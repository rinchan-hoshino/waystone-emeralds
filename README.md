# Paid Waystones

Paid Waystones lets Waystones' native emerald item costs be paid with vanilla emeralds or emerald blocks.

Waystones remains the sole owner of pricing. Configure costs with the native `teleports.warpRequirements` list in `config/waystones-common.toml`, using functions such as `add_item_cost`, `scaled_add_item_cost`, `min_item_cost`, and `max_item_cost`.

When a native Waystones item requirement charges `minecraft:emerald`:

- One emerald block counts as nine emeralds.
- Change is returned as emeralds.
- Teleport rollback refunds the consumed emerald value.

Other Waystones item requirements retain their native behavior. Native item, experience-point, experience-level, and cooldown requirements can be configured together and are all enforced during the same teleport.

## Requirements

- Minecraft 1.21.1
- NeoForge
- Waystones
- Balm
