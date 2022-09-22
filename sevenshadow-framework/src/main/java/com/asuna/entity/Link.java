package entity;

import java.util.Date;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 友链(Link)实体类
 *
 * @author makejava
 * @since 2022-09-17 16:34:55
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Link implements Serializable {

    private Long id;     
    private String name;     
    private String logo;     
    private String description;     
    private String address; /** 网站地址 */    
    private String status; /** 审核状态 (0代表审核通过，1代表审核未通过，2代表未审核) */    
    private Long createBy;     
    private Date createTime;     
    private Long updateBy;     
    private Date updateTime;     
    private Integer delFlag; /** 删除标志（0代表未删除，1代表已删除） */    
}

