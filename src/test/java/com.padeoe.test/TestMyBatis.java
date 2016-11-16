package com.padeoe.test;

import com.padeoe.pojo.Risk;
import com.padeoe.service.IRiskService;
import com.padeoe.service.IUserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {
    private static Logger logger = Logger.getLogger(TestMyBatis.class);
//      private ApplicationContext ac = null;
    @Resource
    private IUserService userService = null;

    @Resource
    private IRiskService riskService = null;
//  @Before
//  public void before() {
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//      userService = (IUserService) ac.getBean("userService");
//  }

    @Test
    public void test1() {
        Risk risk = new Risk();
        risk.setInfluence(1);
        risk.setPossibility(2);
        risk.setRiskBrief("不知道是什么问题");
        risk.setThreshold("无解");

        Integer count = riskService.saveRisk(risk);
        Integer id = risk.getId();
        System.out.println(id);
        System.out.println(riskService.getRiskById(id));
        System.out.println(riskService.searchRisk(risk));
        System.out.println(riskService.updateRisk(risk));
        System.out.println(riskService.deleteRiskById(id));

    }
}
