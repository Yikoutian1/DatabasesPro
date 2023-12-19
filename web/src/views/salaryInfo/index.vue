<template>
  <div class="main">

    <div class="head">
      <el-input v-model="param" placeholder="请输入员工姓名" style="width: 200px">
      </el-input>
      <el-button style="margin-left: 5px" type="primary" @click="Search" class="el-button-search">搜索员工</el-button>

      <el-button type="success" @click="addSalaryInfo()">添加新的薪资信息</el-button>
    </div>


    <div class="table">

      <el-table :data="salaryInfoList" border style="width: 100%" :expand-row-keys="expandRowKeys"
        :row-class-name="tableRowClassName" @row-click="handleRowClick">

        <el-table-column prop="empId" label="员工编号" width="150">
          <!-- sortable="custom" :sort-method="sortChange"> -->
        </el-table-column>
        <el-table-column prop="empName" label="员工姓名" width="150">
        </el-table-column>
        <el-table-column prop="baseSalary" label="员工基础工资" width="150">
          <template slot-scope="scope">
            ￥{{ scope.row.baseSalary }}
          </template>
        </el-table-column>
        <el-table-column prop="jobSalary" label="员工岗位工资" width="150">
          <template slot-scope="scope">
            ￥{{ scope.row.jobSalary }}
          </template>
        </el-table-column>
        <el-table-column prop="expSalary" label="员工工龄工资" width="150">
          <template slot-scope="scope">
            ￥{{ scope.row.expSalary }}
          </template>
        </el-table-column>
        <el-table-column prop="companyBenefits" label="公司福利" width="150">
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
            <el-button type="danger" size="small" @click="deleteChoiseRow(scope.row.empId)">删除</el-button>
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

      <el-dialog title="新增员工薪资信息" :visible.sync="showAddSalaryInfoDialogTableVisible">
        <el-form style="font-size: 16px" :model="newData" ref="newData" label-width="100px" class="class-newData">

          <el-form-item label="员工姓名">
            <el-input v-model="newData.empName" style="width: 550px;"></el-input>
          </el-form-item>
          <el-form-item label="员工基础工资">
            <span style="margin-left: 10px; font-size: 15px;"> ￥5000 </span>
          </el-form-item>

          <el-form-item label="员工岗位工资">
            <el-select v-model="value" placeholder="请选择">
              <el-option v-for="item in optionsLevel" :value="item.value" :key="item.value">{{ item.label }}</el-option>
            </el-select> ￥
          </el-form-item>
          <el-form-item label="员工工龄工资">
            <el-select v-model="ValueE" placeholder="请选择">
              <el-option v-for="item in optionsExp" :value="item.value" :key="item.value">{{ item.label }}</el-option>
            </el-select> ￥
          </el-form-item>
          <el-form-item label="公司福利">
            <el-select v-model="ValueB" placeholder="请选择">
              <el-option v-for="item in optionsBef" :value="item.value" :key="item.value">{{ item.label }}</el-option>
            </el-select> ￥
          </el-form-item>

          <el-form-item style="display: flex; justify-content: center;">
            <el-button type="primary" @click="confirmAdd">添加</el-button>
            <el-button @click="showAddSalaryInfoDialogTableVisible = false">取消</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>



    </div>
  </div>
</template>


<script>
import { getSalaryInfo } from "@/api/salaryInfo";
import axios from 'axios';


