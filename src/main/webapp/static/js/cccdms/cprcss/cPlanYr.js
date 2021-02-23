// Copyright 2021. Team oktop all rights reserved.
/**
 * 연간보육계획안 js
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
                fn_search()
                break;

            default : break;
        }
    }


}



/** 이벤트 **/
function fn_event(){
    /**이벤트 발생 객체 선언**/
    let vSearch = document.getElementById("btn_seacrh");

    /** 이벤트 리스너 **/
    //검색버튼 클릭
    vSearch.addEventListener('click', obj_cPlanYr.ev_click);
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