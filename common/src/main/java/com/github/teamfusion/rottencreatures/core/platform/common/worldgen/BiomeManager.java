package com.github.teamfusion.rottencreatures.core.platform.common.worldgen;

import com.google.common.collect.Lists;
import dev.architectury.injectables.annotations.ExpectPlatform;

import java.util.List;
import java.util.function.BiConsumer;

public class BiomeManager {
    private static final List<BiConsumer<BiomeWriter, BiomeContext>> FEATURES = Lists.newArrayList();

    public static final BiomeManager INSTANCE = new BiomeManager();

    @ExpectPlatform
    public static void setup() {
        throw new AssertionError();
    }

    public void register(BiomeWriter writer) {
        FEATURES.forEach(writer::add);
    }

    public static void add(BiConsumer<BiomeWriter, BiomeContext> modifier) {
        FEATURES.add(modifier);
    }
}