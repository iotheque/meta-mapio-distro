DESCRIPTION = "MAPIO image base"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

inherit core-image

# Network
IMAGE_FEATURES += " \
    ssh-server-openssh \
"

# Kernel
IMAGE_INSTALL += " \
    kernel-modules \
"

### Editors ###
IMAGE_INSTALL += " \
    nano \
    vim \
"

### Docker ###
IMAGE_INSTALL += " \
    docker-moby \
    python3-distutils \
    python3-docker-compose \
"

### OTA ###
IMAGE_INSTALL += " \
    libubootenv \
    u-boot \
    rauc \
"
