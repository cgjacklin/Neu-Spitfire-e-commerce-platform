<template>
  <div>
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/main' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item>Fund check</el-breadcrumb-item>
    </el-breadcrumb>
    <br />
    <br />

    <span>
      Search：
      <el-input style="width:15rem" placeholder="Account name" @input="search" v-model="account"></el-input>
    </span>
    <el-date-picker
      v-model="value"
      type="daterange"
      start-placeholder="start date"
      end-placeholder="end date"
      value-format="yyyy-MM-dd"
      :default-time="['00:00:00', '23:59:59']"
      @change="search"
    ></el-date-picker>
    <el-button type="danger" icon="el-icon-search"></el-button>
    <el-divider></el-divider>
    <el-table 
    :data="tableData.slice((currentPage-1)*pagesize,currentPage*pagesize)"
    style="width: 100%"
    height="600"
    >
      <el-table-column prop="transaction_audit_id" label="Transaction audit id"></el-table-column>
      <el-table-column prop="user_id" label="User id"></el-table-column>
      <el-table-column prop="name" label="Account name"></el-table-column>
      <el-table-column
        prop="type"
        label="Business types"
        :filter-method="filterHandler"
        :filters="[{ text: 'Deposit', value: 'Deposit' }, { text: 'Withdraw', value: 'Withdraw' }]"
      ></el-table-column>
      <el-table-column prop="amount" label="Amount"></el-table-column>
      <el-table-column prop="time" label="Apply time"></el-table-column>
      <el-table-column
        prop="state"
        label="State"
        :filter-method="filterHandler"
        :filters="[{ text: 'Applying', value: 'Applying' }, { text: 'Completed', value: 'Completed'}, { text: 'Failed', value: 'Failed'}]"
      ></el-table-column>
      <el-table-column label="operation">
        <template slot-scope="scope">
          <el-button type="success" size="mini" @click="pass(scope.row)">Pass</el-button>
          <el-button type="danger" size="mini" @click="refuse(scope.row)">Refuse</el-button>
        </template>
      </el-table-column>
    </el-table>
    <br>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-sizes="[10,12,table.length]"
      :page-size="pagesize"
      layout="total,sizes,prev,pager,next,jumper"
      :total="tableData.length"
    ></el-pagination>
    <el-dialog title="Refuse" :visible.sync="dialogVisible" width="23%">
      <span>Upload the order：</span>
      <br />
      <br />
      <el-upload
        ref="upload"
        drag
        action="http://localhost:3000/api/file/up"
        :file-list="fileList"
        :on-change="fileChange"
        :auto-upload="false"
        list-type="picture"
        :limit="1"
      >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">
          Drag the file here, or
          <em>Click to upload</em>
        </div>
        <div
          class="el-upload__tip"
          slot="tip"
        >It is recommended to upload JPG/PNG files and not exceed 500kb</div>
      </el-upload>
      <br />
      <span>
        Reason：
        <el-input style="width:18rem" v-model="reason" placeholder="Reason for refusal"></el-input>
      </span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="diaCancel">cancel</el-button>
        <el-button type="danger" @click="sure">Sure</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      value: "",
      count: 0,
      fileList: [],
      dialogVisible: false,
      account: "",
      tableData: [],
      table: [],
      tableData1: [],
      reason: "",
      currentPage: 1, //默认页码为1
      pagesize: 10, //默认一页显示11条
    };
  },

  mounted() {
    this.$post("/wal/getroleid", {
      user_id: sessionStorage.getItem("user_id")
    }).then(res => {
      if (res.message == "0") {
        this.getAudit();
      } else {
        this.$message.warning("Permission denied");
      }
    });
  },
  methods: {
    handleSizeChange(size) {
      //一页显示多少条
      this.pagesize = size;
    },
    handleCurrentChange(currentPage) {
      //页码更改方法
      this.currentPage = currentPage;
    },
    getAudit() {
      this.tableData = [];
      this.$post("/wal/getAudit", {
        user_id: sessionStorage.getItem("user_id")
      }).then(res => {
        if (res.code == 200) {
          for (var i = 0; i < res.data.WalletTransactionAudit.length; i++) {
            var date =
              res.data.WalletTransactionAudit[i].create_time.slice(0, 10) +
              " " +
              res.data.WalletTransactionAudit[i].create_time.slice(11, 19);
            var ty;
            if (res.data.WalletTransactionAudit[i].operate_type == 1) {
              ty = "Deposit";
            } else if (res.data.WalletTransactionAudit[i].operate_type == 2) {
              ty = "Withdraw";
            } else if (res.data.WalletTransactionAudit[i].operate_type == 3) {
              ty = "Consume";
            } else if (res.data.WalletTransactionAudit[i].operate_type == 4) {
              ty = "Refund";
            }
            var st;
            if (res.data.WalletTransactionAudit[i].status == 1) {
              st = "Applying";
            } else if (res.data.WalletTransactionAudit[i].status == 2) {
              st = "Completed";
            } else if (res.data.WalletTransactionAudit[i].status == 0) {
              st = "Failed";
            }
            this.tableData.push({
              user_id: res.data.WalletTransactionAudit[i].buyer_id,
              transaction_audit_id:
                res.data.WalletTransactionAudit[i].transaction_audit_id,
              name: res.data.name[i],
              type: ty,
              amount: res.data.WalletTransactionAudit[i].operate_money,
              time: date,
              state: st
            });
            this.table.push({
              user_id: res.data.WalletTransactionAudit[i].buyer_id,
              transaction_audit_id:
                res.data.WalletTransactionAudit[i].transaction_audit_id,
              name: res.data.name[i],
              type: ty,
              amount: res.data.WalletTransactionAudit[i].operate_money,
              time: date,
              state: st
            });
          }
        } else {
          if (res.message == "Permission denied") {
            this.$message.warning("Permission denied");
          }
        }
      });
    },
    sure() {
      if (this.reason == "") {
        this.$message.warning("The reason cannot be empty");
        return;
      }
      // if (this.count == 0) {
      //   this.$message.warning("Please upload the order img");
      //   return;
      // }
      console.log(this.tableData1);
      if (this.tableData1.state == "Applying") {
        this.$post("/wal/adminAudit", {
          admin_id: sessionStorage.getItem("user_id"),
          user_id: this.tableData1.user_id,
          transaction_audit_id: this.tableData1.transaction_audit_id,
          status: 0
        }).then(res => {
          if (res.code == 200) {
            this.$message.success("Successfully refuse!");
            this.getAudit();
          }
        });
      } else {
        this.$message.warning("Has been dealt with");
      }

      this.dialogVisible = false;
    },
    diaCancel() {
      this.dialogVisible = false;
      this.count = 0;
      this.reason = "";
      this.fileList = [];
    },
    filterHandler(value, row, column) {
      const property = column["property"];
      return row[property] === value;
    },
    search() {
      let timelist = [];
      if (!this.value) {
        timelist = ["1900-01-01", "2200-01-01"];
      } else {
        timelist = this.value;
      }
      this.tableData = this.table.filter(
        e =>
          e.name.match(this.account) &&
          timelist[0] <= e.time.slice(0, 10) &&
          e.time.slice(0, 10) <= timelist[1]
      );
    },
    pass(row) {
      if (row.state == "Applying") {
        this.$post("/wal/adminAudit", {
          admin_id: sessionStorage.getItem("user_id"),
          user_id: row.user_id,
          transaction_audit_id: row.transaction_audit_id,
          status: 2
        }).then(res => {
          if (res.code == 200) {
            this.$message.success("Successfully pass!");
            this.getAudit();
          }
        });
      } else {
        this.$message.warning("Has been dealt with");
      }
    },
    refuse(row) {
      this.dialogVisible = true;
      this.tableData1 = row;
    },
    fileChange() {
      this.count++;
    }
  }
};
</script>

<style scoped>
.table >>> .el-checkbox__input.is-indeterminate .el-checkbox__inner {
  background-color: #f56c6c;
  border-color: #f56c6c;
}
.table >>> .el-checkbox__input.is-checked .el-checkbox__inner {
  background-color: #f56c6c;
  border-color: #f56c6c;
}
.table >>> .el-checkbox__input.is-checked + .el-checkbox__label {
  color: #f56c6c;
}
</style>