package org.example.janitripractice.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * Create - Add a new item
     *
     * @param item An object item
     * @return The item object saved
     */
    @PostMapping("/api/v1/item")
    public Item createItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }

    /**
     * Read - Get one item
     *
     * @param id The id of the item
     * @return An Item object full filled
     */
    @GetMapping("/api/v1/item/{id}")
    public Item getItem(@PathVariable("id") final Long id) throws ItemNotFoundException {
        Optional<Item> item = itemService.getItem(id);
        // See here we makes changes for response entity like 200 status code always not custom
        if (item.isPresent()) {
            return item.get();
        } else {
            throw new ItemNotFoundException(id);
        }
    }


    /**
     * Read - Get all items
     *
     * @return - An Iterable object of Item full filled
     */
    @GetMapping("/api/v1/items")
    public Iterable<Item> getAllItems() {
        return itemService.getAllItems();
    }

    /**
     * Update - Update an existing item
     *
     * @param id      - The id of the newItem to update
     * @param newItem - The newItem object updated
     * @return - The item updated
     */
    @PutMapping("/api/v1/item/{id}")
    public Item updateItem(@PathVariable("id") final Long id, @RequestBody Item newItem) throws ItemNotFoundException {
        return itemService.updateItem(id, newItem);
    }



    /**
     * Delete - Delete an item
     *
     * @param id - The id of the item to delete
     */
    @DeleteMapping("/api/v1/item/{id}")
    public void deleteItem(@PathVariable("id") final Long id) {
        itemService.deleteItem(id);
    }
}
