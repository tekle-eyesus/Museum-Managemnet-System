package class_project;

import java.util.Date;

public class Item {

    private String itemId, itemName, category, date, source, description;

    public Item(String itemId, String itemName, String category, String date, String source, String description) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
        this.date = date;
        this.source = source;
        this.description = description;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public String getSource() {
        return source;
    }

    public String getDescription() {
        return description;
    }
}
