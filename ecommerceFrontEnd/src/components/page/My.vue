<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/main' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>My info</el-breadcrumb-item>
    </el-breadcrumb>
    <div class="info-box">
      <el-card class="fix-info-card">
        <div slot="header">
          <span>
            <i class="el-icon-s-custom"></i> Basic information
          </span>
        </div>
        <h4>Role:{{role}}</h4>
        <h4>Username:{{username}}</h4>
        <h4>Nickname:{{nickname}}</h4>
        <h4>Phone:{{phone}}</h4>
        <h4>E-mail:{{email}}</h4>
      </el-card>
      <el-card class="change-info-card">
        <div slot="header">
          <span>
            <i class="el-icon-s-tools"></i> Setting
          </span>
        </div>
        <el-form :model="infoForm" ref="infoForm" label-width="100px" class="form">
          <el-form-item
            class="label-font"
            label="nickname"
            prop="nickname"
            :rules="[{ required: true, message: 'Please enter the nickname number'}]"
          >
            <el-input style="width:35rem" v-model="infoForm.nickname" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            class="label-font"
            label="phone"
            prop="phone"
            :rules="[{ required: true, message: 'Please enter your phone number'},{ len: 11, message: 'Please enter the correct length of the phone number'}]"
          >
            <el-input style="width:35rem" v-model="infoForm.phone" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            class="label-font"
            label="email"
            prop="email"
            :rules="[{ required: true, message: 'Please enter your email'},{ type:'email', message: 'Invalid format'}]"
          >
            <el-input style="width:35rem" v-model="infoForm.email" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item>
            <el-button type="danger" @click="submitForm('infoForm')">Update</el-button>
          </el-form-item>
        </el-form>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      role: "",
      username: "",
      nickname: "",
      phone: "",
      email: "",
      infoForm: {
        nickname: "",
        phone: "",
        email: ""
      }
    };
  },
  mounted(){
    this.$post("/mainPage/getUserBasicInfo", {
        user_id: sessionStorage.getItem("user_id")
      }).then(res => {
        //处理response
        console.log(res)
        if (res.code == 504) {
          this.$message.warning(res.message);
          return;
        }
        if (res.code == 200) {
          // this.$root.user_id=res.data.user_id;
          if(res.data.role_id=="0"){this.role = "Admin";}
          if(res.data.role_id=="1"){this.role = "Brand-seller";}
          if(res.data.role_id=="2"){this.role = "Borrow-seller";}
          this.username = res.data.username;
          this.nickname = res.data.name;
          this.phone = res.data.phone;
          this.email = res.data.email;
          // this.infoForm.nickname = res.data.name;
          // this.infoForm.phone = res.data.phone;
          // this.infoForm.email = res.data.email;
        }
      });
  },
  methods: {
    refresh(){
      this.$post("/mainPage/getUserBasicInfo", {
        user_id: sessionStorage.getItem("user_id")
      }).then(res => {
        //处理response
        console.log(res)
        if (res.code == 504) {
          this.$message.warning(res.message);
          return;
        }
        if (res.code == 200) {
          // this.$root.user_id=res.data.user_id;
          if(res.data.role_id=="0"){this.role = "Admin";}
          if(res.data.role_id=="1"){this.role = "Brand-seller";}
          if(res.data.role_id=="2"){this.role = "Borrow-seller";}
          this.username = res.data.username;
          this.nickname = res.data.name;
          this.phone = res.data.phone;
          this.email = res.data.email;
          // this.infoForm.nickname = res.data.name;
          // this.infoForm.phone = res.data.phone;
          // this.infoForm.email = res.data.email;
        }
      });
    },
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          this.$post("/mainPage/updateUserBasicInfo", {
              user_id: sessionStorage.getItem("user_id"),
              name: this.infoForm.nickname,
              phone: this.infoForm.phone,
              email: this.infoForm.email
          }).then(res => {
            //处理response
            console.log(res)
            if (res.code == 504) {
              this.$message.warning(res.message);
               this.$refs[formName].resetFields()
              return;
            }
            if (res.code == 200) {
              this.$message.success(res.message);
              this.$refs[formName].resetFields()
              this.refresh();
            }
       });
        } else {
          return false;
        }
      });
    }
  }
};
</script>

<style scoped>
.info-box {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  margin-top: 3rem;
}
.fix-info-card {
  width: 25rem;
  height: 25rem;
}
.change-info-card {
  width: 65rem;
  height: 30rem;
}
.form {
  margin-top: 1rem;
  margin-left: 6rem;
}
.label-font >>> .el-form-item__label {
  font-size: 17px;
  font-weight: bold;
}
</style>