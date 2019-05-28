window.onload=function (){
    $.ajax({
        type:"GET",
        url:"/GetOrders?email="+localStorage.getItem('email'),
        contentType:"charset=utf-8",
        success:function (data) {
            showMessage(data)
        },
        error:function () {
            alert("连接服务器超时")
        }
    })
};

var text = "<div class=\"order-box\" data-orderid=\"3426246597\">\n" +
    "                        <div class=\"order-header\">\n" +
    "                            <span class=\"order-date\">2018-09-24</span>\n" +
    "                            <span class=\"order-id\">猫眼订单号:3426246597</span>\n" +
    "                        </div>\n" +
    "\n" +
    "                        <div class=\"order-body\">\n" +
    "                            <div class=\"poster\">\n" +
    "                                <img src=\"https://p1.meituan.net/movie/beed599e0bcffdd6cbb403f3bd957d6a907391.jpg@66w_91h_1e_1c\">\n" +
    "                            </div>\n" +
    "\n" +
    "                            <div class=\"order-content\">\n" +
    "                                <div class=\"movie-name\">《李茶的姑妈》</div>\n" +
    "                                <div class=\"cinema-name\">SFC上影影城(成都龙湖IMAX店)</div>\n" +
    "                                <div class=\"hall-ticket\">\n" +
    "                                    <span>11号绿洲厅</span>\n" +
    "                                    <span>5排2座</span>\n" +
    "                                </div>\n" +
    "                                <div class=\"show-time\">周日 9月30日 17:55</div>\n" +
    "                            </div>\n" +
    "\n" +
    "                            <div class=\"order-price\">￥39.8</div>\n" +
    "\n" +
    "                            <div class=\"order-status\">\n" +
    "                                已完成\n" +
    "                            </div>\n" +
    "\n" +
    "                            <div class=\"actions\">\n" +
    "                                <div>\n" +
    "                                    <a href=\"./MyOrderDetail.html\" class=\"order-detail\" data-act=\"orders-detail-click\" data-bid=\"b_y190atas\">查看详情</a>\n" +
    "                                </div>\n" +
    "                            </div>\n" +
    "                        </div>\n" +
    "                    </div>";

function showMessage(data) {
    debugger;
    $(".order-box").each(function (i) {
        $(this).remove()
    });

    for(var i=0,len=data.length;i<len;i++){
        $(".orders-container").append(text);
    }

    $(".order-date").each(function (i) {
        $(this).text(data[i]["Odate"]);
    });

    $(".order-id").each(function (i) {
        $(this).text("订单编号："+data[i]["Ono"]);
    });

    $(".poster img").each(function (i) {
        $(this).attr('src','/image?path='+data[i]["MposterPath"]);
    });

    $(".movie-name").each(function (i) {
        $(this).text("《"+data[i]["Mname"]+"》");
    });

    $(".cinema-name").each(function (i) {
        $(this).text(data[i]["Tname"]);
    });

    $(".hall-ticket").each(function (i) {
        $(this).find('span').each(function (k) {
            if(k===0){
                $(this).text(data[i]["roomName"])
            }else if(k===1){
                $(this).text(data[i]["seat"])
            }
        });
    });

    $(".show-time").each(function (i) {
        $(this).text(data[i]["beginDate"]+" "+data[i]["beginTime"]);
    });

    $(".order-price").each(function (i) {
        $(this).text("￥"+Math.ceil(data[i]["price"]));
    });

    $(".order-detail").each(function (i) {
        $(this).click(function () {
            localStorage.setItem('Ono',data[i]["Ono"])
        })
    });

}