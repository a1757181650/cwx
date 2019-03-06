package com.example.shixing.cwx.cardiy.utils.uploadhead;

import android.util.Log;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hss on 2016/11/6.
 */

public class FileImageUploadUtils {
//    private static final int TIME_OUT = 10 * 10000000; //超时时间
//    private static final String CHARSET = "utf-8"; //设置编码
//    public static final String SUCCESS = "1";
//    public static final String FAILURE = "0";

    public static void handleUpload(File file, String RequestURL) {

        TaskThread taskThread = new TaskThread();
        taskThread.urlPath = RequestURL;
        taskThread.file = file;
        taskThread.start();
    }

    static class TaskThread extends Thread {
        // 请求路径
        private String urlPath;
        private File file;

        @Override
        public void run() {
            try {
                String isSuccess = uploadFile(file, urlPath);
            } catch (Exception e) {
                Log.d("FileImageUploadUtils","请求失败：" + e);
                e.printStackTrace();
            }
        }
    }

//    /**
//     * android上传文件到服务器
//     *
//     * @param file       需要上传的文件
//     * @param RequestURL 请求的rul
//     * @return 返回响应的内容
//     */
//    public static String uploadFile(File file, String RequestURL) {
//        String BOUNDARY = "----WebKitFormBoundaryanMj3qtAPHFy7dkj\n"; //边界标识 随机生成
//        String PREFIX = "--", LINE_END = "\r\n";
//        String CONTENT_TYPE = "multipart/form-data"; //内容类型
//        try {
//            URL url = new URL(RequestURL);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setReadTimeout(TIME_OUT);
//            conn.setConnectTimeout(TIME_OUT);
//            conn.setDoInput(true); //允许输入流
//            conn.setDoOutput(true); //允许输出流
//            conn.setUseCaches(false); //不允许使用缓存
//            conn.setRequestMethod("POST"); //请求方式
//            conn.setRequestProperty("Charset", CHARSET);
//            //设置编码
//            conn.setRequestProperty("connection", "keep-alive");
//            conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary=" + BOUNDARY);
//            if (file != null) {
//                /**
//                 * 当文件不为空，把文件包装并且上传
//                 */
//                OutputStream outputSteam = conn.getOutputStream();
//                DataOutputStream dos = new DataOutputStream(outputSteam);
//                StringBuffer sb = new StringBuffer();
////                sb.append(PREFIX);
//                sb.append(BOUNDARY);
////                sb.append(LINE_END);
//                /**
//                 * 这里重点注意：
//                 * name里面的值为服务器端需要key 只有这个key 才可以得到对应的文件
//                 * filename是文件的名字，包含后缀名的 比如:abc.png
//                 */
//                sb.append("Content-Disposition: form-data; name=\"fileupload\"; filename=\"" + file.getName() + "\"" + LINE_END);
//                sb.append("Content-Type: image/png");
//                sb.append(LINE_END);
//                dos.write(sb.toString().getBytes());
//                InputStream is = new FileInputStream(file);
//                byte[] bytes = new byte[1024];
//                int len = 0;
//                while ((len = is.read(bytes)) != -1) {
//                    dos.write(bytes, 0, len);
//                }
//                is.close();
//                dos.write(LINE_END.getBytes());
//                byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END).getBytes();
//                dos.write(end_data);
//                dos.flush();
//                /**
//                 * 获取响应码 200=成功
//                 * 当响应成功，获取响应的流
//                 */
//                int res = conn.getResponseCode();
//                Logger.d("response code:" + res);
//                if (res == 200) {
//                    return SUCCESS;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return FAILURE;
//    }

    private final static String FAILURE = "0";

    /**
     * 上传文件至Server的方法
     */
    private static String uploadFile(File file, String actionUrl) {
        String end = "\r\n";
        String twoHyphens = "--";
        String boundary = "*****";
        try {
            URL url = new URL(actionUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
          /* 允许Input、Output，不使用Cache */
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setUseCaches(false);
          /* 设置传送的method=POST */
            con.setRequestMethod("POST");
          /* setRequestProperty */
            con.setRequestProperty("Accept", "application/json");
            con.setRequestProperty("Content-Type", "multipart/form-data");
          /* 设置DataOutputStream */
            DataOutputStream ds =
                    new DataOutputStream(con.getOutputStream());
//            ds.writeChars("img_file:");

            ds.writeBytes(twoHyphens + boundary + end);
            ds.writeBytes("Content-Disposition: form-data; " +
                    "name=\"img_file\";filename=\"image.png\"" + end);
//            ds.writeBytes("Content-Disposition: form-data; " +
//                    "name=\"img_file\";filename=\"" +
//                    file.getName() + "\"" + end);
            ds.writeBytes("Content-Type: image/png");
            ds.writeBytes(end + end);
          /* 取得文件的FileInputStream */
            FileInputStream fStream = new FileInputStream(file.getPath());
          /* 设置每次写入1024bytes */
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length = -1;
          /* 从文件读取数据至缓冲区 */
            while ((length = fStream.read(buffer)) != -1) {
            /* 将资料写入DataOutputStream中 */
                ds.write(buffer, 0, length);
            }
            ds.writeBytes(end);
//            ds.writeBytes(twoHyphens + boundary + twoHyphens + end);
          /* close streams */
            fStream.close();
            ds.flush();
          /* 取得Response内容 */
            InputStream is = con.getInputStream();
            int ch;
            StringBuffer b = new StringBuffer();
            while ((ch = is.read()) != -1) {
                b.append((char) ch);
            }
          /* 关闭DataOutputStream */
            ds.close();
            return b.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FAILURE;
    }
}
