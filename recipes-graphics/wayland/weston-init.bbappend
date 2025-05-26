FILESEXTRAPATHS:prepend = "${THISDIR}/${PN}:"

# https://patchwork.yoctoproject.org/project/oe-core/patch/20241127195904.91647-2-raj.khem@gmail.com/
USERADD_PARAM:${PN} = "--home /home/weston --shell /bin/sh --user-group -G video,input,render,seat,wayland weston"
GROUPADD_PARAM:${PN} = "-r wayland; -r render; -r seat"

do_install:append() {
        if ${@bb.utils.contains('DISTRO_FEATURES','systemd','true','false',d)}; then
                rm ${D}${systemd_system_unitdir}/weston.service
                install -D -p -m0644 ${WORKDIR}/weston.service ${D}${systemd_system_unitdir}/weston.service
                sed -i -e s:/etc:${sysconfdir}:g \
                        -e s:/usr/bin:${bindir}:g \
                        -e s:/var:${localstatedir}:g \
                        ${D}${systemd_system_unitdir}/weston.service
        fi

        rm ${D}${sysconfdir}/xdg/weston/weston.ini
        install -D -p -m0644 ${WORKDIR}/weston.ini ${D}${sysconfdir}/xdg/weston/weston.ini
}
