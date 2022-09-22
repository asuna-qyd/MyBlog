package com.asuna.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkVo {

    private Long id;
    private String name;
    private String logo;
    private String description;
    private String address; /** 网站地址 */
}
