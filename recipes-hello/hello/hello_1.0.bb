# vim recipes-hello/hello/hello_1.0.bb

DESCRIPTION = "Simple hello world application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://hello_world.c \
           file://Makefile "

S = "${WORKDIR}"

do_compile() {
    oe_runmake
}

do_install() {
	echo  "workddir: ${S}"
    install -d ${D}${bindir}
    install -m 0755 ${S}/hello ${D}${bindir}/
}
