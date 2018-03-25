package com.dormitory.myoschinatest.ui.Home3;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dormitory.myoschinatest.R;
import com.dormitory.myoschinatest.base.BaseActivity;
import com.dormitory.myoschinatest.bean.DBStudentMessage;
import com.dormitory.myoschinatest.utils.DBStudentSendMessageBeanUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class StudentMessageActivity extends BaseActivity {

    @BindView(R.id.rlv_student_message_activity) RecyclerView mRecyclerView;
    @BindView(R.id.tv_tips_student_message_activity) TextView mTips;

    private int type;
    private List<DBStudentMessage> studentMessageList = new ArrayList<>();
    private StudentMessageAdapter studentMessageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_task);
        if (type == 2) {
            getStudentMessageFromService();
        } else if (type == 3) {
            getStudentMessageFromDB();
        } else {
            mTips.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        }
    }

    public void getStudentMessageFromDB() {
        studentMessageList = DBStudentSendMessageBeanUtils.getInstance().queryAllData();
        initRecyclerView();
    }

    public void getStudentMessageFromService() {
        BmobQuery<DBStudentMessage> query = new BmobQuery<DBStudentMessage>();
        // 按时间降序查询
        query.order("-createdAt");
        query.setLimit(50);
        query.findObjects(new FindListener<DBStudentMessage>() {
            @Override
            public void done(List<DBStudentMessage> list, BmobException e) {
                if (e == null) {
                    initRecyclerView();
                } else {
                    initRecyclerView();
                }
            }
        });
    }

    public void initRecyclerView() {

        if (studentMessageList.size() == 0) {
            mTips.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        } else {
            mTips.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        if (studentMessageAdapter == null) {
            studentMessageAdapter = new StudentMessageAdapter(studentMessageList, this);
        }
        mRecyclerView.setAdapter(studentMessageAdapter);
    }


}
