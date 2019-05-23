$(document).ready(function () {
    // debugger;
    alldshow();
    // $.ajax({
    //     type: "Get",
    //     url: "/Admin_LoadData_movie_list",
    //     async: false,
    //     dataType: "json",
    //     success: function (data,txtstuts) {
    //
    //         debugger;
    //
    //         setSumData(data.length);
    //         //静态测试
    //         for(var i=0;i<data.length;i++){
    //             var movieListTable=document.getElementById("movie-list-show");
    //             var rowLength=movieListTable.rows.length;
    //             var tableRow=movieListTable.insertRow(rowLength);
    //             var moviePosterPath=data[i]["MposterPath"];
    //             // var moviePosterPath="F:/myCode/411movieSystemImage/0abc.jpg";
    //             // debugger;
    //             // var moviePosterPath2=moviePosterPath.substring(moviePosterPath.index("web"),moviePosterPath.end());
    //             // var inde=moviePosterPath.indexOf("image/");
    //             // var moviePosterPath2=moviePosterPath.substr(inde);
    //
    //
    //             var no=data[i]["Mno"];
    //             var name=data[i]["Mname"];
    //             var Ename=data[i]["MEnglishName"];
    //             var piaofang=data[i]["MboxOffice"];
    //             var path=data[i]["MposterPath"];
    //             var director=data[i]["Mdirector"];
    //             var actor=data[i]["actor"];
    //             var type=data[i]["Mtype"];
    //             var language=data[i]["Mlanguage"]
    //             var place=data[i]["Mlocation"];
    //             var shangyitime=data[i]["Mdate"];
    //             var score=data[i]["Mrating"];
    //             var numpeople=data[i]["MscoreNumber"];
    //             var jianjie=data[i]["Mintroduction"];
    //             var time=data[i]["Mduration"];
    //
    //
    //             // Ename,time,piaofang,path,director,actor,type,place,shangyitime,score,numpeople,jianjie
    //
    //             localStorage.setItem("movieParamPath",moviePosterPath);
    //             localStorage.setItem("movieNO",data[i]["Mno"]);
    //             localStorage.setItem("movieName",data[i]["Mname"]);
    //             localStorage.setItem("movieNEnglish",data[i]["MEnglishName"]);
    //             localStorage.setItem("movieNDuration",data[i]["Mduration"]);
    //             localStorage.setItem("movieNOffice",data[i]["MboxOffice"]);
    //             localStorage.setItem("movieNDirector",data[i]["Mdirector"]);
    //             localStorage.setItem("movieNActor",data[i]["actor"]);
    //             localStorage.setItem("movieNType",data[i]["Mtype"]);
    //             localStorage.setItem("movieNLanguage",data[i]["Mlanguage"]);
    //             localStorage.setItem("movieNLocation",data[i]["Mlocation"]);
    //             localStorage.setItem("movieNDate",data[i]["Mdate"]);
    //             localStorage.setItem("movieNRating",data[i]["Mrating"]);
    //             localStorage.setItem("movieNNumber",data[i]["MscoreNumber"]);
    //             localStorage.setItem("movieNIntroduction",data[i]["Mintroduction"]);
    //             var Mnnno=data[i]["Mno"];
    //             // alert(Mnnno);
    //             console.log(Mnnno);
    //             console.log("001");
    //             var Mnname=data[i]["Mname"];
    //             var MnInfo=new Array(2);
    //             MnInfo[0]=data[i]["Mno"];
    //             MnInfo[1]=data[i]["Mname"];
    //             // language=HTML
    //             tableRow.innerHTML=
    //                 "<td>" +
    //                 "<div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\" data-id='2'><i class=\"layui-icon\">&#xe605;</i></div>" +
    //                 "</td>" +
    //                 // "<td>"+data[i]["MposterPath"]+"</td>" +
    //                 // "<td><img src=\"http://localhost:8080/servletSystem_war_exploded/image/abc.jpg\" alt=\"\"></td>" +
    //                 // "<td><img src=\"image/abc.jpg\" alt=\"\"></td>" +
    //                 "<td><img src='/ImageUtil_Admin?path="+moviePosterPath+"' alt=''></td>" +
    //                 "<tr>" +
    //                 "<td width='10'>"+data[i]["Mno"]+"</td>" +
    //                 "<td >"+data[i]["Mname"]+"</td>" +
    //                 "<td >"+data[i]["MEnglishName"]+"</td>" +
    //                 "<td>"+data[i]["Mduration"]+"</td>" +
    //                 "<td >"+data[i]["MboxOffice"]+"</td>" +
    //
    //
    //                 "<td >"+data[i]["Mdirector"]+"</td>" +
    //                 "<td >"+data[i]["actor"]+"</td>" +
    //                 "<td >"+data[i]["Mtype"]+"</td>" +
    //                 "<td >"+data[i]["Mlanguage"]+"</td>" +
    //                 "<td >"+data[i]["Mlocation"]+"</td>" +
    //                 "<td >"+data[i]["Mdate"]+"</td>" +
    //                 "<td >"+data[i]["Mrating"]+"</td>" +
    //                 "<td >"+data[i]["MscoreNumber"]+"</td>" +
    //                 "<td >"+data[i]["Mintroduction"]+"</td></tr>"+
    //                 "<td>" +
    //                 "<button onclick=\"deleteMovieItem('"+Mnnno+"','"+moviePosterPath+"')\">删除</button>" +
    //                 "<button id='alterbutton' onclick=\"alterInfo('"+moviePosterPath+"','"+Mnnno+"')\">修改海报</button>" +
    //                 "<button id='alterbutton' onclick=\"alterInfo2('"+
    //                 no+"','"+
    //                 name+"','"+
    //                 Ename+"','"+
    //                 time+"','"+
    //                 piaofang+"','"+
    //                 path+"','"+
    //                 director+"','"+
    //                 actor+"','"+
    //                 type+"','"+
    //                 language+"','"+
    //                 place+"','"+
    //                 shangyitime+"','"+
    //                 score+"','"+
    //                 numpeople+"','"+
    //                 jianjie+"')\">修改Info</button>" +
    //                 "</td>";
    //
    //             // no,name,Ename,time,piaofang,path,director,actor,type,place,shangyitime,score,numpeople,jianjie
    //
    //
    //         }
    //     }
    // })


});


