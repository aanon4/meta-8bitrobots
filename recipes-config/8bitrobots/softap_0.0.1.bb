DESCRIPTION = "SoftAP"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENCE;md5=61287f92700ec1bdf13bc86d8228cd13"

PROVIDES = "softap"
RPROVIDES_${PN} = "softap"

RDEPENDS_${PN} = " iw hostapd dnsmasq"

PR = "r1"
SRC_URI = "file://softap"

do_configure() {
}

do_compile() {
}

do_install() {
  install -d ${D}${sysconfdir}/init.d
  install -m 0755 ${WORKDIR}/softap ${D}${sysconfdir}/init.d/softap
}
