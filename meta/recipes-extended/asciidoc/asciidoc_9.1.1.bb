SUMMARY = "Tool for creating HTML, PDF, EPUB, man pages"
DESCRIPTION = "AsciiDoc is a text document format for writing short documents, \
articles, books and UNIX man pages."

HOMEPAGE = "http://asciidoc.org/"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=4e5d1baf6f20559e3bec172226a47e4e \
                    file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263 "

SRC_URI = "git://github.com/asciidoc/asciidoc-py3;protocol=https;branch=9.x"
SRCREV = "08b430eb317c584aa6f02a3c4372035a4d8b92c4"

DEPENDS = "libxml2-native libxslt-native docbook-xml-dtd4-native docbook-xsl-stylesheets-native"

S = "${WORKDIR}/git"

# Tell xmllint where to find the DocBook XML catalogue, because right now it
# opens /etc/xml/catalog on the host. Depends on auto-catalogs.patch
export SGML_CATALOG_FILES="file://${STAGING_ETCDIR_NATIVE}/xml/catalog"

# Not using automake
inherit autotools-brokensep
CLEANBROKEN = "1"

# target and nativesdk needs python3, but for native we can use the host.
RDEPENDS:${PN} += "python3"
RDEPENDS:remove:class-native = "python3"

BBCLASSEXTEND = "native nativesdk"

UPSTREAM_CHECK_GITTAGREGEX = "(?P<pver>(\d+(\.\d+)+))$"