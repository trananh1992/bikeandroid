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

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.zyf.bike.suzhou.bean.Station;

/**
 * 与服务端通信接口
 * @author Robot
 * @weibo http://weibo.com/feng88724
 * @date Apr 12, 2012	
 */
public class ServiceManager {
	
	/**
	 * 获取公共自行车站点位置信息
	 * @return
	 * @throws Exception
	 */
	public static List<Station> getStations() throws Exception {
		List<Station> staList = new ArrayList<Station>();
		String json = HttpOperation.doGetString(Const.URL_STATION_TEST);
		JSONObject object = new JSONObject(json);
		JSONArray array = object.getJSONArray("station");
		Station station;
		for (int i = 0; i < array.length(); i++) {
			object = array.getJSONObject(i);
			station = new Station(object);
			staList.add(station);
		}
		return staList;
	}
	
	/**
	 * 获取公共自行车站点的实况数据
	 * @return
	 * @throws Exception
	 */
	public static List<Station> getLives() throws Exception {
		List<Station> staList = new ArrayList<Station>();
		String json = HttpOperation.doGetString(Const.URL_STATION_LIVE);
		int index_first = json.indexOf("{");
		int index_last = json.lastIndexOf("}");
		json = json.substring(index_first, index_last);
		JSONObject object = new JSONObject(json);
		JSONArray array = object.getJSONArray("station");
		Station station;
		for (int i = 0; i < array.length(); i++) {
			object = array.getJSONObject(i);
			station = new Station(object);
			staList.add(station);
		}
		return staList;
	}
}
