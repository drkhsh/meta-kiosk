FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://xserver-nodm.service.in"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"
PACKAGECONFIG:remove = "blank"
PACKAGECONFIG:append = " nocursor"
