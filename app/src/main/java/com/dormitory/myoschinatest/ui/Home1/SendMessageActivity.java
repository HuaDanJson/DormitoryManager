package com.dormitory.myoschinatest.ui.Home1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.dormitory.myoschinatest.DBBeanUtils.DBTaskManagerUserInfoBeanUtils;
import com.dormitory.myoschinatest.R;
import com.dormitory.myoschinatest.base.BaseActivity;
import com.dormitory.myoschinatest.bean.DBStudentMessage;
import com.dormitory.myoschinatest.bean.DBTaskManagerUserInfoBean;
import com.dormitory.myoschinatest.constants.AppConstant;
import com.dormitory.myoschinatest.utils.DBStudentSendMessageBeanUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class SendMessageActivity extends BaseActivity {

    @BindView(R.id.tv_title_send_message_activity) TextView mTitle;
    @BindView(R.id.edt_message_send_message_activity) EditText mEditText;
    @BindView(R.id.ll_sure_send_message_activity) LinearLayout mSend;
    private DBTaskManagerUserInfoBean dbTaskManagerUserInfoBean;
    private List<DBTaskManagerUserInfoBean> dbTaskManagerUserInfoBeanList = new ArrayList<>();
    private String messageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message2);
        ButterKnife.bind(this);
        messageTitle = getIntent().getStringExtra(AppConstant.IntentKey.INTENT_TO_SEND_MESSAGE_ACTIVITY_WITH_TITLE);
        mTitle.setText(messageTitle);
        dbTaskManagerUserInfoBeanList = DBTaskManagerUserInfoBeanUtils.getInstance().queryAllData();
        if (dbTaskManagerUserInfoBeanList.size() > 0) {
            dbTaskManagerUserInfoBean = dbTaskManagerUserInfoBeanList.get(dbTaskManagerUserInfoBeanList.size() - 1);
        }
    }

    @OnClick({R.id.ll_sure_send_message_activity})
    public void onSendMessageClicked(View view) {
        final DBStudentMessage dbStudentMessage = new DBStudentMessage();
        dbStudentMessage.setCreatTimeAsId(System.currentTimeMillis());
        dbStudentMessage.setMessageTitle(messageTitle);
        dbStudentMessage.setMessageValue(mEditText.getText().toString());
        if (dbTaskManagerUserInfoBean != null) {
            dbStudentMessage.setSenderName(dbTaskManagerUserInfoBean.getName());
            dbStudentMessage.setSenderXueHao(dbTaskManagerUserInfoBean.getXueHao());
            dbStudentMessage.setSenderZhuanYe(dbTaskManagerUserInfoBean.getZhuanYe());
            dbStudentMessage.setSenderXueYuan(dbTaskManagerUserInfoBean.getXueYuan());
            dbStudentMessage.setSenderShuSheHao(dbTaskManagerUserInfoBean.getSusheHao());
            dbStudentMessage.setSenderChuangWeiHao(dbTaskManagerUserInfoBean.getBedNumber());
        }

        dbStudentMessage.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                if (e == null) {
                    DBStudentSendMessageBeanUtils.getInstance().insertOneData(dbStudentMessage);
                    LogUtils.d("Send message success");
                    finish();

                } else {
                    LogUtils.d("Send message 11  failed e = " + e);
                }

            }
        });
    }
}
