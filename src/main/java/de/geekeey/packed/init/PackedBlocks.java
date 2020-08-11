package de.geekeey.packed.init;

import de.geekeey.packed.block.CustomBarrel;
import de.geekeey.packed.block.CustomChest;
import de.geekeey.packed.init.helpers.*;

public class PackedBlocks {

    public static final WoodBlockVariants<ChestTier, CustomChest> CHEST_DEFAULT_TIER;
    public static final WoodBlockVariants<ChestTier, CustomChest> CHEST_TIER_1;
    public static final WoodBlockVariants<ChestTier, CustomChest> CHEST_TIER_2;
    public static final WoodBlockVariants<ChestTier, CustomChest> CHEST_TIER_3;

    public static final WoodBlockVariants<BarrelTier, CustomBarrel> BARREL_DEFAULT_TIER;
    public static final WoodBlockVariants<BarrelTier, CustomBarrel> BARREL_TIER_1;
    public static final WoodBlockVariants<BarrelTier, CustomBarrel> BARREL_TIER_2;
    public static final WoodBlockVariants<BarrelTier, CustomBarrel> BARREL_TIER_3;

    static {
        CHEST_DEFAULT_TIER = new WoodBlockVariants<>(ChestTiers.DEFAULT, ChestTiers::identifier, CustomChest::new);
        CHEST_TIER_1 = new WoodBlockVariants<>(ChestTiers.TIER1, ChestTiers::identifier, CustomChest::new);
        CHEST_TIER_2 = new WoodBlockVariants<>(ChestTiers.TIER2, ChestTiers::identifier, CustomChest::new);
        CHEST_TIER_3 = new WoodBlockVariants<>(ChestTiers.TIER3, ChestTiers::identifier, CustomChest::new);

        BARREL_DEFAULT_TIER = new WoodBlockVariants<>(BarrelTiers.DEFAULT, BarrelTiers::identifier, CustomBarrel::new);
        BARREL_TIER_1 = new WoodBlockVariants<>(BarrelTiers.TIER1, BarrelTiers::identifier, CustomBarrel::new);
        BARREL_TIER_2 = new WoodBlockVariants<>(BarrelTiers.TIER2, BarrelTiers::identifier, CustomBarrel::new);
        BARREL_TIER_3 = new WoodBlockVariants<>(BarrelTiers.TIER3, BarrelTiers::identifier, CustomBarrel::new);
    }

    public static void register() {
        // keep so class will get called and initialized
    }
}
