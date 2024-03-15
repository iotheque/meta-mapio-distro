do_install:append() {
    for config in sshd_config sshd_config_readonly; do
        # This regex force to no the following parameters:
        #  * PasswordAuthentication
        #  * PermitEmptyPasswords
        sed -i -E 's/^[#[:space:]]*(PasswordAuthentication|PermitEmptyPasswords) +[^ ]+$/\1 no/' \
            ${D}${sysconfdir}/ssh/$config
    done
}

