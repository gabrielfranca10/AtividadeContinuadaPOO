package br.edu.cs.poo.ac.ordem.entidades;

import lombok.Data;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
public class OrdemServico {
    private Cliente cliente;
    private PrecoBase precoBase;
    private Notebook notebook;
    private Desktop desktop;
    private LocalDateTime dataHoraAbertura;
    private int prazoEmDias;
    private double valor;

    public LocalDate getDataEstimadaEntrega() {
        if (dataHoraAbertura == null) return null;
        return dataHoraAbertura.toLocalDate().plusDays(prazoEmDias);
    }

    public String getNumero() {
        if (dataHoraAbertura == null || cliente == null || cliente.getCpfCnpj() == null) return null;

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMyyyyddHHmm");
        String dt = dataHoraAbertura.format(fmt);
        String cpfCnpj = cliente.getCpfCnpj().replaceAll("\\D", "");

        if (cpfCnpj.length() > 11) {
            return dt + cpfCnpj;
        } else {
            return dt + "000" + cpfCnpj;
        }
    }
}
