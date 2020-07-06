<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/main' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>Goods</el-breadcrumb-item>
    </el-breadcrumb>
    <br />
    <br />

    <span>
      Search：
      <el-input
        style="width:200px"
        placeholder="Goods title"
        @input="search"
        v-model="search_goodstitle"
      ></el-input>
    </span>
    <el-button type="danger" plain icon="el-icon-plus" @click="drawer = true">Add</el-button>

    <br />
    <br />
    <el-table :data="tableData" style="width: 100%" class="table-check">
      <el-table-column type="selection" width="50"></el-table-column>
      <el-table-column prop="name" label="Goods title"></el-table-column>
      <el-table-column prop="type" label="Goods type"></el-table-column>
      <el-table-column prop="picture" label="Goods picture"></el-table-column>
      <el-table-column prop="price" label="Goods price"></el-table-column>
      <el-table-column prop="num" label="Stock"></el-table-column>
      <el-table-column prop="tag" label="State">
        <template slot-scope="scope">
          <el-tag
            :type="tag(scope.row.tag)"
            disable-transitions
          >{{scope.row.tag}}</el-tag>
        </template>
      </el-table-column>

      <el-table-column label="operation" width="250">
        <template slot-scope="scope">
          <el-button type="success" plain size="small" icon="el-icon-edit" @click="edit(scope.row)"></el-button>
          <el-button type="danger" size="small" icon="el-icon-delete"></el-button>
          <el-button type="success" size="small">{{btn(scope.row.tag)}}</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-drawer
      title="drawer"
      :visible.sync="drawer"
      size="50%"
      :wrapperClosable="false"
      :with-header="false"
    >
      <br />
      <br />
      <span>Goods title：</span>
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
        <el-button @click="drawer = false">canceal</el-button>
        <el-button type="danger" @click="drawer = false">sure</el-button>
      
    </el-drawer>
  </div>
</template>

<script>
export default {
  data() {
    return {
      search_goodstitle: "",
      tableData: [
        {
          id: 1,
          name: "joy",
          price: 34,
          num: 8888,
          sku: "GM001031",
          tag: "In warehouse",
          n:'push'
        }
      ],
      orginTableData: [],
      drawer: false
    };
  },
  mounted() {},
  methods: {
    edit(row){
      this.drawer = true;
    },
    btn(msg){
      if(msg == 'Not in warehouse')return 'push'
      if(msg == 'In warehouse')return 'Shelve'
      if(msg == 'On shelf')return 'Unshelve'
    },
    tag(msg){
      if(msg == 'Not in warehouse')return 'danger'
      if(msg == 'In warehouse')return 'warning'
      if(msg == 'On shelf')return 'success'
    },
    search() {}
  }
};
</script>

<style scoped>
.top {
  display: flex;
  flex-direction: row;
  width: 20%;
  font-size: 15px;
  font-weight: bold;
  justify-content: space-between;
}
.table-check >>> .el-checkbox__input.is-checked .el-checkbox__inner,
.el-checkbox__input.is-indeterminate .el-checkbox__inner {
  background-color: #f56c6c;
  border-color: #f56c6c;
}
</style>