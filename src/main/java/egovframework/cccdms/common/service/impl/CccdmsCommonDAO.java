package egovframework.cccdms.common.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;


/**
 * @Class Name : CccdmsCommonDAO.java
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
	
	/**
     * 등록된 게시판 조회수를 수정한다.
     *
     * @param Object vo
     */
    public void viewCnt(Object vo, String str) throws Exception {
    	update(str+".updateViewCnt", vo);
    }
	
    /**
     * 신규 게시판 속성정보를 등록한다.
     *
     * @param Object vo
     */
    public String insert(Object vo, String str) throws Exception {
    	return (String)insert(str+".insert", vo);
    }
    
    /**
     * 등록된 게시판 속성정보를 수정한다.
     *
     * @param Object vo
     */
    public void update(Object vo, String str) throws Exception {
    	update(str+".update", vo);
    }
    
    /**
     * 등록된 게시판 속성정보를 삭제한다.
     *
     * @param Object vo
     */
    public void delete(Object vo, String str) throws Exception {
    	update(str+".delete", vo);
    }
}
