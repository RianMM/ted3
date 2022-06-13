package Application;

import Entities.Cliente;
import Entities.Contrato;
import Entities.ContratoEmpresarial;
import Entities.ContratoResidencial;
import Entities.Sinistro;
import Entities.Enum.TipoPessoa;
import Entities.Enum.TipoRamo;
import Entities.Enum.TipoResidencia;
import Entities.Enum.TipoZona;

import java.util.Scanner;

public class Metodos {

    public static int validaInteiro(String txt) {
        int inteiro;
        while (true) {
            try {
                System.out.print(txt);
                inteiro = new Scanner(System.in).nextInt();
                break;
            } catch (Exception exception) {
                System.out.println("O valor não é inteiro. Digite Mais Uma Vez!");
            }
        }
        return inteiro;
    }

    public static long validaLong(String txt) {
        Long inteiro;
        while (true) {
            try {
                System.out.print(txt);
                inteiro = new Scanner(System.in).nextLong();
                break;
            } catch (Exception exception) {
                System.out.println("O valor não é inteiro. Digite Mais Uma Vez!");
            }
        }
        return inteiro;
    }

    public static String validaString(String txt) {
        String texto;
        while (true) {
            try {
                System.out.print(txt);
                texto = new Scanner(System.in).nextLine();
                break;
            } catch (Exception exception) {
                System.out.println("O valor não é uma string. Digite Mais Uma Vez!");
            }
        }
        return texto;
    }

    public static double validaDouble(String txt) {
        double valor;
        while (true) {
            try {
                System.out.print(txt);
                valor = new Scanner(System.in).nextDouble();
                break;
            } catch (Exception exception) {
                System.out.println("O valor não é válido. Digite Mais Uma Vez!");
            }
        }
        return valor;
    }

    public static void criarClientes() {
        TipoPessoa tipopessoa = null;
        System.out.println();
        System.out.println("* Criando o cliente *");
        long doc = Metodos.validaLong("Digite seu documento: ");
        String nome = Metodos.validaString("Digite seu Nome Completo: ").toUpperCase();
        while (true) {
            int tipo = Metodos.validaInteiro("\n1-PF\n2-PJ \nEscolha entre os dois tipos:");
            if (tipo == 1) {
                tipopessoa = TipoPessoa.valueOf("PF");
                break;
            } else if (tipo == 2) {
                tipopessoa = TipoPessoa.valueOf("PJ");
                break;
            } else {
                System.out.println("Informação inválida. Digite Mais Uma Vez!");
            }
        }
        Cliente c1 = new Cliente(doc, nome, tipopessoa);
        Cliente.setUtilClientes(c1);
    }

