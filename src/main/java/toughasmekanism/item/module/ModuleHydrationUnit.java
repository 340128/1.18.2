package toughasmekanism.item.module;


import mekanism.api.energy.IEnergyContainer;
import mekanism.api.gear.ICustomModule;

import mekanism.api.gear.IModule;

import mekanism.api.math.FloatingLong;

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
}