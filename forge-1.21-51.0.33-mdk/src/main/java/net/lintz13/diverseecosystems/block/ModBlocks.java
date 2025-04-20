package net.lintz13.diverseecosystems.block;


import com.mojang.blaze3d.shaders.Uniform;
import net.lintz13.diverseecosystems.DiverseEcosystems;
import net.lintz13.diverseecosystems.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DiverseEcosystems.MOD_ID);

    public static final RegistryObject<Block> ILLUMIRITE_BLOCK = registerBlock("illumirite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops().sound(SoundType.LODESTONE)));

    public static final RegistryObject<Block> RAW_ILLUMIRITE_BLOCK = registerBlock("raw_illumirite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> ILLUMIRITE_ORE = registerBlock("illumirite_ore",
            () -> new DropExperienceBlock(UniformInt.of(0,1),BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> RAW_ILLUMIRITE_DEEPSLATE_ORE = registerBlock("illumirite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(0,2), BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

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
