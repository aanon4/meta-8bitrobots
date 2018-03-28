DESCRIPTION = "8-Bit Robots"
HOMEPAGE = "http://8bitrobots.org"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fbbfbb98dab7dd2a2e481253113a05d7"

PROVIDES = "8bitrobots"
RPROVIDES_${PN} = "8bitrobots"

SRCREV = "master"
PR = "r1"
SRC_URI = "git://github.com/aanon4/8bitrobots.git file://robot"

DEPENDS = " nodejs pigpio firstuse"
RDEPENDS_${PN} = " nodejs pigpio firstuse"

inherit npm-base update-rc.d systemd
INITSCRIPT_NAME = "robot"
INITSCRIPT_PARAMS="defaults 40"

S = "${WORKDIR}/git"

do_configure() {
}

do_compile() {
  oe_runnpm install
}

do_install() {
  cp -R . ${D}/8bitrobots
  mkdir -f ${D}/8bitrobots/saved
  rm -rf ${D}/8bitrobots/node_modules/usage/compiled/*/ia32
  rm -rf ${D}/8bitrobots/node_modules/usage/compiled/*/x64
  rm -f ${D}/8bitrobots/utils/scurve
  rm -rf ${D}/8bitrobots/node_modules/node-gyp/test
  rm -rf ${D}/8bitrobots/node_modules/node-gyp/gyp/samples
  install -d ${D}${sysconfdir}/init.d
  install -m 0755 ${WORKDIR}/robot ${D}${sysconfdir}/init.d/robot
}

FILES_${PN} = "/8bitrobots ${sysconfdir}/init.d/robot"
