package com.stq.experimentalplatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 尚天琪
 * @since 2021-05-01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 公告ID
     */
    private String noticeId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 发布人
     */
    private Integer userId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
