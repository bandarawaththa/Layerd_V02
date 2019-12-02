package tm;

import javafx.scene.control.Button;

public class ItemTM {
    private String code;
    private String description;
    private int qty;
    private double price;
    private Button btn;

    public ItemTM() {}

    public ItemTM(String code, String description, int qty, double price, Button btn) {
        this.code = code;
        this.description = description;
        this.qty = qty;
        this.price = price;
        this.btn = btn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
}