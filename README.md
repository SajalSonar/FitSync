# FitSync (Prototype) - Healthier Lifestyle Mobile Application

FitSync is a mobile application developed using Java and Android Studio, aimed at promoting a healthier lifestyle. This prototype integrates various features to help users manage their fitness and health goals efficiently.

<div align="center">
    <img src="https://github.com/user-attachments/assets/2a52a091-0f24-4cd1-a264-fe48455adde4" alt="Home Screen" width="33%"/>
</div>

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)

## Overview
FitSync provides a user-friendly interface for tracking exercise, counting calories, monitoring water intake, and discovering new exercises. It leverages secure authentication and a robust backend to ensure data safety and real-time updates.

## Features
- **Secure Registration and Login**: FitSync uses Firebase Authentication for secure user registration and login, ensuring users' personal data and progress are protected.
  
- **Exercise Tracking**: Users can track their exercises, set goals, and monitor their progress. The app provides a comprehensive log of workouts, including duration, type, and intensity.

<div align="center">
    <img src="https://github.com/user-attachments/assets/3cf8903f-eb2a-425f-be65-656b2f11c4ee" alt="Tracker" width="33%"/>
</div>

- **Calorie Counting**: The calorie counting feature helps users keep track of their daily caloric intake. Users can log their meals, and the app calculates the total calories consumed, aiding in diet management.

- **Water Intake Monitoring**: FitSync encourages users to stay hydrated by allowing them to monitor their daily water intake. The app sends reminders to ensure users meet their hydration goals.

- **Discover New Exercises**: Users can explore a variety of exercises within the app. FitSync offers recommendations based on users' fitness levels and goals, helping them diversify their workout routines.

<div align="center">
    <img src="https://github.com/user-attachments/assets/81c48b96-dab7-489c-8142-afdb2e41ade1" alt="Discover" width="33%"/>
</div>

## Technologies Used
- **Java**: The primary programming language used for developing the app.
- **Android Studio**: The integrated development environment (IDE) for Android application development.
- **Firebase**: For backend services, including authentication and real-time database.

## Installation
To run FitSync locally, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/FitSync.git
   cd FitSync
   
2. **Open the project in Android Studio**:
   - Launch Android Studio and open the cloned project.

3. **Sync the project with Gradle files**:
   - Click on `File` -> `Sync Project with Gradle Files`.

4. **Set up Firebase**:
   - Create a Firebase project in the [Firebase Console](https://console.firebase.google.com/).
   - Add your Android app to the project and follow the setup instructions to obtain the `google-services.json` file.
   - Place the `google-services.json` file in the `app/` directory of your project.

5. **Run the application**:
   - Connect your Android device or use an emulator.
   - Click on the `Run` button in Android Studio.

## Usage
- Upon launching FitSync, users can register or log in securely.
- Users can track their workouts, log meals, monitor water intake, and explore new exercises.
- The app will send reminders for hydration goals and prompt users to stay active.

## Contributing
Contributions are welcome! If you would like to contribute to FitSync, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeature`).
3. Make your changes and commit them (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeature`).
5. Open a pull request.

