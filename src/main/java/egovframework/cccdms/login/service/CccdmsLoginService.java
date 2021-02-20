package egovframework.cccdms.login.service;


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
public interface CccdmsLoginService {

	/**
	 * 일반 로그인을 처리한다
	 * @return LoginVO
	 *
	 * @param vo    CccdmsLoginVO
	 * @exception Exception Exception
	 */
	CccdmsLoginVO actionLogin(CccdmsLoginVO vo) throws Exception;

	/**
	 * 아이디를 찾는다.
	 * @return LoginVO
	 *
	 * @param vo    CccdmsLoginVO
	 * @exception Exception Exception
	 */
	CccdmsLoginVO searchId(CccdmsLoginVO vo) throws Exception;

	/**
	 * 비밀번호를 찾는다.
	 * @return boolean
	 *
	 * @param vo    CccdmsLoginVO
	 * @exception Exception Exception
	 */
	boolean searchPassword(CccdmsLoginVO vo) throws Exception;

}