<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/main' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>Parameter management</el-breadcrumb-item>
    </el-breadcrumb>
    <br />
    <br />

    <span>
      Search：
      <el-input style="width:15rem" placeholder @input="search" v-model="search_name"></el-input>
    </span>
    <el-button type="danger" icon="el-icon-plus" @click="dialogVisible = true">Add</el-button>

    <el-divider></el-divider>
    <el-table :data="tableData" style="width: 100%" class="table">
      <el-table-column type="selection" width="50"></el-table-column>
      <el-table-column prop="name" label="Primary key"></el-table-column>
      <el-table-column prop="value" label="Parameter Value"></el-table-column>
      <el-table-column prop="description" label="Description"></el-table-column>      
      <el-table-column label="operation">
        <template slot-scope="scope">
          <el-button type="danger" size="mini" @click="edit(scope.row)">Edit</el-button>
          <el-button type="danger" size="mini" @click="remove(scope.row)">Delete</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="Parameter info" :visible.sync="dialogVisible" width="30%">
      <el-form :model="paramForm" ref="paramForm" label-width="130px">
        <el-form-item
          label="Primary key"
          prop="name"
          :rules="[{ required: true, message: 'Please enter the Primary key'}]"
        >
          <el-input style="width:20rem" v-model="paramForm.name" autocomplete="off"></el-input>
        </el-form-item>
        <br />
        <el-form-item
          label="Description"
          prop="description"
          :rules="[{ required: true, message: 'Please enter the description'}]"
        >
          <el-input style="width:20rem" v-model="paramForm.description" autocomplete="off"></el-input>
        </el-form-item>
        <br />
        <el-form-item
          label="Parameter value"
          prop="value"
          :rules="[{ required: true, message: 'Please enter the value'}]"
        >
          <el-input style="width:20rem" v-model="paramForm.value" autocomplete="off"></el-input>
        </el-form-item>
        <br />
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button type="danger" @click="submitForm('paramForm')">Sure</el-button>
        <el-button @click="cancel('paramForm')">Cancel</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogVisible: false,
      tableData: [{ name: 1 }],
      paramForm: {
        name: "",
        description: "",
        value: ""
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          console.log(this.paramForm);
          this.dialogVisible = false;
        } else {
          return false;
        }
      });
    },
    cancel(formName) {
      this.$refs[formName].resetFields();
      this.dialogVisible = false;
    },
    edit(row) {
      this.paramForm.name = row.name;
      this.dialogVisible = true;
    },
    remove() {}
  }
};
</script>

<style scoped>
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
</style>