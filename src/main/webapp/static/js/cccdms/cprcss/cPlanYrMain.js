// Copyright 2021. Team oktop all rights reserved.
/**
 * 연간보육계획안 메인화면 js
 **/

/** 공통변수 선언 start **/

/** 공통변수 선언 end **/

//post 상세내역 형식 호출
function page_move(obj){
    const fm=document.goForm;
    fm.seqNo.value = obj;
    fm.action = "/cccdms/cprcss/cplanyr/modPage.do";
    fm.submit();
}