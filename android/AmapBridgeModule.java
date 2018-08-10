package com.cnsc.bdtools.map;

import android.content.Intent;
import android.util.Log;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.io.File;
import java.net.URISyntaxException;

public class AmapBridgeModule extends ReactContextBaseJavaModule {

    private String TAG = this.getClass().getSimpleName();
    private ReactApplicationContext context;


    @Override
    public String getName() {
        return "AmapBridge";
    }

    public MapModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.context = reactContext;
    }

    /**
     * 确定起终点坐标BY高德
     */
    @ReactMethod
    public void setUpGaodeAppByLoca(String startLat, String startLng, String startAddress, String endLat, String endLng, String endAddress) {
        try {
            Intent intent = Intent.getIntent("androidamap://route?sourceApplication=softname&slat=" + startLat + "&slon=" + startLng + "&sname=" + startAddress + "&dlat=" + endLat + "&dlon=" + endLng + "&dname=" + endAddress + "&dev=0&m=0&t=1");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (isInstallByread("com.autonavi.minimap")) {
                context.startActivity(intent);
                Log.e(TAG, "高德地图客户端已经安装");
            } else {
                Log.e(TAG, "没有安装高德地图客户端");
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    /**
     * 确认起终点名称BY高德
     */
    @ReactMethod
    public void setUpGaodeAppByName(String startAddress, String endAddress) {
        try {
            Intent intent = Intent.getIntent("androidamap://route?sourceApplication=softname" + "&sname=" + startAddress + "&dname=" + endAddress + "&dev=0&m=0&t=1");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (isInstallByread("com.autonavi.minimap")) {
                context.startActivity(intent);
                Log.e(TAG, "高德地图客户端已经安装");
            } else {
                Log.e(TAG, "没有安装高德地图客户端");
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    /**
     * 我的位置BY高德
     */
    @ReactMethod
    public void setUpGaodeAppByMine(String endLat, String endLng, String endAddress) {
        try {
            Intent intent = Intent.getIntent("androidamap://route?sourceApplication=softname&sname=我的位置&dlat=" + endLat + "&dlon=" + endLng + "&dname=" + endAddress + "&dev=0&m=0&t=1");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (isInstallByread("com.autonavi.minimap")) {
                context.startActivity(intent);
                Log.e(TAG, "高德地图客户端已经安装");
            } else {
                Log.e(TAG, "没有安装高德地图客户端");
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断是否安装目标应用
     *
     * @param packageName 目标应用安装后的包名
     * @return 是否已安装目标应用
     */
    private boolean isInstallByread(String packageName) {
        return new File("/data/data/" + packageName).exists();
    }

    @ReactMethod
    public void isInstallAmap(Promise promise){
        promise.resolve(isInstallByread("com.autonavi.minimap"));
    }
}
