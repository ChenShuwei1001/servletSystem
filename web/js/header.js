var isLogin = localStorage.getItem('isLogin');
if(isLogin==null||isLogin!=="true"){
    $(".header .user-info .user-avatar .user-menu li").each(function (i) {
        $(this).find('a').each(function () {
            $(this).hover(function () {
                $(this).css('color','#EF4238')
            },function () {
                $(this).css('color','#999')
            });
            $(this).click(function () {
                //点击登录，记录之前的界面
                localStorage.setItem('oldPage',location.href);
            })
        })
    });
}else if(isLogin==="true"){
    $(".header .user-info .user-avatar img").attr('src','../img/user_head.jpg');
    $(".header .user-info .user-avatar .user-menu").append($(".header .user-info .user-avatar .user-menu li:last").clone());
    $(".header .user-info .user-avatar .user-menu li").each(function (i) {
        $(this).find('a').each(function () {
            if(i===1){
                $(this).attr('name','quit');
            }else if(i===0){
                $(this).attr('name','order');
            }

            if(i===0){
                $(this).text("我的订单");
                $(this).attr('href','');
            }else if(i===1){
                $(this).text("退出登录");
                var url = location.href;
                $(this).attr('href',url);
            }

            $(this).hover(function () {
                $(this).css('color','#EF4238')
            },function () {
                $(this).css('color','#999')
            });

            $(this).click(function (event) {
                var name = $(event.target).attr("name");
                if(name==='quit'){
                    localStorage.removeItem('isLogin');
                    localStorage.removeItem('email');
                    localStorage.removeItem('name');
                }
            })
        })
    })
}