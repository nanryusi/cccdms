package egovframework.cccdms.common.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.cccdms.common.model.CccdmsMenuVO;


/**
 * @Class Name : CccdmsMenuDAO.java
 * @Description : 전체 업무에서 공용해서 사용해야 하는 서비스를 정의하기위한 데이터 접근 클래스
 * @Modification Information
 *
 *    수정일       수정자         수정내용
 *    -------        -------     -------------------
 *    2021.03.05     hong
 *
 * @author 공통 서비스 개발팀 이삼섭
 * @since 2009. 3. 11.
 * @version
 * @see
 *
 */
@Repository("menuDAO")
public class CccdmsMenuDAO extends EgovComAbstractDAO {

	/**
     * 목록을 불러온다.
     *
     * @param vo
     * @return
     * @throws Exception
     */
	@SuppressWarnings("unchecked")
	public List<CccdmsMenuVO> selectList(String str) throws Exception {
    	return (List<CccdmsMenuVO>) list(str+".selectList");
    }
}
