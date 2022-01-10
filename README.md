# Overview
The Faceki Software Development Kit (SDK) provides you with a set of tools and UIs to develop an Android application perfectly fitted to your specific needs.

Onboard new users and easily verify their digital identities by making sure the IDs they provide are valid and authentic. Extract data from ID documents completely automatically and within seconds. Confirm that users really are who they say they are by having them take a quick selfie and match it to their respective documents. Faceki uses cutting-edge biometric technology such as 3D face mapping to make sure there is an actual, real-life person in front of the screen.

Using the Faceki SDK will allow you to create the best possible solution for your individual needs, providing you with a range of different services to choose from.

# Get Started
Please note that basic setup is required before continuing with the integration of any of the following services.

## ID Verification
ID Verification (formerly known as Netverify) is a secure and easy solution that allows you to establish the genuine identity of your users in your mobile application by verifying their passports and other government-issued IDs in real time. Very user-friendly and highly customizable, it makes onboarding new customers quick and simple.

## Faceki Authentication
Authentication is a cutting-edge biometric-based service that establishes digital identities of your users, simply by taking a selfie. Advanced 3D face mapping-technology quickly and securely authenticates users and their digital identities.

## Faceki Document Verification
Document Verification is a powerful solution that allows users to scan various types of documents quickly and easily in your mobile application. Data extraction is already supported for various document types, such as Passport.

Start by downloading the [KYC-Android-Native] from the Faceki Github repo. You can either clone the repository (using SSH or HTTPS) to your local device or simply download everything as a ZIP.

Once you’ve got the sample application downloaded and unzipped, open Android Studio. Choose __Import project__ and navigate to where you’ve saved your sample application.

Android Studio will now start to import the project. This might take a bit of time. Make sure to wait until the Gradle Build has finished and the application is properly installed!

Note: We strongly recommend not storing any credentials inside your app! We suggest loading them during runtime from your server-side implementation.

Once you start up the sample application, you'll be given the option of trying out the Faceki SDK. Click the hamburger menu in the top left corner to choose a service. Your application will also need camera permissions, which will be prompted for automatically once you try to start any of the services. If you deny camera permissions, you won't be able to use any of the services.


# Basics

## General Requirements
The minimum requirements for the SDK are:
*	Android 5.0 (API level 21) or higher
*	Internet connection

### Authentication with OAuth2
Your OAuth2 credentials are constructed using your API token as the Client ID and email. You can view and manage your API token.

Client ID and email are used to generate an OAuth2 access token. OAuth2 has to be activated for your account. Contact your Faceki Account Manager for activation.

#### Access Token Timeout (OAuth2)
Your OAuth2 access token is valid for 60 minutes. After the token lifetime is expired, it is necessary to generate a new access token.

As soon as the workflow (transaction) starts, a 15 minutes session timeout is triggered. For each action performed (capture image, upload image) the session timeout will reset, and the 15 minutes will start again.

After creating/updating a new account you will receive a `sdk.token` (JWT) for initializing the SDK. Use this SDK token with your Android code:


## Permissions
Required permissions are linked automatically by the SDK.


## Integration by sdk
Use the SDK in your application by including the Maven repositories with the following `build.gradle` configuration in Android Studio:

```
repositories {
	...
	maven { url 'https://jitpack.io' }
}
```


## Integration by library
Use the Library in your application by implemention lib with the following `build.gradle` project module in Android Studio:

```
implementation 'com.github.faceki:KYC-Android-Native:$Version'
```

and including the Maven repositories with the following `build.gradle` configuration in Android Studio:

```
repositories {
	...
	maven { url 'https://jitpack.io' }
}
```

## Example

```
import com.facekikycverification.startup.FacekiVerification
```

Kotlin

```
var facekiVerification: FacekiVerification? = null
facekiVerification = FacekiVerification()
```

```
facekiVerification!!.initiateSMSDK(this, "YOUR_CLIENT_ID", "EMAIL_ADDRESS")
```

Java

```
FacekiVerification facekiVerification = null;
facekiVerification = new FacekiVerification();
```

```
facekiVerification.initiateSMSDK(this, "YOUR_CLIENT_ID", "EMAIL_ADDRESS");
```
