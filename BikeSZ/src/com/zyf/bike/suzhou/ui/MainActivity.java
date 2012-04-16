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
import com.zyf.bike.suzhou.utils.Logger;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TabHost;

/**
 * 主界面
 * @author Robot
 * @weibo http://weibo.com/feng88724
 * @date Apr 12, 2012	
 */
public class MainActivity extends TabActivity {
	private final String TAG = this.getClass().getSimpleName();
	
	private TabHost mTabHost = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mTabHost = getTabHost();
        
    	//Tab1 站点分布
        ImageView iv1 = new ImageView(this);
		iv1.setImageDrawable(getResources().getDrawable(R.drawable.tab_bg_1));
		mTabHost.addTab(mTabHost.newTabSpec("1").setIndicator(iv1).setContent(new Intent(this, StationActivityGoogle.class)));
		
		//Tab2 实况数据
        ImageView iv2 = new ImageView(this);
		iv2.setImageDrawable(getResources().getDrawable(R.drawable.tab_bg_2));
		mTabHost.addTab(mTabHost.newTabSpec("2").setIndicator(iv2).setContent(new Intent(this, LiveActivity.class)));
		
		//Tab3 便民服务
        ImageView iv3 = new ImageView(this);
		iv3.setImageDrawable(getResources().getDrawable(R.drawable.tab_bg_3));
		mTabHost.addTab(mTabHost.newTabSpec("3").setIndicator(iv3).setContent(new Intent(this, QueryActivity.class)));
		
		//Tab4 服务指南
        ImageView iv4 = new ImageView(this);
		iv4.setImageDrawable(getResources().getDrawable(R.drawable.tab_bg_4));
		mTabHost.addTab(mTabHost.newTabSpec("4").setIndicator(iv4).setContent(new Intent(this, GuideActivity.class)));
		
		//Tab5 更多
        ImageView iv5 = new ImageView(this);
		iv5.setImageDrawable(getResources().getDrawable(R.drawable.tab_bg_5));
		mTabHost.addTab(mTabHost.newTabSpec("5").setIndicator(iv5).setContent(new Intent(this, MoreActivity.class)));
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuItem mitem = menu.add(0,0,0,R.string.about_title);
		mitem.setIcon(android.R.drawable.ic_menu_info_details);
		return true;
	}
	
//	@Override
//	public boolean onMenuItemSelected(int featureId, MenuItem item) {
//		Logger.d(TAG, "onMenuItemSelected");
//		if(item.getItemId() == 0) {
//			AboutDialog.show(this);
//		}
//		return super.onMenuItemSelected(featureId, item);
//	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Logger.d(TAG, "onMenuItemSelected");
		if(item.getItemId() == 0) {
			AboutDialog.show(this);
		}
		return super.onOptionsItemSelected(item);
	}
	
	
}