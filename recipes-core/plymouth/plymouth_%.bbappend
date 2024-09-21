FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://skynet.png \
    file://spinner.plymouth \
"

PACKAGECONFIG:remove = "initrd"

do_install:append () {
    install -m 0644 ${WORKDIR}/skynet.png ${D}${datadir}/plymouth/themes/spinner/watermark.png
    install -m 0644 ${WORKDIR}/spinner.plymouth ${D}${datadir}/plymouth/themes/spinner/spinner.plymouth
}

