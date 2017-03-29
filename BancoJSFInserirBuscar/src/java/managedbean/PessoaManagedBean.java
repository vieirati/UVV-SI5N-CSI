package managedbean;

import dao.PessoaDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Pessoa;
import tools.Gerenciador;

/**
 *
 * @author Vieira
 */
@ManagedBean(name = "PessoaManagedBean")
@SessionScoped
public class PessoaManagedBean {
    private PessoaDAO pDAO = new PessoaDAO();
    private Pessoa p = new Pessoa();
    private List<Pessoa> pessoas;
    public PessoaManagedBean() {
    }

    public PessoaDAO getpDAO() {
        return pDAO;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Pessoa> getPessoas() {
        this.pessoas = pDAO.listarPessoasDAO();
        return pessoas;
    }
    
    
    
    public void setpDAO(PessoaDAO pDAO) {
        this.pDAO = pDAO;
    }

    public Pessoa getP() {
        return p;
    }

    public void setP(Pessoa p) {
        this.p = p;
    }
    
    public String inserirManaged(){
        String resultado_inserir = "";
        if(pDAO.inserirPessoaDAO(p)){
            resultado_inserir = Gerenciador.SUCESSO_INSERCAO;
        }
        else{
            resultado_inserir = Gerenciador.FALHA_INSERCAO;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES, "Falha na INSERCAO dos dados...\nPor favor, verifique se o usuário ja está cadastrado. Caso esteja, entre com outro nome.\n"
                    + "Se o problema persistir, consulte o administrador"));
        }
        return resultado_inserir;
    }
    public String consultarManaged(){
        String resultado_busca = "";
        Pessoa pessoaLida = null;
        pessoaLida = pDAO.consultarPessoaDAO(p);
        
        if(pessoaLida != null){
            p = pessoaLida;
            resultado_busca = Gerenciador.BUSCA_VALIDA;
        }
        else{
            resultado_busca = Gerenciador.BUSCA_INVALIDA;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.FACES_MESSAGES, "Nenhum registro Encontrado...\n Por favor, verifique o nome digitado.\n"
                    + "Se o problema persistir, consulte o administrador"));
        }
        return resultado_busca;
    }
    public String listaPessoasManaged(){
        return Gerenciador.BUSCALISTA_VALIDA;
    }
    
    public String excluirPessoa(Pessoa p){
        String resultado_exclusao = "";
        try {
            pDAO.deletePessoa(p);
            return Gerenciador.SUCESSO_DELETE;
        } catch (Exception e) {
        }
        return Gerenciador.FALHA_DELETE;
    }
    
    public String atualizaPessoa(Pessoa p){
        String resultado_update = "";
        
        return resultado_update;
    }
}
