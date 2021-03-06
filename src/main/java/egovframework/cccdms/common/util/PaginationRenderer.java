package egovframework.cccdms.common.util;

import egovframework.rte.ptl.mvc.tags.ui.pagination.AbstractPaginationRenderer;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;
/**
 * ImagePaginationRenderer.java 클래스
 * 
 * @author 서준식
 * @since 2011. 9. 16.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    -------------    ----------------------
 *   2011. 9. 16.   서준식       이미지 경로에 ContextPath추가
 * </pre>
 */
public class PaginationRenderer extends AbstractPaginationRenderer implements ServletContextAware{

	private ServletContext servletContext;
	
	public PaginationRenderer() {
	
	}
	
	public void initVariables(){
		firstPageLabel    = "<li><a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \"><span aria-hidden=\"true\">&laquo;&laquo;</span></a></li>";
        previousPageLabel = "<li><a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \"><span aria-hidden=\"true\">&laquo;</span></a></li>";
        currentPageLabel  = "<li><a class=\"pover\" href=\"#\">{0}</a></li>";
        otherPageLabel    = "<li><a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \">{2}</a></li>";
        nextPageLabel     = "<li><a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \"><span aria-hidden=\"true\">&raquo;</span></a></li>";
        lastPageLabel     = "<li><a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \"><span aria-hidden=\"true\">&raquo;&raquo;</span></a></li>";
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		initVariables();
	}

}
