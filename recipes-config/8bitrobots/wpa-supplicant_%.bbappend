FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://wpa_supplicant.conf"

do_install_append() {
  install -m 0644 ${WORKDIR}/wpa_supplicant.conf ${D}/etc
}
