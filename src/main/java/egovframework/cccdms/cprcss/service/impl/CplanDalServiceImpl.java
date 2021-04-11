package egovframework.cccdms.cprcss.service.impl;

import egovframework.cccdms.cprcss.dao.CplanDalDAO;
import egovframework.cccdms.cprcss.domain.CplanDalDtlVo;
import egovframework.cccdms.cprcss.domain.CplanDalVo;
import egovframework.cccdms.cprcss.service.CplanDalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * CplanDalServiceImpl : 보육일지 서비스 구현
 * Created by ryusi   on 2021-04-11.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
@Service
@Transactional
public class CplanDalServiceImpl implements CplanDalService {

    @Autowired
    private CplanDalDAO cplanDalDAO;

    /**
    * @name    : codeList : 코드 리스트
    * @return  : List<HashMap<String, String>>
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-04-11     ||created
    **/
    @Override
    public List<HashMap<String, String>> codeList(HashMap map, String codeNm) throws Exception {
        return cplanDalDAO.selectCodeList(map,codeNm);
    }

    /**
     * @name    : cntExist : 주간보육계획안 존재확인
     * @return  : int
     * @history :||user      ||date          ||modified comments
     *           ||ryusi    ||2021-04-11     ||created
     **/
    @Override
    public int cntExist(CplanDalVo vo) throws Exception {
        return cplanDalDAO.selectCplanDalExistCnt(vo);
    }

    /**
     * @name    : unUsed : 주간보육계획안 사용여부 N
     * @return  :
     * @history :||user      ||date          ||modified comments
     *           ||ryusi    ||2021-04-11     ||created
     **/
    @Override
    public void unUsed(CplanDalDtlVo vo) throws Exception {
        cplanDalDAO.updateUseYnN(vo);
    }
}
