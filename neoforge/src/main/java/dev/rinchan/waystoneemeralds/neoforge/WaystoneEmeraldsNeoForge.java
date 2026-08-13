package dev.rinchan.waystoneemeralds.neoforge;

import dev.rinchan.waystoneemeralds.WaystoneEmeralds;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(WaystoneEmeralds.MOD_ID)
public class WaystoneEmeraldsNeoForge {
    public WaystoneEmeraldsNeoForge(IEventBus modBus) {
        WaystoneEmeralds.init();
    }
}
