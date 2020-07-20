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
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
  render: h => h(App),
  data: function(){
    return {
      user_id: ''
    }
  }
})



// Vue.http.interceptors.push((request, next) => {
//   // 请求发送前的处理逻辑
//   request.headers.set('Authorization', "Bearer " + sessionStorage.getItem("jwt"))
//   console.log(sessionStorage.getItem("jwt"))
//   next((response) => {
//     // 请求发送后的处理逻辑
//     // 根据请求的状态，response参数会返回给successCallback或errorCallback
//     return response
//   })
// })

