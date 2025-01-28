SUMMARY = "LVGL Audio Playback Example Application"
LICENSE = "CLOSED"
#LIC_FILES_CHKSUM = "file://LICENSE;md5=<checksum>"


SRC_URI = "file://src/main.c \
           file://src/sample-app.c \
           file://src/sample-app.h \
           file://src/sample-player.c \
           file://src/sample-player.h \
           file://src/material/LSVP_btn_pause.c \
           file://src/material/LSVP_btn_play.c \
           file://src/material/LSVP_btn_stop.c \
           file://src/material/LSVP_text.c \
           file://Makefile \
           file://sample/sample_video_with_audio.mp4 "

S = "${WORKDIR}/files"
MOVIES = "${WORKDIR}/sample"
inherit autotools

DEPENDS = "lvgl lv-drivers gstreamer1.0 wayland glib-2.0 "

FILES_${PN} += "/usr/share/movies/sample_video_with_audio.mp4"
FILES_${PN} += "/usr/share/movies"
FILES_${PN} += "/usr/share"

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
    install -m 0755 ${B}/lvgl_sample_video_playback  ${D}${bindir}/lvgl_sample_video_playback 
    install -d ${D}/usr/share/movies
    install -m 0755 ${MOVIES}/*  ${D}/usr/share/movies 
}

#do_install_append() {
#    rm -rf ${D}/usr/share/movies
#    rm -f ${D}/usr/share/movies/sample_video_with_audio.mp4
#    rm -rf ${D}/usr/share
#}

