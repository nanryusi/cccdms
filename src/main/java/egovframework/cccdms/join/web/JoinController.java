package egovframework.cccdms.join.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.cccdms.common.service.CommonService;
import egovframework.cccdms.login.model.LoginVO;
import egovframework.cccdms.common.EgovMessageSource;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * CCCDMS 샘플게시판을 화면 컨드롤러 Created by hong on 2021-03-05
 */
@Controller
@RequestMapping(value = "/cccdms/join")
public class JoinController {

	/** CccdmsCommonService */
	@Resource(name = "commonService")
	private CommonService commonService;

	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;
	
	private final String PROGRAM_ID = "join";

	/**
	 * 샘플게시판 내용 입력 수정을 위해 페이지로 이동.
	 *
	 * @param joinVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("insertForm.do")
	public String insertForm(@PathVariable String pathVariable, @ModelAttribute("searchVO") LoginVO joinVO, ModelMap model) throws Exception {
		System.out.println("===========aaaaa");
		model.addAttribute("joinVO", joinVO);
		
		return "login/joinForm";
	}
	
	/**
	 * 샘플게시판 내용 입력 수정을 위해 페이지로 이동.
	 *
	 * @param joinVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("updateForm.do")
	public String updateForm(@PathVariable String pathVariable, @ModelAttribute("searchVO") LoginVO joinVO, ModelMap model) throws Exception {

		LoginVO vo = (LoginVO) commonService.selectDetail(joinVO, PROGRAM_ID);// 상세조회
		model.addAttribute("joinVO", vo);

		return "login/joinForm";
	}
	
	/**
	 * 샘플게시판 내용을 입력, 수정 한다.
	 *
	 * @param joinVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("{pathVariable}Action.do")
	public String action(@PathVariable String pathVariable, 
			@ModelAttribute("joinVO") LoginVO joinVO, 
			MultipartHttpServletRequest multiRequest, 
			SessionStatus status, 
			HttpServletRequest request, 
			ModelMap model) throws Exception {
		
		if("insert".equals(pathVariable)) {
			commonService.insert(joinVO, PROGRAM_ID);// 입력
		}else if("update".equals(pathVariable)) {
			commonService.update(joinVO, PROGRAM_ID);// 입력
		}
		
		status.setComplete();
		
		if("update".equals(pathVariable)) {
			return "redirect:/cccdms/main/main.do";
		}else {
			return "redirect:/cccdms/login/loginPage.do";
		}
	}
	
	/**
	 * 샘플게시판 내용을 삭제한다.
	 *
	 * @param joinVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("delete.do")
	public String delete(@ModelAttribute("searchVO") LoginVO joinVO, SessionStatus status, HttpServletRequest request, ModelMap model) throws Exception {
		
		commonService.delete(joinVO, PROGRAM_ID);// 삭제
		
		status.setComplete();
		
		return "redirect:/cccdms/login/loginPage.do";
	}
}
