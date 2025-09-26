package br.edu.cs.poo.ac.ordem.daos;

import java.io.Serializable;

import br.edu.cs.poo.ac.ordem.entidades.FechamentoOrdemServico;

public class FechamentoOrdemServicoDAO extends DAOGenerico {

	 public FechamentoOrdemServicoDAO() {
	        super(FechamentoOrdemServico.class);
	    }

	    public FechamentoOrdemServico buscar(String numeroOrdem) {
	        return (FechamentoOrdemServico) cadastroObjetos.buscar(numeroOrdem);
	    }

	    public boolean incluir(FechamentoOrdemServico fechamento) {
	        if (buscar(fechamento.getNumeroOrdemServico()) == null) {
	            cadastroObjetos.incluir(fechamento, fechamento.getNumeroOrdemServico());
	            return true;
	        }
	        return false;
	    }

	    public boolean alterar(FechamentoOrdemServico fechamento) {
	        if (buscar(fechamento.getNumeroOrdemServico()) != null) {
	            cadastroObjetos.alterar(fechamento, fechamento.getNumeroOrdemServico());
	            return true;
	        }
	        return false;
	    }

	    public boolean excluir(String numeroOrdem) {
	        if (buscar(numeroOrdem) != null) {
	            cadastroObjetos.excluir(numeroOrdem);
	            return true;
	        }
	        return false;
	    }

	    public FechamentoOrdemServico[] buscarTodos() {
	        Serializable[] ret = cadastroObjetos.buscarTodos();
	        FechamentoOrdemServico[] retorno;

	        if (ret != null && ret.length > 0) {
	            retorno = new FechamentoOrdemServico[ret.length];
	            for (int i = 0; i < ret.length; i++) {
	                retorno[i] = (FechamentoOrdemServico) ret[i];
	            }
	        } else {
	            retorno = new FechamentoOrdemServico[0];
	        }
	        return retorno;
	    }
}