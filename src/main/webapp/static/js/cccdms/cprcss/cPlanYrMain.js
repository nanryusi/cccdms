// Copyright 2021. Team oktop all rights reserved.
/**
 * 연간보육계획안 메인화면 js
 **/

/** 공통변수 선언 start **/
//검색 오브젝트
let SearchVo = {search_text1: "", search_text2: ""};

/** 공통변수 선언 end **/

const obj_cPlanYr = {

    //온클릭 이벤트
    ev_click(){
        switch (this.id){
            case 'btn_seacrh' :
                fn_search();
                break;

            case 'btn_addPage' :
                fn_getPage("add");
                break;

            default : break;
        }
    }


}



/** 이벤트 **/
function fn_event(){
    /**이벤트 발생 객체 선언**/
    let vSearch = document.getElementById("btn_seacrh");
    let vAddPage = document.getElementById("btn_addPage");

    /** 이벤트 리스너 **/
    //검색버튼 클릭
    vSearch.addEventListener('click', obj_cPlanYr.ev_click);
    //신규 작성 버튼 클릭
    vAddPage.addEventListener('click', obj_cPlanYr.ev_click);
}


/** 화면 이동 **/
function fn_getPage(pageNm){
    switch (pageNm){
        case 'add' : window.location.href = "http://localhost:8080/cccdms/cprcss/cplanyr/addPage.do";
        default : break;
    }
}

/** 검색 이벤트 ajax 통신 **/
async function fn_search() {
    //검색설정
    SearchVo.search_text1 = "testValue";

    //통신설정
    let url = //document.location.href+"/search";
        "http://localhost:8080/cccdms/cprcss/search.do";
    let options = {
        method: 'POST'
        , mode: 'cors'
        , header: {
            'Accept': 'application/json'
            ,'Content-Type': 'application/json;charset=UTF-8'
        }
        , body: JSON.stringify(SearchVo)
    };
    let response = await fetch(url, options);
    let responseOK = response && response.ok;
    if (responseOK) {
        let data = await response.json();
        alert(data);
    }
}


//onload
window.addEventListener('load', function(){
    fn_event();
});