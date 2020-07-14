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
          <el-table-column prop="title" label="Title"></el-table-column>
          <el-table-column prop="sales_price" label="Price"></el-table-column>
          <el-table-column prop="qty" label="QTY"></el-table-column>
          <el-table-column prop="sku_no" label="SKU"></el-table-column>
          <el-table-column prop="order_id" label="Order No"></el-table-column>
          <el-table-column prop="order_created_time" label="Creation date"></el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="Awaiting Shipment" name="second">
        <el-table :data="tableData" style="width: 100%" class="table">
          <el-table-column type="selection" width="50"></el-table-column>
          <el-table-column prop="title" label="Title"></el-table-column>
          <el-table-column prop="sales_price" label="Price"></el-table-column>
          <el-table-column prop="qty" label="QTY"></el-table-column>
          <el-table-column prop="sku_no" label="SKU"></el-table-column>
          <el-table-column prop="order_id" label="Order No"></el-table-column>
          <el-table-column prop="order_created_time" label="Creation date"></el-table-column>
          <el-table-column label="operation">
            <template slot-scope="scope">
              <el-button type="danger" size="small" @click="ship(scope.row, scope.$index)">Shipment</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="Shiped" name="third">
        <el-table :data="tableData" style="width: 100%" class="table">
          <el-table-column type="selection" width="50"></el-table-column>
          <el-table-column prop="title" label="Title"></el-table-column>
          <el-table-column prop="sales_price" label="Price"></el-table-column>
          <el-table-column prop="qty" label="QTY"></el-table-column>
          <el-table-column prop="sku_no" label="SKU"></el-table-column>
          <el-table-column prop="order_id" label="Order No"></el-table-column>
          <el-table-column prop="order_created_time" label="Creation date"></el-table-column>
          <el-table-column prop="tracking_number" label="Tracking No"></el-table-column>
          <el-table-column label="operation">
            <template slot-scope="scope">
              <el-button type="danger" size="small" @click="cancel(scope.row, scope.$index)">Cancel</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="Completed Orders" name="fourth">
        <el-table :data="tableData" style="width: 100%" class="table">
          <el-table-column prop="title" label="Title"></el-table-column>
          <el-table-column prop="sales_price" label="Price"></el-table-column>
          <el-table-column prop="qty" label="QTY"></el-table-column>
          <el-table-column prop="sku_no" label="SKU"></el-table-column>
          <el-table-column prop="order_id" label="Order No"></el-table-column>
          <el-table-column prop="order_created_time" label="Creation date"></el-table-column>
          <el-table-column prop="tracking_number" label="Tracking No"></el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="Cancelled Orders" name="fifth">
        <el-table :data="tableData" style="width: 100%" class="table">
          <el-table-column prop="title" label="Title"></el-table-column>
          <el-table-column prop="sales_price" label="Price"></el-table-column>
          <el-table-column prop="qty" label="QTY"></el-table-column>
          <el-table-column prop="sku_no" label="SKU"></el-table-column>
          <el-table-column prop="order_id" label="Order No"></el-table-column>
          <el-table-column prop="order_created_time" label="Creation date"></el-table-column>
        </el-table>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [],
      search_title: "",
      activeName: "first",
      sts_cd: ''
    };
  },
  mounted(){
    this.$post("/order/getOrders", {
        user_id: sessionStorage.getItem("user_id"),
        sts_cd: "1"
      }).then(res => {
        //处理response
        console.log(res)
        if (res.code == 504) {
          this.$message.warning(res.message);
          return;
        }
        if (res.code == 200) {
          // this.$root.user_id=res.data.user_id;
          this.tableData = res.data
        }
      });
  },
  methods: {
    cancel(row, index) {
      this.$post("/order/cancelOrder",{
        or_id: row.or_id,
        user_id: sessionStorage.getItem("user_id")
      }).then(res=>{
        console.log(res);
        if (res.code == 504) {
          this.$message.warning(res.message);
          return;
        }

        if(res.code == 200){
           this.tableData.splice(index, 1); 
        }
      })
    },

    ship(row, index) {
      //应该是弹出shipment框填写shipment信息

       this.$post("/order/deliverOrder", {
        or_id: row.or_id,
        tracking_number: '',
        tracking_computer: ''
      }).then(res => {
        //处理response
        console.log(res)
        if (res.code == "504") {
          this.$message.warning(res.message);
          return;
        }
        if (res.code == 200) {
          // this.$root.user_id=res.data.user_id;
          // this.tableData = res.data
          this.tableData.splice(index, 1);  
        }
      });
    
    },
    handleClick(tab) {
      console.log(tab.index);
      let tmpStscd = 0;
      if(tab.index == 0){
        tmpStscd = 1
      }
      if(tab.index == 1 ){
        tmpStscd = 2
      }
      if(tab.index == 2){
        tmpStscd = 3
      }
      if(tab.index == 3){
        tmpStscd = 4
      }
      if(tab.index == 4){
        tmpStscd = 0
      }
      this.$post("/order/getOrders",{
        user_id:  sessionStorage.getItem("user_id"),
        sts_cd: tmpStscd
      }).then(res=>{
        console.log(res);
        this.tableData = res.data;
      })
    },
    search() {}
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
.el-checkbox__input.is-checked .el-checkbox__inner{
  background-color: #f56c6c;
  border-color: #f56c6c;
}
.el-checkbox__input.is-indeterminate .el-checkbox__inner {
  background-color: #f56c6c;
  border-color: #f56c6c;
}
</style>