package com.tom.selling.exception;

import com.tom.selling.artpiece.entity.ArtPieceRequest;
import com.tom.selling.order.entity.order.OrderRequest;
import com.tom.selling.order.entity.orderitem.OrderItemRequest;

public class RequestValidator {
    public static void validateArtPiece(ArtPieceRequest request) {
        if (request == null ||
                request.getName() == null ||
                request.getPrice() == null ||
                request.getCategoryName() == null ||
                request.getImageURLs() == null ||
                request.getDescription() == null
        ) {
            throw new NullPointerException();
        }

        if (request.getName().equals("") ||
                request.getPrice() <= 0f ||
                request.getCategoryName().equals("") ||
                request.getImageURLs().stream().anyMatch(url -> url.equals("")) ||
                request.getDescription().equals("")
        ) throw new IllegalArgumentException();
    }

    public static void validateOrder(OrderRequest request) {
        if (request == null ||
                request.getOrderItems() == null ||
                request.getCustomerEmail() == null
        ) throw new NullPointerException();
        if (request.getCustomerEmail().equals("")) throw new IllegalArgumentException();
        for (var item : request.getOrderItems())
            RequestValidator.validateOrderItem(item);
    }

    public static void validateOrderItem(OrderItemRequest request) {
        if (request == null || request.getItemID() == null)
            throw new NullPointerException();
        if (request.getAmount() <= 0 || request.getItemID() < 0)
            throw new IllegalArgumentException();
    }
}
