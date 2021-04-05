package egovframework.cccdms.common.interceptor;

import egovframework.cccdms.common.model.MenuVO;
import egovframework.cccdms.common.service.MenuService;
import egovframework.cccdms.common.util.UserDetailsHelper;
import egovframework.cccdms.login.model.LoginVO;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

/**
 * 인증여부 체크 인터셉터
 * @author 공통서비스 개발팀 서준식
 * @since 2011.07.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자          수정내용
 *  -------    --------    ---------------------------
 *  2011.07.01  서준식          최초 생성
 *  2011.09.07  서준식          인증이 필요없는 URL을 패스하는 로직 추가
 *  2014.06.11  이기하          인증이 필요없는 URL을 패스하는 로직 삭제(xml로 대체)
 *  2021.02.14  hong      프로젝트환경에 맞게 커스트마이징버전 생성
 *  </pre>
 */

public class AuthenticInterceptor extends WebContentInterceptor {
	
	/** CccdmsMenuService */
	@Resource(name = "menuService")
	private MenuService menuService;
	
	/**
	 * 세션에 계정정보(LoginVO)가 있는지 여부로 인증 여부를 체크한다.
	 * 계정정보(LoginVO)가 없다면, 로그인 페이지로 이동한다.
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
		LoginVO loginVO = (LoginVO) UserDetailsHelper.getAuthenticatedUser();
		if (loginVO.getId() != null) {
			try {
				List<MenuVO> resultTopMenuList = menuService.selectList("topMenu");
				List<MenuVO> resultLeftMenuList = menuService.selectList("leftMenu");
				request.getSession().setAttribute("resultTopMenuList", resultTopMenuList);
				request.getSession().setAttribute("resultLeftMenuList", resultLeftMenuList);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
			return true;
		} else {
			ModelAndView modelAndView = new ModelAndView("redirect:/cccdms/login/loginPage.do");
			throw new ModelAndViewDefiningException(modelAndView);
		}
	}

}
