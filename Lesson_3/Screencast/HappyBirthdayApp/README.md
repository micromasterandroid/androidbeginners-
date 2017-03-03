#  *The Happy Birthday App*

**The Happy BirthDay App** loads your contact users and send them send birthday messages. This app uses a [Loader](https://developer.android.com/reference/android/content/Loader.html) to get your user contacts (but first the app ask you for permission) and when you perform a click in each of them, the app is able to send an email with a happy birthday message.

## Topics

* Webview
* Permission system
* Async task, threading and handlers
* Background services
    - JobScheduler
* Loader


## User Stories

The following **required** functionality is completed:

* [x] User can **scroll through contacts**.
* [x] For each contact displayed, user can see the following details:
  * [x] Email and Contact image
* [x] The contacts are loaded using a [Loader](https://developer.android.com/reference/android/content/Loader.html)
* [x] When the user clicks each contact, the app creates an Explicit Intent to open an email client.
* [x] Before loading the contacts, the app request the "Contacts" permission to the user(It is a dangerous [permission](https://developer.android.com/training/permissions/index.html)).
* [x] There is an option in the menu with the "About me" option, when the user clicks this option the app displays an activity that loads a WebView.

The following **bonus** features are implemented:

* [x] All the values for dimensions are specified in dimens.xml
* [x] All the string values are specified in strings.xml

####Functionality
* [x] The code runs without errors.
* [x] Each percentage button updates the TextViews by adding the correct new values.
* [x] The reset button resets the scores on both of the score TextViews.

####Code Readability
* [x] Any classes are named after the object they represent.All variables are named by their intended contents. All methods are named by their intended effect or in the style required by a callback interface.
* [x] "There are no unnecessary blank lines. One variable is declared per declaration line. The code within a method is indented with respect to the method declaration line."

## App Images

Here's a walkthrough of implemented user stories:

<img src='https://github.com/IsabelPalomar/HappyBirthDayApp/blob/master/HappyBirthDayApp.png' title='Video Walkthrough' width='' alt='Video Walkthrough' height="400" width="200" />

<img src='https://github.com/IsabelPalomar/HappyBirthDayApp/blob/master/ComposeHBEmail.png' title='Video Walkthrough' width='' alt='Video Walkthrough' height="400" width="200"  />

GIF created with [LiceCap](http://www.cockos.com/licecap/).
