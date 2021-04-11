package egovframework.cccdms.cprcss.service;

import egovframework.cccdms.cprcss.domain.CplanDalDtlVo;
import egovframework.cccdms.cprcss.domain.CplanDalVo;

import java.util.HashMap;
import java.util.List;

/**
 * CplanDalService : 주간보육계획안 서비스
 * Created by ryusi   on 2021-04-11.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
public interface CplanDalService {


    /**
    * @name    : codeList : 코드 리스트
    * @return  : List<HashMap<String, String>>
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-04-11     ||created
    **/
    List<HashMap<String, String>> codeList(HashMap map, String codeNm) throws Exception;

    /**
    * @name    : cntExist : 주간보육계획안 존재확인
    * @return  : Integer
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-04-11     ||created
    **/
    int cntExist(CplanDalVo vo) throws Exception;
    
    
    /**
    * @name    : unUsed : 주간보육계획안 사용여부 N
    * @return  : 
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-04-11     ||created
    **/
    void unUsed(CplanDalDtlVo vo) throws Exception;
}
