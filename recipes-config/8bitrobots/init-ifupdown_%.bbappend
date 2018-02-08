FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://etc/network/interfaces"

do_install_append() {
  install -m 0644 ${WORKDIR}/etc/network/interfaces ${D}/etc/network
}
