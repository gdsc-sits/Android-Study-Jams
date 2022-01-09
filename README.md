# Android-Study-Jams

## Smart Attendance Application

<b> Problem Statement: </b>

Since the beginning of tracking attendance, we have been faced many issues monitoring attendance in schools and colleges. One of them is the  huge time taken for calling out everyone's roll no. and marking attendance manually on paper. 
Technology plays a vital role in day-to-day life activities which in turn made great changes in many work fields and out of them Mobile Application is one of the major developments. Mobile Application can be used effectively for this job as they are widely used and are known for easy access.

<b> Proposed Solution : </b>

This project proposes a "Smart Attendance System" to keep track of the attendance of school and college students digitally. Its features includes rapid attendance marking using QR code which works withing a millisecond. Unique QR code of each student is scanned and saved in database of attended students. It shows the list of students whose attendance has been marked. It has the option to visit GDSC-SITS & college webpage within the application. Currently we have been testing the app in our SITS institution only. The project's scope is to extend it for other institutions as we add more features.

<img width="559" alt="sampleimages" src="">

<b> Functionality & Concepts used : </b>

- The App has very simple and interactive interface which helps the iser to take attendance and view attendance with ease. Following are few android concepts used to achieve the functionalities in app :
- Constraint Layout : Most of the activities in the app uses a flexible constraint layout, which is easy to handle for different screen sizes.
- Simple & Easy Views Design : Use of familiar audience EditText with hints and interactive buttons made it easier for students to register or sign in without providing any detailed instructions pages. Apps also uses App Navigation to switch between GDSC-SITS & College webpage.
- RecyclerView : To present the list of attended students we used the efficient recyclerview. 
-Firebase API: We are also using the Firebase API free version (Spark Plan) for authentication purpose. In future if the user base increases we will go for the upgraded plan too.
- LiveData & Room Database: We are also using LiveData to update, observe and store attendance data. After the QR code is scanned by the user, the attended is marked and added to Room Database.

<b> Application Link & Future Scope : </b>

The app is currently in the stable testing phase with SITS institute with a limited no. of users, You can access the app : [YOUR APP LINK HERE](either Github link or Google Play store link of published app or .apk file).

We are looking forward to add more features like option to add custom subject attendance, a student login which enabled to monitor his attendance, etc.
Once the app is fully tested and with added useful functionality, we plan to talk to neighboring colleges regarding the implementation of Smart Attendance System using our application. We aim that by next year most of the colleges and schools in our city will use Smart Attendance Application for monitoring attendance.
