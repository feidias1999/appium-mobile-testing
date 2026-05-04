📱 Appium Mobile Automation Project

🚀 Overview

This project demonstrates mobile test automation using:

Java
Appium (v2)
TestNG
UiAutomator2 (Android)

It is designed as a starting point for building a scalable mobile automation framework.

🧰 Tech Stack
Java 17
Appium Java Client
TestNG
Maven
Android Emulator / Real Device

📁 Project Structure
Appium/
│── src/
│   └── test/
│       └── java/
│           └── feidiasantoniouacademy/
│               └── AppiumBasics.java
│
│── resources/
│   └── ApiDemos-debug.apk
│
│── pom.xml

⚙️ Prerequisites

Make sure you have installed:

Java 17+
Maven
Node.js
Appium 2
Android Studio (for emulator)

Verify installations:
java -version
mvn -version
node -v
appium -v

📲 Start Appium Server

Run:

appium

You should see:

Appium REST http interface listener started on http://0.0.0.0:4723

▶️ Running the Test
Start Android emulator or connect a real device
Start Appium server
Run the test class:
AppiumBasics.java

🧪 Example Test
@Test
public void AppiumTest() throws Exception {

    UiAutomator2Options options = new UiAutomator2Options();
    options.setDeviceName("Android Emulator");
    options.setApp("path/to/ApiDemos-debug.apk");

    AndroidDriver driver = new AndroidDriver(
            new URI("http://127.0.0.1:4723").toURL(),
            options
    );

    driver.quit();
}
🔥 Key Features
Appium 2 compatible setup
Uses modern UiAutomator2Options (no deprecated DesiredCapabilities)
Maven-based dependency management
TestNG test execution

❗ Common Issues & Fixes
1. HttpResponse$BodyHandler cannot be resolved

✔ Fix: Use Java 11+ (recommended Java 17)

2. Appium connection issues

✔ Ensure Appium is running:

http://127.0.0.1:4723
3. Device not detected

✔ Check:

adb devices

🧱 Future Improvements
Page Object Model (POM)
Base Test setup
Driver Manager
Parallel execution
Reporting (Allure / Extent Reports)

👨‍💻 Author

Feidias Antoniou

⭐ Notes

This project is part of my journey transitioning from Manual QA → Automation Engineer, focusing on Mobile Test Automation with Appium.
