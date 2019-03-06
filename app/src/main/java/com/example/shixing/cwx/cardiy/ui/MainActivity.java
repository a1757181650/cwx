package com.example.shixing.cwx.cardiy.ui;

import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.jinglangtech.cardiy.R;
import com.jinglangtech.cardiy.net.ServerUrl;
import org.json.JSONObject;
import java.util.HashMap;
import butterknife.Bind;

public class MainActivity extends BaseActivity {

    @Bind(R.id.test)
    TextView test;

    @Override
    public void bindListener() {

    }

    @Override
    public void initData() {
        HashMap<String,String> params = new HashMap<>();
        params.put("pageSize","10");
        params.put("pageNum","1");
        getDataFromServer(Request.Method.POST, ServerUrl.GET_BANNER_LIST, params, JSONObject.class, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }
}
