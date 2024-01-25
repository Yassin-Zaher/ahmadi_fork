package com.codewitharjun.fullstackbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParticipationRequest {
    private long iduser;
    private long iddaret;
    private double amount;

}
