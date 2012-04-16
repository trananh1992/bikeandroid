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
package com.zyf.bike.suzhou.ui;

import com.zyf.bike.suzhou.R;
import com.zyf.bike.suzhou.utils.Const;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * 更多
 * @author Robot
 * @weibo http://weibo.com/feng88724
 * @date Apr 12, 2012	
 */
public class MoreActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.more);
	}
	
	public void doAbout(View view) {
		Intent intent = new Intent(this, CommonWebView.class);
		intent.putExtra("URL", Const.PATH_ABOUT);
		startActivity(intent);
	}
	
	public void doFeedback(View view) {
		Intent intent = new Intent(this, Feedback.class);
		startActivity(intent);
	}
	
	public void doCall0(View view) {
		Uri uri = Uri.parse("tel:051265892178");
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(uri);
		startActivity(intent);
	}
	
	public void doCall1(View view) {
		Uri uri = Uri.parse("tel:051265892278");
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(uri);
		startActivity(intent);
	}
	
	public void doCall2(View view) {
		Uri uri = Uri.parse("tel:4000711882");
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_CALL);
		intent.setData(uri);
		startActivity(intent);
	}
}
