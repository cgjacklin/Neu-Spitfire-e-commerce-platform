<template>
  <div class="flex">
    <ul class="slideshow">
      <li>
        <span>1</span>
      </li>
      <li>
        <span>2</span>
      </li>
      <li>
        <span>3</span>
      </li>
      <li>
        <span>4</span>
      </li>
    </ul>
    <transition name="el-zoom-in-left">
      <div v-show="showlogin" class="box">
        <h2 class="title">Cross-border e-commerce borrow-sell platform</h2>
        <el-input
          style="width:24rem"
          class="input"
          v-model="username"
          placeholder="Please enter the user name."
          prefix-icon="el-icon-user-solid"
        ></el-input>
        <el-input
          style="width:24rem"
          class="input"
          v-model="password"
          placeholder="Please enter your password."
          prefix-icon="el-icon-lock"
          show-password
        ></el-input>
        <div>
          <el-input
            style="width:18rem"
            class="input"
            v-model="checkCode"
            placeholder="Please enter the code."
            prefix-icon="el-icon-edit"
          ></el-input>
          <el-button
            style="width:5.5rem;height: 50px"
            type="danger"
            plain
            @click="createCode"
          >{{Code}}</el-button>
        </div>
        <el-button class="btn" type="danger" @click="login">Login</el-button>
        <el-link
          class="register"
          type="danger"
          :underline="false"
          @click="change"
          icon="el-icon-right"
        >register</el-link>
      </div>
    </transition>

    <transition name="el-zoom-in-left">
      <div v-show="showRegister" class="box-register">
        <h2 class="title">Register</h2>
        <el-input
          style="width:24rem"
          class="input"
          v-model="username"
          placeholder="Please enter the user name."
          prefix-icon="el-icon-user-solid"
        ></el-input>
        <el-input
          style="width:24rem"
          class="input"
          v-model="nickname"
          placeholder="Please enter the nick name."
          prefix-icon="el-icon-user"
        ></el-input>
        <el-input
          style="width:24rem"
          class="input"
          v-model="password"
          placeholder="Please enter your password."
          prefix-icon="el-icon-lock"
          show-password
        ></el-input>
        <el-input
          style="width:24rem"
          class="input"
          v-model="passwordSure"
          placeholder="Please enter password again."
          prefix-icon="el-icon-lock"
          show-password
        ></el-input>
        <el-input
          style="width:24rem"
          class="input"
          v-model="phone"
          placeholder="Please enter your phone."
          prefix-icon="el-icon-phone"
        ></el-input>
        <el-input
          style="width:24rem"
          class="input"
          v-model="email"
          placeholder="Please enter your e-mail."
          prefix-icon="el-icon-message"
        ></el-input>
        <div class="radio">
          <el-radio v-model="role_id" label="1">Brand-seller</el-radio>
          <el-radio v-model="role_id" label="2">Borrow-seller</el-radio>
        </div>
        <el-button class="btn" type="danger" @click="register">Register</el-button>
        <el-link
          class="register"
          type="danger"
          :underline="false"
          @click="change"
          icon="el-icon-back"
        >login</el-link>
      </div>
    </transition>
  </div>
</template>

