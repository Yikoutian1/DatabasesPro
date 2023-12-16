import request from "@/utils/request";

export function getEmployeeInfo(data) {
  return request({
    url: "/employee/getEmployeeInfo",
    method: "post",
    data,
  });
}

export function getEmployeeByM(data, name) {
  return request({
    url: "/employee/getEmployeeByM",
    method: "post",
    data: data,
    params: {
      name: name,
    },
  });
}

export function getDeptNameList() {
  return request({
    url: "/dept/getDeptNameList",
    method: "get",
  });
}

export function getSalaryOnlyLevel() {
  return request({
    url: "/salaryLevel/getSalaryOnlyLevel",
    method: "get",
  });
}

export function getSalaryLevel(data) {
  return request({
    url: "/salaryLevel/getSalaryLevel",
    method: "get",
    params: { name: data },
  });
}

export function updateEmployeeInfo(data) {
  return request({
    url: "/employee",
    method: "put",
    data,
  });
}

export function delEmployee(id) {
  return request({
    url: "/employee",
    method: "delete",
    params: { id: id },
  });
}

export function saveEmployeeInfo(data) {
  return request({
    url: "/employee/saveEmployeeInfo",
    method: "post",
    data
  });
}
