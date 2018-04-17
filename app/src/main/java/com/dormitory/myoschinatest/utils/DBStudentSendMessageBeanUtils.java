package com.dormitory.myoschinatest.utils;

import android.content.Context;

import com.aidebar.greendaotest.gen.DBStudentMessageDao;
import com.aidebar.greendaotest.gen.DaoManager;
import com.dormitory.myoschinatest.bean.DBStudentMessage;

import java.util.List;

/**
 * Created by jason on 2018/3/25.
 */

public class DBStudentSendMessageBeanUtils {

    private DBStudentMessageDao dbUserInvestmentDao;

    private static DBStudentSendMessageBeanUtils dbUserInvestmentUtils = null;

    public DBStudentSendMessageBeanUtils(Context context) {

        dbUserInvestmentDao = DaoManager.getInstance(context).getNewSession().getDBStudentMessageDao();
    }

    public static DBStudentSendMessageBeanUtils getInstance() {

        return dbUserInvestmentUtils;
    }

    public static void Init(Context context) {
        if (dbUserInvestmentUtils == null) {
            dbUserInvestmentUtils = new DBStudentSendMessageBeanUtils(context);
        }
    }

    /**
     * 完成对数据库中插入一条数据操作
     *
     * @param
     * @return
     */
    public void insertOneData(DBStudentMessage dbUserInvestment) {
        dbUserInvestmentDao.insertOrReplace(dbUserInvestment);
    }

    /**
     * 完成对数据库中插入多条数据操作
     *
     * @param dbUserInvestmentList
     * @return
     */
    public boolean insertManyData(List<DBStudentMessage> dbUserInvestmentList) {
        boolean flag = false;
        try {
            dbUserInvestmentDao.insertOrReplaceInTx(dbUserInvestmentList);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库中删除一条数据操作
     *
     * @param dbUserInvestment
     * @return
     */
    public boolean deleteOneData(DBStudentMessage dbUserInvestment) {
        boolean flag = false;
        try {
            dbUserInvestmentDao.delete(dbUserInvestment);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库中删除一条数据 ByKey操作
     *
     * @return
     */
    public boolean deleteOneDataByKey(long id) {
        boolean flag = false;
        try {
            dbUserInvestmentDao.deleteByKey(id);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库中批量删除数据操作
     *
     * @return
     */
    public boolean deleteManData(List<DBStudentMessage> dbUserInvestmentList) {
        boolean flag = false;
        try {
            dbUserInvestmentDao.deleteInTx(dbUserInvestmentList);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库中批量删除数据操作
     *
     * @return
     */
    public boolean deleteAllData() {
        boolean flag = false;
        try {
            dbUserInvestmentDao.deleteAll();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库更新数据操作
     *
     * @return
     */
    public boolean updateData(DBStudentMessage dbUserInvestment) {
        boolean flag = false;
        try {
            dbUserInvestmentDao.update(dbUserInvestment);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库批量更新数据操作
     *
     * @return
     */
    public boolean updateManData(List<DBStudentMessage> dbUserInvestmentList) {
        boolean flag = false;
        try {
            dbUserInvestmentDao.updateInTx(dbUserInvestmentList);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 完成对数据库查询数据操作
     *
     * @return
     */
    public DBStudentMessage queryOneData(long id) {
        return dbUserInvestmentDao.load(id);
    }

    /**
     * 完成对数据库查询所有数据操作
     *
     * @return
     */
    public List<DBStudentMessage> queryAllData() {
        return dbUserInvestmentDao.loadAll();
    }

    /**
     * 完成对数据库查询所有数据操作
     *
     * @return
     */
    public List<DBStudentMessage> queryDataDependUserName(String userName) {
        return dbUserInvestmentDao.queryBuilder().where(DBStudentMessageDao.Properties.SenderName.eq(userName)).build().list();

    }
}
