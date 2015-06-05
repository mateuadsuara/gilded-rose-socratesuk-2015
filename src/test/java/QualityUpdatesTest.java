import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class QualityUpdatesTest {

    public static final int DEFAULT_SELL_IN = 10;

    private void updateQualityOfItem(Item item) {
        List<Item> items = Arrays.asList(item);
        GildedRose gildedRose = new GildedRose();
        gildedRose.setItems(items);
        gildedRose.updateQuality();
    }

    private void assertQualityUpdate(Item item, int expectedQualityAfterUpdate) {
        updateQualityOfItem(item);
        assertEquals(expectedQualityAfterUpdate, item.getQuality());
    }

    public Item createItemWithDefaultSellIn(String name, int quality) {
        return new Item(name, DEFAULT_SELL_IN, quality);
    }

	@Test
	public void normalItemWithPositiveQualityDegrades() {
        assertQualityUpdate(createItemWithDefaultSellIn("+5 Dexterity Vest", 5), 4);
        assertQualityUpdate(createItemWithDefaultSellIn("Elixir of the Mongoose", 5), 4);
        assertQualityUpdate(createItemWithDefaultSellIn("Elixir of the Mongoose", -1), -1);
    }

    @Test
    public void normalItemWithQuality0() {
        assertQualityUpdate(createItemWithDefaultSellIn("+5 Dexterity Vest", 0), 0);
        assertQualityUpdate(createItemWithDefaultSellIn("Elixir of the Mongoose", 0), 0);
    }

    @Test
    public void agedBrie(){
        assertQualityUpdate(createItemWithDefaultSellIn("Aged Brie", 5), 6);
        assertQualityUpdate(createItemWithDefaultSellIn("Aged Brie", 0), 1);
        assertQualityUpdate(createItemWithDefaultSellIn("Aged Brie", 50), 50);
        assertQualityUpdate(createItemWithDefaultSellIn("Aged Brie", 51), 51);
    }

    @Test
    public void sulfuras(){
        assertQualityUpdate(createItemWithDefaultSellIn("Sulfuras, Hand of Ragnaros", 5), 5);
        assertQualityUpdate(createItemWithDefaultSellIn("Sulfuras, Hand of Ragnaros", 0), 0);
    }

    @Test
    public void backstagePasses(){
        assertQualityUpdate(new Item("Backstage passes to a TAFKAL80ETC concert", 11, 5), 6);
        assertQualityUpdate(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 5), 7);
        assertQualityUpdate(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 5), 7);
        assertQualityUpdate(new Item("Backstage passes to a TAFKAL80ETC concert", 6, 5), 7);
        assertQualityUpdate(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5), 8);
        assertQualityUpdate(new Item("Backstage passes to a TAFKAL80ETC concert", 4, 5), 8);
        assertQualityUpdate(new Item("Backstage passes to a TAFKAL80ETC concert", 1, 5), 8);
    }

    @Test
    public void backstagePassesDropToZeroQualityWhenExpires (){
        assertQualityUpdate(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5), 0);
        assertQualityUpdate(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 5), 0);
    }

}
