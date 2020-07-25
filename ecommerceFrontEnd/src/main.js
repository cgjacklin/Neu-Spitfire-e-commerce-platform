// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import VCharts from 'v-charts'
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
// import axios from 'axios'
import App from './App'
import router from './router'
import store from "./store/index";
import locale from 'element-ui/lib/locale/lang/en'
import { post, get, patch, put } from './utils/http'



//定义全局变量
Vue.prototype.$post = post;
Vue.prototype.$get = get;
Vue.prototype.$patch = patch;
Vue.prototype.$put = put;
Vue.prototype.$isCollapse = store;
Vue.use(mavonEditor)
Vue.use(VCharts)
Vue.use(ElementUI, { locale });
Vue.config.productionTip = false
// Vue.prototype.$axios = axios;
/* eslint-disable no-new */
import {setCookie,getCookie,delCookie} from'./components/cookies.js'   //引用
//定义全局变量
Vue.prototype.$setCookie = setCookie;
Vue.prototype.$getCookie = getCookie;
Vue.prototype.$delCookie = delCookie;

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
  render: h => h(App),
  data: function(){
    return {
      user_id: '',
    }
  }
})



router.beforeEach(function (to, from, next) {
  // if (to.path=="/main") {
    //从cookie中获取用户信息，判断是否已登录
    // if (auth.getAdminInfo().userUuid) {
    if (!sessionStorage.getItem("isLogin")) {
      next({
        path: '/login'
      });
      
    } else {
      var a = to.path.split("/");
      var d = sessionStorage.getItem("role_id");
      // next(); //表示已经登录
      //未登录
      // next可以传递一个路由对象作为参数 表示需要跳转到的页面
      if((a[1]=="MVO"||a[1]=="BVO")&&d!="0"){
        if(a[1]=="MVO"&&d=="1" || a[1]=="BVO"&&d=="2"){
          next(); //表示已经登录
        }
        else{
          next({
            path: '/login'
          });
        }
      }
      else{
        next(); //表示已经登录
      }
      
      
    }
  // } else {
  //   //表示不需要登录
  //   next(); //继续往后走
  // }
});