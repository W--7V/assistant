var grid;
var dialog;
var list;
var dialog;
var listUrl = "/member/listMember";
var addUrl = "/member/toadd";
$(function(){
	grid = $("#grid").datagrid({
		title: '成员列表',
		striped: true,
		singleSelect: true,
		url: listUrl,
		rownumbers: true,
		pagination: true,
//		fitColumns: true,
//		sortOrder: 'asc',
		loadMsg: "正在努力加载数据，请稍后...",
//		pageList: [50, 100, 500, 1000],
		columns: [[{
			width: '200',
			title: '姓名',
			align: 'center',
			field: 'name'
		}, {
			width: '200',
			title: '登录名',
			align: 'center',
			field: 'loginName'
		}, {
			width: '200',
			title: '性别',
			align: 'center',
			field: 'gender',
			formatter:function(value, row){
				if(value == 0)return "女";
				else return "男";
			}
		}]],
//		onBeforeLoad: function(row, param) {},
//		onLoadSuccess: function(row, data) {
//			resizeHeight();
//		}
	})
	
//	$("#add").click(function(){
//		addFun();
//	});
})

var addFun = function(){
	dialog = parent.sy.modalDialog({
		title:'新增成员',
		height:$(window).height() * 0.8,
		width:$(window).width() * 0.8,
		url:addUrl,
		buttons:[{
			text:'保存',
			handler:function(){
				
			}
		}]
	})
}