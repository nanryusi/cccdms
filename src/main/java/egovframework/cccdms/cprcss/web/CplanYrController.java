/*
 * Copyright 2021. Team oktop all rights reserved.
 */

package egovframework.cccdms.cprcss.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import egovframework.cccdms.common.service.CccdmsCommonService;
import egovframework.cccdms.cprcss.domain.CplanYrListVo;
import egovframework.cccdms.cprcss.domain.CplanYrVo;
import egovframework.cccdms.cprcss.service.CplanYrService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * CplanYrController : 연간보육계획안 컨트롤러
 * Created by ryusi   on 2021-02-20.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
@Controller
@RequestMapping("/cccdms/cprcss/cplanyr")
public class CplanYrController {
    //로그
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //Service
    @Autowired
    private CplanYrService cplanYrService;
    @Autowired
    private CccdmsCommonService commonService;

    /**
     * @return : java.lang.String
     * @name : getCplanYrMainPage : 연간보육계획안 메인화면
     * @history :||user      ||date          ||modified comments
     * ||ryusi    ||2021-02-20    ||created
     **/
    @RequestMapping(value = "mainxxx.do")
    public String getCplanYrMainPage(HttpServletRequest request, ModelMap model)
            throws Exception {

        //로그 테스트
        logger.debug("디버그");
        logger.info("인포");
        logger.warn("경고");

        return "cprcss/cPlanYrMain";
    }

    /**
     * @return : ModelMap, String
     * @name : List : 연간보육계획안 리스트
     * @history :||user      ||date          ||modified comments
     * ||ryusi    ||2021-03-09     ||created
     **/
    @RequestMapping(value = "mainPage.do")
    public String List(@ModelAttribute("searchVO") CplanYrListVo sVo, ModelMap model) throws Exception {

        PaginationInfo paginationInfo = new PaginationInfo();

        paginationInfo.setCurrentPageNo(sVo.getPageIndex());
        paginationInfo.setRecordCountPerPage(sVo.getPageUnit());
        paginationInfo.setPageSize(sVo.getPageSize());

        sVo.setFirstIndex(paginationInfo.getFirstRecordIndex());
        sVo.setLastIndex(paginationInfo.getLastRecordIndex());
        sVo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

        //테스트용 학교코드, 년도
        sVo.setSearchYr("2021");
        sVo.setSearchSchlCode("100000");

        int totCnt = commonService.selectCnt(sVo, "cplanyr");
        logger.debug("리스트 카운트 :" + totCnt);

        List<CplanYrListVo> resultList = (List<CplanYrListVo>) commonService.selectList(sVo, "cplanyr");

        logger.debug("리스트 내용 카운트:" + resultList.size());
        logger.debug("리스트 내용 1 제목:" + resultList.get(0).getTitle());
        logger.debug("리스트 내용 1 컨텐츠내용:" + resultList.get(0).getContents());

        paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        model.addAttribute("resultList", resultList);
        model.addAttribute("resultCnt", totCnt);

        return "cprcss/cPlanYrMain";
    }

    /**
     * @return : ModelMap, String
     * @name : form : 신규생성, 수정화면
     * @history :||user      ||date          ||modified comments
     * ||ryusi    ||2021-03-09     ||created
     **/
    @RequestMapping("{pathVariable}Form.do")
    public String form(@PathVariable String pathVariable, @ModelAttribute("CplanYrVo") CplanYrVo sVo, ModelMap model) throws Exception {

        if ("insert".equals(pathVariable)) {

            //todo 세션에서 user 정보를 가져온다. id, 이름, 어린이집 id, 어린이집 이름
            HashMap<String, String> inMap = new HashMap();
            inMap.put("id", "teacher001");
            inMap.put("school_cd", "100000");

            List<HashMap<String, String>> resList = (List<HashMap<String, String>>) cplanYrService.codeList(inMap);

            //json 형변환
            String comm_code = new ObjectMapper().writeValueAsString(resList);

            //모델에 담기
            model.addAttribute("comm_code", comm_code);

            sVo.setPathVariable(pathVariable);
            model.addAttribute("CplanYrVo", sVo);
        } else if ("update".equals(pathVariable)) {

            //todo 세션에서 user 정보를 가져온다. id, 이름, 어린이집 id, 어린이집 이름
            HashMap<String, String> inMap = new HashMap();
            inMap.put("id", "teacher001");
            inMap.put("school_cd", "100000");

            List<HashMap<String, String>> resList = (List<HashMap<String, String>>) cplanYrService.codeList(inMap);

            //json 형변환
            String comm_code = new ObjectMapper().writeValueAsString(resList);

            //모델에 담기
            model.addAttribute("comm_code", comm_code);

            CplanYrListVo vo = (CplanYrListVo) commonService.selectDetail(sVo, "cplanyr");// 상세조회
            vo.setPathVariable(pathVariable);
            model.addAttribute("CplanYrVo", vo);
        }

        return "cprcss/cPlanYrForm";
    }

