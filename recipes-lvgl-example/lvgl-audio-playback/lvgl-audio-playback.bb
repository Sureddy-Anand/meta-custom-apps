SUMMARY = "LVGL Audio Playback Example Application"
LICENSE = "CLOSED"
#LIC_FILES_CHKSUM = "file://LICENSE;md5=<checksum>"


SRC_URI = "file://src/main.c \
           file://src/sample-app.c \
           file://src/sample-app.h \
           file://src/sample-player.c \
           file://src/sample-player.h \
           file://src/material/LSAP_btn_pause.c \
           file://src/material/LSAP_btn_play.c \
           file://src/material/LSAP_btn_stop.c \
           file://src/material/LSAP_text1.c \
           file://src/material/LSAP_text2.c \
           file://src/material/LSAP_text3.c \
           file://Makefile \
           file://sample/sample_audio_stereo.aac \
           file://sample/sample_audio_stereo.wav \
           file://sample/sample_audio_stereo.mp3 "

S = "${WORKDIR}/files"
SOUNDS = "${WORKDIR}/sample"

inherit autotools

DEPENDS = "lvgl lv-drivers gstreamer1.0 wayland glib-2.0 "

# Build step using Make
do_compile() {
    # Set up cross-compiler environment variables
     cd ${WORKDIR} 
     export TARGET_CC="${CC}"
     export includedir="${STAGING_INCDIR}"
     #echo "${WORKDIR}"
     #echo "${TARGET_CC}"
     #echo "${includedir}"
    # Run Make
    oe_runmake
}


do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/lvgl_sample_audio_playback  ${D}${bindir}/lvgl_sample_audio_playback 
    install -d ${D}/usr/share/sounds/sample
    install -m 0755 ${SOUNDS}/*  ${D}/usr/share/sounds/sample 
}
