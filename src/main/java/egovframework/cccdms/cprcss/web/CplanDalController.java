package egovframework.cccdms.cprcss.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import egovframework.cccdms.common.service.CommonService;
import egovframework.cccdms.cprcss.domain.CplanDalDtlVo;
import egovframework.cccdms.cprcss.domain.CplanDalListVo;
import egovframework.cccdms.cprcss.domain.CplanDalVo;
import egovframework.cccdms.cprcss.service.CplanDalService;
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
 * CplanDalController : 보육일지 컨트롤러
 * Created by ryusi   on 2021-04-11.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
@Controller
@RequestMapping("/cccdms/cprcss/cplanDal")
public class CplanDalController {
    //Log
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String PROGRAM_ID = "cplanDal";

    //Service
    @Autowired
    private CommonService commonService;
    @Autowired
    private CplanDalService cplanDalService;


    /**
     * @return : ModelMap, String
     * @name : List : 주간보육계획안 리스트
     * @history :||user      ||date          ||modified comments
     *           ||ryusi    ||2021-04-11     ||created
     **/
    @RequestMapping(value = "mainPage.do")
    public String mainPage(@ModelAttribute("searchVO") CplanDalListVo sVo,
                           HttpServletRequest request,
                           ModelMap model) throws Exception {
        logger.debug("mainPage Start!!!");

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

        logger.debug("selectCnt Start!");
        int totCnt = commonService.selectCnt(sVo, PROGRAM_ID);
        logger.debug("totCnt : "+totCnt);
        List<CplanDalListVo> resultList = (List<CplanDalListVo>) commonService.selectList(sVo, PROGRAM_ID);

        paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        model.addAttribute("resultList", resultList);
        model.addAttribute("resultCnt", totCnt);

        return "cprcss/cPlanDalMain";
    }

    /**
    * @name    : form : 등록폼 호출 : 주간보육계획안
    * @return  : java.lang.String
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-04-11     ||created
    **/
    @RequestMapping("{pathVariable}Form.do")
    public String form(@PathVariable String pathVariable,
                       @ModelAttribute("CplanDalDtlVo") CplanDalDtlVo cplanDalDtlVo,
                       HttpServletRequest request, ModelMap model) throws Exception {

        HashMap<String, String> sessionMap = new HashMap();
        HttpSession session = request.getSession();
        sessionMap.put("SESSION_LOGIN_ID", session.getAttribute("LoginId").toString());
        sessionMap.put("SESSION_LOGIN_SCHOOL_CD", session.getAttribute("LoginSchlCd").toString());

        CplanDalVo sVo = new CplanDalVo();

        if("insert".equals(pathVariable)) {
            sVo.setPathVariable(pathVariable);
            model.addAttribute("CplanDalVo", sVo);
        } else if("update".equals(pathVariable)) {
            //뷰화면에서 넘어오는 거라 데이터 그대로 가져다주면 됨.
            model.addAttribute("CplanDalVo", cplanDalDtlVo);
        }

        //분반코드
        List<HashMap<String, String>> codeList_class = cplanDalService.codeList(sessionMap, "code_class");
        model.addAttribute("CodeListClass", codeList_class);

        return "cprcss/cPlanDalForm";
    }

    /**
     * @return : HashMap
     * @name : add_ajax : 주간보육계획안 저장
     * @history :||user      ||date          ||modified comments
     *           ||ryusi     ||2021-04-11     ||created
     **/
    @ResponseBody
    @RequestMapping("add_ajax.do")
    public HashMap add_ajax(@RequestBody String jsonStr, HttpServletRequest request) throws Exception {

        logger.debug("add_ajax Start!");

        HashMap reMap = new HashMap();
        String reTxt = "";

        ObjectMapper oMapper = new ObjectMapper();
        CplanDalVo sVo = oMapper.readValue(jsonStr, CplanDalVo.class);

        //세션에서 id, schoolcd 가져오기
        HttpSession session = request.getSession();
        sVo.setId(session.getAttribute("LoginId").toString());
        sVo.setSchoolCode(session.getAttribute("LoginSchlCd").toString());

        String pathVariable = sVo.getPathVariable();

        if(pathVariable.equals("add")){
            int cnt = cplanDalService.cntExist(sVo);
            if (cnt == 0) { //데이터 삭제 후 입력
                commonService.delete(sVo, PROGRAM_ID);
                commonService.insert(sVo, PROGRAM_ID);
                reTxt = "Success";
            } else {
                reTxt = "해당기간 내에 등록된 문서가 있습니다.";
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
    *           ||ryusi    ||2021-04-11     ||created
    **/
    @RequestMapping("view.do")
    public String view(@ModelAttribute("searchVO") CplanDalListVo cplanDalListVo,
                       HttpServletRequest request, ModelMap model) throws Exception {

        //세션에서 id, schoolcd 가져오기
        HashMap<String, String> sessionMap = new HashMap();
        HttpSession session = request.getSession();
        cplanDalListVo.setSchoolCode(session.getAttribute("LoginSchlCd").toString());
        sessionMap.put("SESSION_LOGIN_ID", session.getAttribute("LoginId").toString());
        sessionMap.put("SESSION_LOGIN_SCHOOL_CD", session.getAttribute("LoginSchlCd").toString());

        //분반코드
        List<HashMap<String, String>> codeList_class = cplanDalService.codeList(sessionMap, "code_class");
        //상세조회
        CplanDalDtlVo vo = (CplanDalDtlVo) commonService.selectDetail(cplanDalListVo, PROGRAM_ID);

        model.addAttribute("CodeListClass", codeList_class);
        model.addAttribute("CplanDalDtlVo", vo);

        return "cprcss/cPlanDalView";
    }

    /**
    * @name    : delete :주간보육계획안 미사용처리
    * @return  : String
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-04-11     ||created
    **/
    @RequestMapping("delete.do")
    public String delete(@ModelAttribute("CplanDalDtlVo") CplanDalDtlVo cplanDalDtlVo,
                         SessionStatus status,
                         HttpServletRequest request, ModelMap model) throws Exception {

        //세션에서 id, schoolcd 가져오기
        HttpSession session = request.getSession();
        cplanDalDtlVo.setId(session.getAttribute("LoginId").toString());
        cplanDalDtlVo.setSchoolCode(session.getAttribute("LoginSchlCd").toString());

        cplanDalService.unUsed(cplanDalDtlVo);

        status.setComplete();

        return "redirect:/cccdms/cprcss/cplanDal/mainPage.do";
    }
}
