复制android目录下的文件至 项目包下

修改文件中的包名

在`MainApplication`中 `getPackage`中 注册包名 `new AmapBridgePackage()`

使用

```javascript
import AmapBridge from 'react-native-amap-bridge'

...

AmapBridge.navByName(startAddress,endAddress)
AmapBridge.navByMine(endLat, endLng, endAddress)   #start = 我的位置
AmapBridge.navByPosition(startLat, startLng, startAddress, endLat, endLng, endAddress)
AmapBridge.isInstallAmap()   #return Promise
```