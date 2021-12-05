package com.mabraham.minecraft.mods.hello_world;

import com.mabraham.minecraft.mods.hello_world.block.ModBlocks;
import com.mabraham.minecraft.mods.hello_world.item.ModItems;
import lombok.extern.log4j.Log4j2;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(HelloWorldMod.MOD_ID)
@Log4j2
public final class HelloWorldMod
{
    public static final String MOD_ID = "hello_world_mod";

    public HelloWorldMod() {

        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        log.info("HELLO FROM PREINIT");
        log.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
