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
          <el-button @click="handleShowInfo(scope.row)" type="text" size="small"
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
    <el-dialog
      title="员工信息修改"
      :visible.sync="showEmpInfoDialogTableVisible"
    >
      <el-form
        style="font-size: 16px"
        :model="choiseRow"
        ref="choiseRow"
        label-width="100px"
        class="class-choiseRow"
      >
        <el-form-item label="工号" prop="id">
          <span> {{ choiseRow.id }} </span>
        </el-form-item>
        <el-form-item label="姓名" prop="name">
          <el-input v-model="choiseRow.name"></el-input>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-radio v-model="choiseRow.sex" label="1">男</el-radio>
          <el-radio v-model="choiseRow.sex" label="0">女</el-radio>
        </el-form-item>
        <el-form-item label="所在部门" prop="dept">
          <el-select v-model="choiseRow.dept" placeholder="请选择">
            <el-option
              v-for="item in deptOptions"
              :key="item"
              :label="item"
              :value="item"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="工资级别" prop="salaryJb">
          <el-select v-model="choiseRow.salaryJb" placeholder="请选择">
            <el-option
              v-for="item in salaryJbOptions"
              :key="item"
              :label="item"
              :value="item"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="工资等级" prop="salaryDj">
          {{ choiseRow.salaryDj }}
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')"
            >立即创建</el-button
          >
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import { getEmployeeInfo } from "@/api/employee";
import { getSalaryLevel } from "@/api/employee";
import { getDeptList } from "@/api/employee";

export default {
  name: "employee",
  data() {
    return {
      showEmpInfoDialogTableVisible: true, // 控制显示员工页的弹窗按钮
      page: {
        pageSize: 20, // 默认一页20个
        currentPage: 1, // 默认第一页
        total: 0, // 默认0
        sortBy: "id", // 默认排序字段id
        orderBy: "ASC", // 默认以ASC排序
      },
      choiseRow: [], // 选择的行信息
      employeeList: [],
      loading: true, // 加载动画
      deptOptions: [], // 所在部门选择列表
      salaryJbOptions: [], // 工资级别选择列表
    };
  },
  methods: {
    /**
     * 初始化选项
     */
    initOptions() {
      const _this = this;
      // 工资等级
      getSalaryLevel().then((res) => {
        let jsonModel = res.data;
        if (res.code === 200) {
          _this.salaryJbOptions = jsonModel;
        }
      });
      // 部门列表
      getDeptList().then((res) => {
        let jsonModel = res.data;
        if (res.code === 200) {
          _this.deptOptions = jsonModel;
        }
      });
    },
    /**
     * 处理修改员工信息保存
     */
    handleShowInfo(row) {
      const _this = this;
      _this.showEmpInfoDialogTableVisible = true;
      _this.choiseRow = row;
      console.info(_this.choiseRow);
    },
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
    _this.initOptions()
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
.mmleft {
  margin-left: 1%;
}
</style>
