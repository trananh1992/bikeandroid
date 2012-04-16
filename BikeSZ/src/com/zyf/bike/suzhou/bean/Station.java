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
package com.zyf.bike.suzhou.bean;

import java.io.Serializable;

import org.json.JSONObject;

import com.zyf.bike.suzhou.utils.Logger;

/**
 * @author Robot
 * @weibo http://weibo.com/feng88724
 * @date Apr 12, 2012	
 */
public class Station implements Serializable {
	
	private final String TAG_ID = "id";
	private final String TAG_NAME = "name";
	private final String TAG_LAT = "lat";
	private final String TAG_LNG = "lng";
	private final String TAG_CAPACITY = "capacity";
	private final String TAG_AVAIL = "availBike";
	private final String TAG_ADDRESS = "address";
	
	/**
	 * 站点编号
	 */
	private String id;
	
	/**
	 * 站点名
	 */
	private String name;
	
	/**
	 * 纬度
	 */
	private String latitude;
	
	/**
	 *  经度
	 */
	private String longitude;
	
	/**
	 * 该站点容量
	 */
	private String capacity;
	
	/**
	 * 当前可借车数
	 */
	private String availBike;
	
	/**
	 * 站点地址
	 */
	private String address;

	public Station() {
		
	}
	
	public Station(JSONObject object) {
		try {
			if(object.has(TAG_ID)) {
				id = object.getString(TAG_ID);
			}
			if(object.has(TAG_NAME)) {
				name = object.getString(TAG_NAME);
			}
			if(object.has(TAG_LAT)) {
				latitude = object.getString(TAG_LAT);
			}
			if(object.has(TAG_LNG)) {
				longitude = object.getString(TAG_LNG);
			}
			if(object.has(TAG_CAPACITY)) {
				capacity = object.getString(TAG_CAPACITY);
			}
			if(object.has(TAG_AVAIL)) {
				availBike = object.getString(TAG_AVAIL);
			}
			if(object.has(TAG_ADDRESS)) {
				address = object.getString(TAG_ADDRESS);
			}
		} catch (Exception e) {
			Logger.e("", e.getMessage(), e);
		}
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the capacity
	 */
	public String getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	/**
	 * @return the availBike
	 */
	public String getAvailBike() {
		return availBike;
	}

	/**
	 * @param availBike the availBike to set
	 */
	public void setAvailBike(String availBike) {
		this.availBike = availBike;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}