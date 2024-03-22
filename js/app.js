(function () {
  var loginView = null; // 设置变量用于存放对话框DOM
  function loginRegisterAction(event) {
    event.preventDefault(); // 阻止a标签的默认形为
    // loginView = null
    if (!loginView) {
      // 如果对话框没有显示出来
      var type = event.target.dataset.type;
      // console.log(type, event);
      loginView = new pageTools.Login(type == "login", "body", function () {
        loginView = null;
      });
    }
  }
  function loginRegister() {
    $(".login").click(loginRegisterAction);
    $(".register").click(loginRegisterAction);
  }

  function main() {
    // 添加监听
    // var loginView = null; // 设置变量用于存放对话框DOM
    // $(".login").click(function (event) {
    //   event.preventDefault();
    //   if (!loginView) {
    //     loginView = new pageTools.Login(true, "body");
    //   }
    // });
    // 添加登录注册的事件处理函数
    // 在主函数中设置全局变量loginView，用于存放对话框DOM，并添加登录注册的点击事件处理函数。

    loginRegister();
  }
  main();
})();
