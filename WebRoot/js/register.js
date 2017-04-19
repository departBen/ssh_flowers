/**
 * Created by ben on 2017/4/8.
 */


/**
 * 验证是否为空
 * @returns {boolean}
 */
function check() {
    var username = $("#username").val();
    var password1 = $("#password").val();
    var password2 = $("#eqPassword").val();
    var realname = $("#realname").val();
    var phoneNO = $("#phoneNO").val();
    var email = $("#email").val();
    var answer = $("#answer").val();
    var address = $("#address").val();

    if (username == "") {
        $("#username").focus();
        $("#username").parent().addClass("has-error");
        return false;
    }
    if (password1 == "") {
        $("#password").focus();
        $("#password").parent().addClass("has-error");
        return false;
    }
    if (password2 == "") {
        $("#eqPassword").focus();
        $("#eqPassword").parent().addClass("has-error");
        return false;
    }
    if (realname == "") {
        $("#realname").focus();
        $("#realname").parent().addClass("has-error");
        return false;
    }
    if (phoneNO == "") {
        $("#phoneNO").focus();
        $("#phoneNO").parent().addClass("has-error");
        return false;
    }
    if (email == "") {
        $("#email").focus();
        $("#email").parent().addClass("has-error");
        return false;
    }
    if (answer == "") {
        $("#answer").focus();
        $("#answer").parent().addClass("has-error");
        return false;
    }
    if (address == "") {
        $("#address").focus();
        $("#address").parent().addClass("has-error");
        return false;
    }

    if (password1 != password2){
        $("#eqPassword").focus();
        $("#eqPassword").parent().addClass("has-error");
        return false;
    }
}

/**
 * 重新输入时清楚错误警告
 * @param obj
 */
function clearError(obj) {
    $(obj).parent().removeClass("has-error")
}

/**
 * 验证两次密码是否一致
 */
function checkPassword() {
    var password1 = $("#password").val();
    var password2 = $("#eqPassword").val();
    if (password1 == password2){
        $("#eqPassword").parent().removeClass("has-error");
        $("#eqPassword").parent().addClass("has-success");
    } else {
        $("#eqPassword").parent().removeClass("has-success");
        $("#eqPassword").parent().addClass("has-error");
    }
}

/**
 * 验证用户名是否存在
 */
function checkUserName() {
    var username = $("#username").val();

    //创建异步交互对象
    var xhr = new XMLHttpRequest();

    //设置监听
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == 200) {

            $("#msg").html(xhr.responseText);

        }
    }

    //打开链接
    xhr.open("GET", "${pageContext.request.contextPath}/userAction!findByName.action?users.userName=" + username, true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    //发送
    xhr.send(null);
}