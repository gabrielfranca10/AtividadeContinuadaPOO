package br.edu.cs.poo.ac.ordem.daos;

import br.edu.cs.poo.ac.ordem.entidades.Cliente;
import java.io.Serializable;

public class ClienteDAO extends DAOGenerico<Cliente> {

    private static final long serialVersionUID = 1L;

    public ClienteDAO() {
        super(Cliente.class);
    }

    public Cliente buscar(String cpfCnpj) {
        return cadastroObjetos.buscar(cpfCnpj);
    }

    public boolean incluir(Cliente cliente) {
        if (buscar(cliente.getCpfCnpj()) == null) {
            cadastroObjetos.incluir(cliente, cliente.getCpfCnpj());
            return true;
        }
        return false;
    }

    public boolean alterar(Cliente cliente) {
        if (buscar(cliente.getCpfCnpj()) != null) {
            cadastroObjetos.alterar(cliente, cliente.getCpfCnpj());
            return true;
        }
        return false;
    }

    public boolean excluir(String cpfCnpj) {
        if (buscar(cpfCnpj) != null) {
            cadastroObjetos.excluir(cpfCnpj);
            return true;
        }
        return false;
    }

    public Cliente[] buscarTodos() {
        Serializable[] ret = cadastroObjetos.buscarTodos();
        if (ret != null && ret.length > 0) {
            Cliente[] retorno = new Cliente[ret.length];
            for (int i = 0; i < ret.length; i++) {
                retorno[i] = (Cliente) ret[i];
            }
            return retorno;
        } else {
            return new Cliente[0];
        }
    }
}
