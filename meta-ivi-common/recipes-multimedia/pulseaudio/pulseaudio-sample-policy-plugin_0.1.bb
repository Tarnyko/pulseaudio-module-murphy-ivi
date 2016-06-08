SUMMARY = "Sample PulseAudio Policy Plugin"
DESCRIPTION = "Sample PulseAudio plugin, discriminating between 3 types of applications"
HOMEPAGE = "http://www.iot.bzh"

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

DEPENDS = "pulseaudio"
RDEPENDS_${PN} = "pulseaudio-server pulseaudio-module-null-sink pulseaudio-module-loopback"

SRCREV = "0cc5408834129e623c3466500622b752c6af1f46"
SRC_URI = "git://github.com/Tarnyko/sample-policy-plugin;protocol=https"

S = "${WORKDIR}/git"

inherit cmake pkgconfig


FILES_${PN} += "${libdir}/pulse-6.0/modules/*"
FILES_${PN}-dbg += "${libdir}/pulse-6.0/modules/.debug/*"
