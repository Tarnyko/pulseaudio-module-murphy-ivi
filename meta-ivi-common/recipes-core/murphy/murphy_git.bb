SUMMARY = "Resource policy daemon"
DESCRIPTION = "Murphy is a Linux resource policy daemon, designed to do \
cross-domain policy decisions in a configurable way. Audio, video and network \
connections are good examples of resources that could be controlled by \
enforcing Murphy decisions."
HOMEPAGE = "https://01.org/murphy"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=14dd3fe4616a4da8dbc1047e96f20670"

# We risk colliding during "make install"
PARALLEL_MAKE = ""

DEPENDS = "attr json-c lua dbus pulseaudio bison flex"

SRCREV = "ec4cc8d550023f87219474ea41bf2a47160f2370"
SRC_URI = "git://github.com/01org/murphy \
           file://0001-compile-with-lua53.patch \
           file://0002-fix-yocto-build.patch \
          "

S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig

EXTRA_OECONF = "--disable-static --enable-gpl --enable-pulse --enable-console"
#LDFLAGS += " -lm"

BBCLASSEXTEND += " native"

FILES_${PN}-dev += "${libdir}/murphy/*.so"
FILES_${PN}-dbg += "${libdir}/murphy/plugins/.debug/*"
