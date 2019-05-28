
window.onload=function (){
    debugger;
    //对应方法2
    var key=localStorage.getItem('key');

    $.ajax({
        type:"GET",
        contentType:"charset=utf-8",
        url: "/MovieDetails?"+"Mno="+key,
        success: function (data) {
            debugger;
            showMovieDetail(data)
        },
        error: function () {
            alert("连接服务器超时");
        }
    })
};

function showMovieDetail(data) {
    $(".avatar").attr('src','/image?path='+data["MposterPath"]);
    $(".movie-brief-container h3").text(data["Mname"]);
    $(".movie-brief-container .ename").text(data["MEnglishName"]);
    $(".movie-brief-container #type").text(data["Mtype"]);
    var times = data["Mduration"].split(":");
    var time = parseInt(times[0])*60+parseInt(times[1]);
    if(data["Mlanguage"]==="English"){
        $(".movie-brief-container #origin").text(time+"分钟/英文");
    }else {
        $(".movie-brief-container #origin").text(time+"分钟/中文");
    }

    $(".movie-brief-container #time").text(data["Mdate"]+"大陆上映");

    if(Math.ceil(data["Mrating"])===data["Mrating"]){
        $("#my-score").text(data["Mrating"]+".0");
    }else {
        $("#my-score").text(data["Mrating"]);
    }


    var num = data["MscoreNumber"];
    if(num>=10000){
        $("#score-num-my").text( Math.ceil(num/10000)+"万")
    }else
        $("#score-num-my").text(num);

    var box = data["MboxOffice"];
    if(box>=100000000){
        $("#my-box-office").text(Math.ceil(box/100000000));
        $(".unit").text('亿')
    }else if(box>=10000){
        $("#my-box-office").text(Math.ceil(box/10000));
        $(".unit").text('万')
    }else {
        $("#my-box-office").text(box);
        $(".unit").text('元')
    }


    $(".dra").text(data["Mintroduction"])
}

