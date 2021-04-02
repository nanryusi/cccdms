package egovframework.cccdms.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.cccdms.common.service.CccdmsCommonService;
import egovframework.cccdms.common.service.FileMngService;
import egovframework.cccdms.common.util.FileMngUtil;
import egovframework.cccdms.sample.model.CccdmsSampleVO;
import egovframework.cccdms.common.EgovMessageSource;
import egovframework.cccdms.common.model.FileVO;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * CCCDMS 샘플게시판을 화면 컨드롤러 Created by hong on 2021-03-05
 */
@Controller
@RequestMapping(value = "/cccdms/sample")
public class CccdmsSampleController {

	/** CccdmsCommonService */
	@Resource(name = "commonService")
	private CccdmsCommonService commonService;

	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;
	
	@Resource(name = "FileMngService")
    private FileMngService fileMngService;

    @Resource(name = "FileMngUtil")
    private FileMngUtil fileUtil;
	
	private final String PROGRAM_ID = "sample";
	
	/**
	 * 샘플게시판 목록
	 * 
	 * @param vo - SampleVO
	 * @exception Exception
	 */
	@RequestMapping("main.do")
	public String List(@ModelAttribute("searchVO") CccdmsSampleVO sampleVO, ModelMap model) throws Exception {

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(sampleVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(sampleVO.getPageUnit());
		paginationInfo.setPageSize(sampleVO.getPageSize());

		sampleVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		sampleVO.setLastIndex(paginationInfo.getLastRecordIndex());
		sampleVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		int totCnt = commonService.selectCnt(sampleVO, PROGRAM_ID);// 목록 카운트

		@SuppressWarnings("unchecked")
		List<CccdmsSampleVO> resultList = (List<CccdmsSampleVO>) commonService.selectList(sampleVO, PROGRAM_ID);// 전체목록 조회

		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("resultList", resultList);
		model.addAttribute("resultCnt", totCnt);

		return "sample/sampleList";
	}

	/**
	 * 샘플게시판 상세내용을 조회한다.
	 *
	 * @param sampleVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("view.do")
	public String view(@ModelAttribute("searchVO") CccdmsSampleVO sampleVO, ModelMap model) throws Exception {

		CccdmsSampleVO vo = (CccdmsSampleVO) commonService.selectDetail(sampleVO, PROGRAM_ID);// 상세조회
		commonService.viewCnt(sampleVO, "sample");// 조회수

		model.addAttribute("resultVO", vo);

		return "sample/sampleView";
	}

	/**
	 * 샘플게시판 내용 입력 수정을 위해 페이지로 이동.
	 *
	 * @param sampleVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("{pathVariable}Form.do")
	public String form(@PathVariable String pathVariable, @ModelAttribute("searchVO") CccdmsSampleVO sampleVO, ModelMap model) throws Exception {
		
		if("insert".equals(pathVariable)) {
			sampleVO.setPathVariable(pathVariable);
			model.addAttribute("sampleVO", sampleVO);
		} else if("update".equals(pathVariable)) {
			CccdmsSampleVO vo = (CccdmsSampleVO) commonService.selectDetail(sampleVO, PROGRAM_ID);// 상세조회
			vo.setPathVariable(pathVariable);
			model.addAttribute("sampleVO", vo);
		}
		
		return "sample/sampleForm";
	}
	
	/**
	 * 샘플게시판 내용을 입력, 수정 한다.
	 *
	 * @param sampleVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("{pathVariable}Action.do")
	public String action(@PathVariable String pathVariable, 
			@ModelAttribute("sampleVO") CccdmsSampleVO sampleVO, 
			MultipartHttpServletRequest multiRequest, 
			SessionStatus status, 
			HttpServletRequest request, 
			ModelMap model) throws Exception {
		
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("LoginId");
		
		String rtn = "";
		final Map<String, MultipartFile> files = multiRequest.getFileMap();
	    String atchFileId = "";

	    if (!files.isEmpty()) {
	    	List<FileVO> result = fileUtil.parseFileInf(files, 0, "", "");

			atchFileId = fileMngService.insertFileInfs(result);

			sampleVO.setAtchFileId(atchFileId);
	    }
		
		if("insert".equals(pathVariable)) {
			sampleVO.setRegId(loginId);
			
			commonService.insert(sampleVO, PROGRAM_ID);// 입력
			
			rtn = "redirect:/cccdms/sample/main.do";
		} else if("update".equals(pathVariable)) {
			sampleVO.setModId(loginId);
			
			commonService.update(sampleVO, PROGRAM_ID);// 수정
			
			rtn = "redirect:/cccdms/sample/view.do?seqNo="+sampleVO.getSeqNo();
		}
		
		status.setComplete();
		
		return rtn;
	}
	
	/**
	 * 샘플게시판 내용을 삭제한다.
	 *
	 * @param sampleVO
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("delete.do")
	public String delete(@ModelAttribute("searchVO") CccdmsSampleVO sampleVO, SessionStatus status, HttpServletRequest request, ModelMap model) throws Exception {
		
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("LoginId");
		
		sampleVO.setDelId(loginId);
		
		commonService.delete(sampleVO, PROGRAM_ID);// 삭제
		
		status.setComplete();
		
		return "redirect:/cccdms/sample/main.do";
	}
}
