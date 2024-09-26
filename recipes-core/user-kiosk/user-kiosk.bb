SUMMARY = "Kiosk image user."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PROVIDES = "user-kiosk"
RPROVIDES:${PN} = "user-kiosk"

FILESEXTRAPATHS:prepend = "${THISDIR}/files:"

SRC_URI = " file://skynet-wallpaper.png"

inherit useradd
USERADD_PARAM:${PN} = " \
    -u 1002 --user-group --create-home \
    --groups audio,video,shutdown,users \
    kiosk"
USERADD_PACKAGES = "${PN}"

do_install:append () {
    install -m 0755 ${D}/usr/share/wallpapers
    install -m 0644 ${WORKDIR}/skynet-wallpaper.png ${D}/usr/share/wallpapers/skynet.png
}

FILES:${PN} = "/usr/share/wallpapers/skynet.png"
