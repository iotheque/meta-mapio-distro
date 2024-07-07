FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://networkd.conf \
    file://20-wired.network \
"

do_install:append() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/20-wired.network   ${D}${sysconfdir}/systemd/network/20-wired.network

    install -m 0644 ${WORKDIR}/networkd.conf ${D}/${sysconfdir}/systemd/networkd.conf
    sed -i -e "s:/lib/systemd/systemd-networkd-wait-online:/lib/systemd/systemd-networkd-wait-online --any:g" \
           ${D}/${systemd_unitdir}/system/systemd-networkd-wait-online.service
}

