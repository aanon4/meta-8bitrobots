DESCRIPTION = "SoftAP"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PROVIDES = "softap"
RPROVIDES_${PN} = "softap"

RDEPENDS_${PN} = " iw hostapd dnsmasq"

PR = "r1"
SRC_URI = "file://softap"

S = "${WORKDIR}"

inherit update-rc.d systemd
INITSCRIPT_NAME = "softap"
INITSCRIPT_PARAMS="defaults 30"

do_configure() {
}

do_compile() {
}

do_install() {
  install -d ${D}${sysconfdir}/init.d
  install -m 0755 ${WORKDIR}/softap ${D}${sysconfdir}/init.d/softap
}
