package com.stq.experimentalplatform.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 结果ID
     */
    private Integer resultId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 问题ID
     */
    private String questionId;

    /**
     * 得分
     */
    private String score;

}
