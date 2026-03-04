# Simple Calc

A simple calculator application for Android.

## 🛠️ How to Build

You can build and run this project using a standard Integrated Development Environment (IDE) or by using a terminal-based approach with Gradle.

### Option 1: Using an IDE (e.g., Android Studio)
Using an IDE is the most straightforward way to build the app, especially for development and testing.

1. Download and install **Android Studio** (if you do not have it installed).
2. Open Android Studio and select **"Open"** (or "Open an existing Android Studio project").
3. Navigate to the root directory of this project and click **OK**.
4. Wait for the initial **Gradle sync** to complete (you can monitor the progress bar at the bottom of the screen).
5. To run the app on an emulator or a plugged-in physical device, click the green **"Run" (Play) button** in the top toolbar. 
6. To simply generate an installable file, go to the top menu and select **Build > Build Bundle(s) / APK(s) > Build APK(s)**.

### Option 2: Using the Terminal (Terminal-based SDK)
If you prefer building from the command line, or if you are running this on a system without a visual IDE installed, follow these steps. 

Open your terminal (or PowerShell), navigate to the root directory of this project, and execute one of the following Gradle commands:

**Standard Build:**
To compile the code and build a debug version of the application, run:
```bash
gradle assembleDebug
```

**Offline Build:**
If you have already downloaded all the necessary Gradle dependencies previously and want to build without an active internet connection, run:
```bash
gradle assembleDebug --offline
```

### 🚀 Locating the Output
Once your terminal build is successful, your compiled APK file will typically be located in the following directory:
`app/build/outputs/apk/debug/`
