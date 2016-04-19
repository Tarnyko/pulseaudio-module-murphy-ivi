SUMMARY = "PulseAudio module for enforcing policy decisions in the audio domain"
DESCRIPTION = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX  \
XXXXXXXXXXXXXXX."

FILESEXTRAPATHS_prepend := ":${THISDIR}/pulseaudio"

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

DEPENDS = "pulseaudio murphy"

SRCREV = "b644e1e4cb1837476792446d0af0727f23b723c3"
SRC_URI = "git://github.com/otcshare/pulseaudio-module-murphy-ivi;protocol=https \
           file://module-combine-sink.pulseaudio6.patch \
           file://module-adapt-to-lua53.patch \
           file://module-adapt-to-pa6rev.patch \
           "

S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig

EXTRA_OECONF = "--disable-static --with-murphyif"

do_configure_prepend() {
       export modlibexecdir="${libdir}/pulse-6.0/modules"
}

do_compile_prepend() {
       ln -sf ${STAGING_INCDIR}/murphy/config.h ${S}/murphy/config.h
}

do_install_append() {
	rm -f ${D}${libdir}/pulse-6.0/modules/*.la
}

FILES_${PN} += "${libdir}/pulse-6.0/modules/*.so"
FILES_${PN}-dbg += "${libdir}/pulse-6.0/modules/.debug/*"
