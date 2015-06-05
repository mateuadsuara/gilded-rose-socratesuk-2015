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
	public void normalItemWithPositiveQualityUpdates() {
        assertQualityUpdate(createItemWithDefaultSellIn("+5 Dexterity Vest", 5), 4);
        assertQualityUpdate(createItemWithDefaultSellIn("Elixir of the Mongoose", 5), 4);
    }

    @Test
    public void normalItemWithQuality0() {
        assertQualityUpdate(createItemWithDefaultSellIn("+5 Dexterity Vest", 0), 0);
    }

    @Test
    public void agedBrieQualityUpdates(){
        assertQualityUpdate(createItemWithDefaultSellIn("Aged Brie", 5), 6);
    }

    @Test
    public void sulfurasQualityUpdates(){
        assertQualityUpdate(createItemWithDefaultSellIn("Sulfuras, Hand of Ragnaros", 5), 5);
    }
}
