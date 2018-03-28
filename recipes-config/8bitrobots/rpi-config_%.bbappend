FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

do_deploy_append() {
    echo "dtoverlay=i2c-gpio,i2c_gpio_sda=19,i2c_gpio_scl=26" >> ${DEPLOYDIR}/bcm2835-bootfiles/config.txt
}
