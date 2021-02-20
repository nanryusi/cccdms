package egovframework.cccdms.login.service.impl;

import egovframework.cccdms.login.service.CccdmsLoginVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

import org.springframework.stereotype.Repository;

/**
 * 일반 로그인을 처리하는 비즈니스 구현 클래스
 * @author 공통서비스 개발팀 박지욱
 * @since 2009.03.06
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2009.03.06  박지욱          최초 생성
 *  2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *  2021.02.14  hong      프로젝트환경에 맞게 커스트마이징버전 생성
 *
 *  </pre>
 */
@Repository("cccdmsLoginDAO")
public class CccdmsLoginDAO extends EgovAbstractDAO {

	/**
	 * 일반 로그인을 처리한다
	 * @param vo CccdmsLoginVO
	 * @return CccdmsLoginVO
	 * @exception Exception
	 */
	public CccdmsLoginVO actionLogin(CccdmsLoginVO vo) throws Exception {
		return (CccdmsLoginVO) select("cccdmsLoginDAO.actionLogin", vo);
	}

	/**
	 * 아이디를 찾는다.
	 * @param vo CccdmsLoginVO
	 * @return CccdmsLoginVO
	 * @exception Exception
	 */
	public CccdmsLoginVO searchId(CccdmsLoginVO vo) throws Exception {
		return (CccdmsLoginVO) select("cccdmsLoginDAO.searchId", vo);
	}

	/**
	 * 비밀번호를 찾는다.
	 * @param vo CccdmsLoginVO
	 * @return CccdmsLoginVO
	 * @exception Exception
	 */
	public CccdmsLoginVO searchPassword(CccdmsLoginVO vo) throws Exception {
		return (CccdmsLoginVO) select("cccdmsLoginDAO.searchPassword", vo);
	}

	/**
	 * 변경된 비밀번호를 저장한다.
	 * @param vo CccdmsLoginVO
	 * @exception Exception
	 */
	public void updatePassword(CccdmsLoginVO vo) throws Exception {
		update("cccdmsLoginDAO.updatePassword", vo);
	}
}
