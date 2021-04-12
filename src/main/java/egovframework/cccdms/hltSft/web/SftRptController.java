/*
 * Copyright 2021. Team oktop all rights reserved.
 */

package egovframework.cccdms.hltSft.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import egovframework.cccdms.common.model.FileVO;
import egovframework.cccdms.common.service.CommonService;
import egovframework.cccdms.common.service.FileMngService;
import egovframework.cccdms.common.util.FileMngUtil;
import egovframework.cccdms.hltSft.domain.SftRptListVo;
import egovframework.cccdms.hltSft.domain.SftRptVo;
import egovframework.cccdms.hltSft.service.SftRptService;
import egovframework.cccdms.sample.model.CccdmsSampleVO;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CplanYrController : 안전교육일지 컨트롤러
 * Created by denicola4   on 2021-04-03.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
@Controller
@RequestMapping("/cccdms/hltSft/sftRpt")
public class SftRptController {
    //Log
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String PROGRAM_ID = "sftRpt";

    //Service
    @Autowired
    private CommonService commonService;
    @Autowired
    private SftRptService sftRptService;


    /**
     * @return : ModelMap, String
     * @name : List : 영유아 안전교육일지 리스트
     * @history :||user         ||date           ||modified comments
     *           ||denicola4    ||2021-04-12     ||created
     **/
    @RequestMapping(value = "mainPage.do")
    public String mainPage(@ModelAttribute("searchVO") SftRptListVo sVo,
                           HttpServletRequest request,
                           ModelMap model) throws Exception {
        logger.debug("영유아 안전교육일지 mainPage Start!!!");

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

        logger.debug("영유아 안전교육일지 selectCnt Start!");
        int totCnt = commonService.selectCnt(sVo, PROGRAM_ID);
        logger.debug("totCnt : "+totCnt);
        logger.debug(" 토탈 카운트 end!");
        List<SftRptListVo> resultList = (List<SftRptListVo>) commonService.selectList(sVo, PROGRAM_ID);
        logger.debug(" 리스트조회 end!");
        paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        model.addAttribute("resultList", resultList);
        model.addAttribute("resultCnt", totCnt);
        logger.debug("영유아 안전교육일지 selectCnt End!");
        return "hltSft/sftRptMain";
    }

}
