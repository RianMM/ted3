package Application;

import java.util.Scanner;

public class UI {

    public static void exibeMenu(){
        while (true) {
            System.out.println();
            UI.menu();
            int opcao = Metodos.validaInteiro("Selecione a opção que você deseja: ");
            if (opcao ==1 ){
                Metodos.criarClientes();
            }else if(opcao == 2){
                Metodos.criarContrato();
            }else if (opcao == 3){
                Metodos.lstCliente();
            }else if (opcao == 4){
                Metodos.lstContrato();
            }else if (opcao == 5){
                Metodos.listSinistre();
            }else if (opcao == 6){
                Metodos.lstContratoSemSinistro();
            }else if(opcao == 7 ){
                System.out.println("\nPrograma Sendo Finalizado...");
                break;
            }
            else{
                System.out.println("Informação inválida. Digite Mais Uma Vez!");
            }
        }
    }

    public static void menu(){
        System.out.println("_______ MENU _______");
        System.out.println("1 - Cadastro de clientes            |");
        System.out.println("2 - Cadastro de contratos           |");
        System.out.println("3 - Lista de clientes               |");
        System.out.println("4 - Lista de contratos              |");
        System.out.println("5 - Lista de sinistros              |");
        System.out.println("6 - Lista de contatos sem sinistro  |");
        System.out.println("7 - Sair                            |");
        System.out.println("_________________");
    }
}