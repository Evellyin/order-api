package com.order.project.dto.request;

import com.order.project.interfaces.ValidUUID;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Data
public class OrderRequestDTO {

    @NotBlank(message = "Postal code cannot be blank.")
    private String postalCode;

    @NotBlank(message = "Address cannot be blank.")
    private String address;

    @NotBlank(message = "Restaurant ID cannot be blank.")
    @ValidUUID(message = "Restaurant ID must be a valid UUID.")
    private String restaurantId;

    @NotBlank(message = "User ID cannot be blank.")
    @ValidUUID(message = "User ID must be a valid UUID.")
    private String userId;

    @NotNull(message = "Menu item list cannot be null.")
    @Size(min = 1, message = "Menu item list must have at least one item.")
    private List<String> itemMenuId;

}