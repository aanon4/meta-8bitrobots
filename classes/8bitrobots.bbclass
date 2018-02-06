DESCRIPTION = "8-Bit Robots"
HOMEPAGE = "http://8bitrobots.org"

LICENSE = "MIT"

PROVIDES = "8bitrobots"

SRC_URI = "https://github.com/aanon4/8bitrobots.git;name=src"

DEPENDS = " nodejs-native"
RDEPENDS_${PN} = " nodejs"

inherit npm npm-install

S = "${WORKDIR}/8bitrobots-v${PV}"

do_configure() {
}

do_compile() {
  oe_runnpm install
}

do_install() {
  cp -R . ${D}/8bitrobots
}
