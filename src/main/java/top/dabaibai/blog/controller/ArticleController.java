package top.dabaibai.blog.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import top.dabaibai.blog.config.LoginCheck;
import top.dabaibai.blog.config.PoetryResult;
import top.dabaibai.blog.service.ArticleService;
import top.dabaibai.blog.utils.CommonConst;
import top.dabaibai.blog.utils.PoetryCache;
import top.dabaibai.blog.utils.PoetryUtil;
import top.dabaibai.blog.vo.ArticleVO;
import top.dabaibai.blog.vo.BaseRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * 文章表 前端控制器
 * </p>
 *
 * @author dabaibai
 * @since 2021-08-13
 */
@Slf4j
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;


    /**
     * 保存文章
     */
    @LoginCheck(1)
    @PostMapping("/saveArticle")
    public PoetryResult saveArticle(@Validated @RequestBody ArticleVO articleVO) {
        PoetryCache.remove(CommonConst.USER_ARTICLE_LIST + PoetryUtil.getUserId().toString());
        PoetryCache.remove(CommonConst.ARTICLE_LIST);
        PoetryCache.remove(CommonConst.SORT_ARTICLE_LIST);
        return articleService.saveArticle(articleVO);
    }


    /**
     * 删除文章
     */
    @GetMapping("/deleteArticle")
    @LoginCheck(1)
    public PoetryResult deleteArticle(@RequestParam("id") Integer id) {
        PoetryCache.remove(CommonConst.USER_ARTICLE_LIST + PoetryUtil.getUserId().toString());
        PoetryCache.remove(CommonConst.ARTICLE_LIST);
        PoetryCache.remove(CommonConst.SORT_ARTICLE_LIST);
        return articleService.deleteArticle(id);
    }


    /**
     * 更新文章
     */
    @PostMapping("/updateArticle")
    @LoginCheck(1)
    public PoetryResult updateArticle(@Validated @RequestBody ArticleVO articleVO) {
        PoetryCache.remove(CommonConst.ARTICLE_LIST);
        PoetryCache.remove(CommonConst.SORT_ARTICLE_LIST);
        return articleService.updateArticle(articleVO);
    }


    /**
     * 查询文章List
     */
    @PostMapping("/listArticle")
    public PoetryResult<Page> listArticle(@RequestBody BaseRequestVO baseRequestVO) {
        return articleService.listArticle(baseRequestVO);
    }

    /**
     * 查询分类文章List
     */
    @GetMapping("/listSortArticle")
    public PoetryResult<Map<Integer, List<ArticleVO>>> listSortArticle() {
        return articleService.listSortArticle();
    }

    /**
     * 查询文章
     */
    @GetMapping("/getArticleById")
    public PoetryResult<ArticleVO> getArticleById(@RequestParam("id") Integer id, @RequestParam(value = "password", required = false) String password) {
        return articleService.getArticleById(id, password);
    }
}

