<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/main' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>Goods</el-breadcrumb-item>
    </el-breadcrumb>
    <br />
    <br />

    <span>
      Search：
      <el-input
        style="width:200px"
        placeholder="Goods title"
        @input="search"
        v-model="search_goodstitle"
      ></el-input>
    </span>
    <el-button type="danger" plain icon="el-icon-plus" @click="drawer = true">Add</el-button>

    <br />
    <br />
    <el-table :data="tableData" style="width: 100%" class="table-check">
      <el-table-column type="selection" width="50"></el-table-column>
      <el-table-column prop="name" label="Goods title"></el-table-column>
      <el-table-column prop="type" label="Goods type"></el-table-column>
      <el-table-column prop="picture" label="Goods picture"></el-table-column>
      <el-table-column prop="price" label="Goods price"></el-table-column>
      <el-table-column prop="num" label="Stock"></el-table-column>
      <el-table-column prop="tag" label="State">
        <template slot-scope="scope">
          <el-tag :type="tag(scope.row.tag)" disable-transitions>{{scope.row.tag}}</el-tag>
        </template>
      </el-table-column>

      <el-table-column label="operation" width="250">
        <template slot-scope="scope">
          <el-button type="success" plain size="small" icon="el-icon-edit" @click="edit(scope.row)"></el-button>
          <el-button type="danger" size="small" icon="el-icon-delete"></el-button>
          <el-button type="success" size="small">{{btn(scope.row.tag)}}</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-drawer
      title="drawer"
      :visible.sync="drawer"
      size="50%"
      :wrapperClosable="false"
      :with-header="false"
      class="slip"
    >
      <div class="form-div">
        <h3>Goods information</h3>
        <el-form
          :model="addGoodsForm"
          ref="addGoodsForm"
          label-width="150px"
          class="add-goods-form"
        >
          <el-form-item
            label="Goods title"
            prop="title"
            :rules="[{ required: true, message: 'Please enter the goods title'}]"
          >
            <el-input style="width:35rem" v-model="addGoodsForm.title" autocomplete="off"></el-input>
          </el-form-item>
          <br />

          <el-form-item
            label="SKU Code"
            prop="sku"
            :rules="[{ required: true, message: 'Please enter the sku code'}]"
          >
            <el-input style="width:35rem" v-model="addGoodsForm.sku" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="UPC Code"
            prop="upc"
            :rules="[{ required: true, message: 'Please enter the upc code'}]"
          >
            <el-input style="width:35rem" v-model="addGoodsForm.upc" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="ENA Code"
            prop="ena"
            :rules="[{ required: true, message: 'Please enter the ena code'}]"
          >
            <el-input style="width:35rem" v-model="addGoodsForm.ena" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="Goods type"
            prop="type"
            :rules="[{ required: true, message: 'Please enter the Goods type'}]"
          >
            <el-input style="width:35rem" v-model="addGoodsForm.type" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="Goods model"
            prop="model"
            :rules="[{ required: true, message: 'Please enter the Goods model'}]"
          >
            <el-input style="width:35rem" v-model="addGoodsForm.model" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="Goods price"
            prop="price"
            :rules="[{ required: true, message: 'Please enter the Goods price'}]"
          >
            <el-input style="width:35rem" v-model="addGoodsForm.price" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="Goods stocks"
            prop="num"
            :rules="[{ required: true, message: 'Please enter the Goods stocks'}]"
          >
            <el-input style="width:35rem" v-model="addGoodsForm.num" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="Warranty period"
            prop="period"
            :rules="[{ required: true, message: 'Please enter the Warranty period'}]"
          >
            <el-input style="width:35rem" v-model="addGoodsForm.period" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <div class="flex">
            <div>
              <span>Goods picture:</span>
              <br />
              <br />
              <el-upload
                style="width:24rem"
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
            </div>
            <div>
              <span>Goods parameters:</span>
              <br />
              <br />
              <el-form-item
                label="Length(cm)"
                prop="length"
                :rules="[{ required: true, message: 'Please enter the length'}]"
              >
                <el-input style="width:12rem" v-model="addGoodsForm.length" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item
                label="Width(cm)"
                prop="width"
                :rules="[{ required: true, message: 'Please enter the width'}]"
              >
                <el-input style="width:12rem" v-model="addGoodsForm.width" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item
                label="Height(cm)"
                prop="height"
                :rules="[{ required: true, message: 'Please enter the height'}]"
              >
                <el-input style="width:12rem" v-model="addGoodsForm.height" autocomplete="off"></el-input>
              </el-form-item>
              <el-form-item
                label="Weight(kg)"
                prop="weight"
                :rules="[{ required: true, message: 'Please enter the weight'}]"
              >
                <el-input style="width:12rem" v-model="addGoodsForm.weight" autocomplete="off"></el-input>
              </el-form-item>
            </div>
          </div>
          <el-form-item class="com-form-button">
            <el-button type="danger" @click="submitForm('addGoodsForm')">Save</el-button>
            <el-button @click="darCancel('addGoodsForm')">Cancel</el-button>
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
      fileList: [],
      addGoodsForm: {
        title: "",
        price: "",
        num: "",
        sku: "",
        type: "",
        upc: "",
        ena: "",
        model: "",
        length: "",
        width: "",
        height: "",
        weight: ""
      },
      search_goodstitle: "",
      tableData: [
        {
          id: 1,
          name: "joy",
          price: 34,
          num: 8888,
          sku: "GM001031",
          tag: "In warehouse",
          n: "push"
        }
      ],
      orginTableData: [],
      drawer: false
    };
  },
  mounted() {},
  methods: {
    darCancel(formName){
      this.$refs[formName].resetFields();
      this.drawer = false;
      this.count = 0;
      this.fileList = [];
    },
    fileChange() {
      this.count++;
    },
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          console.log(this.addGoodsForm);
          if (this.count == 0) {
            this.$message.warning("Please upload goods picture");
            return;
          }
          this.drawer = false;
          this.$refs.upload.submit();
        } else {
          return false;
        }
      });
    },
    edit(row) {
      this.drawer = true;
    },
    btn(msg) {
      if (msg == "Not in warehouse") return "push";
      if (msg == "In warehouse") return "Shelve";
      if (msg == "On shelf") return "Unshelve";
    },
    tag(msg) {
      if (msg == "Not in warehouse") return "danger";
      if (msg == "In warehouse") return "warning";
      if (msg == "On shelf") return "success";
    },
    search() {}
  }
};
</script>

<style scoped>
.flex {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  /* align-items: center; */
}
.slip >>> .el-drawer__body {
  overflow-y: auto;
}
.form-div {
  margin-left: 3rem;
}
.add-goods-form {
  margin-top: 2rem;
}
.top {
  display: flex;
  flex-direction: row;
  width: 20%;
  font-size: 15px;
  font-weight: bold;
  justify-content: space-between;
}
.table-check >>> .el-checkbox__input.is-checked .el-checkbox__inner,
.el-checkbox__input.is-indeterminate .el-checkbox__inner {
  background-color: #f56c6c;
  border-color: #f56c6c;
}
</style>