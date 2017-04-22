package com.nishubin.work.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author 
 */
public class DedeSysconfig implements Serializable {
    private String varname;

    private Short aid;

    private String info;

    private Short groupid;

    private String type;

    private String value;

    private static final long serialVersionUID = 1L;

    public String getVarname() {
        return varname;
    }

    public void setVarname(String varname) {
        this.varname = varname;
    }

    public Short getAid() {
        return aid;
    }

    public void setAid(Short aid) {
        this.aid = aid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Short getGroupid() {
        return groupid;
    }

    public void setGroupid(Short groupid) {
        this.groupid = groupid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
}