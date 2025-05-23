#!/bin/sh

. /data/config/kiosk

if test -z "$XDG_RUNTIME_DIR"; then
    export XDG_RUNTIME_DIR=/run/user/`id -u`
    if ! test -d "$XDG_RUNTIME_DIR"; then
        mkdir --parents $XDG_RUNTIME_DIR
        chmod 0700 $XDG_RUNTIME_DIR
    fi
fi

# wait for weston
while [ ! -e  $XDG_RUNTIME_DIR/wayland-1 ]; do sleep 0.1; done
sleep 1

export DISPLAY=:0.0
export WAYLAND_DISPLAY=wayland-1

# launch application
/usr/bin/chromium --kiosk --use-gl=angle --ignore-gpu-blocklist --enable-zero-copy \
	--enable-gpu-rasterization --force-renderer-accessibility --enable-remote-extensions \
	--noerrdialogs --hide-crash-restore-bubble --no-first-run --hide-scrollbars \
	--pull-to-refresh=1 --force-device-scale-factor=0.9 --force-dark-mode \
	\"${URL:=https://news.ycombinator.com/}\" &

