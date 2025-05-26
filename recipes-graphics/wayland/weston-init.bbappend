FILESEXTRAPATHS:prepend = "${THISDIR}/${PN}:"

# https://patchwork.yoctoproject.org/project/oe-core/patch/20241127195904.91647-2-raj.khem@gmail.com/
USERADD_PARAM:${PN} = "--home /home/weston --shell /bin/sh --user-group -G video,input,render,seat,wayland weston"
GROUPADD_PARAM:${PN} = "-r wayland; -r render; -r seat"

do_install() {
        install -D -p -m0644 ${WORKDIR}/weston.ini ${D}${sysconfdir}/xdg/weston/weston.ini
}
