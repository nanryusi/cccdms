/*
 * Copyright 2021. Team oktop all rights reserved.
 */

package egovframework.cccdms.hltSft.service.impl;

import egovframework.cccdms.hltSft.dao.SftRptDAO;
import egovframework.cccdms.hltSft.domain.SftRptListVo;
import egovframework.cccdms.hltSft.domain.SftRptVo;
import egovframework.cccdms.hltSft.service.SftRptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * CplanYrServiceImpl : 차량안전점검표 서비스 구현
 * Created by denicola4   on 2021-04-03.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
@Service
@Transactional
public class SftRptServiceImpl implements SftRptService {

    @Autowired
    private SftRptDAO sftRptDAO;

    /**
    * @name    : search : 차량안전점검표 검색 리스트
    * @return  : List
    * @history :||user         ||date          ||modified comments
    *           ||denicola4    ||2021-04-03     ||created
    **/
    @Override
    public List<?> search(SftRptListVo searchVo) throws Exception {
        return null;
    }

    /**
    * @name    : codeList : 공통코드 리스트
    * @return  : List
    * @history :||user         ||date          ||modified comments
    *           ||denicola4    ||2021-04-03     ||created
    **/
    @Override
    public List<?> codeList(HashMap map) throws Exception {
        return sftRptDAO.selectCodeList(map);
    }

    /**
    * @name    : cntExist : 차량안전점검표 유무 체크
    * @return  : int
    * @history :||user         ||date          ||modified comments
    *           ||denicola4    ||2021-03-06     ||created
    **/
	/*
	 * @Override public int cntExist(SftRptVo vo) throws Exception { return
	 * sftRptDAO.selectCplanYrCnt(vo); }
	 */

    /**
    * @name    : addCplanYr
    * @return  :
    * @history :||user         ||date          ||modified comments
    *           ||denicola4    ||2021-03-07     ||created
    **/
	/*
	 * @Override public void addCplanYr(SftRptVo vo) throws Exception {
	 * sftRptDAO.insertCplanYr(vo); }
	 */
}
