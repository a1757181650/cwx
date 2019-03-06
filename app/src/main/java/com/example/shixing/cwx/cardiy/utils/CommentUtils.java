package com.example.shixing.cwx.cardiy.utils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hss on 2016/12/28.
 */

public class CommentUtils {
    public static final int OP_TYPE_LIKE = 1;
    public static final int OP_TYPE_COLLECTION = 2;
    public static final int OP_TYPE_SUBSCRIBE = 3;
    public static final int OP_TYPE_DOWNLOAD = 4;
    public static final int OP_TYPE_SHARE = 5;
    public static final int OP_TYPE_KNOW = 6;
    public static final int OP_TYPE_FOCUS = 7;
    public static final int OP_TYPE_WATCH = 8;
    public static final int OP_TYPE_FRIEND = 9;
    public static final int OP_TYPE_FORMULA = 10;

    public static final int OP_VALUE_CANCEL = 0;
    public static final int OP_VALUE_BUILD = 1;

    public static final int OP_OBJ_ZHENTI = 0;
    public static final int OP_OBJ_ZHUANTI = 1;
    public static final int OP_OBJ_YONGHU = 2;
    public static final int OP_OBJ_QINGDAN = 3;
    public static final int OP_OBJ_LIZHIYU = 4;
    public static final int OP_OBJ_PINGLUN = 5;

    public static JSONObject getParams(int op_id, int op_obj, int op_type, int op_value, String userguid, int user_id) {
        JSONObject params = new JSONObject();
        try {
            params.put("op_id", op_id);
            params.put("op_obj", op_obj);
            params.put("op_type", op_type);
            params.put("op_value", op_value);
            params.put("userguid", userguid);
            params.put("user_id", user_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return params;
    }

}
