var grid;
var dialog;
var list;
var listUrl = "/member/list";
var addUrl = "/member/toadd";
$(function(){
	
	var resizeWidth = function(n){
		return parseInt(($(window).width()) * (1/12)) * n;
	}
	
	grid = $("#grid").datagrid({
		title: '成员列表',
		striped: true,
		singleSelect: true,
		url: listUrl,
		rownumbers: true,
		pagination: true,
		fitColumns: true,
//		sortOrder: 'asc',
		loadMsg: "正在努力加载数据，请稍后...",
//		pageList: [50, 100, 500, 1000],
		columns: [[{
			width: resizeWidth(1),
			title: '姓名',
			align: 'center',
			field: 'name'
		}, {
			width: resizeWidth(1),
			title: '登录名',
			align: 'center',
			field: 'loginName'
		}, {
			width: resizeWidth(1),
			title: '性别',
			align: 'center',
			field: 'gender',
			formatter:function(value, row){
				if(value == 0)return "女";
				else return "男";
			}
		}, {
			width: resizeWidth(1),
			title: '操作',
			align: 'center',
			field: 'action',
			formatter:function(value, row){
				var operation = '<a title="查看任务" class="btn btn-info" onclick="listTask(\'' + row.id + '\')">查看任务</a>';
				return operation;
			}
		}]],
//		onBeforeLoad: function(row, param) {},
		toolbar:[
		    { text: '增加', iconCls: 'icon-add', handler: function () {addFun();} }
		],
		onLoadSuccess: function(row, data) {
			resizeHeight();
		}
	})
	
//	$("#add").click(function(){
//		addFun();
//	});
})

var resizeHeight = function() {
	$('#grid').datagrid('resize', {
		height: $(window).height() - $(".cut").outerHeight(true) - $(".min_title").outerHeight(true) - 4
	});
	if(dialog != null && !dialog.parent().is(":hidden")) {
		dialog.dialog('resize', {
			height: top.windowHeight() * 0.7,
			width: top.windowWidth() * 0.7,
		});
	}
}

var addFun = function(){
	$("#createDialog").dialog({
        title : '新增成员',
        modal : true,
        width : '90%',
        height : '90%',
        href : '/member/toadd',
//        buttons:{
//        	""
//        }
	});
}

var listTask = function(mid){
//	console.log(parent.sy);
	$("#createDialog").dialog({
        title : '任务列表',
        modal : true,
        width : '90%',
        height : '90%',
        href : '/member/toadd',
//        buttons:{
//        	""
//        }
	});
//	console.log(parent);
//	dialog = parent.$.modalDialog({
//		title:'任务列表',
//		height:$(window).height() * 0.8,
//		width:$(window).width() * 0.8,
//		url:addUrl,
//		buttons:[{
//			text:'保存',
//			handler:function(){
//				
//			}
//		}]
//	})
}