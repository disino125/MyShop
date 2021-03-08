function changeCode(img) {
    img.src = "getCode?"+new Date().getTime();
};

function focusItem(obj) {
    if(obj.name=='codeValidate'){
        $(obj).next().next('span').html('');
    }else {
        $(obj).next('span').html('');
    }
};

function checkItem(obj) {
    var spanTag = $(obj).next('span');
    switch (obj.name) {
        case 'username':
            if (obj.value=="") {
                spanTag.html('用户名不能为空');
                spanTag.addClass("error");
                flag = false;
            }else {
                var url = "checkUsername?username="+encodeURI($(obj).val())+"&"+new Date().getTime();
                $.get(url,function (data) {
                    if(data=="true"){
                        spanTag.html('用户名已被使用');
                        spanTag.addClass("error");
                        flag = false;
                    }else {
                        spanTag.html().removeClass('error');
                        flag = true;
                    }
                })
            }
        break;
        case 'name':
            if (obj.value=="") {
                spanTag.html('姓名不能为空');
                spanTag.addClass("error");
                flag = false;
            }else {
                flag = true;
            }
            break;
        case 'password':
            if (obj.value=="") {
                spanTag.html('密码不能为空');
                spanTag.addClass("error");
                flag = false;
            }else {
                flag = true;
            }
            break;
        case 'rePassword':
            if (obj.value=="") {
                spanTag.html('请再次输入密码');
                spanTag.addClass("error");
                flag = false;
            }else if ($("#psw").val()!=$(obj).val()){
                spanTag.html('密码不一致');
                spanTag.addClass("error");
                flag = false;
            }else {
                flag = true;
            }
            break;
        case 'birthday':
            if (obj.value=="") {
                spanTag.html('生日不能为空');
                spanTag.addClass("error");
                flag = false;
            }else {
                flag = true;
            }
            break;
        case 'email':
            if (obj.value=="") {
                spanTag.html('邮箱不能为空');
                spanTag.addClass("error");
                flag = false;
            }else {
                flag = true;
            }
            break;
        case 'mobil':
            if (obj.value=="") {
                spanTag.html('电话不能为空');
                spanTag.addClass("error");
                flag = false;
            }else {
                flag = true;
            }
            break;
        case 'address':
            if (obj.value=="") {
                spanTag.html('地址不能为空');
                spanTag.addClass("error");
                flag = false;
            }else {
                flag = true;
            }
            break;
        case 'codeValidate':
            if (obj.value=="") {
                $("#code").html('验证码不能为空');
                $("#code").addClass("error");
                flag = false;
            }else {
                var url = "checkCode?code="+encodeURI($(obj).val())+"&"+new Date().getTime();
                $.get(url,function (data) {
                    if(data=="false"){
                        $("#code").html('验证码错误');
                        $("#code").addClass("error");
                        flag = false;
                    }else {
                        $("#code").removeClass('error');
                        flag = true;
                    }
                })
            }
            break;
    }
};

var flag = true;

function checkForm(form){
    var els = form.getElementsByTagName('input');
    for (var i = 0; i < els.length ; i++) {
        if(els[i]!=null){
            if(els[i].getAttribute('onblur')){
                checkItem(els[i]);
            }
        }
    }
    return flag;
}

