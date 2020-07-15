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
       <el-table-column prop="userid" label="User id"></el-table-column>
      <el-table-column prop="username" label="User name"></el-table-column>
      <el-table-column prop="nickname" label="Nick name"></el-table-column>
      <el-table-column prop="role" label="Role"></el-table-column>
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
            <el-radio v-model="userForm.role" label="MVO">Brand-seller</el-radio>
            <el-radio v-model="userForm.role" label="BVO">Borrow-seller</el-radio>
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
        <div class="switch" v-for="item in menu" :key="item.index">
          <el-switch v-model="item.state" active-color="#13ce66" inactive-color="#D8D8D8"></el-switch>
          <p class="p-menu">
            <i :class="item.icon"></i>
            {{item.title}}
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
      menu: [
        {
          icon: "el-icon-school",
          index: "/company",
          title: "Company information",
          state: true
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
        },
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
        }
      ],
      search_name:"",
      drawerPr: false,
      drawer: false,
      tableData: [],
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
      this.tableData = [];
      this.$post("/rle/getUsers", {
        user_id: sessionStorage.getItem("user_id")
      }).then(res => {
        if (res.code == 200) {
          for (var i = 0; i < res.data.user.length; i++) {
            var role;
            if (res.data.user[i].role_id == 1) {
              role = "MVO";
            } else if (res.data.user[i].role_id == 2) {
              role = "BVO";
            } else if (res.data.user[i].role_id == 0) {
              role = "Admin";
            }
            this.tableData.push({
              userid: res.data.user[i].user_id,
              username: res.data.user[i].username,
              nickname: res.data.user[i].name,
              role: role,
              phone: res.data.user[i].phone,
              email: res.data.user[i].email
            });
          }
        } else {
          if (res.message == "Permission denied") {
            this.$message.warning("Permission denied");
          }
        }
      });
    },
    permissions(row) {
      this.drawerPr = true;
    },
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
this.$post("/rle/updateUser", {
        admin_id: sessionStorage.getItem("user_id"),
        user_id:this.userForm.userid,
        username:this.userForm.username,
        password:this.userForm.password,
        name:this.userForm.nickname,
        email:this.userForm.email,
        phone:this.userForm.phone,
        role_id:this.userForm.role
      }).then(res => {
          if(res.code==200){
            this.$message.success("Successfully update!");
          }else{
            this.$message.warning("Update failed");
          }
          this.drawer = false;
      })
          
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
      if(this.userForm.role=="Admin"){
  this.$message.warning("Can't edit the admin account");
  return;
      }
      this.drawer = true;
    },
    remove(row) {
this.$post("/rle/deletedUser", {
        user_id: sessionStorage.getItem("user_id"),
        delete_id:row.userid
      }).then(res => {
        if(res.code==200){
          this.getUsers();
        }else{
          this.$message.warning("Delete failed");
        }
      })
    },
    search(){}
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