$(function(){
	$(".save").click(addFun);
})

var addFun = function addFun(){
	var params = $("#addForm").serialize();
	$.ajax({
		type:"post",
		url:"/member/saveOrUpdate",
		dataType:"json",
		data:params,
		success:function(data){
			if(data.status){
				alert(data.msg);
			}
		}
	});
}