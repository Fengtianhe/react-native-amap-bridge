import {NativeModules} from 'react-native';


const {AmapBridge} = NativeModules;

export default {
  navByName (startAddress, endAddress) {
    AmapBridge.setUpGaodeAppByName(startAddress, endAddress)
  },
  navByMine (endLat, endLng, endAddress) {
    AmapBridge.setUpGaodeAppByMine(endLat, endLng, endAddress);
  },
  navByPosition (startLat, startLng, startAddress, endLat, endLng, endAddress) {
    AmapBridge.setUpGaodeAppByLoca(startLat, startLng, startAddress, endLat, endLng, endAddress);
  },
  /**
   * 判断是否安装高德地图
   * @returns Promise
   */
  isInstallAmap () {
    return AmapBridge.isInstallAmap()
  }
};