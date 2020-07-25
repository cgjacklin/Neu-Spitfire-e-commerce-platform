<template>
  <div class="topbar-container">
    <div class="btn" @click="Sidebar">
      <i
        style="font-size:30px"
        :class="sharedState.state.isCollapse ?'el-icon-s-unfold':'el-icon-s-fold'"
      ></i>
    </div>
    <div class="user">
      <el-dropdown trigger="click" @command="handleCommand">
        <el-avatar :src="imgSrc"></el-avatar>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item disabled icon="el-icon-s-custom">{{nickname}}</el-dropdown-item>
          <el-dropdown-item command="my">My Info</el-dropdown-item>
          <el-dropdown-item command="login">Log out</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      nickname: "",  
      imgSrc: require("../../assets/user.jpg"),
      sharedState: this.$isCollapse
    };
  },
  mounted(){
    this.$post("/mainPage/getUserBasicInfo", {
        user_id: sessionStorage.getItem("user_id")
      }).then(res => {
        if (res.code == 200) {
          // console.log("HHHH")
          // console.log(res)
          this.nickname = res.data.name;
        } 
        
      });
  },
  methods: {
    Sidebar() {
      console.log(this.$isCollapse);
      if (this.sharedState.state.isCollapse == false) {
        this.sharedState.setAction(true);
      } else {
        this.sharedState.setAction(false);
      }
    },
    handleCommand(command) {
      console.log(command);
      this.$router.push(`/${command}`);
      if(command=="login"){
        sessionStorage.clear()
      }
    }
  }
};
</script>

<style scoped>
.topbar-container {
  height: 56px;
  background-image: linear-gradient(134deg, #ffbe85 0%, #f46774 100%);
  border-left: 3px solid rgb(255, 255, 255);
}
.btn {
  display: inline-block;
  padding: 10px 20px;
  color: white;
}
.user {
  position: absolute;
  right: 20px;
  top: 8px;
  display: inline-block;
}
</style>