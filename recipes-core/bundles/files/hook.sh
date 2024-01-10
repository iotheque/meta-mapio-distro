#!/bin/sh

case "$1" in
        slot-post-install)
                # Update kernel, devicetree and bootscript
                cp "$RAUC_BUNDLE_MOUNT_POINT"/Image /boot/Image
                cp "$RAUC_BUNDLE_MOUNT_POINT"/bcm2711-rpi-cm4-io.dtb /boot/bcm2711-rpi-cm4-io.dtb
                cp "$RAUC_BUNDLE_MOUNT_POINT"/boot.scr /boot/boot.scr
                ;;
        *)
                exit 1
                ;;
esac

exit 0