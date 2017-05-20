/**
 * tinymce plugin
 * Created by jerry on 16/8/5.
 */
tinymce.PluginManager.add('uploadimage', function (editor) {
    function selectLocalImages() {
    document.getElementById("uploadButton1").click();
    }

    editor.addCommand("mceUploadImageEditor", selectLocalImages);

    editor.addButton('uploadimage', {
        icon: 'image',
        tooltip: '上传图片',
        onclick: selectLocalImages
    });

    editor.addMenuItem('uploadimage', {
        icon: 'image',
        text: '上传图片',
        context: 'tools',
        onclick: selectLocalImages
    });
});

var upload2 = Qiniu.uploader({
    runtimes: 'html5,flash,html4',      // 上传模式，依次退化
    browse_button: 'uploadButton1',         // 上传选择的点选按钮，必需
    uptoken_url: '/cms/getUploadToken',         // Ajax请求uptoken的Url，强烈建议设置（服务端提供）
    get_new_uptoken: false,             // 设置上传文件的时候是否每次都重新获取新的uptoken
    domain: 'http://ob06udlxs.bkt.clouddn.com',     // bucket域名，下载资源时用到，必需
    max_file_size: '100mb',             // 最大文件体积限制
    flash_swf_url: 'js/qiniu/Moxie.swf',  //引入flash，相对路径
    max_retries: 3,                     // 上传失败最大重试次数
    dragdrop: false,                     // 开启可拖曳上传
   //drop_element: 'textarea',          // 拖曳上传区域元素的ID，拖曳文件或文件夹后可触发上传
    chunk_size: '4mb',                  // 分块上传时，每块的体积
    auto_start: true,                   // 选择文件后自动上传，若关闭需要自己绑定事件触发上传
    init: {
        'FilesAdded': function(up, files) {
            plupload.each(files, function(file) {
            });
        },
        'BeforeUpload': function(up, file) {
        },
        'UploadProgress': function(up, file) {
        },
        'FileUploaded': function(up, file, info) {
        	 var domain = up.getOption('domain');
             info = eval('(' + info + ')'); 
             var sourceLink = domain +"/"+ info.key;
             tinymce.activeEditor.selection.setContent(tinymce.activeEditor.dom.createHTML('img', {src: sourceLink}));
        },
        'Error': function(up, err, errTip) {
        },
        'UploadComplete': function() {
        },
    }
});
