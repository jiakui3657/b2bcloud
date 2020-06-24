package com.haoxuer.b2bcloud.product.data.enums;

public enum ProductState {
    onSale, sellout,lowerShelf, storage, checking, reject, checked, recycle;
    public String toString() {
        if (this.name().equals("sellout")) {
            return "售罄";
        } else if (this.name().equals("lowerShelf")) {
            return "下架";
        } else if (this.name().equals("onSale")) {
            return "在售";
        } else {
            return this.name().equals("archive") ? "归档" : super.toString();
        }
    }
}
