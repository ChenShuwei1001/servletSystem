$(document).ready(function () {
    debugger;
    $.ajax({
        type: "Get",
        url: "/Admin_LoadData_movie_list",
        async: false,
        dataType: "json",
        success: function (data,txtstuts) {

            debugger;

            //静态测试
            for(var i=0;i<data.length;i++){
                var movieListTable=document.getElementById("movie-list-show");
                var rowLength=movieListTable.rows.length;
                var tableRow=movieListTable.insertRow(rowLength);
                var moviePosterPath=data[i]["MposterPath"];
                // var moviePosterPath="F:/myCode/411movieSystemImage/0abc.jpg";
                // debugger;
                // var moviePosterPath2=moviePosterPath.substring(moviePosterPath.index("web"),moviePosterPath.end());
                var inde=moviePosterPath.indexOf("image/");
                var moviePosterPath2=moviePosterPath.substr(inde);

                localStorage.setItem("movieParam",moviePosterPath2);
                localStorage.setItem("movieNO",data[i]["Mno"]);

                // language=HTML
                tableRow.innerHTML=
                    "<td>" +
                    "<div class=\"layui-unselect layui-form-checkbox\" lay-skin=\"primary\" data-id='2'><i class=\"layui-icon\">&#xe605;</i></div>" +
                    "</td>" +
                    // "<td>"+data[i]["MposterPath"]+"</td>" +
                    // "<td><img src=\"http://localhost:8080/servletSystem_war_exploded/image/abc.jpg\" alt=\"\"></td>" +
                    // "<td><img src=\"image/abc.jpg\" alt=\"\"></td>" +
                    "<td><img onclick=\"x_admin_show('更换海报','./html/alterPoster.html',600,400)\" src='/ImageUtil_Admin?path="+moviePosterPath+"' alt=''></td>" +
                    "<td width='10'>"+data[i]["Mno"]+"</td>" +
                    "<td>"+data[i]["Mname"]+"</td>" +
                    "<td>"+data[i]["MEnglishName"]+"</td>" +
                    "<td>"+data[i]["Mduration"]+"</td>" +
                    "<td>"+data[i]["MboxOffice"]+"</td>" +


                    "<td>"+data[i]["Mdirector"]+"</td>" +
                    "<td>"+data[i]["actor"]+"</td>" +
                    "<td>"+data[i]["Mtype"]+"</td>" +
                    "<td>"+data[i]["Mlanguage"]+"</td>" +
                    "<td>"+data[i]["Mlocation"]+"</td>" +
                    "<td>"+data[i]["Mdate"]+"</td>" +
                    "<td>"+data[i]["Mrating"]+"</td>" +
                    "<td>"+data[i]["MscoreNumber"]+"</td>" +
                    "<td>"+data[i]["Mintroduction"]+"</td>"+
                    "<td><input id='id' type='button' value='编辑' onclick='editTd(this.id)'/></td>";




            }
        }
    })


});





// $(function(){
//   // language=JQuery-CSS
//   $(".showPoster").click(function(){
//     var _this = $(this);//将当前的pimg元素作为_this传入函数
//     imgShow("#outerdiv", "#innerdiv", "#bigimg", _this);
//   });
// });

// $(function () {
//   function showBig() {
//     var _this = $(this);//将当前的pimg元素作为_this传入函数
//     imgShow("#outerdiv", "#innerdiv", "#bigimg", _this);
//   }
// });