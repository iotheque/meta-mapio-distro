
do_install:prepend () {
    # Remove old lines
    sed -i '/^MAPIO_OS/d' os-release
    # Add MAPIO OS custom versions
    echo "MAPIO_OS_VERSION=${MAPIO_OS_VERSION}" >> os-release
    echo "MAPIO_OS_VERSION_PRETTY=Mapio OS distribution ${MAPIO_OS_VERSION} (Yocto ${VERSION_CODENAME})" >> os-release
}
