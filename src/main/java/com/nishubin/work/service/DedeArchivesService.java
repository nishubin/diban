package com.nishubin.work.service;

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
		DedeArchives row = dedeArchivesMapper.selectByPrimaryKey((long)dedeArchives.getId());
		if(row!=null){
			dedeArchivesMapper.updateByPrimaryKeySelective(dedeArchives);
			if(dedeArchives.getBody()!=null){
				DedeAddonarticle dedeAddonarticle =dedeAddonarticleMapper.selectByPrimaryKey((long)dedeArchives.getId());
				dedeAddonarticle.setBody(dedeArchives.getBody());
				dedeAddonarticleMapper.updateByPrimaryKey(dedeAddonarticle);
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
		int id =dedeArchivesMapper.insert(dedeArchives);
		resp.setData(dedeArchives);
		if(dedeArchives.getBody()!=null){
			DedeAddonarticle dedeAddonarticle = new DedeAddonarticle();
			dedeAddonarticle.setAid(id);
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
	public RespJson deleteArchives(Integer archivesId){
		RespJson resp = new RespJson();
		dedeArchivesMapper.deleteByPrimaryKey((long)archivesId);
		return resp;
	}
	/**
	 * 查询文章
	 * @param arctypeId
	 * @return
	 */
	public RespJson selectArchives(Integer archivesId){
		RespJson resp = new RespJson();
		DedeArchives row = dedeArchivesMapper.selectByPrimaryKey((long)archivesId);
		if(row!=null){
			resp.setData(row);
		}else{
			resp.setCode("500");
			resp.setData(row);
			resp.setMsg("找不到该数据");
		}
		return resp;
	}
}
