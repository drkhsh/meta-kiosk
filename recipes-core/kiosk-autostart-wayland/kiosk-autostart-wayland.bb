SUMMARY = "Kiosk autostart (on Wayland)"

inherit allarch systemd

LICENSE="MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

RDEPENDS_${PN} += "weston-init"

S = "${WORKDIR}"

SRC_URI:append = " file://wayland-launch-kiosk.service \
                   file://wayland-launch-kiosk.sh \
                   file://kiosk.conf"

do_install () {
    install -d ${D}/${bindir} ${D}${systemd_unitdir}/system/
    install -m 0644 ${S}/wayland-launch-kiosk.service ${D}${systemd_unitdir}/system
    install -m 0755 ${S}/wayland-launch-kiosk.sh ${D}/${bindir}

    install -m 755 -d ${D}/data/config
    install -m 644 ${S}/kiosk.conf ${D}/data/config/kiosk
}

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE:${PN} = "wayland-launch-kiosk.service"
SYSTEMD_AUTO_ENABLE = "enable"

FILES:${PN} += " /data/config/kiosk /usr/lib/systemd/system/wayland-launch-kiosk.service"

