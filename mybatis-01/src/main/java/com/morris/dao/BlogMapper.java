package com.morris.dao;

import com.morris.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    // 插入數據
    int addBlog(Blog blog);

    // 更新博客
    int updateBlog(Map map);

    // 查詢博客
    List<Blog> queryBlogIf(Map map);

    List<Blog> queryBlogChoose(Map map);

    // 查詢id為5、6、7博客
    List<Blog> queryBlogForeach(Map map);
}
