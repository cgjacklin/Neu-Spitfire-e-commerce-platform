<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/main' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>Wish list</el-breadcrumb-item>
    </el-breadcrumb>
    <br />
    <br />

    <span>
      Search：
      <el-input style="width:15rem" placeholder="Goods name" @input="search" v-model="search_name"></el-input>
    </span>
    <el-select style="width:15rem" placeholder="Goods type" v-model="type" autocomplete="off">
      <el-option
        v-for="item in type_options"
        :key="item.value"
        :label="item.label"
        :value="item.value"
      ></el-option>
    </el-select>
    <el-button type="danger" icon="el-icon-search"></el-button>
    <el-divider></el-divider>
    <el-table :data="goods" style="width: 100%" class="check">
      <el-table-column type="selection" width="50"></el-table-column>
      <el-table-column prop="src" label="Goods">
        <template slot-scope="scope">
          <img :src="scope.row.src" width="100" />
        </template>
      </el-table-column>
      <el-table-column prop="name" label="Goods Name"></el-table-column>
      <el-table-column prop="price" label="Price"></el-table-column>
      <el-table-column label="operation">
        <template slot-scope="scope">
          <el-button type="danger" size="mini" @click="detail(scope.row)">Details</el-button>
          <el-button type="danger" size="mini" @click="remove(scope.row)">Remove</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-drawer title="drawer" :visible.sync="drawer" size="50%" :with-header="false">
      <div class="goods-div">
        <h2>{{chooseItem.name}}</h2>
        <div class="icon" @click="star(chooseItem)">
          <i :class="chooseItem.star == 1 ? 'el-icon-star-on' :'el-icon-star-off'"></i>
        </div>
        <div class="base-info">
          <img :src="chooseItem.src" class="img" />
          <div style="width:25rem">
            <p>{{chooseItem.name}}</p>
            <el-link :underline="false" type="danger">{{chooseItem.price}} ¥</el-link>
            <p>Brand: {{chooseItem.brand}}</p>
            <p>Stock: {{chooseItem.brand}}</p>
            <el-popover placement="bottom" v-model="dialogVisible">
              <div class="check">
                <el-checkbox
                  :indeterminate="isIndeterminate"
                  v-model="checkAll"
                  @change="handleCheckAllChange"
                >Amazon</el-checkbox>

                <el-checkbox-group v-model="checkedAStores" @change="handleCheckedAStoresChange">
                  <el-checkbox
                    class="store"
                    v-for="item in Astores"
                    :label="item"
                    :key="item"
                  >{{item}}</el-checkbox>
                </el-checkbox-group>

                <el-checkbox
                  class="title"
                  :indeterminate="EisIndeterminate"
                  v-model="EcheckAll"
                  @change="EhandleCheckAllChange"
                >Ebay</el-checkbox>

                <el-checkbox-group v-model="checkedEStores" @change="handleCheckedEStoresChange">
                  <el-checkbox
                    class="store"
                    v-for="item in Estores"
                    :label="item"
                    :key="item"
                  >{{item}}</el-checkbox>
                </el-checkbox-group>
              </div>
              <div class="minibtn">
                <el-button size="mini" @click="dialogVisible = false">Cancel</el-button>
                <el-button size="mini" type="danger" plain @click="pushShip">Push</el-button>
              </div>
              <el-button type="danger" slot="reference">Dropship Now</el-button>
            </el-popover>
            <el-button
              type="danger"
              @click="star(chooseItem)"
            >{{chooseItem.star == 1 ? 'Remove from Wish List' : 'Add to Wish List'}}</el-button>
          </div>
        </div>
        <br />
        <el-tabs v-model="activeName" class="tab">
          <el-tab-pane label="Amazon description" name="first">{{chooseItem.description}}</el-tab-pane>
          <el-tab-pane label="ebay description" name="second">{{chooseItem.description}}</el-tab-pane>
        </el-tabs>
      </div>
    </el-drawer>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [{ name: 1 }, { name: 1 }],
      checkAll: false,
      EcheckAll: false,
      checkedAStores: [],
      checkedEStores: [],
      Astores: ["Apple", "Nick"],
      Estores: ["Apple", "Nick"],
      isIndeterminate: true,
      EisIndeterminate: true,
      //
      dialogVisible: false,
      activeName: "first",
      chooseItem: {},
      drawer: false,
      type_options: [
        { value: "Phone", label: "Phone" },
        { value: "Computer", label: "Computer" },
        { value: "Instrument", label: "Instrument" },
        { value: "Appliances", label: "Appliances" }
      ],
      search_name: "",
      type: "",
      goods: [
        // {
        //   name: "Mac book",
        //   src:
        //     "http://img1.imgtn.bdimg.com/it/u=1524275480,3404163321&fm=26&gp=0.jpg",
        //   price: 3333,
        //   star: 1
        // },
        // {
        //   name: "iPhone",
        //   src:
        //     "http://img2.imgtn.bdimg.com/it/u=2221061121,1432349285&fm=26&gp=0.jpg",
        //   price: 3333,
        //   star: 2
        // }
      ]
    };
  },
  mounted: function () {
    console.log("mounted")
    this.loadData()
  },
  methods: {
  loadData () {
       this.$post("/wit/getWishlist", {
        user_id: sessionStorage.getItem("user_id")
      }).then(res => {
        console.log(res)
      });
    },
    EhandleCheckAllChange(val) {
      this.checkedEStores = val ? this.Estores : [];
      this.EisIndeterminate = false;
    },
    handleCheckAllChange(val) {
      this.checkedAStores = val ? this.Astores : [];
      this.isIndeterminate = false;
    },
    handleCheckedEStoresChange(value) {
      let checkedCount = value.length;
      this.EcheckAll = checkedCount === this.Estores.length;
      this.EisIndeterminate =
        checkedCount > 0 && checkedCount < this.Estores.length;
    },
    handleCheckedAStoresChange(value) {
      let checkedCount = value.length;
      this.checkAll = checkedCount === this.Astores.length;
      this.isIndeterminate =
        checkedCount > 0 && checkedCount < this.Astores.length;
    },
    remove(item) {},
    pushShip() {
      this.dialogVisible = false;
      this.$notify.success("Successfull");
    },
    star(item) {
      if (item.star == 1) {
        item.star = 2;
        return;
      }
      item.star = 1;
    },
    detail(item) {
      this.chooseItem = item;
      this.drawer = true;
    },
    search() {
      console.log(1);
    }
  }
};
</script>

