<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/main' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>Goods</el-breadcrumb-item>
    </el-breadcrumb>
    <br />
    <br />

    <span>
      name：
      <el-input style="width:200px" placeholder @input="search" v-model="search_username"></el-input>
    </span>
    <el-button type="danger" icon="el-icon-search"></el-button>
    <el-button type="danger" plain icon="el-icon-plus" @click="dialogVisible = true">add</el-button>

    <br />
    <br />
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="id" sortable label="ID"></el-table-column>
      <el-table-column prop="name" label="name"></el-table-column>
      <el-table-column prop="price" label="price"></el-table-column>
      <el-table-column prop="num" label="number"></el-table-column>
      <el-table-column prop="sku" label="sku"></el-table-column>

      <el-table-column label="operation">
        <template>
          <el-button type="danger" size="mini">delete</el-button>
          <el-button type="danger" size="mini">change</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog title="Add" :visible.sync="dialogVisible" width="30%">
      <br />
      <br />
      <span>name：</span>
      <el-input style="width:300px" placeholder></el-input>
      <br />
      <br />
      <span>price：</span>
      <el-input style="width:300px"></el-input>
      <br />
      <br />
      <span>number：</span>
      <el-input style="width:300px" placeholder></el-input>
      <br />
      <br />
      <span>sku：</span>
      <el-input style="width:300px"></el-input>
      <br />
      <br />
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">canceal</el-button>
        <el-button type="danger" @click="dialogVisible = false">sure</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [
        { id: 1, name: "joy", price: 34, num: 8888, sku: "GM001031" }
      ],
      orginTableData: [],
      dialogVisible: false
    };
  },
  mounted() {},
  methods: {}
};
</script>

<style>
.top {
  display: flex;
  flex-direction: row;
  width: 20%;
  font-size: 15px;
  font-weight: bold;
  justify-content: space-between;
}
</style>