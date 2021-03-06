/*
 * Copyright 2021. Team oktop all rights reserved.
 */

package egovframework.cccdms.cprcss.dao;

import egovframework.cccdms.cprcss.domain.CplanYrListVo;
import egovframework.cccdms.cprcss.domain.CplanYrVo;
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
    public List<?> search(CplanYrListVo searchVo) throws Exception{
        return listWithPaging("", searchVo, 1, 10);
    }

    /**
    * @name    : codeList : 공통 코드 리스트 호출
    * @return  : List
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-02-28     ||created
    **/
    public List<?> selectCodeList(HashMap map) throws Exception{
        return list("CplanYrDAO.selectCodeList", map);
    }

    /**
    * @name    : selectCplanYrCnt : 연간 보육 계획안 유무 체크
    * @return  : int
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-03-06     ||created
    **/
    public int selectCplanYrCnt(CplanYrVo vo) throws Exception{
        return (int)select("CplanYrDAO.selectCplanYrCnt", vo);
    }

    /**
    * @name    : insertCplanYr : 연간 보육 계획안 입력
    * @return  :
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-03-07     ||created
    **/
    public void insertCplanYr(CplanYrVo vo) throws Exception{
        insert("CplanYrDAO.insertCplanYr", vo);
    }
}
