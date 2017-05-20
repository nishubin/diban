$(function(){ 
	$.ajax({
	    type : 'POST',
	    url : '/cms/seleteArctype',
	    dataType : 'json',
	    contentType: "application/x-www-form-urlencoded; charset=utf-8", 
	    data:{
	    	arctypeId:GetQueryString('arcTypeId')
	    },
	    success : function(data) {
	      if(data.code==200){
	    	  $('input[name="typename"]').val(data.data.typename);
	    	  $('input[name="id"]').val(data.data.id);
	    	  if(data.data.ishidden==1){
	    		  $('input[name="ishidden"]').attr("checked", false); 
	    	  }else{
	    		  $('input[name="ishidden"]').attr("checked", true); 
	    	  }
	    	  tinymce.activeEditor.setContent(data.data.content);
	      }else{
	    	  alert("查询失败");
	      }
	    },
	    error : function() {
	      alert("系统错误");
	    }
	  });
}); 
function modifyArcType(){
	var ishidden ="0";
	if($('input[name="ishidden"]').val()=="off"){
		ishidden="1";
	}
	$.ajax({
	    type : 'POST',
	    url : '/cms/modifyArctype',
	    contentType: "application/x-www-form-urlencoded; charset=utf-8", 
	    dataType : 'json',
	    data:{
	    	id:$('input[name="id"]').val(),
	    	ishidden:ishidden,
	    	typename :$('input[name="typename"]').val(),
			content:tinymce.activeEditor.getContent()
	    },
	    success : function(data) {
	      if(data.code==200){
	    	  loadPage('plugins/arcTypeList.html');
	      }else{
	    	  alert("修改失败");
	      }
	    },
	    error : function() {
	      alert("系统错误");
	    }
	  });
}