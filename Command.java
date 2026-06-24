public class BancoPessoas {
    public static void main(String[] args) {
        HashMap<Integer, Pessoa> banco = new HashMap<>();
        HashMap<String, Command> comandos = new HashMap<>();

        comandos.put("new", cmdArgs -> {
            int id = Integer.parseInt(cmdArgs[0]);
            String nome = cmdArgs[1];
            banco.put(id, new Pessoa(id, nome));
            System.out.println("Criado: " + banco.get(id));
        });

        comandos.put("delete", cmdArgs -> {
            int id = Integer.parseInt(cmdArgs[0]);
            System.out.println("Removido: " + banco.remove(id));
        });

        comandos.put("get", cmdArgs -> {
            int id = Integer.parseInt(cmdArgs[0]);
            System.out.println(banco.get(id));
        });

        comandos.put("all", cmdArgs -> {
            banco.values().forEach(System.out::println);
        });

        String nome = args[0];
        String[] rest = Arrays.copyOfRange(args, 1, args.length);
        comandos.get(nome).execute(rest);
    }
}
