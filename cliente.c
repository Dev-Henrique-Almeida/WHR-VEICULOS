#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Cliente
{

    char nome_completo[101];
    char cpf[15];
    char telefone[15];
};

struct Cliente pessoa[50];
int prox_cliente;
int codigocliente[50];

void CadastrarCliente()
{

    printf("_______ Cadastrar Cliente _______\n\n");

    printf("Informe o completo do cliente:\n");
    getchar();
    scanf(" %[^\n]", pessoa[prox_cliente].nome_completo);

    printf("Informe o CPF do cliente:\n");
    getchar();
    scanf(" %[^\n]", pessoa[prox_cliente].cpf);

    printf("Informe o telefone do cliente:\n");
    getchar();
    scanf("%[^\n]", pessoa[prox_cliente].telefone);

    system("cls");

    printf("_______ Cliente Cadastrado _______\n\n");
    printf("Nome Completo: %s\n", pessoa[prox_cliente].nome_completo);
    printf("CPF: %s\n", pessoa[prox_cliente].cpf);
    printf("Telefone: %s\n", pessoa[prox_cliente].telefone);
    printf("Codigo do cliente: # %d\n", codigocliente[prox_cliente]);
    printf("__________________________________\n");

    prox_cliente++;
    codigocliente[prox_cliente] = codigocliente[prox_cliente - 1] + 1;

    system("pause");
    system("cls");
}

void ConsultarCliente()
{

    int opcaoCliente;
    int i, j;
    int telaCliente = 0;
    char buscarCpf[15];

    do
    {
        printf("_______ RW Veiculos _______\n\n");
        printf("1 - Visualizar todos os clientes.\n");
        printf("2 - Buscar cliente.\n");
        printf("___________________________\n");

        scanf("%d", &opcaoCliente);

        system("cls");

        if (opcaoCliente == 1)
        {
            printf("_______ Todos os clientes _______\n\n");
            for (i = 0; i < prox_cliente; i++)
            {
                printf("_______ Informa��es do Cliente _______\n\n");
                printf("Nome Completo: %s\n", pessoa[i].nome_completo);
                printf("CPF: %s\n", pessoa[i].cpf);
                printf("Telefone: %s\n", pessoa[i].telefone);
                printf("Codigo do cliente: # %d\n\n", codigocliente[i]);
            }
        }
        if (opcaoCliente == 2)
        {

            printf("Informe o CPF do cliente:");
            getchar();
            scanf("%[^\n]", buscarCpf);

            system("cls");

            for (j = 0; j < prox_cliente; j++)
            {

                if (strcmp(buscarCpf, pessoa[j].cpf) == 0)
                {
                    telaCliente = 1;
                    printf("_______ Informa��es do Cliente _______\n\n");
                    printf("Nome Completo: %s\n", pessoa[j].nome_completo);
                    printf("CPF: %s\n", pessoa[j].cpf);
                    printf("Telefone: %s\n", pessoa[j].telefone);
                    printf("Codigo do cliente: # %d\n", codigocliente[j]);
                }
            }
            if (telaCliente == 0)
            {
                printf("_______ RW Veiculos _______\n\n");
                printf("CPF nao encontrado.\n\n");
            }
        }

        printf("\n\n\n3 - Visualizar novo cliente.\n");
        printf("4 - Voltar para o menu anterior.\n");
        printf("___________________________\n");

        scanf("%d", &opcaoCliente);

        system("cls");

    } while (opcaoCliente != 4);

    system("cls");
}

void iniciar()
{

    strcpy(pessoa[prox_cliente].nome_completo, "Robert Freire de Melo");
    strcpy(pessoa[prox_cliente].cpf, "583.650.824-13");
    strcpy(pessoa[prox_cliente].telefone, "87 991656586");
    prox_cliente++;
    codigocliente[prox_cliente] = codigocliente[prox_cliente - 1] + 1;

    strcpy(pessoa[prox_cliente].nome_completo, "William Batista Couto Dos Santos");
    strcpy(pessoa[prox_cliente].cpf, "856.583.654-15");
    strcpy(pessoa[prox_cliente].telefone, "81 995725052");
    prox_cliente++;
    codigocliente[prox_cliente] = codigocliente[prox_cliente - 1] + 1;

    strcpy(pessoa[prox_cliente].nome_completo, "Jose dos testes");
    strcpy(pessoa[prox_cliente].cpf, "123");
    strcpy(pessoa[prox_cliente].telefone, "87 0000000");
    prox_cliente++;
    codigocliente[prox_cliente] = codigocliente[prox_cliente - 1] + 1;
}

int main()
{

    prox_cliente = 0;
    codigocliente[0] = 1322;
    int opcao2;
    // || Variaveis dos clientes ||
    iniciar();

    int opc;

    do
    {

        printf("_______________________________________\n");
        printf("1 - Venda\n");
        printf("2 - Cadastrar ou consultar clientes\n");
        printf("3 - Cadastrar ou consultar veiculos\n");
        printf("4 - Alugar veiculo\n");
        printf("9 - Sair\n");
        printf("_______________________________________\n");
        scanf("%d", &opc);

        system("cls");

        if (opc == 2)
        {
            printf("_______ RW Veiculos _______\n\n");
            printf("1- Cadastrar Cliente. \n");
            printf("2- Consultar Cliente. \n");
            printf("3- Editar Cliente. \n");
            printf("4- Remover Cliente. \n");
            printf("__________________________\n");
            scanf("%d", &opcao2);

            system("cls");

            if (opcao2 == 1)
            {

                CadastrarCliente();
            }

            if (opcao2 == 2)
            {

                ConsultarCliente();
            }
        }

    } while (opc != 9);

    return 0;
}
