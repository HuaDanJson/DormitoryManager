package com.dormitory.myoschinatest.ui.Home2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dormitory.myoschinatest.R;
import com.dormitory.myoschinatest.base.BaseFragment;
import com.dormitory.myoschinatest.bean.DBTaskManagerUserInfoBean;
import com.dormitory.myoschinatest.constants.AppConstant;
import com.dormitory.myoschinatest.db.DBNotificationBean;
import com.dormitory.myoschinatest.ui.Home3.StudentMessageActivity;
import com.dormitory.myoschinatest.utils.DBNotificationBeanUtils;
import com.dormitory.myoschinatest.utils.ToastHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.bmob.v3.BmobUser;

public class Fragment2 extends BaseFragment implements NotificationAdapter.NotificationAdapterListener {

    @BindView(R.id.rlv_notification_fragment) RecyclerView mRecyclerView;
    @BindView(R.id.tv_tips_notification_fragment) TextView mTips;
    @BindView(R.id.tv_check_student_message_fragment2) TextView mCheckStudentMessage;

    private List<DBNotificationBean> dbNotificationBeanList = new ArrayList<>();
    private NotificationAdapter notificationAdapter;
    private DBTaskManagerUserInfoBean mCurrentUser;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment2, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCurrentUser = BmobUser.getCurrentUser(DBTaskManagerUserInfoBean.class);
        initRecyclerView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment2;
    }

    public static Fragment2 instanceFragment() {
        Fragment2 fragment2 = new Fragment2();
        return fragment2;
    }

    @Override
    public void initView() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.tv_check_student_message_fragment2)
    public void onSenfMessageClicked(View view) {
        if (mCurrentUser != null && mCurrentUser.getTypeOfWorkManager() == 0) {
            Intent intent = new Intent(getActivity(), StudentMessageActivity.class);
            intent.putExtra(AppConstant.IntentKey.INTENT_TO_STUDENT_MESSAGE_ACTIVITY_WITH_TYPE, 2);
            startActivity(intent);
        } else {
            ToastHelper.showShortMessage("只有管理员才可以查看学生消息");
        }
    }

    public void initRecyclerView() {
        dbNotificationBeanList = DBNotificationBeanUtils.getInstance().queryAllData();
        if (dbNotificationBeanList.size() == 0) {
            mTips.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        } else {
            mTips.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        notificationAdapter = new NotificationAdapter(dbNotificationBeanList, getActivity());
        notificationAdapter.setNotificationAdapterListener(this);
        mRecyclerView.setAdapter(notificationAdapter);
    }

    @Override
    public void onDeleteNotificationClick(DBNotificationBean dbNotificationBean, int position) {

        for (DBNotificationBean dbTaskBean : dbNotificationBeanList) {
            if (dbTaskBean.getCreatTimeAsId() == dbNotificationBean.getCreatTimeAsId()) {
                DBNotificationBeanUtils.getInstance().deleteOneData(dbTaskBean);
                dbNotificationBeanList.remove(dbTaskBean);
                break;
            }
        }
        notificationAdapter.setData(dbNotificationBeanList);
        if (dbNotificationBeanList.size() == 0) {
            mTips.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        } else {
            mTips.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);

        }
    }
}
