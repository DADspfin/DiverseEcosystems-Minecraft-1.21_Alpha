package net.lintz13.diverseecosystems.item;

import net.lintz13.diverseecosystems.DiverseEcosystems;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    //register the items in the game (tell the game that you are adding new items)
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DiverseEcosystems.MOD_ID);

    //important! the name below with green text must be written with lowercase letters and/or numbers (w/wo .) only!
    public static final RegistryObject<Item> ILLUMIRITE = ITEMS.register("illumirite", () ->
            new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_ILLUMIRITE = ITEMS.register("raw_illumirite",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
