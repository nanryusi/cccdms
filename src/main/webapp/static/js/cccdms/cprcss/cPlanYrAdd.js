// Copyright 2021. Team oktop all rights reserved.
/**
 * 연간보육계획안 js
 **/

/** 공통변수 선언 start **/
//분과코드 객체
let code_comm_cl = '';
//공통 분과코드 셀렉트 박스
let sBox_cl;

/** 공통변수 선언 end **/

/** 공통코드 호출 **/
function fn_comm_code(type, obj){
    switch (type){
        case 'comm_cl' : fn_make_selbox('comm_cl', obj);
            break;
        default : break;
    }
}

function fn_make_selbox(nm, obj){
    sBox_cl = document.getElementById(nm);
    let opt = "";
    code_comm_cl = JSON.parse(obj);

    code_comm_cl.forEach(function(data, idx){

        opt = document.createElement("OPTION");
        for(key in data){
            if(key == 'cl_cd'){ opt.value = data[key];}
            if(key == 'cl_nm'){ opt.text = data[key];}
            if(key == 'div_cd'){ opt.div_cd = data[key];}
            if(key == 'div_nm'){ opt.div_nm = data[key];}

        }
        sBox_cl.options.add(opt);
    });

    sBox_cl.addEventListener('change', obj_cPlanYr.ev_boxChange);
}


const obj_cPlanYr = {

    //온클릭 이벤트
    ev_click() {
        switch (this.id) {
            case 'btn_seacrh' :
                //fn_search();
                break;

            default :
                break;
        }
    },
    //셀렉트 박스 체인지
    ev_boxChange(){
        //todo 셀렉트 박스가 바뀌면 담임, 부담임으로 자동 변경
        //let class_nm = document.getElementById("div_nm");
        //alert(class_nm.text);
        //class_nm.text = sBox_cl.option.div_nm;
    }


}



/** 이벤트 **/
function fn_event(){

}

//onload
window.addEventListener('load', function(){
    fn_event();
});