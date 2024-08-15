inherit systemd

SUMMARY = "Kiosk refresh"

LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

RDEPENDS:${PN} = "chromium-x11 xdotool"

SRC_URI:append = " file://kiosk-reload.service \
                   file://kiosk-reload.timer \
                   file://refresh-chromium.sh"

SYSTEMD_SERVICE:${PN} = "kiosk-reload.timer"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install() {
	install -d -m 755 ${D}${bindir}
	install -d -m 755 ${D}${sysconfdir}/systemd/system

	install -m 0644 ${WORKDIR}/kiosk-reload.service ${D}${sysconfdir}/systemd/system/kiosk-reload.service
	install -m 0644 ${WORKDIR}/kiosk-reload.timer ${D}${sysconfdir}/systemd/system/kiosk-reload.timer
	install -m 755 ${WORKDIR}/refresh-chromium.sh ${D}${bindir}/refresh-chromium.sh
}

FILES:${PN} += " ${sysconfdir}/systemd/system/kiosk-reload.service \
                 ${sysconfdir}/systemd/system/kiosk-reload.timer \
                 ${bindir}/refresh-chromium.sh"

