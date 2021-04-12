/*
 * Copyright 2021. Team oktop all rights reserved.
 */

package egovframework.cccdms.hltSft.dao;

import egovframework.cccdms.hltSft.domain.SftRptListVo;
import egovframework.cccdms.hltSft.domain.SftRptVo;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * CplanYrDao : 차량안전점검표 DAO
 * Created by denicola4   on 2021-04-03.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
@Repository
public class SftRptDAO extends EgovAbstractDAO {

    /**
    * @name    : search : 차량안전점검표 구현 검색 리스트
    * @return  : List
    * @history :||user         ||date          ||modified comments
    *           ||denicola4    ||021-04-03     ||created
    **/
    public List<?> search(SftRptListVo searchVo) throws Exception{
        return listWithPaging("", searchVo, 1, 10);
    }

    /**
    * @name    : codeList : 공통 코드 리스트 호출
    * @return  : List
    * @history :||user         ||date          ||modified comments
    *           ||denicola4    ||021-04-03     ||created
    **/
    public List<?> selectCodeList(HashMap map) throws Exception{
        return list("SftRptDAO.selectCodeList", map);
    }

    /**
    * @name    : selectCplanYrCnt : 차량안전점검표 유무 체크
    * @return  : int
    * @history :||user         ||date          ||modified comments
    *           ||denicola4    ||021-04-03     ||created
    **/
	/*
	 * public int selectCplanYrCnt(SftRptVo vo) throws Exception{ return
	 * (int)select("SftRptDAO.selectCplanYrCnt", vo); }
	 */

    /**
    * @name    : insertCplanYr : 차량안전점검표 입력
    * @return  :
    * @history :||user         ||date          ||modified comments
    *           ||denicola4    ||021-04-03     ||created
    **/
	/*
	 * public void insertCplanYr(SftRptVo vo) throws Exception{
	 * insert("SftRptDAO.insertCplanYr", vo); }
	 */
}
