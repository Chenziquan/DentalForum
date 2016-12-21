package jqchen.dentalforum.http.alipay;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;

import jqchen.dentalforum.app.MyApplication;

/**
 * Created by jqchen on 2016/12/21.
 * Use to
 */
public class OssServer {
    private static final String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
    private static final String accessKeyId = "LTAIcgVnzN0Ki8Lh";
    private static final String accessKeySecret = "T5EcVO9Ja9ldRBDwjlYMNBK7IBR2UT";
    private OSS oss;
    private static OssServer Instance;

    public static OssServer getInstance() {
        if (Instance == null) {
            Instance = new OssServer();
        }
        return Instance;
    }

    public OssServer() {
        OSSCredentialProvider credentialProvider = new OSSPlainTextAKSKCredentialProvider(accessKeyId, accessKeySecret);
        ClientConfiguration conf = new ClientConfiguration();
        conf.setConnectionTimeout(15 * 1000); // 连接超时，默认15秒
        conf.setSocketTimeout(15 * 1000); // socket超时，默认15秒
        conf.setMaxConcurrentRequest(5); // 最大并发请求书，默认5个
        conf.setMaxErrorRetry(2); // 失败后最大重试次数，默认2次
        OSSLog.enableLog();
        oss = new OSSClient(MyApplication.getInstance(), endpoint, credentialProvider, conf);
    }

    public OSS getOss() {
        return oss;
    }
}
