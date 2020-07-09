<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/main' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>Store</el-breadcrumb-item>
    </el-breadcrumb>

    <div class="main">
      <el-link style="font-size:18px" :underline="false" type="warning">Amazon</el-link>
      <el-divider></el-divider>
      <el-row>
        <el-col :span="4" v-for="item in aList" :key="item.name">
          <el-card class="card">
            <div class="card-flex">
              <img :src="aImg" class="img" />
              <span>{{item.name}}</span>
            </div>
          </el-card>
        </el-col>
      </el-row>
      <br />
      <el-link style="font-size:18px" :underline="false" type="danger">E</el-link>
      <el-link style="font-size:18px" :underline="false" type="primary">b</el-link>
      <el-link style="font-size:18px" :underline="false" type="warning">a</el-link>
      <el-link style="font-size:18px" :underline="false" type="success">y</el-link>
      <el-divider></el-divider>
      <el-row>
        <el-col :span="4" v-for="item in aList" :key="item.name">
          <el-card class="card">
            <div class="card-flex">
              <img :src="eImg" class="img" />
              <span>{{item.name}}</span>
            </div>
          </el-card>
        </el-col>
      </el-row>
      <el-button class="btn" icon="el-icon-plus" type="danger" @click="dialogVisible=true">Add Store</el-button>
    </div>

    <el-dialog title="Add new store" :visible.sync="dialogVisible" width="25.5%">
      <span>
        Store Name：
        <el-input style="width:20rem" v-model="name" placeholder="Please enter the store name."></el-input>
      </span>
      <br />
      <br />

      <div class="radio">
        <span>
          Store Type：
          <el-radio v-model="type" label="1">Amazon</el-radio>
          <el-radio v-model="type" label="2">Ebay</el-radio>
        </span>
      </div>

      <span slot="footer" class="dialog-footer">
        <el-button type="danger" @click="add">Sure</el-button>
        <el-button @click="dialogVisible=false">Cancel</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      type: "1",
      name: "",
      dialogVisible: false,
      aImg: require("../../../assets/amazon.png"),
      eImg: require("../../../assets/ebay.png"),
      aList: [{ name: 1 }, { name: 2 }],
      eList: [{ name: 1 }, { name: 2 }]
    };
  },
  methods: {
    add() {
      this.dialogVisible = false;
    }
  }
};
</script>

<style scoped>
.main {
  margin-top: 2rem;
}
.card {
  margin-top: 0.8rem;
  width: 15rem;
  height: 15rem;
}
.img {
  width: 7rem;
  height: 7rem;
}
.card-flex {
  height: 13rem;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
}
.btn {
  margin-top: 2rem;
  margin-left: 89rem;
}
.radio >>> .el-radio__input.is-checked .el-radio__inner {
  border-color: #f46774;
  background: #f46774;
}
.radio >>> .el-radio__input.is-checked + .el-radio__label {
  color: #f46774;
}
</style>