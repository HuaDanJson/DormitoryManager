package com.dormitory.myoschinatest.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

import cn.bmob.v3.BmobObject;

/**
 * Created by jason on 2018/3/25.
 */

@Entity
public class DBStudentMessage extends BmobObject {

    @Id(autoincrement = false)
    public long creatTimeAsId;

    @Property(nameInDb = "DBStudentMessage")
    public String senderName;
    public String senderUid;
    public String senderXueHao;
    public String senderZhuanYe;
    public String senderXueYuan;
    public String senderShuSheHao;
    public String senderChuangWeiHao;
    public String messageValue;
    public String messageTitle;
    @Generated(hash = 1846811032)
    public DBStudentMessage(long creatTimeAsId, String senderName, String senderUid,
            String senderXueHao, String senderZhuanYe, String senderXueYuan,
            String senderShuSheHao, String senderChuangWeiHao, String messageValue,
            String messageTitle) {
        this.creatTimeAsId = creatTimeAsId;
        this.senderName = senderName;
        this.senderUid = senderUid;
        this.senderXueHao = senderXueHao;
        this.senderZhuanYe = senderZhuanYe;
        this.senderXueYuan = senderXueYuan;
        this.senderShuSheHao = senderShuSheHao;
        this.senderChuangWeiHao = senderChuangWeiHao;
        this.messageValue = messageValue;
        this.messageTitle = messageTitle;
    }
    @Generated(hash = 1454524837)
    public DBStudentMessage() {
    }
    public long getCreatTimeAsId() {
        return this.creatTimeAsId;
    }
    public void setCreatTimeAsId(long creatTimeAsId) {
        this.creatTimeAsId = creatTimeAsId;
    }
    public String getSenderName() {
        return this.senderName;
    }
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }
    public String getSenderUid() {
        return this.senderUid;
    }
    public void setSenderUid(String senderUid) {
        this.senderUid = senderUid;
    }
    public String getSenderXueHao() {
        return this.senderXueHao;
    }
    public void setSenderXueHao(String senderXueHao) {
        this.senderXueHao = senderXueHao;
    }
    public String getSenderZhuanYe() {
        return this.senderZhuanYe;
    }
    public void setSenderZhuanYe(String senderZhuanYe) {
        this.senderZhuanYe = senderZhuanYe;
    }
    public String getSenderXueYuan() {
        return this.senderXueYuan;
    }
    public void setSenderXueYuan(String senderXueYuan) {
        this.senderXueYuan = senderXueYuan;
    }
    public String getSenderShuSheHao() {
        return this.senderShuSheHao;
    }
    public void setSenderShuSheHao(String senderShuSheHao) {
        this.senderShuSheHao = senderShuSheHao;
    }
    public String getSenderChuangWeiHao() {
        return this.senderChuangWeiHao;
    }
    public void setSenderChuangWeiHao(String senderChuangWeiHao) {
        this.senderChuangWeiHao = senderChuangWeiHao;
    }
    public String getMessageValue() {
        return this.messageValue;
    }
    public void setMessageValue(String messageValue) {
        this.messageValue = messageValue;
    }
    public String getMessageTitle() {
        return this.messageTitle;
    }
    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    @Override
    public String toString() {
        return "DBStudentMessage{" +
                "creatTimeAsId=" + creatTimeAsId +
                ", senderName='" + senderName + '\'' +
                ", senderUid='" + senderUid + '\'' +
                ", senderXueHao='" + senderXueHao + '\'' +
                ", senderZhuanYe='" + senderZhuanYe + '\'' +
                ", senderXueYuan='" + senderXueYuan + '\'' +
                ", senderShuSheHao='" + senderShuSheHao + '\'' +
                ", senderChuangWeiHao='" + senderChuangWeiHao + '\'' +
                ", messageValue='" + messageValue + '\'' +
                ", messageTitle='" + messageTitle + '\'' +
                '}';
    }
}
