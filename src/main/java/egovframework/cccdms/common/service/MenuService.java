package egovframework.cccdms.common.service;

import java.util.List;

import egovframework.cccdms.common.model.MenuVO;

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
public interface MenuService {
	
	/**
     * 목록을 불러온다.
     *
     * @param vo
     * @return
     * @throws Exception
     */
	List<MenuVO> selectList(String str) throws Exception;
}
