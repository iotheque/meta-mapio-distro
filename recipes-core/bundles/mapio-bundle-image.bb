# nooelint: oelint.var.mandatoryvar
SUMMARY = "MAPIO rauc bunlde base"
DESCRIPTION = "Configure rauc bundle to update mapio image"
HOMEPAGE = "https://github.com/pcurt/meta-mapio-distro"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit bundle

RAUC_BUNDLE_COMPATIBLE ?= "mapio-image"

RAUC_BUNDLE_SLOTS ?= "rootfs"

# nooelint: oelint.vars.specific
RAUC_SLOT_rootfs ?= "mapio-image"

RAUC_KEY_FILE = "${SECRET_PATH}/development-1.key.pem"
RAUC_CERT_FILE = "${SECRET_PATH}/development-1.cert.pem"

