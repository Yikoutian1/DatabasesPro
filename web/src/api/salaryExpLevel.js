import request from "@/utils/request";

export function getSalaryExp (data) {
  return request({
    url: "/experience/getAllInfo",
    method: "get",
    data,
  });
}

export function getSalaryLevel (data) {
  return request({
    url: "/salaryLevel/getAllInfoLe",
    method: "get",
    data,
  });
}

export function updateSalaryInfo (data) {
  return request({
    url: "/salaryLevel/updateSalaryInfo",
    method: "post",
    data,
  });
}