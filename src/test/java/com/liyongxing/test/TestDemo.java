package com.liyongxing.test;

import com.liyongxing.springMybatis.beans.School;
import com.liyongxing.springMybatis.mapper.SchoolMapper;
import com.liyongxing.springMybatis.service.SchoolService;
import com.liyongxing.springMybatis.service.impl.SchoolServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName:TestDemo
 * @Discroption:
 * @Author:Prey
 * @Date:2020 年 11 月 26 21:56
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core.xml"})
public class TestDemo {
    @Autowired
    SqlSessionFactory sqlSessionFactory;
    @Autowired
    SchoolService schoolService;
    SchoolMapper schoolMapper = null;
    @Before
    public void getMapper(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        schoolMapper = sqlSession.getMapper(SchoolMapper.class);
    }

    @Test
    public void queryById(){
        School school = schoolMapper.selectByPrimaryKey(1);
        System.out.println(school);
    }
}
