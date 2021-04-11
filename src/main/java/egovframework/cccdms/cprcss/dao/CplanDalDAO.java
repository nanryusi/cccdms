package egovframework.cccdms.cprcss.dao;

import egovframework.cccdms.cprcss.domain.CplanDalDtlVo;
import egovframework.cccdms.cprcss.domain.CplanDalVo;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * CplanDalDAO : 보육일지 DAO
 * Created by ryusi   on 2021-04-11.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
@Repository
public class CplanDalDAO extends EgovAbstractDAO {

    /**
     * @name    : codeList : 코드 리스트 호출
     * @return  : List
     * @history :||user      ||date          ||modified comments
     *           ||ryusi    ||2021-04-11     ||created
     **/
    public List<HashMap<String, String>> selectCodeList(HashMap map, String codeNm) throws Exception{

        List<HashMap<String, String>> reList = new ArrayList<>();
        String selectedQueryStr = "";

        switch(codeNm){

            case "code_class" : selectedQueryStr = "CplanDalDAO.selectCodeListForClass"; break;
            default: break;
        }

        return (List<HashMap<String, String>>)list(selectedQueryStr, map);
    }

    /**
    * @name    : selectCplanDalExistCnt : 주간보육계획안 존재여부 확인
    * @return  : int
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-04-11     ||created
    **/
    public int selectCplanDalExistCnt(CplanDalVo vo) throws Exception{
        return (int)select("CplanDalDAO.selectCplanDalExistCnt", vo);
    }

    /**
    * @name    : updateUseYnN : 주간보육계획안 사용여부 N
    * @return  :
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-04-11     ||created
    **/
    public void updateUseYnN(CplanDalDtlVo vo) throws Exception{
        update("CplanDalDAO.updateUseYnN", vo);
    }

}
