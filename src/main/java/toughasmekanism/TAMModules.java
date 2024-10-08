package toughasmekanism;

import toughasmekanism.item.module.ModuleHydrationUnit;
import toughasmekanism.item.module.ModuleThermoregulatorUnit;
import mekanism.common.registration.impl.ModuleDeferredRegister;
import mekanism.common.registration.impl.ModuleRegistryObject;
import net.minecraft.world.item.Rarity;

public class TAMModules {
    public static final ModuleDeferredRegister MODULES = new ModuleDeferredRegister("toughasmekanism");
    public static final ModuleRegistryObject<ModuleThermoregulatorUnit> THERMOREGULATOR_UNIT;
    public static final ModuleRegistryObject<ModuleHydrationUnit> HYDRATION_UNIT;

    private TAMModules() {
    }

    static {
        THERMOREGULATOR_UNIT = MODULES.register("thermoregulator_unit", ModuleThermoregulatorUnit::new, () -> {
            return TAMItems.THERMOREGULATOR_UNIT.m_5456_();
        }, (builder) -> {
            return builder.maxStackSize(1).rarity(Rarity.UNCOMMON);
        });
        HYDRATION_UNIT = MODULES.register("hydration_unit", ModuleHydrationUnit::new, () -> {
            return TAMItems.HYDRATION_UNIT.m_5456_();
        }, (builder) -> {
            return builder.maxStackSize(1).rarity(Rarity.UNCOMMON);
        });
    }
}
