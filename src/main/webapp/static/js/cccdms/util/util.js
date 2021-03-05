// Copyright 2021. Team oktop all rights reserved.

let today = new Date();

//년도
let vTHIS_YEAR = today.getFullYear();
//월
let vTHIS_MONTH = today.getMonth() + 1;
//날짜
let vTHIS_DATE = today.getDate();
//요일
let vTHIS_DAY = today.getDay();

//월 01,02,03 으로 표시
let vTHIS_MONTH2 = function(){
    if(vTHIS_MONTH < 10){
        return "0"+vTHIS_MONTH;
    }else{
        return vTHIS_MONTH;
    }
}();


/** ajax 통신 **/
async function fn_ajax(url, obj, re_fn) {

    //통신설정
    //let url = "http://localhost:8080/cccdms/cprcss/search.do";
    let options = {
        method: 'POST'
        , mode: 'cors'
        , header: {
            'Accept': 'application/json'
            ,'Content-Type': 'application/json;charset=UTF-8'
        }
        , body: JSON.stringify(obj)
    };
    let response = await fetch(url, options);
    let responseOK = response && response.ok;
    if (responseOK) {
        let data = await response.json();
        re_fn(data);
    }else{
        alert("실패하였습니다.");
    }
}