FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://nginx.conf \
    file://nginx.service \
"

do_install:append () {
    install -d ${D}${sysconfdir}/nginx/
    install -m 0644 ${WORKDIR}/nginx.conf ${D}/${sysconfdir}/nginx/nginx.conf
}

FILES:${PN} += "${sysconfdir}/nginx/nginx.conf"
