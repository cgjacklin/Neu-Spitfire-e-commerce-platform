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
    <el-button type="danger" icon="el-icon-plus" @click="add">Add</el-button>

    <el-divider></el-divider>
    <el-table
      :data="tableData"
      style="width: 100%"
      class="table"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="50"></el-table-column>
      <el-table-column prop="user_id" label="User id"></el-table-column>
      <el-table-column prop="username" label="User name"></el-table-column>
      <el-table-column prop="name" label="Nick name"></el-table-column>
      <el-table-column prop="role_id" label="Role"></el-table-column>
      <el-table-column prop="phone" label="Phone number"></el-table-column>
      <el-table-column prop="email" label="E-mail"></el-table-column>
      <el-table-column label="operation">
        <template slot-scope="scope">
          <el-button type="warning" size="mini" icon="el-icon-user" @click="permissions(scope.row)"></el-button>
          <el-button type="success" size="mini" icon="el-icon-edit" @click="edit(scope.row)"></el-button>
          <el-button type="danger" size="mini" icon="el-icon-delete" @click="remove(scope.row)"></el-button>
        </template>
      </el-table-column>
    </el-table>
    <br />
    <el-button size="medium" type="danger" icon="el-icon-delete" @click="removeMore">Batch</el-button>
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
            prop="name"
            :rules="[{ required: true, message: 'Please enter the nickname'}]"
          >
            <el-input style="width:20rem" v-model="userForm.name" autocomplete="off"></el-input>
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
            prop="role_id"
            :rules="[{ required: true, message: 'Please choose the Role'}]"
          >
            <el-radio v-model="userForm.role_id" label="MVO">Brand-seller</el-radio>
            <el-radio v-model="userForm.role_id" label="BVO">Borrow-seller</el-radio>
          </el-form-item>

          <el-form-item class="user-form-button">
            <el-button type="danger" @click="submitForm('userForm')">Sure</el-button>
            <el-button @click="cancel('userForm')">Cancel</el-button>
          </el-form-item>
          <br />
        </el-form>
      </div>
    </el-drawer>
    <!-- direction="ltr" -->
    <el-drawer title="drawer" :visible.sync="drawerPr" size="20%" :with-header="false">
      <div class="form-div">
        <h3>Permission Assignment</h3>
        <span>Admin：</span>
        <div class="switch" v-for="item in menu0" :key="item.menu_id">
          <el-switch v-model="item.state" active-color="#13ce66" inactive-color="#D8D8D8" @change="changePermission($event,item.menu_id)"></el-switch>
          <p class="p-menu">
            <i :class="item.menu_icon"></i>
            {{item.menu_name}}
          </p>
        </div>
        <span>MVO：</span>
        <div class="switch" v-for="item in menu1" :key="item.menu_id">
          <el-switch v-model="item.state" active-color="#13ce66" inactive-color="#D8D8D8" @change="changePermission($event,item.menu_id)"></el-switch>
          <p class="p-menu">
            <i :class="item.menu_icon"></i>
            {{item.menu_name}}
          </p>
        </div>
        <span>BVO：</span>
        <div class="switch" v-for="item in menu2" :key="item.menu_id">
          <el-switch v-model="item.state" active-color="#13ce66" inactive-color="#D8D8D8" @change="changePermission($event,item.menu_id)"></el-switch>
          <p class="p-menu">
            <i :class="item.menu_icon"></i>
            {{item.menu_name}}
          </p>
        </div>
      </div>
    </el-drawer>
  </div>
</template>

