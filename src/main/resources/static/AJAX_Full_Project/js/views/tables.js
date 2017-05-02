$(function(){
  $('.datatable').dataTable({
    "sDom": "<'row mb-1'<'col-sm-6'l><'col-sm-6'f>r>t<'row'<'col-sm-6'i><'col-sm-6 center'p>>",
    renderer: 'bootstrap',
    serverSide: true,  //启用服务器端分页
    searching: false,  //禁用原生搜索
    // "oLanguage": {
    //   "sLengthMenu": "_MENU_ records per page"
    // }
  });
});
