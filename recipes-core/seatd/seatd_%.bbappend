# https://patchwork.yoctoproject.org/project/oe-core/patch/20241127195904.91647-1-raj.khem@gmail.com/

inherit useradd systemd

PACKAGECONFIG[systemd] = "-Dlibseat-logind=systemd,,systemd"

do_install:append() {
    if [ "${VIRTUAL-RUNTIME_init_manager}" = "systemd" ]; then
        install -Dm644 ${S}/contrib/systemd/seatd.service ${D}${systemd_unitdir}/system/seatd.service
    fi
}

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM:${PN} = "-r seat"

SYSTEMD_SERVICE:${PN} = "seatd.service"
