var t
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
  t = $('.datatable').DataTable({
	  "sDom": "<'row mb-1'<'col-sm-6'l><'col-sm-6'f>r>t<'row'<'col-sm-6'i><'col-sm-6 center'p>>",
	    renderer: 'bootstrap',
	    ordering:false,   //禁止排序
	  ajax: {
          //指定数据源
		  type: "POST",
          url: "/cms/listArchives",
      },
      columns: [{
          "data": "id" //此列不绑定数据源，用来显示序号
      },
      {
          "data": "title"
      },
      {
          "data": "litpic"
      },
      {
          "data": "keywords"
      },{
    	  "data": "description"
      }
      ],
      "columnDefs": [{
          "render": function(data, type, row, meta) {
    		  return '<img class="typo_img" src="'+row.litpic+'" style="width: 101px; height: 100px;">';
          },
      	"targets": 2	
      },
      {
          "render": function(data, type, row, meta) {
        		  return "<button class='btn btn-outline-success' onclick=loadPage('forms/archivesModify.html?archivesId="+row.id+"')>修改</button><button class='btn btn-outline-success' onclick=deleteArchives('"+row.id+"')>删除</button>";
          },
      	"targets": 5	
      }]
  });
/*
  //更换数据源（相同格式，但是数据内容不同）
  $("#redraw").click(function() {
      var url = table.api().ajax.url("http://www.gbtags.com/gb/networks/uploads/a7bdea3c-feaf-4bb5-a3bd-f6184c19ec09/newData.txt");
      url.load();
  });*/
});

function deleteArchives(id){
	$.ajax({
	    type : 'POST',
	    url : '/cms/deleteArchives',
	    contentType: "application/x-www-form-urlencoded; charset=utf-8", 
	    dataType : 'json',
	    data:{
	    	archivesId:id
	    },
	    success : function(data) {
	      if(data.code==200){
	    	  t.ajax.reload();
	    	  alert("删除成功");
	      }else{
	    	  alert("删除失败");
	      }
	    },
	    error : function() {
	      window.location.href = $.page404;
	    }
	  });
}
