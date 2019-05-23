$(document).ready(function () {
    debugger;
    $.ajax({
        type: "Get",
        url: "WelcomeServlet",
        async: false,
        data:{"First":"ALL"},
        dataType: "json",
        success: function (data,stu) {

            if(data.length<=0){
                error();
            }
            else
                // alert("状态：加载成功");
            showdata(data);
        },
        error:function (data) {
            alert("状态：加载失败");
        }
    })
    function showdata(data) {
        var k=10;
        $("cite:last").text(k);
        debugger;
        var w=data["MoviesNum"]
        $("#OrderNum1").text(data["OrderNum"]);
        $("#MovieNum1").text(data["MoviesNum"]);
        $("#SceneNum1").text(data["SceneNum"]);
        $("#UserNum1").text(data["UserNum"]);
        $("#TheatNum1").text(data["TheaterNum"]);

    }
})