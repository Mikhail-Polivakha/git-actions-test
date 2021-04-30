package com.example.dockermultistagebuild.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {

    private UUID id;
    private String txCode;
    private double sum;
}