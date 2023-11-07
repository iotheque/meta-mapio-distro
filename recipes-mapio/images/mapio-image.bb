SUMMARY = "MAPIO image base"
DESCRIPTION = "Install all needed applicative tools for MAPIO gateway"
HOMEPAGE = "https://github.com/pcurt/meta-mapio-distro"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit core-image

IMAGE_INSTALL:append = " tzdata"

# Network
IMAGE_FEATURES += "\
    ssh-server-openssh \
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
    python3-distutils \
    python3-docker-compose \
"

### OTA ###
IMAGE_INSTALL += "\
    libubootenv \
    u-boot \
    rauc \
    e2fsprogs-resize2fs \
"

### Bench ###
IMAGE_INSTALL += "\
    bluez5 \
    iperf3 \
    i2c-tools \
"

### MAPIO APP ###
IMAGE_INSTALL += "\
    mapio-init \
    mapio-docker-compose \
    mapio-display \
    mapio-gpio-ha \
    mapio-setup-wizard \
    python3-pyserial \
    python3-intelhex \
"
