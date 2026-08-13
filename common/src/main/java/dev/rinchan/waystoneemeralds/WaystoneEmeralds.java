package dev.rinchan.waystoneemeralds;

import dev.rinchan.waystoneemeralds.requirement.EmeraldCompatibleItemRequirementType;
import net.blay09.mods.waystones.api.WaystonesAPI;

public final class WaystoneEmeralds {
    public static final String MOD_ID = "waystone_emeralds";

    private WaystoneEmeralds() {
    }

    public static void init() {
        WaystonesAPI.registerRequirementType(new EmeraldCompatibleItemRequirementType());
    }
}
