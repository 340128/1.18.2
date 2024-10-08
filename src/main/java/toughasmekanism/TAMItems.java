package toughasmekanism;

import mekanism.common.item.ItemModule;
import mekanism.common.registration.impl.ItemDeferredRegister;
import mekanism.common.registration.impl.ItemRegistryObject;

public class TAMItems {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister("toughasmekanism");
    public static final ItemRegistryObject<ItemModule> THERMOREGULATOR_UNIT;
    public static final ItemRegistryObject<ItemModule> HYDRATION_UNIT;

    public TAMItems() {
    }

    static {
        THERMOREGULATOR_UNIT = ITEMS.registerModule(TAMModules.THERMOREGULATOR_UNIT);
        HYDRATION_UNIT = ITEMS.registerModule(TAMModules.HYDRATION_UNIT);
    }
}
