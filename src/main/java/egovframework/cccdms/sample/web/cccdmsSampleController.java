package egovframework.cccdms.sample.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.cccdms.common.service.CccdmsCommonService;
import egovframework.cccdms.sample.vo.CccdmsSampleVO;
import egovframework.com.cmm.EgovMessageSource;
import egovframework.rte.fdl.cmmn.trace.LeaveaTrace;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * CCCDMS 샘플게시판을 화면 컨드롤러
 * Created by hong on 2021-03-05
 */
@Controller
@RequestMapping(value = "/cccdms/sample")
public class cccdmsSampleController {

	/** EgovLoginService */
	@Resource(name = "commonService")
	private CccdmsCommonService commonService;

	/** EgovMessageSource */
	@Resource(name = "egovMessageSource")
	EgovMessageSource egovMessageSource;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** TRACE */
	@Resource(name = "leaveaTrace")
	LeaveaTrace leaveaTrace;	

	/**
	 * 샘플게시판 목록
	 * @param vo - SampleVO
	 * @param request - 세션처리를 위한 HttpServletRequest
	 * @return result - 로그인결과(세션정보)
	 * @exception Exception
	 */
	@RequestMapping(value = "main.do")
	public String List(@ModelAttribute("searchVO") CccdmsSampleVO sampleVO, ModelMap model)
	throws Exception{
		
		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(sampleVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(sampleVO.getPageUnit());
		paginationInfo.setPageSize(sampleVO.getPageSize());

		sampleVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		sampleVO.setLastIndex(paginationInfo.getLastRecordIndex());
		sampleVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		int totCnt = commonService.selectCnt(sampleVO, "sample");

		@SuppressWarnings("unchecked")
		List<CccdmsSampleVO> resultList = (List<CccdmsSampleVO>) commonService.selectList(sampleVO, "sample");
		
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("resultList", resultList);
		model.addAttribute("resultCnt", totCnt);

		return "sample/list";
	}
}
