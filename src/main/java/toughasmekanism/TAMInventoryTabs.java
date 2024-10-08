package toughasmekanism;

import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TAMInventoryTabs {
    public static final DeferredRegister<CreativeModeTab> TABS;
    public static final RegistryObject<CreativeModeTab> TOUGH_AS_MEKANISM_TAB;

    public TAMInventoryTabs() {
    }

    static {
        TABS = DeferredRegister.create(Registries.f_279569_, "toughasmekanism");
        TOUGH_AS_MEKANISM_TAB = TABS.register("tough_as_mekanism", () -> {
            return CreativeModeTab.builder().m_257737_(() -> {
                return new ItemStack((ItemLike)TAMItems.THERMOREGULATOR_UNIT.get());
            }).m_257941_(Component.m_237115_("creativetab.toughasmekanism")).m_257501_((pParameters, pOutput) -> {
                pOutput.m_246342_(new ItemStack((ItemLike)TAMItems.THERMOREGULATOR_UNIT.get()));
                pOutput.m_246342_(new ItemStack((ItemLike)TAMItems.HYDRATION_UNIT.get()));
            }).m_257652_();
        });
    }
}