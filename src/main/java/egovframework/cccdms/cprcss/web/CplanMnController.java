package egovframework.cccdms.cprcss.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import egovframework.cccdms.common.service.CccdmsCommonService;
import egovframework.cccdms.cprcss.domain.CplanMnListVo;
import egovframework.cccdms.cprcss.domain.CplanMnVo;
import egovframework.cccdms.cprcss.domain.CplanYrVo;
import egovframework.cccdms.cprcss.service.CplanMnService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * CplanMnController : 월간보육계획안 컨트롤러
 * Created by ryusi   on 2021-03-14.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
@Controller
@RequestMapping("/cccdms/cprcss/cplanMn")
public class CplanMnController {
    //Log
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //Service
    @Autowired
    private CccdmsCommonService commonService;
    @Autowired
    private CplanMnService cplanMnService;


    /**
     * @return : ModelMap, String
     * @name : List : 연간보육계획안 리스트
     * @history :||user      ||date          ||modified comments
     * ||ryusi    ||2021-03-09     ||created
     **/
    @RequestMapping(value = "mainPage.do")
    public String mainPage(@ModelAttribute("searchVO") CplanMnListVo sVo,
                           HttpServletRequest request,
                           ModelMap model) throws Exception {

        //페이징 기본 처리 start
        PaginationInfo paginationInfo = new PaginationInfo();

        paginationInfo.setCurrentPageNo(sVo.getPageIndex());
        paginationInfo.setRecordCountPerPage(sVo.getPageUnit());
        paginationInfo.setPageSize(sVo.getPageSize());

        sVo.setFirstIndex(paginationInfo.getFirstRecordIndex());
        sVo.setLastIndex(paginationInfo.getLastRecordIndex());
        sVo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
        //페이징 기본 처리 end

        //세션값 호출 & 설정
        HttpSession session = request.getSession();
        //String loginId = (String)session.getAttribute("LoginId");
        String loginSchCd = (String)session.getAttribute("LoginSchlCd");
        sVo.setSearchSchlCode(loginSchCd);


        int totCnt = commonService.selectCnt(sVo, "cplanMn");
        List<CplanMnListVo> resultList = (List<CplanMnListVo>) commonService.selectList(sVo, "cplanMn");

        paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        model.addAttribute("resultList", resultList);
        model.addAttribute("resultCnt", totCnt);

        return "cprcss/cPlanMnMain";
    }

    /**
    * @name    : form : 등록폼 호출 : 월간보육계획안
    * @return  : java.lang.String
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-03-15     ||created
    **/
    @RequestMapping("{pathVariable}Form.do")
    public String form(@PathVariable String pathVariable,
                       @ModelAttribute("searchVO") CplanMnVo mnVo,
                       HttpServletRequest request, ModelMap model) throws Exception {

        HashMap<String, String> sessionMap = new HashMap();
        HttpSession session = request.getSession();
        sessionMap.put("SESSION_LOGIN_ID", session.getAttribute("LoginId").toString());
        sessionMap.put("SESSION_LOGIN_SCHOOL_CD", session.getAttribute("LoginSchlCd").toString());



        if("insert".equals(pathVariable)) {
            mnVo.setPathVariable(pathVariable);
            
            //분반코드
            List<HashMap<String, String>> codeList_class = cplanMnService.codeList(sessionMap, "code_class");
            
            model.addAttribute("CodeListClass", codeList_class);
            model.addAttribute("CplanMnVo", mnVo);
        } else if("update".equals(pathVariable)) {
            //todo 수정로직
        }

        return "cprcss/cPlanMnForm";
    }

    /**
     * @return : HashMap
     * @name : add_ajax : 월간보육계획안 저장
     * @history :||user      ||date          ||modified comments
     *           ||ryusi     ||2021-03-18     ||created
     **/
    @ResponseBody
    @RequestMapping("add_ajax.do")
    public HashMap add_ajax(@RequestBody String jsonStr, HttpServletRequest request) throws Exception {
        HashMap reMap = new HashMap();
        String reTxt = "";

        logger.debug("add_ajax 컨트롤러 시작");
        logger.debug("str 내용 : " + jsonStr);

        ObjectMapper oMapper = new ObjectMapper();
        CplanMnVo sVo = oMapper.readValue(jsonStr, CplanMnVo.class);

        //세션에서 id, schoolcd 가져오기
        HttpSession session = request.getSession();
        sVo.setId(session.getAttribute("LoginId").toString());
        sVo.setSchoolCode(session.getAttribute("LoginSchlCd").toString());

        String pathVariable = sVo.getPathVariable();

        if(pathVariable.equals("add")){
            int cnt = cplanMnService.cntExist(sVo);
            if (cnt == 0) {
                commonService.delete(sVo, "cplanMn");
                commonService.insert(sVo, "cplanMn");
                reTxt = "Success";
            } else {
                reTxt = "이미 등록된 문서입니다.";
            }
        }else if(pathVariable.equals("mod")){
            commonService.update(sVo, "cplanMn");
            reTxt = "Success";
        }


        reMap.put("result", reTxt);
        return reMap;
    }
}
