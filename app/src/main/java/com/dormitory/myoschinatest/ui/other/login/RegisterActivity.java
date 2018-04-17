package com.dormitory.myoschinatest.ui.other.login;

import android.os.Bundle;
import android.widget.Button;

import com.dormitory.myoschinatest.R;
import com.dormitory.myoschinatest.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.btnRegisterStudentActivitySubmit) Button btnRegisterStudentActivitySubmit;
    @BindView(R.id.btnRegisterManagerActivitySubmit) Button btnRegisterManagerActivitySubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "07348efa40f2184aaf6c11bb75aeab97");
        setContentView(R.layout.activity_regiest);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnRegisterStudentActivitySubmit)
    public void registStudentClicked() {
        toActivity(StudentrRegisterActivity.class);
        finish();
    }

    @OnClick(R.id.btnRegisterManagerActivitySubmit)
    public void registManagerClicked() {
        toActivity(ManagerRegisterActivity.class);
        finish();
    }

}
