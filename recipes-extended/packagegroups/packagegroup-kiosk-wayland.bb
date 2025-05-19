DESCRIPTION = "Common package group list for kiosk image (wayland)"
LICENSE = "GPL-3.0-or-later"

inherit packagegroup

RDEPENDS:${PN} += " \
    kiosk-autostart-wayland \
    kiosk-wallpaper-wayland \
    chromium-x11 \
    libgles2 libgles2-mesa \
    user-kiosk \
    liberation-fonts \
    rpi-screenbrightness-mqtt \
    noto-color-emoji-unhinted \
    psplash \
    wayland \
    weston \
    "

