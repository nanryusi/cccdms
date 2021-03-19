package egovframework.cccdms.cprcss.service;

import egovframework.cccdms.cprcss.domain.CplanMnDtlVo;
import egovframework.cccdms.cprcss.domain.CplanMnVo;

import java.util.HashMap;
import java.util.List;

/**
 * CplanYrService : 월간보육계획안 서비스
 * Created by ryusi   on 2021-03-18.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
public interface CplanMnService {


    /**
    * @name    : codeList : 코드 리스트
    * @return  : List<HashMap<String, String>>
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-03-18     ||created
    **/
    List<HashMap<String, String>> codeList(HashMap map, String codeNm) throws Exception;

    /**
    * @name    : cntExist : 월간보육계획안 존재확인
    * @return  : Integer
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-03-18     ||created
    **/
    int cntExist(CplanMnVo vo) throws Exception;
    
    
    /**
    * @name    : unUsed : 월간보육계획안 사용여부 N
    * @return  : 
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-03-19     ||created
    **/
    void unUsed(CplanMnDtlVo vo) throws Exception;
}
