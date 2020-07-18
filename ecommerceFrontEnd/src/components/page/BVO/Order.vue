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
    <el-button type="danger" icon="el-icon-search"></el-button>

    <el-tabs v-model="activeName" @tab-click="handleClick" class="order-tab">
      <el-tab-pane label="Awaiting Payment" name="first">
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
          <el-table-column prop="total" label="Total"></el-table-column>
          <el-table-column label="operation">
            <template slot-scope="scope">
              <el-button type="danger" size="small" @click="pay(scope.row, scope.$index)">Pay</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="Awaiting Shipment" name="second">
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
          <el-table-column prop="total" label="Total"></el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="Shiped" name="third">
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
          <el-table-column prop="total" label="Total"></el-table-column>
          <el-table-column prop="tracking_number" label="Tracking No">
            <template slot-scope="scope">
              <el-popover placement="bottom" width="250" trigger="hover">
                <el-timeline>
                  <el-timeline-item timestamp="2020-05-12 20:46" color="#67C23A">Start shipping</el-timeline-item>
                  <el-timeline-item timestamp="2020-06-12 20:46" color="#67C23A">Arrive in Shanghai</el-timeline-item>
                  <el-timeline-item>Complete</el-timeline-item>
                </el-timeline>
                <el-link type="warning" slot="reference">{{scope.row.tracking_number}}</el-link>
              </el-popover>
            </template>
          </el-table-column>
        </el-table>
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
          <el-table-column prop="total" label="Total"></el-table-column>
          <el-table-column prop="tracking_number" label="Tracking No">
            <template slot-scope="scope">
              <el-popover placement="bottom" width="250" trigger="hover">
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
          <el-table-column prop="total" label="Total"></el-table-column>
        </el-table>
      </el-tab-pane>
    </el-tabs>

    <el-drawer
      title="drawer"
      :visible.sync="drawer"
      size="50%"
      :wrapperClosable="false"
      :with-header="false"
    >
      <div class="pay-form-div">
        <h3>Order payment</h3>
        <el-form :model="payForm" ref="payForm" label-width="150px" class="pay-form">
          <el-form-item
            label="Receiver"
            prop="name"
            :rules="[{ required: true, message: 'Please enter the Receiver'}]"
          >
            <el-input style="width:35rem" v-model="payForm.name" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="Address"
            prop="address"
            :rules="[{ required: true, message: 'Please enter the Address'}]"
          >
            <el-input style="width:35rem" v-model="payForm.address" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item
            label="Phone number"
            prop="phone"
            :rules="[{ required: true, message: 'Please enter the phone number'}]"
          >
            <el-input style="width:35rem" v-model="payForm.phone" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item label="Quantity" prop="num">
            <el-input style="width:35rem" v-model="payForm.qty" :disabled="true" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item class="pay-form-button">
            <el-button type="danger" @click="payNow('payForm')">Pay Now</el-button>
            <el-button @click="drawer=false">Cancel</el-button>
          </el-form-item>
        </el-form>
      </div>
    </el-drawer>

    <el-dialog title="Payment" :visible.sync="dialogVisible" width="30%">
      <el-form :model="paymentForm" ref="paymentForm" label-width="130px">
        <el-form-item label="Total Money" prop="totalMoney">
          <el-input
            style="width:20rem"
            v-model="paymentForm.totalMoney"
            :disabled="true"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <br />
        <el-form-item label="Available Money" prop="availableMoney">
          <el-input
            style="width:20rem"
            v-model="paymentForm.availableMoney"
            :disabled="true"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <br />
        <el-form-item
          label="Password"
          prop="password"
          :rules="[{ required: true, message: 'Please enter the password'}]"
        >
          <el-input
            placeholder="Please enter password"
            v-model="paymentForm.password"
            show-password
          ></el-input>
        </el-form-item>
        <br />
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button type="danger" @click="submitForm('paymentForm')">Sure</el-button>
        <el-button @click="cancel">Cancel</el-button>
      </span>
    </el-dialog>


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

  </div>
</template>

<script>
export default {
  data() {
    return {
      drawer: false,
      opRow: "",
      opIndex: "",
      tableData: [],
      table: [],
      search_title: "",
      itemDrawer: false,
      activeNameDetail: "first",
      activeName: "first",
      chooseItem: '',
      payForm: {
        selected: "",
        name: "",
        address: "",
        phone: "",
        qty: ""
        // trackingCompany: ""
      },
      dialogVisible: false,
      paymentForm: {
        password: "",
        totalMoney: "",
        availableMoney: ""
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
        console.log(res);
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
    deleteRow(index) {
      this.tableData.splice(index, 1);
    },
    payNow(formName) {
      console.log(this.payForm.trackingCompany);
      this.$refs[formName].validate(valid => {
        if (valid) {
          this.$post("/wal/getAvailable_money", {
            user_id: sessionStorage.getItem("user_id")
          }).then(res => {
            if (res.code == 504) {
              this.$message.warning(res.message);
              return;
            }
            if (res.code == 200) {
              this.paymentForm.availableMoney = res.message;
              this.paymentForm.totalMoney =
                this.opRow.qty * this.opRow.sales_price;
              this.dialogVisible = true;
              this.$refs[formName].resetFields();
            }
          });
        } else {
          return false;
        }
      });
    },
    cancel() {
      this.dialogVisible = false;
    },

    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          // console.log(this.payForm);
          this.drawer = false;
          this.dialogVisible = false;

          this.$post("/order/payOrder", {
            or_id: this.opRow.or_id,
            user_id: sessionStorage.getItem("user_id"),
            password: this.paymentForm.password
          }).then(res => {
            if (res.code == 504) {
              this.$message.warning(res.message);
              this.$refs[formName].resetFields();
              return;
            }
            if (res.code == 200) {
              // this.$root.user_id=res.data.user_id;
              this.$message.success(res.message);
              this.deleteRow(this.opIndex);
              this.$refs[formName].resetFields();
            }
          });
        } else {
          return false;
        }
      });
    },
    pay(row, index) {
      if(sessionStorage.getItem("user_id") == 3){
        this.$message.warning("Admin can not operate")
        return
      }
      this.drawer = true;
      this.opRow = row;
      this.payForm.qty = row.qty;
      this.opIndex = index;
    },
    handleClick(tab) {
      this.tableData = "";
      console.log(tab.index);
      let tmpStscd = 0;
      if (tab.index == 0) {
        tmpStscd = 1;
      }
      if (tab.index == 1) {
        tmpStscd = 2;
      }
      if (tab.index == 2) {
        tmpStscd = 3;
      }
      if (tab.index == 3) {
        tmpStscd = 4;
      }
      if (tab.index == 4) {
        tmpStscd = 0;
      }
      this.$post("/order/getOrders", {
        user_id: sessionStorage.getItem("user_id"),
        sts_cd: tmpStscd
      }).then(res => {
        console.log(res);
        this.tableData = res.data;
        this.table = res.data;
      });
    },
    search() {
      this.tableData = this.table.filter(e => e.title.match(this.search_title));
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


.el-checkbox__input.is-indeterminate .el-checkbox__inner {
  background-color: #f56c6c;
  border-color: #f56c6c;
}
.pay-form-div {
  margin-left: 3rem;
  height: 50rem;
}
.pay-form {
  margin-top: 5rem;
}
.pay-form-button {
  margin-left: 24rem;
}
</style>