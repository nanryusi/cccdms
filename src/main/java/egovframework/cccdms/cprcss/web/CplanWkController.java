package egovframework.cccdms.cprcss.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import egovframework.cccdms.common.service.CccdmsCommonService;
import egovframework.cccdms.cprcss.domain.CplanWkDtlVo;
import egovframework.cccdms.cprcss.domain.CplanWkListVo;
import egovframework.cccdms.cprcss.domain.CplanWkVo;
import egovframework.cccdms.cprcss.service.CplanWkService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * CplanWkController : 주간보육계획안 컨트롤러
 * Created by ryusi   on 2021-03-23.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
@Controller
@RequestMapping("/cccdms/cprcss/cplaWk")
public class CplanWkController {
    //Log
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String PROGRAM_ID = "cplanWk";

    //Service
    @Autowired
    private CccdmsCommonService commonService;
    @Autowired
    private CplanWkService cplanWkService;


    /**
     * @return : ModelMap, String
     * @name : List : 주간보육계획안 리스트
     * @history :||user      ||date          ||modified comments
     *           ||ryusi    ||2021-03-23     ||created
     **/
    @RequestMapping(value = "mainPage.do")
    public String mainPage(@ModelAttribute("searchVO") CplanWkListVo sVo,
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
        sVo.setSchoolCode(loginSchCd);


        int totCnt = commonService.selectCnt(sVo, PROGRAM_ID);
        List<CplanWkListVo> resultList = (List<CplanWkListVo>) commonService.selectList(sVo, PROGRAM_ID);

        paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        model.addAttribute("resultList", resultList);
        model.addAttribute("resultCnt", totCnt);

        return "cprcss/cPlanWkMain";
    }

    /**
    * @name    : form : 등록폼 호출 : 주간보육계획안
    * @return  : java.lang.String
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-03-23     ||created
    **/
    @RequestMapping("{pathVariable}Form.do")
    public String form(@PathVariable String pathVariable,
                       @ModelAttribute("CplanWkDtlVo") CplanWkDtlVo cplanWkDtlVo,
                       HttpServletRequest request, ModelMap model) throws Exception {

        HashMap<String, String> sessionMap = new HashMap();
        HttpSession session = request.getSession();
        sessionMap.put("SESSION_LOGIN_ID", session.getAttribute("LoginId").toString());
        sessionMap.put("SESSION_LOGIN_SCHOOL_CD", session.getAttribute("LoginSchlCd").toString());

        CplanWkVo sVo = new CplanWkVo();

        if("insert".equals(pathVariable)) {
            sVo.setPathVariable(pathVariable);
            model.addAttribute("CplanWkVo", sVo);
        } else if("update".equals(pathVariable)) {
            //뷰화면에서 넘어오는 거라 데이터 그대로 가져다주면 됨.
            model.addAttribute("CplanWkVo", cplanWkDtlVo);
        }

        //분반코드
        List<HashMap<String, String>> codeList_class = cplanWkService.codeList(sessionMap, "code_class");
        model.addAttribute("CodeListClass", codeList_class);

        return "cprcss/cPlanWkForm";
    }

    /**
     * @return : HashMap
     * @name : add_ajax : 주간보육계획안 저장
     * @history :||user      ||date          ||modified comments
     *           ||ryusi     ||2021-03-23     ||created
     **/
    @ResponseBody
    @RequestMapping("add_ajax.do")
    public HashMap add_ajax(@RequestBody String jsonStr, HttpServletRequest request) throws Exception {
        HashMap reMap = new HashMap();
        String reTxt = "";

        ObjectMapper oMapper = new ObjectMapper();
        CplanWkVo sVo = oMapper.readValue(jsonStr, CplanWkVo.class);

        //세션에서 id, schoolcd 가져오기
        HttpSession session = request.getSession();
        sVo.setId(session.getAttribute("LoginId").toString());
        sVo.setSchoolCode(session.getAttribute("LoginSchlCd").toString());

        String pathVariable = sVo.getPathVariable();

        if(pathVariable.equals("add")){
            int cnt = cplanWkService.cntExist(sVo);
            if (cnt == 0) { //데이터 삭제 후 입력
                commonService.delete(sVo, PROGRAM_ID);
                commonService.insert(sVo, PROGRAM_ID);
                reTxt = "Success";
            } else {
                reTxt = "이미 등록된 문서입니다.";
            }
        }else if(pathVariable.equals("mod")){

            //todo 권한체크
            commonService.update(sVo, PROGRAM_ID);
            reTxt = "Success";
        }


        reMap.put("result", reTxt);
        return reMap;
    }



    /**
    * @name    : view : 주간보육계획안 상세내역
    * @return  : java.lang.String
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-03-23     ||created
    **/
    @RequestMapping("view.do")
    public String view(@ModelAttribute("searchVO") CplanWkListVo cplanWkListVo,
                       HttpServletRequest request, ModelMap model) throws Exception {

        //세션에서 id, schoolcd 가져오기
        HashMap<String, String> sessionMap = new HashMap();
        HttpSession session = request.getSession();
        cplanWkListVo.setSchoolCode(session.getAttribute("LoginSchlCd").toString());
        sessionMap.put("SESSION_LOGIN_ID", session.getAttribute("LoginId").toString());
        sessionMap.put("SESSION_LOGIN_SCHOOL_CD", session.getAttribute("LoginSchlCd").toString());

        //분반코드
        List<HashMap<String, String>> codeList_class = cplanWkService.codeList(sessionMap, "code_class");
        //상세조회
        CplanWkDtlVo vo = (CplanWkDtlVo) commonService.selectDetail(cplanWkListVo, PROGRAM_ID);

        model.addAttribute("CodeListClass", codeList_class);
        model.addAttribute("CplanWkDtlVo", vo);

        return "cprcss/cPlanWkView";
    }

    /**
    * @name    : delete :주간보육계획안 미사용처리
    * @return  : String
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-03-23     ||created
    **/
    @RequestMapping("delete.do")
    public String delete(@ModelAttribute("CplanWkDtlVo") CplanWkDtlVo cplanWkDtlVo,
                         SessionStatus status,
                         HttpServletRequest request, ModelMap model) throws Exception {

        //세션에서 id, schoolcd 가져오기
        HttpSession session = request.getSession();
        cplanWkDtlVo.setId(session.getAttribute("LoginId").toString());
        cplanWkDtlVo.setSchoolCode(session.getAttribute("LoginSchlCd").toString());

        cplanWkService.unUsed(cplanWkDtlVo);

        status.setComplete();

        return "redirect:/cccdms/cprcss/cplanWk/mainPage.do";
    }
}
