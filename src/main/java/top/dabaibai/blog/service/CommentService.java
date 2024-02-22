package top.dabaibai.blog.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.dabaibai.blog.config.PoetryResult;
import top.dabaibai.blog.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import top.dabaibai.blog.vo.BaseRequestVO;
import top.dabaibai.blog.vo.CommentVO;


/**
 * <p>
 * 文章评论表 服务类
 * </p>
 *
 * @author dabaibai
 * @since 2021-08-13
 */
public interface CommentService extends IService<Comment> {

    PoetryResult saveComment(CommentVO commentVO);

    PoetryResult deleteComment(Integer id);

    PoetryResult<BaseRequestVO> listComment(BaseRequestVO baseRequestVO);

    PoetryResult<Page> listAdminComment(BaseRequestVO baseRequestVO, Boolean isBoss);
}
