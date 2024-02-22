package top.dabaibai.blog.service.impl;

import top.dabaibai.blog.entity.Resource;
import top.dabaibai.blog.dao.ResourceMapper;
import top.dabaibai.blog.service.ResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 资源信息 服务实现类
 * </p>
 *
 * @author dabaibai
 * @since 2022-03-06
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

}
