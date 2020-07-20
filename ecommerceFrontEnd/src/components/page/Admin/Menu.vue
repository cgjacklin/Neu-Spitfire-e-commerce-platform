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
    <el-button type="danger" icon="el-icon-plus" @click="dialog = true; isAdd=true">Add</el-button>

    <el-divider></el-divider>
    <el-table 
    :data="tableData.slice((currentPage-1)*pagesize,currentPage*pagesize)"
    style="width: 100%" 
    class="table"
    height="600"
    >
      <el-table-column prop="menu_name" label="Menu title"></el-table-column>
      <el-table-column prop="menu_url" label="Index"></el-table-column>
      <el-table-column prop="menu_icon" label="icon"></el-table-column>
      <el-table-column label="operation">
        <template slot-scope="scope">
          <el-button type="success" size="mini" icon="el-icon-edit" @click="edit(scope.row)">Edit</el-button>
          <el-button
            type="danger"
            size="mini"
            icon="el-icon-delete"
            @click="remove(scope.$index, tableData)"
          >Delete</el-button>
        </template>
      </el-table-column>
    </el-table>
    <br>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[10,12,tableData.length]"
      :page-size="pagesize"
      layout="total,sizes,prev,pager,next,jumper"
      :total="tableData.length"
    ></el-pagination>

    <el-dialog title="Menu info" :visible.sync="dialog" width="30%">
      <el-form :model="menuForm" ref="menuForm" label-width="130px">
        <el-form-item
          label="Menu title"
          prop="menu_name"
          :rules="[{ required: true, message: 'Please enter the Menu title'}]"
        >
          <el-input style="width:20rem" v-model="menuForm.menu_name" autocomplete="off"></el-input>
        </el-form-item>
        <br />
        <el-form-item
          label="index"
          prop="menu_url"
          :rules="[{ required: true, message: 'Please enter the index'}]"
        >
          <el-input style="width:20rem" v-model="menuForm.menu_url" autocomplete="off"></el-input>
        </el-form-item>
        <br />
        <el-form-item
          label="icon"
          prop="menu_icon"
          :rules="[{ required: true, message: 'Please enter the icon'}]"
        >
          <el-input style="width:20rem" v-model="menuForm.menu_icon" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="cancel('menuForm')">cancel</el-button>
        <el-button type="danger" @click="submitForm('menuForm')">Submit</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      title: "",
      currentPage: 1, //默认页码为1
      pagesize: 10, //默认一页显示11条
      dialog: false,
      tableData: [],
      table: [],
      isAdd: false,
      menuForm: {
        menu_id: "",
        menu_name: "",
        menu_icon: "",
        menu_url: ""
      }
    };
  },
  mounted() {
    this.getData().then(r => {
      this.table = this.tableData;
    });
  },
  methods: {
    handleSizeChange(size) {
      //一页显示多少条
      this.pagesize = size;
    },
    handleCurrentChange(currentPage) {
      //页码更改方法
      this.currentPage = currentPage;
    },
    search() {
      this.tableData = this.table.filter(e => e.menu_name.match(this.title));
    },
    async getData() {
      await this.$post("/menu/getAllMenuList", {
        user_id: sessionStorage.getItem("user_id")
      }).then(res => {
        if (res.code == 504) {
          this.$message.warning(res.message);
          return;
        }
        if (res.code == 200) {
          this.tableData = res.data;
        }
      });
    },
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          if (!this.isAdd) {
            this.$post("/menu/updateMenuInfo", {
              user_id: sessionStorage.getItem("user_id"),
              menu_id: this.menuForm.menu_id,
              menu_name: this.menuForm.menu_name
            }).then(res => {
              if (res.code == 504) {
                this.$message.warning(res.message);
                return;
              }
              if (res.code == 200) {
                this.$message.success(res.message);
                this.getData();
              }
            });
            this.menuForm = {
              menu_id: "",
              menu_name: "",
              menu_icon: "",
              menu_url: ""
            };
          }
          if (this.isAdd) {
            this.isAdd = false;
            this.tableData.push(this.menuForm);
            this.menuForm = {
              menu_id: "",
              menu_name: "",
              menu_icon: "",
              menu_url: ""
            };
          }

          this.dialog = false;
        } else {
          return false;
        }
      });
    },
    cancel(formName) {
      this.menuForm = {
        menu_id: "",
        menu_name: "",
        menu_icon: "",
        menu_url: ""
      };
      this.dialog = false;
    },
    edit(row) {
      console.log(row);
      let temp = {
        menu_id: row.menu_id,
        menu_name: row.menu_name,
        menu_icon: row.menu_icon,
        menu_url: row.menu_url
      };
      this.menuForm = temp;
      this.dialog = true;
    },
    remove(index, rows) {
      index = index + this.pagesize*(this.currentPage-1);
      rows.splice(index, 1);
      this.$message.success("Delete success");
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