package dev.rinchan.waystoneemeralds.requirement;

import net.blay09.mods.waystones.api.requirement.RequirementType;
import net.blay09.mods.waystones.requirement.ItemRequirement;
import net.blay09.mods.waystones.requirement.ItemRequirementType;
import net.minecraft.resources.ResourceLocation;

/** Replaces only the instance behind Waystones' native item requirement type. */
public final class EmeraldCompatibleItemRequirementType implements RequirementType<ItemRequirement> {
    @Override
    public ResourceLocation getId() {
        return ItemRequirementType.ID;
    }

    @Override
    public ItemRequirement createInstance() {
        return new EmeraldCompatibleItemRequirement();
    }
}
