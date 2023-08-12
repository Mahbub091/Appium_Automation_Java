#!/bin/bash
set -ex
npm install -g appium@next
appium driver install xcuitest
appium driver install espresso
appium driver install uiautomator2

appium -v
appium --log appium.log &>/dev/null &