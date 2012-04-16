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
package com.zyf.bike.suzhou;

import com.zyf.bike.suzhou.ui.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

/**
 * 启动界面
 * @author Robot
 * @weibo http://weibo.com/feng88724
 * @date Apr 12, 2012
 */
public class LauncherActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher);
        
		new CountDownTimer(3000, 100) {
			
			@Override
			public void onTick(long millisUntilFinished) {
				
			}
			
			/** 倒计时结束后在这里实现activity跳转  */
			@Override
			public void onFinish() {
				 Intent intent = new Intent();
				 intent.setClass(LauncherActivity.this, MainActivity.class);
				 startActivity(intent);
				 
				 //销毁自身防止用户返回
				 finish();
			}
		}.start();
    }
}