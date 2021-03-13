// Copyright 2021. Team oktop all rights reserved.
$(document).ready(function(){
	
	$("#btn_addPage").click(function(){ fnInsertForm(); });
	$("#btn_update").click(function(){ fnUpdateForm(); });
	$("#btn_add").click(function(){ fnInsertAction(); });
	$("#btn_updateAction").click(function(){ fnUpdateAction(); });
	$("#btn_delete").click(function(){ fnDelete(); });
});

function fnInsertForm(){
	location.href = "insertForm.do";
}

function fnUpdateForm(){
	const updateForm = document.viewForm;
	updateForm.action = "updateForm.do";
	if(confirm("수정하시겠습니까?")){
		updateForm.submit();
	}
}

function fnInsertAction(){
	const actionForm = document.actionForm;
	
	//actionForm.method = "post";
	actionForm.action = "insertAction.do";
	
	if(confirm("입력하시겠습니까?")){
		actionForm.submit();
	}
}

function fnUpdateAction(){
	const actionForm = document.actionForm;
	
	//actionForm.method = "post";
	actionForm.action = "updateAction.do";
	
	if(confirm("수정하시겠습니까?")){
		actionForm.submit();
	}
}

function fnDelete(){
	const actionForm = document.viewForm;
	
	//actionForm.method = "post";
	actionForm.action = "delete.do";
	
	if(confirm("삭제하시겠습니까?")){
		actionForm.submit();
	}
}