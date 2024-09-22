SUMMARY = "provides a service for controlling a RaspberryPis screenbrightness via mqtt "
HOMEPAGE = "https://github.com/tofuSCHNITZEL/rpi-screenbrightness-mqtt"

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

DEPENDS = "python3-paho-mqtt python3-rpi-backlight"

RDEPENDS:${PN} += " \
    python3-paho-mqtt \
    python3-rpi-backlight \
"

SRC_URI = "git://github.com/tofuSCHNITZEL/rpi-screenbrightness-mqtt.git;branch=master;protocol=https \
           file://rpi_screenbrightness_mqtt.service \
           file://rpi_screenbrightness_mqtt.conf \
"
SRCREV= "dc17bee9f0b8c43483648f9504ddf94c1416302b"

SYSTEMD_SERVICE:${PN} = "rpi_screenbrightness_mqtt.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

S = "${WORKDIR}/git"

inherit setuptools3

do_install:append () {
	install -d -m 755 ${D}${sysconfdir}/systemd/system
	install -m 0644 ${WORKDIR}/rpi_screenbrightness_mqtt.service ${D}${sysconfdir}/systemd/system/rpi_screenbrightness_mqtt.service

	install -d -m 755 ${D}/data/config
    install -m 0644 ${WORKDIR}/rpi_screenbrightness_mqtt.conf ${D}/data/config/rpi_screenbrightness_mqtt
    ln -sf /data/config/rpi_screenbrightness_mqtt ${D}${sysconfdir}/rpi_screenbrightness_mqtt.conf
}

FILES:${PN} += "/data/config/rpi_screenbrightness_mqtt"
