package com.padeoe.test;

import com.padeoe.pojo.Project;
import com.padeoe.pojo.Risk;
import com.padeoe.pojo.User;
import com.padeoe.service.IProjectService;
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

    @Resource
    private IProjectService projectService = null;
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
//        System.out.println(id);
//        System.out.println(riskService.getRiskById(id));
//        System.out.println(riskService.searchRisk(risk));
        risk=riskService.getRiskById(count);
        System.out.println(risk);
        risk.setPossibility(3);
        riskService.updateRisk(risk);
        System.out.println(risk);
  //      riskService.deleteRiskById(id);
    }

//    @Test
    public void test2() {
        User user = new User();
        user.setUsername("wht");
        user.setPassword("fucn");
        user.setAuthority(1);
        userService.saveUser(user);
        System.out.println(userService.getUserByCondition(user).size());
    }
    @Test
    public void test3(){
        Project project = new Project();
        project.setName("64646");
        project.setDescription("建一个超四流的系统");
        projectService.saveProject(project);
        projectService.getProjectByName("64646");
        projectService.deleteProject("64646");
    }
}
