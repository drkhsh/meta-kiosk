SUMMARY = "Kiosk autostart"

LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

RDEPENDS:${PN} = "mini-x-session"

SRC_URI:append = " file://session \
                   file://kiosk.conf"
FILES:${PN} += " ${sysconfdir}/mini_x/session /data/config/kiosk"

do_install() {
    install -d ${D}${sysconfdir}/mini_x
    install -m 755 ${WORKDIR}/session ${D}${sysconfdir}/mini_x/session

    install -m 755 -d ${D}/data/config
    install -m 644 ${WORKDIR}/kiosk.conf ${D}/data/config/kiosk
}
