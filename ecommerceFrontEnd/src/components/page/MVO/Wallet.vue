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
      <div>
    
        <div class="bank-card"></div>
        <br />
        <el-button type="danger" @click="drawer=true">Change</el-button>
      </div>
      <div class="main-box-top">
        <el-link style="font-size:18px" :underline="false" type="success">Withdrawal Record</el-link>
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

        <el-table :data="tableData" style="width: 100%">
          <el-table-column prop="name" label="Brand Name"></el-table-column>
          <el-table-column prop="logo" label="Brand Logo"></el-table-column>
          <el-table-column label="operation">
            <template slot-scope="scope">
              <el-button type="danger" size="mini" @click="change(scope.$index, scope.row)">change</el-button>
              <el-button type="danger" size="mini">delete</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </div>

    <el-dialog title="Wallet account registration" :visible.sync="dialogVisible" width="30%">
      <el-form :model="walletRegForm" ref="walletRegForm" label-width="120px" class="form">
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
        <el-button type="danger" @click="submitForm('walletRegForm')">sure</el-button>
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
    return {
      emptyImage: require("../../../assets/empty-wallet.png"),
      emptyShow: true,
      mainShow: false,
      time: "",
      tableData:[],
      dialogVisible: false,
      validatePass: validatePass,
      validatePass2: validatePass2,
      walletRegForm: {
        name: "",
        password: "",
        checkPass: "",
        email: ""
      }
    };
  },
  methods: {
    submitForm(formName) {
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
.bank-card{
    width: 32.3rem;
    height: 20rem;
    background-image: url('https://i.loli.net/2020/07/08/oZtnwqzTxS64Mf7.png');
    background-size: contain
}
</style>