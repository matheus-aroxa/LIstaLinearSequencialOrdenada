import java.util.Scanner;

public class Menu {
    String[] actions = {"1 - Criar uma nova lista", "2 - Inserir", "3 - Remover", "4 - Buscar", "5 - Exibir Lista", "6 - Sair"};
    ListaLinearSequencialOrdenada lista;
    Scanner scanner = new Scanner(System.in);

    public void start(){
        int action = -1;

        do {
            showActions();
            action = scanner.nextInt();
            executeAction(action);
        } while (action != 6);
    }

    private void showActions(){
        for(int i = 0; i < actions.length; i++){
            System.out.println(actions[i]);
        }
    }

    private void executeAction(int action) {
        int value;
        switch (action) {
            case 1:
                int size = -1;
                System.out.println("Criar uma nova lista de tamanho: ");
                size = scanner.nextInt();

                if(size > 0){
                    lista = ListaLinearSequencialOrdenada.newListaLinearSequencialOrdenada(size);
                } else {
                    System.out.println("Não foi possível criar uma lista de tamanho: " + size);
                }
                break;
            case 2:
                System.out.println("Inserir valor: ");
                value = scanner.nextInt();

                if(handleNullLista(lista)) return;
                ListaLinearSequencialOrdenada.insert(lista, value);
                break;
            case 3:
                System.out.println("Remover valor: ");
                value = scanner.nextInt();

                if(handleNullLista(lista)) return;
                ListaLinearSequencialOrdenada.delete(lista, value);
                break;
            case 4:
                System.out.println("Buscar valor: ");
                value = scanner.nextInt();

                if(handleNullLista(lista)) return;
                System.out.println("Elemento na posição: " + ListaLinearSequencialOrdenada.find(lista, value));
                break;
            case 5:
                System.out.println("Exibindo Lista: ");
                if(handleNullLista(lista)) return;
                ListaLinearSequencialOrdenada.print(lista);
                break;
            case 6:
                System.out.println("Encerrando . . .");
                break;
            default:
                System.out.println("Ação inválida");
        }
    }

    private boolean handleNullLista(ListaLinearSequencialOrdenada lista) {
        if(lista == null){
            System.out.println("Não é póssivel realizar a operação, pois a lista não foi devidamente inicializada");
            return true;
        }
        return false;
    }

}
