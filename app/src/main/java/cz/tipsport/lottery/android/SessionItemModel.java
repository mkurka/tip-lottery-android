package cz.tipsport.lottery.android;

import java.math.BigDecimal;

public class SessionItemModel {
    private long clientSessionItemId;
    private String description;
    private String additionalDescription;
    private BigDecimal totalPrice;
    private boolean cancellable;

    public SessionItemModel(long clientSessionItemId, String description, String additionalDescription, BigDecimal totalPrice, boolean cancellable) {
        this.clientSessionItemId = clientSessionItemId;
        this.description = description;
        this.additionalDescription = additionalDescription;
        this.totalPrice = totalPrice;
        this.cancellable = cancellable;
    }

    public long getClientSessionItemId() {
        return clientSessionItemId;
    }

    public String getDescription() {
        return description;
    }

    public String getAdditionalDescription() {
        return additionalDescription;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public boolean isCancellable() {
        return cancellable;
    }
}
