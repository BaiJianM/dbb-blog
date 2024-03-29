package top.dabaibai.blog.controller;


import top.dabaibai.blog.config.LoginCheck;
import top.dabaibai.blog.config.PoetryResult;
import top.dabaibai.blog.config.SaveCheck;
import top.dabaibai.blog.service.CommentService;
import top.dabaibai.blog.utils.CommonConst;
import top.dabaibai.blog.utils.CommonQuery;
import top.dabaibai.blog.utils.PoetryCache;
import top.dabaibai.blog.utils.StringUtil;
import top.dabaibai.blog.vo.BaseRequestVO;
import top.dabaibai.blog.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 文章评论表 前端控制器
 * </p>
 *
 * @author dabaibai
 * @since 2021-08-13
 */
@RestController
@RequestMapping("/comment")
public class CommentController {


    @Autowired
    private CommentService commentService;

    @Autowired
    private CommonQuery commonQuery;


    /**
     * 保存评论
     */
    @PostMapping("/saveComment")
    @LoginCheck
    @SaveCheck
    public PoetryResult saveComment(@Validated @RequestBody CommentVO commentVO) {
        String content = StringUtil.removeHtml(commentVO.getCommentContent());
        if (!StringUtils.hasText(content)) {
            return PoetryResult.fail("评论内容不合法！");
        }
        commentVO.setCommentContent(content);

        PoetryCache.remove(CommonConst.COMMENT_COUNT_CACHE + commentVO.getSource().toString() + "_" + commentVO.getType());
        return commentService.saveComment(commentVO);
    }


    /**
     * 删除评论
     */
    @GetMapping("/deleteComment")
    @LoginCheck
    public PoetryResult deleteComment(@RequestParam("id") Integer id) {
        return commentService.deleteComment(id);
    }


    /**
     * 查询评论数量
     */
    @GetMapping("/getCommentCount")
    public PoetryResult<Integer> getCommentCount(@RequestParam("source") Integer source, @RequestParam("type") String type) {
        return PoetryResult.success(commonQuery.getCommentCount(source, type));
    }


    /**
     * 查询评论
     */
    @PostMapping("/listComment")
    public PoetryResult<BaseRequestVO> listComment(@RequestBody BaseRequestVO baseRequestVO) {
        return commentService.listComment(baseRequestVO);
    }
}

