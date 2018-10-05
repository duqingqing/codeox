function showBlog() {
    var blog_list = window.document.getElementById("blog_list");
    var blog;
    var blog_title;
    var blog_content;
    var blog_modified_time;
    var blog_author;
    var blog_readers;
    var blogList;
    var basePath = [[${#httpServletRequest.getScheme() + "://" + #httpServletRequest.getServerName() + ":" + #httpServletRequest.getServerPort() + #httpServletRequest.getContextPath()}]];
    alert(basePath);
    if (blog_list) {
        $.ajax({
            type: "get",
            dataType: "json",
            url: basePath + '/blog/list',
            success: function (msg) {
                for (var i = 0; i < msg.length; i++) {
                    blog = msg[i];
                    blog_modified_time = blog.dateModified;
                    blog_title = blog.title;
                    console.log(blog_title);
                    blog_content = blog.content;
                    blog_author = blog.author.username;
                    blog_readers = blog.readers;
                    var oneBlog = "<div class=\"panel panel-default\">\n" +
                        "  <div class=\"panel-heading\"><h3>" + blog_title + "</h3></div>\n" +
                        "  <div class=\"panel-body\">\n" +
                        "    " + blog_content + "\n" +
                        "  </div>\n" +
                        "   <div class=\"panel-footer\">\n" +
                        "   <span class=\"label label-success\">作者</span>\n" +
                        "   <span class=\"label label-info\">" + blog_author + "</span>\n" +
                        "   <span class=\"label label-success\">发布时间</span>\n" +
                        "   <span class=\"label label-info\">" + blog_modified_time + "</span>\n" +
                        "   <span class=\"label label-success\">阅读次数<span class=\"badge\">" + blog_readers + "</span></span>\n" +
                        "   </div>\n" +
                        "</div>";
                    blogList = blogList + oneBlog;
                }
                blog_list.innerHTML = blogList;
            }
        });
    } else {
        error: function error() {
            alert("没有blog_title节点");
        }
    }
}