import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';
import codePush from "react-native-code-push";

class AwesomeProject extends Component {
  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          Welcome to React Native!
        </Text>
        <Text style={styles.instructions}>
          我是 原生项目嵌入的 ReactNative 修改
        </Text>
        <Text style={styles.instructions}>
          Press Cmd+R to reload,{'\n'}
          Cmd+D or shake for dev menu
        </Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

//注意：这个hello要和前面RN入口里面(startReactApplication方法里面的参数)的相对应
AppRegistry.registerComponent('ReactNative', () => AwesomeProject);
AppRegistry.registerComponent('ReactNative', () => codePush(App));

//更新js
//react-native bundle --platform android --entry-file index.android.js --bundle-output app/src/main/assets/index.android.bundle --dev false