package egovframework.cccdms.login.model;

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
 * @ 2021.03.14  ryusi	   학교코드 추가(현재 소속)
 *
 *  @author 공통서비스 개발팀 박지욱
 *  @since 2009.03.03
 *  @version 1.0
 *  @see
 *  
 */
public class LoginVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8274004534207618049L;
	
	/** 아이디 */
	private String id;
	/** 이름 */
	private String userName;
	/** 비밀번호 */
	private String password;
	/** 비밀번호 힌트 */
	private String passwordHint;
	/** 비밀번호 정답 */
	private String passwordCnsr;
	/** 사용자구분 */
	private String userLevel;
	/** 사용자구분 */
	private String userGroup;
	/** 사용자 IP정보 */
	private String userIp;
	/** 마지막로그인일자 */
	private String lastLoginDt;
	/** 마지막로그인Ip */
	private String lastLoginIp;
	/** 로그인실패횟수 */
	private String failLoginCnt;
	/** 가입일자 */
	private String regDt;
	/** 학교 코드 */
	private String schoolCd;
	/** 승인여부 */
	private String authYN;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordHint() {
		return passwordHint;
	}
	public void setPasswordHint(String passwordHint) {
		this.passwordHint = passwordHint;
	}
	public String getPasswordCnsr() {
		return passwordCnsr;
	}
	public void setPasswordCnsr(String passwordCnsr) {
		this.passwordCnsr = passwordCnsr;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	public String getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}
	public String getUserIp() {
		return userIp;
	}
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	public String getLastLoginDt() {
		return lastLoginDt;
	}
	public void setLastLoginDt(String lastLoginDt) {
		this.lastLoginDt = lastLoginDt;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public String getFailLoginCnt() {
		return failLoginCnt;
	}
	public void setFailLoginCnt(String failLoginCnt) {
		this.failLoginCnt = failLoginCnt;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public String getSchoolCd() {
		return schoolCd;
	}
	public void setSchoolCd(String schoolCd) {
		this.schoolCd = schoolCd;
	}
	public String getAuthYN() {
		return authYN;
	}
	public void setAuthYN(String authYN) {
		this.authYN = authYN;
	}
}
