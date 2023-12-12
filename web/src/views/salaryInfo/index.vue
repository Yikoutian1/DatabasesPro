<template>
  <div class="table">
    <el-table :data="salaryInfoList" border style="width: 100%" :expand-row-keys="expandRowKeys"
      @row-click="handleRowClick">

      <el-table-column prop="empId" label="类型" width="150">
      </el-table-column>
      <el-table-column prop="empName" label="员工姓名" width="120">
      </el-table-column>
      <el-table-column prop="baseSalary" label="员工基础工资" width="120">
      </el-table-column>
      <el-table-column prop="jobSalary" label="员工岗位工资" width="120">
      </el-table-column>
      <el-table-column prop="expSalary" label="员工工龄工资" width="200">
      </el-table-column>
      <el-table-column prop="companyBenefits" label="公司福利" width="120">
      </el-table-column>
      <el-table-column prop="netSalary" label="员工实得工资" width="120">
      </el-table-column>
      <el-table-column label="操作" width="100">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>

  </div>
</template>


<script>
import { getSalaryInfo } from "@/api/salaryInfo";

export default {
  name: "salaryInfo",
  data () {
    return {
      page: {
        sortBy: "id", // 默认排序字段id
        orderBy: "ASC", // 默认以ASC排序
      },
      choiseRow: [], // 选择的行信息
      salaryInfoList: [],
    };
  },
  methods: {
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
  },
  mounted () {
    const _this = this;
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
