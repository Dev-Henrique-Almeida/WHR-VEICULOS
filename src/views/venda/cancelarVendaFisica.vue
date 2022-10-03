<template >
    <div>
        <template v-if="tela === 1">
            <v-container>
                <v-row class="text-center">
                    <v-col dark>
                        <v-img :src="require('@/assets/3carros.png')" class="my-3" contain height="200" />
                    </v-col>
                </v-row>
                <v-card>
                    <v-card-title>
                        Selecione a venda que deseja CANCELAR:
                        <v-spacer></v-spacer>
                        <v-text-field v-model="search" append-icon="mdi-magnify" label="Buscar" single-line
                            hide-details>
                        </v-text-field>
                    </v-card-title>

                    <v-data-table v-model="selected" :headers="headers" :items="desserts" :search="search"
                        :single-select="singleSelect" item-key="id" show-select class="elevation-1">
                    </v-data-table>
                </v-card>
                <div class="text-center">
                    <v-btn class="ma-2" :loading="loading" :disabled="loading" color="secondary" @click="home">
                        Cancelar
                    </v-btn>
                    <v-btn class="ma-2" :loading="loading" :disabled="loading" color="success" @click="continuar">
                        Continuar</v-btn>
                </div>

            </v-container>
        </template>
        <template v-if="tela === 2">
            <v-container>
                <v-card color="grey darken-4">
                    <v-container>
                        <br />
                        <center>
                            <h1> Resumo da Venda </h1>
                        </center>
                        <h2> Vendedor: </h2>
                        <template>
                            <v-data-table :headers="headersFuncionario" :items="venda" hide-default-footer
                                class="elevation-1">
                            </v-data-table>
                        </template>
                        <br />
                        <h2> Cliente: </h2>
                        <template>
                            <v-data-table :headers="headersClienteFisico" :items="venda" hide-default-footer
                                class="elevation-1">
                            </v-data-table>
                        </template>
                        <br />
                        <h2> Veiculo: </h2>
                        <template v-if="(condicaoVeiculo === 'Veiculo Usado')">
                            <v-data-table :headers="headersVeiculoUsado" :items="venda" hide-default-footer
                                class="elevation-1">
                            </v-data-table>
                        </template>
                        <template v-if="(condicaoVeiculo === 'Veiculo Novo')">
                            <v-data-table :headers="headersVeiculoNovo" :items="venda" hide-default-footer
                                class="elevation-1">
                            </v-data-table>
                        </template>
                        <br />
                        <h2> Informações do pagamento: </h2>
                        <template>
                            <v-data-table :headers="headersPagamento" :items="venda" hide-default-footer
                                class="elevation-1">
                            </v-data-table>
                        </template>
                        <br />
                        <center>
                            <v-alert dense border="left" type="warning" width="800">Atenção, verifique os dados da
                                venda, ao
                                confirmar o cancelamento a operação é irreversível</v-alert>
                        </center>
                    </v-container>
                </v-card>
            </v-container>
            <template>
                <div class="text-center">
                    <v-btn depressed color="secondary" @click="acessoRestrito">Voltar</v-btn>
                    <v-btn class="ma-2" :loading="loading" :disabled="loading" color="secondary" @click="volta">Escolher
                        outra venda</v-btn>
                    <v-btn depressed color="error" @click="cancelarVenda">Confirmar Cancelamento</v-btn>
                </div>
            </template>
        </template>
    </div>
</template>
  
<script>

import CadastroOrdemVendaPessoaFisicaService from '@/service/CadastroOrdemVendaPessoaFisicaService';

