package egovframework.cccdms.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import egovframework.cccdms.login.model.LoginVO;
import egovframework.cccdms.login.service.LoginService;
import egovframework.cccdms.common.EgovMessageSource;

import java.net.InetAddress;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * CCCDMS 로그인을 화면 컨드롤러
 * Created by hong on 2021-02-14
 */
@Controller
public class LoginController {

	/** EgovLoginService */
	@Resource(name = "loginService")
	private LoginService loginService;

	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	//로그인페이지 호출
	@RequestMapping(value = "/cccdms/login/loginPage.do")
	public String getMainPage(HttpServletRequest request, ModelMap model)
	throws Exception{

		return "login/login";
	}

	/**
	 * 일반 로그인을 처리한다
	 * @param vo - 아이디, 비밀번호가 담긴 LoginVO
	 * @param request - 세션처리를 위한 HttpServletRequest
	 * @return result - 로그인결과(세션정보)
	 * @exception Exception
	 */
	@RequestMapping(value = "/cccdms/login/actionLogin.do")
	public String actionLogin(@ModelAttribute("cccdmsloginVO") LoginVO loginVO, HttpServletRequest request, ModelMap model) throws Exception {

		// 1. 일반 로그인 처리
		LoginVO resultVO = loginService.actionLogin(loginVO);
		
		InetAddress local = InetAddress.getLocalHost();
		String ip = local.getHostAddress();
		
		resultVO.setLastLoginIp(ip);
		
		boolean loginPolicyYn = true;

		if (resultVO != null && resultVO.getId() != null && !resultVO.getId().equals("") && loginPolicyYn) {
			//승인 여부
			if("Y".equals(resultVO.getAuthYN())){
				request.getSession().setAttribute("LoginVO", resultVO);
				request.getSession().setAttribute("LoginId", resultVO.getId());
				request.getSession().setAttribute("LoginSchlCd", resultVO.getSchoolCd());
				
				loginService.updateLoginInfo(resultVO);
				
				return "redirect:/cccdms/main/main.do";
			}else {
				model.addAttribute("message", egovMessageSource.getMessage("fail.common.loginAuth"));
				return "login/login";
			}
		} else {
			//로그인 실패 시 실패횟수 증가
			loginService.updateFailLoginCnt(loginVO);
			
			model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
			return "login/login";
		}

	}

	/**
	 * 로그아웃한다.
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping(value = "/cccdms/login/actionLogout.do")
	public String actionLogout(HttpServletRequest request, ModelMap model) throws Exception {

		RequestContextHolder.getRequestAttributes().removeAttribute("LoginVO", RequestAttributes.SCOPE_SESSION);
		RequestContextHolder.getRequestAttributes().removeAttribute("LoginId", RequestAttributes.SCOPE_SESSION);
		RequestContextHolder.getRequestAttributes().removeAttribute("LoginSchlCd", RequestAttributes.SCOPE_SESSION);
		
		request.getSession().invalidate();
		
		return "redirect:/cccdms/login/loginPage.do";
	}
}
