package net.lintz13.diverseecosystems.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class RawIllumiriteBlock extends Block {
    public RawIllumiriteBlock(Properties properties) {
        super(Properties.of()
                .mapColor(MapColor.COLOR_ORANGE).requiresCorrectToolForDrops()
                .strength(3.0f, 6.0f)
                .lightLevel(state -> 9)); // 15 is max light level;
    }

    @Override
    public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
        ItemStack stack = player.getMainHandItem();
        return stack.isCorrectToolForDrops(state);
    }

//    @Override
//    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
//        super.animateTick(state, world, pos, random);
//        world.addParticle(ParticleTypes.GLOW,
//                pos.getX() + random.nextDouble(),
//                pos.getY() + random.nextDouble(),
//                pos.getZ() + random.nextDouble(),
//                0.0D, 0.0D, 0.0D);
//    }
}
