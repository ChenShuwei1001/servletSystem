function getParams(url) {
    var theRequest = new Object();
    if (!url)
        url = location.href;
    if (url.indexOf("?") !== -1)
    {
        var str = url.substr(url.indexOf("?") + 1) + "&";
        var strs = str.split("&");
        for (var i = 0; i < strs.length - 1; i++)
        {
            var key = strs[i].substring(0, strs[i].indexOf("="));
            var val = strs[i].substring(strs[i].indexOf("=") + 1);
            theRequest[key] = val;
        }
    }
    return theRequest;
}

$(".action--buy").click(function(){

    var params = getParams(location.href);
    //获取地址栏上的userName
    var sessionId =  params.sessionId;
    var hallId = params.hallId;
    var s = $(".row__seat--selected").data("tooltip");
    window.location.href = "/MovieManager/BuyTicketAction?userId=${sessionScope.user.id}&sessionId="+sessionId+"&hallId="+hallId+"&seat="+s;

})