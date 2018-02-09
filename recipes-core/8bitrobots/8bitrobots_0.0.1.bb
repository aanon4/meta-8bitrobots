DESCRIPTION = "8-Bit Robots"
HOMEPAGE = "http://8bitrobots.org"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fbbfbb98dab7dd2a2e481253113a05d7"

PROVIDES = "8bitrobots"
RPROVIDES_${PN} = "8bitrobots"

SRCREV = "master"
PR = "r1"
SRC_URI = "git://github.com/aanon4/8bitrobots.git"

DEPENDS = " nodejs pigpio"
RDEPENDS_${PN} = " nodejs pigpio"

inherit npm-base

S = "${WORKDIR}/git"

do_configure() {
}

do_compile() {
  oe_runnpm install
}

do_install() {
  cp -R . ${D}/8bitrobots
  rm -rf ${D}/8bitrobots/node_modules/usage/compiled/*/ia32
  rm -rf ${D}/8bitrobots/node_modules/usage/compiled/*/x64
  rm -f ${D}/8bitrobots/utils/scurve
  rm -rf ${D}/8bitrobots/node_modules/node-gyp/test
  rm -rf ${D}/8bitrobots/node_modules/node-gyp/gyp/samples
}

FILES_${PN} = "/8bitrobots"
