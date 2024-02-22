package top.dabaibai.blog.im.http.service.impl;

import top.dabaibai.blog.im.http.entity.ImChatUserMessage;
import top.dabaibai.blog.im.http.dao.ImChatUserMessageMapper;
import top.dabaibai.blog.im.http.service.ImChatUserMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 单聊记录 服务实现类
 * </p>
 *
 * @author dabaibai
 * @since 2021-12-02
 */
@Service
public class ImChatUserMessageServiceImpl extends ServiceImpl<ImChatUserMessageMapper, ImChatUserMessage> implements ImChatUserMessageService {

}
