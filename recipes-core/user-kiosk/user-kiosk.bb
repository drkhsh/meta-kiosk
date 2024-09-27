SUMMARY = "Kiosk image user."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PROVIDES = "user-kiosk"
RPROVIDES:${PN} = "user-kiosk"

KIOSK_WALLPAPER ?= "wallpaper.png"

FILESEXTRAPATHS:prepend = "${THISDIR}/files:"

SRC_URI = " file://${KIOSK_WALLPAPER}"

inherit useradd
USERADD_PARAM:${PN} = " \
    -u 1002 --user-group --create-home \
    --groups audio,video,shutdown,users \
    kiosk"
USERADD_PACKAGES = "${PN}"

do_install:append () {
    install -d -m 0755 ${D}/usr/share/wallpapers
    install -m 0644 ${WORKDIR}/${KIOSK_WALLPAPER} ${D}/usr/share/wallpapers/wallpaper.png
}

FILES:${PN} = "/usr/share/wallpapers/wallpaper.png"
