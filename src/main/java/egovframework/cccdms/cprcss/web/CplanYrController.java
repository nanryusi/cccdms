/*
 * Copyright 2021. Team oktop all rights reserved.
 */

package egovframework.cccdms.cprcss.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import egovframework.cccdms.cprcss.domain.ListVo;
import egovframework.cccdms.cprcss.domain.SearchVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/cccdms/cprcss")
public class CplanYrController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /**
    * @name    : getCplanYrPage : 연간보육계획안 메인화면
    * @return  : java.lang.String
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-02-20    ||created
    **/
    @RequestMapping(value = "cPlanYrPage.do")
    public String getCplanYrPage(HttpServletRequest request, ModelMap model)
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
    * @return  : String
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-02-27     ||created
    **/
    @RequestMapping("addPage.do")
    public String getAddPage(HttpServletRequest request, ModelMap model) throws Exception{
        logger.debug("신규 생성 페이지 컨트롤러 시작");

        //todo 세션에서 user 정보를 가져온다. id, 이름, 어린이집 id, 어린이집 이름
        //테스트용
        String id = "teacher001";
        String schl_cd = "100000";
        String schl_nm = "테스트 어린이집";

        //todo 공통 코드를 가져온다.
        //테스트용
        List<HashMap<String, String>> rList = new ArrayList<>();
        HashMap<String, String> hMap = new HashMap<>();
        HashMap<String, String> hMap2 = new HashMap<>();

        //공통코드 : 교사가 가지고 있는 분반명을 가져온다.
        //분반 코드
        hMap.put("cl_cd", "1");
        //분반 명
        hMap.put("cl_nm", "햇님반");
        //해당 분반의 권한
        hMap.put("div_cd", "TEA00001");
        //해당 분반의 권한명
        hMap.put("div_nm", "담임");

        rList.add(hMap);

        //공통코드 : 교사가 가지고 있는 분반명을 가져온다.
        //분반 코드
        hMap2.put("cl_cd", "2");
        //분반 명
        hMap2.put("cl_nm", "달님반");
        //해당 분반의 권한
        hMap2.put("div_cd", "TEA00001");
        //해당 분반의 권한명
        hMap2.put("div_nm", "담임");

        rList.add(hMap2);

        //json 형변환
        String comm_cl = new ObjectMapper().writeValueAsString(rList);
        model.addAttribute("comm_cl", comm_cl);
        logger.debug("신규 생성 페이지 컨트롤러 끝");
        return "cprcss/cPlanAdd";
    }

}