function alldshow(){
    $.ajax({
        type: "Get",
        url: "/Admin_LoadData_movie_list",
        async: false,
        dataType: "json",
        success: function (data,txtstuts) {
            showData(data);
            // debugger;
            //
            // setSumData(data.length);
            // //静态测试
            // for(var i=0;i<data.length;i++){
            //     var movieListTable=document.getElementById("movie-list-show");
            //     var rowLength=movieListTable.rows.length;
            //     var tableRow=movieListTable.insertRow(rowLength);
            //     var moviePosterPath=data[i]["MposterPath"];
            //     // var moviePosterPath="F:/myCode/411movieSystemImage/0abc.jpg";
            //     // debugger;
            //     // var moviePosterPath2=moviePosterPath.substring(moviePosterPath.index("web"),moviePosterPath.end());
            //     // var inde=moviePosterPath.indexOf("image/");
            //     // var moviePosterPath2=moviePosterPath.substr(inde);
            //
            //
            //     var no=data[i]["Mno"];
            //     var name=data[i]["Mname"];
            //     var Ename=data[i]["MEnglishName"];
            //     var piaofang=data[i]["MboxOffice"];
            //     var path=data[i]["MposterPath"];
            //     var director=data[i]["Mdirector"];
            //     var actor=data[i]["actor"];
            //     var type=data[i]["Mtype"];
            //     var language=data[i]["Mlanguage"]
            //     var place=data[i]["Mlocation"];
            //     var shangyitime=data[i]["Mdate"];
            //     var score=data[i]["Mrating"];
            //     var numpeople=data[i]["MscoreNumber"];
            //     var jianjie=data[i]["Mintroduction"];
            //     var time=data[i]["Mduration"];
            //
            //
            //     // Ename,time,piaofang,path,director,actor,type,place,shangyitime,score,numpeople,jianjie
            //
            //     localStorage.setItem("movieParamPath",moviePosterPath);
            //     localStorage.setItem("movieNO",data[i]["Mno"]);
            //     localStorage.setItem("movieName",data[i]["Mname"]);
            //     localStorage.setItem("movieNEnglish",data[i]["MEnglishName"]);
            //     localStorage.setItem("movieNDuration",data[i]["Mduration"]);
            //     localStorage.setItem("movieNOffice",data[i]["MboxOffice"]);
            //     localStorage.setItem("movieNDirector",data[i]["Mdirector"]);
            //     localStorage.setItem("movieNActor",data[i]["actor"]);
            //     localStorage.setItem("movieNType",data[i]["Mtype"]);
            //     localStorage.setItem("movieNLanguage",data[i]["Mlanguage"]);
            //     localStorage.setItem("movieNLocation",data[i]["Mlocation"]);
            //     localStorage.setItem("movieNDate",data[i]["Mdate"]);
            //     localStorage.setItem("movieNRating",data[i]["Mrating"]);
            //     localStorage.setItem("movieNNumber",data[i]["MscoreNumber"]);
            //     localStorage.setItem("movieNIntroduction",data[i]["Mintroduction"]);
            //     var Mnnno=data[i]["Mno"];
            //     // alert(Mnnno);
            //     console.log(Mnnno);
            //     console.log("001");
            //     var Mnname=data[i]["Mname"];
            //     var MnInfo=new Array(2);
            //     MnInfo[0]=data[i]["Mno"];
            //     MnInfo[1]=data[i]["Mname"];
            //     // language=HTML
            //     tableRow.innerHTML=
            //         "<td>" +
            //         "<div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\" data-id='2'><i class=\"layui-icon\">&#xe605;</i></div>" +
            //         "</td>" +
            //         // "<td>"+data[i]["MposterPath"]+"</td>" +
            //         // "<td><img src=\"http://localhost:8080/servletSystem_war_exploded/image/abc.jpg\" alt=\"\"></td>" +
            //         // "<td><img src=\"image/abc.jpg\" alt=\"\"></td>" +
            //         "<td><img src='/ImageUtil_Admin?path="+moviePosterPath+"' alt=''></td>" +
            //         "<tr>" +
            //         "<td width='10'>"+data[i]["Mno"]+"</td>" +
            //         "<td >"+data[i]["Mname"]+"</td>" +
            //         "<td >"+data[i]["MEnglishName"]+"</td>" +
            //         "<td>"+data[i]["Mduration"]+"</td>" +
            //         "<td >"+data[i]["MboxOffice"]+"</td>" +
            //
            //
            //         "<td >"+data[i]["Mdirector"]+"</td>" +
            //         "<td >"+data[i]["actor"]+"</td>" +
            //         "<td >"+data[i]["Mtype"]+"</td>" +
            //         "<td >"+data[i]["Mlanguage"]+"</td>" +
            //         "<td >"+data[i]["Mlocation"]+"</td>" +
            //         "<td >"+data[i]["Mdate"]+"</td>" +
            //         "<td >"+data[i]["Mrating"]+"</td>" +
            //         "<td >"+data[i]["MscoreNumber"]+"</td>" +
            //         "<td >"+data[i]["Mintroduction"]+"</td></tr>"+
            //         "<td>" +
            //         "<button onclick=\"deleteMovieItem('"+Mnnno+"','"+moviePosterPath+"')\">删除</button>" +
            //         "<button id='alterbutton' onclick=\"alterInfo('"+moviePosterPath+"','"+Mnnno+"')\">修改海报</button>" +
            //         "<button id='alterbutton' onclick=\"alterInfo2('"+
            //         no+"','"+
            //         name+"','"+
            //         Ename+"','"+
            //         time+"','"+
            //         piaofang+"','"+
            //         path+"','"+
            //         director+"','"+
            //         actor+"','"+
            //         type+"','"+
            //         language+"','"+
            //         place+"','"+
            //         shangyitime+"','"+
            //         score+"','"+
            //         numpeople+"','"+
            //         jianjie+"')\">修改Info</button>" +
            //         "</td>";
            //
            //     // no,name,Ename,time,piaofang,path,director,actor,type,place,shangyitime,score,numpeople,jianjie
            //
            //
            // }
        }
    })
}

