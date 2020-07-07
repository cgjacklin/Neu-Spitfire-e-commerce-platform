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
  </div>
</template>

<script>
export default {
  data() {
    return{

    }
  },
  methods:{
    search(){

    }
  }
};
</script>

<style>
</style>