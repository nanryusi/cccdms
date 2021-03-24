package egovframework.cccdms.cprcss.service.impl;

import egovframework.cccdms.cprcss.dao.CplanWkDAO;
import egovframework.cccdms.cprcss.domain.CplanWkDtlVo;
import egovframework.cccdms.cprcss.domain.CplanWkVo;
import egovframework.cccdms.cprcss.service.CplanWkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * CplanMnServiceImpl : 주간보육계획안 서비스 구현
 * Created by ryusi   on 2021-03-23.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
@Service
@Transactional
public class CplanWkServiceImpl implements CplanWkService {

    @Autowired
    private CplanWkDAO cplanWkDAO;

    /**
    * @name    : codeList : 코드 리스트
    * @return  : List<HashMap<String, String>>
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-03-23     ||created
    **/
    @Override
    public List<HashMap<String, String>> codeList(HashMap map, String codeNm) throws Exception {
        return cplanWkDAO.selectCodeList(map,codeNm);
    }

    /**
     * @name    : cntExist : 주간보육계획안 존재확인
     * @return  : int
     * @history :||user      ||date          ||modified comments
     *           ||ryusi    ||2021-03-23     ||created
     **/
    @Override
    public int cntExist(CplanWkVo vo) throws Exception {
        return cplanWkDAO.selectCplanWkExistCnt(vo);
    }

    /**
     * @name    : unUsed : 주간보육계획안 사용여부 N
     * @return  :
     * @history :||user      ||date          ||modified comments
     *           ||ryusi    ||2021-03-23     ||created
     **/
    @Override
    public void unUsed(CplanWkDtlVo vo) throws Exception {
        cplanWkDAO.updateUseYnN(vo);
    }
}
