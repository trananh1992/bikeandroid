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
package com.zyf.bike.suzhou.adapter;

import java.util.ArrayList;
import java.util.List;

import com.zyf.bike.suzhou.R;
import com.zyf.bike.suzhou.bean.Station;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @author Robot
 * @weibo http://weibo.com/feng88724
 * @date Apr 12, 2012	
 */
public class LiveAdapter extends BaseAdapter {
	private List<Station> stationList;
	private Context context;
	
	public LiveAdapter(Context context) {
		stationList = new ArrayList<Station>();
		this.context = context;
	}
	
	public LiveAdapter(Context context, List<Station> stations) {
		this.context = context;
		if(stations != null) {
			this.stationList = stations;
		} else {
			this.stationList = new ArrayList<Station>();
		}
	}
	
	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		return stationList.size();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		return stationList.get(position);
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		return position;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder;
		if(convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.live_item, null);
			holder = new Holder();
			holder.tv0 = (TextView)convertView.findViewById(R.id.text0);
			holder.tv1 = (TextView)convertView.findViewById(R.id.text1);
			holder.tv2 = (TextView)convertView.findViewById(R.id.text2);
			holder.tv3 = (TextView)convertView.findViewById(R.id.text3);
			convertView.setTag(holder);
		} else {
			holder = (Holder)convertView.getTag();
		}
		Station station = stationList.get(position);
		if(station == null) return null;
//		holder.tv0.setText(station.getId());
		holder.tv0.setText(position+"");
		holder.tv1.setText(station.getName());
		String stv2 = String.format(context.getString(R.string.mess_availbike), station.getAvailBike());
		holder.tv2.setText(stv2);
		if(station.getAvailBike() != null && station.getCapacity() != null) {
			int all = Integer.parseInt(station.getCapacity());
			int avail = Integer.parseInt(station.getAvailBike());
			int rest = all - avail;
			String park = String.format(context.getString(R.string.mess_parkbike), rest);
			holder.tv3.setText(park);
		} else {
			holder.tv3.setText("");
		}
		return convertView;
	}

	class Holder {
		TextView tv1;
		TextView tv2;
		TextView tv3;
		TextView tv0;
	}

	/**
	 * @return the stationList
	 */
	public List<Station> getStationList() {
		return stationList;
	}

	/**
	 * @param stationList the stationList to set
	 */
	public void setStationList(List<Station> stationList) {
		this.stationList = stationList;
	}
	
}
