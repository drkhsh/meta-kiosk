SUMMARY = "provides a service for controlling a RaspberryPis screenbrightness via mqtt"
HOMEPAGE = "https://github.com/tofuSCHNITZEL/rpi-screenbrightness-mqtt"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ecb60f442a5c7e94740539e9b098379a"

SRC_URI[sha256sum] = "0c64a8aa401574c75942045b9af70d1656e14c5366151c0cbb400cbeedc2362a"

PYPI_PACKAGE = "rpi-backlight"

inherit pypi setuptools3
