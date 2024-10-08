package toughasmekanism.item.module;


import java.util.function.Consumer;
import mekanism.api.energy.IEnergyContainer;
import mekanism.api.gear.ICustomModule;
import mekanism.api.gear.IHUDElement;
import mekanism.api.gear.IModule;
import mekanism.api.gear.IModuleHelper;
import mekanism.api.math.FloatingLong;
import mekanism.api.MekanismAPI;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import toughasnails.api.thirst.IThirst;
import toughasnails.api.thirst.ThirstHelper;

public class ModuleHydrationUnit implements ICustomModule<ModuleHydrationUnit> {
    public ModuleHydrationUnit() {
    }

    public void tickServer(IModule<ModuleHydrationUnit> module, Player player) {
        IEnergyContainer energyContainer = module.getEnergyContainer();
        if (energyContainer != null && energyContainer.getEnergy().getValue() > 0L && ThirstHelper.getThirst(player).getThirst() < 20) {
            IThirst thirst = ThirstHelper.getThirst(player);
            thirst.setThirst(thirst.getThirst() + 1);
            module.useEnergy(player, FloatingLong.create(100L));
        }

    }

    public void addHUDElements(IModule<ModuleHydrationUnit> module, Player player, Consumer<IHUDElement> hudElementAdder) {
        if (module.isEnabled()) {
            hudElementAdder.accept(IModuleHelper.INSTANCE.IHUDElement(new ResourceLocation("toughasmekanism:textures/gui/hud/hydration_unit"), 1.0));
        }
    }
}