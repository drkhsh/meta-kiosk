#!/bin/sh
export DISPLAY=:0
WID=$(xdotool search --onlyvisible --class chromium | head -n 1)
xdotool windowactivate ${WID}
xdotool key shift+F5
