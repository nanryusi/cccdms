package egovframework.cccdms.cprcss.service.impl;

import egovframework.cccdms.cprcss.dao.CplanMnDAO;
import egovframework.cccdms.cprcss.domain.CplanMnDtlVo;
import egovframework.cccdms.cprcss.domain.CplanMnVo;
import egovframework.cccdms.cprcss.service.CplanMnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * CplanMnServiceImpl : 월간보육계획안 서비스 구현
 * Created by ryusi   on 2021-03-18.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
@Service
@Transactional
public class CplanMnServiceImpl implements CplanMnService {

    @Autowired
    private CplanMnDAO cplanMnDAO;

    /**
    * @name    : codeList : 코드 리스트
    * @return  : List<HashMap<String, String>>
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-03-18     ||created
    **/
    @Override
    public List<HashMap<String, String>> codeList(HashMap map, String codeNm) throws Exception {
        return cplanMnDAO.selectCodeList(map,codeNm);
    }

    /**
     * @name    : cntExist : 월간보육계획안 존재확인
     * @return  : int
     * @history :||user      ||date          ||modified comments
     *           ||ryusi    ||2021-03-18     ||created
     **/
    @Override
    public int cntExist(CplanMnVo vo) throws Exception {
        return cplanMnDAO.selectCplanMnExistCnt(vo);
    }

    /**
     * @name    : unUsed : 월간보육계획안 사용여부 N
     * @return  :
     * @history :||user      ||date          ||modified comments
     *           ||ryusi    ||2021-03-18     ||created
     **/
    @Override
    public void unUsed(CplanMnDtlVo vo) throws Exception {
        cplanMnDAO.updateUseYnN(vo);
    }
}
