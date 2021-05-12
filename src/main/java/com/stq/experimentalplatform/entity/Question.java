package com.stq.experimentalplatform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 问题的ID
     */
    @TableId(type = IdType.AUTO)
    private Integer questionId;

    /**
     * 问题的类型。选择题还是SQL题。
     */
    private String type;

    /**
     * 小标题
     */
    private String title;

    /**
     * 题目
     */
    private String subject;

    /**
     * A答案
     */
    @TableField("answerA")
    private String answera;

    /**
     * B答案
     */
    @TableField("answerB")
    private String answerb;

    /**
     * C答案
     */
    @TableField("answerC")
    private String answerc;

    /**
     * D答案
     */
    @TableField("answerD")
    private String answerd;

    /**
     * 该题的正确答案
     */
    private String rightAnswer;


    /**
     * 该题的分数
     */
    private String score;

}
