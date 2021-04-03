/*
 * Copyright 2021. Team oktop all rights reserved.
 */

package egovframework.cccdms.hltSft.service;

import egovframework.cccdms.hltSft.domain.SftCarListVo;
import egovframework.cccdms.hltSft.domain.SftCarVo;

import java.util.HashMap;
import java.util.List;

/**
 * CplanYrService : 차량안전점검표 서비스
 * Created by denicola4   on 2021-04-03.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
public interface SftCarService {

    /**
    * @name    : search : 차량안전점검표 검색 리스트
    * @return  : List
    * @history :||user         ||date           ||modified comments
    *           ||denicoal4    ||2021-04-03     ||created
    **/
    List<?> search(SftCarListVo searchVo) throws Exception;
    
    /**
    * @name    : codeList : 공통 코드 리스트
    * @return  : List
    * @history :||user         ||date          ||modified comments
    *           ||denicoal4    ||2021-04-03     ||created
    **/
    List<?> codeList(HashMap map) throws Exception;

    /**
    * @name    : cntExist : 차량안전점검표 유무 체크
    * @return  : int
    * @history :||user         ||date           ||modified comments
    *           ||denicoal4    ||2021-04-03     ||created
    **/
	/* int cntExist(CplanYrVo vo) throws Exception; */

    /**
    * @name    : addCplanYr : 차량안전점검표 입력
    * @return  :
    * @history :||user         ||date           ||modified comments
    *           ||denicoal4    ||2021-04-03     ||created
    **/
	/* void addCplanYr(CplanYrVo vo) throws Exception; */
}
