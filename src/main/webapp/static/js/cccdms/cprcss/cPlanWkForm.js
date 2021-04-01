// Copyright 2021. Team oktop all rights reserved.
/**
 * 주간보육일지 수정화면 js
 **/

/** 공통변수 선언 start **/
//주간보육일지변수
let vCplanWk = {
      idx: ''           //주간보육일지번호
    , schoolCode: ''    //학교코드
    , classCode: ''     //분반코드
    , stndYear: ''      //해당년도
    , startDay: ''      //시작일
    , endDay: ''        //종료일
    , morningAct: ''    //오전활동
    , lunchAct: ''      //점심활동
    , breakTimeAct: ''  //휴식시간 활동
    , outdoorAct: ''    //야외활동
    , indoorAct: ''     //실내활동
    , additAct: ''      //추가활동
    , firstEvalPlan: '' //첫째날 평가계획
    , secondEvalPlan: ''//둘째날 평가계획
    , thirdEvalPlan: '' //셋째날 평가계획
    , forthEvalPlan: '' //넷째날 평가계획
    , fifthEvalPlan: '' //다섯째날 평가계획
    , nextEvalPlan: ''  //다음주 평가계획
    , firstOprSpcf: ''  //첫째날 특이사항
    , secondOprSpcf: '' //둘째날 특이사항
    , thirdOprSpcf: ''  //셋째날 특이사항
    , forthOprSpcf: ''  //넷째날 특이사항
    , fifthOprSpcf: ''  //다섯째날 특이사항
    , pathVariable: ''
};
/** 공통변수 선언 end **/

const obj_cPlanWk = {

    //온클릭 이벤트
    ev_click() {
        switch (this.id) {
            case 'btn_add_ajax' :
                fn_add('add'); break;
            case 'btn_mod_ajax' :
                fn_add('mod'); break;
            case 'btn_return' :
                window.location.href = 'mainPage.do';
            default : break;
        }
    }

}


//저장
function fn_add(modType) {
    //저장데이터 입력
    vCplanWk.idx        = document.getElementById("idx").value;
    vCplanWk.classCode  = document.getElementById("sBox_cl").value;
    vCplanWk.stndYear   = document.getElementById("sBox_yr").value;
    vCplanWk.startDay   = document.getElementById("startDay").value;
    vCplanWk.endDay     = document.getElementById("endDay").value;
    vCplanWk.morningAct = document.getElementById("morningAct").value;
    vCplanWk.lunchAct   = document.getElementById("lunchAct").value;
    vCplanWk.breakTimeAct   = document.getElementById("breakTimeAct").value;
    vCplanWk.indoorAct  = document.getElementById("indoorAct").value;
    vCplanWk.outdoorAct = document.getElementById("outdoorAct").value;
    vCplanWk.additAct   = document.getElementById("additAct").value;
    vCplanWk.firstEvalPlan  = document.getElementById("firstEvalPlan").value;
    vCplanWk.firstOprSpcf   = document.getElementById("firstOprSpcf").value;
    vCplanWk.secondEvalPlan = document.getElementById("secondEvalPlan").value;
    vCplanWk.secondOprSpcf  = document.getElementById("secondOprSpcf").value;
    vCplanWk.thirdEvalPlan  = document.getElementById("thirdEvalPlan").value;
    vCplanWk.thirdOprSpcf   = document.getElementById("thirdOprSpcf").value;
    vCplanWk.forthEvalPlan  = document.getElementById("forthEvalPlan").value;
    vCplanWk.forthOprSpcf   = document.getElementById("forthOprSpcf").value;
    vCplanWk.fifthEvalPlan  = document.getElementById("fifthEvalPlan").value;
    vCplanWk.fifthOprSpcf   = document.getElementById("fifthOprSpcf").value;
    vCplanWk.nextEvalPlan   = document.getElementById("nextEvalPlan").value;

    //날짜형식에서 숫자만 추출
    vCplanWk.startDay   = vCplanWk.startDay.replaceAll(/[^0-9]/g, '');
    vCplanWk.endDay     = vCplanWk.endDay.replaceAll(/[^0-9]/g, '');


    if (modType == 'add') {
        vCplanWk.pathVariable = 'add';
    } else if (modType == 'mod') {
        vCplanWk.pathVariable = 'mod';
    } else {
        alert("저장할 수 없습니다.");
        return false;
    }

    //ajax 통신 호출
    let url = "add_ajax.do";
    fn_ajax(url, vCplanWk, fn_re_add);
}

//저장 콜백
function fn_re_add(reObj) {
    if (reObj.result == "Success") {
        alert("저장되었습니다.");
    } else {
        alert(reObj.result);
    }
}

/** 이벤트 **/
function fn_event() {

    /**이벤트 발생 객체 선언**/
    let vAdd = document.getElementById("btn_add_ajax");
    let vMod = document.getElementById("btn_mod_ajax");
    let vReturn = document.getElementById("btn_return");
    /** 이벤트 리스너 **/
    //저장버튼 클릭
    if (vAdd !== null) {
        vAdd.addEventListener('click', obj_cPlanWk.ev_click);
    }
    if (vMod !== null) {
        vMod.addEventListener('click', obj_cPlanWk.ev_click);
    }
    vReturn.addEventListener('click', obj_cPlanWk.ev_click);
}

$(document).ready(function () {

    //기본 년도, 월 선택
    $('#sBox_yr').val(vTHIS_YEAR).prop("selected", true);

    fn_event();
});