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

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.GeoPoint;
import com.baidu.mapapi.MapActivity;
import com.baidu.mapapi.MapController;
import com.baidu.mapapi.MapView;
import com.zyf.bike.suzhou.R;
import com.zyf.bike.suzhou.bean.Station;
import com.zyf.bike.suzhou.map.StationOverlayBaidu;
import com.zyf.bike.suzhou.utils.Const;
import com.zyf.bike.suzhou.utils.Logger;
import com.zyf.bike.suzhou.utils.ServiceManager;

/**
 * 公共自行车站点分布（百度地图）
 * @author Robot
 * @weibo http://weibo.com/feng88724
 * @date Apr 12, 2012	
 */
public class StationActivityBaidu extends MapActivity {
	private final double center_lat = 31.319;
	private final double center_lon = 120.63;
	
	BMapManager mBMapMan;
	MapView mMapView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.station_map);
		
		mBMapMan = new BMapManager(getApplication());
		mBMapMan.init(Const.APPKEY_BaiduMap, null);
		super.initMapActivity(mBMapMan);
		 
		mMapView = (MapView) findViewById(R.id.bmapsView);
		 //设置启用内置的缩放控件
		mMapView.setBuiltInZoomControls(true); 
		
        //设置在缩放动画过程中也显示overlay,默认为不绘制
        mMapView.setDrawOverlayWhenZooming(true);
        
		// 得到mMapView的控制权,可以用它控制和驱动平移和缩放
		MapController mMapController = mMapView.getController();  
        
		//用给定的经纬度构造一个GeoPoint，单位是微度 (度 * 1E6)
		GeoPoint point = new GeoPoint((int) (center_lat * 1E6), (int) (center_lon * 1E6));
		
		//设置地图中心点
		mMapController.setCenter(point);  
		
		//设置地图zoom级别
		mMapController.setZoom(12);
		
		new DataGet().execute();
	}
	
	@Override
	protected void onDestroy() {
	    if (mBMapMan != null) {
	        mBMapMan.destroy();
	        mBMapMan = null;
	    }
	    super.onDestroy();
	}
	
	@Override
	protected void onPause() {
	    if (mBMapMan != null) {
	        mBMapMan.stop();
	    }
	    super.onPause();
	}
	
	@Override
	protected void onResume() {
	    if (mBMapMan != null) {
	        mBMapMan.start();
	    }
	    super.onResume();
	}
	
	/* (non-Javadoc)
	 * @see com.baidu.mapapi.MapActivity#isRouteDisplayed()
	 */
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	
	
	private class DataGet extends AsyncTask<String, Integer, List<Station>> {
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			//mProgress.setVisibility(View.VISIBLE);
		}
		
		@Override
		protected List<Station> doInBackground(String... params) {
			try {
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
			//mProgress.setVisibility(View.GONE);
			if(result != null) {
				try {
					mMapView.getOverlays().add(new StationOverlayBaidu(getResources().getDrawable(R.drawable.marker_rounded_yellow_green), result));
					mMapView.refreshDrawableState();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				Toast.makeText(StationActivityBaidu.this, "数据下载出错!", Toast.LENGTH_SHORT).show();
			}
		}
	}
}
