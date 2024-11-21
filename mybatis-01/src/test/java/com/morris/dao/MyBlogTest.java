package com.morris.dao;

import com.morris.pojo.Blog;
import com.morris.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyBlogTest {

    @Test
    public void addBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

            Blog blog = new Blog();
            blog.setId(IdUtils.getId());
            blog.setTitle("哈利波特");
            blog.setAuthor("J.K.羅琳");
            blog.setCreateTime(new Date());
            blog.setPrice(480);
            blogMapper.addBlog(blog);

            blog.setId(IdUtils.getId());
            blog.setTitle("張忠謀自傳全集");
            blog.setAuthor("張忠謀");
            blog.setCreateTime(new Date());
            blog.setPrice(850);
            blogMapper.addBlog(blog);

            blog.setId(IdUtils.getId());
            blog.setTitle("深刻認識一個人");
            blog.setAuthor("大衛．布魯克斯");
            blog.setCreateTime(new Date());
            blog.setPrice(355);
            blogMapper.addBlog(blog);

            blog.setId(IdUtils.getId());
            blog.setTitle("哈利波特(7)死神的聖物");
            blog.setAuthor("J.K.羅琳");
            blog.setCreateTime(new Date());
            blog.setPrice(999);
            blogMapper.addBlog(blog);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryBlogIf() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

            HashMap map = new HashMap();
            map.put("title", "哈利波特");
            map.put("author", "J.K.羅琳");

            List<Blog> blogs = blogMapper.queryBlogIf(map);

            for(Blog blog : blogs) {
                System.out.println(blog);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryBlogChoose() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

            HashMap map = new HashMap();
            map.put("title", "哈利波特(7)死神的聖物");
//            map.put("author", "J.K.羅琳");
            map.put("price", 999);

            List<Blog> blogs = blogMapper.queryBlogChoose(map);

            for(Blog blog : blogs) {
                System.out.println(blog);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateBlog() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        try {
            BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);

            HashMap map = new HashMap();
            map.put("id", "6fc5667bdf8c4b12b14a75e24feeb014");
            map.put("title", "深刻認識一個人2");
//            map.put("author", "大衛．布魯克斯");
            map.put("price", 999);

            blogMapper.updateBlog(map);

            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
