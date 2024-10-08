package toughasmekanism;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class config {
    @EventBusSubscriber(
            modid = "toughasmekanism",
            bus = Bus.MOD
    )
    public class Config {
        private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
        private static final ForgeConfigSpec.LongValue MODULE_THERMOREGULATOR_UNIT_USAGE;
        private static final ForgeConfigSpec.IntValue MAGIC_NUMBER;
        public static final ForgeConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION;
        private static final ForgeConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS;
        static final ForgeConfigSpec SPEC;
        public static Long moduleThermoregulatorUnitUsage;
        public static int magicNumber;
        public static String magicNumberIntroduction;
        public static Set<Item> items;

        public Config() {
        }

        private static boolean validateItemName(Object obj) {
            boolean var10000;
            if (obj instanceof String itemName) {
                if (ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName))) {
                    var10000 = true;
                    return var10000;
                }
            }

            var10000 = false;
            return var10000;
        }

        @SubscribeEvent
        static void onLoad(ModConfigEvent event) {
            moduleThermoregulatorUnitUsage = (Long)MODULE_THERMOREGULATOR_UNIT_USAGE.get();
            magicNumber = (Integer)MAGIC_NUMBER.get();
            magicNumberIntroduction = (String)MAGIC_NUMBER_INTRODUCTION.get();
            items = (Set)((List)ITEM_STRINGS.get()).stream().map((itemName) -> {
                return (Item)ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemName));
            }).collect(Collectors.toSet());
        }

        static {
            MODULE_THERMOREGULATOR_UNIT_USAGE = BUILDER.comment("How much energy the Thermoregulator unit uses per tick").defineInRange("moduleThermoregulatorUnitUsage", 100L, 0L, 1000L);
            MAGIC_NUMBER = BUILDER.comment("A magic number").defineInRange("magicNumber", 42, 0, Integer.MAX_VALUE);
            MAGIC_NUMBER_INTRODUCTION = BUILDER.comment("What you want the introduction message to be for the magic number").define("magicNumberIntroduction", "The magic number is... ");
            ITEM_STRINGS = BUILDER.comment("A list of items to log on common setup.").defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), Config::validateItemName);
            SPEC = BUILDER.build();
        }
    }

}
