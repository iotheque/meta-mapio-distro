FILESEXTRAPATHS:prepend := "${THISDIR}/wpa-supplicant:"

SRC_URI:append = " \
    file://wpa_supplicant-wlan0.conf  \
    file://25-wlan.network  \
    file://wpa_supplicant-ap.conf  \
    file://wpa_supplicant-ap.service \
    file://30-wlan_ap.network  \
"

do_install:append() {
    install -d ${D}${sysconfdir}/wpa_supplicant
    install -m 0644 ${WORKDIR}/wpa_supplicant-wlan0.conf  ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf

    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/25-wlan.network  ${D}${sysconfdir}/systemd/network/25-wlan.network

    # Acesspoint
    install -m 0644 ${WORKDIR}/wpa_supplicant-ap.conf  ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-ap.conf
    install -m 0644 ${WORKDIR}/30-wlan_ap.network  ${D}${sysconfdir}/systemd/network/30-wlan_ap.network
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/wpa_supplicant-ap.service ${D}/${systemd_unitdir}/system/
}
