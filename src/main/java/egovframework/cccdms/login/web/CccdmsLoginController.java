package egovframework.cccdms.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import egovframework.cccdms.login.model.CccdmsLoginVO;
import egovframework.cccdms.login.service.CccdmsLoginService;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.rte.fdl.cmmn.trace.LeaveaTrace;
import egovframework.rte.fdl.property.EgovPropertyService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * CCCDMS 로그인을 화면 컨드롤러
 * Created by hong on 2021-02-14
 */
@Controller
public class CccdmsLoginController {

	/** EgovLoginService */
	@Resource(name = "cccdmsLoginService")
	private CccdmsLoginService cccdmsLoginService;

	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** TRACE */
	@Resource(name = "leaveaTrace")
	LeaveaTrace leaveaTrace;	

	//로그인페이지 호출
	@RequestMapping(value = "/cccdms/login/loginPage.do")
	public String getMainPage(HttpServletRequest request, ModelMap model)
	throws Exception{

		return "main/CccdmsLogin";
	}

	/**
	 * 일반 로그인을 처리한다
	 * @param vo - 아이디, 비밀번호가 담긴 LoginVO
	 * @param request - 세션처리를 위한 HttpServletRequest
	 * @return result - 로그인결과(세션정보)
	 * @exception Exception
	 */
	@RequestMapping(value = "/cccdms/login/actionLogin.do")
	public String actionLogin(@ModelAttribute("cccdmsloginVO") CccdmsLoginVO loginVO, HttpServletRequest request, ModelMap model) throws Exception {

		// 1. 일반 로그인 처리
		CccdmsLoginVO resultVO = cccdmsLoginService.actionLogin(loginVO);

		boolean loginPolicyYn = true;

		if (resultVO != null && resultVO.getId() != null && !resultVO.getId().equals("") && loginPolicyYn) {
			request.getSession().setAttribute("LoginVO", resultVO);
			request.getSession().setAttribute("LoginId", resultVO.getId());
			return "redirect:/cccdms/main/mainPage.do";
		} else {
			model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
			return "main/CccdmsLogin";
		}

	}

	/**
	 * 로그인 후 메인화면으로 들어간다
	 * @param
	 * @return 로그인 페이지
	 * @exception Exception
	 */
	@RequestMapping(value = "/cccdms/login/actionMain.do")
	public String actionMain(ModelMap model) throws Exception {

		// 1. 사용자 인증 처리
		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
		if (!isAuthenticated) {
			model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
			return "main/CccdmsLogin";
		}

		// 2. 메인 페이지 이동
		return "redirect:/cccdms/main/mainPage.do";
	}

	/**
	 * 로그아웃한다.
	 * @return String
	 * @exception Exception
	 */
	@RequestMapping(value = "/cccdms/login/actionLogout.do")
	public String actionLogout(HttpServletRequest request, ModelMap model) throws Exception {

		RequestContextHolder.getRequestAttributes().removeAttribute("LoginVO", RequestAttributes.SCOPE_SESSION);

		return "redirect:/cccdms/main/mainPage.do";
	}
}
