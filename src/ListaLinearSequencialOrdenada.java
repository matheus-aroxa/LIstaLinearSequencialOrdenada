public class ListaLinearSequencialOrdenada {
    int size;
    int last;
    Node[] arr;

    //retorna uma nova lista linear sequencial ordenada de tamanho definido
    public static ListaLinearSequencialOrdenada newListaLinearSequencialOrdenada(int size){
        ListaLinearSequencialOrdenada lista = new ListaLinearSequencialOrdenada();
        lista.size = size;
        lista.arr = new Node[size];
        lista.last = -1; //ultimo elemento na posição -1 explicita que a lista está vázia

        return lista;
    };

    public static void insert(ListaLinearSequencialOrdenada lista, int key) {
        Node node = new Node(); //cria o nó que com o valor a ser inserido
        node.key = key;

        //verifica se a lista está cheia, caso esteja cria uma nova com o dobro do tamanho
        if(lista.last == lista.size - 1){
            Node[] temp = new Node[lista.size * 2];

            for(int i = 0; i <= lista.last; i++){ // copia os elementos para o temp
                temp[i] = lista.arr[i];
            }

            //atualiza os dados da estrutura
            lista.arr = temp;
            lista.size = lista.size * 2;

            insert(lista, key);

            System.out.println("Lista cheia! Dobrando a capacidade para: " + lista.size);
            return;
        }

        //laço de repetição que insere o node na posição correta
        for(int i = 0; i <= lista.last; i++){
            if(lista.arr[i].key > key){
                moveRight(lista, i);
                lista.arr[i] = node;
                lista.last++;
                return;
            }
        }

        //caso o novo valor seja maior que todos os elementos da lista, adiciona no final e atualiza o tamanho da lista
        lista.arr[++lista.last] = node;
    }

    //desloca todos os elementos do array da posição i até lista.last em 1 casa a direita
    private static void moveRight(ListaLinearSequencialOrdenada lista, int index) {
        for(int i = lista.last + 1; i > index; i--){
            lista.arr[i] = lista.arr[i - 1];
        }
    }

    //printa as chaves de todos os nodes na lista, caso uma posição seja nula ela será exibida como null
    public static void print(ListaLinearSequencialOrdenada lista) {
        for(int i = 0; i < lista.size; i++){
            if(lista.arr[i] == null){
                System.out.printf("NULL ");
            } else {
                System.out.printf("%d ",  lista.arr[i].key);
            }
        }
        System.out.println(); //pula uma linha para melhor organização
    }

    //retorna a posição do node no array, caso não encontre, retorna -1
    public static int find(ListaLinearSequencialOrdenada lista, int key) {
        int index = -1;

        //percorre o array procurando o valor especificado
        for(int i = 0; i <= lista.last; i++){
            if(lista.arr[i].key == key) {
                index = i;
                return index;
            } else if(lista.arr[i].key > key){ //se o elemento for maior que a chave procurada, então o node buscado não está na lista, partindo do principio de que a lista é ordenada
                return index;
            }
        }

        return index;
    }

    //apaga um node da estrutura mantendo a ordenação
    public static void delete(ListaLinearSequencialOrdenada lista, int key) {
        int index = find(lista, key);

        //se o elemento não estiver na lista
        if(index == -1){
            System.out.println("Não foi possivel encontrar o elemento: " + key);
            return;
        }


        moveLeft(lista, index);
        lista.last--;
    }

    //procedimento auxiliar da remoção, desloca os elementos uma posição para a esquerda
    private static void moveLeft(ListaLinearSequencialOrdenada lista, int index){
        for(int i = index; i < lista.size - 1; i++){
            lista.arr[i] = lista.arr[i + 1];
        }
        lista.arr[lista.size - 1] = null;
    }
}
