package egovframework.cccdms.common.service.impl;

import java.util.List;

import egovframework.cccdms.common.dao.MenuDAO;
import egovframework.cccdms.common.model.MenuVO;
import egovframework.cccdms.common.service.MenuService;
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
@Service("menuService")
public class MenuServiceImpl extends EgovAbstractServiceImpl implements MenuService {

	@Resource(name = "menuDAO")
	private MenuDAO menuDAO;
	
	/**
     * 목록을 불러온다.
     *
     * @param vo
     * @return
     * @throws Exception
     */
	@Override
	public List<MenuVO> selectList(String str) throws Exception {
    	return menuDAO.selectList(str);
    }
}
