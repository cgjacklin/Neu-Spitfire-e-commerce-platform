<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/main' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>Company</el-breadcrumb-item>
    </el-breadcrumb>
    <br />
    <br />
    <br />
    <div class="flex">
    <span>
      Company Name：
      <el-input style="width:200px" placeholder></el-input>
    </span>
    
    <span>Brief Introduction:</span>
    
    <el-input style="width:800px" :autosize="{ minRows: 8, maxRows: 8}" type="textarea" placeholder="enter" v-model="textarea2"></el-input>

    
    <span>
      GMC Report Type：
      <el-input style="width:200px" placeholder></el-input>
    </span>
    
    <span>
      GMC Report Url：
      <el-input style="width:200px" placeholder></el-input>
    </span>
    
    <el-button style="width:150px" type="danger">save</el-button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  }
};
</script>

<style>
.flex{
    display: flex;
    height: 600px;
    flex-direction: column;
    justify-content: space-between;
}
</style>