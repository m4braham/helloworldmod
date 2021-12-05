package com.mabraham.minecraft.mods.hello_world.item;

import com.mabraham.minecraft.mods.hello_world.HelloWorldMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public final class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HelloWorldMod.MOD_ID);

    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register(
            "titanium_ingot", () -> new Item(
                    new Item.Properties()
                            .tab(CreativeModeTab.TAB_MISC)
            )
    );
    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register(
            "titanium_nugget", () -> new Item(
                    new Item.Properties()
                            .tab(CreativeModeTab.TAB_MISC)
            )
    );

    public static void register(final IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
