SUMMARY = "Kiosk image user."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PROVIDES = "user-kiosk"
RPROVIDES:${PN} = "user-kiosk"

FILESEXTRAPATHS:prepend = "${THISDIR}/files:"

inherit useradd
USERADD_PARAM:${PN} = " \
    -u 1002 --user-group --create-home \
    --groups audio,video,shutdown,users \
    kiosk"
USERADD_PACKAGES = "${PN}"

ALLOW_EMPTY:${PN} = "1"
