package com.zkb.common.utils.http;

import com.zkb.common.enums.HttpMethod;
import com.zkb.common.enums.HttpUserAgent;
import com.zkb.common.utils.StringUtils;
import okhttp3.*;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * 通用http发送方法
 *
 * @author KingPrimes
 */
public class HttpUtils {
    public static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");
    public static final MediaType MEDIA_TYPE_JPEG = MediaType.parse("image/jpeg");
    public static final MediaType MEDIA_TYPE_GIF = MediaType.parse("image/gif");
    public static final MediaType MEDIA_TYPE_XML = MediaType.parse("application/xml");
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json");

    public static final MediaType MEDIA_TYPE_FORM_URLENCODED = MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8");
    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);
    private static OkHttpClient httpClient = new OkHttpClient();
    private static OkHttpClient CLIENT_PROXY = new OkHttpClient.Builder().proxy(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("127.0.0.1", 7890))).build();

    public static void initOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.proxy(new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("127.0.0.1", 10808)));
        httpClient = builder.build();
    }

    public static void deleteOkHttpClient() {
        httpClient = new OkHttpClient();
    }

    /**
     * 向指定网址发送http请求
     *
     * @param urlParam     url网址
     * @param requestType  请求类型 如: get、post
     * @param charsetsType 编码类型  如: utf-8、gbk
     */
    public static String sendRequest(String urlParam, HttpMethod requestType, String charsetsType, List<RequestProperty> propertyList, String userAgent) {
        HttpURLConnection connection;
        BufferedReader bufferedReader;
        StringBuilder resultBuffer;
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2,SSLv3");
        try {
            URL url = new URL(urlParam);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(String.valueOf(requestType));
            connection.setRequestProperty("User-Agent", userAgent);
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            if (propertyList != null) {
                for (RequestProperty property : propertyList) {
                    connection.setRequestProperty(property.getKey(), property.getValue());
                }
            }
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            int Code = connection.getResponseCode();
            if (Code == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                resultBuffer = new StringBuilder();
                String line;
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charsetsType));
                while ((line = bufferedReader.readLine()) != null) {
                    resultBuffer.append(line);
                }
                return resultBuffer.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 采用Java 源JDK实现
     *
     * @param url          Url地址
     * @param requestType  请求方式
     * @param charsetsType 编码类型  如: utf-8、gbk
     * @return 结果
     */
    public static String sendResponse(String url, HttpMethod requestType, String charsetsType) {
        return sendRequest(url, requestType, charsetsType, null, HttpUserAgent.USER_AGENT_EDGE_WIN10_99.getUserAgent());
    }

    /**
     * 向指定 URL 发送GET方法的请求
     *
     * @param url         发送请求的 URL
     * @param param       请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param contentType 编码类型
     * @return 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param, String contentType) {
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try {
            String urlNameString = StringUtils.isNotBlank(param) ? url + "?" + param : url;
            log.info("sendGet - {}", urlNameString);
            URL realUrl = new URL(urlNameString);
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", HttpUserAgent.USER_AGENT_EDGE_WIN10_99.getUserAgent());
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), contentType));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            //log.info("recv - {}", result);
        } catch (ConnectException e) {
            log.error("调用HttpUtils.sendGet ConnectException, url=" + url + ",param=" + param, e);
        } catch (SocketTimeoutException e) {
            log.error("调用HttpUtils.sendGet SocketTimeoutException, url=" + url + ",param=" + param, e);
        } catch (IOException e) {
            log.error("调用HttpUtils.sendGet IOException, url=" + url + ",param=" + param, e);
        } catch (Exception e) {
            log.error("调用HttpsUtil.sendGet Exception, url=" + url + ",param=" + param, e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception ex) {
                log.error("调用in.close Exception, url=" + url + ",param=" + param, ex);
            }
        }
        return result.toString();
    }

    /**
     * 向指定 URL 发送GET方法的请求
     *
     * @param url         发送请求的 URL
     * @param param       请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param contentType 编码类型
     * @return 所代表远程资源的响应结果
     */
    public static String sendGetProperty(String url, String param, String contentType, List<RequestProperty> propertyList) {
        Socket s = null;
        StringBuilder result = new StringBuilder();
        BufferedReader in = null;
        try {
            s = new Socket("localhost", 20170);
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", HttpUserAgent.USER_AGENT_EDGE_WIN10_99.getUserAgent());
            connection.setInstanceFollowRedirects(true);
            if (propertyList != null) {
                for (RequestProperty property : propertyList) {
                    connection.setRequestProperty(property.getKey(), property.getValue());
                }
            }
            connection.connect();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(), contentType));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (ConnectException e) {
            log.error("调用HttpUtils.sendGet ConnectException, url=" + url + ",param=" + param, e.getMessage());
        } catch (SocketTimeoutException e) {
            log.error("调用HttpUtils.sendGet SocketTimeoutException, url=" + url + ",param=" + param, e.getMessage());
        } catch (IOException e) {
            log.error("调用HttpUtils.sendGet IOException, url=" + url + ",param=" + param, e.getMessage());
        } catch (Exception e) {
            log.error("调用HttpsUtil.sendGet Exception, url=" + url + ",param=" + param, e.getMessage());
        } finally {
            try {
                if (in != null) {
                    s.close();
                    in.close();
                }
            } catch (Exception ex) {
                log.error("调用in.close Exception, url=" + url + ",param=" + param, ex.getMessage());
            }
        }
        return result.toString();
    }


    /**
     * 向指定 URL 发送POST方法的请求
     *
     * @param url   发送请求的 URL
     * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            log.info("sendPost - {}", url);
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("contentType", "utf-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            log.info("recv - {}", result);
        } catch (ConnectException e) {
            log.error("调用HttpUtils.sendPost ConnectException, url=" + url + ",param=" + param, e);
        } catch (SocketTimeoutException e) {
            log.error("调用HttpUtils.sendPost SocketTimeoutException, url=" + url + ",param=" + param, e);
        } catch (IOException e) {
            log.error("调用HttpUtils.sendPost IOException, url=" + url + ",param=" + param, e);
        } catch (Exception e) {
            log.error("调用HttpsUtil.sendPost Exception, url=" + url + ",param=" + param, e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                log.error("调用in.close Exception, url=" + url + ",param=" + param, ex);
            }
        }
        return result.toString();
    }

    /**
     * 发送Post请求并携带json数据
     *
     * @param url  请求地址
     * @param data json数据
     */
    public static String sendPostJson(String url, String data) {
        String response = null;
        try {
            CloseableHttpClient httpclient = null;
            CloseableHttpResponse httpresponse = null;
            try {
                httpclient = HttpClients.createDefault();
                HttpPost httppost = new HttpPost(url);
                StringEntity stringentity = new StringEntity(data,
                        ContentType.create("application/json", "UTF-8"));
                httppost.setEntity(stringentity);
                httpresponse = httpclient.execute(httppost);
                response = EntityUtils
                        .toString(httpresponse.getEntity());
            } finally {
                if (httpclient != null) {
                    httpclient.close();
                }
                if (httpresponse != null) {
                    httpresponse.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public static String sendSSLPost(String url, String param) {
        StringBuilder result = new StringBuilder();
        String urlNameString = url + "?" + param;
        try {
            log.info("sendSSLPost - {}", urlNameString);
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, new TrustManager[]{new TrustAnyTrustManager()}, new java.security.SecureRandom());
            URL console = new URL(urlNameString);
            HttpsURLConnection conn = (HttpsURLConnection) console.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", HttpUserAgent.USER_AGENT_EDGE_WIN10_99.getUserAgent());
            conn.setRequestProperty("Accept-Charset", "utf-8");
            conn.setRequestProperty("contentType", "utf-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            conn.setSSLSocketFactory(sc.getSocketFactory());
            conn.setHostnameVerifier(new TrustAnyHostnameVerifier());
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String ret = "";
            while ((ret = br.readLine()) != null) {
                if (ret != null && !"".equals(ret.trim())) {
                    result.append(new String(ret.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));
                }
            }
            log.info("recv - {}", result);
            conn.disconnect();
            br.close();
        } catch (ConnectException e) {
            log.error("调用HttpUtils.sendSSLPost ConnectException, url=" + url + ",param=" + param, e);
        } catch (SocketTimeoutException e) {
            log.error("调用HttpUtils.sendSSLPost SocketTimeoutException, url=" + url + ",param=" + param, e);
        } catch (IOException e) {
            log.error("调用HttpUtils.sendSSLPost IOException, url=" + url + ",param=" + param, e);
        } catch (Exception e) {
            log.error("调用HttpsUtil.sendSSLPost Exception, url=" + url + ",param=" + param, e);
        }
        return result.toString();
    }

    /**
     * 根据URL网址获取Image图片
     *
     * @param url 网址
     * @return 流数据 二进制
     */
    public static byte[] sendGetForFile(String url) {
        InputStream inputStream = null;
        Request req = (new Request.Builder()).url(url).addHeader("User-Agent", getUserAgent()).get().build();
        Response response;
        try {
            response = new OkHttpClient().newCall(req).execute();
            if (!response.isSuccessful()) {
                log.error("【调用HTTP请求异常】 code:{},message:{}", response.code(), response.message());
                return null;
            }
            inputStream = response.body().byteStream();
            return inputToByte(inputStream);
        } catch (IOException e) {
            log.error("发起请求出现异常:", e);
            return null;
        } finally {
            try {
                inputStream.close();
            } catch (IOException var12) {
                log.error("【关闭流异常】");
            }
        }
    }

    /**
     * 流转byte数组
     */
    private static byte[] inputToByte(InputStream inputStream) throws IOException {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int rc;
        while ((rc = inputStream.read(buff, 0, 1024)) > 0) {
            swapStream.write(buff, 0, rc);
        }
        return swapStream.toByteArray();
    }

    /**
     * 上传图片文件 提取图中的文字
     *
     * @param file       图片文件
     * @param imageName  文件名称
     * @param mediaTypet 文件后缀 .jpg/.png
     * @return JSON格式的数据
     */
    public static String sendPostFile(File file, String imageName, MediaType mediaTypet) {
        RequestBody fileBody = RequestBody.create(file, mediaTypet);
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file", imageName, fileBody)
                .build();
        Request request = new Request.Builder()
                .url("https://api.uutool.cn/photo/ocr/")
                .addHeader("User-Agent", getUserAgent())
                .post(requestBody)
                .build();
        try {
            Response response = httpClient.newCall(request).execute();
            assert response.body() != null;
            String result = response.body().string();
            response.close();
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    public static byte[] sendGetImage(String url) {
        byte[] image = null;
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = httpClient.newCall(request);
        try {
            image = Objects.requireNonNull(call.execute().body()).bytes();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

    /**
     * 发送Get请求
     *
     * @param url     请求地址
     * @param param   请求参数 key=v&key=v
     * @param headers 请求头
     * @return 返回值
     */
    public static String sendGetOkHttp(String url, String param, Headers.Builder headers) {
        try {
            Response response = httpClient.newCall(send(url, param, headers)).execute();
            String tmp = Objects.requireNonNull(response.body()).string();
            response.close();
            return tmp;
        } catch (Exception e) {
            if (e.getMessage().equals("timeout")) {
                log.error("Url:{} 请求超时", url + param);
                return "timeout";
            }
            log.error("Url:{} \n\t\t错误信息:{}", url + param, e.getMessage());
            return "";
        }

    }

    public static String sendGetOkHttpProxy(String url, String param, Headers.Builder headers) {
        try {
            Response response = CLIENT_PROXY.newCall(send(url, param, headers)).execute();
            String tmp = (response.body()).string();
            response.close();
            if (tmp == null) {
                return sendGetOkHttp(url, param, headers);
            }
            return tmp;
        } catch (Exception e) {
            if (e.getMessage().equals("timeout")) {
                return "timeout";
            }
            return "";
        }

    }

    private static Request send(String url, String param, Headers.Builder headers) {
        headers.add("User-Agent", getUserAgent());
        String urlNameString;
        if (param.length() != 0) {
            urlNameString = url + "?" + param;
        } else {
            urlNameString = url;
        }

        return new Request.Builder()
                .url(urlNameString)
                .get()
                .headers(headers.build())
                .build();
    }

    /**
     * 发送Get请求
     *
     * @param url Url地址
     * @return 返回值
     */
    public static String sendGetOkHttpProxy(String url) {
        return sendGetOkHttpProxy(url, "");
    }

    /**
     * 发送Get请求
     *
     * @param url   URL网址
     * @param param 请求参数 key=v&key=v
     * @return 返回值
     */
    public static String sendGetOkHttpProxy(String url, String param) {
        return sendGetOkHttpProxy(url, param, new Headers.Builder());
    }

    public static String sendPostOkHttpToJson(String url, String data, Headers headers) {
        try {
            Request request;
            RequestBody body = RequestBody.create(data, MEDIA_TYPE_JSON);
            if (headers != null) {
                request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .headers(headers)
                        .build();
            } else {
                request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();
            }

            Call call = httpClient.newCall(request);
            String result = Objects.requireNonNull(call.execute().body()).string();
            call.clone();
            return result;
        } catch (Exception e) {
            log.info(e.getMessage());
            return "";
        }
    }

    public static String sendPostOkHttpToFormU(String url, String data, Headers headers) {
        try {
            Request request;
            RequestBody body = RequestBody.create(data, MEDIA_TYPE_FORM_URLENCODED);
            if (headers != null) {
                request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .headers(headers)
                        .build();
            } else {
                request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .build();
            }

            Call call = httpClient.newCall(request);
            String result = Objects.requireNonNull(call.execute().body()).string();
            call.clone();
            return result;
        } catch (Exception e) {
            log.info(e.getMessage());
            return "";
        }
    }

    /**
     * 发送Get请求
     *
     * @param url Url地址
     * @return 返回值
     */
    public static String sendGetOkHttp(String url) {
        return sendGetOkHttp(url, "");
    }

    /**
     * 发送Get请求
     *
     * @param url   URL网址
     * @param param 请求参数 key=v&key=v
     * @return 返回值
     */
    public static String sendGetOkHttp(String url, String param) {
        return sendGetOkHttp(url, param, new Headers.Builder());
    }

    /**
     * 取随机User-Agent
     *
     * @return User-Agent
     */
    private static String getUserAgent() {
        Random random = new Random();
        return HttpUserAgent.values()[random.nextInt(HttpUserAgent.values().length)].getUserAgent();
    }

    private static class TrustAnyTrustManager implements X509TrustManager {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[]{};
        }
    }

    private static class TrustAnyHostnameVerifier implements HostnameVerifier {
        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }

    public static class RequestProperty {
        private String key;
        private String value;

        public RequestProperty(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }


}
