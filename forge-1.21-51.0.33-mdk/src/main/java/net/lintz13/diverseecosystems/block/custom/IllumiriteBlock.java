package net.lintz13.diverseecosystems.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class IllumiriteBlock extends Block {
    public IllumiriteBlock(Properties properties) {
        super(Properties.of().requiresCorrectToolForDrops()
                .mapColor(MapColor.METAL)
                .strength(3.0f, 6.0f)
                .lightLevel(state -> 15)); // 15 is max light level;
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        super.animateTick(state, world, pos, random);
        world.addParticle(ParticleTypes.END_ROD,
                pos.getX() + random.nextDouble(),
                pos.getY() + random.nextDouble(),
                pos.getZ() + random.nextDouble(),
                0.0D, 1.0D, 0.0D);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        super.stepOn(level, pos, state, entity);

        if (!(entity instanceof Player player)) return;

        // Tag key for storing last activation time
        String cooldownKey = "my_mod.illumirite_step_cooldown";
        CompoundTag data = player.getPersistentData();

        long currentTime = level.getGameTime();
        long lastUsedTime = data.getLong(cooldownKey);

        // Cooldown = 1200 ticks (60 seconds)
        if (currentTime - lastUsedTime >= 1200) {
            // Apply effect
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 600, 0));

            // Optional: feedback like a sound or particle
            level.playSound(null, pos, SoundEvents.BEACON_ACTIVATE, SoundSource.BLOCKS, 1.0f, 1.0f);

            // Save the time of activation
            data.putLong(cooldownKey, currentTime);
        }
    }

    @Override
    public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
        ItemStack stack = player.getMainHandItem();
        return stack.isCorrectToolForDrops(state);
    }

}
