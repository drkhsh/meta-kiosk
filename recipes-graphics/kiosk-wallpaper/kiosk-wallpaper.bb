SUMMARY = "Kiosk wallpaper."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

KIOSK_WALLPAPER ?= "wallpaper.png"
FILESEXTRAPATHS:prepend = "${THISDIR}/files:"
SRC_URI = " file://${KIOSK_WALLPAPER}"

do_install:append () {
    install -d -m 0755 ${D}/usr/share/wallpapers
    install -m 0644 ${WORKDIR}/${KIOSK_WALLPAPER} ${D}/usr/share/wallpapers/wallpaper.png
}

FILES:${PN} = "/usr/share/wallpapers/wallpaper.png"