function showData(data){
    debugger;



    setSumData(data.length);
    //静态测试
    for(var i=0;i<data.length;i++){
        var movieListTable=document.getElementById("movie-list-show");
        var rowLength=movieListTable.rows.length;
        var tableRow=movieListTable.insertRow(rowLength);
        var moviePosterPath=data[i]["MposterPath"];
        // var moviePosterPath="F:/myCode/411movieSystemImage/0abc.jpg";
        // debugger;
        // var moviePosterPath2=moviePosterPath.substring(moviePosterPath.index("web"),moviePosterPath.end());
        // var inde=moviePosterPath.indexOf("image/");
        // var moviePosterPath2=moviePosterPath.substr(inde);


        var no=data[i]["Mno"];
        var name=data[i]["Mname"];
        var Ename=data[i]["MEnglishName"];
        var piaofang=data[i]["MboxOffice"];
        var path=data[i]["MposterPath"];
        var director=data[i]["Mdirector"];
        var actor=data[i]["actor"];
        var type=data[i]["Mtype"];
        var language=data[i]["Mlanguage"]
        var place=data[i]["Mlocation"];
        var shangyitime=data[i]["Mdate"];
        var score=data[i]["Mrating"];
        var numpeople=data[i]["MscoreNumber"];
        var jianjie=data[i]["Mintroduction"];
        var time=data[i]["Mduration"];


        // Ename,time,piaofang,path,director,actor,type,place,shangyitime,score,numpeople,jianjie

        localStorage.setItem("movieParamPath",moviePosterPath);
        localStorage.setItem("movieNO",data[i]["Mno"]);
        localStorage.setItem("movieName",data[i]["Mname"]);
        localStorage.setItem("movieNEnglish",data[i]["MEnglishName"]);
        localStorage.setItem("movieNDuration",data[i]["Mduration"]);
        localStorage.setItem("movieNOffice",data[i]["MboxOffice"]);
        localStorage.setItem("movieNDirector",data[i]["Mdirector"]);
        localStorage.setItem("movieNActor",data[i]["actor"]);
        localStorage.setItem("movieNType",data[i]["Mtype"]);
        localStorage.setItem("movieNLanguage",data[i]["Mlanguage"]);
        localStorage.setItem("movieNLocation",data[i]["Mlocation"]);
        localStorage.setItem("movieNDate",data[i]["Mdate"]);
        localStorage.setItem("movieNRating",data[i]["Mrating"]);
        localStorage.setItem("movieNNumber",data[i]["MscoreNumber"]);
        localStorage.setItem("movieNIntroduction",data[i]["Mintroduction"]);
        var Mnnno=data[i]["Mno"];
        // alert(Mnnno);
        console.log(Mnnno);
        console.log("001");
        var Mnname=data[i]["Mname"];
        var MnInfo=new Array(2);
        MnInfo[0]=data[i]["Mno"];
        MnInfo[1]=data[i]["Mname"];
        // language=HTML
        tableRow.innerHTML=
            "<td>" +
            "<div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\" data-id='2'><i class=\"layui-icon\">&#xe605;</i></div>" +
            "</td>" +
            // "<td>"+data[i]["MposterPath"]+"</td>" +
            // "<td><img src=\"http://localhost:8080/servletSystem_war_exploded/image/abc.jpg\" alt=\"\"></td>" +
            // "<td><img src=\"image/abc.jpg\" alt=\"\"></td>" +
            "<td><img src='/ImageUtil_Admin?path="+moviePosterPath+"' alt=''></td>" +
            "<tr>" +
            "<td width='10'>"+data[i]["Mno"]+"</td>" +
            "<td >"+data[i]["Mname"]+"</td>" +
            "<td >"+data[i]["MEnglishName"]+"</td>" +
            "<td>"+data[i]["Mduration"]+"</td>" +
            "<td >"+data[i]["MboxOffice"]+"</td>" +


            "<td >"+data[i]["Mdirector"]+"</td>" +
            "<td >"+data[i]["actor"]+"</td>" +
            "<td >"+data[i]["Mtype"]+"</td>" +
            "<td >"+data[i]["Mlanguage"]+"</td>" +
            "<td >"+data[i]["Mlocation"]+"</td>" +
            "<td >"+data[i]["Mdate"]+"</td>" +
            "<td >"+data[i]["Mrating"]+"</td>" +
            "<td >"+data[i]["MscoreNumber"]+"</td>" +
            "<td >"+data[i]["Mintroduction"]+"</td></tr>"+
            "<td>" +
            "<button onclick=\"deleteMovieItem('"+Mnnno+"','"+moviePosterPath+"')\">删除</button>" +
            "<button id='alterbutton' onclick=\"alterInfo('"+moviePosterPath+"','"+Mnnno+"')\">修改海报</button>" +
            "<button id='alterbutton' onclick=\"alterInfo2('"+
            no+"','"+
            name+"','"+
            Ename+"','"+
            time+"','"+
            piaofang+"','"+
            path+"','"+
            director+"','"+
            actor+"','"+
            type+"','"+
            language+"','"+
            place+"','"+
            shangyitime+"','"+
            score+"','"+
            numpeople+"','"+
            jianjie+"')\">修改Info</button>" +
            "</td>";

        // no,name,Ename,time,piaofang,path,director,actor,type,place,shangyitime,score,numpeople,jianjie


    }
}

