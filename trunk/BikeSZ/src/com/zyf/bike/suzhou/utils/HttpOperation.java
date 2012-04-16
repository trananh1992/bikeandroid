/*
 *	Copyright (c) 2012 Robot
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License"); you may
 *	not use this file except in compliance with the License. You may obtain
 *	a copy of the License at
 *		http://www.apache.org/licenses/LICENSE-2.0
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package com.zyf.bike.suzhou.utils;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpOperation {
	
	public static final String TAG = "HttpOperation";
	
    /**
     * 通过Http Get获取字符串(默认尝试三次)
     * @param url
     * @return
     */
    public static String doGetString(String url) {
    	byte[] data = doGetBase(url, 3);
    	if(data != null) {
    		String re = new String(data);
    		Logger.d("", "[Response]:" + re);
    		return re;
    	} else {
    		return null;
    	}
    }
    
    /**
     * 通过Http Get请求获取数据
     * @param url
     * @param testnum 尝试次数
     * @return
     */
    public static byte[] doGetBase(String url, int testnum) {
    	if(testnum < 0) {
    		return null;
    	}
    	try {
	        //新建HttpClient对象    
	        HttpClient httpclient = new DefaultHttpClient();  
	        //创建POST连接  
	        HttpGet get = new HttpGet(url);
            HttpResponse response = httpclient.execute(get);
            int code = response.getStatusLine().getStatusCode();
            if (code == HttpStatus.SC_OK){
            	//请求成功
            	return EntityUtils.toByteArray(response.getEntity());
            }  else if(code == HttpStatus.SC_NOT_FOUND || code == HttpStatus.SC_FORBIDDEN || code == HttpStatus.SC_METHOD_NOT_ALLOWED) {  
            	//403 禁止访问
            	//404 资源不存在
            	//405 资源被禁止
            	return null;
            }	else {
            	//超时等其他问题，重新尝试
            	doGetBase(url, testnum--);
            }
        } catch (Exception e) {
        	Logger.e(TAG, e.getMessage(), e);
        }
        return null;
    }
}
