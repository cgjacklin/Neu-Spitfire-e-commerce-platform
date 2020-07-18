<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/main' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>Company</el-breadcrumb-item>
    </el-breadcrumb>
    <div v-show="emptyShow" class="empty-box">
      <img style="width:25rem" :src="emptyImage" alt />
      <span>There is no company information.</span>
      <el-button type="danger" @click="drawer=true">Fill Company information</el-button>
    </div>

    <div v-show="mainShow" class="main-box-top">
      <div>
        <el-link style="font-size:18px" :underline="false" type="warning">Company information</el-link>
        <el-divider></el-divider>
        <div class="info-flex">
          <p style="width:25rem">
            <i class="el-icon-office-building"></i>
            Company Name：{{name_en}}
          </p>
          <p style="width:25rem">
            <i class="el-icon-document"></i>
            Brief Introduction：{{description}}
          </p>
        </div>
        <div class="info-flex">
          <p style="width:25rem">
            <i class="el-icon-collection-tag"></i>
            GMC Report Type：{{gmc_report_type}}
          </p>
          <p style="width:25rem">
            <i class="el-icon-link"></i>
            GMC Report Url：{{gmc_report_url}}
          </p>
        </div>
        <br />
        <el-button type="danger" @click="changeCompanyInfo">Change</el-button>
      </div>
      <div class="main-box-top">
        <el-link style="font-size:18px" :underline="false" type="success">Brand information</el-link>
        <el-divider></el-divider>
        <span>
          Search：
          <el-input
            style="width:12rem"
            placeholder="Brand Name"
            @input="search"
            v-model="search_name"
          ></el-input>
        </span>
        <el-button type="danger" icon="el-icon-search"></el-button>
        <el-button type="danger" plain icon="el-icon-plus" @click="add">Add</el-button>
        <br />
        <br />
        <el-table :data="tableData" style="width: 100%">
          <el-table-column prop="brdid" label="Brand Id"></el-table-column>
          <el-table-column prop="name" label="Brand Name"></el-table-column>
          <!-- <el-table-column prop="logo" label="Brand Logo"></el-table-column> -->
          <el-table-column prop="logo" label="Brand Logo">
            <template slot-scope="scope">
              <img :src="scope.row.logo" width="60" height="50" />
            </template>
          </el-table-column>
          <el-table-column label="operation">
            <template slot-scope="scope">
              <el-button type="success" size="mini" icon="el-icon-edit" @click="change(scope.$index, scope.row)">edit</el-button>
              <el-button type="danger" icon="el-icon-delete" size="mini" @click="remove(scope.row)">delete</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </div>

    <el-dialog title="Add Brand information" :visible.sync="dialogVisible" width="23%">
      <span>
        Brand Name：
        <el-input style="width:250px" v-model="brandname" placeholder></el-input>
      </span>
      <br />
      <br />
      <span>Brand Logo：</span>
      <br />
      <br />
      <el-upload
        ref="upload"
        drag
        action="http://localhost:8088/product/uploadPicture"
        :name="fileName"
        :file-list="fileList"
        :on-success="handleSuccess"
        :on-change="fileChange"
        :auto-upload="false"
        list-type="picture"
        :limit="1"
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">
          Drag the file here, or
          <em>Click to upload</em>
        </div>
        <div
          class="el-upload__tip"
          slot="tip"
        >It is recommended to upload JPG/PNG files and not exceed 500kb</div>
      </el-upload>
      <span slot="footer" class="dialog-footer">
        <el-button @click="diaCancel">cancel</el-button>
        <el-button type="danger" @click="submitUpload">sure</el-button>
      </span>
    </el-dialog>

    <el-dialog title="Update Brand information" :visible.sync="dialogVisible1" width="23%">
      <span>
        Brand Name：
        <el-input style="width:250px" v-model="brandname" placeholder></el-input>
      </span>
      <br />
      <br />
      <span>Brand Logo：</span>
      <br />
      <br />
      <el-upload
        ref="upload"
        drag
        action="http://localhost:8088/product/uploadPicture"
        :name="fileName"
        :file-list="fileList"
        :on-success="handleSuccess"
        :on-change="fileChange"
        :auto-upload="false"
        list-type="picture"
        :limit="1"
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">
          Drag the file here, or
          <em>Click to upload</em>
        </div>
        <div
          class="el-upload__tip"
          slot="tip"
        >It is recommended to upload JPG/PNG files and not exceed 500kb</div>
      </el-upload>
      <span slot="footer" class="dialog-footer">
        <el-button @click="diaCancel">cancel</el-button>
        <el-button type="danger" @click="submitUpdate">sure</el-button>
      </span>
    </el-dialog>

    <el-drawer
      title="drawer"
      :visible.sync="drawer"
      size="50%"
      :wrapperClosable="false"
      :with-header="false"
    >
      <div class="form-div">
        <h3>Company information</h3>
        <el-form :model="addComForm" ref="addComForm" label-width="150px" class="add-com-form">
          <el-form-item
            label="Company Name"
            prop="name_en"
            :rules="[{ required: true, message: 'Please enter the Company Name'}]"
          >
            <el-input style="width:35rem" v-model="addComForm.name_en" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="Brief Introduction"
            prop="description"
            :rules="[{ required: true, message: 'Please enter the Brief Introduction'}]"
          >
            <el-input
              style="width:35rem"
              type="textarea"
              v-model="addComForm.description"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="GMC Report Type"
            prop="gmc_report_type"
            :rules="[{ required: true, message: 'Please enter the GMC Report Type'}]"
          >
            <el-input style="width:35rem" v-model="addComForm.gmc_report_type" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="GMC Report Url"
            prop="gmc_report_url"
            :rules="[{ required: true, message: 'Please enter the GMC Report Url'}]"
          >
            <el-input style="width:35rem" v-model="addComForm.gmc_report_url" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item class="com-form-button">
            <el-button type="danger" @click="submitForm('addComForm')">Save</el-button>
            <el-button @click="drawer=false">Cancel</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-drawer>
  </div>
