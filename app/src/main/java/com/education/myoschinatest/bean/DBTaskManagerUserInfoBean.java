package com.education.myoschinatest.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import cn.bmob.v3.BmobUser;

/**
 * Created by jason on 2018/1/19.
 */
@Entity
public class DBTaskManagerUserInfoBean extends BmobUser {

    @Id(autoincrement = false)
    public long creatTimeAsId;//录入的具体数据的时间作为ID
    @Property(nameInDb = "DBTaskManagerUserInfoBean")
    public String name;
    public String old;
    public String tellPhone;
    public String mail;
    public String xueHao;
    public String zhuanYe;
    public String xueYuan;
    public String susheHao;
    public String bedNumber;
    public String typeOfWork;
    public int typeOfWorkManager;
    @Generated(hash = 1211586222)
    public DBTaskManagerUserInfoBean(long creatTimeAsId, String name, String old,
            String tellPhone, String mail, String xueHao, String zhuanYe,
            String xueYuan, String susheHao, String bedNumber, String typeOfWork,
            int typeOfWorkManager) {
        this.creatTimeAsId = creatTimeAsId;
        this.name = name;
        this.old = old;
        this.tellPhone = tellPhone;
        this.mail = mail;
        this.xueHao = xueHao;
        this.zhuanYe = zhuanYe;
        this.xueYuan = xueYuan;
        this.susheHao = susheHao;
        this.bedNumber = bedNumber;
        this.typeOfWork = typeOfWork;
        this.typeOfWorkManager = typeOfWorkManager;
    }
    @Generated(hash = 173426095)
    public DBTaskManagerUserInfoBean() {
    }
    public long getCreatTimeAsId() {
        return this.creatTimeAsId;
    }
    public void setCreatTimeAsId(long creatTimeAsId) {
        this.creatTimeAsId = creatTimeAsId;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOld() {
        return this.old;
    }
    public void setOld(String old) {
        this.old = old;
    }
    public String getTellPhone() {
        return this.tellPhone;
    }
    public void setTellPhone(String tellPhone) {
        this.tellPhone = tellPhone;
    }
    public String getMail() {
        return this.mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getXueHao() {
        return this.xueHao;
    }
    public void setXueHao(String xueHao) {
        this.xueHao = xueHao;
    }
    public String getZhuanYe() {
        return this.zhuanYe;
    }
    public void setZhuanYe(String zhuanYe) {
        this.zhuanYe = zhuanYe;
    }
    public String getXueYuan() {
        return this.xueYuan;
    }
    public void setXueYuan(String xueYuan) {
        this.xueYuan = xueYuan;
    }
    public String getSusheHao() {
        return this.susheHao;
    }
    public void setSusheHao(String susheHao) {
        this.susheHao = susheHao;
    }
    public String getBedNumber() {
        return this.bedNumber;
    }
    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }
    public String getTypeOfWork() {
        return this.typeOfWork;
    }
    public void setTypeOfWork(String typeOfWork) {
        this.typeOfWork = typeOfWork;
    }
    public int getTypeOfWorkManager() {
        return this.typeOfWorkManager;
    }
    public void setTypeOfWorkManager(int typeOfWorkManager) {
        this.typeOfWorkManager = typeOfWorkManager;
    }



}
