package biblioteca;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Simulator {
    public static void main(String[] args) {
        List<Livro> livros = new ArrayList<>();
        Queue<String> fila = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int opcao;
        
        do { 
            System.out.println("=========== BIBLIOTECA MENU ===========");
            System.out.println("1. Cadastrar Livros");
            System.out.println("2. Mostrar Livros");
            System.out.println("3. Verificar Disponibilidade");
            System.out.println("4. Retirar Livro");
            System.out.println("5. Mostrar fila");
            System.out.println("6. Retirar 1° da fila");              
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            System.out.println();
            switch (opcao) {
                case 1: 
                    sc.nextLine(); //consumir dados
                    for (int i = 0; i < 5; i++) {
                        System.out.println("Digite o Título do Livro "+(i+1));
                        String titulo = sc.nextLine();                    
                        System.out.println("Digite o Autor "+(i+1));
                        String autor = sc.nextLine();
                        Livro novoLivro = new Livro(autor, true, titulo); 
                        livros.add(novoLivro);                                               
                    }
                    System.out.println("Livros adicionados com sucesso!"); 
                    break;

                case 2:
                    sc.nextLine(); //consumir dados
                    if (livros.isEmpty()) {
                        System.out.println("Não tem Livros.");
                    } else {
                        for (Livro l : livros) {
                            l.mostrarLivrosDisponiveis();
                        }
                    }
                    break;
                case 3:
                    sc.nextLine(); //consumir dados
                    System.out.print("Digite o Titulo do Livro: ");
                    String titulo = sc.nextLine();
                    Livro livroDisp = buscarLivro(livros, titulo);                  
 
                    if(livroDisp!=null){                        
                        if (livroDisp.verificarDisponibilidade()) {
                            System.out.println("Livro disponível." );
                        } else {
                            System.out.println("Livro Indisponível");
                            System.out.println("Deseja colocar seu nome na fila?");
                            System.out.println("S ou N?");
                            String a = sc.nextLine();
                            if(a.equals("S")||a.equals("s")){
                                System.out.println("Digite seu nome: ");
                                String nome = sc.nextLine();
                                fila.add(nome); 
                            }                                                      
                          
                        }
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                case 4: 
                    sc.nextLine(); //consumir dados                    
                    System.out.println("Digite o Titulo do livro: ");
                    String titulolivro = sc.nextLine();
                    Livro livroDisp2 = buscarLivro(livros, titulolivro);  
                    if(livroDisp2!=null){
                        if(livroDisp2.verificarDisponibilidade()){
                            for(Livro l : livros){
                        if(l.getTitulo().equals(titulolivro) ){
                            l.setDisponivel(false);
                            System.out.println("Livro retirado com sucesso.");
                        }
                        
                    }
                        } else{
                            System.out.println("Livro Indisponível");
                        } 
                    }else{
                        System.out.println("Livro não encontrado.");
                    }                    
                    break;
                case 5: 
                    sc.nextLine(); //consumir dados                  
                    for (String f : fila) {
                        System.out.println(f);
                    }
                    break;
                case 6:
                    sc.nextLine(); //consumir dados 
                    System.out.println(fila.poll()+" retirado da fila com sucesso!");
                    break;
                case 0:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            
        } while (opcao!=0);
        
        sc.close();
    }
     //método auxiliar de buscar livro na lista
        private static Livro buscarLivro(List<Livro>livros, String titulo) {
        for (Livro l : livros) {
            if (l.getTitulo().equals(titulo)) {
                return l;
            }
        }
            return null;
        

        }

}
