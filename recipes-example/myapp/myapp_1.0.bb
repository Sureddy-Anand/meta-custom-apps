# File: meta-my-layer/recipes-example/myapp/myapp_1.0.bb

SUMMARY = "Hello World Example in C"
DESCRIPTION = "A simple Hello World C program"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
SRC_URI = "file://myapp.c"

S = "${WORKDIR}/build"

do_compile() {
    # Compile the C source file using the Yocto environment's cross-compiler
    ${CC} ${CFLAGS} ${LDFLAGS} ${WORKDIR}/myapp.c -o ${S}/myapp
}

do_install() {
    # Install the compiled binary to the target directory
    install -d ${D}${bindir}
    install -m 0755 ${S}/myapp ${D}${bindir}/
}
