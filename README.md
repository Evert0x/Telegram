# Telegram Totality
A telegram fork with integrated non-custodial Ethereum wallet. Bot creators are able to create in chat actions that let users send Ethereum transactions and interact with Ethereum protocols in an intuitive way. Made during https://hackathon.money/.

**Examples**
- https://github.com/Evert0x/ENSbot
- https://github.com/Evert0x/AaveBot

## Build info
1. Follow the original readme below
2. Add the following info to `gradle.properties`

>INFURA_ENDPOINT=https://ropsten.infura.io/v3  
INFURA_KEY={INFURA_KEY}</br>
DAI_ADDRESS=0xf80A32A835F79D7787E8a8ee5721D0fEaFd78108  
ENS_ADDRESS=0x283Af0B28c62C092C9727F1Ee09c02CA627EB7F5  
AAVE_ADDRESS=0x9E5C7835E4b13368fd628196C4f1c6cEc89673Fa  
TGLINK_ENDPOINT={TGLINK}</br>
ENS_ENDPOINT={ENS_SERVER_URL}</br>
AAVE_ENDPOINT={AAVE_SERVER_URL}

For TGLINK, take a look at https://github.com/Evert0x/KeyValue, this is a centralized placeholder to map Telegram userid's to their Ethereum address. Will be on chain in the future.

### Notes
Currently the ENS and AAVE use cases are hardcoded, this is to showcase the hack. In the future this will be more generalised with proxy endpoints / contracts.

# Original read me

## Telegram messenger for Android

[Telegram](https://telegram.org) is a messaging app with a focus on speed and security. It’s superfast, simple and free.
This repo contains the official source code for [Telegram App for Android](https://play.google.com/store/apps/details?id=org.telegram.messenger).

## Creating your Telegram Application

We welcome all developers to use our API and source code to create applications on our platform.
There are several things we require from **all developers** for the moment.

1. [**Obtain your own api_id**](https://core.telegram.org/api/obtaining_api_id) for your application.
2. Please **do not** use the name Telegram for your app — or make sure your users understand that it is unofficial.
3. Kindly **do not** use our standard logo (white paper plane in a blue circle) as your app's logo.
3. Please study our [**security guidelines**](https://core.telegram.org/mtproto/security_guidelines) and take good care of your users' data and privacy.
4. Please remember to publish **your** code too in order to comply with the licences.

### API, Protocol documentation

Telegram API manuals: https://core.telegram.org/api

MTproto protocol manuals: https://core.telegram.org/mtproto

### Compilation Guide

**Note**: In order to support [reproducible builds](https://core.telegram.org/reproducible-builds), this repo contains dummy release.keystore,  google-services.json and filled variables inside BuildVars.java. Before publishing your own APKs please make sure to replace all these files with your own.

You will require Android Studio 3.4, Android NDK rev. 20 and Android SDK 8.1

1. Download the Telegram source code from https://github.com/DrKLO/Telegram ( git clone https://github.com/DrKLO/Telegram.git )
2. Copy your release.keystore into TMessagesProj/config
3. Fill out RELEASE_KEY_PASSWORD, RELEASE_KEY_ALIAS, RELEASE_STORE_PASSWORD in gradle.properties to access your  release.keystore
4.  Go to https://console.firebase.google.com/, create two android apps with application IDs org.telegram.messenger and org.telegram.messenger.beta, turn on firebase messaging and download google-services.json, which should be copied to the same folder as TMessagesProj.
5. Open the project in the Studio (note that it should be opened, NOT imported).
6. Fill out values in TMessagesProj/src/main/java/org/telegram/messenger/BuildVars.java – there’s a link for each of the variables showing where and which data to obtain.
7. You are ready to compile Telegram.

### Localization

We moved all translations to https://translations.telegram.org/en/android/. Please use it.
