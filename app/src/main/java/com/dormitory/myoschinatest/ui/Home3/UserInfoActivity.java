package com.dormitory.myoschinatest.ui.Home3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.blankj.utilcode.util.LogUtils;
import com.dormitory.myoschinatest.DBBeanUtils.DBTaskManagerUserInfoBeanUtils;
import com.dormitory.myoschinatest.R;
import com.dormitory.myoschinatest.base.BaseActivity;
import com.dormitory.myoschinatest.bean.DBTaskManagerUserInfoBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class UserInfoActivity extends BaseActivity {

    @BindView(R.id.edtUserInfoActivityName) EditText edtUserInfoActivityName;
    @BindView(R.id.edtUserInfoActivityOld) EditText edtUserInfoActivityOld;
    @BindView(R.id.edtUserInfoActivityTel) EditText edtUserInfoActivityTel;
    @BindView(R.id.edtUserInfoActivityMail) EditText edtUserInfoActivityMail;
    @BindView(R.id.edtUserInfoActivityXueHao) EditText edtUserInfoActivityXueHao;
    @BindView(R.id.edtUserInfoActivityZhaunYe) EditText edtUserInfoActivityZhaunYe;
    @BindView(R.id.edtUserInfoActivityXueYuan) EditText edtUserInfoActivityXueYuan;
    @BindView(R.id.edtUserInfoActivityShuSheNumber) EditText edtUserInfoActivityShuSheNumber;
    @BindView(R.id.edtUserInfoActivityChuangWeiNumber) EditText edtUserInfoActivityChuangWeiNumber;
    @BindView(R.id.btnRegisterActivitySubmit) Button btnRegisterActivitySubmit;
    private DBTaskManagerUserInfoBean dbUserInfoBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ButterKnife.bind(this);
        dbUserInfoBean = BmobUser.getCurrentUser(DBTaskManagerUserInfoBean.class);
        initUser();
    }

    public void initUser() {
        if (dbUserInfoBean != null) {
            edtUserInfoActivityName.setText(dbUserInfoBean.getName());
            edtUserInfoActivityOld.setText(dbUserInfoBean.getOld());
            edtUserInfoActivityTel.setText(dbUserInfoBean.getTellPhone());
            edtUserInfoActivityMail.setText(dbUserInfoBean.getMail());
            edtUserInfoActivityXueHao.setText(dbUserInfoBean.getXueHao());
            edtUserInfoActivityZhaunYe.setText(dbUserInfoBean.getZhuanYe());
            edtUserInfoActivityXueYuan.setText(dbUserInfoBean.getXueYuan());
            edtUserInfoActivityShuSheNumber.setText(dbUserInfoBean.getSusheHao());
            edtUserInfoActivityChuangWeiNumber.setText(dbUserInfoBean.getBedNumber());
        }
    }

    @OnClick({R.id.btnRegisterActivitySubmit})
    public void onSendMessageClicked(View view) {
        String name = edtUserInfoActivityName.getText().toString();
        String old = edtUserInfoActivityOld.getText().toString();
        String tellPhone = edtUserInfoActivityTel.getText().toString();
        String mail = edtUserInfoActivityMail.getText().toString();
        String xueHao = edtUserInfoActivityXueHao.getText().toString();
        String zhaunYe = edtUserInfoActivityZhaunYe.getText().toString();
        String xueYuan = edtUserInfoActivityXueYuan.getText().toString();
        String suSheHao = edtUserInfoActivityShuSheNumber.getText().toString();
        String bedNumber = edtUserInfoActivityChuangWeiNumber.getText().toString();
        if (dbUserInfoBean != null) {
            dbUserInfoBean.setName(name);
            dbUserInfoBean.setOld(old);
            dbUserInfoBean.setTellPhone(tellPhone);
            dbUserInfoBean.setMail(mail);
            dbUserInfoBean.setXueHao(xueHao);
            dbUserInfoBean.setZhuanYe(zhaunYe);
            dbUserInfoBean.setXueYuan(xueYuan);
            dbUserInfoBean.setSusheHao(suSheHao);
            dbUserInfoBean.setBedNumber(bedNumber);
            dbUserInfoBean.update(new UpdateListener() {
                @Override
                public void done(BmobException e) {
                    if (e == null) {
                        LogUtils.d("update userInfo success");
                        DBTaskManagerUserInfoBeanUtils.getInstance().updateData(dbUserInfoBean);
                        finish();
                    } else {
                        LogUtils.d("update userInfoe 11  failed e = " + e);
                    }
                }
            });
        }
    }

}


