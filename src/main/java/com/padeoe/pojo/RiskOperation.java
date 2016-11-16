package com.padeoe.pojo;

/**
 * RiskOperation定义了对一条风险的任何操作，譬如风险的识别，添加，转化成问题了，被委托给某人追踪，记录了这些操作发生的时间，操作人
 * @author padeoe
 * Date: 2016/11/16
 */
public class RiskOperation {
    /**
     * 风险id，对应一个{@link Risk}对象
     */
    String riskId;

    /**
     * 该风险的追踪负责人，唯一对应了一个{@link User}对象
     */
    String username;

    /**
     * 该风险隶属的项目名称，唯一对应了一个{@link Project}对象
     */
    String projectName;

    /**
     * 对风险的操作，包括添加，识别，转化成问题，改变追踪人
     */
    String operation;

    /**
     * 对该风险操作的时间
     */
    String date;

}
