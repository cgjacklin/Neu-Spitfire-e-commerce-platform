<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/main' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>User management</el-breadcrumb-item>
    </el-breadcrumb>
    <br />
    <br />

    <span>
      Search：
      <el-input style="width:15rem" placeholder="User name" @input="search" v-model="search_name"></el-input>
    </span>
    <el-button type="danger" icon="el-icon-plus" @click="drawer = true">Add</el-button>

    <el-divider></el-divider>
    <el-table :data="tableData" style="width: 100%" class="table">
      <el-table-column type="selection" width="50"></el-table-column>
      <el-table-column prop="username" label="User name"></el-table-column>
      <el-table-column prop="role" label="Role"></el-table-column>
      <el-table-column prop="nickname" label="Nick name"></el-table-column>
      <el-table-column prop="phone" label="Phone number"></el-table-column>
      <el-table-column prop="email" label="E-mail"></el-table-column>
      <el-table-column label="operation">
        <template slot-scope="scope">
          <el-button type="danger" size="mini" @click="edit(scope.row)">Edit</el-button>
          <el-button type="danger" size="mini" @click="remove(scope.row)">Delete</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-drawer title="drawer" :visible.sync="drawer" size="35%" :with-header="false">
      <div class="form-div">
        <h3>User info</h3>
        <el-form :model="userForm" ref="userForm" label-width="130px" class="add-user-form">
          <el-form-item
            label="User name"
            prop="username"
            :rules="[{ required: true, message: 'Please enter the User name'}]"
          >
            <el-input style="width:20rem" v-model="userForm.username" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="Nick name"
            prop="nickname"
            :rules="[{ required: true, message: 'Please enter the nickname'}]"
          >
            <el-input style="width:20rem" v-model="userForm.nickname" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="Password"
            prop="password"
            :rules="[{ required: true, message: 'Please enter the password'}]"
          >
            <el-input
              style="width:20rem"
              v-model="userForm.password"
              autocomplete="off"
              show-password
            ></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="Phone"
            prop="phone"
            :rules="[{ required: true, message: 'Please enter the phone'}]"
          >
            <el-input style="width:20rem" v-model="userForm.phone" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="E-mail"
            prop="email"
            :rules="[{ required: true, message: 'Please enter the E-mail'}]"
          >
            <el-input style="width:20rem" v-model="userForm.email" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item
            class="radio"
            label="Role"
            prop="role"
            :rules="[{ required: true, message: 'Please choose the Role'}]"
          >
            <el-radio v-model="userForm.role" label="1">Brand-seller</el-radio>
            <el-radio v-model="userForm.role" label="2">Borrow-seller</el-radio>
          </el-form-item>

          <el-form-item class="user-form-button">
            <el-button type="danger" @click="submitForm('userForm')">Sure</el-button>
            <el-button @click="cancel('userForm')">Cancel</el-button>
          </el-form-item>
          <br />
        </el-form>
      </div>
    </el-drawer>
  </div>
</template>

<script>
export default {
  data() {
    return {
      drawer: false,
      tableData: [{ username: 1 }],
      userForm: {
        username: "",
        nickname: "",
        password: "",
        phone: "",
        email: "",
        role: ""
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          console.log(this.userForm);
          this.drawer = false;
        } else {
          return false;
        }
      });
    },
    cancel(formName) {
      this.$refs[formName].resetFields();
      this.drawer = false;
    },
    edit(row) {
      this.userForm = row;
      this.drawer = true;
    },
    remove() {}
  }
};
</script>

<style scoped>
.form-div {
  margin-left: 3rem;
  height: 50rem;
}
.add-user-form {
  margin-top: 5rem;
}
.user-form-button {
  margin-top: 3rem;
  margin-left: 10rem;
}
.table >>> .el-checkbox__input.is-indeterminate .el-checkbox__inner {
  background-color: #f56c6c;
  border-color: #f56c6c;
}
.table >>> .el-checkbox__input.is-checked .el-checkbox__inner {
  background-color: #f56c6c;
  border-color: #f56c6c;
}
.table >>> .el-checkbox__input.is-checked + .el-checkbox__label {
  color: #f56c6c;
}
.radio >>> .el-radio__input.is-checked .el-radio__inner {
  border-color: #f46774;
  background: #f46774;
}
.radio >>> .el-radio__input.is-checked + .el-radio__label {
  color: #f46774;
}
</style>