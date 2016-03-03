import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GoldenMasterTest {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String DEXTERITY_VEST = "+5 Dexterity Vest";
    public static final String ELIXIR_OF_THE_MONGOOSE = "Elixir of the Mongoose";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED_MANA_CAKE = "Conjured Mana Cake";

    private List<Item> createSampleInputs() {
        List<Item> items;
        items = new ArrayList<Item>();

        items.add(new Item(DEXTERITY_VEST, 10, 20));
        items.add(new Item(AGED_BRIE, 2, 0));
        items.add(new Item(ELIXIR_OF_THE_MONGOOSE, 5, 7));
        items.add(new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 80));
        items.add(new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 15, 20));
        items.add(new Item(CONJURED_MANA_CAKE, 3, 6));

        items.add(new Item(DEXTERITY_VEST, 50, 50));
        items.add(new Item(AGED_BRIE, 50, 50));
        items.add(new Item(ELIXIR_OF_THE_MONGOOSE, 50, 50));
        items.add(new Item(SULFURAS_HAND_OF_RAGNAROS, 50, 50));
        items.add(new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 50, 50));
        items.add(new Item(CONJURED_MANA_CAKE, 50, 50));

        items.add(new Item(DEXTERITY_VEST, 50, 25));
        items.add(new Item(AGED_BRIE, 50, 25));
        items.add(new Item(ELIXIR_OF_THE_MONGOOSE, 50, 25));
        items.add(new Item(SULFURAS_HAND_OF_RAGNAROS, 50, 25));
        items.add(new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 50, 25));
        items.add(new Item(CONJURED_MANA_CAKE, 50, 25));

        items.add(new Item(DEXTERITY_VEST, 0, 25));
        items.add(new Item(AGED_BRIE, 0, 25));
        items.add(new Item(ELIXIR_OF_THE_MONGOOSE, 0, 25));
        items.add(new Item(SULFURAS_HAND_OF_RAGNAROS, 0, 25));
        items.add(new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 0, 25));
        items.add(new Item(CONJURED_MANA_CAKE, 0, 25));

        items.add(new Item(DEXTERITY_VEST, 25, 0));
        items.add(new Item(AGED_BRIE, 25, 0));
        items.add(new Item(ELIXIR_OF_THE_MONGOOSE, 25, 0));
        items.add(new Item(SULFURAS_HAND_OF_RAGNAROS, 25, 0));
        items.add(new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT, 25, 0));
        items.add(new Item(CONJURED_MANA_CAKE, 25, 0));

        return items;
    }

    @Test
    public void goldenMaster() {
        OldGildedRose oldCode = new OldGildedRose();
        GildedRose newCode = new GildedRose();

        final List<Item> itemsForOldCode = createSampleInputs();
        oldCode.setItems(itemsForOldCode);

        final List<Item> itemsForNewCode = createSampleInputs();
        newCode.setItems(itemsForNewCode);

        String oldResult = "";
        for (int day = 0; day < 55; day++){
            oldCode.updateQuality();

            oldResult += "Day " + day + "\n";
            oldResult += itemsForOldCode.toString()  + "\n";
        }


        String newResult = "";
        for (int day = 0; day < 55; day++){
            newCode.updateQuality();

            newResult += "Day " + day + "\n";
            newResult += itemsForNewCode.toString()  + "\n";
        }

        assertEquals(oldResult, newResult);

    }
}
