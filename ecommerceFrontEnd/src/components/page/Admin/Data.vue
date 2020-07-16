<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/main' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>Data dictionary</el-breadcrumb-item>
    </el-breadcrumb>
    <br />
    <br />

    <span>
      Search：
      <el-input
        style="width:15rem"
        placeholder="Dictionary type"
        @input="search"
        v-model="search_name"
      ></el-input>
    </span>
    <el-button type="danger" icon="el-icon-plus" @click="dialogVisible = true; isAdd = true">Add</el-button>

    <el-divider></el-divider>
    <el-table :data="tableData" style="width: 100%" class="table">
      <el-table-column type="selection" width="50"></el-table-column>
      <el-table-column prop="code_type" label="Dictionary type"></el-table-column>
      <el-table-column prop="description" label="Description"></el-table-column>
      <el-table-column prop="type_cd" label="Code"></el-table-column>
      <el-table-column prop="code_val" label="Code value"></el-table-column>
      <el-table-column label="operation">
        <template slot-scope="scope">
          <el-button type="danger" size="mini" @click="edit(scope.row)">Edit</el-button>
          <el-button type="danger" size="mini" @click="remove(scope.row, scope.$index)">Delete</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="Data dictionary info" :visible.sync="dialogVisible" width="30%">
      <el-form :model="dataForm" ref="dataForm" label-width="120px">
        <el-form-item
          label="Dictionary type"
          prop="code_type"
          :rules="[{ required: true, message: 'Please enter the dictionary type'}]"
        >
          <el-input style="width:20rem" v-model="dataForm.code_type" autocomplete="off"></el-input>
        </el-form-item>
        <br />
        <el-form-item
          label="Description"
          prop="description"
          :rules="[{ required: true, message: 'Please enter the description'}]"
        >
          <el-input style="width:20rem" v-model="dataForm.description" autocomplete="off"></el-input>
        </el-form-item>
        <br />
        <el-form-item
          label="Code"
          prop="type_cd"
          :rules="[{ required: true, message: 'Please enter the type_cd'}]"
        >
          <el-input style="width:20rem" v-model="dataForm.type_cd" autocomplete="off"></el-input>
        </el-form-item>
        <br />
        <el-form-item
          label="Code value"
          prop="code_val"
          :rules="[{ required: true, message: 'Please enter the value'}]"
        >
          <el-input style="width:20rem" v-model="dataForm.code_val" autocomplete="off"></el-input>
        </el-form-item>
        <br />
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button type="danger" @click="submitForm('dataForm')">Sure</el-button>
        <el-button @click="cancel('dataForm')">Cancel</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      search_name: "",
      dialogVisible: false,
      tableData: [],
      table: [],
      isAdd: false,
      opRow: "",
      dataForm: {
        code_type: "",
        description: "",
        type_cd: "",
        code_val: ""
      }
    };
  },
  mounted() {
    this.$post("/dictionary/getDictionaries", {}).then(res => {
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
    search() {
      this.tableData = this.table.filter(e =>
        e.code_type.match(this.search_name)
      );
    },
    refresh() {
      this.$post("/dictionary/getDictionaries", {}).then(res => {
        //处理response
        console.log(res);
        if (res.code == 504) {
          this.$message.warning(res.message);
          return;
        }
        if (res.code == 200) {
          this.table = res.data;
          this.tableData = res.data;
        }
      });
    },
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          if (!this.isAdd) {
            // console.log(this.dataForm.param_value);
            this.$post("/dictionary/updateDictionary", {
              user_id: sessionStorage.getItem("user_id"),
              cdm_id: this.opRow.cdm_id,
              code_type: this.dataForm.code_type,
              description: this.dataForm.description,
              code_val: this.dataForm.code_val,
              type_cd: this.dataForm.type_cd
            }).then(res => {
              // console.log(this.opRow.param_value);
              // console.log(this.dataForm.param_value);
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
            this.$post("/dictionary/addDictionary", {
              user_id: sessionStorage.getItem("user_id"),
              // cdm_id: this.opRow.cdm_id,
              code_type: this.dataForm.code_type,
              description: this.dataForm.description,
              code_val: this.dataForm.code_val,
              type_cd: this.dataForm.type_cd
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
        this.dataForm.code_type = row.code_type;
        this.dataForm.description = row.description;
        this.dataForm.type_cd = row.type_cd;
        this.dataForm.code_val = row.code_val;
      });
    },
    remove(row, index) {
      this.$post("/dictionary/deleteDictionary", {
        cdm_id: row.cdm_id
      }).then(res => {
        if (res.code == 504) {
          this.$message.warning(res.message);
          return;
        }
        if (res.code == 200) {
          // this.$root.user_id=res.data.user_id;
          this.$message.success(res.message);
          // this.tableData.splice(index);
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