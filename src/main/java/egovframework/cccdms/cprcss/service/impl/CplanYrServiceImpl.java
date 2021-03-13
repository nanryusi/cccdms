/*
 * Copyright 2021. Team oktop all rights reserved.
 */

package egovframework.cccdms.cprcss.service.impl;

import egovframework.cccdms.cprcss.dao.CplanYrDAO;
import egovframework.cccdms.cprcss.domain.CplanYrListVo;
import egovframework.cccdms.cprcss.domain.CplanYrVo;
import egovframework.cccdms.cprcss.service.CplanYrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * CplanYrServiceImpl : 연간보육계획안 서비스 구현
 * Created by ryusi   on 2021-02-24.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
@Service
@Transactional
public class CplanYrServiceImpl implements CplanYrService {

    @Autowired
    private CplanYrDAO cplanYrDAO;

    /**
    * @name    : search : 연간보육계획안 검색 리스트
    * @return  : List
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-02-24     ||created
    **/
    @Override
    public List<?> search(CplanYrListVo searchVo) throws Exception {
        return null;
    }

    /**
    * @name    : codeList : 공통코드 리스트
    * @return  : List
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-02-28     ||created
    **/
    @Override
    public List<?> codeList(HashMap map) throws Exception {
        return cplanYrDAO.selectCodeList(map);
    }

    /**
    * @name    : cntExist : 연간 보육 계획안 유무 체크
    * @return  : int
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-03-06     ||created
    **/
    @Override
    public int cntExist(CplanYrVo vo) throws Exception {
        return cplanYrDAO.selectCplanYrCnt(vo);
    }

    /**
    * @name    : addCplanYr
    * @return  :
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-03-07     ||created
    **/
    @Override
    public void addCplanYr(CplanYrVo vo) throws Exception {
        cplanYrDAO.insertCplanYr(vo);
    }
}
