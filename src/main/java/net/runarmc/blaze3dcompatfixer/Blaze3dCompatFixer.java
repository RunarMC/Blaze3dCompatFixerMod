package net.runarmc.blaze3dcompatfixer;

import com.mojang.blaze3d.platform.GLX;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import java.lang.reflect.Method;


@Mod(Constant.MOD_ID)
public class Blaze3dCompatFixer {
    public Blaze3dCompatFixer() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::check);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void check(final FMLLoadCompleteEvent event)  {
        try {
            Method method = GLX.class.getMethod("isUsingFBO");
            if (method.isAccessible()) {
                Constant.LOGGER.info(String.format("[%s] Patched 'isUsingFBO()Z' successfully.", Constant.MOD_ID));
            } else {
                Constant.LOGGER.info(String.format("[%s] Patched 'isUsingFBO()Z' successfully.", Constant.MOD_ID));
                method.setAccessible(true);
            }
        } catch (NoSuchMethodException e) {
            Constant.LOGGER.fatal(String.format("[%s] Unable to patch 'isUsingFBO()Z'...", Constant.MOD_ID), e);
        }
    }
}
