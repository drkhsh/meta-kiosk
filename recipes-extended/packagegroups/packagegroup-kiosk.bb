DESCRIPTION = "Common package group list for kiosk image"
LICENSE = "GPL-3.0-or-later"

inherit packagegroup

RDEPENDS:${PN} += " \
    kiosk-autostart \
    kiosk-refresh \
    chromium-x11 \
    onboard \
    at-spi2-core \
    ibus \
    matchbox-wm \
    unclutter-xfixes \
    xdotool \
    feh \
    user-kiosk \
    "

