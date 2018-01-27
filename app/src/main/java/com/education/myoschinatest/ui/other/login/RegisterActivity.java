package com.education.myoschinatest.ui.other.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.education.myoschinatest.DBBeanUtils.DBTaskManagerUserInfoBeanUtils;
import com.education.myoschinatest.R;
import com.education.myoschinatest.bean.DBTaskManagerUserInfoBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.tvRegisterActivityTitle)
    TextView tvRegisterActivityTitle;
    @BindView(R.id.edtRegisterActivityUserName)
    EditText edtRegisterActivityUserName;
    @BindView(R.id.edtRegisterActivityPassWord1)
    EditText edtRegisterActivityPassWord1;
    @BindView(R.id.edtRegisterActivityPassWord2)
    EditText edtRegisterActivityPassWord2;
    @BindView(R.id.edtRegisterActivityName)
    EditText edtRegisterActivityName;
    @BindView(R.id.edtRegisterActivityOld)
    EditText edtRegisterActivityOld;
    @BindView(R.id.edtRegisterActivityTel)
    EditText edtRegisterActivityTel;
    @BindView(R.id.edtRegisterActivityMail)
    EditText edtRegisterActivityMail;
    @BindView(R.id.btnRegisterActivitySubmit)
    Button btnRegisterActivitySubmit;
    @BindView(R.id.spinner_kind_work) Spinner spinnerKindWork;

    private int typeOfWorkManager = 0;
    private String typeOfWork = "管理员";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "5f38f08929314ed5b3f0f4992b847582");
        setContentView(R.layout.activity_regiest);
        ButterKnife.bind(this);
        btnRegisterActivitySubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRegisterClick();
            }
        });

        spinnerKindWork.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View view, int position, long id) {
                typeOfWork = adapter.getItemAtPosition(position).toString();
                typeOfWorkManager = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String typeOfWork = "管理员";
                typeOfWorkManager = 0;
            }
        });
    }

    public void setRegisterClick() {
        String userName = edtRegisterActivityUserName.getText().toString();
        String passWord1 = edtRegisterActivityPassWord1.getText().toString();
        String passWord2 = edtRegisterActivityPassWord2.getText().toString();
        String name = edtRegisterActivityName.getText().toString();
        String old = edtRegisterActivityOld.getText().toString();
        String tellPhone = edtRegisterActivityTel.getText().toString();
        String mail = edtRegisterActivityMail.getText().toString();
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord1) || TextUtils.isEmpty(passWord2) || TextUtils.isEmpty(name) || TextUtils.isEmpty(old) || TextUtils.isEmpty(tellPhone) || TextUtils.isEmpty(mail)) {
            Toast.makeText(RegisterActivity.this, "请输入完整信息后再注册", Toast.LENGTH_SHORT).show();
        } else {
            if (passWord1.equals(passWord2)) {
                final DBTaskManagerUserInfoBean dbUserInfoBean = new DBTaskManagerUserInfoBean();
                dbUserInfoBean.setCreatTimeAsId(getTime());
                dbUserInfoBean.setUsername(userName);
                dbUserInfoBean.setPassword(passWord1);
                dbUserInfoBean.setName(name);
                dbUserInfoBean.setOld(old);
                dbUserInfoBean.setTellPhone(tellPhone);
                dbUserInfoBean.setMail(mail);
                dbUserInfoBean.setTypeOfWork(typeOfWork);
                dbUserInfoBean.setTypeOfWorkManager(typeOfWorkManager);
                dbUserInfoBean.signUp(new SaveListener<DBTaskManagerUserInfoBean>() {
                    @Override
                    public void done(DBTaskManagerUserInfoBean dbTaskManagerUserInfoBean, BmobException e) {
                        if (e == null) {
                            DBTaskManagerUserInfoBeanUtils.getInstance().insertOneData(dbUserInfoBean);
                            Toast.makeText(RegisterActivity.this, "恭喜您，注册成功", Toast.LENGTH_SHORT).show();
                            RegisterActivity.this.finish();
                        } else {
                            Toast.makeText(RegisterActivity.this, "注册失败 ：" + e, Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            } else {
                Toast.makeText(RegisterActivity.this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public long getTime() {
        return System.currentTimeMillis();//获取系统时间戳
    }

}
