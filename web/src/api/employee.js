import request from "@/utils/request";

export function getEmployeeInfo(data) {
  return request({
    url: "/employee/getEmployeeInfo",
    method: "post",
    data,
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
    name: data
  });
}
