# nooelint: oelint.vars.pathhardcode
do_install:append() {
    for config in sshd_config sshd_config_readonly; do
        # This regex force to no the following parameters:
        #  * PasswordAuthentication
        #  * PermitEmptyPasswords
        sed -i -E 's/^[#[:space:]]*(PasswordAuthentication|PermitEmptyPasswords) +[^ ]+$/\1 no/' \
            ${D}${sysconfdir}/ssh/$config
    done

    # Configure ssh HostKey path in RW partition
    sed -i 's|#HostKey /etc/ssh|HostKey /usr/local/ssh|' ${D}${sysconfdir}/ssh/sshd_config
}

