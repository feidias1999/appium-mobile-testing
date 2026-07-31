# Appium Mobile Automation Project

This repository contains a Java + TestNG + Appium project aligned with the course lectures for mobile automation.

## What is included
- Basic Appium interactions
- Gestures such as scroll, swipe, long press, and drag-and-drop
- E-commerce app automation with General Store
- Hybrid app/browser automation
- Mobile browser automation with Chrome

## Prerequisites
- Java 17+
- Android Studio with an emulator or a physical Android device
- Appium Server
- Node.js

## Local setup
1. Start an Android emulator or connect a device.
2. Start Appium:
   ```bash
   appium
   ```
3. Run the suite from the project root:
   ```bash
   mvn -Dtest=AppiumCourseSuite.xml test
   ```
   If your environment uses TestNG directly from the IDE, run the XML suite file.

## Useful environment variables
You can override the default configuration without editing code:
- `appium.server.host`
- `appium.server.port`
- `appium.js.path`
- `android.device.name`
- `android.app.path`
- `chromedriver.path`
- `browser.name`
- `ios.device.name`
- `ios.app.path`
- `ios.platform.version`

Example:
```bash
set appium.server.port=4723
set android.device.name=Android Emulator
```

## Notes
- The tests are designed to run against an emulator or real device with the required apps installed.
- Some examples depend on the app package and activity names used in the course.
