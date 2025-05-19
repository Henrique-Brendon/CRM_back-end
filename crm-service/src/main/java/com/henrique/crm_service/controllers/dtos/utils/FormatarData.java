package com.henrique.crm_service.controllers.dtos.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FormatarData {
    
    public static String formatarData(Instant data) {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy")
                .withZone(java.time.ZoneId.systemDefault())
                .format(data);
    }

    public static Instant converterParaInstant(String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(data, formatter);
        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant();
    }
}
