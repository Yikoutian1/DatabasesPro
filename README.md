## 本系统主要有：
系统数据初始化；
员工基本信息数据的输入、修改、删除；
企业工资的基本设定；
员工工资的浏览；
员工个人工资表的查询；
员工工资的计算；
工资报表打印。

## 数据流图如下：
员工基本状况：包括员工号、员工姓名、性别、所在部门、工资级别、工资等级等。
工资级别和工资金额：包括工资等级、工资额。
企业部门及工作岗位信息：包括部门名称、工作岗位名称、工作岗位工资等。
工龄和工资金额：包括工龄及对应工资额。
公司福利表：包括福利名称、福利值。
工资信息：包括员工号、员工姓名、员工基础工资、员工岗位工资、员工工龄工资、公司福利、员工实得工资。

## 参考建表如下(没有设置描述信息)
仅参考
```mysql
-- 创建员工基本信息表
CREATE TABLE EmployeeInfo (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    sex VARCHAR(10),
    dept VARCHAR(255),
    salary_grade VARCHAR(10)
);

-- 创建工资级别和工资金额表
CREATE TABLE SalaryLevel (
    salary_grade VARCHAR(10) PRIMARY KEY,
    salary_amount DECIMAL(10, 2)
);

-- 创建企业部门及工作岗位信息表
CREATE TABLE Department (
    dept_name VARCHAR(255) PRIMARY KEY,
    job_title VARCHAR(255),
    job_salary DECIMAL(10, 2)
);

-- 创建工龄和工资金额表
CREATE TABLE ExperienceSalary (
    experience INT PRIMARY KEY,
    salary_amount DECIMAL(10, 2)
);

-- 创建公司福利表
CREATE TABLE CompanyBenefits (
    benefit_name VARCHAR(255) PRIMARY KEY,
    benefit_value DECIMAL(10, 2)
);

-- 创建工资信息表
CREATE TABLE SalaryInfo (
    employee_id INT,
    employee_name VARCHAR(255),
    base_salary DECIMAL(10, 2),
    job_salary DECIMAL(10, 2),
    experience_salary DECIMAL(10, 2),
    company_benefits DECIMAL(10, 2),
    net_salary DECIMAL(10, 2),
    PRIMARY KEY (employee_id),
    FOREIGN KEY (employee_id) REFERENCES EmployeeInfo(id)
);
```