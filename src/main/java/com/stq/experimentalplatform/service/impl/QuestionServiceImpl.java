package com.stq.experimentalplatform.service.impl;

import com.stq.experimentalplatform.entity.Question;
import com.stq.experimentalplatform.mapper.QuestionMapper;
import com.stq.experimentalplatform.service.QuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 尚天琪
 * @since 2021-05-01
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

}
