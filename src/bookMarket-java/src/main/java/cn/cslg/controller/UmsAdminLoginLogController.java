package cn.cslg.controller;

import cn.cslg.model.UmsAdminLoginLog;
import cn.cslg.service.UmsAdminLoginLogService;

import cn.cslg.bean.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import javax.annotation.Resource;

/**
 * 后台用户登录日志(UmsAdminLoginLog)表控制层
 *
 * @author 张广洲
 * @since 2020-02-27 23:03:01
 */
@RestController
@RequestMapping("/umsAdminLoginLog")
public class UmsAdminLoginLogController implements ApplicationContextAware{

    /**
     * 服务对象
     */
    @Resource
    private UmsAdminLoginLogService umsAdminLoginLogService;
    
    private ApplicationContext applicationContext;

    private static Logger logger = LoggerFactory.getLogger(UmsAdminLoginLog.class);
    
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