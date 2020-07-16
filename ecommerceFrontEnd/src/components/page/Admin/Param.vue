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
      <el-input style="width:15rem" placeholder="Primary key" @input="search" v-model="search_name"></el-input>
    </span>
    <el-button type="danger" icon="el-icon-plus" @click="dialogVisible = true; isAdd=true">Add</el-button>

    <el-divider></el-divider>
    <el-table :data="tableData" style="width: 100%" class="table">
      <el-table-column type="selection" width="50"></el-table-column>
      <el-table-column prop="param_cd" label="Primary key"></el-table-column>
      <el-table-column prop="param_value" label="Parameter Value"></el-table-column>
      <el-table-column prop="description" label="Description"></el-table-column>
      <el-table-column label="operation">
        <template slot-scope="scope">
          <el-button type="danger" size="mini" @click="edit(scope.row)">Edit</el-button>
          <el-button type="danger" size="mini" @click="remove(scope.row, scope.$index)">Delete</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="Parameter info" :visible.sync="dialogVisible" width="30%">
      <el-form :model="paramForm" ref="paramForm" label-width="130px">
        <el-form-item
          label="Primary key"
          prop="param_cd"
          :rules="[{ required: true, message: 'Please enter the Primary key'}]"
        >
          <el-input style="width:20rem" v-model="paramForm.param_cd" autocomplete="off"></el-input>
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
          prop="param_value"
          :rules="[{ required: true, message: 'Please enter the value'}]"
        >
          <el-input style="width:20rem" v-model="paramForm.param_value" autocomplete="off"></el-input>
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
      isAdd: false,
      search_name: "",
      tableData: [],
      table:[],
      opRow: "",
      opIndex: "",
      paramForm: {
        param_cd: "",
        description: "",
        param_value: ""
      }
    };
  },
  mounted() {
    this.$post("/parameter/getParameters", {}).then(res => {
      //处理response
      console.log(res);
      if (res.code == 504) {
        this.$message.warning(res.message);
        return;
      }
      if (res.code == 200) {
        // this.$root.user_id=res.data.user_id;
        this.tableData = res.data;
      this.table = res.data;
      }
    });
  },
  methods: {
    search(){
      this.tableData = this.table.filter(e => e.param_cd.match(this.search_name));
    },
    refresh() {
      this.$post("/parameter/getParameters", {}).then(res => {
        //处理response
        console.log(res);
        if (res.code == 504) {
          this.$message.warning(res.message);
          return;
        }
        if (res.code == 200) {
          this.tableData = res.data;
          this.table = res.data;
        }
      });
    },
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          if (!this.isAdd) {
            // console.log(this.paramForm.param_value);
            this.$post("/parameter/updateParameter", {
              user_id: sessionStorage.getItem("user_id"),
              par_id: this.opRow.par_id,
              param_value: this.paramForm.param_value,
              description: this.paramForm.description,
              param_cd: this.paramForm.param_cd
            }).then(res => {
              // console.log(this.opRow.param_value);
              // console.log(this.paramForm.param_value);
              // console.log(res)
              if (res.code == 504) {
                this.$message.warning(res.message);
                return;
              }
              if (res.code == 200) {
                // this.$root.user_id=res.data.user_id;
                this.$message.success(res.message);
                this.refresh();
              }
            });

            this.dialogVisible = false;
            this.$refs[formName].resetFields();
            return;
          }
          if (this.isAdd) {
            this.isAdd = false;
            this.$post("/parameter/addParameter", {
              user_id: sessionStorage.getItem("user_id"),
              param_value: this.paramForm.param_value,
              description: this.paramForm.description,
              param_cd: this.paramForm.param_cd
            }).then(res => {
              if (res.code == 504) {
                this.$message.warning(res.message);
                return;
              }
              if (res.code == 200) {
                // this.$root.user_id=res.data.user_id;
                this.$message.success(res.message);
                this.refresh();
              }
            });

            this.dialogVisible = false;
            this.$refs[formName].resetFields();
            return;
          }
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
      this.opRow = row;
      this.dialogVisible = true;
      this.$nextTick(function() {
        this.paramForm.param_cd = row.param_cd;
        this.paramForm.description = row.description;
        this.paramForm.param_value = row.param_value;
      });
    },
    remove(row, index) {
      this.$post("/parameter/deleteParameter", {
        par_id: row.par_id
      }).then(res => {
        if (res.code == 504) {
          this.$message.warning(res.message);
          return;
        }
        if (res.code == 200) {
          this.$message.success(res.message);
          // this.tableData.splice(index,1);
          this.refresh();
        }
      });
    }
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