import java.util.Scanner;

public class LoginSistema {
    public static void main(String[] args) {
        Scanner Entrada = new Scanner(System.in);
        String login;
        String senha;
        System.out.println("Olá, bem-vindo ao banco Itaú");

        System.out.println("Digite o seu login: ");
        login = Entrada.nextLine();
        System.out.println("Digite a sua senha: ");
        senha = Entrada.nextLine();

        Usuario usuarioLogado = getUsuario(login, senha);

        if (usuarioLogado != null) {
            System.out.println("Login bem-sucedido");
           
        } else {
            System.out.println("Login incorreto");
        }

  
        // Interação com o cliente após o login
        if (usuarioLogado != null) {
            System.out.println("Bem-vindo à sua conta, " + usuarioLogado.getLogin() + "!");
            while (true) {
             System.out.println("deseja ver seu saldo ou fazer uma transação?");
             String resposta = Entrada.nextLine();
           
              if(resposta.equals("saldo")){
                 System.out.println("Saldo: R$" + usuarioLogado.getSaldo());
                 
                } else if (resposta.equals("transação")) {
                    System.out.println("Fechando banco");
                    // Adiciona um return ou um System.exit(0) para encerrar o programa
                    return; // Pode ser substituído por System.exit(0);
                } else {
                    System.out.println("Opção inválida ou transação não implementada.");
                }
            
           }
        }
    }

    private static Usuario getUsuario(String login, String senha) {
        // Simulação de um vetor de usuários
        Usuario[] usuarios = {
            new Usuario("Thiago", "senha123", 1500.0),
            new Usuario("usuario2", "senha456", 2000.0)
        };

        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }
}

class Usuario {
    private String login;
    private String senha;
    private double saldo;

    public Usuario(String login, String senha, double saldo) {
        this.login = login;
        this.senha = senha;
        this.saldo = saldo;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public double getSaldo() {
        return saldo;
    }
}
