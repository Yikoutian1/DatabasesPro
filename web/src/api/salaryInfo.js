import request from "@/utils/request";

export function getSalaryInfo (data) {
  return request({
    url: "/salaryInfo/getSalaryInfo",
    method: "get",
    data,
  });
}

export function addSalaryInfo (data) {
  return request({
    url: "/salaryInfo/insertSalaryInfo",
    method: "post",
    data,
  });
}