package com.allianz.example.model.requestDTO;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class PersonAddressRequestDTO {
    private List<UUID> addressUUIDList;
}