<script>
let _ = require("lodash");
export default {
  data() {
    return {
      showlogin: true,
      showRegister: false,
      checkCode: "",
      Code: "",
      username: "",
      nickname: "",
      password: "",
      passwordSure: "",
      phone: "",
      email: "",
      role_id: "1"
    };
  },
  watch: {
    passwordSure: function() {
      this.debouncedPassword();
    },
    username: function() {
      if (this.showRegister == true) {
        this.debouncedUsername();
      }
    }
  },
  mounted() {
    this.createCode();
  },
  created() {
    // `_.debounce` 通过 Lodash 等待输入完毕后，再进行验证
    this.debouncedPassword = _.debounce(this.passwordSureInput, 900);
    this.debouncedUsername = _.debounce(this.usernameInput, 900);
  },
  methods: {
    createCode() {
      let code = "";
      let codeLength = 4; //验证码的长度
      let random = new Array(
        0,
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        "A",
        "B",
        "C",
        "D",
        "E",
        "F",
        "G",
        "H",
        "I",
        "J",
        "K",
        "L",
        "M",
        "N",
        "O",
        "P",
        "Q",
        "R",
        "S",
        "T",
        "U",
        "V",
        "W",
        "X",
        "Y",
        "Z"
      ); //随机数
      for (let i = 0; i < codeLength; i++) {
        //循环操作
        let index = Math.floor(Math.random() * 36); //取得随机数的索引（0~35）
        code += random[index]; //根据索引取得随机数加到code上
      }
      this.Code = code; //把code值赋给验证码
    },
    change() {
      if (this.showlogin == true) {
        this.showlogin = false;
        this.clearString();
        setTimeout(() => {
          this.showRegister = true;
        }, "350");
      } else {
        this.showRegister = false;
        this.clearString();
        setTimeout(() => {
          this.showlogin = true;
        }, "350");
      }
    },
    clearString() {
      this.username = "";
      this.password = "";
      this.nickname = "";
      this.passwordSure = "";
      this.phone = "";
      this.email = "";
      this.role_id = "1";
    },
    usernameInput() {
      this.$post("/user/checkUsername", {
        username: this.username
      }).then(res => {
        if (res.code == 504) {
          this.$notify({
            title: "Warning",
            message: `The user name '${this.username}' already exists, please enter a new name`,
            position: "bottom-left",
            type: "warning"
          });
        }
        if (res.code == 200) {
          this.$notify({
            title: "Wonderfull",
            message: "The user name is available",
            position: "bottom-left",
            type: "success"
          });
        }
      });
    },
    passwordSureInput() {
      if (this.password == this.passwordSure && this.passwordSure != "") {
        this.$notify({
          title: "Wonderfull",
          message: "Two passwords are the same",
          position: "bottom-left",
          type: "success"
        });
        return;
      }
      if (this.passwordSure == "") {
        return;
      }
      this.$notify({
        title: "Warning",
        message: "Two passwords are not the same，please re-enter",
        position: "bottom-left",
        type: "warning"
      });
    },
    register() {
      if (this.username == "") {
        this.$notify.error("Please enter the username");
        return;
      }
      if (this.nickname == "") {
        this.$notify.error("Please enter the nickname");
        return;
      }
      if (this.password == "") {
        this.$notify.error("Please enter the password");
        return;
      }
      if (this.passwordSure == "") {
        this.$notify.error("Please enter the password again");
        return;
      }
      if (this.phone == "") {
        this.$notify.error("Please enter the phone");
        return;
      }
      if (this.email == "") {
        this.$notify.error("Please enter the email");
        return;
      }
      if (this.password != this.passwordSure) {
        this.$notify.error("Two passwords are not the same，please re-enter");
        return;
      }
      this.$post("/user/register", {
        username: this.username,
        password:this.password,
        name:this.nickname,
        phone:this.phone,
        email:this.email,
        role_id:this.role_id
      }).then(res => {
        if (res.code == 504) {
          this.$notify.error("The user name already exists");
        }
        if (res.code == 200) {
          this.change();
          this.$notify.success("Registered successfully");
        }
      });
    },
    login() {
      if (this.username == "") {
        this.$notify.error("Please enter the user name");
        return;
      }
      if (this.password == "") {
        this.$notify.error("Please enter the password");
        return;
      }
      if (this.checkCode == "") {
        this.$notify.error("Please enter the verification code");
        return;
      }
      if (this.checkCode != this.Code) {
        this.$notify.warning("The verification code is error");
        return;
      }
   
      this.$post("/user/login", {
        username: this.username,
        password: this.password
      }).then(res => {
     
        console.log(res)
        if (res.message == "User doesn't exist") {
          this.$notify.warning("User doesn't exist");
          return;
        }
        if (res.message == "Password is wrong") {
          this.$notify.warning("Password is wrong");
          return;
        }
        if (res.code == 200) {
          // this.$root.user_id=res.data.user_id;
          sessionStorage.setItem("user_id", res.data.user_id);
          sessionStorage.setItem("jwt", res.data.jwt);
          sessionStorage.setItem("isLogin", true);
          sessionStorage.setItem("role_id", res.data.role_id);
          console.log(sessionStorage.getItem("user_id"));
          this.$message.success("Login Successfull");
          this.$router.push("/main");
        }
      });
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.flex {
  display: flex;
  width: 50%;
  flex-direction: column;
  align-items: center;
}
.box {
  margin-top: 10rem;
  width: 85%;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  height: 30rem;
}
.box-register {
  margin-top: 5rem;
  width: 85%;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  height: 40rem;
}
.title {
  width: 35rem;
}
.input >>> .el-input__inner {
  height: 50px !important;
}
.radio >>> .el-radio__input.is-checked .el-radio__inner {
  border-color: #f46774;
  background: #f46774;
}
.radio >>> .el-radio__input.is-checked + .el-radio__label {
  color: #f46774;
}
.btn {
  width: 15rem;
  height: 3.2rem;
  font-size: 20px;
}
.register {
  width: 5rem;
  font-size: 18px;
}
.slideshow {
  list-style: none;
  z-index: -1;
}
.slideshow li span {
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0px;
  left: 0px;
  color: transparent;
  background-size: cover;
  background-position: 50% 50%;
  background-repeat: none;
  opacity: 0;
  z-index: 0;
  -webkit-backface-visibility: hidden;
  backface-visibility: hidden;
  -webkit-animation: imageAnimation 24s linear infinite 0s;
  -moz-animation: imageAnimation 24s linear infinite 0s;
  animation: imageAnimation 24s linear infinite 0s;
}
.slideshow li:nth-child(1) span {
  background-image: url(https://i.loli.net/2020/07/01/8nRNvQr31u2GOEJ.jpg);
}

.slideshow li:nth-child(2) span {
  background-image: url(https://i.loli.net/2020/07/01/a8P7pQ2qzNm9X16.jpg);
  -webkit-animation-delay: 6s;
  -moz-animation-delay: 6s;
  animation-delay: 6s;
}
.slideshow li:nth-child(3) span {
  background-image: url(https://i.loli.net/2020/07/01/8nRNvQr31u2GOEJ.jpg);
  -webkit-animation-delay: 12s;
  -moz-animation-delay: 12s;
  animation-delay: 12s;
}
.slideshow li:nth-child(4) span {
  background-image: url(https://i.loli.net/2020/07/01/a8P7pQ2qzNm9X16.jpg);
  -webkit-animation-delay: 18s;
  -moz-animation-delay: 18s;
  animation-delay: 18s;
}
@-webkit-keyframes imageAnimation {
  0% {
    opacity: 0;
    -webkit-animation-timing-function: ease-in;
  }

  12.5% {
    opacity: 1;
    -webkit-animation-timing-function: ease-out;
  }

  25% {
    opacity: 1;
  }

  37.5% {
    opacity: 0;
  }

  100% {
    opacity: 0;
  }
}

@-moz-keyframes imageAnimation {
  0% {
    opacity: 0;
    -moz-animation-timing-function: ease-in;
  }

  12.5% {
    opacity: 1;
    -moz-animation-timing-function: ease-out;
  }

  25% {
    opacity: 1;
  }

  37.5% {
    opacity: 0;
  }

  100% {
    opacity: 0;
  }
}

@keyframes imageAnimation {
  0% {
    opacity: 0;
    -webkit-animation-timing-function: ease-in;
    -moz-animation-timing-function: ease-in;
    animation-timing-function: ease-in;
  }

  12.5% {
    opacity: 1;
    -webkit-animation-timing-function: ease-out;
    -moz-animation-timing-function: ease-out;
    animation-timing-function: ease-out;
  }

  25% {
    opacity: 1;
  }

  37.5% {
    opacity: 0;
  }

  100% {
    opacity: 0;
  }
}

@-webkit-keyframes titleAnimation {
  0% {
    opacity: 0;
  }

  12.5% {
    opacity: 1;
  }

  25% {
    opacity: 1;
  }

  37.5% {
    opacity: 0;
  }

  100% {
    opacity: 0;
  }
}

@-moz-keyframes titleAnimation {
  0% {
    opacity: 0;
  }

  12.5% {
    opacity: 1;
  }

  25% {
    opacity: 1;
  }

  37.5% {
    opacity: 0;
  }

  100% {
    opacity: 0;
  }
}

@keyframes titleAnimation {
  0% {
    opacity: 0;
  }

  12.5% {
    opacity: 1;
  }

  25% {
    opacity: 1;
  }

  37.5% {
    opacity: 0;
  }

  100% {
    opacity: 0;
  }
}

.no-cssanimations .slideshow li span {
  opacity: 1;
}
</style>
