DESCRIPTION = "first bootlogo splash image"
SECTION = "base"
PRIORITY = "required"
PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "lunix|lunix3-4k"

require conf/license/openpli-gplv2.inc

PV = "1.0"
PR = "r0"

S = "${WORKDIR}/"

SRC_URI = " \
	file://${MACHINE}_splash.bmp \
"

SRC_URI_append_lunix = " \
	file://${MACHINE}_splash1.bmp \
	file://${MACHINE}_splash2.bmp \
	file://${MACHINE}_splash3.bmp \
"

inherit deploy

ALLOW_EMPTY_${PN} = "1"

do_deploy() {
	install -m 0644 ${WORKDIR}/*.bmp ${DEPLOYDIR}/
}

addtask deploy before do_build after do_install
