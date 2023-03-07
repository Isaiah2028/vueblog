package com.luyuan.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author IsaiahLu
 * @since 2023-03-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("m_blog")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String userId;

    private String title;

    private String description;

    private String content;

    private LocalDateTime created;

    private Integer status;


}
