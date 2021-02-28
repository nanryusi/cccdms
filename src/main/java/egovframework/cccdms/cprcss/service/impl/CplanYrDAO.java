/*
 * Copyright 2021. Team oktop all rights reserved.
 */

package egovframework.cccdms.cprcss.service.impl;

import egovframework.cccdms.cprcss.domain.SearchVo;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * CplanYrDao : 연간보육계획안 DAO
 * Created by ryusi   on 2021-02-24.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
@Repository
public class CplanYrDAO extends EgovAbstractDAO {

    /**
    * @name    : search : 연간보육계획안 구현 검색 리스트
    * @return  : List
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-02-24     ||created
    **/
    public List<?> search(SearchVo searchVo) throws Exception{
        return listWithPaging("", searchVo, 1, 10);
    }

    /**
    * @name    : codeList : 공통 코드 리스트 호출
    * @return  : List
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-02-28     ||created
    **/
    public List<?> codeList(HashMap map) throws Exception{
        return list("", map, 1, 10);
    }
}