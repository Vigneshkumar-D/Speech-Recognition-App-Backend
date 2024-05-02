# Speech Recognition App Backend

## Overview

The Speech Recognition App Backend is responsible for handling speech recognition requests from the frontend, processing the transcribed text, and saving it to an Excel file. It provides the necessary APIs for receiving transcription data, processing it, and returning responses to the frontend.

## Features

- **Speech Recognition:** Backend functionality includes speech recognition using the Web Speech API.
- **Excel File Generation:** Transcribed text is saved to an Excel file for further analysis and use.
- **RESTful APIs:** The backend exposes RESTful APIs for receiving transcription data and handling requests.
- **Error Handling:** Robust error handling mechanisms are implemented to handle unexpected scenarios and provide informative error messages.

## Technologies Used

- **Java:** Programming language used for backend development.
- **Spring Boot:** Framework for building web applications with Java.
- **Apache POI:** Library for working with Microsoft Office documents, used for Excel file generation.

## Getting Started

To run the Speech Recognition App Backend locally, follow these steps:

1. **Clone the Repository:**
   ```bash
   git clone <repository_url>
   ```

2. **Navigate to the Backend Directory:**
   ```bash
   cd speech-recognition-app/backend
   ```

3. **Build the Project:**
   ```bash
   mvn clean install
   ```

4. **Run the Application:**
   ```bash
   java -jar target/speech-recognition-app-backend.jar
   ```

5. **Access the APIs:**
   The backend APIs will be accessible at `http://localhost:8080`.

## API Endpoints

- **Save Speech Transcription:**
  - **Endpoint:** `POST /save-speech`
  - **Request Body:** JSON object containing the transcribed text.
  - **Response:** JSON object with a success message or error message.

## Contribution

Contributions to the Speech Recognition App Backend are welcome! If you'd like to contribute, please fork the repository, make your changes, and submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).
```

Feel free to adjust any details or add more information as needed!
