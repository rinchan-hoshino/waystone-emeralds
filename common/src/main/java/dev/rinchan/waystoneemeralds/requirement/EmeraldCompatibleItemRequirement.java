package dev.rinchan.waystoneemeralds.requirement;

import dev.rinchan.waystoneemeralds.payment.EmeraldPayment;
import net.blay09.mods.waystones.requirement.ItemRequirement;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

/**
 * Preserves Waystones' native item-cost calculation while allowing an emerald
 * requirement to be paid with emerald blocks and returned emerald change.
 */
public final class EmeraldCompatibleItemRequirement extends ItemRequirement {
    private int consumedEmeralds;

    public EmeraldCompatibleItemRequirement() {
        super(ItemStack.EMPTY, 0);
    }

    @Override
    public boolean canAfford(Player player) {
        return isEmeraldRequirement()
            ? EmeraldPayment.canPay(player, getCount())
            : super.canAfford(player);
    }

    @Override
    public void consume(Player player) {
        if (isEmeraldRequirement()) {
            consumedEmeralds = EmeraldPayment.consume(player, getCount());
        } else {
            super.consume(player);
        }
    }

    @Override
    public void rollback(Player player) {
        if (!isEmeraldRequirement()) {
            super.rollback(player);
            return;
        }
        if (consumedEmeralds > 0) {
            EmeraldPayment.giveInventoryEmeralds(player, consumedEmeralds);
            consumedEmeralds = 0;
        }
    }

    private boolean isEmeraldRequirement() {
        return getItemStack().is(Items.EMERALD);
    }
}
