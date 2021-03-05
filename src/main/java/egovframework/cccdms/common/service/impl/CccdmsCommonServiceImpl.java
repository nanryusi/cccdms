package egovframework.cccdms.common.service.impl;

import java.util.List;

import egovframework.cccdms.common.service.CccdmsCommonService;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * @Class Name : EgovCmmUseServiceImpl.java
 * @Description : 공통코드등 전체 업무에서 공용해서 사용해야 하는 서비스를 정의하기위한 서비스 구현 클래스
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
		System.out.println("ServiceImpl=="+str);
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
}
