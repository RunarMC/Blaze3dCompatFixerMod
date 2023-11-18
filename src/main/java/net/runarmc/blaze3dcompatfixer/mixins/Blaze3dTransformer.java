package net.runarmc.blaze3dcompatfixer.mixins;

import com.mojang.blaze3d.platform.GLX;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;

/**
 * Character     Type          Interpretation
 * ------------------------------------------
 * B             byte          signed byte
 * C             char          Unicode character
 * D             double        double-precision floating-point value
 * F             float         single-precision floating-point value
 * I             int           integer
 * J             long          long integer
 * L<classname>; reference     an instance of class
 * S             short         signed short
 * Z             boolean       true or false
 * [             reference     one array dimension
 */

@Mixin(GLX.class)
public class Blaze3dTransformer {
    /*
     * When adding methods on a Mixin without any annotation, Mixin will inject it as-is
     * This is exactly what we want!
     */
    public boolean isUsingFBO() {
        return true;
    }
}
