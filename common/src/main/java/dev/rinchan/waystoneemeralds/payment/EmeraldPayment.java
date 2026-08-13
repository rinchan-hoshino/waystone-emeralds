package dev.rinchan.waystoneemeralds.payment;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public final class EmeraldPayment {
    private static final int EMERALD_BLOCK_VALUE = 9;

    private EmeraldPayment() {
    }

    public static boolean canPay(Player player, int emeralds) {
        return emeralds <= 0
            || player.getAbilities().instabuild
            || countInventoryUnits(player) >= emeralds;
    }

    public static int consume(Player player, int emeralds) {
        if (emeralds <= 0 || player.getAbilities().instabuild) {
            return 0;
        }
        if (countInventoryUnits(player) < emeralds) {
            return 0;
        }

        int remaining = emeralds;
        for (int slot = 0; slot < player.getInventory().getContainerSize() && remaining > 0; slot++) {
            ItemStack stack = player.getInventory().getItem(slot);
            if (stack.is(Items.EMERALD)) {
                int used = Math.min(stack.getCount(), remaining);
                stack.shrink(used);
                remaining -= used;
            } else if (stack.is(Items.EMERALD_BLOCK)) {
                int blocks = Math.min(stack.getCount(), (remaining + EMERALD_BLOCK_VALUE - 1) / EMERALD_BLOCK_VALUE);
                int covered = Math.min(remaining, blocks * EMERALD_BLOCK_VALUE);
                int change = blocks * EMERALD_BLOCK_VALUE - covered;
                stack.shrink(blocks);
                remaining -= covered;
                giveInventoryEmeralds(player, change);
            }
        }
        player.getInventory().setChanged();
        return emeralds;
    }

    public static void giveInventoryEmeralds(Player player, int emeralds) {
        if (emeralds <= 0) {
            return;
        }
        ItemStack stack = new ItemStack(Items.EMERALD, emeralds);
        if (!player.getInventory().add(stack)) {
            player.drop(stack, false);
        }
    }

    private static int countInventoryUnits(Player player) {
        int total = 0;
        for (int slot = 0; slot < player.getInventory().getContainerSize(); slot++) {
            ItemStack stack = player.getInventory().getItem(slot);
            if (stack.is(Items.EMERALD)) {
                total += stack.getCount();
            } else if (stack.is(Items.EMERALD_BLOCK)) {
                total += stack.getCount() * EMERALD_BLOCK_VALUE;
            }
        }
        return total;
    }
}
