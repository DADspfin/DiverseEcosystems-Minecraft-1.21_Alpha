package net.lintz13.diverseecosystems.item;

import net.lintz13.diverseecosystems.DiverseEcosystems;
import net.lintz13.diverseecosystems.block.ModBlocks;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DiverseEcosystems.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DIVERSE_ECOSYSTEMS_TAB =
            CREATIVE_MODE_TABS.register("diverse_ecosystems_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.ILLUMIRITE_BLOCK.get()))
                    .title(Component.translatable("creativetab.diverseecosystemsmod.diverse_ecosystems"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ILLUMIRITE.get());
                        output.accept(ModItems.RAW_ILLUMIRITE.get());
                        output.accept(ModBlocks.ILLUMIRITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_ILLUMIRITE_BLOCK.get());
                        output.accept(ModBlocks.ILLUMIRITE_ORE.get());
                        output.accept(ModBlocks.RAW_ILLUMIRITE_DEEPSLATE_ORE.get());

                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}