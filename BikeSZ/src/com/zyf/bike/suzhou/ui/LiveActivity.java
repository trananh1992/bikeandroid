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

import java.util.List;

import com.zyf.bike.suzhou.R;
import com.zyf.bike.suzhou.adapter.LiveAdapter;
import com.zyf.bike.suzhou.bean.Station;
import com.zyf.bike.suzhou.utils.HttpOperation;
import com.zyf.bike.suzhou.utils.Logger;
import com.zyf.bike.suzhou.utils.ServiceManager;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

/**
 * 车站实况数据
 * @author Robot
 * @weibo http://weibo.com/feng88724
 * @date Apr 12, 2012	
 */
public class LiveActivity extends BaseActivity {

	private ListView mListView;
	private ProgressBar mProgress;
	private LiveAdapter mLiveAdapter;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.live);
		mListView = (ListView)findViewById(R.id.id_listView1);
		mProgress = (ProgressBar)findViewById(R.id.id_progressBar1);
		mLiveAdapter = new LiveAdapter(this);
		mListView.setAdapter(mLiveAdapter);
		
		new DataGet().execute("");
	}
	
	private class DataGet extends AsyncTask<String, Integer, List<Station>> {
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			mProgress.setVisibility(View.VISIBLE);
		}
		
		@Override
		protected List<Station> doInBackground(String... params) {
			try {
//				HttpOperation.doGetString("http://www.subicycle.com/map.asp");
//				Thread.sleep(1000);
//				return ServiceManager.getLives();
				return ServiceManager.getStations();
			} catch (Exception e) {
				Logger.e("", e.getMessage(), e);
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(List<Station> result) {
			super.onPostExecute(result);
			mProgress.setVisibility(View.GONE);
			if(result != null) {
				mLiveAdapter.setStationList(result);
				mLiveAdapter.notifyDataSetChanged();
			} else {
				Toast.makeText(LiveActivity.this, "数据下载出错!", Toast.LENGTH_SHORT).show();
			}
		}
	}
}
