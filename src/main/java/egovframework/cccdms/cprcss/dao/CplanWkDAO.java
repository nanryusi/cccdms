package egovframework.cccdms.cprcss.dao;

import egovframework.cccdms.cprcss.domain.CplanWkDtlVo;
import egovframework.cccdms.cprcss.domain.CplanWkVo;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * CplanWkDAO : 주간보육계획안 DAO
 * Created by ryusi   on 2021-03-23.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
@Repository
public class CplanWkDAO extends EgovAbstractDAO {

    /**
     * @name    : codeList : 코드 리스트 호출
     * @return  : List
     * @history :||user      ||date          ||modified comments
     *           ||ryusi    ||2021-03-23     ||created
     **/
    public List<HashMap<String, String>> selectCodeList(HashMap map, String codeNm) throws Exception{

        List<HashMap<String, String>> reList = new ArrayList<>();
        String selectedQueryStr = "";

        switch(codeNm){

            case "code_class" : selectedQueryStr = "CplanWkDAO.selectCodeListForClass"; break;
            default: break;
        }

        return (List<HashMap<String, String>>)list(selectedQueryStr, map);
    }

    /**
    * @name    : selectCplanWkExistCnt : 주간보육계획안 존재여부 확인
    * @return  : int
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-03-23     ||created
    **/
    public int selectCplanWkExistCnt(CplanWkVo vo) throws Exception{
        return (int)select("CplanWkDAO.selectCplanWkExistCnt", vo);
    }

    /**
    * @name    : updateUseYnN : 주간보육계획안 사용여부 N
    * @return  :
    * @history :||user      ||date          ||modified comments
    *           ||ryusi    ||2021-03-23     ||created
    **/
    public void updateUseYnN(CplanWkDtlVo vo) throws Exception{
        update("CplanWkDAO.updateUseYnN", vo);
    }

}
