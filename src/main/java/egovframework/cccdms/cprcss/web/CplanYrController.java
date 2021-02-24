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

}
