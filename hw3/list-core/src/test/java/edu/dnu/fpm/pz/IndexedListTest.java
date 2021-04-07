package edu.dnu.fpm.pz;

import edu.dnu.fpm.pz.list.core.IndexedList;
import edu.dnu.fpm.pz.list.core.Item;
import edu.dnu.fpm.pz.list.exception.WrongIndex;
import edu.dnu.fpm.pz.list.exception.WrongLength;
import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class IndexedListTest
{
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private IndexedList<Item> list;
    private Item data = new Item(10);

    @Before
    public void prepareData()
    {
        list = new IndexedList<>();
        list.add(data);
    }

    @After
    public void afterTest()
    {
        list = null;
    }

    @Test
    public void testDefaultConstructor()
    {
        //GIVEN
        int expectedLength = 0;
        //WHEN
        list = new IndexedList<Item>();
        int result = list.length();
        //THEN
        Assert.assertNotNull(list);
        assertThat(expectedLength, equalTo(result));
    }
    @Test
    public void testConstructorWithParameter() throws WrongLength
    {
        //GIVEN
        int expectedLength = 0;
        //WHEN
        list = new IndexedList<Item>(15);
        int result = list.length();
        //THEN
        Assert.assertNotNull(list);
        assertThat(expectedLength, equalTo(result));
    }
    @Test
    public void testConstructorWithWrongLength() throws WrongLength
    {
        //GIVEN
        String expectMessage = "Wrong length -10 !!!";
        expectedException.expect(WrongLength.class);
        expectedException.expectMessage(expectMessage);
        //WHEN
        list = new IndexedList<Item>(-10);
        //THEN
    }
    @Test
    public void testAddWithTParameter() throws WrongIndex
    {
        //GIVEN
        int index = 0;
        int expectedLength = 2;
        //WHEN
        list.add(data);
        //THEN
        assertThat(data, equalTo(list.find(index)));
        assertThat(expectedLength, equalTo(list.length()));
    }
    @Test
    public void testRemoveItemWithIndexParameter() throws WrongIndex
    {
        //GIVEN
        int index = 0;
        int expectedLength = 0;
        //WHEN
        Item result = list.removeAt(index);
        //THEN
        assertThat(data, equalTo(result));
        assertThat(expectedLength, equalTo(list.length()));
    }
    @Test
    public void testRemoveItemWithNegativeIndexParameter() throws WrongIndex
    {
        //GIVEN
        int index = -5;
        String expectMessage = "Wrong index -5 !!!";
        expectedException.expect(WrongIndex.class);
        expectedException.expectMessage(expectMessage);
        //WHEN
        list.removeAt(index);
        //THEN
    }
    @Test
    public void testRemoveItemWithOutOfRangeWrongIndex() throws WrongIndex
    {
        //GIVEN
        int index = 100;
        String expectMessage = "Wrong index 100 !!!";
        expectedException.expect(WrongIndex.class);
        expectedException.expectMessage(expectMessage);
        //WHEN
        list.removeAt(index);
        //THEN
    }
    @Test
    public void testGetLength()
    {
        //GIVEN
        int expectedLength = 1;
        //WHEN
        int length = list.length();
        //THEN
        assertThat(expectedLength, equalTo(length));
    }
    @Test
    public void testInsertWithIndexParameter() throws WrongIndex
    {
        //GIVEN
        int expectedLength = 2;
        int index = 0;
        //WHEN
        list.insert(index, data);
        //THEN
        assertThat(data, equalTo(list.find(index)));
        assertThat(expectedLength, equalTo(list.length()));
    }
    @Test
    public void testInsertWithIndexNegativeParameter() throws WrongIndex
    {
        //GIVEN
        String expectMessage = "Wrong index -1 !!!";
        int index = -1;
        expectedException.expect(WrongIndex.class);
        expectedException.expectMessage(expectMessage);
        //WHEN
        list.insert(index, data);
        //THEN
    }
    @Test
    public void testInsertWithOutOfRangeWrongIndex() throws WrongIndex
    {
        //GIVEN
        String expectMessage = "Wrong index 100 !!!";
        int index = 100;
        expectedException.expect(WrongIndex.class);
        expectedException.expectMessage(expectMessage);
        //WHEN
        list.insert(index, data);
        //THEN
    }
    @Test
    public void testGetItemWithIndexParameter() throws WrongIndex
    {
        //GIVEN
        int index = 0;
        //WHEN
        Item item = list.find(index);
        //THEN
        assertThat(data, equalTo(item));
    }
    @Test
    public void testGetItemWithIndexNegativeParameter() throws WrongIndex
    {
        //GIVEN
        String expectMessage = "Wrong index -1 !!!";
        int index = -1;
        expectedException.expect(WrongIndex.class);
        expectedException.expectMessage(expectMessage);
        //WHEN
        Item item = list.find(index);
        //THEN
    }
    @Test
    public void testGetItemWithIndexOutOfRangeWrongIndex() throws WrongIndex
    {
        //GIVEN
        String expectMessage = "Wrong index 100 !!!";
        int index = 100;
        expectedException.expect(WrongIndex.class);
        expectedException.expectMessage(expectMessage);
        //WHEN
        Item item = list.find(index);
        //THEN
    }
}