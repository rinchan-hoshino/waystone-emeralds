# Paid Waystones

Paid Waystones charges vanilla emeralds for Waystones teleports.

Configure teleport costs in `config/waystone_emeralds-common.toml`.

## Config

Default `config/waystone_emeralds-common.toml`:

```toml
[teleports]
enableEmeraldCosts = true
sameDimensionCost = 1
interdimensionalCost = 3
scrollCostMultiplier = 0.0
minCost = 0
maxCost = 3
```

The default config mirrors a simple fixed Waystones XP setup, but charges emerald units instead:

- Same-dimension warp: 1 emerald.
- Interdimensional warp: 3 emeralds.
- Scrolls: no extra emerald cost.
- Emerald blocks count as 9 emeralds and return change as emeralds.

## Requirements

- Minecraft 1.21.1
- NeoForge
- Waystones
- Balm
