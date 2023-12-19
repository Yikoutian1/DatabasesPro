import request from "@/utils/request";


export function getAllBenefitInfo() {
  return request({
    url: "/companyBenefits/getAllInfo",
    method: "get",
  });
}

