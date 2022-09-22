package entity;

import java.util.Date;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 标签(Tag)实体类
 *
 * @author makejava
 * @since 2022-09-22 22:48:20
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tag implements Serializable {

    private Long id;     
    private String name; /** 标签名 */    
    private Long createBy;     
    private Date createTime;     
    private Long updateBy;     
    private Date updateTime;     
    private Integer delFlag; /** 删除标志（0代表未删除，1代表已删除） */    
    private String remark; /** 备注 */    
}

