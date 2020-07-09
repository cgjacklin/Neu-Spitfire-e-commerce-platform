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
          <el-table-column prop="name" label="Title"></el-table-column>
          <el-table-column prop="price" label="Price"></el-table-column>
          <el-table-column prop="qty" label="QTY"></el-table-column>
          <el-table-column prop="sku" label="SKU"></el-table-column>
          <el-table-column prop="order_num" label="Order No"></el-table-column>
          <el-table-column prop="total" label="Total"></el-table-column>
          <el-table-column label="operation">
            <template slot-scope="scope">
              <el-button type="danger" size="small" @click="pay(scope.row)">Pay</el-button>
            </template>
          </el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="Awaiting Shipment" name="second">
        <el-table :data="tableData" style="width: 100%" class="table">
          <el-table-column prop="name" label="Title"></el-table-column>
          <el-table-column prop="price" label="Price"></el-table-column>
          <el-table-column prop="qty" label="QTY"></el-table-column>
          <el-table-column prop="sku" label="SKU"></el-table-column>
          <el-table-column prop="order_num" label="Order No"></el-table-column>
          <el-table-column prop="total" label="Total"></el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="Shiped" name="third">
        <el-table :data="tableData" style="width: 100%" class="table">
          <el-table-column prop="name" label="Title"></el-table-column>
          <el-table-column prop="price" label="Price"></el-table-column>
          <el-table-column prop="qty" label="QTY"></el-table-column>
          <el-table-column prop="sku" label="SKU"></el-table-column>
          <el-table-column prop="order_num" label="Order No"></el-table-column>
          <el-table-column prop="total" label="Total"></el-table-column>
          <el-table-column prop="tracking_no" label="Tracking No"></el-table-column>
        </el-table>
      </el-tab-pane>
      <el-tab-pane label="Completed Orders" name="fourth">
        <el-table :data="tableData" style="width: 100%" class="table">
          <el-table-column prop="name" label="Title"></el-table-column>
          <el-table-column prop="price" label="Price"></el-table-column>
          <el-table-column prop="qty" label="QTY"></el-table-column>
          <el-table-column prop="sku" label="SKU"></el-table-column>
          <el-table-column prop="order_num" label="Order No"></el-table-column>
          <el-table-column prop="total" label="Total"></el-table-column>
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
          <el-form-item
            label="Quantity"
            prop="num"
            :rules="[{ required: true, message: 'Please enter the Quantity'}]"
          >
            <el-input style="width:35rem" v-model="payForm.num" autocomplete="off"></el-input>
          </el-form-item>
          <br />
          <el-form-item class="pay-form-button">
            <el-button type="danger" @click="submitForm('payForm')">Save</el-button>
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
      drawer: false,
      tableData: [{ name: 1 }],
      search_title: "",
      activeName: "first",
      payForm: {
        name: "",
        address: "",
        phone: "",
        num: ""
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          console.log(this.payForm);
          this.drawer = false;
        } else {
          return false;
        }
      });
    },
    pay() {
      this.drawer = true;
    },
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