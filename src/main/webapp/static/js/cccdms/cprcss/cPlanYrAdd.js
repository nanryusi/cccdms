// Copyright 2021. Team oktop all rights reserved.
/**
 * 연간보육계획안 js
 **/

/** 공통변수 선언 start **/
//분과코드 객체
let code_comm_cl = '';
//공통 분과코드 셀렉트 박스
let sBox_cl;
//연간보육계획안변수
let vCplanYr = {
    school_code : ''    //학교코드
    ,class_code : ''    //분반코드
    ,year    : ''       //해당년도
    ,month  : ''        //해당월
    ,week   : ''        //해당주간
    ,mainEvent : ''     //행사
    ,mainExp    : ''    //주요경험

    ,teacher_div : ''   //교사분류
};

/** 공통변수 선언 end **/

/** 공통코드 호출 **/
function fn_comm_code(type, obj){
    switch (type){
        case 'comm_cl' : fn_make_selbox('comm_cl', obj);
            break;
        default : break;
    }

    //기본 년도, 월 선택
    document.getElementById("sBox_yr").value = vTHIS_YEAR;
    document.getElementById("sBox_mn").value = vTHIS_MONTH2;

}

const obj_cPlanYr = {

    //온클릭 이벤트
    ev_click() {
        switch (this.id) {
            case 'btn_add' :
                fn_add();
                break;

            default :
                break;
        }
    },
    //셀렉트 박스 체인지
    ev_boxChange(){
        //셀렉트 박스가 바뀌면 담임, 부담임으로 자동 변경
        let class_nm = document.getElementById("div_nm");
        class_nm.innerHTML = sBox_cl[sBox_cl.selectedIndex].div_nm;
    }


}


//공통코드용 셀렉트박스 만들기
function fn_make_selbox(nm, obj){
    sBox_cl = document.getElementById(nm);
    let opt = "";
    code_comm_cl = JSON.parse(obj);
    //담임, 부담임, 원장 표시용
    let class_nm = document.getElementById("div_nm");

    code_comm_cl.forEach(function(data, idx){

        opt = document.createElement("OPTION");
        for(key in data){
            if(key == 'cl_cd'){ opt.value = data[key];}
            if(key == 'cl_nm'){ opt.text = data[key];}
            if(key == 'div_cd'){ opt.div_cd = data[key];}
            if(key == 'div_nm'){ opt.div_nm = data[key];}

            //기본값을 위해 맨 처음 div_nm 값을 입력시킴
            if(idx==0 && key == 'div_nm'){
                class_nm.innerHTML = data[key];
            }
        }
        sBox_cl.options.add(opt);
    });

    sBox_cl.addEventListener('change', obj_cPlanYr.ev_boxChange);
}

//저장
function fn_add(){
    //저장데이터 입력
    vCplanYr.year   = document.getElementById("sBox_yr").value;
    vCplanYr.month  = document.getElementById("sBox_mn").value;
    vCplanYr.week   = document.getElementById("sBox_wk").value;
    vCplanYr.mainEvent  = document.getElementById("txt_m_evnt").value;
    vCplanYr.mainExp    = document.getElementById("txt_m_exp").value;
    vCplanYr.class_code = sBox_cl[sBox_cl.selectedIndex].value;
    vCplanYr.teacher_div= sBox_cl[sBox_cl.selectedIndex].div_cd;

    //ajax 통신 호출
    let url = "http://localhost:8080/cccdms/cprcss/cplanyr/add_ajax.do";
    fn_ajax(url, vCplanYr, fn_re_add);
}
//저장 콜백
function fn_re_add(reObj){
    alert(reObj.result);
}

/** 이벤트 **/
function fn_event(){
    /**이벤트 발생 객체 선언**/
    let vAdd = document.getElementById("btn_add");
    /** 이벤트 리스너 **/
    //검색버튼 클릭
    vAdd.addEventListener('click', obj_cPlanYr.ev_click);
}

//onload
window.addEventListener('load', function(){
    fn_event();
});