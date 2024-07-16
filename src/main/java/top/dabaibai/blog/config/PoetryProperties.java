package top.dabaibai.blog.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 文本格式化配置
 *
 * @author baijianmin
 */
@Data
@ConfigurationProperties("user")
public class PoetryProperties {

    private String codeFormat;

    private String subscribeFormat;

}
