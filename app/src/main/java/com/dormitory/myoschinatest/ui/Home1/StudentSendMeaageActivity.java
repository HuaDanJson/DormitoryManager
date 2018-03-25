package com.dormitory.myoschinatest.ui.Home1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.dormitory.myoschinatest.R;
import com.dormitory.myoschinatest.base.BaseActivity;
import com.dormitory.myoschinatest.constants.AppConstant;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StudentSendMeaageActivity extends BaseActivity {

    @BindView(R.id.tv_wan_gui_student_send_message_activity) TextView tvWanGuiStudentSendMessageActivity;
    @BindView(R.id.tv_ru_zhu_deng_ji_student_send_message_activity) TextView tvRuZhuDengJiStudentSendMessageActivity;
    @BindView(R.id.tv_jia_qi_liu_su_deng_ji_student_send_message_activity) TextView tvJiaQiLiuSuDengJiStudentSendMessageActivity;
    @BindView(R.id.tv_shi_wu_deng_ji_zhao_ling_student_send_message_activity) TextView tvShiWuDengJiZhaoLingStudentSendMessageActivity;
    @BindView(R.id.tv_fang_ke_deng_ji_student_send_message_activity) TextView tvFangKeDengJiStudentSendMessageActivity;
    @BindView(R.id.tv_bao_xiu_student_send_message_activity) TextView tvBaoXiuStudentSendMessageActivity;
    @BindView(R.id.tv_su_she_bao_xiu_student_send_message_activity) TextView tvSuSheBaoXiuStudentSendMessageActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chack_task);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_wan_gui_student_send_message_activity, R.id.tv_ru_zhu_deng_ji_student_send_message_activity,
            R.id.tv_jia_qi_liu_su_deng_ji_student_send_message_activity, R.id.tv_shi_wu_deng_ji_zhao_ling_student_send_message_activity,
            R.id.tv_fang_ke_deng_ji_student_send_message_activity, R.id.tv_bao_xiu_student_send_message_activity,
            R.id.tv_su_she_bao_xiu_student_send_message_activity})
    public void onSendMessageClicked(View view) {
        Intent intent = new Intent(this, SendMessageActivity.class);
        switch (view.getId()) {
            case R.id.tv_wan_gui_student_send_message_activity:
                intent.putExtra(AppConstant.IntentKey.INTENT_TO_SEND_MESSAGE_ACTIVITY_WITH_TITLE, tvWanGuiStudentSendMessageActivity.getText().toString());
                break;

            case R.id.tv_ru_zhu_deng_ji_student_send_message_activity:
                intent.putExtra(AppConstant.IntentKey.INTENT_TO_SEND_MESSAGE_ACTIVITY_WITH_TITLE, tvRuZhuDengJiStudentSendMessageActivity.getText().toString());
                break;

            case R.id.tv_jia_qi_liu_su_deng_ji_student_send_message_activity:
                intent.putExtra(AppConstant.IntentKey.INTENT_TO_SEND_MESSAGE_ACTIVITY_WITH_TITLE, tvJiaQiLiuSuDengJiStudentSendMessageActivity.getText().toString());
                break;

            case R.id.tv_shi_wu_deng_ji_zhao_ling_student_send_message_activity:
                intent.putExtra(AppConstant.IntentKey.INTENT_TO_SEND_MESSAGE_ACTIVITY_WITH_TITLE, tvShiWuDengJiZhaoLingStudentSendMessageActivity.getText().toString());
                break;

            case R.id.tv_fang_ke_deng_ji_student_send_message_activity:
                intent.putExtra(AppConstant.IntentKey.INTENT_TO_SEND_MESSAGE_ACTIVITY_WITH_TITLE, tvFangKeDengJiStudentSendMessageActivity.getText().toString());
                break;

            case R.id.tv_bao_xiu_student_send_message_activity:
                intent.putExtra(AppConstant.IntentKey.INTENT_TO_SEND_MESSAGE_ACTIVITY_WITH_TITLE, tvBaoXiuStudentSendMessageActivity.getText().toString());
                break;

            case R.id.tv_su_she_bao_xiu_student_send_message_activity:
                intent.putExtra(AppConstant.IntentKey.INTENT_TO_SEND_MESSAGE_ACTIVITY_WITH_TITLE, tvSuSheBaoXiuStudentSendMessageActivity.getText().toString());
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
