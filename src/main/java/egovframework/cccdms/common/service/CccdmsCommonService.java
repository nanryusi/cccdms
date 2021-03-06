package egovframework.cccdms.common.service;

import java.util.List;

/**
 *
 * 전체 업무에서 공용해서 사용해야 하는 서비스를 정의하기 위한 서비스 인터페이스
 * @author 공통서비스 개발팀 이삼섭
 * @since 2009.04.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2021.03.05     hong
 *
 * </pre>
 */
public interface CccdmsCommonService {
	
	/**
     * 목록카운트을 불러온다.
     *
     * @param vo
     * @return
     * @throws Exception
     */
	int selectCnt(Object vo, String str) throws Exception;
	
	/**
     * 목록을 불러온다.
     *
     * @param vo
     * @return
     * @throws Exception
     */
	List<?> selectList(Object vo, String str) throws Exception;
	
    /**
     * 상세보기를 불러온다.
     *
     * @param vo
     * @return
     * @throws Exception
     */
	Object selectDetail(Object vo, String str) throws Exception;
	
	/**
     * 등록된 게시판 조회수를 수정한다.
     *
     * @param Object vo
     */
    void viewCnt(Object vo, String str) throws Exception;
	
	/**
     * 신규 게시판 속성정보를 등록한다.
     *
     * @param Object vo
     */
    String insert(Object vo, String str) throws Exception;
    
    /**
     * 등록된 게시판 속성정보를 수정한다.
     *
     * @param Object vo
     */
    void update(Object vo, String str) throws Exception;
    
    /**
     * 등록된 게시판 속성정보를 삭제한다.
     *
     * @param Object vo
     */
    void delete(Object vo, String str) throws Exception;
}
