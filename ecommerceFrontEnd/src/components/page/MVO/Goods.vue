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
    <el-button type="danger" icon="el-icon-search"></el-button>
    <el-button type="danger" plain icon="el-icon-plus" @click="add">Add</el-button>

    <br />
    <br />
    <el-table :data="tableData" style="width: 100%" class="table-check">
      <el-table-column type="selection" width="50"></el-table-column>
      <el-table-column prop="title" label="Goods title"></el-table-column>
      <el-table-column prop="key_words" label="Goods type"></el-table-column>
      <el-table-column prop="remark" label="Goods picture">
        <template slot-scope="scope">
          <img :src="scope.row.remark" width="100" />
        </template>
      </el-table-column>
      <el-table-column prop="retail_price" label="Goods price"></el-table-column>
      <el-table-column prop="replenishment_period" label="Stock"></el-table-column>
      <el-table-column prop="sts_cd" label="State">
        <template slot-scope="scope">
          <el-tag :type="tag(scope.row.sts_cd)" disable-transitions>{{scope.row.sts_cd}}</el-tag>
        </template>
      </el-table-column>

      <el-table-column label="operation" width="250">
        <template slot-scope="scope">
          <el-button type="success" size="small" icon="el-icon-edit" @click="edit(scope.row)"></el-button>
          <el-button type="danger" size="small" icon="el-icon-delete" @click="remove(scope.row, scope.$index)"></el-button>
          <el-button type="warning" size="small" @click="operate(scope.row)">{{btn(scope.row.sts_cd)}}</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-drawer
      title="drawer"
      :visible.sync="drawer"
      size="50%"
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
            label="Goods brand"
            prop="brand_options"
          >
                      <!-- :rules="[{ required: true, message: 'Please choose the Goods brand', trigger: 'blur'}]" -->

            <el-select
              style="width:35rem"
              placeholder
              v-model="addGoodsForm.brd_id"
              autocomplete="off"
            >
              <el-option
                v-for="item in brand_options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </el-form-item>
          <br />
          <el-form-item
            label="SKU Code"
            prop="sku_cd"
            :rules="[{ required: true, message: 'Please enter the sku_cd code'}]"
          >
            <el-input style="width:35rem" v-model="addGoodsForm.sku_cd" autocomplete="off"></el-input>
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
            label="ean Code"
            prop="ean"
            :rules="[{ required: true, message: 'Please enter the ean code'}]"
          >
            <el-input style="width:35rem" v-model="addGoodsForm.ean" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="Goods type"
            prop="key_words"
            :rules="[{ required: true, message: 'Please choose the Goods type', trigger: 'blur'}]"
          >
            <el-select
              style="width:35rem"
              placeholder
              v-model="addGoodsForm.key_words"
              autocomplete="off"
            >
              <el-option
                v-for="item in type_options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
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
            prop="retail_price"
            :rules="[{ required: true, message: 'Please enter the Goods price'}]"
          >
            <el-input style="width:35rem" v-model="addGoodsForm.retail_price" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="Goods stocks"
            prop="replenishment_period"
            :rules="[{ required: true, message: 'Please enter the Goods stocks'}]"
          >
            <el-input style="width:35rem" v-model="addGoodsForm.replenishment_period" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="Warranty period"
            prop="warranty_day"
            :rules="[{ required: true, message: 'Please enter the Warranty period'}]"
          >
            <el-input style="width:35rem" v-model="addGoodsForm.warranty_day" autocomplete="off"></el-input>
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
                action="http://localhost:8088/product/uploadPicture"
                :name=fileName
                :data=addGoodsForm
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
          <br />
          <span>eBay description：</span>
          <mavon-editor
            :subfield="false"
            :toolbars="toolbars"
            class="markdown"
            v-model="addGoodsForm.ebay_description"
            ref="md"
          />
          <br />
          <span>Amazon description：</span>
          <mavon-editor
            :subfield="false"
            :toolbars="toolbars"
            class="markdown"
            v-model="addGoodsForm.amazon_description"
            ref="md"
          />

          <el-form-item class="goods-form-button">
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
      toolbars: {
        bold: true, // 粗体
        italic: true, // 斜体
        header: true, // 标题
        underline: true, // 下划线
        mark: true, // 标记
        ol: true, // 有序列表
        ul: true, // 无序列表
        link: true, // 链接
        imagelink: true, // 图片链接
        code: false, // code
        fullscreen: true, // 全屏编辑
        readmodel: true, // 沉浸式阅读
        htmlcode: true, // 展示html源码
        /* 1.3.5 */
        undo: true, // 上一步
        redo: true, // 下一步
        trash: true, // 清空
        /* 1.4.2 */
        navigation: true, // 导航目录
        /* 2.1.8 */
        alignleft: true, // 左对齐
        aligncenter: true, // 居中
        alignright: true, // 右对齐
        /* 2.2.1 */
        subfield: true, // 单双栏模式
        preview: true // 预览
      },
      count: 0,
      fileList: [],
      fileName: "fileName",
      isAdd: false,
      // brand_options: [{ value: 1, label: "p" }],
      brand_options: [],
      type_options: [
        { value: "Phone", label: "Phone" },
        { value: "Computer", label: "Computer" },
        { value: "Instrument", label: "Instrument" },
        { value: "Appliances", label: "Appliances" }
      ],
      addGoodsForm: {
        pro_id: "",
        title: "",
        name_en: "",
        retail_price: "",
        replenishment_period: "",
        remark: "",
        sku_cd: "",
        key_words: "",
        upc: "",
        warranty_day: "",
        ean: "",
        model: "",
        length: "",
        width: "",
        height: "",
        weight: "",
        ebay_description: "",
        amazon_description: "",
        brd_id: ""
      },
      ori_form: {
        pro_id: "",
        title: "",
        name_en: "",
        retail_price: "",
        replenishment_period: "",
        remark: "",
        sku_cd: "",
        key_words: "",
        upc: "",
        warranty_day: "",
        ean: "",
        model: "",
        length: "",
        width: "",
        height: "",
        weight: "",
        ebay_description: "",
        amazon_description: "",
        brd_id: ""
      },
      search_goodstitle: "",
      tableData: [],
      orginTableData: [],
      opRow: '',
      drawer: false
    };
  },
  mounted() {
    this.$post("brd/getBrand",{
      user_id: sessionStorage.getItem("user_id")
    }).then(res=>{

      let tmpBrands = [];
      for(let i = 0; i < res.data.length; i++){
        tmpBrands[i] = {value: res.data[i].brd_id, 
                      label: res.data[i].name_en}
      }
      this.brand_options = tmpBrands;
    }),
    this.$post("/product/getProducts", {
        user_id: sessionStorage.getItem("user_id")
      }).then(res => {
        if (res.code == 504) {
          this.$notify.warning(res.message);
          return;
        }
        if (res.code == 200) {
          this.tableData = res.data;
        }
      });
  },
  methods: {
    add(){
      // console.log(this.addGoodsForm)
      this.addGoodsForm.brd_id="";
      // this.addGoodsForm
      this.isAdd = true;
      this.drawer = true;
    },

    remove(row, index){
      this.$post("/product/deleteProduct", {
        pro_id: row.pro_id
      }).then (res=> {
        if(res.code == 504){
          this.$message.warning(res.message);
          this.refresh();
          return;
        }
        if(res.code == 200){
          this.$message.success(res.message);
          this.refresh();
        }
      })
    },

    darCancel(formName) {
      this.addGoodsForm.ebay_description = "";
      this.addGoodsForm.amazon_description = "";
      this.$refs[formName].resetFields();
      this.drawer = false;
      this.isAdd = false;
      this.count = 0;
      this.fileList = [];
    },
    fileChange() {
      this.count++;
      // console.log(this.fileList)
    },

    handleSuccess(res){
      // console.log(this.fileList.length)
        if(this.isAdd){
          // console.log(this.addGoodsForm.brd_id)
          this.isAdd = false;
          this.$post("/product/addProduct", {
            brd_id: this.addGoodsForm.brd_id,
            retail_price: this.addGoodsForm.retail_price,
            sku_cd: this.addGoodsForm.sku_cd,
            title: this.addGoodsForm.title,
            upc: this.addGoodsForm.upc,
            ean: this.addGoodsForm.ean,
            name_en: this.addGoodsForm.name_en,
            ebay_description: this.addGoodsForm.ebay_description,
            amazon_description: this.addGoodsForm.amazon_description,
            key_words: this.addGoodsForm.key_words,
            width: this.addGoodsForm.width,
            height: this.addGoodsForm.height,
            weight: this.addGoodsForm.weight,
            length: this.addGoodsForm.length,
            model: this.addGoodsForm.model,
            replenishment_period: this.addGoodsForm.replenishment_period,
            warranty_day: this.addGoodsForm.warranty_day,
            remark: res.data,
            user_id: sessionStorage.getItem("user_id")
        }).then(res => {
          if(res.code == 504){
            this.$message.warning(res.message);
            this.refresh();
            this.addGoodsForm.ebay_description = "";
            this.addGoodsForm.amazon_description = "";
                 
            this.$refs['addGoodsForm'].resetFields();
            this.fileList = [];
            return;
          }
          if(res.code == 200){
            this.$message.success(res.message);
            this.refresh();
            this.addGoodsForm.ebay_description = "";
            this.addGoodsForm.amazon_description = "";
            this.$refs['addGoodsForm'].resetFields();
            this.fileList = [];
            return;
          }
        })
        }
        if(!this.isAdd){
          this.$post("/product/updateProduct", {
            brd_id: this.addGoodsForm.brd_id,
            retail_price: this.addGoodsForm.retail_price,
            sku_cd: this.addGoodsForm.sku_cd,
            title: this.addGoodsForm.title,
            upc: this.addGoodsForm.upc,
            ean: this.addGoodsForm.ean,
            name_en: this.addGoodsForm.name_en,
            ebay_description: this.addGoodsForm.ebay_description,
            amazon_description: this.addGoodsForm.amazon_description,
            key_words: this.addGoodsForm.key_words,
            width: this.addGoodsForm.width,
            height: this.addGoodsForm.height,
            weight: this.addGoodsForm.weight,
            length: this.addGoodsForm.length,
            model: this.addGoodsForm.model,
            replenishment_period: this.addGoodsForm.replenishment_period,
            warranty_day: this.addGoodsForm.warranty_day,
            remark: res.data,
            user_id: sessionStorage.getItem("user_id"),
            pro_id: this.addGoodsForm.pro_id
          }).then(res => {
            if(res.code == 504){
              this.$message.warning(res.message);
              this.addGoodsForm.ebay_description = "";
              this.addGoodsForm.amazon_description = "";
              this.$refs['addGoodsForm'].resetFields();
              this.fileList = [];
              return;
            }
            if(res.code == 200){
              this.$message.success(res.message);
              this.refresh();
              this.addGoodsForm.ebay_description = "";
              this.addGoodsForm.amazon_description = "";
              this.$refs['addGoodsForm'].resetFields();
              this.fileList = [];
              return;
            }
          })
        }
        this.drawer = false;
        
    },

    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          console.log(this.count)
          console.log(!this.isAdd)
          
           if (this.count == 0) {
            this.$message.warning("Please upload goods picture");
            return;
          }
          if (
            this.addGoodsForm.ebay_description == "" ||
            this.addGoodsForm.amazon_description == ""
          ) {
            this.$message.warning("Please enter the description");
            return;
          }
          this.$refs.upload.submit();

        } else {
          return false;
        }
      });
    },
    edit(row) {
      this.drawer = true;
      this.$nextTick(function(){
          this.addGoodsForm = JSON.parse(JSON.stringify(row));
          
      })

      
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
    search() {},

    refresh(){
      this.$post("/product/getProducts", {
          user_id: sessionStorage.getItem("user_id")
      }).then(res => {
        if (res.code == 504) {
          this.$message.warning(res.message);
          this.tableData = res.data
          return;
        }
        if (res.code == 200) {
          this.tableData = res.data
        }
      });
    },

    operate(row){
      let nextStage = '';
      if(row.sts_cd == "Not in warehouse"){
          nextStage = "In warehouse";
      }
      if(row.sts_cd == "In warehouse"){
        nextStage = "On shelf";
      }
      if(row.sts_cd == "On shelf"){
        nextStage = "In warehouse";
      }
      this.$post("/product/updateSts", {
        pro_id: row.pro_id,
        sts_cd: nextStage
      }).then(res => {
        // console.log(res)
        if(res.code == 504){
          this.$message.warning(res.message);
          return;
        }
        if(res.code == 200){
          this.refresh();
        }
      })
    }
  }
};
</script>

<style scoped>
.goods-form-button {
  margin-top: 2rem;
  margin-left: 30rem;
}
.markdown {
  margin-top: 1rem;
  height: 25rem;
  width: 50rem;
}
.flex {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
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