package io.barguti.titanium.core.init;

import io.barguti.titanium.Titanium;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Titanium.MOD_ID);
    public static final RegistryObject<Item> RAW_TITANIUM_ITEM = ITEMS.register("raw_titanium_item",
            () ->
                    new Item(
                            new Item.Properties()
                                    .tab(Titanium.TITANIUM_TAB)
                                    .rarity(Rarity.COMMON)
                    )
    );
}
