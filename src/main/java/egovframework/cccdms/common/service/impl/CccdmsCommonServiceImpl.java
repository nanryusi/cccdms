package egovframework.cccdms.common.service.impl;

import java.util.List;

import egovframework.cccdms.common.service.CccdmsCommonService;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * @Class Name : CccdmsCommonServiceImpl.java
 * @Description : 전체 업무에서 공용해서 사용해야 하는 서비스를 정의하기위한 서비스 구현 클래스
 * @Modification Information
 *
 *    수정일       수정자         수정내용
 *    -------        -------     -------------------
 *    2021.03.05     hong
 *
 * @author 
 * @since 
 * @version
 * @see
 *
 */
@Service("commonService")
public class CccdmsCommonServiceImpl extends EgovAbstractServiceImpl implements CccdmsCommonService {

	@Resource(name = "commonDAO")
	private CccdmsCommonDAO commonDAO;
	
	/**
     * 목록카운트을 불러온다.
     *
     * @param vo
     * @return
     * @throws Exception
     */
	@Override
	public int selectCnt(Object vo, String str) throws Exception {
    	return commonDAO.selectCnt(vo, str);
    }
	
	/**
     * 목록을 불러온다.
     *
     * @param vo
     * @return
     * @throws Exception
     */
	@Override
	public List<?> selectList(Object vo, String str) throws Exception {
    	return commonDAO.selectList(vo, str);
    }
	
    /**
     * 상세보기를 불러온다.
     *
     * @param vo
     * @return
     * @throws Exception
     */
	@Override
	public Object selectDetail(Object vo, String str) throws Exception {
		return commonDAO.selectDetail(vo, str);
    }
	
	/**
     * 등록된 게시판 조회수를 수정한다.
     *
     * @param Object vo
     */
	@Override
    public void viewCnt(Object vo, String str) throws Exception {
    	commonDAO.viewCnt(vo, str);
    }
	
	/**
     * 신규 게시판 속성정보를 등록한다.
     *
     * @param Object vo
     */
	@Override
    public String insert(Object vo, String str) throws Exception {
    	return commonDAO.insert(vo, str);
    }
    
    /**
     * 등록된 게시판 속성정보를 수정한다.
     *
     * @param Object vo
     */
	@Override
    public void update(Object vo, String str) throws Exception {
    	commonDAO.update(vo, str);
    }
    
    /**
     * 등록된 게시판 속성정보를 삭제한다.
     *
     * @param Object vo
     */
	@Override
    public void delete(Object vo, String str) throws Exception {
    	commonDAO.delete(vo, str);
    }
}