<style scoped>
.minibtn {
  margin-top: 1rem;
}
.check >>> .el-checkbox__input.is-indeterminate .el-checkbox__inner {
  background-color: #f56c6c;
  border-color: #f56c6c;
}
.check >>> .el-checkbox__input.is-checked .el-checkbox__inner {
  background-color: #f56c6c;
  border-color: #f56c6c;
}
.check >>> .el-checkbox__input.is-checked + .el-checkbox__label {
  color: #f56c6c;
}
.title {
  margin-top: 0.5rem;
}
.store {
  display: block;
  margin-left: 1rem;
  margin-top: 0.5rem;
}
.tab {
  width: 50rem;
}
.tab >>> .el-tabs__item.is-active {
  color: #f56c6c;
}
.tab >>> .el-tabs__active-bar {
  background-color: #f56c6c;
}
.base-info {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
.goods-div {
  margin-left: 3rem;
  height: 60rem;
}
.small-icon {
  font-size: 20px;
  color: #f3c93f;
}
.icon {
  position: absolute;
  top: 1rem;
  left: 11rem;
  font-size: 30px;
  color: #f3c93f;
}
.goods-row {
  width: 94%;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
}
.goods-info-div {
  margin-left: 1rem;
  width: 50%;
}
.small-img {
  width: 15rem;
  height: 15rem;
}
.img {
  width: 20rem;
  height: 20rem;
}
.goods-card {
  margin-top: 0.8rem;
  width: 42rem;
  height: 15rem;
}
.goods-small-div {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
</style>