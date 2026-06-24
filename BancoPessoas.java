import java.util.Arrays;
import java.util.HashMap;

public class BancoPessoas {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java BancoPessoas <comando> [<args>]");
            System.out.println("Comandos disponíveis: new <id> <nome> | delete <id> | all | get <id>");
            return;
        }

        HashMap<Integer, Pessoa> banco = new HashMap<>();

        HashMap<String, Command> comandos = new HashMap<>();
        comandos.put("new",    new NewCommand(banco));
        comandos.put("delete", new DeleteCommand(banco));
        comandos.put("all",    new AllCommand(banco));
        comandos.put("get",    new GetCommand(banco));

        String nomeComando = args[0].toLowerCase();
        Command comando = comandos.get(nomeComando);

        if (comando == null) {
            System.out.println("Comando desconhecido: " + nomeComando);
            System.out.println("Comandos disponíveis: " + comandos.keySet());
            return;
        }

        String[] cmdArgs = Arrays.copyOfRange(args, 1, args.length);
        comando.execute(cmdArgs);
    }
}