</template>

<script>
export default {
  data() {
    return {
      count: 0,
      brandname: "",
      fileList: [],
      search_name: "",
      dialogVisible: false,
      dialogVisible1: false,
      emptyImage: require("../../../assets/empty.png"),
      emptyShow: true,
      mainShow: false,
      drawer: false,
      brd_id: "",
      man_id: "",
      name_en: "",
      description: "",
      remake: "",
      fileName: "fileName",
      gmc_report_type: "",
      gmc_report_url: "",
      tableData: [],
      table:[],
      isAdd: false,
      addComForm: {
        name_en: "",
        description: "",
        gmc_report_type: "",
        gmc_report_url: ""
      }
    };
  },
  mounted() {
    this.checkCompany();
  },
  methods: {
    changeCompanyInfo(){
      this.addComForm.name_en = this.name_en;
      this.addComForm.description = this.description;
      this.addComForm.gmc_report_type = this.gmc_report_type;
      this.addComForm.gmc_report_url = this.gmc_report_url;
    

      this.drawer = true;
    },
    checkCompany() {
      //查詢用戶是否有公司信息
      this.$post("/mvo/getManufacturerByUserID", {
        user_id: sessionStorage.getItem("user_id")
      }).then(res => {
        if (res.code == 504) {
          this.$message.warning(res.message);
          this.emptyShow = true;
          this.mainShow = false;
          return;
        }
        if (res.code == 200) {
          this.$message.success("Successfully get company info!");
          this.man_id = res.data.man_id;
          this.name_en = res.data.name_en;
          this.description = res.data.description;
          this.gmc_report_type = res.data.gmc_report_type;
          this.gmc_report_url = res.data.gmc_report_url;
          this.emptyShow = false;
          this.mainShow = true;
          this.getBrand();
        }
      });
    },
    getBrand() {
      this.tableData = [];
      this.table = [];
      this.$post("/brd/getBrand", {
        user_id: sessionStorage.getItem("user_id")
      }).then(res => {
        for (var i = 0; i < res.data.length; i++) {
          this.tableData.push({
            brdid: res.data[i].brd_id,
            name: res.data[i].name_en,
            logo: res.data[i].remark
          });
          this.table.push({
            brdid: res.data[i].brd_id,
            name: res.data[i].name_en,
            logo: res.data[i].remark
          });
        }
      });
    },
    handleSuccess(res) {
      console.log("HandleSuccess")
      console.log(res.data)
      this.remake = res.data;

      if(this.isAdd){
          this.$post("/brd/addBrand", {
          user_id: sessionStorage.getItem("user_id"),
          name_en: this.brandname,
          remark: this.remake
        }).then(res => {
          if (res.code == 200) {
            this.$message.success("Successfully add!");
          } else {
            this.$message.warning("Add failed");
          }
          this.getBrand();
        });
        this.dialogVisible = false;
      }
      if(!this.isAdd){
           this.$post("/brd/updateBrand", {
            brd_id: this.brd_id,
            user_id: sessionStorage.getItem("user_id"),
            name_en: this.brandname,
            remark: this.remake
          }).then(res => {
            if (res.code == 200) {
              this.$message.success("Successfully update!");
            } else {
              this.$message.warning("Update failed");
            }
            this.getBrand();
          });
          this.dialogVisible1 = false;
      }
     
      
    },
    remove(row) {
      this.$post("/brd/deleteBrand", {
        brd_id: row.brdid
      }).then(res => {
        if (res.code == 200) {
          this.$message.success("Successfully delete!");
        } else {
          this.$message.warning("Delete failed");
        }
        this.getBrand();
      });
    },
    diaCancel() {
      this.dialogVisible = false;
      this.dialogVisible1 = false;
      this.brandname = "";
      this.count = 0;
      this.fileList = [];
    },
    add() {
      this.isAdd = true;
      this.brandname = "";
      this.count = 0;
      this.fileList = [];
      this.dialogVisible = true;
      //通过改变filelist展示图片
    },

    change(index, row) {
      this.isAdd = false;
      this.brd_id = row.brdid;
      this.brandname = row.name;
      this.fileList = [{name: 'logo', url: row.logo}]
      this.dialogVisible1 = true;
      //通过改变filelist展示图片
    },
    fileChange() {
      this.count++;
    },
    submitUpload() {
      if (this.brandname == "") {
        this.$message.warning("The brand name cannot be empty");
        return;
      }
      if (this.count == 0) {
        this.$message.warning("Please upload the logo");
        return;
      }
      this.$refs.upload.submit();
      // this.$post("/brd/addBrand", {
      //   user_id: sessionStorage.getItem("user_id"),
      //   name_en: this.brandname,
      //   remark: this.remake
      // }).then(res => {
      //   if (res.code == 200) {
      //     this.$message.success("Successfully add!");
      //   } else {
      //     this.$message.warning("Add failed");
      //   }
      //   this.getBrand();
      // });
      // this.dialogVisible = false;
    },
    submitUpdate() {
      if (this.brandname == "") {
        this.$message.warning("The brand name cannot be empty");
        return;
      }
      // if (this.count == 0) {
      //   this.$message.warning("Please upload the logo");
      //   return;
      // }
      this.$refs.upload.submit();
      // this.$post("/brd/updateBrand", {
      //   brd_id: this.brd_id,
      //   user_id: sessionStorage.getItem("user_id"),
      //   name_en: this.brandname,
      //   remark: this.remake
      // }).then(res => {
      //   if (res.code == 200) {
      //     this.$message.success("Successfully update!");
      //   } else {
      //     this.$message.warning("Update failed");
      //   }
      //   this.getBrand();
      // });
      // this.dialogVisible1 = false;
    },
    search() {
      this.tableData = this.table.filter(e =>
        e.name.match(this.search_name)
      );
    },
    submitForm(formName) {
      //增加及修改company info
      this.$refs[formName].validate(valid => {
        if (valid) {
          if (!this.mainShow) {
            this.$post("/mvo/addManufacturer", {
              user_id: sessionStorage.getItem("user_id"),
              name_en: this.addComForm.name_en,
              gmc_report_type: this.addComForm.gmc_report_type,
              gmc_report_url: this.addComForm.gmc_report_url,
              description: this.addComForm.description
            }).then(res => {
              if (res.code == 504) {
                this.$message.warning(res.message);
                return;
              }
              if (res.code == 200) {
                this.$message.success("Successfully added new company!");
                this.checkCompany();
              }
            });
          }
          if (this.mainShow) {
            this.$post("/mvo/updateManufacturer", {
              man_id: this.man_id,
              name_en: this.addComForm.name_en,
              gmc_report_type: this.addComForm.gmc_report_type,
              gmc_report_url: this.addComForm.gmc_report_url,
              description: this.addComForm.description
            }).then(res => {
              if (res.code == 504) {
                this.$message.warning(res.message);
                return;
              }
              if (res.code == 200) {
                this.$message.success("Successfully updated company info!");
                this.checkCompany();
              }
            });
          }
          // console.log(this.addComForm);
          this.drawer = false;
          // this.emptyShow = false;
          // this.mainShow = true;
        } else {
          return false;
        }
      });
    }
  }
};
</script>

<style scoped>
.form-div {
  margin-left: 3rem;
  height: 50rem;
}
.add-com-form {
  margin-top: 5rem;
}
.com-form-button {
  margin-left: 24rem;
}
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
.info-flex {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  width: 60%;
}
</style>