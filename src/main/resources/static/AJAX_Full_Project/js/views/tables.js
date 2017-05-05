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
	    serverSide: true,  //启用服务器端分页
	    searching: false,  //禁用原生搜索
	    ordering:false,   //禁止排序
	  ajax: {
          //指定数据源
		  type: "POST",
          url: "/cms/listArctype",
      },
      //每页显示三条数据
      pageLength: 3,
      columns: [{
          "data": "typename" //此列不绑定数据源，用来显示序号
      },
      {
          "data": "topid"
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
     /* "columnDefs": [{
          // "visible": false,
          //"targets": 0
      },
      {
          "render": function(data, type, row, meta) {
              //渲染 把数据源中的标题和url组成超链接
              return '<a href="' + data + '" target="_blank">' + row.title + '</a>';
          },
          //指定是第三列
          "targets": 2
      }]
*/
  });
/*
  //更换数据源（相同格式，但是数据内容不同）
  $("#redraw").click(function() {
      var url = table.api().ajax.url("http://www.gbtags.com/gb/networks/uploads/a7bdea3c-feaf-4bb5-a3bd-f6184c19ec09/newData.txt");
      url.load();
  });*/
});
