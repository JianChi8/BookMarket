package cn.cslg.service.impl;

import cn.cslg.model.BmsBook;
import cn.cslg.dao.BmsBookDao;
import cn.cslg.service.BmsBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品信息(BmsBook)表服务实现类
 *
 * @author zhangguangzhou
 * @since 2020-04-15 13:44:51
 */
@Service("bmsBookService")
public class BmsBookServiceImpl implements BmsBookService {
    @Resource(name="bmsBookDao")
    private BmsBookDao bmsBookDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BmsBook queryById(Long id) {
        return this.bmsBookDao.findById(BmsBook.class, id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BmsBook> queryAllByLimit(int offset, int limit) {
        return this.bmsBookDao.findAll(BmsBook.class, offset, limit);
    }

    /**
     * 新增数据
     *
     * @param bmsBook 实例对象
     */
    @Override
    public void insert(BmsBook bmsBook) {
        this.bmsBookDao.save(bmsBook);
    }

    /**
     * 修改数据
     *
     * @param bmsBook 实例对象
     */
    @Override
    public void update(BmsBook bmsBook) {
        this.bmsBookDao.saveorupdate(bmsBook);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     */
    @Override
    public void deleteById(Long id) {
        this.bmsBookDao.deleteById(BmsBook.class, id);
    }
}