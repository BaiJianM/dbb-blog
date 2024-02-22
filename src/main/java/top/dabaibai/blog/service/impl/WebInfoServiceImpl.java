package top.dabaibai.blog.service.impl;

import top.dabaibai.blog.entity.WebInfo;
import top.dabaibai.blog.dao.WebInfoMapper;
import top.dabaibai.blog.service.WebInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 网站信息表 服务实现类
 * </p>
 *
 * @author dabaibai
 * @since 2021-09-14
 */
@Service
public class WebInfoServiceImpl extends ServiceImpl<WebInfoMapper, WebInfo> implements WebInfoService {

}
