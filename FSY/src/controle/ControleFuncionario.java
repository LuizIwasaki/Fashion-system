/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Funcionario;

/**
 *
 * @author Eduardo Faustino
 */
public class ControleFuncionario {

    public ControleFuncionario() {
    }

    private static Funcionario usuarioLogado;

    public static Funcionario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Funcionario usuarioLogado) {
        ControleFuncionario.usuarioLogado = usuarioLogado;
    }

    public static boolean isUsuarioLogado() {
        return (usuarioLogado != null);
    }

    public static boolean loginUsuario(String email, String senha) {
        List<Funcionario> listaFuncionarios;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Funcionario> consultaFuncionario;

        consultaFuncionario = Gerente.createNamedQuery("Funcionario.logar", Funcionario.class);

        consultaFuncionario.setParameter("emailPesquisa", email);
        consultaFuncionario.setParameter("senhaPesquisa", senha);

        listaFuncionarios = consultaFuncionario.getResultList();
        if (listaFuncionarios.isEmpty()) {
            return false;
        } else {
            ControleFuncionario.setUsuarioLogado(listaFuncionarios.get(0));
            return true;

        }

    }

    public static void logout() {
        ControleFuncionario.setUsuarioLogado(null);
    }

    public void salvar(Funcionario f) {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();

        gerente.getTransaction().begin();

        gerente.persist(f);

        gerente.getTransaction().commit();

        gerente.close();

    }

    public void alterar(Funcionario f) {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();;

        gerente.getTransaction().begin();

        gerente.merge(f);

        gerente.getTransaction().commit();

        gerente.close();

    }

    public void excluir(Funcionario f) {
        EntityManager gerente = util.FabricaEntidades.getGerenteEntidade();;

        f = gerente.find(Funcionario.class, f.getId());

        gerente.getTransaction().begin();

        gerente.remove(f);

        gerente.getTransaction().commit();

        gerente.close();

    }

    public List<Funcionario> listarTodos() {
        List<Funcionario> listaFuncionarios;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Funcionario> consultaFuncionario;

        consultaFuncionario = Gerente.createNamedQuery("Funcionario.listarTodos", Funcionario.class);

        listaFuncionarios = consultaFuncionario.getResultList();

        return listaFuncionarios;
    }

    public List<Funcionario> listarPorNomePesquisado(String nomePesquisado) {
        List<Funcionario> listaFuncionarios;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Funcionario> consultaFuncionario;

        consultaFuncionario = Gerente.createNamedQuery("Funcionario.listarPorNomePesquisado", Funcionario.class);

        consultaFuncionario.setParameter("nomePesquisa", "%" + nomePesquisado + "%");

        listaFuncionarios = consultaFuncionario.getResultList();

        return listaFuncionarios;
    }

    public Funcionario buscaCPF(String Cpf) {
        List<Funcionario> listaFuncionarios;
        Funcionario funcionarioEncontrado = null;

        EntityManager Gerente = util.FabricaEntidades.getGerenteEntidade();

        TypedQuery<Funcionario> consultaFuncionario;

        consultaFuncionario = Gerente.createNamedQuery("Funcionario.buscaPorCpf", Funcionario.class);

        consultaFuncionario.setParameter("Cpf", Cpf);

        listaFuncionarios = consultaFuncionario.getResultList();

        if (!listaFuncionarios.isEmpty()) {
            funcionarioEncontrado = listaFuncionarios.get(0);
        }

        return funcionarioEncontrado;
    }

}
