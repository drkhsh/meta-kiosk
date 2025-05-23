# https://patchwork.yoctoproject.org/project/oe-core/patch/20241127195904.91647-2-raj.khem@gmail.com/

USERADD_PARAM:${PN} = "--home /home/weston --shell /bin/sh --user-group -G video,input,render,seat,wayland weston"
GROUPADD_PARAM:${PN} = "-r wayland; -r render; -r seat"
