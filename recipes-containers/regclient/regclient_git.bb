SUMMARY = "regclient utility"
DESCRIPTION = "This recipe builds the reglcient binaries."
HOMEPAGE = "https://github.com/regclient/regclient"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit go
GO_IMPORT = "github.com/regclient/regclient"
SRC_URI = "git://${GO_IMPORT}.git;protocol=https;branch=releases/0.8"

SRCREV = "e7e5436b4e93a897084aceca6b118b8002b20122"
S = "${WORKDIR}/git"

# nooelint: oelint.vars.insaneskip
INSANE_SKIP:${PN} += "already-stripped"

# Workaround for network access issue during compile step
# this needs to be fixed in the recipes buildsystem to move
# this such that it can be accomplished during do_fetch task
# nooelint: oelint.task.network
do_compile[network] = "1"

do_compile() {
    export GOARCH=${TARGET_GOARCH}
    export CGO_ENABLED="1"
    export CGO_CFLAGS="${CFLAGS} --sysroot=${STAGING_DIR_TARGET}"
    export CGO_LDFLAGS="${LDFLAGS} --sysroot=${STAGING_DIR_TARGET}"

    cd ${S}/src/${GO_IMPORT}
    oe_runmake binaries
}

do_install() {
    install -d ${D}${bindir}
    install -m 0744 ${WORKDIR}/git/src/${GO_IMPORT}/bin/regctl ${D}${bindir}/
}

deltask compile_ptest_base

FILES:${PN} += "${bindir}/regctl"
