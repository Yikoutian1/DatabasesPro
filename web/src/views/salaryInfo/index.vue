<template>
  <div class="table">
    <el-table :data="salaryInfoList" border style="width: 100%" :expand-row-keys="expandRowKeys"
      :row-class-name="tableRowClassName" @row-click="handleRowClick">

      <el-table-column prop="empId" label="员工编号" width="150">
      </el-table-column>
      <el-table-column prop="empName" label="员工姓名" width="120">
      </el-table-column>
      <el-table-column prop="baseSalary" label="员工基础工资" width="120">
        <template slot-scope="scope">
          ￥{{ scope.row.baseSalary }}
        </template>
      </el-table-column>
      <el-table-column prop="jobSalary" label="员工岗位工资" width="120">
        <template slot-scope="scope">
          ￥{{ scope.row.jobSalary }}
        </template>
      </el-table-column>
      <el-table-column prop="expSalary" label="员工工龄工资" width="200">
        <template slot-scope="scope">
          ￥{{ scope.row.expSalary }}
        </template>
      </el-table-column>
      <el-table-column prop="companyBenefits" label="公司福利" width="120">
        <template slot-scope="scope">
          ￥{{ scope.row.companyBenefits }}
        </template>
      </el-table-column>
      <el-table-column prop="netSalary" label="员工实得工资" width="120">
        <template slot-scope="scope">
          ￥{{ scope.row.netSalary }}
        </template>
      </el-table-column>
      <el-table-column label="操作" width="150">
        <template slot-scope="scope">
          <el-button type="primary" size="small" @click="handleShowInfo(scope.row)">编辑</el-button>
          <el-button type="danger" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>


    <el-dialog title="员工的薪资信息修改" :visible.sync="showSalaryInfoDialogTableVisible">
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
        <el-form-item label="员工岗位工资" prop="jobSalary">
          <el-input v-model="choiseRow.jobSalary"></el-input>
        </el-form-item>
        <el-form-item label="员工工龄工资" prop="expSalary">
          <el-input v-model="choiseRow.expSalary"></el-input>
        </el-form-item>
        <el-form-item label="公司福利" prop="companyBenefits">
          <el-input v-model="choiseRow.companyBenefits"></el-input>
        </el-form-item>
        <el-form-item label="员工实得工资" prop="netSalary">
          <el-input v-model="choiseRow.netSalary"></el-input>
        </el-form-item>
        <el-form-item style="display: flex; justify-content: center;">
          <el-button type="primary" @click="confirmUpdate()">保存</el-button>
          <el-button @click="concelUpdate()">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>



  </div>
</template>


<script>
import { getSalaryInfo } from "@/api/salaryInfo";

export default {
  name: "salaryInfo",
  data () {
    return {
      showSalaryInfoDialogTableVisible: false, // 控制显示员工页的弹窗按钮
      page: {

        sortBy: "id", // 默认排序字段id
        orderBy: "ASC", // 默认以ASC排序
      },
      oldChoiseRow: [], // 旧表单
      choiseRow: [], // 选择的行信息
      salaryInfoList: [],
    };
  },

  methods: {

    tableRowClassName: function (row) {
      console.log(row)
      if (row.rowIndex === 1) {
        return 'warning-row';
      } else if (row.rowIndex === 3) {
        return 'success-row';
      }
      return '';
    },



    /**
     * 保存
     */
    confirmUpdate () {
      console.info(this.choiseRow);
    },
    /**
     * 取消
     */
    concelUpdate () {
      const _this = this;
      _this.oldChoiseData();
      _this.showSalaryInfoDialogTableVisible = false;
    },
    /**
     * 原表单数据
     */
    oldChoiseData () {
      const _this = this;
      _this.choiseRow.empId = _this.oldChoiseRow.empId;
      _this.choiseRow.empName = _this.oldChoiseRow.empName;
      _this.choiseRow.baseSalary = _this.oldChoiseRow.baseSalary;
      _this.choiseRow.jobSalary = _this.oldChoiseRow.jobSalary;
      _this.choiseRow.expSalary = _this.oldChoiseRow.expSalary;
      _this.choiseRow.companyBenefits = _this.oldChoiseRow.companyBenefits;
      _this.choiseRow.netSalary = _this.oldChoiseRow.netSalary;
    },
    /**
     * 修改薪资信息
     */
    handleShowInfo (row) {
      const _this = this;
      _this.showSalaryInfoDialogTableVisible = true;
      _this.saveOldChoiseRowInfo(row);
      _this.choiseRow = row;
      console.info(_this.choiseRow);
    },
    // 旧表单
    saveOldChoiseRowInfo (row) {
      const _this = this;
      _this.oldChoiseRow.empId = row.empId;
      _this.oldChoiseRow.empName = row.empName;
      _this.oldChoiseRow.baseSalary = row.baseSalary;
      _this.oldChoiseRow.jobSalary = row.jobSalary;
      _this.oldChoiseRow.expSalary = row.expSalary;
      _this.oldChoiseRow.companyBenefits = row.companyBenefits;
      _this.oldChoiseRow.netSalary = row.netSalary;

    },
    /**
     * 初始化选项
     */
    initOptions () {
      const _this = this;
    },


    /**
     * 统一请求处理
     */
    getSalaryInfo () {
      const _this = this;

      getSalaryInfo().then((res) => {
        const jsonModel = res.data;
        if (res.code === 200) {

          _this.salaryInfoList = jsonModel.records;

        } else {
          this.$message.error("服务器打瞌睡了");
        }
      });
    },

    open () {
      this.$prompt('请输入邮箱', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        inputPattern: /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/,
        inputErrorMessage: '邮箱格式不正确'
      }).then(({ value }) => {
        this.$message({
          type: 'success',
          message: '你的邮箱是: ' + value
        });
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '取消输入'
        });
      });
    },
  },
  mounted () {
    const _this = this;
    _this.initOptions();
    _this.getSalaryInfo();
  },
};

</script>



<!-- 
<style  lang="css" scoped>
.table {
  text-align: center;
}
</style> -->
