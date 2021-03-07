/*
 * Copyright 2021. Team oktop all rights reserved.
 */

package egovframework.cccdms.cprcss.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import egovframework.cccdms.cprcss.domain.CplanYrVo;
import egovframework.cccdms.cprcss.domain.ListVo;
import egovframework.cccdms.cprcss.domain.SearchVo;
import egovframework.cccdms.cprcss.service.CplanYrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    
    /**
    * @name    : getCplanYrMainPage : 연간보육계획안 메인화면
    * @return  : java.lang.String
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-02-20    ||created
    **/
    @RequestMapping(value = "mainPage.do")
    public String getCplanYrMainPage(HttpServletRequest request, ModelMap model)
            throws Exception{

        //로그 테스트
        logger.debug("디버그");
        logger.info("인포");
        logger.warn("경고");

        return "cprcss/cPlanYrMain";
    }

    /**
    * @name    : search : 연간보육계획안 리스트
    * @return  : List<ListVo>
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-02-23    ||created
    **/
    @ResponseBody
    @RequestMapping("search.do")
    public List<ListVo> search(@RequestBody String jsonStr) throws Exception{

        List<ListVo> rList = null;
        //json 데이터 매핑
        ObjectMapper oMapper = new ObjectMapper();
        SearchVo sVo = oMapper.readValue(jsonStr, SearchVo.class);

        logger.debug("sVo.searchText : "+sVo.getSearch_text1());
        return rList;
    }

    /**
    * @name    : getAddPage : 연간보육계획 생성 페이지
    * @return  : String, ModelMap
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-02-27     ||created
    **/
    @RequestMapping("addPage.do")
    public String getAddPage(HttpServletRequest request, ModelMap model) throws Exception{
        logger.debug("신규 생성 페이지 컨트롤러 시작");

        //todo 세션에서 user 정보를 가져온다. id, 이름, 어린이집 id, 어린이집 이름
        //테스트용
        HashMap<String,String> inMap = new HashMap();
        String id = "teacher001";
        String school_cd = "100000";
        String schl_nm = "테스트 어린이집";
        inMap.put("id", "teacher001");
        inMap.put("school_cd", "100000");

        List<HashMap<String, String>> resList = (List<HashMap<String, String>>)cplanYrService.codeList(inMap);

        //json 형변환
        String comm_cl = new ObjectMapper().writeValueAsString(resList);

        //모델에 담기
        model.addAttribute("comm_cl", comm_cl);
        logger.debug("신규 생성 페이지 컨트롤러 끝");
        return "cprcss/cPlanYrAdd";
    }

    /**
    * @name    : add_ajax : 연간보육계획안 저장
    * @return  : HashMap
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-03-05     ||created
    **/
    @ResponseBody
    @RequestMapping("add_ajax.do")
    public HashMap add_ajax(@RequestBody String jsonStr) throws Exception{
        HashMap reMap = new HashMap();
        String reTxt = "";

        logger.debug("add_ajax 컨트롤러 시작");
        logger.debug("str 내용 : "+ jsonStr);
        
        ObjectMapper oMapper = new ObjectMapper();
        CplanYrVo sVo = oMapper.readValue(jsonStr, CplanYrVo.class);

        //todo 세션에서 id, schoolcd 가져오기
        sVo.setId("teacher001");
        sVo.setSchool_code("100000");

        int cnt = cplanYrService.cntExist(sVo);
        if(cnt==0){
            cplanYrService.addCplanYr(sVo);
            reTxt = "Success";
        }else{
            reTxt = "이미 등록된 문서입니다.";
        }

        reMap.put("result", reTxt);
        return reMap;
    }

}
