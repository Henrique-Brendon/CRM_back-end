package com.henrique.crm_service.entities.enums;

public enum EstadoProposta {
    PAGO(0),
    NÃO_PAGO(1),
    EM_AGUARDO(2);

    private int code;

    private EstadoProposta(int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static EstadoProposta valueOf(int code){
        for(EstadoProposta value: EstadoProposta.values()) {
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid SectorType code");
    } 
    
}
