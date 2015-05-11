package todo.sd4mp.dc.ufc.br.mytodolist;

/**
 * Created by 0322850 on 11/05/15.
 */
public class Tarefa {

    private int id;
    private String titulo;
    private String Descricao;
    private String dataCriacao;
    private int status;

    public String getDescricao() {
        return Descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {

        Descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
