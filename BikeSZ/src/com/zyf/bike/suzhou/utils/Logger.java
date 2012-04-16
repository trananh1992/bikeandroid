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

import android.util.Log;

/**
 * 日志类
 * @author Robot
 * @weibo http://weibo.com/feng88724
 * @date Apr 12, 2012
 */
public class Logger {
	
	/**
	 * 日志开关
	 * True:  显示
	 * False:  关闭
	 */
	private static boolean SHOW_FLAG = true;
		
	public static void e(String className, String msg) {
		if(!SHOW_FLAG) {
			return;
		}
		Log.e("[" + className + "]" ,  msg);
	}
	
	public static void d(String className, String msg) {
		if(!SHOW_FLAG) {
			return;
		}
		Log.d("[" + className + "]" ,  msg);
	}
	
	public static void i(String className, String msg) {
		if(!SHOW_FLAG) {
			return;
		}
		Log.i("[" + className + "]" ,  msg);
	}
	
	public static void v(String className, String msg) {
		if(!SHOW_FLAG) {
			return;
		}
		Log.v("[" + className + "]" ,  msg);
	}
	
	public static void w(String className, String msg) {
		if(!SHOW_FLAG) {
			return;
		}
		Log.w("[" + className + "]" ,  msg);
	}
	
	public static void e(String className, String msg, Throwable e) {
		if(!SHOW_FLAG) {
			return;
		}
		Log.e("[" + className + "]" ,  msg, e);
	}
	
	public static void d(String className, String msg, Throwable e) {
		if(!SHOW_FLAG) {
			return;
		}
		Log.d("[" + className + "]" ,  msg, e);
	}
	
	public static void i(String className, String msg, Throwable e) {
		if(!SHOW_FLAG) {
			return;
		}
		Log.d("[" + className + "]" ,  msg, e);
	}
	
	public static void v(String className, String msg, Throwable e) {
		if(!SHOW_FLAG) {
			return;
		}
		Log.v("[" + className + "]" ,  msg, e);
	}
	
	public static void w(String className, String msg, Throwable e) {
		if(!SHOW_FLAG) {
			return;
		}
		Log.w("[" + className + "]" ,  msg, e);
	}
}