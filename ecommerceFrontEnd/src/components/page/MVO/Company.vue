<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/main' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>Company</el-breadcrumb-item>
    </el-breadcrumb>
    <div v-show="emptyShow" class="empty-box">
      <img style="width:25rem" :src="emptyImage" alt />
      <span>There is no company information.</span>
      <el-button type="danger" @click="drawer=true">Fill Company info</el-button>
    </div>

    <div v-show="mainShow" class="main-box-top">
      <div>
        <el-link style="font-size:18px" :underline="false" type="warning">Company information</el-link>
        <el-divider></el-divider>
        <div class="info-flex">
          <p style="width:25rem">
            <i class="el-icon-office-building"></i>
            Company Name：{{name}}
          </p>
          <p style="width:25rem">
            <i class="el-icon-document"></i>
            Brief Introduction：{{intr}}
          </p>
        </div>
        <div class="info-flex">
          <p style="width:25rem">
            <i class="el-icon-collection-tag"></i>
            GMC Report Type：{{type}}
          </p>
          <p style="width:25rem">
            <i class="el-icon-link"></i>
            GMC Report Url：{{url}}
          </p>
        </div>
        <br />
        <el-button type="danger" @click="drawer=true">Change</el-button>
      </div>
      <div class="main-box-top">
        <el-link style="font-size:18px" :underline="false" type="success">Brand information</el-link>
        <el-divider></el-divider>
        <span>
          Search:
          <el-input
            style="width:12rem"
            placeholder="Brand Name"
            @input="search"
            v-model="search_name"
          ></el-input>
        </span>
        <el-button type="danger" icon="el-icon-search"></el-button>
        <el-button type="danger" plain icon="el-icon-plus" @click="dialogVisible = true">Add</el-button>
        <br />
        <br />
        <el-table :data="tableData" style="width: 100%">
          <el-table-column prop="name" label="Brand Name"></el-table-column>
          <el-table-column prop="logo" label="Brand Logo"></el-table-column>
          <el-table-column label="operation">
            <template slot-scope="scope">
              <el-button
                type="danger"
                size="mini"
                @click="change(scope.$index, scope.row)"
              >change</el-button>
              <el-button type="danger" size="mini">delete</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </div>

    <el-dialog title="Add brand information" :visible.sync="dialogVisible" width="23%">
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
        action="http://localhost:3000/api/file/up"
        :file-list="fileList"
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
            prop="name"
            :rules="[{ required: true, message: 'Please enter the Company Name'}]"
          >
            <el-input style="width:35rem" v-model="addComForm.name" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="Brief Introduction"
            prop="intr"
            :rules="[{ required: true, message: 'Please enter the Brief Introduction'}]"
          >
            <el-input
              style="width:35rem"
              type="textarea"
              v-model="addComForm.intr"
              autocomplete="off"
            ></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="GMC Report Type"
            prop="type"
            :rules="[{ required: true, message: 'Please enter the GMC Report Type'}]"
          >
            <el-input style="width:35rem" v-model="addComForm.type" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="GMC Report Url"
            prop="url"
            :rules="[{ required: true, message: 'Please enter the GMC Report Url'}]"
          >
            <el-input style="width:35rem" v-model="addComForm.url" autocomplete="off"></el-input>
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
      emptyImage: require("../../../assets/empty.png"),
      emptyShow: true,
      mainShow: false,
      drawer: false,
      name: "",
      intr: "",
      type: "",
      url: "",
      tableData: [{ name: 1 },{ name: 2 }],
      addComForm: {
        name: "",
        intr: "",
        type: "",
        url: ""
      }
    };
  },
  methods: {
    diaCancel(){
      this.dialogVisible = false;
      this.brandname = "";
      this.count = 0;
      this.fileList = [];
    },
    change(index, row) {
      this.brandname = row.name;
      this.dialogVisible = true;
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
      this.dialogVisible = false;
    },
    search() {},
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          console.log(this.addComForm);
          this.drawer = false;
          this.emptyShow = false;
          this.mainShow = true;
        } else {
          return false;
        }
      });
    }
  }
};
</script>

<style>
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