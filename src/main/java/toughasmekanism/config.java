package toughasmekanism;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = ToughAsMekanism.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.LongValue MODULE_THERMOREGULATOR_UNIT_USAGE;
    public static final ForgeConfigSpec.LongValue MODULE_HYDRATION_UNIT_USAGE;
    public static final ForgeConfigSpec.IntValue MODULE_HYDRATION_UNIT_GIVES_THIRST;

    static {
        MODULE_THERMOREGULATOR_UNIT_USAGE = BUILDER
                .comment("How much energy the Thermoregulator unit uses per tick")
                .defineInRange("moduleThermoregulatorUnitUsage", 100L, 0L, 1000L);

        MODULE_HYDRATION_UNIT_USAGE = BUILDER
                .comment("How much energy the Hydration unit uses per tick")
                .defineInRange("moduleHydrationUnitUsage", 50L, 0L, 1000L);

        MODULE_HYDRATION_UNIT_GIVES_THIRST = BUILDER
                .comment("How much thirst the Hydration unit gives per tick")
                .defineInRange("moduleHydrationUnitGivesThirst", 1, 0, 20);
    }

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public static Long moduleThermoregulatorUnitUsage;
    public static Long moduleHydrationUnitUsage;
    public static Integer moduleHydrationUnitGivesThirst;

    @SubscribeEvent
    public static void onLoad(final ModConfigEvent.Loading event) {
        moduleThermoregulatorUnitUsage = MODULE_THERMOREGULATOR_UNIT_USAGE.get();
        moduleHydrationUnitUsage = MODULE_HYDRATION_UNIT_USAGE.get();
        moduleHydrationUnitGivesThirst = MODULE_HYDRATION_UNIT_GIVES_THIRST.get();
    }

    @SubscribeEvent
    public static void onReload(final ModConfigEvent.Reloading event) {
        moduleThermoregulatorUnitUsage = MODULE_THERMOREGULATOR_UNIT_USAGE.get();
        moduleHydrationUnitUsage = MODULE_HYDRATION_UNIT_USAGE.get();
        moduleHydrationUnitGivesThirst = MODULE_HYDRATION_UNIT_GIVES_THIRST.get();
    }

    public static void loadConfig(ForgeConfigSpec spec, String path) {
        final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
        configData.load();
        spec.setConfig(configData);
    }
}