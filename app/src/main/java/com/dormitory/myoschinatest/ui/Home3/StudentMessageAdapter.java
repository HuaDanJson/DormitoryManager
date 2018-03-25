package com.dormitory.myoschinatest.ui.Home3;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dormitory.myoschinatest.R;
import com.dormitory.myoschinatest.bean.DBStudentMessage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jason on 2018/2/3.
 */

public class StudentMessageAdapter extends RecyclerView.Adapter<StudentMessageAdapter.StudentMessageAdapterViewHolder> {

    private List<DBStudentMessage> studentMessageList = new ArrayList<>();
    private Activity activity;


    public StudentMessageAdapter(List<DBStudentMessage> dbTaskBeanList, Activity activity) {
        this.studentMessageList = dbTaskBeanList;
        this.activity = activity;
    }

    @Override
    public StudentMessageAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.item_student_message_fragment, parent, false);
        StudentMessageAdapterViewHolder holder = new StudentMessageAdapterViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(StudentMessageAdapterViewHolder holder, final int position) {
        SimpleDateFormat sdr1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String createdTime2 = sdr1.format(new Date(studentMessageList.get(position).getCreatTimeAsId()));
        holder.mTime.setText("消息发布时间：" + createdTime2);
        holder.mKind.setText("消息类别： " + studentMessageList.get(position).getMessageTitle());
        holder.mName.setText("消息发布者名字： " + studentMessageList.get(position).getSenderName());
        holder.mXueHao.setText("消息发布者学号： " + studentMessageList.get(position).getSenderXueHao());
        holder.mShuSheHao.setText("消息发布者宿舍号： " + studentMessageList.get(position).getSenderShuSheHao());
        holder.mBedNumber.setText("消息发布者床号： " + studentMessageList.get(position).getSenderChuangWeiHao());
        holder.mValue.setText("消息内容： " + studentMessageList.get(position).getMessageValue());
    }

    @Override
    public int getItemCount() {
        return studentMessageList.size() == 0 ? 0 : studentMessageList.size();
    }

    public void setData(List<DBStudentMessage> dbTaskBeanList) {
        this.studentMessageList = dbTaskBeanList;
        notifyDataSetChanged();
    }

    public class StudentMessageAdapterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_message_kind_item_student_message_adapter) TextView mKind;
        @BindView(R.id.tv_student_name_item_student_message_adapter) TextView mName;
        @BindView(R.id.tv_xue_hao_item_student_message_adapter) TextView mXueHao;
        @BindView(R.id.tv_shu_she_hao_item_student_message_adapter) TextView mShuSheHao;
        @BindView(R.id.tv_shu_she_item_student_message_adapter) TextView mBedNumber;
        @BindView(R.id.tv_value_item_student_message_adapter) TextView mValue;
        @BindView(R.id.tv_time_item_student_message_adapter) TextView mTime;

        public StudentMessageAdapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