export default {
    data() {
        return {
            singleSelect: true,
            search: '',
            tela: '',
            venda: '',
            clienteFJ: '',
            condicaoVeiculo: '',
            funcionario: [],
            veiculoUsado: [],
            veiculoNovo: [],
            cliente: [],
            selected: [],
            headers: [
                { text: 'ID', value: 'id' },
                { text: 'Valor', value: 'valor' },
                { text: 'Forma Pagamento', value: 'formaPagamento' },
                { text: 'Modelo', value: 'veiculo.modelo.nomeModelo' },
                { text: 'Funcionario', value: 'vendedor.nome' },
                { text: 'Cliente', value: 'cliente.nome' },
                { text: 'CPF Cliente', value: 'cliente.cpf' },

            ],
            headersJuridico: [
                { text: 'ID', value: 'id' },
                { text: 'Valor', value: 'valor' },
                { text: 'Forma Pagamento', value: 'formaPagamento' },
                { text: 'Modelo', value: 'veiculo.modelo.nomeModelo' },
                { text: 'Funcionario', value: 'vendedor.nome' },
                { text: 'Cliente', value: 'cliente.nome' },
                { text: 'CPF Cliente', value: 'cliente.cnpj' },
            ],

            headersFuncionario: [
                { text: 'ID', value: 'vendedor.id' },
                { text: 'Nome', value: 'vendedor.nome' },
                { text: 'Cargo', value: 'vendedor.cargo' },

            ],
            headersClienteFisico: [
                { text: 'ID', value: 'cliente.id' },
                { text: 'Nome', value: 'cliente.nome' },
                { text: 'CPF', value: 'cliente.cpf' },
                { text: 'Telefone', value: 'cliente.telefone' },
                { text: 'Cidade', value: 'cliente.endereco.cidade' },
                { text: 'UF', value: 'cliente.endereco.estado' },
            ],
            headersVeiculoNovo: [
                { text: 'ID', value: 'veiculo.id' },
                { text: 'Marca', value: 'veiculo.modelo.nomeMarca' },
                { text: 'Modelo', value: 'veiculo.modelo.nomeModelo' },
                { text: 'Combustível', value: 'veiculo.modelo.combustivel' },
                { text: 'Valor', value: 'veiculo.valorVenda' },
                { text: 'Cor', value: 'veiculo.modelo.cor' },
                { text: 'Quant. Passageiros', value: 'veiculo.modelo.quantidadePassageiros' },
                { text: 'Garantia', value: 'veiculo.garantiaFabrica' },
                { text: 'Chassi', value: 'veiculo.chassi' },
                { text: 'Km`s', value: 'veiculo.km' },
            ],
            headersVeiculoUsado: [
                { text: 'ID', value: 'veiculo.id' },
                { text: 'Marca', value: 'veiculo.modelo.nomeMarca' },
                { text: 'Modelo', value: 'veiculo.modelo.nomeModelo' },
                { text: 'Combustível', value: 'veiculo.modelo.combustivel' },
                { text: 'Valor', value: 'veiculo.valorVenda' },
                { text: 'Cor', value: 'veiculo.modelo.cor' },
                { text: 'Quant. Passageiros', value: 'veiculo.modelo.quantidadePassageiros' },
                { text: 'Revisado', value: 'veiculo.revisado' },
                { text: 'Único Dono', value: 'veiculo.unicoDono' },
                { text: 'Km`s', value: 'veiculo.km' },
                { text: 'Chassi', value: 'veiculo.chassi' },
            ],
            headersPagamento: [
                { text: 'Forma de Pagamento', value: 'formaPagamento' },
                { text: 'Valor Total', value: 'valor' },
            ],
            dessertsClienteFisico: [
            ],
            dessertsVeiculoNovo: [
            ],
            dessertsVeiculoUsado: [
            ],
            dessertsFuncionario: [
            ],
            dessertsJuridico: [
            ],
            desserts: [
            ],

        }
    },
    methods: {
        loadAll() {
            this.tela = 1;
            CadastroOrdemVendaPessoaFisicaService.getAll().then(
                response => {
                    this.desserts = response.data;
                }

            );
        },
        continuar() {
            this.tela = 2;
            this.venda = this.selected
            if (this.selected[0].veiculo.km == 0) {
                this.condicaoVeiculo = 'Veiculo Novo'

            } else {
                this.condicaoVeiculo = 'Veiculo Usado'

            }

        },
        volta() {
            this.tela = 1;
        },
        acessoRestrito() {
            this.$router.push({ name: 'acessoRestrito' });
        },
        finalizado() {
            this.$router.push({ name: 'gerenciarVendas' });
        },
        cancelarVenda() {
            console.log(this.selected[0].id)
            CadastroOrdemVendaPessoaFisicaService.cancelarVenda(this.selected[0].id).then(
                response => {
                    alert("Venda Cancelada com Sucesso!"),
                    this.finalizado();
                        console.log(response.status);
                }).catch(e => {
                    console.log(e.response.data.message);
                    alert(e.response.data.message);
                });
        },

    },
    mounted() {
        this.loadAll();
    }
}
</script>
  
