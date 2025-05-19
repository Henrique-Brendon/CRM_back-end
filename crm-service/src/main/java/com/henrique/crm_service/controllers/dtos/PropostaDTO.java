package com.henrique.crm_service.controllers.dtos;

import java.math.BigDecimal;

import com.henrique.crm_service.controllers.dtos.utils.FormatarData;
import com.henrique.crm_service.entities.Proposta;

import java.text.NumberFormat;
import java.util.Locale;

public record PropostaDTO(
    String dataDeProposta,
    String valor,
    String parcelas,
    String nomeVendedor,
    String nomeCliente,
    String cpfCliente,
    String estadoProposta
) {
    public static PropostaDTO fromProposta(Proposta proposta) {
        return new PropostaDTO(
            FormatarData.formatarData(proposta.getDataDeProposta()),
            formatarMoeda(proposta.getValor()),
            formatarParcelas(proposta.getParcelas()),
            proposta.getCliente().getVendedor().getNome(),
            proposta.getCliente().getNome(),
            proposta.getCliente().getCpf(),
            proposta.getEstadoProposta().name()
        );
    }

    private static String formatarMoeda(BigDecimal valor) {
        NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return formatador.format(valor);
    }

    private static String formatarParcelas(String parcelasStr) {
        try {
            String[] partes = parcelasStr.split("X");
            if (partes.length != 2) return parcelasStr;

            String quantidade = partes[0].trim();
            String valorStr = partes[1].trim();

            BigDecimal valor = new BigDecimal(valorStr.replace(",", "."));
            String valorFormatado = formatarMoeda(valor);

            valorFormatado = valorFormatado.replace("R$ ", "").replace("R$", "").trim();

            return quantidade + " X " + valorFormatado + " R$";
        } catch (Exception e) {
            return parcelasStr;
        }
    }
}
