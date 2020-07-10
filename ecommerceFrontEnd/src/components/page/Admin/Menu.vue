<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/main' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>Menu management</el-breadcrumb-item>
    </el-breadcrumb>
    <br />
    <br />

    <span>
      Search：
      <el-input style="width:15rem" placeholder="Menu title" @input="search" v-model="title"></el-input>
    </span>
    <el-button type="danger" icon="el-icon-plus" @click="dialog = true">Add</el-button>

    <el-divider></el-divider>
    <el-table :data="tableData" style="width: 100%" class="table">
      <el-table-column type="selection" width="50"></el-table-column>
      <el-table-column prop="title" label="Menu title"></el-table-column>
      <el-table-column prop="index" label="Index"></el-table-column>
      <el-table-column prop="icon" label="icon"></el-table-column>
      <el-table-column label="operation">
        <template slot-scope="scope">
          <el-button type="danger" size="mini" icon="el-icon-edit" @click="edit(scope.row)">Edit</el-button>
          <el-button type="danger" size="mini" icon="el-icon-delete" @click="remove(scope.$index, tableData)">Delete</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="Menu info" :visible.sync="dialog" width="30%">
      <el-form :model="userForm" ref="userForm" label-width="130px">
        <el-form-item
          label="Menu title"
          prop="title"
          :rules="[{ required: true, message: 'Please enter the Menu title'}]"
        >
          <el-input style="width:20rem" v-model="userForm.title" autocomplete="off"></el-input>
        </el-form-item>
        <br />
        <el-form-item
          label="index"
          prop="index"
          :rules="[{ required: true, message: 'Please enter the index'}]"
        >
          <el-input style="width:20rem" v-model="userForm.index" autocomplete="off"></el-input>
        </el-form-item>
        <br />
        <el-form-item
          label="icon"
          prop="icon"
          :rules="[{ required: true, message: 'Please enter the icon'}]"
        >
          <el-input style="width:20rem" v-model="userForm.icon" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="cancel('userForm')">cancel</el-button>
        <el-button type="danger" @click="submitForm('userForm')">Sure</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      title: "",
      dialog: false,
      tableData: [
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
        },
        
      ],
      userForm: {
        title: "",
        icon: "",
        index: ""
      }
    };
  },
  methods: {
    search() {},
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          console.log(this.userForm);
          this.dialog = false;
        } else {
          return false;
        }
      });
    },
    cancel(formName) {
      this.userForm = {
        title: "",
        icon: "",
        index: ""
      };
      this.dialog = false;
    },
    edit(row) {
      let temp = row;
      this.userForm = temp;
      this.dialog = true;
    },
    remove(index, rows) {
      rows.splice(index, 1);
    }
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