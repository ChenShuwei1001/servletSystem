
    debugger;
    $.ajax({
        type: "Get",
        url: "SceneShow",
        async: false,
        data:{"Sno":"ALL"},
        dataType: "json",
        success: function (data,stu) {
            // alert("状态：加载成功");
            // alert("data:"+data[0]["Sno"]);

            showdata(data)

        },
        error:function (data) {
            alert("数据初始化失败，请查看数据库是否存在数据");
        }
    })
    $("#Sno-button").click(function () {
        if($("#Sno").val()==""){
            alert("请不要输入空")
        }
        else
            $.ajax({
                type: "Get",
                url: "SceneShow",
                async: false,
                data: {"Sno": $("#Sno").val()},
                dataType: "json",
                success: function (data,stu) {
                    // alert("状态：",stu);
                    // alert("data:"+data[0]["Sno"]);
                    showdata(data)
                }
            })
    })
    function  showdata(data) {
        debugger;
        $("#SceneNum").text(data.length);
        $("table tbody").html("");
        var tempHtml = "";


        for(var i = 0; i< data.length; i++)
        {


            var sno=data[i]["sno"];
            var mno=data[i]["mno"];
            var tno=data[i]["tno"];
            var tbrand=data[i]["tbrand"];
            var beginTime=data[i]["beginTime"];
            var endTime=data[i]["endTime"];
            var language=data[i]["language"];
            var roomType=data[i]["roomType"];
            var roomName=data[i]["roomName"];
            var location=data[i]["location"];
            var sdate=data[i]["sdate"];
            var seat=data[i]["seat"];
            var price=data[i]["price"];

            // Ename,time,piaofang,path,director,actor,type,place,shangyitime,score,numpeople,jianjie

            localStorage.setItem("sno",data[i]["sno"]);
            localStorage.setItem("mno",data[i]["mno"]);
            localStorage.setItem("tno",data[i]["tno"]);
            localStorage.setItem("tbrand",data[i]["tbrand"]);
            localStorage.setItem("beginaTime",data[i]["beginTime"]);
            localStorage.setItem("endTime",data[i]["endTime"]);
            localStorage.setItem("roomType",data[i]["roomType"]);
            localStorage.setItem("roomName",data[i]["roomName"]);
            localStorage.setItem("location",data[i]["location"]);
            localStorage.setItem("sdate",data[i]["sdate"]);
            localStorage.setItem("seat",data[i]["seat"]);
            localStorage.setItem("price",data[i]["price"]);

            tempHtml += "<tr><td>" +
                "              <div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\" data-id='2'><i class=\"layui-icon\">&#xe605;</i></div>\n" +
                "            </td>"+
                "<td>"+data[i]["sno"]+"</td>" +
                "<td>"+data[i]["mno"]+"</td>" +
                "<td>"+data[i]["tno"]+"</td>" +
                "<td>"+data[i]["tbrand"]+"</td>" +
                "<td>"+data[i]["beginTime"]+"</td>" +
                "<td>"+data[i]["endTime"]+"</td>" +
                "<td>"+data[i]["language"]+"</td>" +
                "<td>"+data[i]["roomType"]+"</td>" +
                "<td>"+data[i]["roomName"]+"</td>" +
                "<td>"+data[i]["location"]+"</td>" +
                "<td>"+data[i]["sdate"]+"</td>" +
                "<td>"+data[i]["seat"]+"</td>" +
                "<td>"+data[i]["price"]+"</td>" +
                "<td><button onclick=\"deleteSceneItem('"+sno+"')\">删除</button></td>" +
                "<td><button id='alterbutton' onclick=\"modify('"+
                sno+"','"+
                mno+"','"+
                tno+"','"+
                tbrand+"','"+
                beginTime+"','"+
                endTime+"','"+
                language+"','"+
                roomType+"','"+
                roomName+"','"+
                location+"','"+
                sdate+"','"+
                seat+"','"+
                price+"')\">修改Info</button>" +
                "</td>";
                "</tr>";
        }
        $("table").append(tempHtml); //添加你拼接好的html到table里


    }

function modify( sno, mno, tno, tbrand, beginTime,endTime,language,
                 roomType,
                 roomName,
                 location,
                 sdate,
                 seat,
                 price){
    localStorage.setItem("sno",sno);
    localStorage.setItem("mno",mno);
    localStorage.setItem("tno",tno);
    localStorage.setItem("tbrand",tbrand);
    localStorage.setItem("beginTime",beginTime);
    localStorage.setItem("endTime",endTime);
    localStorage.setItem("language",language);
    localStorage.setItem("roomType",roomType);
    localStorage.setItem("roomName",roomName);
    localStorage.setItem("location",location);
    localStorage.setItem("sdate",sdate);
    localStorage.setItem("seat",seat);
    localStorage.setItem("price",price);
    debugger;
    x_admin_show('更换海报','/scene-modify.html',600,400);
}

function deleteSceneItem(sno) {
    // alert("hello");
    debugger;
    if(confirm("确定删除?\n编号："+sno)){
        // alert(arrM[1]);
        $.ajax({
            type: "Get",
            url: "/Scene_delete",
            async: false,
            data:{'Sno':sno},
            dataType: "json",
            success:function (data) {
                // alert("删除成功");
            },
            error:function (data) {
                // alert("失败");
            }
        })
    }
}