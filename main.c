#include <stdio.h>
#include <stdlib.h>

typedef struct no{
    int valor;
    struct no *prox;
}no;

void inserirInicio(no **lista, int num){

    no *aux, *novo = malloc(sizeof(no));

    if (novo){
        novo->valor = num;

        if(*lista == NULL){
            novo->prox = NULL;
            *lista = novo;
        }
        else if(novo->valor < (*lista)->valor){
            novo->prox = *lista;
            *lista = novo;

        }
        else{
            aux = *lista;
            while(aux->prox && novo->valor > aux->prox->valor){
                aux = aux->prox;
            novo->prox = aux->prox;
            aux->prox = novo;
            }
        }
    }
}

void imprimir(no *no){

    while(no){
        printf("%d ", no->valor);
        no = no->prox;
    }
    printf("\n \n");


}


int main()
{
    no *lista = NULL;

    int opcao, valor;

    do{
        printf("1- Inserir \n2- imprimir \n4- sair\n");
        scanf("%d", &opcao);

        switch(opcao){
        case 1:
            printf("Digite um numero para inserir a lista:\n");
            scanf("%d", &valor);
            inserirInicio(&lista, valor);
            break;
        case 2:
            imprimir(lista);
            break;
        case 5:
            break;
        }
    }while(opcao!= 5);


    return 0;
}
