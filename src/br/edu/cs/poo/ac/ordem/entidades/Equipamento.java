package br.edu.cs.poo.ac.ordem.entidades;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Equipamento {
    private String descricao;
    private TipoEquipamento tipo;
    private boolean ehNovo;
    private double valorEstimado;
}
