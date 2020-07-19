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
    <el-select
      style="width:15rem"
      placeholder="Goods type"
      @change="search"
      v-model="type"
      autocomplete="off"
      clearable
    >
      <el-option
        v-for="item in type_options"
        :key="item.value"
        :label="item.label"
        :value="item.value"
      ></el-option>
    </el-select>
    <el-button type="danger" icon="el-icon-search"></el-button>
    <el-divider></el-divider>
    <el-table
      :data="goods"
      style="width: 100%"
      class="check"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="50"></el-table-column>
      <el-table-column prop="src" label="Goods">
        <template slot-scope="scope">
          <img :src="scope.row.src" width="100" @click="detail(scope.row)" />
        </template>
      </el-table-column>
      <el-table-column prop="name" label="Goods Name"></el-table-column>
      <el-table-column prop="key_words" label="Goods type"></el-table-column>
      <el-table-column prop="price" label="Price"></el-table-column>
      <el-table-column label="operation">
        <template slot-scope="scope">
          <el-button type="success" icon="el-icon-receiving" size="mini" @click="detail(scope.row)">Details</el-button>
          <el-button type="danger" icon="el-icon-delete" size="mini" @click="star(scope.row)">Remove</el-button>
        </template>
      </el-table-column>
    </el-table>
    <br />
    <el-button size="medium" type="danger" icon="el-icon-delete" @click="removeMore">Batch</el-button>
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
            <p>Stock: {{chooseItem.stock}}</p>
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
          <el-tab-pane label="Amazon description" name="first">
            <article v-html="compileMarkDown(chooseItem.amazondescription)" ></article> 
          </el-tab-pane>
          <el-tab-pane label="ebay description" name="second">
            <article v-html="compileMarkDown(chooseItem.ebaydescription)" ></article>
          </el-tab-pane>
        </el-tabs>
      </div>
    </el-drawer>
  </div>
</template>

<script>
import showdown from 'showdown'
var converter = new showdown.Converter();
export default {
  data() {
    return {
      tableData: [],
      checkAll: false,
      EcheckAll: false,
      checkedAStores: [],
      checkedEStores: [],
      Astores: [],
      Estores: [],
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
      goods: [],
      table: [],
      multipleSelection: []
    };
  },
  mounted: function() {
     this.$post("/str/getStoreByUserID", {
        user_id: sessionStorage.getItem("user_id")
      }).then(res => {
        if (res.code == 504) {
          this.$message.warning(res.message);
          return;
        }
        if (res.code == 200) {
          console.log(res.data);
          this.Astores = res.data.filter(e => e.plataeform_type == 1).map(e => e.store_name);
          this.Estores = res.data.filter(e => e.plataeform_type == 2).map(e => e.store_name);
        }
      });
    this.loadData();
  },
  methods: {
    compileMarkDown(value) {
      return converter.makeHtml(value)
    },
    loadData() {
      this.$post("/wit/getWishlist", {
        user_id: sessionStorage.getItem("user_id")
      }).then(res => {
        let temp = [];
        for (var i = 0; i < res.data.number; i++) {
          temp.push({
            name: res.data.product[i].title,
            src: res.data.product[i].remark,
            price: res.data.product[i].retail_price,
            key_words: res.data.product[i].key_words,
            brand: res.data.brand[i].name_en,
            stock: res.data.product[i].replenishment_period,
            amazondescription: res.data.packageinfo[i].amazon_description,
            ebaydescription: res.data.packageinfo[i].ebay_description,
            witid: res.data.wishlist[i].wit_id,
            star: 1,
            proid: res.data.product[i].pro_id
          });
        }
        this.goods = temp;
        this.table = temp;
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
    pushShip() {
      this.dialogVisible = false;
      this.$notify.success("Successfull");
    },

    star(item) {
      if (item.star == 1) {
        this.$post("/wit/deletedWishlist", {
          wit_id: item.witid
        }).then(res => {
          item.star = 2;
          this.loadData();
        });
        return;
      } else {
        this.$post("/wit/addWishlist", {
          user_id: sessionStorage.getItem("user_id"),
          pro_id: item.proid
        }).then(res => {
          item.star = 1;
          this.loadData();
        });
      }
    },

    detail(item) {
      this.chooseItem = item;
      this.drawer = true;
    },
    removeMore() {
      if (this.multipleSelection == 0) {
        this.$message.warning("Please select item");
        return;
      }
      this.multipleSelection.forEach(element => {
        this.star(element);
      });
      this.$message.success("Remove success");
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    },
    search() {
      this.goods = this.table.filter(
        e => e.name.match(this.search_name) && e.key_words.match(this.type)
      );
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