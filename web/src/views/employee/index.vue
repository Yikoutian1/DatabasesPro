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
          <el-button
            @click="handleShowInfo(scope.row)"
            type="primary"
            size="small"
            >编辑</el-button
          >
          <el-button size="small" type="danger" @click="del(scope.row.id)"
            >删除</el-button
          >
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
          <el-button type="primary" @click="confirmUpdate()">保存</el-button>
          <el-button @click="concelUpdate()">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
import { getEmployeeInfo } from "@/api/employee";
import { getDeptNameList } from "@/api/employee";
import { getSalaryOnlyLevel } from "@/api/employee";
import { getSalaryLevel } from "@/api/employee";
import { updateEmployeeInfo } from "@/api/employee";
import { saveEmployeeInfo } from "@/api/employee";
import { delEmployee } from "@/api/employee";

export default {
  name: "employee",
  data() {
    return {
      showEmpInfoDialogTableVisible: false, // 控制显示员工页的弹窗按钮
      page: {
        pageSize: 20, // 默认一页20个
        currentPage: 1, // 默认第一页
        total: 0, // 默认0
        sortBy: "id", // 默认排序字段id
        orderBy: "ASC", // 默认以ASC排序
      },
      choiseRow: [], // 选择的行信息
      oldChoiseRow: [], // 旧表单
      employeeList: [],
      loading: true, // 加载动画
      salaryJbOptions: [], // 工资级别选择列表
      deptOptions: [], // 部门名
    };
  },
  methods: {
    
    del(id) {
      this.$confirm("确定要删除吗？", "删除操作", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        closeOnClickModal: false,
        type: "warning",
        center: true,
      }).then(async () => {
        await delEmployee(id).then((res) => {
          if (res.code === 200) {
            this.$message({
              message: "删除成功",
              type: "success",
            });
          } else {
            this.$message.error("删除失败");
          }
        });
      });
    },
    confirmUpdate() {
      // console.info(this.choiseRow);
      const _this = this;
      updateEmployeeInfo(_this.choiseRow).then((res) => {
        if (res.code === 200) {
          this.$message({
            message: "更新成功",
            type: "success",
          });
        } else {
          this.$message.error("更新失败");
        }
        _this.showEmpInfoDialogTableVisible = false;
      });
    },
    concelUpdate() {
      const _this = this;
      _this.oldChoiseData();
      _this.showEmpInfoDialogTableVisible = false;
    },
    /**
     * 原表单数据
     */
    oldChoiseData() {
      const _this = this;
      _this.choiseRow.dept = _this.oldChoiseRow.dept;
      _this.choiseRow.id = _this.oldChoiseRow.id;
      _this.choiseRow.name = _this.oldChoiseRow.name;
      _this.choiseRow.salaryDj = _this.oldChoiseRow.salaryDj;
      _this.choiseRow.salaryJb = _this.oldChoiseRow.salaryJb;
      _this.choiseRow.sex = _this.oldChoiseRow.sex;
      // console.info("old:" + _this.choiseRow);
    },
    /**
     * 初始化选项
     */
    initOptions() {
      const _this = this;
      // 获取工资对照表
      getSalaryOnlyLevel().then((res) => {
        let jsonModel = res.data;
        if (res.code === 200) {
          _this.salaryJbOptions = jsonModel;
        }
      });
    },
    /**
     * TODO 处理修改员工信息保存
     */
    handleShowInfo(row) {
      const _this = this;
      _this.showEmpInfoDialogTableVisible = true;
      _this.saveOldChoiseRowInfo(row);
      _this.choiseRow = row;
      // console.info(_this.choiseRow);
    },
    // 旧表单
    saveOldChoiseRowInfo(row) {
      const _this = this;
      _this.oldChoiseRow.dept = row.dept;
      _this.oldChoiseRow.id = row.id;
      _this.oldChoiseRow.name = row.name;
      _this.oldChoiseRow.salaryDj = row.salaryDj;
      _this.oldChoiseRow.salaryJb = row.salaryJb;
      _this.oldChoiseRow.sex = row.sex;
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
        let jsonModel = res.data;
        if (res.code === 200) {
          _this.page.total = parseInt(jsonModel.total);
          _this.employeeList = jsonModel.records;
          _this.loading = false;
        } else {
          this.$message.error("服务器打瞌睡了");
        }
      });
    },
    getDeptNames() {
      const _this = this;
      getDeptNameList().then((res) => {
        let jsonModel = res.data;
        if (res.code === 200) {
          _this.deptOptions = jsonModel;
        } else {
          this.$message.error("服务器打瞌睡了");
        }
      });
    },
  },
  mounted() {
    const _this = this;
    _this.getEmployeePageInfo();
    _this.initOptions();
    _this.getDeptNames();
  },
  watch: {
    "choiseRow.salaryJb"() {
      getSalaryLevel(this.choiseRow.salaryJb).then((res) => {
        if (res.code === 200) {
          if (res.message == "数据为空") return;
          // console.info(res.data);
          this.choiseRow.salaryDj = res.data;
        }
      });
    },
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