export default {
  name: "salaryInfo",
  data () {
    return {
      param: "", // 搜索
      value: '',
      optionsLevel: [
        {
          value: 75000,
          label: '资深专家,总监'
        },
        {
          value: 60000,
          label: '高级专家,资深经理'
        },
        {
          value: 45000,
          label: '专家,经理'
        },
        {
          value: 35000,
          label: '高级工程师,主管'
        },
        {
          value: 25000,
          label: '中级工程师'
        },
        {
          value: 15000,
          label: '初级工程师'
        },
        {
          value: 8000,
          label: '实习生'
        },
        {
          value: 4000,
          label: '其他'
        }
      ],
      ValueE: null,
      optionsExp: [
        {
          value: 1000,
          label: '0年'
        },
        {
          value: 5000,
          label: '1年'
        },
        {
          value: 7000,
          label: '2年'
        },
        {
          value: 10000,
          label: '3年'

        },
        {
          value: 70000,
          label: '4年'
        },
        {
          value: 13000,
          label: '5年'

        },
        {
          value: 15000,
          label: '6年'
        },
        {
          value: 20000,
          label: '7年'

        },
        {
          value: 25000,
          label: '8年'
        },
        {
          value: 30000,
          label: '9年'
        },
        {
          value: 40000,
          label: '10年'
        },
        {
          value: 50000,
          label: '11年'
        },
        {
          value: 60000,
          label: '12年'
        }
      ],
      ValueB: null,
      optionsBef: [
        {
          value: 500,
          label: '高温补贴'
        },
        {
          value: 500,
          label: '全勤奖'
        }
      ],
      showSalaryInfoDialogTableVisible: false, // 控制弹窗按钮
      showAddSalaryInfoDialogTableVisible: false, //新增弹窗
      page: {

        sortBy: "id", // 默认排序字段id
        orderBy: "ASC", // 默认以ASC排序
      },
      oldChoiseRow: [], // 旧表单
      choiseRow: [], // 选择的行信息
      salaryInfoList: [],
      newData: [],
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

    // 搜索
    Search () {
      const _this = this;
      let param = _this.param;
      if (param) {  // 只有当param不为空时才发起请求
        const url = `http://localhost:9000/salaryInfo/selectSalaryInfo/${param}`;
        axios.get(url)
          .then(response => {
            const jsonModel = response.data;
            if (jsonModel.data.total === 0) {
              this.$message.error('搜索失败，没有这条数据');
            } else {
              _this.salaryInfoList = jsonModel.data.records;
              this.$message.success('搜索成功');
            }
          })
          .catch(error => {
            console.error('Error delete : ', error);
            this.$message.error('搜索失败，没有这条数据');
          });
      } else {
        this.$message.error('请输入员工姓名');
      }
    },

    /**
     * 修改
     */
    confirmUpdate () {
      console.info(this.choiseRow);
      const _this = this;
      const url = 'http://localhost:9000/salaryInfo/updateSalaryInfo';
      const data = _this.choiseRow;

      axios.post(url, data)
        .then(response => {
          console.log(response.data);
          _this.$message.success("修改成功！")
          this.showSalaryInfoDialogTableVisible = false;
        })
        .catch(error => {
          console.error('Error sending data to the backend: ', error);
        });
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
     * 新增
     */
    addSalaryInfo () {
      const _this = this;
      _this.showAddSalaryInfoDialogTableVisible = true;

    },
    /**
     * 提交新增
     */
    confirmAdd () {
      const _this = this;
      const url = 'http://localhost:9000/salaryInfo/insertSalaryInfo';
      let data = {

        empName: this.newData.empName,
        baseSalary: 5000,
        jobSalary: this.value,
        expSalary: this.ValueE,
        companyBenefits: this.ValueB,
        netSalary: 0
      };
      data.netSalary = parseInt(data.baseSalary) + parseInt(data.jobSalary) + parseInt(data.expSalary) + parseInt(data.companyBenefits)
      //alert(data.netSalary);
      axios.post(url, data)
        .then(response => {
          console.log(response.data);
          //alert("添加成功");
          this.$message.success("添加成功！")
          this.showAddSalaryInfoDialogTableVisible = false;
          _this.getSalaryInfo(); //刷新 重新加载数据
        })
        .catch(error => {
          console.error('Error sending data to the backend: ', error);
        });
    },
    /**
     * 
     * 删除
     */
    deleteChoiseRow (id) {
      const _this = this;
      const url = `http://localhost:9000/salaryInfo/deleteSalaryInfo/${id}`;

      this.$confirm('确定要删除吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          axios.delete(url)
            .then(response => {
              _this.getSalaryInfo(); //刷新 重新加载数据

              console.log(response.data);
              _this.$message.success('删除成功');


            })
            .catch(error => {
              console.error('Error delete : ', error);
              _this.$message.error('删除失败');
            });
        })
        .catch(() => { });
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




  },
  mounted () {
    const _this = this;
    _this.initOptions();
    _this.getSalaryInfo();
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

.main {
  margin-left: 15px;

  .choise {
    margin: 1%;
  }
}

.head {
  margin: 10px auto;
}
</style>