<script>
export default {
  data() {
    return {
      menu0: [],
      menu1: [],
      menu2: [],
      beingChangedUserID:0,
      search_name: "",
      drawerPr: false,
      drawer: false,
      isAdd: false,
      tableData: [],
      table: [],
      multipleSelection: [],
      userForm: {
        username: "",
        name: "",
        password: "",
        phone: "",
        email: "",
        role_id: ""
      }
    };
  },
  mounted() {
    this.$post("/wal/getroleid", {
      user_id: sessionStorage.getItem("user_id")
    }).then(res => {
      if (res.message == "0") {
        this.getUsers();
      } else {
        this.$message.warning("Permission denied");
      }
    });
  },
  methods: {
    getUsers() {
      this.$post("/rle/getUsers", {
        user_id: sessionStorage.getItem("user_id")
      }).then(res => {
        if (res.code == 200) {
          this.tableData = res.data.user;
          this.table = res.data.user;
        } else {
          if (res.message == "Permission denied") {
            this.$message.warning("Permission denied");
          }
        }
      });
    },
    permissions(row) {    //权限管理获取状态列表
      this.$post("/menuList/getAllMenusWithState", {
        user_id: row.user_id
      }).then(res => {
        if (res.code == 504) {
          this.$message.warning(res.message);
          return;
        }
        if (res.code == 200) {
          this.menu0 = res.data.filter(e => e.parent_id == 0);
          this.menu1 = res.data.filter(e => e.parent_id == 1);
          this.menu2 = res.data.filter(e => e.parent_id == 2);
          this.beingChangedUserID = row.user_id;
        }
      });

      this.drawerPr = true;
    },
    changePermission(state,menu_id){  //权限改变回调函数
      if(this.beingChangedUserID==0){
        this.$message.warning("You are changing the wrong user, confirm user again.");
      }
      if(state == true){
        this.$post("/menuList/addMenuList", {
        user_id: this.beingChangedUserID,
        menu_id: menu_id
      }).then(res => {
        if (res.code == 504) {
          this.$message.warning("Permission modification failed, try again");
          this.drawerPr = false;
          return;
        }
        if (res.code == 200) {
          this.$message.success("Success upgrade permission of current user!");
        }
      });
      }
      if(state == false){
        this.$post("/menuList/deleteMenuList", {
        user_id: this.beingChangedUserID,
        menu_id: menu_id
      }).then(res => {
        if (res.code == 504) {
          this.$message.warning("Permission modification failed, try again");
          this.drawerPr = false;
          return;
        }
        if (res.code == 200) {
          this.$message.success("Success degrade permission of current user!");
        }
      });
      }
      console.log(state);
    },
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          if (this.isAdd) {
            this.$message.warning(
              "The system only supports adding users from the registration page"
            );
            this.isAdd = false;
          } else {
            this.$post("/rle/updateUser", {
              admin_id: sessionStorage.getItem("user_id"),
              user_id: this.userForm.userid,
              username: this.userForm.username,
              password: this.userForm.password,
              name: this.userForm.nickname,
              email: this.userForm.email,
              phone: this.userForm.phone,
              role_id: this.userForm.role
            }).then(res => {
              if (res.code == 200) {
                this.$message.success("Successfully update!");
              } else {
                this.$message.warning("Update failed");
              }
            });
          }
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
    add() {
      this.isAdd = true;
      this.userForm = [];
      this.drawer = true;
    },
    edit(row) {
      this.userForm = row;
      if (this.userForm.role == "Admin") {
        this.$message.warning("Can't edit the admin account");
        return;
      }
      this.drawer = true;
    },
    remove(row) {
      this.$post("/rle/deletedUser", {
        user_id: sessionStorage.getItem("user_id"),
        delete_id: row.user_id
      }).then(res => {
        if (res.code == 200) {
          this.getUsers();
          this.$message.success("Delete success");
        } else {
          this.$message.warning("Delete failed");
        }
      });
    },
    removeMore() {
      if (this.multipleSelection.length == 0) {
        this.$message.warning("Please select item");
        return;
      }
      this.multipleSelection.forEach(element => {
        this.$post("/rle/deletedUser", {
          user_id: sessionStorage.getItem("user_id"),
          delete_id: element.user_id
        }).then(res => {
          if (res.code == 200) {
            this.getUsers();
          } else {
            this.$message.warning("Delete failed");
          }
        });
      });

      this.$message.success("Delete success");
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    search() {
      this.tableData = this.table.filter(e =>
        e.username.match(this.search_name)
      );
    }
  }
};
</script>

<style scoped>
.p-menu {
  margin-left: 1rem;
}
.switch {
  display: flex;
  flex-direction: row;
  align-items: center;
}
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