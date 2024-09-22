SUMMARY = "provides a service for controlling a RaspberryPis screenbrightness via mqtt "
HOMEPAGE = "https://github.com/tofuSCHNITZEL/rpi-screenbrightness-mqtt"

LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

DEPENDS = "python3-core python3-paho-mqtt python3-rpi-backlight"

RDEPENDS:${PN} += " \
    python3-paho-mqtt \
    python3-rpi-backlight \
"

SRC_URI = "git://github.com/tofuSCHNITZEL/rpi-screenbrightness-mqtt.git;branch=master;protocol=https"
SRCREV= "88cf6d9b9b685ffa1720644bd53c742afb10a414"

S = "${WORKDIR}/git"

inherit setuptools3
