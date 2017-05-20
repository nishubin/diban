package com.nishubin.work.service;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nishubin.work.bean.resp.PagePlug;
import com.nishubin.work.bean.resp.RespJson;
import com.nishubin.work.dao.DedeAddonarticleMapper;
import com.nishubin.work.dao.DedeArchivesMapper;
import com.nishubin.work.model.DedeAddonarticle;
import com.nishubin.work.model.DedeArchives;
import com.nishubin.work.model.DedeArchivesExample;
@Service
public class DedeArchivesService {
	@Autowired
	private DedeArchivesMapper dedeArchivesMapper;
	@Autowired
	private DedeAddonarticleMapper dedeAddonarticleMapper;
	/**
	 * 查询文章列表
	 * @param archives
	 * @param page
	 * @param rows
	 * @return
	 */
	public PagePlug<DedeArchives> queryDedeArchives(DedeArchives archives,Integer page,Integer rows){
		PagePlug<DedeArchives> pageplug = new PagePlug<DedeArchives>();
		DedeArchivesExample example = new DedeArchivesExample();
		DedeArchivesExample.Criteria criteria = example.createCriteria();
		if(!StringUtils.isEmpty(archives.getTitle())){
			criteria.andTitleLike("%"+archives.getTitle()+"%");
		}
		if(page!=null&&page>0&&rows!=null&&rows>0){
			example.setLimit(rows);
			example.setOffset((page-1)*rows);
			pageplug.setPageSize(pageplug.getTotal()%rows==0?pageplug.getTotal()/rows:pageplug.getTotal()/rows+1);
		}
		criteria.andIsdeleteEqualTo("0");
		pageplug.setData(dedeArchivesMapper.selectByExample(example));
		pageplug.setTotal(dedeArchivesMapper.countByExample(example));
		return pageplug;
	}
	/**
	 * 修改文章
	 * @param admin
	 * @return
	 */
	public RespJson modifyArchives(DedeArchives dedeArchives){
		RespJson resp = new RespJson();
		DedeArchives row = dedeArchivesMapper.selectByPrimaryKey(dedeArchives.getId());
		if(row!=null){
			dedeArchivesMapper.updateByPrimaryKeySelective(dedeArchives);
			if(dedeArchives.getBody()!=null){
				DedeAddonarticle dedeAddonarticle = new DedeAddonarticle();
				dedeAddonarticle.setAid(row.getId());
				dedeAddonarticle.setTypeid(row.getTypeid());
				dedeAddonarticle.setBody(dedeArchives.getBody());
				dedeAddonarticleMapper.updateByPrimaryKeySelective(dedeAddonarticle);
			}
			resp.setData(dedeArchives);
		}else{
			resp.setCode("500");
			resp.setData(dedeArchives);
			resp.setMsg("找不到要修改的用户");
		}
		return resp;
	}
	/**
	 * 创建文章
	 * @param admin
	 * @return
	 */
	public RespJson createArchives(DedeArchives dedeArchives){
		RespJson resp = new RespJson();
		dedeArchives.setId(new Date().getTime());
		dedeArchives.setUrl(getUrl((long)dedeArchives.getTypeid(),dedeArchives.getId()));
		dedeArchives.setSortrank(dedeArchives.getId());
		dedeArchives.setIsdelete("0");
		dedeArchivesMapper.insert(dedeArchives);
		resp.setData(dedeArchives);
		if(dedeArchives.getBody()!=null){
			DedeAddonarticle dedeAddonarticle = new DedeAddonarticle();
			dedeAddonarticle.setAid(dedeArchives.getId());
			dedeAddonarticle.setTypeid(dedeArchives.getTypeid());
			dedeAddonarticle.setBody(dedeArchives.getBody());
			dedeAddonarticleMapper.insert(dedeAddonarticle);
		}
		return resp;
	}
	
	/**
	 * 删除文章
	 * @param archivesId
	 * @return
	 */
	public RespJson deleteArchives(Long archivesId){
		RespJson resp = new RespJson();
		DedeArchives row = dedeArchivesMapper.selectByPrimaryKey(archivesId);
		if(row!=null){
			row.setIsdelete("1");
			dedeArchivesMapper.updateByPrimaryKey(row);
		}else{
			resp.setCode("500");
			resp.setData(row);
			resp.setMsg("找不到该数据");
		}
		return resp;
	}
	/**
	 * 查询文章
	 * @param arctypeId
	 * @return
	 */
	public RespJson selectArchives(Long archivesId){
		RespJson resp = new RespJson();
		DedeArchives row = dedeArchivesMapper.selectByPrimaryKey(archivesId);
		if(row!=null){
			DedeAddonarticle dedeAddonarticle = dedeAddonarticleMapper.selectByPrimaryKey(row.getId());
			if(dedeAddonarticle!=null){
				row.setBody(dedeAddonarticle.getBody());
			}
			resp.setData(row);
		}else{
			resp.setCode("500");
			resp.setData(row);
			resp.setMsg("找不到该数据");
		}
		return resp;
	}
	private String getUrl(Long typeId,Long id){
		if(typeId.equals(6L)){
			return "/view/articleArticle/5/"+typeId+"?infoId="+id;
		}else if(typeId.equals(7L)){
			return "/view/articleArticle/5/"+typeId+"?infoId="+id;
		}else if(typeId.equals(8L)){
			return "/view/articleArticle/5/"+typeId+"?infoId="+id;
		}else if(typeId.equals(15L)){
			return "/view/articleNews/14/"+typeId+"?infoId="+id;
		}else if(typeId.equals(16L)){
			return "/view/articleNews/14/"+typeId+"?infoId="+id;
		}else if(typeId.equals(17L)){
			return "/view/articleNews/14/"+typeId+"?infoId="+id;
		}else if(typeId.equals(21L)){
			return "/view/articleArticle/21/"+typeId+"?infoId="+typeId;
		}else{
			return null;
		}
		
	}
}
