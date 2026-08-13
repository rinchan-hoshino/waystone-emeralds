package dev.rinchan.waystoneemeralds.client;

import dev.rinchan.waystoneemeralds.requirement.EmeraldCompatibleItemRequirement;
import net.blay09.mods.waystones.client.requirement.RequirementRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;

/** Renders the native item cost for the compatibility requirement subclass. */
public final class EmeraldCompatibleItemRequirementRenderer implements RequirementRenderer<EmeraldCompatibleItemRequirement> {
    @Override
    public void renderWidget(Player player, EmeraldCompatibleItemRequirement requirement, GuiGraphics guiGraphics,
                             int mouseX, int mouseY, float partialTicks, int x, int y) {
        if (requirement.getCount() > 0) {
            var icon = requirement.getItemStack();
            guiGraphics.renderItem(icon, x, y);
            guiGraphics.renderItemDecorations(Minecraft.getInstance().font, icon, x, y,
                requirement.getCount() > 1 ? Integer.toString(requirement.getCount()) : null);
        }
    }

    @Override
    public int getOrder() {
        return 10;
    }

    @Override
    public int getWidth(Player player, EmeraldCompatibleItemRequirement requirement) {
        return requirement.getCount() > 0 ? 18 : 0;
    }
}
