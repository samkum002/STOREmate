package com.store.mate.STOREmate;

// import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
// @AllArgsConstructor
public class CartResponseMessage {

    private String message;
    private String status;

    public CartResponseMessage(String message, String status) {
        this.message = message;
        this.status = status;
    }
}
