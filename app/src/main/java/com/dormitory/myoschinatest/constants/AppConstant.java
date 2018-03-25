package com.dormitory.myoschinatest.constants;

/**
 * Created by wangjun on 3/18/17.
 */

public final class AppConstant {

    public static final class ActivityRequestCode {
        public static final int ACCOUNT_KIT_LOGIN = 101;
        public static final int REQUEST_ALBUM_IMG = 105;
        public static final int REQUEST_CAMERA_IMG = 106;
        public static final int SETTING_PERMISSION = 109;
    }

    public static final class Common {
        public static final int TEXT_CHAT_INT_TO_MAIN_ACTIVITY = 1;
        public static final int LOGOUT_TINTEN_KEY = 2;
    }


    public static final class PermissionRequestCode {
        private static final int BASE_VALUE_PERMISSION = 0X0001;
        public static final int RECORD_AUDIO = BASE_VALUE_PERMISSION + 1;
        public static final int CAMERA = BASE_VALUE_PERMISSION + 2;
        public static final int WRITE_EXTERNAL_STORAGE = BASE_VALUE_PERMISSION + 3;
        public static final int READ_CONTACTS = BASE_VALUE_PERMISSION + 4;
        public static final int READ_PHONE_STATE = BASE_VALUE_PERMISSION + 5;
        public static final int ACCESS_FINE_LOCATION = BASE_VALUE_PERMISSION + 6;
    }

    public static final class HttpResponseCode {
        public static final int SUCCESS = 200;
        public static final int INVALID_TOKEN = 3;
        public static final int NOT_ENOUGH_GEM = 7;
        public static final int ALREADY_FRIEND = 19;
        public static final int PAYMENT_REPEAT_CODE = 26;
        public static final int DISABLE_RONG_CLOUD = 40;
    }

    public static final class SharedPreferenceKey {
        public static final String CURRENT_UID = "current_uid";
        public static final String CURRENT_TOKEN = "current_token";
        public static final String CAMERA_PERMISSION_NEVER_ASK = "CAMERA_PERMISSION_NEVER_ASK";
    }

    public static final class IntentKey {

        public static final String INTENT_TO_SEND_MESSAGE_ACTIVITY_WITH_TITLE = "INTENT_TO_SEND_MESSAGE_ACTIVITY_WITH_TITLE";
        public static final String INTENT_TO_STUDENT_MESSAGE_ACTIVITY_WITH_TYPE= "INTENT_TO_STUDENT_MESSAGE_ACTIVITY_WITH_TYPE";
    }

    public static final class ReceiveMessageType {
        public static final String CHAT = "chat";
        public static final String MATCHED_USER = "matched_user";
        public static final String JSON_API_DATA = "json_api_data";
    }
}
