package toughasmekanism;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.Event;
import toughasmekanism.TAMInventoryTabs;
import toughasmekanism.TAMItems;
import toughasmekanism.TAMModules;
import mekanism.api.MekanismIMC;
import mekanism.api.providers.IModuleDataProvider;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file

@Mod("toughasmekanism")
public class toughasmekanism {
    public static final String MODID = "toughasmekanism";
    private static final Logger LOGGER = LogUtils.getLogger();

    public toughasmekanism() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::imcQueue);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
        TAMModules.MODULES.register(modEventBus);
        TAMItems.ITEMS.register(modEventBus);
        TAMInventoryTabs.TABS.register(modEventBus);
    }

    private void addCreative(Event event) {
    }

    private void imcQueue(InterModEnqueueEvent event) {
        MekanismIMC.addMekaSuitHelmetModules(new IModuleDataProvider[]{TAMModules.HYDRATION_UNIT});
        MekanismIMC.addMekaSuitBodyarmorModules(new IModuleDataProvider[]{TAMModules.THERMOREGULATOR_UNIT});
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}

