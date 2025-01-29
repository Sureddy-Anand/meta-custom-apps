SUMMARY = "LVGL Example Application"
LICENSE = "CLOSED"
#LIC_FILES_CHKSUM = "file://LICENSE;md5=<checksum>"


SRC_URI = "file://src/main.c \
           file://src/sample-app.c \
           file://src/sample-app.h \
           file://src/material/LSID_1_btn1.c \
           file://src/material/LSID_1_btn2.c \
           file://src/material/LSID_1_btn3.c \
           file://src/material/LSID_1_btn4.c \
           file://src/material/LSID_1_btn5.c \
           file://src/material/LSID_1_btn6.c \
           file://src/material/LSID_1_btn7.c \
           file://src/material/LSID_1_btn8.c \
           file://src/material/LSID_1_btn_quit.c \
           file://src/material/LSID_1_guide.c \
           file://src/material/LSID_2_btn_back.c \
           file://Makefile \
           file://sample/sample_image_1280x720.bmp \
           file://sample/sample_image_1280x720.png \
           file://sample/sample_image_640x360.bmp \
           file://sample/sample_image_640x360.jpg \
           file://sample/sample_image_1280x720.gif \
           file://sample/sample_image_1280x720.sjpg \
           file://sample/sample_image_640x360.gif \
           file://sample/sample_image_640x360.png"
#file://0001-second-commit.patch" --Uncomment this to apply patch

#PATCHES = "file://0001-second-commit.patch" -- Uncomment this to apply patch

S = "${WORKDIR}"
IMAGES = "${WORKDIR}/sample"
inherit autotools

DEPENDS = "lvgl lv-drivers "


FILES_${PN} += "/usr/share/images"

# Build step using Make
do_compile() {
    # Set up cross-compiler environment variables
     cd ${WORKDIR} 
     export TARGET_CC="${CC}"
     export includedir="${STAGING_INCDIR}"
     echo "${WORKDIR}"
     echo "${TARGET_CC}"
     echo "${includedir}"
    # Run Make
    oe_runmake
}


do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/lvgl_sample_img_display  ${D}${bindir}/lvgl_sample_img_display 
    install -d ${D}/usr/share/images
    install -m 0755 ${IMAGES}/*  ${D}/usr/share/images 
}
