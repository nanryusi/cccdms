/*
 * Copyright 2021. Team oktop all rights reserved.
 */

package egovframework.cccdms.cprcss.domain;

import lombok.Data;

/**
 * CplanMnVo : 월간보육계획안 Vo
 * Created by ryusi   on 2021-03-15.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
@Data
public class CplanMnVo {
    //상태값
    private String pathVariable;
    //아이디
    private String id;

    //인덱스
    private String idx;
    //학교코드
    private String schoolCode;
    //학교분반코드
    private String classCode;
    //기준년도
    private String stndYear;
    //기준월
    private String stndMonth;
    //기준주
    private String stndWeek;
    //주제
    private String title;
    //주요경험
    private String mainExp;
    //야외활동
    private String outdoorAct;
    //주요활동
    private String mainAct;
    //놀이자료
    private String playMtl;
    //행사일정
    private String eventPlan;

}
