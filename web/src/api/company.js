import request from "@/utils/request";

export function getAllInfo() {
  return request({
    url: "/experience/getAllInfo",
    method: "get",
  });
}


