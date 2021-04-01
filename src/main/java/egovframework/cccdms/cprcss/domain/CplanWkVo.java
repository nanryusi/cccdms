/*
 * Copyright 2021. Team oktop all rights reserved.
 */

package egovframework.cccdms.cprcss.domain;

import lombok.Data;

/**
 * CplanMnVo : 주간보육일지 Vo
 * Created by ryusi   on 2021-03-23.
 * Modification Information
 * ||수정자       ||수정일     ||수정내용
 */
@Data
public class CplanWkVo {
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
    //시작일
    private String startDay;
    //종료일
    private String endDay;
    //오전활동
    private String morningAct;
    //점심활동
    private String lunchAct;
    //휴식시간 활동
    private String breakTimeAct;
    //야외활동
    private String outdoorAct;
    //실내활동
    private String indoorAct;
    //추가활동
    private String additAct;
    //첫째날 평가 및 계획
    private String firstEvalPlan;
    //둘째날 평가 및 계획
    private String secondEvalPlan;
    //셋째날 평가 및 계획
    private String thirdEvalPlan;
    //넷째날 평가 및 계획
    private String forthEvalPlan;
    //다섯째날 평가 및 계획
    private String fifthEvalPlan;
    //다음주 평가 및 계획
    private String nextEvalPlan;
    //첫째날 특이사항
    private String firstOprSpcf;
    //둘째날 특이사항
    private String secondOprSpcf;
    //셋째날 특이사항
    private String thirdOprSpcf;
    //넷째날 특이사항
    private String forthOprSpcf;
    //다섯째날 특이사항
    private String fifthOprSpcf;
}
