package net.lintz13.diverseecosystems.block.custom;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MapColor;

public class IllumiriteOre extends Block {
    public IllumiriteOre(Properties properties) {
        super(Properties.of().requiresCorrectToolForDrops()
                .mapColor(MapColor.METAL)
                .lightLevel(state -> 5));
    }
}
