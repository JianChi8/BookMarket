package cn.cslg.controller;

import cn.cslg.model.UmsMemberRuleSettings;
import cn.cslg.service.UmsMemberRuleSettingsService;

import cn.cslg.bean.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import javax.annotation.Resource;

/**
 * 会员成长规则
(UmsMemberRuleSettings)表控制层
 *
 * @author 张广洲
 * @since 2020-02-27 23:03:01
 */
@RestController
@RequestMapping("/umsMemberRuleSettings")
public class UmsMemberRuleSettingsController implements ApplicationContextAware{

    /**
     * 服务对象
     */
    @Resource
    private UmsMemberRuleSettingsService umsMemberRuleSettingsService;
    
    private ApplicationContext applicationContext;

    private static Logger logger = LoggerFactory.getLogger(UmsMemberRuleSettings.class);
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping(value = "/selectOne", method = RequestMethod.GET)
    public Response selectOne(Long id) {
        return new Response().failure("");
    }
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}