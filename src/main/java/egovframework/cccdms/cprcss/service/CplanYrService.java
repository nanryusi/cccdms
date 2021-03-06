/*
 * Copyright 2021. Team oktop all rights reserved.
 */

package egovframework.cccdms.cprcss.service;

import egovframework.cccdms.cprcss.domain.CplanYrVo;
import egovframework.cccdms.cprcss.domain.SearchVo;

import java.util.HashMap;
import java.util.List;

/**
 * CplanYrService : 연간보육계획안 서비스
 * Created by ryusi   on 2021-02-24.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
public interface CplanYrService {

    /**
    * @name    : search : 연간보육계획안 검색 리스트
    * @return  : List
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-02-24     ||created
    **/
    List<?> search(SearchVo searchVo) throws Exception;
    
    /**
    * @name    : codeList : 공통 코드 리스트
    * @return  : List
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-02-28     ||created
    **/
    List<?> codeList(HashMap map) throws Exception;

    /**
    * @name    : cntExist : 연간 보육 계획안 유무 체크
    * @return  : int
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-03-06     ||created
    **/
    int cntExist(CplanYrVo vo) throws Exception;
}
