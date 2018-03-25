package com.dormitory.myoschinatest.ui.Home3;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.dormitory.myoschinatest.R;
import com.dormitory.myoschinatest.base.BaseActivity;
import com.dormitory.myoschinatest.bean.DBTaskBean;
import com.dormitory.myoschinatest.db.DBNotificationBean;
import com.dormitory.myoschinatest.notification.NotificationBean;
import com.dormitory.myoschinatest.ui.WelcomeActivity;
import com.dormitory.myoschinatest.utils.DBNotificationBeanUtils;
import com.dormitory.myoschinatest.utils.DBTaskBeanUtils;
import com.dormitory.myoschinatest.utils.ToastHelper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobPushManager;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.PushListener;

public class SendMessageManagerActivity extends BaseActivity {

    @BindView(R.id.edt_send_message_activity) EditText edtSendMessage;
    @BindView(R.id.ll_send_message_activity) LinearLayout llSendMessage;

    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @OnClick({R.id.ll_send_message_activity})
    public void onSendMessageClicked(View view) {
        message = edtSendMessage.getText().toString().trim();
        if (TextUtils.isEmpty(message)) {
            ToastHelper.showShortMessage("请输入公告内容后再点击发送公告");
        } else {
            BmobPushManager bmobPushManager = new BmobPushManager();
            bmobPushManager.pushMessageAll("新的公告：" + message, new PushListener() {
                @Override
                public void done(BmobException e) {
                    if (e == null) {
                        Log.i("bmob", "Client 推送成功！");
                        ToastHelper.showShortMessage("公告发布成功");
                        finish();
                    } else {
                        Log.i("bmob", "Client 异常：" + e.getMessage());
                        ToastHelper.showShortMessage("公告发布失败 原因：" + e.getMessage());
                    }
                }
            });

        }

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getEventData(NotificationBean notificationBean) {
//      定义一个PendingIntent,点击Intent可以启动一个新的Intent
        Log.i("bmob", "getEventData ：" + notificationBean.getAlert());
        Intent intent = new Intent(SendMessageManagerActivity.this, WelcomeActivity.class);
        PendingIntent pit = PendingIntent.getActivity(SendMessageManagerActivity.this, 0, intent, 0);
//                设置图片文字提示方式等等
        Notification.Builder builder = new Notification.Builder(SendMessageManagerActivity.this);
        builder.setContentTitle("您有 宿舍系统 新的消息")                        //标题
                .setContentText(notificationBean.getAlert())      //内容
                .setSubText(notificationBean.getAlert())                    //内容下面的一小段文字
                .setTicker(notificationBean.getAlert())             //收到信息后状态栏显示的文字信息
                .setWhen(System.currentTimeMillis())           //设置通知时间
                .setSmallIcon(R.drawable.icon_logo)            //设置小图标
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.icon_logo))
                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE)    //设置默认的三色灯与振动器
                .setAutoCancel(true)                           //设置点击后取消Notification
                .setContentIntent(pit);
        Notification notification = builder.build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
        getMediaData();
        DBNotificationBean dbNotificationBean = new DBNotificationBean(System.currentTimeMillis(), notificationBean.getAlert());
        DBNotificationBeanUtils.getInstance().insertOneData(dbNotificationBean);
    }

    public void getMediaData() {
        BmobQuery<DBTaskBean> query = new BmobQuery<DBTaskBean>();
        // 按时间降序查询
        query.order("-createdAt");
        query.setLimit(50);
        query.findObjects(new FindListener<DBTaskBean>() {
            @Override
            public void done(List<DBTaskBean> list, BmobException e) {
                if (e == null) {
                    if (list.size() > 0) {
                        boolean flag = DBTaskBeanUtils.getInstance().deleteAllData();
                        if (flag) {
                            DBTaskBeanUtils.getInstance().insertManyData(list);
                        }
                    }
                }
            }
        });
    }

}
