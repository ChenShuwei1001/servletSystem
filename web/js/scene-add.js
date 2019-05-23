$(document).ready(function () {
    //页面加载请求数据加载Option
    $("#Scene-add-button").click(function () {
        debugger;
        if($("#beginTime").val()>$("#endTime").val()){
            alert("格式出错，请重新输入");
            $("input").html("");
        }
        else {
            $.ajax({
                type: "POST",
                url: "/SceneAdd",
                async: false,
                data: {
                    "Sno": $("#Sno").val(),
                    "Mno": $("#Mno").val(),
                    "Tno": $("#Tno").val(),
                    "Tbrand": $("#Tbrand").val(),
                    "beginTime": $("#beginTime").val(),
                    "endTime": $("#endTime").val(),
                    "language": $("#language").val(),
                    "roomType": $("#roomType").val(),
                    "roomName": $("#roomName").val(),
                    "location": $("#location").val(),
                    "Sdate": $("#location").val(),
                    "Price": $("#Price").val()
                },
                dataType: "json",
                success: function (data) {
                    debugger;
                    if (data === false) {
                        alert("传送失败")
                    } else if (data === true) {
                        alert("状态：插入成功");
                        // alert("data:" + data);
                        Myclose();
                    }
                },
                error: function () {
                    alert("传送失败")
                }
            })
        }
        function  Myclose() {
            window.opener=null;window.open('','_self');window.close();
        }
    })
});