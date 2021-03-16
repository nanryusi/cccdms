package egovframework.cccdms.common.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import egovframework.cccdms.common.service.FileMngService;
import egovframework.cccdms.common.util.CccdmsUserDetailsHelper;
import egovframework.cccdms.common.model.FileVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 파일 조회, 삭제, 다운로드 처리를 위한 컨트롤러 클래스
 * @author 공통서비스개발팀 이삼섭
 * @since 2009.06.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.03.25  이삼섭          최초 생성
 *   2011.08.31  JJY            경량환경 템플릿 커스터마이징버전 생성
 *
 * </pre>
 */
@Controller
public class FileMngController {

    @Resource(name = "FileMngService")
    private FileMngService fileService;

    /**
     * 첨부파일에 대한 목록을 조회한다.
     *
     * @param fileVO
     * @param atchFileId
     * @param sessionVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/cccdms/fms/selectFileInfs.do")
    public String selectFileInfs(@ModelAttribute("searchVO") FileVO fileVO, @RequestParam Map<String, Object> commandMap, ModelMap model) throws Exception {
	String atchFileId = (String)commandMap.get("param_atchFileId");
	String updateFlag = (String)commandMap.get("param_updateFlag");

	fileVO.setAtchFileId(atchFileId);
	List<FileVO> result = fileService.selectFileInfs(fileVO);

	model.addAttribute("fileList", result);
	model.addAttribute("updateFlag", updateFlag);
	model.addAttribute("fileListCnt", result.size());
	model.addAttribute("atchFileId", atchFileId);

	return "common/fms/FileList";
    }

    /**
     * 첨부파일 변경을 위한 수정페이지로 이동한다.
     *
     * @param fileVO
     * @param atchFileId
     * @param sessionVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/cccdms/fms/selectFileInfsForUpdate.do")
    public String selectFileInfsForUpdate(@ModelAttribute("searchVO") FileVO fileVO, @RequestParam Map<String, Object> commandMap,
	    ModelMap model) throws Exception {

	String atchFileId = (String)commandMap.get("param_atchFileId");

	fileVO.setAtchFileId(atchFileId);

	List<FileVO> result = fileService.selectFileInfs(fileVO);

	model.addAttribute("fileList", result);
	model.addAttribute("updateFlag", "Y");
	model.addAttribute("fileListCnt", result.size());
	model.addAttribute("atchFileId", atchFileId);

	return "common/fms/FileList";
    }

    /**
     * 첨부파일에 대한 삭제를 처리한다.
     *
     * @param fileVO
     * @param returnUrl
     * @param sessionVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/cccdms/fms/deleteFileInfs.do")
    public Map<String, Boolean> deleteFileInf(@ModelAttribute("searchVO") FileVO fileVO,
	    HttpServletRequest request,
	    ModelMap model) throws Exception {
    	HashMap<String, Boolean> result = new HashMap<String, Boolean>();
    	Boolean isAuthenticated = CccdmsUserDetailsHelper.isAuthenticated();
    	Boolean rtn = false;
		if (isAuthenticated) {
		    fileService.deleteFileInf(fileVO);
		    
		    int fileCnt = fileService.getFileCnt(fileVO);
		    
		    if(fileCnt == 0) {
		    	fileService.deleteAllFileInf(fileVO);
		    }
		    
		    rtn = true;
		}
		result.put("result", rtn);
		
		return result;
    }

    /**
     * 이미지 첨부파일에 대한 목록을 조회한다.
     *
     * @param fileVO
     * @param atchFileId
     * @param sessionVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping("/cccdms/fms/selectImageFileInfs.do")
    public String selectImageFileInfs(@ModelAttribute("searchVO") FileVO fileVO, @RequestParam Map<String, Object> commandMap,
	    ModelMap model) throws Exception {

	String atchFileId = (String)commandMap.get("atchFileId");

	fileVO.setAtchFileId(atchFileId);
	List<FileVO> result = fileService.selectImageFileList(fileVO);

	model.addAttribute("fileList", result);

	return "common/fms/ImgFileList";
    }
}
