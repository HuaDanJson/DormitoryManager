package com.dormitory.myoschinatest.ui.Home3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dormitory.myoschinatest.R;
import com.dormitory.myoschinatest.base.BaseFragment;
import com.dormitory.myoschinatest.bean.DBTaskManagerUserInfoBean;
import com.dormitory.myoschinatest.constants.AppConstant;
import com.dormitory.myoschinatest.ui.other.login.LoginActivity;
import com.dormitory.myoschinatest.utils.ToastHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.bmob.v3.BmobUser;

public class Fragment3 extends BaseFragment {

    @BindView(R.id.tv_log_out_fragment3) TextView tvLogOutFragment3;

    Unbinder unbinder;
    @BindView(R.id.tv_check_user_send_message_fragment3) TextView tvCheckUserSendMessageFragment3;
    @BindView(R.id.tv_check_user_info_fragment3) TextView tvCheckUserInfoFragment3;
    private DBTaskManagerUserInfoBean mCurrentUser;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment3, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCurrentUser = BmobUser.getCurrentUser(DBTaskManagerUserInfoBean.class);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void initView() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment3;
    }

    public static Fragment3 instanceFragment() {
        Fragment3 fragment3 = new Fragment3();
        return fragment3;
    }

    @OnClick(R.id.tv_log_out_fragment3)
    public void onLogOutClicked(View view) {
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }

    @OnClick(R.id.tv_check_user_send_message_fragment3)
    public void onSenfMessageClicked(View view) {
        Intent intent = new Intent(getActivity(), StudentMessageActivity.class);
        intent.putExtra(AppConstant.IntentKey.INTENT_TO_STUDENT_MESSAGE_ACTIVITY_WITH_TYPE, 3);
        startActivity(intent);
    }

    @OnClick(R.id.tv_check_user_info_fragment3)
    public void onCheckUserinfoClicked(View view) {
        if (mCurrentUser != null && mCurrentUser.getTypeOfWorkManager() == 1) {
            startActivity(new Intent(getActivity(), UserInfoActivity.class));
        } else {
            ToastHelper.showShortMessage("只有学生才可以查看自己发送的消息");
        }
    }
}

