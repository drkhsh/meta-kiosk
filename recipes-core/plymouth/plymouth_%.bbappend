FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://0001-ply-device-manager-add-missing-function-declaration.patch \
    file://skynet.png \
    file://spinner.plymouth \
"

PACKAGECONFIG = "pango drm"

CFLAGS:append = " -Wno-unused-value"
EXTRA_OECONF += "--with-udev --with-runtimedir=/run"

do_install:append () {
    install -m 0644 ${WORKDIR}/skynet.png ${D}${datadir}/plymouth/themes/spinner/watermark.png
    install -m 0644 ${WORKDIR}/spinner.plymouth ${D}${datadir}/plymouth/themes/spinner/spinner.plymouth
}

