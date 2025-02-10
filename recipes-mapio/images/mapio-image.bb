SUMMARY = "MAPIO image base"
DESCRIPTION = "Install all needed applicative tools for MAPIO gateway"
HOMEPAGE = "https://github.com/iotheque/meta-mapio-distro"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit core-image extrausers

EXTRA_USERS_PARAMS = "\
    usermod -p '${PASSWD_ROOT}' root; \
"

IMAGE_INSTALL:append = " tzdata"

# Network
IMAGE_FEATURES += "\
    ssh-server-openssh \
"
IMAGE_INSTALL += "\
    iptables \
"

# Kernel
IMAGE_INSTALL += "\
    kernel-modules \
    libgpiod \
    libgpiod-tools \
"

### Editors ###
IMAGE_INSTALL += "\
    nano \
    vim \
"

### Docker ###
IMAGE_INSTALL += "\
    docker-moby \
    docker-compose \
"

### Bench ###
IMAGE_INSTALL += "\
    e2fsprogs-resize2fs \
    i2c-tools \
    screen \
    zram \
"

### MAPIO APP ###
IMAGE_INSTALL += "\
    mapio-init \
    mapio-docker-compose \
    mapio-display \
    mapio-gpio-ha \
    mapio-tools \
    mapio-webserver-back \
    mapio-webserver-front \
    python3-hivesense2mqtt \
"
