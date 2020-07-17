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
          <el-submenu :index="item.menu_url" :key="item.menu_url">
            <template slot="title">
              <i :class="item.menu_icon"></i>
              <span slot="title">{{item.menu_name}}</span>
            </template>
            <el-menu-item
              v-for="sub in item.subs"
              :index="sub.menu_url"
              :key="sub.menu_name"
            >{{sub.menu_name}}</el-menu-item>
          </el-submenu>
        </template>
        <!-- 没有子菜单 -->
        <template v-else>
          <el-menu-item :index="item.menu_url" :key="item.menu_url">
            <i :class="item.menu_icon"></i>
            <span>{{ item.menu_name }}</span>
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
      role: "",
      items: [
        {
          menu_icon: "el-icon-s-home",
          menu_url: "/main",
          menu_name: "Home"
        },
        {
          menu_icon: "el-icon-setting",
          menu_name: "Management",
          menu_url: "1",
          subs: [
            {
              menu_icon: "el-icon-notebook-2",
              menu_url: "/menu",
              menu_name: "Menu manage"
            },
            {
              menu_icon: "el-icon-user",
              menu_url: "/user",
              menu_name: "User manage"
            },
            {
              menu_icon: "el-icon-notebook-1",
              menu_url: "/param",
              menu_name: "Parameter manage"
            },
            {
              menu_icon: "el-icon-collection",
              menu_url: "/data",
              menu_name: "Data dictionary"
            },
            {
              menu_icon: "el-icon-document-checked",
              menu_url: "/check",
              menu_name: "Fund check"
            }
          ]
        },
        {
          menu_icon: "el-icon-office-building",
          menu_name: "MVO",
          menu_url: "2",
          subs: [
            {
              menu_icon: "el-icon-school",
              menu_url: "/company",
              menu_name: "Company info"
            },
            {
              menu_icon: "el-icon-goods",
              menu_url: "/goods",
              menu_name: "Goods manage"
            },
            {
              menu_icon: "el-icon-s-order",
              menu_url: "/MVO/order",
              menu_name: "Order manage"
            },
            {
              menu_icon: "el-icon-wallet",
              menu_url: "/MVO/wallet",
              menu_name: "Wallet"
            }
          ]
        },
        {
          menu_icon: "el-icon-s-shop",
          menu_name: "BVO",
          menu_url: "3",
          subs: [
            {
              menu_icon: "el-icon-house",
              menu_url: "/store",
              menu_name: "Store manage"
            },
            {
              menu_icon: "el-icon-goods",
              menu_url: "/goodslist",
              menu_name: "Goods list"
            },
            {
              menu_icon: "el-icon-star-off",
              menu_url: "/wishlist",
              menu_name: "Wish list"
            },
            {
              menu_icon: "el-icon-s-order",
              menu_url: "/BVO/order",
              menu_name: "Order manage"
            },
            {
              menu_icon: "el-icon-wallet",
              menu_url: "/BVO/wallet",
              menu_name: "Wallet"
            }
          ]
        }
      ]
    };
  },
  mounted() {
    this.$post("/mainPage/getInfo", {
      user_id: sessionStorage.getItem("user_id")
    }).then(res => {
      //处理response
      console.log(res);
      if (res.code == 504) {
        this.$message.warning(res.message);
        return;
      }
      if (res.code == 200) {
        console.log(res.data.role);
        if (res.data.role == "Admin") {
          return;
        }
        this.$post("/menuList/getMenuListByID", {
          user_id: sessionStorage.getItem("user_id")
        }).then(res => {
          this.items = res.data;
          this.items.unshift({
            menu_icon: "el-icon-s-home",
            menu_url: "/main",
            menu_name: "Home"
          });
        });
      }
    });
  },
  methods: {}
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