    @RequestMapping("view.do")
    public String view(@ModelAttribute("searchDetailVO") CplanYrListVo sVo, ModelMap model) throws Exception {

        //todo 세션에서 user 정보를 가져온다. id, 이름, 어린이집 id, 어린이집 이름
        HashMap<String, String> inMap = new HashMap();
        inMap.put("id", "teacher001");
        inMap.put("school_cd", "100000");

        logger.debug("seqNo : " + sVo.getSeqNo());

        CplanYrListVo vo = (CplanYrListVo) commonService.selectDetail(sVo, "cplanyr");// 상세조회

        //todo 권한이 없으면 deny 처리
        sVo.setPathVariable("update");
        model.addAttribute("CplanYrVo", vo);

        return "cprcss/cPlanYrForm";
    }


    /**
     * @return : List<ListVo>
     * @name : search : 연간보육계획안 리스트
     * @history :||user      ||date          ||modified comments
     * ||ryusi    ||2021-02-23    ||created
     **/
    @ResponseBody
    @RequestMapping("search.do")
    public List<CplanYrListVo> search(@RequestBody String jsonStr) throws Exception {

        List<CplanYrListVo> rList = null;
        //json 데이터 매핑
        ObjectMapper oMapper = new ObjectMapper();
        CplanYrListVo sVo = oMapper.readValue(jsonStr, CplanYrListVo.class);

        return rList;
    }

    /**
     * @return : String, ModelMap
     * @name : getAddPage : 연간보육계획 생성 페이지
     * @history :||user      ||date          ||modified comments
     * ||ryusi    ||2021-02-27     ||created
     **/
    @RequestMapping("addPage.do")
    public String getAddPage(HttpServletRequest request, ModelMap model) throws Exception {
        logger.debug("신규 생성 페이지 컨트롤러 시작");

        //todo 세션에서 user 정보를 가져온다. id, 이름, 어린이집 id, 어린이집 이름
        //테스트용
        HashMap<String, String> inMap = new HashMap();
        inMap.put("id", "teacher001");
        inMap.put("school_cd", "100000");

        List<HashMap<String, String>> resList = (List<HashMap<String, String>>) cplanYrService.codeList(inMap);

        //json 형변환
        String comm_cl = new ObjectMapper().writeValueAsString(resList);

        //모델에 담기
        model.addAttribute("comm_cl", comm_cl);
        logger.debug("신규 생성 페이지 컨트롤러 끝");
        return "cprcss/cPlanYrAdd";
    }

    /**
     * @return : HashMap
     * @name : add_ajax : 연간보육계획안 저장
     * @history :||user      ||date          ||modified comments
     * ||ryusi    ||2021-03-05     ||created
     **/
    @ResponseBody
    @RequestMapping("add_ajax.do")
    public HashMap add_ajax(@RequestBody String jsonStr) throws Exception {
        HashMap reMap = new HashMap();
        String reTxt = "";

        logger.debug("add_ajax 컨트롤러 시작");
        logger.debug("str 내용 : " + jsonStr);

        ObjectMapper oMapper = new ObjectMapper();
        CplanYrVo sVo = oMapper.readValue(jsonStr, CplanYrVo.class);

        //todo 세션에서 id, schoolcd 가져오기
        sVo.setId("teacher001");
        sVo.setSchool_code("100000");

        int cnt = cplanYrService.cntExist(sVo);
        if (cnt == 0) {
            //cplanYrService.addCplanYr(sVo);
            commonService.insert(sVo, "cplanyr");
            reTxt = "Success";
        } else {
            reTxt = "이미 등록된 문서입니다.";
        }

        reMap.put("result", reTxt);
        return reMap;
    }

}
