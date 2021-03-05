/*
 * Copyright 2021. Team oktop all rights reserved.
 */

package egovframework.cccdms.cprcss.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * CplanYrVo : 연간보육계획안 Vo
 * Created by ryusi   on 2021-03-05.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
@Getter
@Setter
public class CplanYrVo {
    //어린이집 학교 코드
    private String school_code;
    //어린이집 학급 코드
    private String class_code;
    //해당년도
    private String year;
    //해당월
    private String month;
    //해당주
    private String week;
    //주요 행사
    private String mainEvent;
    //주요 경험
    private String mainExp;
    //교사 아이디
    private String id;
    //교사 구분
    private String teacher_div;

}
