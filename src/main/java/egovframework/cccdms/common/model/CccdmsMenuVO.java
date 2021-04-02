package egovframework.cccdms.common.model;

import java.io.Serializable;

/**
 * @Class Name : CccdmsLoginVO.java
 * @Description : Login VO class
 * @Modification Information
 * @
 * @  수정일         수정자                   수정내용
 * @ -------    --------    ---------------------------
 * @ 2009.03.03    박지욱          최초 생성
 * @ 2021.02.14  hong      프로젝트환경에 맞게 커스트마이징버전 생성
 *
 *  @author 공통서비스 개발팀 박지욱
 *  @since 2009.03.03
 *  @version 1.0
 *  @see
 *  
 */
public class CccdmsMenuVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8274004534207618049L;
	
	private String menuCd;
	private String menuNm;
	private String parMenuCd;
	private String menuLev;
	private String menuSn;
	private String menuUrl;
	
	public String getMenuCd() {
		return menuCd;
	}
	public void setMenuCd(String menuCd) {
		this.menuCd = menuCd;
	}
	public String getMenuNm() {
		return menuNm;
	}
	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}
	public String getParMenuCd() {
		return parMenuCd;
	}
	public void setParMenuCd(String parMenuCd) {
		this.parMenuCd = parMenuCd;
	}
	public String getMenuLev() {
		return menuLev;
	}
	public void setMenuLev(String menuLev) {
		this.menuLev = menuLev;
	}
	public String getMenuSn() {
		return menuSn;
	}
	public void setMenuSn(String menuSn) {
		this.menuSn = menuSn;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
}
