## Random Dog Image Generator App

Android application that generates and saves random dog images using the Dog API. Built with Jetpack Compose and following Android best practices.

##  Demo

[ Watch Demo Video ](https://drive.google.com/file/d/1QUySv01_OPw2chBbSvM_Ckf9iFFqZrmk/view?usp=sharing)

##  Features

- Generate random dog images with a single tap
- Save recently generated images automatically
- View history of generated images in a horizontal scrollable gallery
- Clear saved images with one click
- Persistent storage across app sessions

##  Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **MVVM Architecture**
- **Coroutines & Flow**
- **Dagger Hilt**
- **Retrofit**
- **Coil**
- **DataStore**
- **Material 3**

##  API

The app uses the https://dog.ceo/api/breeds/image/random API to fetch random dog images.

##  Implementation Details

- Used Jetpack DataStore for efficient data persistence
- Implemented LRU cache mechanism to store last 20 generated images
- Implemented proper error handling and loading states
