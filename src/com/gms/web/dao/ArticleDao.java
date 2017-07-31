package com.gms.web.dao;
import java.util.List;

import com.gms.web.domain.ArticleBean;

public interface ArticleDao {
	public int insert(ArticleBean article);
	public List<ArticleBean> selectAll();
	public List<ArticleBean> selectById(String id);
	public ArticleBean selectBySeq(String seq);
	public int update(ArticleBean article);
	public int delete(String seq);
	public int count();
}
