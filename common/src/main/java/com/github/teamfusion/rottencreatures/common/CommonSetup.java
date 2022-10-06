package com.github.teamfusion.rottencreatures.common;

import com.github.teamfusion.platform.common.MobHandler;
import com.github.teamfusion.platform.common.registry.ItemRegistry;
import com.github.teamfusion.platform.common.worldgen.BiomeModifier;
import com.github.teamfusion.rottencreatures.common.entities.Burned;
import com.github.teamfusion.rottencreatures.common.entities.Frostbitten;
import com.github.teamfusion.rottencreatures.common.entities.Swampy;
import com.github.teamfusion.rottencreatures.common.registries.RCEntityTypes;
import com.github.teamfusion.rottencreatures.common.registries.RCItems;
import com.github.teamfusion.rottencreatures.common.registries.RCPotions;
import com.github.teamfusion.rottencreatures.common.worldgen.WorldGeneration;
import com.github.teamfusion.rottencreatures.mixin.access.PotionBrewingAccessor;

public class CommonSetup {
    public static void common() {
        MobHandler.registerAttributes(RCEntityTypes.BURNED, Burned::createAttributes);
        MobHandler.registerAttributes(RCEntityTypes.FROSTBITTEN, Frostbitten::createAttributes);
        MobHandler.registerAttributes(RCEntityTypes.SWAMPY, Swampy::createAttributes);
    }

    public static void postCommon() {
        WorldGeneration.setup();
        BiomeModifier.setup();
        ItemRegistry.registerFuel(RCItems.MAGMA_ROTTEN_FLESH.get(), 67);
        RCPotions.bootstrap();
    }
}