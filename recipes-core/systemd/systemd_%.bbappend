do_install:append() {
    sed -i -e "s:/lib/systemd/systemd-networkd-wait-online:/lib/systemd/systemd-networkd-wait-online --any:g" \
           ${D}/${systemd_unitdir}/system/systemd-networkd-wait-online.service
}

