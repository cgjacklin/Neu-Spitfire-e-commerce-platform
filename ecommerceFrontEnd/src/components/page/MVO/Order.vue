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
          <el-table-column prop="name" label="Title"></el-table-column>
          <el-table-column prop="price" label="Price"></el-table-column>
          <el-table-column prop="qty" label="QTY"></el-table-column>
          <el-table-column prop="sku" label="SKU"></el-table-column>
          <el-table-column prop="order_num" label="Order No"></el-table-column>
          <el-table-column prop="creation_date" label="Creation date"></el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="Awaiting Shipment" name="second">
        <el-table :data="tableData" style="width: 100%" class="table">
          <el-table-column type="selection" width="50"></el-table-column>
          <el-table-column prop="name" label="Title"></el-table-column>
          <el-table-column prop="price" label="Price"></el-table-column>
          <el-table-column prop="qty" label="QTY"></el-table-column>
          <el-table-column prop="sku" label="SKU"></el-table-column>
          <el-table-column prop="order_num" label="Order No"></el-table-column>
          <el-table-column prop="creation_date" label="Creation date"></el-table-column>
          <el-table-column label="operation">
            <template slot-scope="scope">
              <el-button type="danger" size="small" @click="ship(scope.row)">Shipment</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="Shiped" name="third">
        <el-table :data="tableData" style="width: 100%" class="table">
          <el-table-column type="selection" width="50"></el-table-column>
          <el-table-column prop="name" label="Title"></el-table-column>
          <el-table-column prop="price" label="Price"></el-table-column>
          <el-table-column prop="qty" label="QTY"></el-table-column>
          <el-table-column prop="sku" label="SKU"></el-table-column>
          <el-table-column prop="order_num" label="Order No"></el-table-column>
          <el-table-column prop="creation_date" label="Creation date"></el-table-column>
          <el-table-column prop="tracking_no" label="Tracking No"></el-table-column>
          <el-table-column label="operation">
            <template slot-scope="scope">
              <el-button type="danger" size="small" @click="cancel(scope.row)">Cancel</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="Completed Orders" name="fourth">
        <el-table :data="tableData" style="width: 100%" class="table">
          <el-table-column prop="name" label="Title"></el-table-column>
          <el-table-column prop="price" label="Price"></el-table-column>
          <el-table-column prop="qty" label="QTY"></el-table-column>
          <el-table-column prop="sku" label="SKU"></el-table-column>
          <el-table-column prop="order_num" label="Order No"></el-table-column>
          <el-table-column prop="creation_date" label="Creation date"></el-table-column>
          <el-table-column prop="tracking_no" label="Tracking No"></el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="Cancelled Orders" name="fifth">
        <el-table :data="tableData" style="width: 100%" class="table">
          <el-table-column prop="name" label="Title"></el-table-column>
          <el-table-column prop="price" label="Price"></el-table-column>
          <el-table-column prop="qty" label="QTY"></el-table-column>
          <el-table-column prop="sku" label="SKU"></el-table-column>
          <el-table-column prop="order_num" label="Order No"></el-table-column>
          <el-table-column prop="creation_date" label="Creation date"></el-table-column>
        </el-table>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [{ name: 1 },{ name: 1 }],
      search_title: "",
      activeName: "first"
    };
  },
  methods: {
    cancel() {},
    ship() {},
    handleClick(tab) {
      console.log(tab.index);
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