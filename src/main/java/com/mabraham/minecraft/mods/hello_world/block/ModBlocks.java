package com.mabraham.minecraft.mods.hello_world.block;

import com.mabraham.minecraft.mods.hello_world.HelloWorldMod;
import com.mabraham.minecraft.mods.hello_world.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public final class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, HelloWorldMod.MOD_ID);

    public static final RegistryObject<Block> TiTANIUM_BLOCK = registerBlock("titanium_block",
            () -> new Block(
                    BlockBehaviour.Properties.of(Material.METAL)
                            .strength(12f)
            )
    );
    public static final RegistryObject<Block> TiTANIUM_OREBLOCK = registerBlock("titanium_ore",
            () -> new Block(
                    BlockBehaviour.Properties.of(Material.METAL)
                            .strength(12f)
            )
    );

    private static <T extends Block>RegistryObject<T> registerBlock(final String name, final Supplier<T> blockSupplier) {
        RegistryObject<T> block = BLOCKS.register(name, blockSupplier);
        registerBlockItem(name, block);
        return block;
    }

    private static <T extends Block> void registerBlockItem(final String name, final RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
    }

    public static void register(final IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
