var uploader = Qiniu.uploader({
    runtimes: 'html5,flash,html4',      // 上传模式，依次退化
    browse_button: 'uploadButton',         // 上传选择的点选按钮，必需
    // 在初始化时，uptoken，uptoken_url，uptoken_func三个参数中必须有一个被设置
    // 切如果提供了多个，其优先级为uptoken > uptoken_url > uptoken_func
    // 其中uptoken是直接提供上传凭证，uptoken_url是提供了获取上传凭证的地址，如果需要定制获取uptoken的过程则可以设置uptoken_func
    // uptoken : '<Your upload token>', // uptoken是上传凭证，由其他程序生成
    uptoken_url: '/cms/getUploadToken',         // Ajax请求uptoken的Url，强烈建议设置（服务端提供）
    // uptoken_func: function(file){    // 在需要获取uptoken时，该方法会被调用
    //    // do something
    //    return uptoken;
    // },
    get_new_uptoken: false,             // 设置上传文件的时候是否每次都重新获取新的uptoken
    // downtoken_url: '/downtoken',
    // Ajax请求downToken的Url，私有空间时使用，JS-SDK将向该地址POST文件的key和domain，服务端返回的JSON必须包含url字段，url值为该文件的下载地址
    // unique_names: true,              // 默认false，key为文件名。若开启该选项，JS-SDK会为每个文件自动生成key（文件名）
    // save_key: true,                  // 默认false。若在服务端生成uptoken的上传策略中指定了sava_key，则开启，SDK在前端将不对key进行任何处理
    domain: 'http://ob06udlxs.bkt.clouddn.com',     // bucket域名，下载资源时用到，必需
    //container: 'container',             // 上传区域DOM ID，默认是browser_button的父元素
    max_file_size: '100mb',             // 最大文件体积限制
    flash_swf_url: 'js/qiniu/Moxie.swf',  //引入flash，相对路径
    max_retries: 3,                     // 上传失败最大重试次数
    dragdrop: true,                     // 开启可拖曳上传
    drop_element: 'litpicImg',          // 拖曳上传区域元素的ID，拖曳文件或文件夹后可触发上传
    chunk_size: '4mb',                  // 分块上传时，每块的体积
    auto_start: true,                   // 选择文件后自动上传，若关闭需要自己绑定事件触发上传
    //x_vars : {
    //    查看自定义变量
    //    'time' : function(up,file) {
    //        var time = (new Date()).getTime();
              // do something with 'time'
    //        return time;
    //    },
    //    'size' : function(up,file) {
    //        var size = file.size;
              // do something with 'size'
    //        return size;
    //    }
    //},
    init: {
        'FilesAdded': function(up, files) {
            plupload.each(files, function(file) {
                // 文件添加进队列后，处理相关的事情
            });
        },
        'BeforeUpload': function(up, file) {
               // 每个文件上传前，处理相关的事情
        },
        'UploadProgress': function(up, file) {
               // 每个文件上传时，处理相关的事情
        },
        'FileUploaded': function(up, file, info) {
           // 每个文件上传成功后，处理相关的事情
           // 其中info是文件上传成功后，服务端返回的json，形式如：
           // {
           //    "hash": "Fh8xVqod2MQ1mocfI4S4KpRL6D98",
           //    "key": "gogopher.jpg"
           //  }
           // 查看简单反馈
        	var domain = up.getOption('domain');
           info = eval('(' + info + ')'); 
           var sourceLink = domain +"/"+ info.key;
           $("#litpicImg").attr('src',sourceLink); 
           $('input[name="litpic"]').val(sourceLink);
        	
        },
        'Error': function(up, err, errTip) {
               //上传出错时，处理相关的事情
        },
        'UploadComplete': function() {
               //队列文件处理完毕后，处理相关的事情
        },
        /*'Key': function(up, file) {
            // 若想在前端对每个文件的key进行个性化处理，可以配置该函数
            // 该配置必须要在unique_names: false，save_key: false时才生效

            var key = "";
            // do something with key here
            return key
        }*/
    }
});

$(function(){ 
	$.ajax({
	    type : 'POST',
	    url : '/cms/seleteArchives',
	    dataType : 'json',
	    contentType: "application/x-www-form-urlencoded; charset=utf-8", 
	    data:{
	    	archivesId:GetQueryString('archivesId')
	    },
	    success : function(data) {
	      if(data.code==200){
    	  	$('input[name="id"]').val(data.data.id);
	    	$('input[name="title"]').val(data.data.title);
	    	$('select[name="typeid"]').val(data.data.typeid);
	    	$('input[name="keywords"]').val(data.data.keywords);
	    	$('input[name="litpic"]').val(data.data.litpic);
	    	$("#litpicImg").attr('src',data.data.litpic); 
	    	$('input[name="description"]').val(data.data.description);
	    	tinymce.activeEditor.setContent(data.data.body);
	      }else{
	    	  alert("查询失败");
	      }
	    },
	    error : function() {
	      alert("系统错误");
	    }
	  });
}); 
function modifyArchives(){
	$.ajax({
	    type : 'POST',
	    url : '/cms/modifyArchives',
	    contentType: "application/x-www-form-urlencoded; charset=utf-8", 
	    dataType : 'json',
	    data:{
	    	id:$('input[name="id"]').val(),
	    	title:$('input[name="title"]').val(),
	    	typeid:$('select[name="typeid"]').val(),
	    	keywords :$('input[name="keywords"]').val(),
	    	litpic :$('input[name="litpic"]').val(),
	    	description:tinymce.activeEditor.getContent( { 'format' : 'text' }),
	    	body:tinymce.activeEditor.getContent()
	    },
	    success : function(data) {
	      if(data.code==200){
	    	  loadPage('plugins/archivesList.html');
	      }else{
	    	  alert("修改失败");
	      }
	    },
	    error : function() {
	    	 alert("系统错误");
	    }
	  });
}
