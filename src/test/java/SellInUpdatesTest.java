import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SellInUpdatesTest {

    private static final int DEFAULT_QUALITY = 5;

    private void updateSellInOfItem(Item item) {
        List<Item> items = Arrays.asList(item);
        GildedRose gildedRose = new GildedRose();
        gildedRose.setItems(items);
        gildedRose.updateQuality();
    }

    public Item createItemWithDefaultQuality(String name, int sellIn) {
        return new Item(name, sellIn, DEFAULT_QUALITY);
    }

    private void assertSellInUpdate(Item item, int expectedSellInAfterUpdate) {
        updateSellInOfItem(item);
        assertEquals(item.getName(), expectedSellInAfterUpdate, item.getSellIn());
    }

    private void assertSellInDecreasingByOne(String name) {
        assertSellInUpdate(createItemWithDefaultQuality(name, 10), 9);
        assertSellInUpdate(createItemWithDefaultQuality(name, 0), -1);
        assertSellInUpdate(createItemWithDefaultQuality(name, -1), -2);
    }

    @Test
    public void allOtherItemsDecreaseByOne(){
        assertSellInDecreasingByOne("+5 Dexterity Vest");
        assertSellInDecreasingByOne("Aged Brie");
        assertSellInDecreasingByOne("Elixir of the Mongoose");
        assertSellInDecreasingByOne("Backstage passes to a TAFKAL80ETC concert");
        assertSellInDecreasingByOne("Conjured Mana Cake");
    }

    @Test
    public void sulfurasNeverHasToBeSold(){
        assertSellInUpdate(createItemWithDefaultQuality("Sulfuras, Hand of Ragnaros", 10), 10);
        assertSellInUpdate(createItemWithDefaultQuality("Sulfuras, Hand of Ragnaros", 0), 0);
        assertSellInUpdate(createItemWithDefaultQuality("Sulfuras, Hand of Ragnaros", -1), -1);
    }
}