$("#butmoviesearch").click(function () {
    debugger;
    if($("#moviesnamesearch").val()===""){
        alert("输入为空")
        alldshow();
    }else{
        // alert("查询")
        $.ajax({
            type: "Get",
            url: "/Admin_LoadData_movie_list",
            async: false,
            dataType: "json",
            data:{"searchMno":$("#moviesnamesearch").val()},
            success:function (data) {
                debugger;
                $("#movie-list-show tbody").html("");
                showData(data);
            }
        });
        debugger;
    }
});

function alterInfo2(no,name,Ename,time,piaofang,path,director,actor,type,language,place,shangyitime,score,numpeople,jianjie) {

debugger;
    localStorage.setItem("no",no);
    localStorage.setItem("name",name);
    localStorage.setItem("Ename",Ename);
    localStorage.setItem("time",time);
    localStorage.setItem("piaofang",piaofang);
    localStorage.setItem("path",path);
    localStorage.setItem("director",director);
    localStorage.setItem("actor",actor);
    localStorage.setItem("type",type);
    localStorage.setItem("language",language);
    localStorage.setItem("place",place);
    localStorage.setItem("shangyitime",shangyitime);
    localStorage.setItem("score",score);
    localStorage.setItem("numpeople",numpeople);
    localStorage.setItem("jianjie",jianjie);

    x_admin_show('更换海报','./html/alterInfo.html',600,400);

}

function alterInfo(path,no) {
    // alert(path);
    localStorage.setItem("alterPosterPath",path);
    localStorage.setItem("alterMovieItemNo",no);

    x_admin_show('更换海报','./html/alterPoster.html',600,400);
}


function deleteMovieItem(arrM,path) {
    // alert("hello");
    debugger;
    if(confirm("确定删除?\n编号："+arrM)){
        // alert(arrM[1]);
        $.ajax({
            type: "Get",
            url: "/Admin_delete",
            async: false,
            data:{'Mnooo':arrM,
            'Mnnpath':path},
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


function setSumData(length) {
    // $(".x-right").attr('value',12);
    document.getElementById("x-rightid").innerHTML="共有数据："+length+" 条";
}

