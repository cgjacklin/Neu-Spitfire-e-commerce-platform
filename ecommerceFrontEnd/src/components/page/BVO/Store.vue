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
        <el-col :span="4" v-for="item in aList" :key="item.store_name">
          <el-card class="card">
            <div class="card-flex">
              <img :src="aImg" class="img" />
              <span>{{item.store_name}}</span>
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
        <el-col :span="4" v-for="item in eList" :key="item.store_name">
          <el-card class="card">
            <div class="card-flex">
              <img :src="eImg" class="img" />
              <span>{{item.store_name}}</span>
            </div>
          </el-card>
        </el-col>
      </el-row>
      <el-button class="btn" icon="el-icon-plus" type="danger" @click="dialogVisible=true">Add Store</el-button>
    </div>

    <el-dialog title="Add new store" :visible.sync="dialogVisible" width="25.5%">
      <span>
        Store Name：
        <el-input
          style="width:20rem"
          v-model="store_name"
          placeholder="Please enter the store name."
        ></el-input>
      </span>
      <br />
      <br />

      <div class="radio">
        <span>
          Store Type：
          <el-radio v-model="plataeform_type" label="1">Amazon</el-radio>
          <el-radio v-model="plataeform_type" label="2">Ebay</el-radio>
        </span>
      </div>
      <br />

      <div class="radio">
        <span>
          Store state：
          <el-radio v-model="store_sts_cd" label="0">Error</el-radio>
          <el-radio v-model="store_sts_cd" label="1">Normal</el-radio>
          <el-radio v-model="store_sts_cd" label="2">Close</el-radio>
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
      plataeform_type: "1",
      store_name: "",
      store_sts_cd: "1",
      dialogVisible: false,
      aImg: require("../../../assets/amazon.png"),
      eImg: require("../../../assets/ebay.png"),
      aList: [],
      eList: []
    };
  },
  mounted() {
    this.getStoreList();
  },
  methods: {
    getStoreList() {
      this.$post("/str/getStoreByUserID", {
        user_id: sessionStorage.getItem("user_id")
      }).then(res => {
        if (res.code == 504) {
          this.$message.warning(res.message);
          return;
        }
        if (res.code == 200) {
          console.log(res.data);
          this.aList = res.data.filter(e => e.plataeform_type == 1);
          this.eList = res.data.filter(e => e.plataeform_type == 2);
        }
      });
    },
    add() {
      this.$post("/str/addStore", {
        user_id: sessionStorage.getItem("user_id"),
        plataeform_type: this.plataeform_type,
        store_name: this.store_name,
        store_sts_cd: this.store_sts_cd
      }).then(res => {
        if (res.code == 504) {
          this.$message.warning(res.message);
          return;
        }
        if (res.code == 200) {
          this.$message.success("Successfully added new store!");
          this.getStoreList();
        }
      });

      this.dialogVisible = false;
      this.store_name = '';
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