var uploader = Qiniu.uploader({
    runtimes: 'html5,flash,html4',      // 上传模式，依次退化
    browse_button: 'uploadButton',         // 上传选择的点选按钮，必需
    uptoken_url: '/cms/getUploadToken',         // Ajax请求uptoken的Url，强烈建议设置（服务端提供）
    get_new_uptoken: false,             // 设置上传文件的时候是否每次都重新获取新的uptoken
    domain: 'http://ob06udlxs.bkt.clouddn.com',     // bucket域名，下载资源时用到，必需
    max_file_size: '100mb',             // 最大文件体积限制
    flash_swf_url: 'js/qiniu/Moxie.swf',  //引入flash，相对路径
    max_retries: 3,                     // 上传失败最大重试次数
    dragdrop: true,                     // 开启可拖曳上传
    drop_element: 'uploadElement',          // 拖曳上传区域元素的ID，拖曳文件或文件夹后可触发上传
    chunk_size: '4mb',                  // 分块上传时，每块的体积
    auto_start: true,                   // 选择文件后自动上传，若关闭需要自己绑定事件触发上传
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
           $("#cfg_logoImg").attr('src',sourceLink); 
           $('input[name="cfg_logo"]').val(sourceLink);
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
var uploader2 = Qiniu.uploader({
    runtimes: 'html5,flash,html4',      // 上传模式，依次退化
    browse_button: 'uploadcfg_wxewm',         // 上传选择的点选按钮，必需
    uptoken_url: '/cms/getUploadToken',         // Ajax请求uptoken的Url，强烈建议设置（服务端提供）
    get_new_uptoken: false,             // 设置上传文件的时候是否每次都重新获取新的uptoken
    domain: 'http://ob06udlxs.bkt.clouddn.com',     // bucket域名，下载资源时用到，必需
    max_file_size: '100mb',             // 最大文件体积限制
    flash_swf_url: 'js/qiniu/Moxie.swf',  //引入flash，相对路径
    max_retries: 3,                     // 上传失败最大重试次数
    dragdrop: true,                     // 开启可拖曳上传
    drop_element: 'cfg_wxewmElement',          // 拖曳上传区域元素的ID，拖曳文件或文件夹后可触发上传
    chunk_size: '4mb',                  // 分块上传时，每块的体积
    auto_start: true,                   // 选择文件后自动上传，若关闭需要自己绑定事件触发上传
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
           $("#cfg_wxewmImg").attr('src',sourceLink); 
           $('input[name="cfg_wxewm"]').val(sourceLink);
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
	    url : '/cms/selectSystem',
	    dataType : 'json',
	    contentType: "application/x-www-form-urlencoded; charset=utf-8", 
	    success : function(data) {
	      if(data.code==200){
    	  	$('input[name="cfg_webname"]').val(data.data.cfg_webname);
	    	$('input[name="cfg_rxdianhua"]').val(data.data.cfg_rxdianhua);
	    	$('input[name="cfg_zxdianhua"]').val(data.data.cfg_zxdianhua);
	    	$('input[name="cfg_kfqq"]').val(data.data.cfg_kfqq);
	    	$('input[name="cfg_logo"]').val(data.data.cfg_logo);
	    	$('input[name="cfg_wxewm"]').val(data.data.cfg_wxewm);
	    	$("#cfg_wxewmImg").attr('src',data.data.cfg_wxewm); 
	    	$("#cfg_logoImg").attr('src',data.data.cfg_logo); 
	      }else{
	    	  alert("查询失败");
	      }
	    },
	    error : function() {
	    	alert("系统错误");
	    }
	  });
}); 
function modifySystem(){
	$.ajax({
	    type : 'POST',
	    url : '/cms/updateSystem',
	    contentType: "application/x-www-form-urlencoded; charset=utf-8", 
	    dataType : 'json',
	    data:{
	    	cfg_webname:$('input[name="cfg_webname"]').val(),
	    	cfg_rxdianhua:$('input[name="cfg_rxdianhua"]').val(),
	    	cfg_zxdianhua:$('input[name="cfg_zxdianhua"]').val(),
	    	cfg_kfqq :$('input[name="cfg_kfqq"]').val(),
	    	cfg_logo :$('input[name="cfg_logo"]').val(),
	    	cfg_wxewm :$('input[name="cfg_wxewm"]').val()
	    },
	    success : function(data) {
	      if(data.code==200){
	    	  alert("修改成功");
	      }else{
	    	  alert("修改失败");
	      }
	    },
	    error : function() {
	    	alert("系统错误");
	    }
	  });
}
