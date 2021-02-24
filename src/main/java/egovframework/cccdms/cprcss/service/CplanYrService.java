/*
 * Copyright 2021. Team oktop all rights reserved.
 */

package egovframework.cccdms.cprcss.service;

import egovframework.cccdms.cprcss.domain.SearchVo;

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

}
