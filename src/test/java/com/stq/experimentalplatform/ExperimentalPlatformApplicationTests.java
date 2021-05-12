package com.stq.experimentalplatform;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stq.experimentalplatform.entity.Notice;
import com.stq.experimentalplatform.mapper.NoticeMapper;
import com.stq.experimentalplatform.mapper.SQLMapper;
import com.stq.experimentalplatform.mapper.UserMapper;
import com.stq.experimentalplatform.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class ExperimentalPlatformApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NoticeMapper noticeMapper;

    @Autowired
    private SQLMapper sqlMapper;

    @Test
    void contextLoads() {
        IPage<Notice> noticePage = new Page<>(2, 2);
        IPage<Notice> page = noticeMapper.selectPage(noticePage, null);
        List<Notice> list = noticePage.getRecords();
        for (Notice notice : list) {
            System.out.println(notice);
        }
    }

    @Test
    void getDatabases() {
        List<Map<String, Object>> list = sqlMapper.executeSQL("SELECT * FROM `sql_platform`.`notice` LIMIT 0,1000");

        for (Map<String, Object> m : list) {
            for (String k : m.keySet()) {
                System.out.println(k + " : " + m.get(k));
            }
        }

    }

}
