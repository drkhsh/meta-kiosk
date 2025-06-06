DESCRIPTION = "Common package group list for kiosk image"
LICENSE = "GPL-3.0-or-later"

inherit packagegroup features_check

REQUIRED_DISTRO_FEATURES = "x11"

RDEPENDS:${PN} += " \
    packagegroup-core-x11-xserver \
    packagegroup-core-x11-utils \
    kiosk-autostart \
    kiosk-refresh \
    kiosk-wallpaper \
    chromium-x11 \
    libgles2 libgles2-mesa \
    onboard \
    at-spi2-core \
    ibus \
    matchbox-wm \
    matchbox-terminal \
    unclutter-xfixes \
    xdotool \
    feh \
    user-kiosk \
    mini-x-session \
    liberation-fonts \
    rpi-screenbrightness-mqtt \
    noto-color-emoji-unhinted \
    psplash \
    "

PACKAGE_ARCH = "${TUNE_PKGARCH}"
