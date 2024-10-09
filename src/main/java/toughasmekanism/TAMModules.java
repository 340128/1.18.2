package toughasmekanism;

import mekanism.api.gear.ICustomModule;
import mekanism.api.gear.IModuleHelper;
import mekanism.common.registration.impl.ModuleDeferredRegister;
import mekanism.common.registration.impl.ModuleRegistryObject;
import toughasmekanism.item.module.ModuleHydrationUnit;
import toughasmekanism.item.module.ModuleThermoregulatorUnit;

public class TAMModules {
    public static final ModuleDeferredRegister MODULES = new ModuleDeferredRegister("toughasmekanism");
    public static final ModuleRegistryObject<ModuleThermoregulatorUnit> THERMOREGULATOR_UNIT;
    public static final ModuleRegistryObject<ModuleHydrationUnit> HYDRATION_UNIT;

    private TAMModules() {
    }

    static {
        THERMOREGULATOR_UNIT = MODULES.register("thermoregulator_unit", ModuleThermoregulatorUnit::new, TAMItems.THERMOREGULATOR_UNIT::m_5456_, (builder) -> {
            return builder.maxStackSize(1);
        });
        HYDRATION_UNIT = MODULES.register("hydration_unit", ModuleHydrationUnit::new, TAMItems.HYDRATION_UNIT::m_5456_, (builder) -> {
            return builder.maxStackSize(1);
        });
    }
}