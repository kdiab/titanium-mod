package io.barguti.titanium.core.init;

import io.barguti.titanium.Titanium;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;
import java.util.function.Supplier;

import static io.barguti.titanium.Titanium.TITANIUM_TAB;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Titanium.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;
    public static final RegistryObject<Block> TITANIUM_ORE_BLOCK = register("titanium_ore_block",
            () -> new Block(
                            BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_CYAN).strength(3.0f).sound(SoundType.METAL)),
                            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(TITANIUM_TAB))
                    );
    private static <T extends Block> RegistryObject<T> registerBlock(final String name,
                                                    final  Supplier<? extends T> block){
        return BLOCKS.register(name,block);
    }

    private static <T extends Block> RegistryObject<T> register (final String name, final Supplier<? extends T> block,
                                                                 Function<RegistryObject<T>, Supplier<? extends Item>> item){
        RegistryObject<T> obj = registerBlock(name,block);
        ITEMS.register(name,item.apply(obj));
        return obj;
    }
}
