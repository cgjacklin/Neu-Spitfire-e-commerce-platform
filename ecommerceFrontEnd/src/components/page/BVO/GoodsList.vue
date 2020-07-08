<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/main' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>Goods list</el-breadcrumb-item>
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
    <el-row>
      <el-col :span="4" v-for="item in goods" :key="item.name">
        <div>
          <el-card class="goods-card" :body-style="{ padding: '0px' }">
            <img :src="item.src" class="small-img" @click="detail(item)" />
            <div class="goods-info-div">
              <div class="goods-row">
                <span>{{item.name}}</span>
                <div class="small-icon" @click="star(item)">
                  <i :class="item.star == 1 ? 'el-icon-star-on' :'el-icon-star-off'"></i>
                </div>
              </div>
              <div class="goods-row">
                <el-link :underline="false" type="danger">{{item.price}} ¥</el-link>
                <el-button type="text" class="btn" @click="detail(item)">Details</el-button>
              </div>
            </div>
          </el-card>
        </div>
      </el-col>
    </el-row>

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
            <el-button type="danger">Dropship Now</el-button>
            <el-button type="danger">Add to Wish List</el-button>
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
        {
          name: "Iphone7",
          src:
            "http://img1.imgtn.bdimg.com/it/u=1524275480,3404163321&fm=26&gp=0.jpg",
          price: 3333,
          star: 1
        },
        {
          name: "Mac book",
          src:
            "https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png",
          price: 3333,
          star: 2
        }
      ]
    };
  },
  methods: {
    star(item) {
      if (item.star == 1) {
        item.star = 2;
        return;
      }
      item.star = 1;
    },
    detail(item) {
      console.log(item);
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
.tab{
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
  margin-top: 0.5rem;
  margin-left: 1rem;
}
.small-img {
  width: 100%;
  height: 15rem;
}
.img {
  width: 20rem;
  height: 20rem;
}
.goods-card {
  margin-top: 0.8rem;
  width: 15rem;
  height: 20rem;
}
</style>