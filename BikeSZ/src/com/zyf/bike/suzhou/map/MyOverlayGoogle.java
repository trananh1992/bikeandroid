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

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;


/**
 * @author Robot
 * @weibo http://weibo.com/feng88724
 * @date Apr 12, 2012	
 */
public class MyOverlayGoogle extends Overlay {
	GeoPoint geoPoint = new GeoPoint((int) (31.316376 * 1E6), (int) (120.714576 * 1E6));
 
    @Override
    public void draw(Canvas canvas, MapView mapView, boolean shadow) {
    	Paint paint = new Paint();
    	Point point = mapView.getProjection().toPixels(geoPoint, null);
        canvas.drawText("★", point.x, point.y, paint);
    }
}
