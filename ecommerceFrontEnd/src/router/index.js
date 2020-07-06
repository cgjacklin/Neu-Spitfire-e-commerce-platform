import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)
const originalPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
}

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/login'
    },
    {
      path: '/login',
      component: resolve => require(['../components/Login.vue'], resolve)
    },
    {
      path: '/main',
      component: resolve => require(['../components/common/Main.vue'], resolve),
      children:[
        {
          path: '/',
          component: resolve => require(['../components/page/Home.vue'], resolve)
        },
        {
          path: '/my',
          component: resolve => require(['../components/page/My.vue'], resolve)
        },
        {
          path: '/company',
          component: resolve => require(['../components/page/MVO/Company.vue'], resolve)
        },
        {
          path: '/goods',
          component: resolve => require(['../components/page/MVO/Goods.vue'], resolve)
        },
        {
          path: '/MVO/order',
          component: resolve => require(['../components/page/MVO/Order.vue'], resolve)
        },
        {
          path: '/MVO/wallet',
          component: resolve => require(['../components/page/MVO/Wallet.vue'], resolve)
        },
        {
          path: '/BVO/order',
          component: resolve => require(['../components/page/BVO/Order.vue'], resolve)
        },
        {
          path: '/BVO/wallet',
          component: resolve => require(['../components/page/BVO/Wallet.vue'], resolve)
        },
        {
          path: '/store',
          component: resolve => require(['../components/page/BVO/Store.vue'], resolve)
        },
        {
          path: '/goodslist',
          component: resolve => require(['../components/page/BVO/GoodsList.vue'], resolve)
        },
        {
          path: '/wishlist',
          component: resolve => require(['../components/page/BVO/WishList.vue'], resolve)
        },
        {
          path: '/menu',
          component: resolve => require(['../components/page/Admin/Menu.vue'], resolve)
        },
        {
          path: '/user',
          component: resolve => require(['../components/page/Admin/User.vue'], resolve)
        },
        {
          path: '/param',
          component: resolve => require(['../components/page/Admin/Param.vue'], resolve)
        },
        {
          path: '/data',
          component: resolve => require(['../components/page/Admin/Data.vue'], resolve)
        },
        {
          path: '/check',
          component: resolve => require(['../components/page/Admin/Check.vue'], resolve)
        },
      ]
    }
  ]
})
