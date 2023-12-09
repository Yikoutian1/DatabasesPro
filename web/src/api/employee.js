import request from "@/utils/request";

export function getEmployeeInfo(data) {
  return request({
    url: "/employee/getEmployeeInfo",
    method: "post",
    data,
  });
}

export function getSalaryLevel() {
  return request({
    url: "/salaryLevel/getSalaryLevel",
    method: "get",
  });
}

export function getDeptList() {
  return request({
    url: "/dept/getDeptList",
    method: "get",
  });
}