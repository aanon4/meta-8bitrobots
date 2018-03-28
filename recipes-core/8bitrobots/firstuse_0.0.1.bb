DESCRIPTION = "First Use"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PROVIDES = "firstuse"
RPROVIDES_${PN} = "firstuse"

PR = "r1"
SRC_URI = "file://firstuse"

S = "${WORKDIR}"

inherit update-rc.d systemd
INITSCRIPT_NAME = "firstuse"
INITSCRIPT_PARAMS="defaults 01"

do_configure() {
}

do_compile() {
}

do_install() {
  install -d ${D}${sysconfdir}/init.d
  install -m 0755 ${WORKDIR}/firstuse ${D}${sysconfdir}/init.d/firstuse
}
