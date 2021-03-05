package egovframework.cccdms.common.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * @Class Name : CccdmsCommonDAO.java
 * @Description : 공통코드등 전체 업무에서 공용해서 사용해야 하는 서비스를 정의하기위한 데이터 접근 클래스
 * @Modification Information
 *
 *    수정일       수정자         수정내용
 *    -------        -------     -------------------
 *    2009. 3. 11.     이삼섭
 *
 * @author 공통 서비스 개발팀 이삼섭
 * @since 2009. 3. 11.
 * @version
 * @see
 *
 */
@Repository("commonDAO")
public class CccdmsCommonDAO extends EgovComAbstractDAO {
	
	/**
     * 목록카운트을 불러온다.
     *
     * @param vo
     * @return
     * @throws Exception
     */
	public int selectCnt(Object vo, String str) throws Exception {
		System.out.println("dao=="+str);
    	return (int) select(str+".selectCnt", vo);
    }

	/**
     * 목록을 불러온다.
     *
     * @param vo
     * @return
     * @throws Exception
     */
	public List<?> selectList(Object vo, String str) throws Exception {
    	return (List<?>) list(str+".selectList", vo);
    }
	
    /**
     * 상세보기를 불러온다.
     *
     * @param vo
     * @return
     * @throws Exception
     */
	public Object selectDetail(Object vo, String str) throws Exception {
    	return (Object) select(str+".selectDetail", vo);
    }
}
