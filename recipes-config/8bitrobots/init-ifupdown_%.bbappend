FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://interfaces"

do_install_append() {
  install -m 0644 ${WORKDIR}/interfaces ${D}/etc/network
}
