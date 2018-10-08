# HW2 App
Software Engineering (CEG 4110) HW2

### Main Features
The main purpose of this software is to build a mobile application that displays a clock to a user. The users will have the option to view the current time in either an analog representation or a digital representation. Both views update every second. The user also has the ability to open multiple views at once or multiple copies of the same view. This was implemented by opening each view in a new tab. When the user first launches the application, the time will automatically default to the current time. However, the user is also able to manually change the date and time to anything he/she wishes from the menu tab. The user is able to change the month, day, year, hour, minute, or second in the software, this change is then applied to all open views. The user is also has the ability to undo and redo any time changes that was applied.

The screenshot below shows the general layout of the menu tab. You are able to change the Number Picker for any of the values and then click its associated button to change the time or date. To add views, you simply click on either the “ADD ANALOG VIEW” or “ADD DIGITAL VIEW” buttons. To undo or redo, you would also simply click on one of the buttons.

<img src="https://user-images.githubusercontent.com/22596783/46631509-9cc97400-cb15-11e8-9874-f6aaa2e92a84.JPG" width="300" height="550">

Below shows screenshots if the view layouts. The first is the digital view that simply shows a digital time and date representation and the second is the analog clock with the date displayed at the top. You can also see additional analog and digital clock views open in tabs at the top of the screen.

<img src="https://user-images.githubusercontent.com/22596783/46631535-b2d73480-cb15-11e8-8072-b4f1475e1af1.JPG" width="300" height="550"> <img src="https://user-images.githubusercontent.com/22596783/46631540-b5398e80-cb15-11e8-8152-a467fa0c7506.JPG" width="300" height="550">

### Design Patterns
We were tasked to implement the MVC and Command design patterns in our application. I first started with implementing the MVC design pattern. I did not find this design too complicated to implement. The model and controller were both easy to design and then I just created the views (all extending abstract class View) and had these communicate with the controller to receive and set the variables held in the model. The main problem I had with this pattern was implementing this with the rest of the application. For example, working this model in while working around the fragment class (to create the tab views) was a bit of a challenge. However, I still found this design pattern very important and worth implementing. 

The Command design pattern was also a requirement to implement in this application. This design pattern was also not too difficult to implement. After creating the Command interface, it was simply a matter of creating each command with its necessary actions in its own class. All of these classes implemented a method to execute, undo, and redo the command. An instance of each command was created when its associated listener was triggered from its button click. As each command was instantiated, they were pushed into the queue in the singleton class CommandQ that was created to implement to undo and redo functions. The redo and undo functions were implemented by keeping two variables to keep up with the current index and the max index. I found this design pattern very important and worth implementing, as well. It took a little more time to set up as I felt it was a little more difficult to implement than the MVC was, however I still find it worthwhile. 

### Deployment
You can either launch this application through the source code or the APK.

#### Source Code Method:
To run this app, download the project zip folder and extract the contents on to your computer. Launch Android Studio (or download it at this link if you do not have it installed: https://developer.android.com/studio/) and click to open an existing project within Android Studio as shown below.

![2018-09-14 2](https://user-images.githubusercontent.com/22596783/45560708-e626ec00-b813-11e8-8e9c-81cb24b5c643.png)

Browse to where you saved the extracted project and click to open it.

![2018-09-14 3](https://user-images.githubusercontent.com/22596783/45560818-24bca680-b814-11e8-9b56-c02d8cae81c7.png)

Android Studio should then load the project in. Once it has finished indexing, you can either plug in your android device through a USB cable and hit the play button at the top of your screen and select your plugged-in device to run the app on. Or you can create and run an android emulator through android studio by hitting the play button and then selecting/creating an emulator with the dialog screen the pops up.

![2018-09-14 5](https://user-images.githubusercontent.com/22596783/45561112-f1c6e280-b814-11e8-9ad0-9fa1650206e5.png)

After Android Studio has finished building, the HW2 application will download and launch on your phone (or emulator). You must enable app debugging for this method. The app will still be available on your phone under applications as "HW2" even after stopping android studio and/or unplugging your device. 

#### APK Method:
To run this app, download the project zip folder and extract the contents on to your computer. Plug in your Android mobile device to your computer and connect as media device if you get prompted. Then open up your folder to view your Android device's files under "My Computer" or "This PC". Once you have your Android device's files open, copy the APK from the bin folder in the extracted git project to the root of your Android device's files as shown below.
Now, switch to your Android device and open the application "My Files". Locate your APK, click on your APK, and click "Install". Once it has finished installing, click "Open" to launch the application.
