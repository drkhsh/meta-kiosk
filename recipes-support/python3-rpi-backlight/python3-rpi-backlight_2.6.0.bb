SUMMARY = "provides a service for controlling a RaspberryPis screenbrightness via mqtt"
HOMEPAGE = "https://github.com/tofuSCHNITZEL/rpi-screenbrightness-mqtt"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ecb60f442a5c7e94740539e9b098379a"

SRC_URI[sha256sum] = "4b57871020e3067026fcd1f00a0f67265e269af18b7ef53f7725580c3d08e219"

PYPI_PACKAGE = "rpi-backlight"

inherit pypi setuptools3
