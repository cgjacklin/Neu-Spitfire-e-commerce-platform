<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/main' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>Order</el-breadcrumb-item>
    </el-breadcrumb>
    <br />
    <br />

    <span>
      Search：
      <el-input
        style="width:200px"
        placeholder="Goods title"
        @input="search"
        v-model="search_title"
      ></el-input>
    </span>
    <el-date-picker
      v-model="value"
      type="daterange"
      start-placeholder="start date"
      end-placeholder="end date"
      value-format="yyyy-MM-dd"
      :default-time="['00:00:00', '23:59:59']"
      @change="search"
    ></el-date-picker>
    <el-button type="danger" icon="el-icon-search"></el-button>

    <el-tabs v-model="activeName" @tab-click="handleClick" class="order-tab">
      <el-tab-pane label="Awaiting Payment" name="first">
        <el-table :data="tableData" style="width: 100%" class="table">
          <el-table-column prop="title" label="Title">
            <template slot-scope="scope">
              <el-link icon="el-icon-goods" type="info" @click="showDetail(scope.row)">{{scope.row.title}}</el-link>
            </template>
          </el-table-column>
          <el-table-column prop="sales_price" label="Price"></el-table-column>
          <el-table-column prop="qty" label="QTY"></el-table-column>
          <el-table-column prop="sku_no" label="SKU"></el-table-column>
          <el-table-column prop="order_id" label="Order No"></el-table-column>
          <el-table-column prop="order_created_time" label="Creation time"></el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="Awaiting Shipment" name="second">
        <el-table
          ref="multipleTable"
          @selection-change="handleSelectionChange"
          :data="tableData"
          style="width: 100%"
          class="table"
        >
          <el-table-column type="selection" width="50"></el-table-column>
          <el-table-column prop="title" label="Title">
            <template slot-scope="scope">
              <el-link icon="el-icon-goods" type="info" @click="showDetail(scope.row)">{{scope.row.title}}</el-link>
            </template>
          </el-table-column>
          <el-table-column prop="sales_price" label="Price"></el-table-column>
          <el-table-column prop="qty" label="QTY"></el-table-column>
          <el-table-column prop="sku_no" label="SKU"></el-table-column>
          <el-table-column prop="order_id" label="Order No"></el-table-column>
          <el-table-column prop="order_created_time" label="Creation time"></el-table-column>
          <el-table-column label="operation">
            <template slot-scope="scope">
              <el-button type="danger" size="small" @click="ship(scope.row, scope.$index)">Shipment</el-button>
            </template>
          </el-table-column>
        </el-table>
        <br />
        <el-button type="danger" size="medium" @click="shipSelected">Ship Selected</el-button>
      </el-tab-pane>
      <el-tab-pane label="Shiped" name="third">
        <el-table :data="tableData" style="width: 100%" class="table">
          <el-table-column type="selection" width="50"></el-table-column>
          <el-table-column prop="title" label="Title">
            <template slot-scope="scope">
              <el-link icon="el-icon-goods" type="info" @click="showDetail(scope.row)">{{scope.row.title}}</el-link>
            </template>
          </el-table-column>
          <el-table-column prop="sales_price" label="Price"></el-table-column>
          <el-table-column prop="qty" label="QTY"></el-table-column>
          <el-table-column prop="sku_no" label="SKU"></el-table-column>
          <el-table-column prop="order_id" label="Order No"></el-table-column>
          <el-table-column prop="tracking_number" label="Tracking No">
            <template slot-scope="scope">
              <el-popover placement="right-start" width="250" trigger="hover">
                <el-timeline>
                  <el-timeline-item timestamp="2020-05-12 20:46" color="#67C23A">Start shipping</el-timeline-item>
                  <el-timeline-item timestamp="2020-06-12 20:46" color="#67C23A">Arrive in Shanghai</el-timeline-item>
                  <el-timeline-item>Complete</el-timeline-item>
                </el-timeline>
                <el-link type="warning" slot="reference">{{scope.row.tracking_number}}</el-link>
              </el-popover>
            </template>
          </el-table-column>
          <el-table-column prop="order_created_time" label="Creation time"></el-table-column>
          <el-table-column label="operation">
            <template slot-scope="scope">
              <el-button type="danger" size="small" @click="cancel(scope.row, scope.$index)">Cancel</el-button>
            </template>
          </el-table-column>
        </el-table>
        <br />
        <!-- <el-button type="danger" size="medium" @click="cancelSelected">Cancel Selected</el-button> -->
      </el-tab-pane>
      <el-tab-pane label="Completed Orders" name="fourth">
        <el-table :data="tableData" style="width: 100%" class="table">
          <el-table-column prop="title" label="Title">
            <template slot-scope="scope">
              <el-link icon="el-icon-goods" type="info" @click="showDetail(scope.row)">{{scope.row.title}}</el-link>
            </template>
          </el-table-column>
          <el-table-column prop="sales_price" label="Price"></el-table-column>
          <el-table-column prop="qty" label="QTY"></el-table-column>
          <el-table-column prop="sku_no" label="SKU"></el-table-column>
          <el-table-column prop="order_id" label="Order No"></el-table-column>
          <el-table-column prop="tracking_number" label="Tracking No">
            <template slot-scope="scope">
              <el-popover placement="right-start" width="250" trigger="hover">
                <el-timeline>
                  <el-timeline-item timestamp="2020-05-12 20:46" color="#67C23A">Start shipping</el-timeline-item>
                  <el-timeline-item timestamp="2020-06-12 20:46" color="#67C23A">Sent to Shanghai</el-timeline-item>
                  <el-timeline-item timestamp="2020-07-12 20:46" color="#67C23A">Arrive in Shanghai</el-timeline-item>
                  <el-timeline-item timestamp="2020-08-12 20:46" color="#67C23A">Complete</el-timeline-item>
                </el-timeline>
                <el-link type="success" slot="reference">{{scope.row.tracking_number}}</el-link>
              </el-popover>
            </template>
          </el-table-column>
          <el-table-column prop="order_created_time" label="Creation time"></el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="Cancelled Orders" name="fifth">
        <el-table :data="tableData" style="width: 100%" class="table">
          <el-table-column prop="title" label="Title">
            <template slot-scope="scope">
              <el-link icon="el-icon-goods" type="info" @click="showDetail(scope.row)">{{scope.row.title}}</el-link>
            </template>
          </el-table-column>
          <el-table-column prop="sales_price" label="Price"></el-table-column>
          <el-table-column prop="qty" label="QTY"></el-table-column>
          <el-table-column prop="sku_no" label="SKU"></el-table-column>
          <el-table-column prop="order_id" label="Order No"></el-table-column>
          <el-table-column prop="order_created_time" label="Creation time"></el-table-column>
        </el-table>
      </el-tab-pane>
    </el-tabs>

    <el-drawer title="drawerDetail" :visible.sync="itemDrawer" size="50%" :with-header="false">
      <div class="goods-div">
        <h2>{{chooseItem.title}}</h2>
        <div class="base-info">
          <img :src="chooseItem.remark" class="img" />
          <div style="width:25rem">
            <p>{{chooseItem.title}}</p>
            <el-link :underline="false" type="danger">¥ {{chooseItem.retail_price}}</el-link>
            <p>Brand: {{chooseItem.name_en}}</p>
            <p>Stock: {{chooseItem.replenishment_period}}</p>
          </div>
        </div>
        <br />
        <el-tabs v-model="activeNameDetail" class="tab">
          <el-tab-pane label="Amazon description" name="first">{{chooseItem.amazon_description}}</el-tab-pane>
          <el-tab-pane label="ebay description" name="second">{{chooseItem.ebay_description}}</el-tab-pane>
        </el-tabs>
      </div>
    </el-drawer>

    <el-dialog title="Tracking Company" :visible.sync="dialogVisible" width="30%">
      <el-form :model="trackTable" ref="trackTable" label-width="130px">
        <el-form-item
          label="Company"
          prop="trackingCompany"
          :rules="[{ required: true, message: 'Please select tracking company'}]"
        >
          <el-radio
            v-model="trackTable.trackingCompany"
            label="SF Express"
          >SF Express (Fast 1-2 days)</el-radio>
          <br />
          <el-radio v-model="trackTable.trackingCompany" label="UPS">UPS (Slow 3-4 days)</el-radio>
        </el-form-item>
        <br />
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button type="danger" @click="submitForm('trackTable')">Ship</el-button>
        <el-button @click="cancelForm('trackTable')">Cancel</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      value: "",
      tableData: [],
      table: [],
      selections: [],
      dialogVisible: false,
      search_title: "",
      itemDrawer: false,
      activeNameDetail: "first",
      activeName: "first",
      chooseItem: '',
      sts_cd: "",
      opRow: "",
      opIndex: "",
      tmpStscd: "",
      multi: false,
      trackTable: {
        trackingCompany: ""
      }
    };
  },
  mounted() {
    this.$post("/order/getOrders", {
      user_id: sessionStorage.getItem("user_id"),
      sts_cd: "1"
    }).then(res => {
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
    showDetail(row){
        
        this.$post("/product/getProduct", {
          pro_id : row.pro_id
        }).then(res=>{
          if(res.code==200){
            this.chooseItem = res.data;
            this.itemDrawer = true;
          }
          else{
            this.$message.warning(res.message)
          }
          
        })
        
    },
    a() {
      console.log("a");
      alert("a");
    },
    cancelSelected() {
      if(this.selections.length==0){
        this.$message.warning("Please select item")
        return
      }
      this.dialogVisible = true;
      this.multi = true;
    },
    shipSelected() {
      // console.log(this.selections)
      if(this.selections.length==0){
        this.$message.warning("Please select item")
        return
      }
      this.dialogVisible = true;
      this.multi = true;
    },
    handleSelectionChange(val) {
      // console.log(val);
      this.selections = val;
      console.log(this.selections);
    },
    cancelForm(formName) {
      this.$refs[formName].resetFields();
      this.dialogVisible = false;
    },
    cancel(row, index) {
      this.$post("/order/cancelOrder", {
        or_id: row.or_id,
        user_id: sessionStorage.getItem("user_id")
      }).then(res => {
        console.log(res);
        if (res.code == 200) {
          this.$message.success(res.message);
          this.tableData.splice(index, 1);
          return;
        }
        this.$message.warning(res.message);
      });
    },

    refresh() {
      this.$post("/order/getOrders", {
        user_id: sessionStorage.getItem("user_id"),
        sts_cd: this.tmpStscd
      }).then(res => {
        console.log(res);
        this.tableData = res.data;
        this.table = res.data;
      });
    },

    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          if (this.multi) {
            this.multi = false;
            console.log("JSON.stringify(this.selections)");
            this.$post("/order/shipSelected", {
              tracking_company: this.trackTable.trackingCompany,
              orders: JSON.stringify(this.selections)
            }).then(res => {
              //处理response
              console.log(res);
              if (res.code == 504) {
                this.$message.warning(res.message);
                this.$refs[formName].resetFields();
                return;
              }
              if (res.code == 200) {
                // this.$root.user_id=res.data.user_id;
                // this.tableData = res.data
                this.$refs[formName].resetFields();
                this.dialogVisible = false;
                this.refresh();
              }
            });
            this.dialogVisible = false;
            return;
          }
          if (!this.multi) {
            this.$post("/order/deliverOrder", {
              or_id: this.opRow.or_id,
              tracking_number: "",
              tracking_company: this.trackTable.trackingCompany
            }).then(res => {
              //处理response
              console.log(res);
              if (res.code == "504") {
                this.$message.warning(res.message);
                this.$refs[formName].resetFields();
                return;
              }
              if (res.code == 200) {
                // this.$root.user_id=res.data.user_id;
                // this.tableData = res.data
                // this.tableData.splice(this.opIndex, 1);
                this.$message.success(res.message);
                this.$refs[formName].resetFields();
                this.refresh();
              }
            });
            this.dialogVisible = false;
          }
        } else {
          return false;
        }
      });
    },

    ship(row, index) {
      //应该是弹出shipment框填写shipment信息
      this.dialogVisible = true;
      this.opRow = row;
      this.opIndex = index;
    },
    handleClick(tab) {
      this.tableData = "";
      console.log(tab.index);
      this.tmpStscd = 0;
      this.selections = [];
      if (tab.index == 0) {
        this.tmpStscd = 1;
      }
      if (tab.index == 1) {
        this.tmpStscd = 2;
      }
      if (tab.index == 2) {
        this.tmpStscd = 3;
      }
      if (tab.index == 3) {
        this.tmpStscd = 4;
      }
      if (tab.index == 4) {
        this.tmpStscd = 0;
      }
      this.$post("/order/getOrders", {
        user_id: sessionStorage.getItem("user_id"),
        sts_cd: this.tmpStscd
      }).then(res => {
        console.log(res);
        this.tableData = res.data;
        this.table = res.data;
      });
    },
    search() {
      let timelist = [];
      if (!this.value) {
        timelist = ["1900-01-01", "2200-01-01"];
      } else {
        timelist = this.value;
      }
      this.tableData = this.table.filter(
        e =>
          e.title.match(this.search_title) &&
          timelist[0] <= e.order_created_time.slice(0, 10) &&
          e.order_created_time.slice(0, 10) <= timelist[1]
      );
    }
  }
};
</script>

<style>
.table {
  margin-top: 0.5rem;
}
.order-tab {
  margin-top: 2rem;
}
.el-tabs__item.is-active {
  color: #f56c6c;
}
.el-tabs__active-bar {
  background-color: #f56c6c;
}
.el-checkbox__input.is-checked .el-checkbox__inner {
  background-color: #f56c6c;
  border-color: #f56c6c;
}
.el-checkbox__input.is-indeterminate .el-checkbox__inner {
  background-color: #f56c6c;
  border-color: #f56c6c;
}

.tab >>> .el-tabs__item.is-active {
  color: #f56c6c;
}
.tab >>> .el-tabs__active-bar {
  background-color: #f56c6c;
}
.goods-div {
  margin-left: 3rem;
  height: 60rem;
}
.base-info {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
.img {
  width: 20rem;
  height: 20rem;
}
.goods-row {
  width: 94%;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
}
.tab {
  width: 50rem;
}
</style>