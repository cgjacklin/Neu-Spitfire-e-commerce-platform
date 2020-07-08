<template>
  <div class="sidebar-container" :class="{'collapse-width': sharedState.state.isCollapse}">
    <div class="logo" :class="{'collapse-logo': sharedState.state.isCollapse}">LOGO</div>

    <el-menu
      :default-active="$route.path"
      background-color="#FAF3EA"
      active-text-color="#F67E7E"
      class="el-menu-vertical-demo"
      router
      unique-opened
      :collapse="sharedState.state.isCollapse"
    >
      <!-- 如果有子菜单 -->
      <template v-for="item in items">
        <template v-if="item.subs">
          <el-submenu :index="item.index" :key="item.title">
            <template slot="title">
              <i :class="item.icon"></i>
              <span slot="title">{{item.title}}</span>
            </template>
            <el-menu-item v-for="sub in item.subs" :index="sub.index" :key="sub.title">{{sub.title}}</el-menu-item>
          </el-submenu>
        </template>
        <!-- 没有子菜单 -->
        <template v-else>
          <el-menu-item :index="item.index" :key="item.title">
            <i :class="item.icon"></i>
            <span>{{ item.title }}</span>
          </el-menu-item>
        </template>
      </template>
    </el-menu>
  </div>
</template>

<script>
export default {
  data() {
    return {
      sharedState: this.$isCollapse,
      items: [
        {
          icon: "el-icon-s-home",
          index: "/main",
          title: "Home"
        },
        {
          icon: "el-icon-setting",
          title: "Management",
          index: "1",
          subs: [
            {
              icon: "el-icon-notebook-2",
              index: "/menu",
              title: "Menu management"
            },
            {
              icon: "el-icon-user",
              index: "/user",
              title: "User management"
            },
            {
              icon: "el-icon-notebook-1",
              index: "/param",
              title: "Parameter management"
            },
            {
              icon: "el-icon-collection",
              index: "/data",
              title: "Data dictionary"
            },
            {
              icon: "el-icon-document-checked",
              index: "/check",
              title: "Fund check"
            },
          ]
        },
        {
          icon: "el-icon-office-building",
          title: "MVO",
          index: "2",
          subs: [
            {
              icon: "el-icon-school",
              index: "/company",
              title: "Company information"
            },
            {
              icon: "el-icon-goods",
              index: "/goods",
              title: "Goods management"
            },
            {
              icon: "el-icon-s-order",
              index: "/MVO/order",
              title: "Order management"
            },
            {
              icon: "el-icon-wallet",
              index: "/MVO/wallet",
              title: "Wallet"
            }
          ]
        },
        {
          icon: "el-icon-s-shop",
          title: "BVO",
          index: "3",
          subs: [
            {
              icon: "el-icon-house",
              index: "/store",
              title: "Store management"
            },
            {
              icon: "el-icon-goods",
              index: "/goodslist",
              title: "Goods list"
            },
            {
              icon: "el-icon-star-off",
              index: "/wishlist",
              title: "Wish list"
            },
            {
              icon: "el-icon-s-order",
              index: "/BVO/order",
              title: "Order management"
            },
            {
              icon: "el-icon-wallet",
              index: "/BVO/wallet",
              title: "Wallet"
            }
          ]
        }
      ]
    };
  },
  mounted(){
    
  },
  methods: {

  }
};
</script>

<style scoped>
.collapse-width {
  width: 64px !important;
}
.collapse-logo {
  font-size: 10px !important;
}
.sidebar-container {
  width: 200px;
  height: 100%;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  transition: width 0.3s;
  z-index: 1001;
  overflow: hidden;
}
.logo {
  width: 100%;
  height: 56px;
  line-height: 56px;
  font-size: 30px;
  font-weight: bold;
  text-align: center;
  color: white;
  background-color: #ffbe85;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  height: 100%;
}
.el-menu-vertical-demo {
  height: 100%;
}
.el-menu {
  border: none;
  height: 100%;
  width: 100% !important;
  overflow-y: auto;
}
/* .el-submenu .el-menu-item{
      background-color: rgb(0, 8, 15)!important;
    } */
</style>