Inspectron README
====
This yocto was branched from the yocto source on the fido branch. This branch is targeted at the Inspectron imx6 devices. 

### Requirements

* Build machine must be ubuntu 16.04 or earlier. Will **not** work on ubuntu 18.04 or greater
* Suggested 8GB RAM or more
* Suggested minimum 120GB of Storage space
* Suggested PC with 4 cores or more

### Setup
1) install the required packages as suggested by the yocto organization
``` bash
sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib \
     build-essential chrpath socat cpio python3 python3-pip python3-pexpect \
     xz-utils debianutils iputils-ping python3-git python3-jinja2 libegl1-mesa libsdl1.2-dev \
     pylint3 xterm
```
2) clone yocto_imx from Inspectron
``` bash
git clone git@github.com:Inspectron/yocto_imx.git
```

3) clone the meta layers (qt5, inspectron, openembedded)
``` bash
cd yocto_imx
git clone -b fido git://git.yoctoproject.org/meta-fsl-arm
git clone -b fido git@github.com:SolidRun/meta-solidrun-arm-imx6.git
git clone git@github.com:Inspectron/meta-inspectron.git
git clone git@github.com:Inspectron/meta-qt5.git
git clone git@github.com:Inspectron/meta-openembedded.git
git clone git@github.com:Inspectron/meta-murata-wireless.git
```

### Building
1) run oe setup script. This will create build/conf/local.conf & build/conf/bblayers.conf if they do not exist. You should run this before building
``` bash
source oe-init-build-env
```

2) build the image
This should take a while
``` bash
bitbake inspectron-base-image
```

3) (optional) build the sdk. This should install the sdk to /opt/poky/...
``` bash
bitbake inspectron-base-sdk
```

### Images
After a successful build, the images will be in build/tmp/deploy/images/inspectron-itb200. There will files for all your builds, with a symlink to the most recent sdcard image.

### Helpful commands
Most of these are available in the [BitBake command Cheat Sheet](https://www.openembedded.org/wiki/Bitbake_cheat_sheet) .

#### build a package
``` bash
bitbake <pkg-name>
```

#### clean a package
``` bash
bitbake -c clean <pkg-name>
```


### References 
* [Solidrun Yocto for i.MX6](https://solidrun.atlassian.net/wiki/spaces/developer/pages/287277558/Yocto+for+i.MX6)
* [Yocto Manual - supported Distros](https://www.yoctoproject.org/docs/2.4.1/ref-manual/ref-manual.html#detailed-supported-distros)
* [Yocto Manua - Quick Start](https://www.yoctoproject.org/docs/2.4.1/yocto-project-qs/yocto-project-qs.html)
* [BitBake file Cheat Sheet](https://elinux.org/Bitbake_Cheat_Sheet)
* [BitBake command Cheat Sheet](https://www.openembedded.org/wiki/Bitbake_cheat_sheet)

---
---
Poky README
---
---

Poky
====

Poky is an integration of various components to form a complete prepackaged
build system and development environment. It features support for building
customised embedded device style images. There are reference demo images
featuring a X11/Matchbox/GTK themed UI called Sato. The system supports
cross-architecture application development using QEMU emulation and a
standalone toolchain and SDK with IDE integration.

Additional information on the specifics of hardware that Poky supports
is available in README.hardware. Further hardware support can easily be added
in the form of layers which extend the systems capabilities in a modular way.

As an integration layer Poky consists of several upstream projects such as 
BitBake, OpenEmbedded-Core, Yocto documentation and various sources of information 
e.g. for the hardware support. Poky is in turn a component of the Yocto Project.

The Yocto Project has extensive documentation about the system including a 
reference manual which can be found at:
    http://yoctoproject.org/documentation

OpenEmbedded-Core is a layer containing the core metadata for current versions
of OpenEmbedded. It is distro-less (can build a functional image with
DISTRO = "nodistro") and contains only emulated machine support.

For information about OpenEmbedded, see the OpenEmbedded website:
    http://www.openembedded.org/

Where to Send Patches
=====================

As Poky is an integration repository (built using a tool called combo-layer),
patches against the various components should be sent to their respective
upstreams:

bitbake:
    Git repository: http://git.openembedded.org/bitbake/
    Mailing list: bitbake-devel@lists.openembedded.org

documentation:
    Git repository: http://git.yoctoproject.org/cgit/cgit.cgi/yocto-docs/
    Mailing list: yocto@yoctoproject.org

meta-yocto(-bsp):
    Git repository: http://git.yoctoproject.org/cgit/cgit.cgi/meta-yocto(-bsp)
    Mailing list: poky@yoctoproject.org

Everything else should be sent to the OpenEmbedded Core mailing list.  If in
doubt, check the oe-core git repository for the content you intend to modify.
Before sending, be sure the patches apply cleanly to the current oe-core git
repository.

    Git repository: http://git.openembedded.org/openembedded-core/
    Mailing list: openembedded-core@lists.openembedded.org

Note: The scripts directory should be treated with extra care as it is a mix of
oe-core and poky-specific files.
