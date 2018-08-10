import {NativeModules} from 'react-native';


const {MapNavigationModule} = NativeModules;

export default {
  navByName (startAddress, endAddress) {
    MapNavigationModule.setUpGaodeAppByName(startAddress, endAddress)
  },
  navByMine (endLat, endLng, endAddress) {
    MapNavigationModule.setUpGaodeAppByMine(endLat, endLng, endAddress);
  },
  navByPosition (startLat, startLng, startAddress, endLat, endLng, endAddress) {
    MapNavigationModule.setUpGaodeAppByLoca(startLat, startLng, startAddress, endLat, endLng, endAddress);
  },
  /**
   * 判断是否安装高德地图
   * @returns Promise
   */
  isInstallAmap () {
    return MapNavigationModule.isInstallAmap()
  }
};