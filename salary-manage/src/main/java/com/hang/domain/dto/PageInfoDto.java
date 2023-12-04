package com.hang.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName PageInfo
 * @Description 分页参数接收
 * @Author QiuLiHang
 * @DATE 2023/12/04 004 21:02
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageInfoDto {
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 分页大小
     */
    private Integer pageSize;
    /**
     * 倒序顺序
     * ASC/DESC
     */
    private String orderBy;
    /**
     * 排序字段 根据什么排
     * 例如 fid
     */
    private String sortBy;

}
