# BatteryChargingNotificator

## What is it

**Challenge**: Some smartphones (like the Moto G) only have a single color LED which seems not to indicate charging state of the phone.
(I can not say if this is because I'm using CyanogenMod or if this is the case on original devices too.)

**Solution**: "Battery Charging Notificator" uses notifications to switches the LED.

- While charging, the LED is off and the notification shows an orange icon.
- When fully charged, the icon becomes green and (if screen is off) the LED is switched on.

## Building from github

IDE-specific files are not included in the repository.

- Please set up yourself a local project in your preferred IDE.
- When committing changes, make sure that no local project files are committed (i.e. update `.gitignore`).

## Prebuild binaries

The current release from branch [Release-1.0.0](https://github.com/soerenkoehler/BatteryChargingNotificator/tree/Release-1.0.0) is available on Google Play:

<a href="https://play.google.com/store/apps/details?id=de.soerenkoehler.android.bcn&utm_source=global_co&utm_medium=prtnr&utm_content=Mar2515&utm_campaign=PartBadge&pcampaignid=MKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1"><img alt="Get it on Google Play" src="https://play.google.com/intl/en_us/badges/images/generic/en-play-badge-border.png" height="60px"/></a>
