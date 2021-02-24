/*
 * Copyright 2021. Team oktop all rights reserved.
 */

package egovframework.cccdms.cprcss.service.impl;

import egovframework.cccdms.cprcss.domain.SearchVo;
import egovframework.cccdms.cprcss.service.CplanYrService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    /**
    * @name    : search : 연간보육계획안 검색 리스트
    * @return  : ArrayList
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-02-24     ||created
    **/
    @Override
    public List<?> search(SearchVo searchVo) throws Exception {
        return null;
    }
}
