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
package com.zyf.bike.suzhou.map;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.Drawable;

import com.baidu.mapapi.GeoPoint;
import com.baidu.mapapi.ItemizedOverlay;
import com.baidu.mapapi.OverlayItem;
import com.zyf.bike.suzhou.bean.Station;

/**
 * 自行车站点遮层(百度地图)
 * @author Robot
 * @weibo http://weibo.com/feng88724
 * @date Apr 12, 2012	
 */
public class StationOverlayBaidu extends ItemizedOverlay<OverlayItem> {
	
	private List<OverlayItem> geoList = new ArrayList<OverlayItem>();
	
	/**
	 * @param arg0
	 * @throws Exception 
	 */
	public StationOverlayBaidu(Drawable arg0, List<Station> stationList) throws Exception {
		super(arg0);
		
		if(stationList == null) {
			throw new Exception("The station list can't be null.");
		}
		GeoPoint point;
		Station station;
		OverlayItem item;
		for (int i = 0; i < stationList.size(); i++) {
			station = stationList.get(i);
			double latitude = Double.valueOf(station.getLatitude()) * 1E6;
			double longitude = Double.valueOf(station.getLongitude()) * 1E6;
			point = new GeoPoint((int)latitude, (int)longitude);
			
			item = new OverlayItem(point, station.getName(), station.getAddress());
			geoList.add(item);
		}
		
		populate();
	}

	@Override
	protected OverlayItem createItem(int index) {
		return geoList.get(index);
	}

	@Override
	public int size() {
		return geoList.size();
	}
	
	/**
	 * 点击事件
	 */
	@Override
    protected boolean onTap(int i) {
        return true;
    }

}
