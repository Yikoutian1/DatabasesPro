import request from "@/utils/request";

export function exportExcel(data) {
  return request({
    url: "/upload/export/forEmployee",
    method: "post",
    data
  });
}


