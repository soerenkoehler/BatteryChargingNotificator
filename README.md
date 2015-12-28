# BatteryChargingNotificator

## What is it

**Challenge**: Some smartphones (like the Moto G) only have a single color LED which seems not to indicate charging state of the phone.
(I can not say if this is because I'm using CyanogenMod or if this is the case on original devices too.)

**Solution**: "Battery Charging Notificator" uses notifications to switches the LED.

- While charging, the LED is off and the notification shows an orange icon.
- When fully charged, the icon becomes green and (if screen is off) the LED is switched on.

## Prebuild binaries

https://play.google.com/

## Building from github

IDE-specific files are not included in the repository.

- Please set up yourself a local project in your preferred IDE.
- Make sure that any local project files are ignored (i.e. update `.gitignore`).