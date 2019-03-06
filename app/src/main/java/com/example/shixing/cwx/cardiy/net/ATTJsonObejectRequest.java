package com.example.shixing.cwx.cardiy.net;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 刘 on 2016/11/29.
 */

public class ATTJsonObejectRequest<T> extends JsonRequest<JSONObject>{
    /**
     * Params to be added to the request body in case of
     * a POST or PUT request or appended to the URL in
     * case of a GET request
     */
    private Map<String, String> mParams = null;

    /**
     * Creates a new request.
     * @param method the HTTP method to use
     * @param url URL to fetch the JSON from
     * @param jsonRequest A {@link JSONObject} to post with the request. Null is allowed and
     *   indicates no parameters will be posted along with request.
     * @param listener Listener to receive the JSON response
     * @param errorListener Error listener, or null to ignore errors.
     */
    public ATTJsonObejectRequest(int method, String url, JSONObject jsonRequest, Listener<JSONObject> listener,
                                 ErrorListener errorListener)
    {
        super(method, url, (jsonRequest == null) ? null : jsonRequest.toString(), listener, errorListener);
    }

    /**
     * Constructor which defaults to <code>GET</code> if <code>jsonRequest</code> is
     * <code>null</code>, <code>POST</code> otherwise.
     *
     */
    public ATTJsonObejectRequest(String url, JSONObject jsonRequest, Listener<JSONObject> listener,
                                 ErrorListener errorListener)
    {
        this(jsonRequest == null ? Method.GET : Method.POST, url, jsonRequest, listener, errorListener);
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response)
    {
//        try
//        {
//            String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
//            final JSONObject json = new JSONObject(jsonString);
//            final String message = json.optString("errorMsg");
//            final int responseCode = json.optInt("responseCode");
//
//            if(responseCode == 1004)
//            {
//                throw new SessionInvalidError(message);
//            }
//            if (responseCode == 1001)
//            {
//                throw new VersionUpdateError(message);
//            }
//            if(responseCode != 1000)
//            {
//                throw new CommonFailError(message, responseCode);
//            }
//            return Response.success(json, HttpHeaderParser.parseCacheHeaders(response));
//        }
//        catch (UnsupportedEncodingException e)
//        {
//            return Response.error(new ParseError(e));
//        }
//        catch (JSONException je)
//        {
//            return Response.error(new ParseError(je));
//        }
//        catch (SessionInvalidError e)
//        {
//            return Response.error(e);
//        }
//        catch (VersionUpdateError e)
//        {
//            return Response.error(e);
//        }
//        catch (CommonFailError e)
//        {
//            return Response.error(e);
//        }
        String jsonString = null;
        try {
            jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            final JSONObject json;
            json = new JSONObject(jsonString);
            return Response.success(json, HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        }
        catch (JSONException e) {
            return Response.error(new ParseError(e));
        }
    }

    /**
     * Returns a Map of parameters to be used for a POST or PUT request.  Can throw
     *
     * <p>Note that you can directly override {@link #getBody()} for custom data.</p>
     *
     */
    protected Map<String, String> getParams()
    {

        return (mParams == null) ? Collections.<String, String> emptyMap() : mParams;
    }

    /**
     * Sets the parameters to be added to the request body in case of a
     * POST or PUT request, or appended to the URL in case of GET request
     * @param params
     */
    public void setParams(Map<String, String> params)
    {
        mParams = params;
    }

    public void addParams(String key, String value)
    {
        if(mParams == null)
        {
            mParams = new HashMap<String, String>();
        }
        mParams.put(key, value);
    }

    public void addParams(Map<String, String> params)
    {
        if(mParams == null)
        {
            mParams = new HashMap<String, String>();
        }

        mParams.putAll(params);
    }
}
