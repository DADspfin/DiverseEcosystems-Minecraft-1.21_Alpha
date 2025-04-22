package net.lintz13.diverseecosystems.block;


import com.mojang.blaze3d.shaders.Uniform;
import net.lintz13.diverseecosystems.DiverseEcosystems;
import net.lintz13.diverseecosystems.block.custom.IllumiriteBlock;
import net.lintz13.diverseecosystems.block.custom.IllumiriteOre;
import net.lintz13.diverseecosystems.block.custom.RawIllumiriteBlock;
import net.lintz13.diverseecosystems.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DiverseEcosystems.MOD_ID);

    public static final RegistryObject<Block> ILLUMIRITE_BLOCK = registerBlock("illumirite_block",
            () -> new IllumiriteBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.LODESTONE)));

    public static final RegistryObject<Block> RAW_ILLUMIRITE_BLOCK = registerBlock("raw_illumirite_block",
            () -> new RawIllumiriteBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> ILLUMIRITE_ORE = registerBlock("illumirite_ore",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).lightLevel(state -> 5).strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RAW_ILLUMIRITE_DEEPSLATE_ORE = registerBlock("illumirite_deepslate_ore",
            () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).lightLevel(state -> 6).strength(6f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
