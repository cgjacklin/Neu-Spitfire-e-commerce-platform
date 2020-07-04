<template>
  <div class="card-body">
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/main' }">Home</el-breadcrumb-item>
    </el-breadcrumb>
    <div class="top-box">
      <el-card class="card" v-for="item in cardInfo" :key="item.name">
        <div class="card-flex" @click="card">
          <img :class="item.class" :src="item.img" alt />
          <div>
            <h2 class="name">{{item.name}}</h2>
            <h1 class="num">{{item.num}}</h1>
          </div>
        </div>
      </el-card>
    </div>
    <div class="chart-box">
      <ve-ring
        style="width:600px"
        :data="chartData"
      >Summary of platform users ( Pre means the user has no orders on the platform )</ve-ring>
      <ve-line
        style="width:600px"
        :data="chartData1"
      >The number of orders which completed on the platform within the last four days .</ve-line>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      userImg: require("../../assets/user.png"),
      goodsImg: require("../../assets/goods.png"),
      orderImg: require("../../assets/order.png"),
      walletImg: require("../../assets/wallet.png"),
      cardInfo: [],
      chartData: {
        columns: ["User", "Num"],
        rows: [
          { User: "Brand-seller", Num: 1393 },
          { User: "Borrow-seller", Num: 3530 },
          { User: "Pre-Brand-seller", Num: 2000 },
          { User: "Pre-Borrow-seller", Num: 1000 }
        ]
      },
      chartData1: {
        columns: [
          "date",
          "Completed orders",
          "New orders",
          "orders in progress"
        ],
        rows: [
          {
            date: "07.01",
            "New orders": 500,
            "Completed orders": 1093,
            "orders in progress": 1000
          },
          {
            date: "07.02",
            "New orders": 2000,
            "Completed orders": 3230,
            "orders in progress": 2000
          },
          {
            date: "07.03",
            "New orders": 3000,
            "Completed orders": 2623,
            "orders in progress": 2500
          },
          {
            date: "07.04",
            "New orders": 2800,
            "Completed orders": 1423,
            "orders in progress": 3000
          }
        ]
      }
    };
  },
  mounted() {
    this.cardInfo = [
      {
        name: "Role",
        num: "admin",
        img: this.userImg,
        class: "img-class1"
      },
      {
        name: "Goods",
        num: "200",
        img: this.goodsImg,
        class: "img-class2"
      },
      {
        name: "Orders",
        num: "12350",
        img: this.orderImg,
        class: "img-class1"
      },
      {
        name: "Wallet",
        num: "100$",
        img: this.walletImg,
        class: "img-class2"
      }
    ];
  },
  methods: {
    card() {}
  }
};
</script>

<style scoped>
.card-body >>>.el-card__body {
  padding: 0px;
}
.top-box {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  margin-top: 3rem;
}
.card-flex {
  height: 9rem;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
}
.card {
  width: 20rem;
  height: 9rem;
}
.img-class1 {
  width: 3.5rem;
  height: 4.5rem;
}
.img-class2 {
  width: 4.5rem;
  height: 4.5rem;
}
.name {
  font-size: 18px;
  color: grey;
}
.num {
  font-size: 25px;
  color: rgb(199, 121, 121);
}
.chart-box {
  margin-top: 6rem;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-content: center;
}
</style>