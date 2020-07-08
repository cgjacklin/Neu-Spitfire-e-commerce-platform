<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/main' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>Wallet</el-breadcrumb-item>
    </el-breadcrumb>
    <div v-show="emptyShow" class="empty-box">
      <img style="width:25rem" :src="emptyImage" alt />
      <span>You have not registered a wallet account.</span>
      <el-button type="danger" @click="dialogVisible=true">Register</el-button>
    </div>

    <div v-show="mainShow" class="main-box-top">
      <div class="card-div">
        <div class="bank-card">
          <span class="account">Account: {{name}}</span>
          <span class="account">Available Money: ${{money}}</span>
        </div>
        <br />
        <div class="btn-div">
          <el-popover placement="right" width="380" v-model="visible1">
            <div class="password">
              <el-input
                style="width:300px"
                v-model="password"
                placeholder="Please enter your wallet password."
                prefix-icon="el-icon-lock"
                show-password
              ></el-input>
              <el-button type="danger" size="small" @click="WithdrawPass">Sure</el-button>
            </div>
            <el-button style="width:10rem" type="danger" slot="reference" round plain>Withdraw</el-button>
          </el-popover>

          <el-popover placement="right" width="380" v-model="visible">
            <div class="password">
              <el-input
                style="width:300px"
                v-model="password"
                placeholder="Please enter your wallet password."
                prefix-icon="el-icon-lock"
                show-password
              ></el-input>
              <el-button type="danger" size="small" @click="AccountPass">Sure</el-button>
            </div>
            <el-button style="width:10rem" type="danger" slot="reference" round plain>Account manage</el-button>
          </el-popover>
        </div>
      </div>

      <div class="main-box-top">
        <el-link style="font-size:18px" :underline="false" type="success">Withdrawal Records</el-link>
        <el-divider></el-divider>
        <span>Records time：</span>
        <el-date-picker
          v-model="time"
          type="daterange"
          align="right"
          unlink-panels
          range-separator="to"
          start-placeholder="Begin date"
          end-placeholder="End date"
          value-format="yyyy-MM-dd"
        ></el-date-picker>

        <el-table :data="tableData" style="width: 100%" class="table">
          <el-table-column prop="num" label="Transaction Number"></el-table-column>
          <el-table-column prop="amount" label="amount"></el-table-column>
          <el-table-column prop="time" label="Create Time"></el-table-column>
          <el-table-column prop="state" label="State">
            <template slot-scope="scope">
              <el-tag disable-transitions>{{scope.row.state}}</el-tag>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </div>
    <el-dialog title="Withdraw" :visible.sync="dialogWithdraw" width="30%">
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogWithdraw = false">cancel</el-button>
        <el-button type="danger" @click="dialogWithdraw= false">sure</el-button>
      </span>
    </el-dialog>

    <el-dialog title="Password management" :visible.sync="dialogAccount" width="30%">
      <el-form :model="passwordForm" ref="passwordForm" label-width="120px">
        <el-form-item
          label="new password"
          prop="password"
          :rules="[{ validator: validatePass3, trigger: 'blur' }]"
        >
          <el-input
            style="width:20rem"
            show-password
            v-model="passwordForm.password"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <br />
        <el-form-item
          label="check Password"
          prop="checkPass"
          :rules="[{ validator: validatePass4, trigger: 'blur' }]"
        >
          <el-input
            style="width:20rem"
            show-password
            v-model="passwordForm.checkPass"
            autocomplete="off"
          ></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="diaCancel('passwordForm')">cancel</el-button>
        <el-button type="danger" @click="passwordSubForm('passwordForm')">sure</el-button>
      </span>
    </el-dialog>

    <el-dialog title="Wallet account registration" :visible.sync="dialogVisible" width="30%">
      <el-form :model="walletRegForm" ref="walletRegForm" label-width="120px">
        <el-form-item
          label="Account Name"
          prop="name"
          :rules="[{ required: true, message: 'Please enter the account name'}]"
        >
          <el-input style="width:20rem" v-model="walletRegForm.name" autocomplete="off"></el-input>
        </el-form-item>
        <br />
        <el-form-item
          label="password"
          prop="password"
          :rules="[{ validator: validatePass, trigger: 'blur' }]"
        >
          <el-input
            style="width:20rem"
            show-password
            v-model="walletRegForm.password"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <br />
        <el-form-item
          label="check Password"
          prop="checkPass"
          :rules="[{ validator: validatePass2, trigger: 'blur' }]"
        >
          <el-input
            style="width:20rem"
            show-password
            v-model="walletRegForm.checkPass"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <br />
        <el-form-item
          label="E-mail"
          prop="email"
          :rules="[{ required: true, message: 'Please enter your email'},{ type:'email', message: 'Invalid format'}]"
        >
          <el-input style="width:20rem" v-model="walletRegForm.email" autocomplete="off"></el-input>
        </el-form-item>
        <br />
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="diaCancel('walletRegForm')">cancel</el-button>
        <el-button type="danger" @click="regForm('walletRegForm')">sure</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("Please enter the password"));
      } else {
        if (this.walletRegForm.checkPass !== "") {
          this.$refs.walletRegForm.validateField("checkPass");
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("Please enter the password again"));
      } else if (value !== this.walletRegForm.password) {
        callback(new Error("Two passwords are not the same，please re-enter"));
      } else {
        callback();
      }
    };
    var validatePass3 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("Please enter the password"));
      } else {
        if (this.passwordForm.checkPass !== "") {
          this.$refs.passwordForm.validateField("checkPass");
        }
        callback();
      }
    };
    var validatePass4 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("Please enter the password again"));
      } else if (value !== this.passwordForm.password) {
        callback(new Error("Two passwords are not the same，please re-enter"));
      } else {
        callback();
      }
    };
    return {
      emptyImage: require("../../../assets/empty-wallet.png"),
      emptyShow: false,
      mainShow: true,
      time: "",
      visible: false,
      visible1: false,
      tableData: [{ state: 3 }],
      dialogVisible: false,
      dialogWithdraw: false,
      dialogAccount: false,
      validatePass: validatePass,
      validatePass2: validatePass2,
      validatePass3: validatePass3,
      validatePass4: validatePass4,
      name: "bbb",
      money: "1",
      password: "",
      passwordForm: {
        password: "",
        checkPass: ""
      },
      walletRegForm: {
        name: "",
        password: "",
        checkPass: "",
        email: ""
      }
    };
  },
  methods: {
    WithdrawPass(){
      if (this.password != "aaa") {
        this.$message.warning("Password is wrong.");
        return;
      }
      this.dialogWithdraw = true;
      this.visible1 = false;
    },
    AccountPass() {
      if (this.password != "aaa") {
        this.$message.warning("Password is wrong.");
        return;
      }
      this.dialogAccount = true;
      this.visible = false;
    },
    passwordSubForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          console.log(this.passwordForm);
          this.dialogAccount = false;
        } else {
          return false;
        }
      });
    },
    regForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          console.log(this.walletRegForm);
          this.dialogVisible = false;
          this.emptyShow = false;
          this.mainShow = true;
        } else {
          return false;
        }
      });
    },
    diaCancel(formName) {
      this.$refs[formName].resetFields();
      this.dialogVisible = false;
      this.dialogAccount = false;
    }
  }
};
</script>

<style scoped>
.empty-box {
  height: 40rem;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
}
.main-box-top {
  margin-top: 2rem;
}
.bank-card {
  width: 32.3rem;
  height: 20rem;
  background-image: url("https://i.loli.net/2020/07/08/oZtnwqzTxS64Mf7.png");
  background-size: contain;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}
.account {
  color: white;
  font-size: 22px;
  margin-left: 3rem;
  font-weight: bold;
  height: 3rem;
}
.card-div {
  width: 50rem;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
.btn-div {
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  height: 20rem;
}
.table {
  margin-top: 2rem;
}
.password {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
</style>