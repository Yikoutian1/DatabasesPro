<template>
  <div class="main">
    <div class="table" style="float: left; margin-left: 60px">
      <div style="text-align: center; font-size: 24px; border: 1px solid gainsboro; line-height: 50px;">工资级别表</div>
      <el-table :data="expInfoList" border style="width: 100%">
        <el-table-column prop="salGrade" label="工资级别" width="150"></el-table-column>
        <el-table-column prop="salJobName" label="工作名" width="150"></el-table-column>
        <el-table-column prop="salAmount" label="工资金额" width="150">
          <template slot-scope="scope">
            <span>￥{{ scope.row.salAmount }}</span>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="120">
          <template slot-scope="scope">
            <el-button type="primary" size="small" @click="editSalaryAndLevel(scope.row)">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>


    <div style="float: right; margin-right: 130px;">
      <div style="text-align: center; font-size: 24px; border: 1px solid gainsboro; line-height: 50px;">工龄表</div>
      <el-table :data="levelInfoList" border style="width: 100%">
        <el-table-column prop="exp" label="工作经验" width="150"></el-table-column>
        <el-table-column prop="salAmount" label="工资" width="150">
          <template slot-scope="scope">
            ￥{{ scope.row.salAmount }}
          </template>
        </el-table-column>
        <el-table-column label="操作" width="120px">
          <template slot-scope="scope">
            <el-button type="primary" size="small" @click="editSalaryAndExp(scope.row)">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>

    <!-- <el-dialog title="员工的薪资信息修改" :visible.sync="showSalaryInfoDialogTableVisible">
      <el-form style="font-size: 16px" :model="choiseRow" ref="choiseRow" label-width="100px" class="class-choiseRow">
        <el-form-item label="员工编号" prop="empId">
          <span> {{ choiseRow.empId }} </span>
        </el-form-item>

        <el-form-item label="员工姓名" prop="empName">
          <el-input v-model="choiseRow.empName"></el-input>
        </el-form-item>
        <el-form-item label="员工基础工资" prop="baseSalary">
          <el-input v-model="choiseRow.baseSalary"></el-input>
        </el-form-item>

        <el-form-item style="display: flex; justify-content: center;">
          <el-button type="primary" @click="confirmUpdate()">保存</el-button>
          <el-button @click="concelUpdate()">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog> -->

  </div>
</template>


<script>
import { getSalaryExp } from "@/api/salaryExpLevel";
import { getSalaryLevel } from "@/api/salaryExpLevel";
import axios from 'axios';


export default {
  name: "salaryExpLevel",
  data () {
    return {
      levelInfoList: [],
      expInfoList: [],
      dialogLevel: false,
      dialogExp: false,
      editedRow: null,
    }
  },
  methods: {
    editSalaryAndLevel (row) {
      const _this = this;
      console.log(row);
      //_this.editedRow = row;
      _this.dialogLevel = true;
    },
    editSalaryAndExp (row) {
      const _this = this;
      console.log(row);
      //_this.editedRow = row;
      _this.dialogExp = true;
    },
    /**
     * 统一请求处理
     */
    getInfo () {
      const _this = this;

      getSalaryExp().then((res) => {
        const jsonModel = res.data;
        if (res.code === 200) {

          _this.levelInfoList = jsonModel;
          console.log(_this.levelInfoList);
        } else {
          this.$message.error("服务器打瞌睡了");
        }
      });

      getSalaryLevel().then((res) => {
        const jsonModel = res.data;
        if (res.code === 200) {

          _this.expInfoList = jsonModel;
          console.log(_this.expInfoList);

        } else {
          this.$message.error("服务器打瞌睡了");
        }
      });
    },
  },

  mounted () {
    const _this = this;
    _this.getInfo();
  }

}

</script>


<style lang="scss" scoped>
.block {
  margin-top: 1%;
  text-align: center;
}

.el-tag,
.el-table {
  font-size: 16px;
}

.mmleft {
  margin-left: 1%;
}

.main {
  margin-top: 23px;
  margin-left: 15px;

  .choise {
    margin: 1%;
  }
}

.head {
  margin: 10px auto;
}
</style>
