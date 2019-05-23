window.onload=function (){
    var form_data = localStorage.getItem('searchMovie');
    $.ajax({
        type: "POST",
        dataType: "json",//服务器返回的数据类型
        contentType: "application/json",//post请求的信息格式
        url: "/users/login",
        data: form_data,
        success: function (data) {
            showSearchMovieList(data)
        },
        error: function () {
            alert("连接服务器失败！");
        }
    });
};

function showSearchMovieList(data) {

}
