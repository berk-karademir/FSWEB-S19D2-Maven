package com.workintech.s18d4.dto;

public record AddressResponse(Long id, String name, String street,
                              String description, CustomerResponse customerResponse) {
}
