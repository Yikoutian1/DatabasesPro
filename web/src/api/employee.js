import request from "@/utils/request";

export function getEmployeeInfo(data) {
  return request({
    url: "/employee/getEmployeeInfo",
    method: "post",
    data,
  });
}
