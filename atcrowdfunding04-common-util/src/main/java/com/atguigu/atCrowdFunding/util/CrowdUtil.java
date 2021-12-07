package com.atguigu.atCrowdFunding.util;

import com.atguigu.atCrowdFunding.stant.CrowdConstant;
import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * @auther konglingyang
 * @date 2021/12/5 20:19
 * 尚筹网通用工具方法
 */
public class CrowdUtil {

    /**
     * 判断请求是否为ajax请求
     * @param request  请求
     * @return 请求判断结果
     */
    public static boolean judgeRequstType(HttpServletRequest request) {
        String accept = request.getHeader("Accept");
        String xRequestHeader = request.getHeader("X-Requested-with");
        return (accept != null && accept.contains("application/json")) ||
                (xRequestHeader != null && xRequestHeader.equals("XMLHttpRequest"));
    }

    /**
     * 明文字符串进行MD5加密
     * @param source  传入明文字符串
     * @return 加密结果
     */
    public static String md5(String source) {

        // 判断字符串是否为空
        if(source == null || source.length() == 0) {
            throw new RuntimeException(CrowdConstant.MESSAGE_STRING_EXCEPTION);
        }

        // 声明转换类型
        String algorethm = "md5";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorethm);
            // 转换为字节数组
            byte[] input = source.getBytes();
            // 执行加密
            byte[] output = messageDigest.digest(input);

            // 创建BigInteger对象,并将字节数组封装
            int singNum = 1;
            BigInteger bigInteger = new BigInteger(singNum,output);

            // 按十六进制得到String字符串
            int radix = 16;
           String encode = bigInteger.toString(radix).toUpperCase();
            return encode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
