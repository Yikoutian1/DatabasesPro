<template>
  <div class="login-container">
    <el-table
      :data="employeeList"
      v-loading="loading"
      border
      style="width: 100%"
      class="mmleft"
    >
      <el-table-column
        
        fixed
        prop="id"
        label="员工编号"
        width="120"
      ></el-table-column>
      <el-table-column prop="name" label="姓名" width="140"> </el-table-column>
      <el-table-column prop="sex" label="性别" width="70">
        <template #default="scope">
          <el-tag size="medium " type="success" v-if="scope.row.sex == 1">
            男
          </el-tag>
          <el-tag v-else> 女 </el-tag>
        </template>
      </el-table-column>
      <el-table-column
        prop="dept"
        label="所在部门"
        width="140"
      ></el-table-column>
      <el-table-column
        prop="salaryJb"
        label="工资级别"
        width="170"
      ></el-table-column>
      <el-table-column
        prop="salaryDj"
        label="工资等级"
        width="120"
      ></el-table-column>
      <el-table-column label="操作" width="300">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small"
            >查看</el-button
          >
          <el-button type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="block">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="page.currentPage"
        :page-sizes="[10, 20, 50, 100]"
        :page-size="page.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="page.total"
      >
      </el-pagination>
    </div>
  </div>
</template>

<script>
import { getEmployeeInfo } from "@/api/employee";

export default {
  name: "employee",
  data() {
    return {
      page: {
        pageSize: 20, // 默认一页20个
        currentPage: 1, // 默认第一页
        total: 0, // 默认0
        sortBy: "id", // 默认排序字段id
        orderBy: "ASC", // 默认以ASC排序
      },
      employeeList: [],
      loading: true, // 加载动画
    };
  },
  methods: {
    /**
     * 修改分页大小
     */
    handleSizeChange(newSize) {
      const _this = this;
      _this.page.pageSize = newSize;
      _this.getEmployeePageInfo();
    },
    /**
     * 修改当前页码
     */
    handleCurrentChange(newPageNum) {
      const _this = this;
      _this.page.currentPage = newPageNum;
      _this.getEmployeePageInfo();
    },
    /**
     * 统一请求处理
     */
    getEmployeePageInfo() {
      const _this = this;
      let param = new URLSearchParams();
      param.append("pageNum", _this.page.currentPage);
      param.append("pageSize", _this.page.pageSize);
      param.append("orderBy", _this.page.orderBy);
      param.append("sortBy", _this.page.sortBy);
      getEmployeeInfo(param).then((res) => {
        const jsonModel = res.data;
        if (res.code === 200) {
          _this.page.total = jsonModel.total;
          _this.employeeList = jsonModel.records;
          _this.loading = false;
        } else {
          this.$message.error("服务器打瞌睡了");
        }
      });
    },
  },
  mounted() {
    const _this = this;
    _this.getEmployeePageInfo();
  },
};
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
.mmleft{
  margin-left: 1%;
}
</style>
