#!/bin/sh

case "$1" in
        slot-pre-install)
                # Check if wlan0 service is enabled
                if [ -e "/etc/systemd/system/multi-user.target.wants/wpa_supplicant@wlan0.service" ]; then
                        # Backup WIFI cretentials
                        cp /etc/wpa_supplicant/wpa_supplicant-wlan0.conf /tmp/
                fi
                ;;
        slot-post-install)
                # Check if WIFI cretentials have been backuped
                if [ -e "/tmp/wpa_supplicant-wlan0.conf" ]; then
                        # Restore
                        cp /tmp/wpa_supplicant-wlan0.conf "$RAUC_SLOT_MOUNT_POINT"/etc/wpa_supplicant/
                        ln -s "$RAUC_SLOT_MOUNT_POINT"/lib/systemd/system/wpa_supplicant@.service "$RAUC_SLOT_MOUNT_POINT"/etc/systemd/system/multi-user.target.wants/wpa_supplicant@wlan0.service
                fi
                ;;
        *)
                exit 1
                ;;
esac

exit 0