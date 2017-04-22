package com.nishubin.work.bean.resp;

import java.io.Serializable;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nishubin.work.model.DedeAddonarticle;
import com.nishubin.work.model.DedeArchives;
import com.nishubin.work.model.DedeArctype;
import com.nishubin.work.model.DedeSysconfig;

public class SysConfigs implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<DedeSysconfig> configs;
	
	List<DedeArctype> arcTypes;
	
	List<DedeAddonarticle> dedeAddonarticles;
	
	List<DedeArchives> dedeArchives;
	
	
	
	public List<DedeArctype> getArcTypes() {
		return arcTypes;
	}

	public void setArcTypes(List<DedeArctype> arcTypes) {
		this.arcTypes = arcTypes;
	}

	public List<DedeAddonarticle> getDedeAddonarticles() {
		return dedeAddonarticles;
	}

	public void setDedeAddonarticles(List<DedeAddonarticle> dedeAddonarticles) {
		this.dedeAddonarticles = dedeAddonarticles;
	}

	public List<DedeArchives> getDedeArchives() {
		return dedeArchives;
	}

	public void setDedeArchives(List<DedeArchives> dedeArchives) {
		this.dedeArchives = dedeArchives;
	}

	public List<DedeSysconfig> getConfigs() {
		return configs;
	}

	public void setConfigs(List<DedeSysconfig> configs) {
		this.configs = configs;
	}

	public String getTypeValue(String TypeName){
    	for(DedeSysconfig row :configs){
    		if(row!=null&&row.getVarname()!=null){
    			if(row.getVarname().equals(TypeName)){
    				return row.getValue();
    			}
    		}
    	}
    	return "";
    }
	public DedeSysconfig getTypeConfig(String TypeName){
    	for(DedeSysconfig row :configs){
    		if(row!=null&&row.getVarname()!=null){
    			if(row.getVarname().equals(TypeName)){
    				return row;
    			}
    		}
    	}
    	return new DedeSysconfig();
    }
	
	public List<DedeArctype> getRootArcTyes() {
		List<DedeArctype> rootArcTypes = new ArrayList<DedeArctype>();
		for (DedeArctype arcType : arcTypes) {
			if (arcType.getTopid() == 0L && "0".equals(arcType.getIshidden())) {
				rootArcTypes.add(arcType);
			}
		}
		return rootArcTypes;
	}

	public DedeArctype getArcTye(Integer id) {
		for (DedeArctype arcType : arcTypes) {
			if (arcType.getId().equals(id) && "0".equals(arcType.getIshidden())) {
				return arcType;
			}
		}
		return null;
	}
	
	public List<DedeArctype> getChildArcTyes(Integer pid) {
		List<DedeArctype> rootArcTypes = new ArrayList<DedeArctype>();
		for (DedeArctype arcType : arcTypes) {
			if (arcType.getTopid().equals(pid) && "0".equals(arcType.getIshidden())) {
				rootArcTypes.add(arcType);
			}
		}
		return rootArcTypes;
	}
	/**
	 * 根据typeId获取文章
	 * @param typeId
	 * @return
	 */
	public List<DedeArchives> queryTypeId(Integer typeId){
		List<DedeArchives> rows = new ArrayList<DedeArchives>();
		for (DedeArchives dedeArchive : dedeArchives) {
			if (dedeArchive.getTypeid().equals(typeId)) {
				rows.add(dedeArchive);
			}
		}
		return rows;
	}
	
	
	/**
	 * 根据id获取文章
	 * @param typeId
	 * @return
	 */
	public DedeArchives queryId(Integer id){
		DedeArchives row = null;
		for (DedeArchives dedeArchive : getDedeArchives()) {
			if (dedeArchive.getId().equals(id)) {
				row = dedeArchive;
				row.setBody(getAddonarticle(id).getBody());
			}
		}
		return row;
	}
	/**
	 * 根据typeId获取文章 从第几条到第几条
	 * @param typeId
	 * @return
	 */
	public List<DedeArchives> queryTypeId(Integer typeId,Integer start,Integer end){
		List<DedeArchives> rows = new ArrayList<DedeArchives>();
		int i=0;
		for ( DedeArchives dedeArchive : dedeArchives) {
			if (dedeArchive.getTypeid().equals(typeId)) {
				if(i>=start&&i<end){
					rows.add(dedeArchive);
				}
				i++;
			}
		}
		return rows;
	}
	
	/**
	 * 分页获取文章
	 * @param typeId
	 * @return
	 */
	public List<DedeArchives> queryTypeIdPage(Integer typeId,Integer page,Integer pageSize){
		Integer start = (page-1)*pageSize;
		Integer end = start+pageSize; 
		List<DedeArchives> rows = new ArrayList<DedeArchives>();
		int i=0;
		for ( DedeArchives dedeArchive : dedeArchives) {
			if (dedeArchive.getTypeid().equals(typeId)) {
				if(i>=start&&i<end){
					rows.add(dedeArchive);
				}
				i++;
			}
		}
		return rows;
	}
	
	
	public Integer complementation(Integer a,Integer b){
		return a%b;
	}
	
	public DedeAddonarticle getAddonarticle(Integer aid){
		DedeAddonarticle addonarticle = null;
		for(DedeAddonarticle row :getDedeAddonarticles()){
			if(row.getAid().equals(aid)){
				addonarticle = row;
			}
		}
		return addonarticle;
	}
	
	public String getDescription(String description){
		if(description.length()>183){
			return description.substring(0, 180)+"...";
		}else{
			return description;
		}
	}
	
	/**
	 * 根据时间秒获取指定时间格式
	 * @param date
	 * @return
	 */
	public String getFormatDate(Integer dateM,String dataType){
		Long dataL = dateM*1000L;
		Date data = new Date(dataL);
		SimpleDateFormat formatter = new SimpleDateFormat(dataType);
		return formatter.format(data);
	}

	public String getPageList(Integer typeId,Integer page,Integer pageSize,String href){
		String str = "";
		Integer totalPage = 0;
		List<DedeArchives> rows = new ArrayList<DedeArchives>();
		for ( DedeArchives dedeArchive : dedeArchives) {
			if (dedeArchive.getTypeid().equals(typeId)) {
					rows.add(dedeArchive);
			}
		}
		if(rows.size()%pageSize==0){
			totalPage = rows.size()/pageSize;
		}else{
			totalPage = rows.size()/pageSize+1;
		}
		if(totalPage>1&&page==1){
			str = "<li><a>首页</a></li> ";
		}else if(totalPage>1&&page!=1){
			str = "<li><a href='"+href+"' >首页</a>";
		}
		for(int i = 1;i<=totalPage;i++){
			if(page==i){
				str +="<li class='thisclass' ><a  >"+i+"</a></li>";
			}else{
				str +="<li ><a href='"+href+"?page="+i+"' >"+i+"</a></li>";
			}
			
		}
		
		if(totalPage>1&&totalPage==page){
			str += " <li><a>下一页</a></li><li><a >末页</a></li> ";
		}else if(totalPage>1&&totalPage!=page){
			str += "<li><a href='"+href+"?page="+(page+1)+"' >下一页</a></li><li><a href='"+href+"?page="+totalPage+"' >末页</a></li> ";
		}
		return str;
	}
}
