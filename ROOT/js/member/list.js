var grid;
var dialog;
var list;
var listUrl = "/member/listMember";
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
		}]],
//		onBeforeLoad: function(row, param) {},
		toolbar:[
		    { text: '增加', iconCls: 'icon-add', handler: function () {} }
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