    public static void criarContrato() {
        TipoRamo tipoRamo = null;
        TipoZona tipoZona = null;
        TipoResidencia tipoResidencia = null;
        System.out.println();
        long doc;
        if (Cliente.getLstClientes().size() > 0) {
            System.out.println("* Criando o contrato *");
            doc = Metodos.validaLong("Digite o documento do cliente : ");
            while (!Cliente.getMapClienteDoc().containsKey(doc)) {
                System.out.println("Cliente não encontrado...");
                doc = Metodos.validaLong("Digite o documento do cliente : ");
            }
            Cliente cliente = Cliente.getMapClienteDoc().get(doc);
            double valor = Metodos.validaDouble("Digite o valor do contrato: ");
            while (true) {
                System.out.println();
                int tipo = Metodos.validaInteiro("\n1-Empresarial\n2-Residencial\nDigite o tipo do contrato: ");
                if (tipo == 1) {
                    int numeroFunc = Metodos.validaInteiro("Digite o número de funcionários: ");
                    int visitas = Metodos.validaInteiro("Digite o número de visitas diárias: ");
                    int ramo = Metodos.validaInteiro("\n1-Loja\n2-fábrica\n3-Agropecuário\nDigite o ramo da empresa: ");
                    while (ramo != 1 && ramo != 2 && ramo != 3) {
                        System.out.println("Ramo inesistente");
                        ramo = Metodos.validaInteiro("\n1-loja\n2-fábrica\n3-Agropecuário\nDigite o ramo da empresa: ");
                    }
                    if (ramo == 1) {
                        tipoRamo = TipoRamo.valueOf("LOJA");
                    } else if (ramo == 2) {
                        tipoRamo = TipoRamo.valueOf("FÁBRICA");
                    } else if (ramo == 3) {
                        tipoRamo = TipoRamo.valueOf("AGROPECUÁRIA");
                    }
                    int SimNao = Metodos.validaInteiro("\n1- Sim\n2- Não\nDeseja adicionar um sinistro: ");
                    while (SimNao != 1 && SimNao != 2) {
                        System.out.println("Informação inválida. Digite Mais Uma Vez!");
                        SimNao = Metodos.validaInteiro("\n1- Sim\n2- Não\nDeseja adicionar um sinistro: ");
                    }
                    if (SimNao == 1) {
                        String data = Metodos.validaString("Digite a data: ");
                        double porcentagem = Metodos.validaDouble("Digite a porcentagem desejada: ");
                        Sinistro sinistro = new Sinistro(data, porcentagem);
                        Sinistro.setListSinistre(sinistro);
                        Contrato contrato = new ContratoEmpresarial(cliente, valor, sinistro, numeroFunc, visitas, tipoRamo);
                        Contrato.setLstContrato(contrato);

                    } else {
                        Sinistro sinistro = null;
                        Contrato contrato = new ContratoEmpresarial(cliente, valor, sinistro, numeroFunc, visitas, tipoRamo);
                        Contrato.setLstContrato(contrato);
                    }
                    break;
                } else if (tipo == 2) {
                    String endereco = Metodos.validaString("Digite seu endereço: ");
                    int zona = Metodos.validaInteiro("\n1-SUBURBANA\n2-RURAL\n3-URBANA\nDigite a zona do seu endereço: ");
                    while (zona != 1 && zona != 2 && zona != 3) {
                        System.out.println("Zona inesistente");
                        zona = Metodos.validaInteiro("\n1-SUBURBANA\n2-RURAL\n3-URBANA\nDigite a zona do seu endereço: ");
                    }
                    if (zona == 1) {
                        tipoZona = TipoZona.valueOf("SUBURBANA");
                    } else if (zona == 2) {
                        tipoZona = TipoZona.valueOf("RURAL");
                    } else if (zona == 3) {
                        tipoZona = TipoZona.valueOf("URBANA");
                    }
                    int residencia = Metodos.validaInteiro("\n1-Casa\n2-Predio\nDigite o tipo da sua residencia: ");
                    while (residencia != 1 && residencia != 2) {
                        System.out.println("Tipo inesistente");
                        residencia = Metodos.validaInteiro("\n1-Casa\n2-Predio\nDigite o tipo da sua residencia: ");
                    }
                    if (residencia == 1) {
                        tipoResidencia = TipoResidencia.valueOf("CASA");
                    } else if (residencia == 2) {
                        tipoResidencia = TipoResidencia.valueOf("PREDIO");
                    }
                    int SimNao = Metodos.validaInteiro("\nDeseja adicionar um sinistro [1-Sim|2-Não]: ");
                    while (SimNao != 1 && SimNao != 2) {
                        System.out.println("Informação inválida. Digite Mais Uma Vez!");
                        SimNao = Metodos.validaInteiro("\nDeseja adicionar um sinistro [1-Sim|2-Não]: ");
                    }
                    if (SimNao == 1) {
                        String data = Metodos.validaString("Digite a data: ");
                        double porcentagem = Metodos.validaDouble("Digite a porcentagem desejada: ");

                        Sinistro sinistro = new Sinistro(data, porcentagem);
                        Sinistro.setListSinistre(sinistro);
                        Contrato contrato = new ContratoResidencial(cliente, valor, sinistro, endereco, tipoZona, tipoResidencia);
                        Contrato.setLstContrato(contrato);

                    } else {
                        Sinistro sinistro = null;
                        Contrato contrato = new ContratoResidencial(cliente, valor, sinistro, endereco, tipoZona, tipoResidencia);
                        Contrato.setLstContrato(contrato);
                    }
                    break;
                } else {
                    System.out.println("Informação inválida. Digite Mais Uma Vez!");
                }
            }
        } else {
            System.out.println("É preciso ter pelo menos um cliente cadastrado!");
        }
    }

    public static void lstCliente() {
        if (Cliente.getLstClientes().size() > 0) {
            for (Cliente c : Cliente.getLstClientes()) {
                System.out.println(c.toString());
            }
        } else {
            System.out.println("Não existem clientes cadastrados! ");
        }
    }

    public static void lstContrato() {
        if (Contrato.getLstContrato().size() > 0) {
            for (Contrato c : Contrato.getLstContrato()) {
                System.out.println(c.toString());
            }
        } else {
            System.out.println("Não existem cadastros de contratos!");
        }
    }

    public static void listSinistre() {
        if (Sinistro.getListSinistre().size() > 0) {
            for (Sinistro s : Sinistro.getListSinistre()) {
                System.out.println(s.toString());
            }
        } else {
            System.out.println("Não existem cadastros de contratos com sinistro! ");
        }
    }
    public static void lstContratoSemSinistro () {
            for (Contrato c : Contrato.getLstContrato()) {
                if (c.getSinistro() == null)
                    System.out.println(c.toString());
            }
        }
    }

