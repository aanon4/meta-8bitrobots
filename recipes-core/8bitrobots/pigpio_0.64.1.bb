DESCRIPTION = "PigPIO"
HOMEPAGE = "http://abyz.me.uk/rpi/pigpio"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://UNLICENCE;md5=61287f92700ec1bdf13bc86d8228cd13"

PROVIDES = "pigpio"
RPROVIDES_${PN} = "pigpio"

SRCREV = "master"
PR = "r64"
SRC_URI = "git://github.com/joan2937/pigpio.git"

S = "${WORKDIR}/git"

TARGET_CC_ARCH += "${LDFLAGS}" 
INSANE_SKIP_${PN}-dev += "dev-elf"

PACKAGES = "${PN} ${PN}-dev ${PN}-dbg"
FILES_${PN} = "${libdir}/*"

do_configure() {
}

do_compile() {
  oe_runmake libpigpio.so STRIP=true CC="${CC}"
}

do_install() {
  install -m 0755 -d ${D}${includedir}
  install -m 0755 -d ${D}${libdir}
  install -m 0644 pigpio.h ${D}${includedir}
  install -m 0755 libpigpio.so ${D}${libdir}
}
