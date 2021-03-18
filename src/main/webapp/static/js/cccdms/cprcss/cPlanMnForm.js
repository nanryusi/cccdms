// Copyright 2021. Team oktop all rights reserved.
/**
 * 월간보육계획안 수정화면 js
 **/

/** 공통변수 선언 start **/
//월간보육계획안변수
let vCplanMn = {
    schoolCode: ''     //학교코드
    , classCode: ''     //분반코드
    , stndYear: ''   //해당년도
    , stndMonth: ''    //해당월
    , stndWeek: ''    //해당주간
    , title: ''         //주제
    , mainExp: ''    //주요경험
    , outdoorAct: ''    //야외활동
    , mainAct: ''    //주요활동
    , playMtl: ''    //놀이자료
    , eventPlan: ''    //행사일정
    , pathVariable: ''
};
/** 공통변수 선언 end **/

const obj_cPlanMn = {

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
    vCplanMn.classCode  = document.getElementById("sBox_cl").value;
    vCplanMn.eventPlan  = document.getElementById("eventPlan").value;
    vCplanMn.mainAct    = document.getElementById("mainAct").value;
    vCplanMn.mainExp    = document.getElementById("mainExp").value;
    vCplanMn.outdoorAct = document.getElementById("outdoorAct").value;
    vCplanMn.playMtl    = document.getElementById("playMtl").value;
    vCplanMn.stndMonth  = document.getElementById("sBox_mn").value;
    vCplanMn.stndWeek   = document.getElementById("sBox_wk").value;
    vCplanMn.stndYear   = document.getElementById("sBox_yr").value;
    vCplanMn.title      = document.getElementById("title").value;


    if (modType == 'add') {
        vCplanMn.pathVariable = 'add';
    } else if (modType == 'mod') {
        vCplanMn.pathVariable = 'mod';
    } else {
        alert("저장할 수 없습니다.");
        return false;
    }

    //ajax 통신 호출
    let url = "add_ajax.do";
    fn_ajax(url, vCplanMn, fn_re_add);
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
        vAdd.addEventListener('click', obj_cPlanMn.ev_click);
    }
    if (vMod !== null) {
        vMod.addEventListener('click', obj_cPlanMn.ev_click);
    }
    vReturn.addEventListener('click', obj_cPlanMn.ev_click);
}

$(document).ready(function () {

    //기본 년도, 월 선택
    $('#sBox_yr').val(vTHIS_YEAR).prop("selected", true);
    $('#sBox_mn').val(vTHIS_MONTH2).prop("selected", true);

    fn_event();
});