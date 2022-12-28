package de.neltopia.bedwars1vs1.util;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import static de.neltopia.bedwars1vs1.BedWars1vs1.blue;
import static de.neltopia.bedwars1vs1.BedWars1vs1.red;

public class Shop {

    public String name = "§bSHOP";
    public String blocks = "§bBaumaterial";
    public String armor = "§eRüstung";
    public String swords = "§cNahkampfwaffen";
    public String picks = "§eSpitzhacken";
    public String bows = "§aSchusswaffen";
    public String food = "§6Nahrung";
    public String special = "§5Spezial";


    public Inventory categoriesMenu(TeamHandler team) {
        Inventory inventory = Bukkit.createInventory(null,6*9,"§bSHOP");
        if (team == red) {
            inventory.setItem(1,new ItemBuilder(Material.RED_CONCRETE,1,this.blocks).build());
        } else if (team == blue) {
            inventory.setItem(1,new ItemBuilder(Material.BLUE_CONCRETE,1,this.blocks).build());
        }
        inventory.setItem(2,new ItemBuilder(Material.CHAINMAIL_CHESTPLATE,1,this.armor).build());
        inventory.setItem(3,new ItemBuilder(Material.IRON_SWORD,1,this.swords).build());
        inventory.setItem(4,new ItemBuilder(Material.IRON_PICKAXE,1,this.picks).build());
        inventory.setItem(5,new ItemBuilder(Material.BOW,1,this.bows).build());
        inventory.setItem(6,new ItemBuilder(Material.COOKED_PORKCHOP,1,this.food).build());
        inventory.setItem(7,new ItemBuilder(Material.ENDER_PEARL,1,this.special).build());
        for (int i = 9; i < 18; i++) {
            inventory.setItem(i, new ItemBuilder(Material.RED_STAINED_GLASS_PANE, 1, " ").build());
        }
        for (int i = 18; i < 27; i++) {
            inventory.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE, 1, " ").build());
        }

        for (int i = 45; i < 54; i++) {
            inventory.setItem(i, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE, 1, " ").build());
        }
        return inventory;
    }

    public Inventory blocksMenu(TeamHandler team) {
        Inventory inventory = categoriesMenu(team);
        if (team == red) {
            inventory.setItem(29,new ItemBuilder(Material.RED_CONCRETE,2,"").build());
        } else if (team == blue) {
            inventory.setItem(29,new ItemBuilder(Material.BLUE_CONCRETE,2,"").build());
        }
        inventory.setItem(31,new ItemBuilder(Material.END_STONE,1,"").build());
        inventory.setItem(33,new ItemBuilder(Material.IRON_BLOCK,1,"").build());

        inventory.setItem(38,new SpawnerMethods().bronze(1));
        inventory.setItem(40,new SpawnerMethods().bronze(7));
        inventory.setItem(42,new SpawnerMethods().iron(3));
        return inventory;
    }

    public Inventory armorMenu(TeamHandler team) {
        ItemStack redHelmet = new ItemBuilder(Material.LEATHER_HELMET, 1, "").build();
        LeatherArmorMeta redHelmetMeta = (LeatherArmorMeta) redHelmet.getItemMeta();
        redHelmetMeta.setColor(Color.RED);
        redHelmet.setItemMeta(redHelmetMeta);

        ItemStack blueHelmet = new ItemBuilder(Material.LEATHER_HELMET, 1, "").build();
        LeatherArmorMeta blueHelmetMeta = (LeatherArmorMeta) blueHelmet.getItemMeta();
        blueHelmetMeta.setColor(Color.BLUE);
        blueHelmet.setItemMeta(blueHelmetMeta);

        ItemStack redLEGGINGS = new ItemBuilder(Material.LEATHER_LEGGINGS, 1, "").build();
        LeatherArmorMeta redLEGGINGSMeta = (LeatherArmorMeta) redLEGGINGS.getItemMeta();
        redLEGGINGSMeta.setColor(Color.RED);
        redLEGGINGS.setItemMeta(redLEGGINGSMeta);

        ItemStack blueLEGGINGS = new ItemBuilder(Material.LEATHER_LEGGINGS, 1, "").build();
        LeatherArmorMeta blueLEGGINGSMeta = (LeatherArmorMeta) blueLEGGINGS.getItemMeta();
        blueLEGGINGSMeta.setColor(Color.BLUE);
        blueLEGGINGS.setItemMeta(blueLEGGINGSMeta);

        ItemStack redBOOTS = new ItemBuilder(Material.LEATHER_BOOTS, 1, "").build();
        LeatherArmorMeta redBOOTSMeta = (LeatherArmorMeta) redBOOTS.getItemMeta();
        redBOOTSMeta.setColor(Color.RED);
        redBOOTS.setItemMeta(redBOOTSMeta);

        ItemStack blueBOOTS = new ItemBuilder(Material.LEATHER_BOOTS, 1, "").build();
        LeatherArmorMeta blueBOOTSMeta = (LeatherArmorMeta) blueBOOTS.getItemMeta();
        blueBOOTSMeta.setColor(Color.BLUE);
        blueBOOTS.setItemMeta(blueBOOTSMeta);


        ItemStack tier1Chest = new ItemBuilder(Material.CHAINMAIL_CHESTPLATE, 1, "§fLevel I Brustplatte").build();
        ItemMeta tier1ChestMeta = tier1Chest.getItemMeta();
        tier1ChestMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        tier1Chest.setItemMeta(tier1ChestMeta);

        ItemStack tier2Chest = new ItemBuilder(Material.CHAINMAIL_CHESTPLATE, 1, "§fLevel II Brustplatte").build();
        ItemMeta tier2ChestMeta = tier2Chest.getItemMeta();
        tier2ChestMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        tier2Chest.setItemMeta(tier2ChestMeta);
        Inventory inventory = categoriesMenu(team);
        if (team == red) {
            inventory.setItem(28,redHelmet);
            inventory.setItem(29,redLEGGINGS);
            inventory.setItem(30,redBOOTS);
        } else if (team == blue) {
            inventory.setItem(28,blueHelmet);
            inventory.setItem(29,blueLEGGINGS);
            inventory.setItem(30,blueBOOTS);
        }
        inventory.setItem(32,tier1Chest);
        inventory.setItem(33,tier2Chest);
        inventory.setItem(34, new ItemBuilder(Material.SHIELD,1,"").build());

        inventory.setItem(37,new SpawnerMethods().bronze(1));
        inventory.setItem(38,new SpawnerMethods().bronze(1));
        inventory.setItem(39,new SpawnerMethods().bronze(1));

        inventory.setItem(41,new SpawnerMethods().iron(1));
        inventory.setItem(42,new SpawnerMethods().iron(3));
        inventory.setItem(43, new SpawnerMethods().gold(2));
        return inventory;
    }

    public Inventory swordsMenu(TeamHandler team) {
        ItemStack knueppel = new ItemBuilder(Material.STICK, 1, "").build();
        ItemMeta knueppelMeta = knueppel.getItemMeta();
        knueppelMeta.setDisplayName("§fKnockback-Stick");
        knueppelMeta.addEnchant(Enchantment.KNOCKBACK, 2, true);
        knueppel.setItemMeta(knueppelMeta);

        ItemStack tier1Sword = new ItemBuilder(Material.GOLDEN_SWORD, 1, "§fLevel I Schwert").build();
        ItemMeta tier1SwordMeta = tier1Sword.getItemMeta();
        tier1SwordMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        tier1Sword.setItemMeta(tier1SwordMeta);

        ItemStack tier2Sword = new ItemBuilder(Material.GOLDEN_SWORD, 1, "§fLevel II Schwert").build();
        ItemMeta tier2SwordMeta = tier2Sword.getItemMeta();
        tier2SwordMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        tier2SwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        tier2Sword.setItemMeta(tier2SwordMeta);

        Inventory inventory = categoriesMenu(team);
        inventory.setItem(29,knueppel);
        inventory.setItem(31,tier1Sword);
        inventory.setItem(33,tier2Sword);

        inventory.setItem(38,new SpawnerMethods().bronze(8));
        inventory.setItem(40,new SpawnerMethods().iron(1));
        inventory.setItem(42,new SpawnerMethods().iron(3));
        return inventory;
    }

    public Inventory picksMenu(TeamHandler team) {
        ItemStack tier1Pick = new ItemBuilder(Material.WOODEN_PICKAXE, 1, "§fLevel I Spitzhacke").build();
        ItemMeta tier1PickMeta = tier1Pick.getItemMeta();
        tier1PickMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        tier1Pick.setItemMeta(tier1PickMeta);

        ItemStack tier2Pick = new ItemBuilder(Material.STONE_PICKAXE, 1, "§fLevel II Spitzhacke").build();
        ItemMeta tier2PickMeta = tier2Pick.getItemMeta();
        tier2PickMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        tier2Pick.setItemMeta(tier2PickMeta);

        ItemStack tier3Pick = new ItemBuilder(Material.IRON_PICKAXE, 1, "§fLevel III Spitzhacke").build();
        ItemMeta tier3PickMeta = tier3Pick.getItemMeta();
        tier3PickMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        tier3Pick.setItemMeta(tier3PickMeta);

        Inventory inventory = categoriesMenu(team);
        inventory.setItem(29,tier1Pick);
        inventory.setItem(31,tier2Pick);
        inventory.setItem(33,tier3Pick);

        inventory.setItem(38,new SpawnerMethods().bronze(4));
        inventory.setItem(40,new SpawnerMethods().iron(2));
        inventory.setItem(42,new SpawnerMethods().gold(1));
        return inventory;
    }

    public Inventory bowsMenu(TeamHandler team) {
        ItemStack tier1Bow = new ItemBuilder(Material.BOW, 1, "§fLevel I Bogen").build();
        ItemMeta tier1BowMeta = tier1Bow.getItemMeta();
        tier1BowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
        tier1Bow.setItemMeta(tier1BowMeta);

        ItemStack tier2Bow = new ItemBuilder(Material.BOW, 1, "§fLevel II Bogen").build();
        ItemMeta tier2BowMeta = tier2Bow.getItemMeta();
        tier2BowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 2, true);
        tier2BowMeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
        tier2Bow.setItemMeta(tier2BowMeta);

        Inventory inventory = categoriesMenu(team);
        inventory.setItem(29,tier1Bow);
        inventory.setItem(31,tier2Bow);
        inventory.setItem(33,new ItemBuilder(Material.ARROW,1,"").build());

        inventory.setItem(38,new SpawnerMethods().gold(3));
        inventory.setItem(40,new SpawnerMethods().gold(7));
        inventory.setItem(42,new SpawnerMethods().bronze(10));
        return inventory;
    }
    public Inventory foodMenu(TeamHandler team) {
        Inventory inventory = categoriesMenu(team);
        inventory.setItem(29,new ItemBuilder(Material.APPLE,1,"").build());
        inventory.setItem(31,new ItemBuilder(Material.COOKED_PORKCHOP,1,"").build());
        inventory.setItem(33,new ItemBuilder(Material.GOLDEN_APPLE,1,"").build());

        inventory.setItem(38,new SpawnerMethods().bronze(1));
        inventory.setItem(40,new SpawnerMethods().bronze(2));
        inventory.setItem(42,new SpawnerMethods().gold(1));
        return inventory;
    }

    public Inventory specialMenu(TeamHandler team) {
        Inventory inventory = categoriesMenu(team);
        inventory.setItem(29,new ItemBuilder(Material.BLAZE_ROD,1,"§fRettungsplattform").build());
        inventory.setItem(33,new ItemBuilder(Material.ENDER_PEARL,1,"").build());

        inventory.setItem(38,new SpawnerMethods().gold(3));
        inventory.setItem(42,new SpawnerMethods().gold(13));
        return inventory;
    }
}
