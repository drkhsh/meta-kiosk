DESCRIPTION = "Common package group list for kiosk image (wayland)"
LICENSE = "GPL-3.0-or-later"

inherit packagegroup features_check

REQUIRED_DISTRO_FEATURES = "wayland"

RDEPENDS:${PN} += " \
    kiosk-autostart-wayland \
    kiosk-wallpaper \
    chromium-ozone-wayland \
    libgles2 libgles2-mesa \
    user-kiosk \
    liberation-fonts \
    noto-color-emoji-unhinted \
    psplash \
    wayland \
    weston \
    weston-init \
    seatd \
    "

PACKAGE_ARCH = "${TUNE_PKGARCH}"
