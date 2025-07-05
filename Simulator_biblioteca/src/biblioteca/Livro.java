package biblioteca;

public class Livro {
    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro(String autor, boolean disponivel, String titulo) {
        this.autor = autor;
        this.disponivel = disponivel;
        this.titulo = titulo;
    }
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulor) {
        this.titulo = titulor;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public boolean isDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
      
   
    
    public boolean verificarDisponibilidade(){
        if(this.disponivel!=false){
            return this.disponivel=true;
        }
        return this.disponivel = false;
    }

    public void mostrarLivrosDisponiveis(){
        System.out.println("Titulo do Livro: "+titulo);
        System.out.println("Autor: "+autor);        
        
    }

    
}

