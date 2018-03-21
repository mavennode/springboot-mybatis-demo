package com.demo;

import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo1ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Transactional
    public void test() {
        userMapper.insert("matrix2", "1234", "1230811");
//        int a = 1/0;
        userMapper.insert("dd", "123456", "18600000000");
        User user = userMapper.findUserByPhone("1230811");
        Assert.assertEquals("matrix2", user.getName());
    }
}
