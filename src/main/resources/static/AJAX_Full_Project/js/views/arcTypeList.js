$(function(){
 /* $('.datatable').dataTable({
    "sDom": "<'row mb-1'<'col-sm-6'l><'col-sm-6'f>r>t<'row'<'col-sm-6'i><'col-sm-6 center'p>>",
    renderer: 'bootstrap',
    serverSide: true,  //启用服务器端分页
    searching: false,  //禁用原生搜索
    // "oLanguage": {
    //   "sLengthMenu": "_MENU_ records per page"
    // }
  });*/
  /*Javascript代码片段*/
  var t = $('.datatable').DataTable({
	  "sDom": "<'row mb-1'<'col-sm-6'l><'col-sm-6'f>r>t<'row'<'col-sm-6'i><'col-sm-6 center'p>>",
	    renderer: 'bootstrap',
	    ordering:false,   //禁止排序
	  ajax: {
          //指定数据源
		  type: "POST",
          url: "/cms/listArctype",
      },
      columns: [{
          "data": "id" //此列不绑定数据源，用来显示序号
      },
      {
          "data": "typename"
      },
      {
          "data": "content"
      },
      {
          "data": "ishidden"
      },{
    	  "data": "ishidden"
      }
      ],
      "columnDefs": [{
          "render": function(data, type, row, meta) {
        	  if(row.ishidden==0){
        		  return "显示";
        	  }else{
        		  return "隐藏";
        	  }
          },
      	"targets": 3	
      },
      {
          "render": function(data, type, row, meta) {
        		  return "<button class='btn btn-outline-success' onclick=loadPage('forms/arcTypeModify.html?arcTypeId="+row.id+"')>修改</button>";
          },
      	"targets": 4	
      }]
  });
/*
  //更换数据源（相同格式，但是数据内容不同）
  $("#redraw").click(function() {
      var url = table.api().ajax.url("http://www.gbtags.com/gb/networks/uploads/a7bdea3c-feaf-4bb5-a3bd-f6184c19ec09/newData.txt");
      url.load();
  });*/
});
