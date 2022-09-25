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
                        Selecione o funcionario responsavel pela venda
                        <v-spacer></v-spacer>
                        <v-text-field v-model="searchFuncionario" append-icon="mdi-magnify" label="Buscar" single-line
                            hide-details>
                        </v-text-field>
                    </v-card-title>
                    <v-data-table v-model="funcionario" :headers="headersFuncionario" :items="dessertsFuncionario"
                        :search="searchFuncionario" :single-select="singleSelect" item-key="id" show-select
                        class="elevation-1">
                    </v-data-table>
                </v-card>
                <br />
                <br />
                <br />
                <center>
                    <h1> Informações do Cliente</h1>
                </center>
                <br />
                <br />
                <v-card>
                    <v-card-title>
                        Selecione Um Cliente
                        <v-spacer></v-spacer>
                        <v-text-field v-model="searchcliente" append-icon="mdi-magnify" label="Buscar" single-line
                            hide-details>
                        </v-text-field>
                    </v-card-title>
                    <template>
                        <div class="text-right">
                            <v-btn :loading="loading3" :disabled="loading3" color="blue-grey" class="ma-2 white--text"
                                @click="cadastrarNovoCliente">Cadastrar Novo Cliente<v-icon right dark>mdi-cloud-upload
                                </v-icon>
                            </v-btn>
                        </div>
                    </template>
                    <v-data-table v-model="cliente" :headers="headersClienteFisico" :items="dessertsClienteFisico"
                        :search="searchcliente" :single-select="singleSelect" item-key="id" show-select
                        class="elevation-1">
                    </v-data-table>
                </v-card>
                <br />
                <br />
                <br />
                <center>
                    <h1> Informações do Veiculo</h1>
                </center>
                <v-form v-model="valid">
                    <v-container>
                        <v-row>
                            <v-col cols="12" md="4">
                                <v-select :items="['Veiculo Novo', 'Veiculo Usado']" v-model="condicaoVeiculo"
                                    label="Selecione Uma opção" required></v-select>
                            </v-col>
                        </v-row>
                    </v-container>
                </v-form>

                <template v-if=" (condicaoVeiculo === 'Veiculo Novo')">
                    <v-card>
                        <v-card-title>
                            Lista de Veículos Novos
                            <v-spacer></v-spacer>
                            <v-text-field v-model="searchVeiculo" append-icon="mdi-magnify" label="Search" single-line
                                hide-details>
                            </v-text-field>
                        </v-card-title>
                        <v-data-table v-model="veiculoNovo" :headers="headersVeiculoNovo" :items="dessertsVeiculoNovo"
                            :search="searchVeiculo" :single-select="singleSelect" item-key="id" show-select
                            class="elevation-1">
                        </v-data-table>
                    </v-card>
                </template>

                <template v-if=" (condicaoVeiculo === 'Veiculo Usado')">
                    <v-card>
                        <v-card-title>
                            Lista de Veículos Usados
                            <v-spacer></v-spacer>
                            <v-text-field v-model="searchVeiculo" append-icon="mdi-magnify" label="Buscar" single-line
                                hide-details>
                            </v-text-field>
                        </v-card-title>
                        <v-data-table v-model="veiculoUsado" :headers="headersVeiculoUsado"
                            :items="dessertsVeiculoUsado" :search="searchVeiculo" :single-select="singleSelect"
                            item-key="id" show-select class="elevation-1">
                        </v-data-table>
                    </v-card>
                </template>
                <br />
                <br />
                <center>
                    <h1> Informações de Pagamento</h1>
                </center>
                <v-form v-model="valid">
                    <v-container>
                        <v-row>
                            <v-col cols="12" md="4">
                                <v-select :items="['Tranferencia (TED/DOC)', 'PIX', 'Credito','Débito', 'Dinheiro']"
                                    v-model="formaPagamento" label="Selecione Uma opção" required></v-select>
                            </v-col>
                        </v-row>
                    </v-container>
                </v-form>
                <br />
                <br />
                <br />
                <template>
                    <div class="text-center">
                        <v-btn class="ma-2" :loading="loading" :disabled="loading" color="secondary" @click="home">
                            Cancelar
                        </v-btn>
                        <v-btn class="ma-2" :loading="loading" :disabled="loading" color="success" @click="continuar">
                            Continuar</v-btn>
                    </div>
                </template>
                <br />
                <br />
                <br />
                <br />
                <br />
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
                            <v-data-table :headers="headersFuncionario" :items="funcionario" hide-default-footer
                                class="elevation-1"> </v-data-table>
                        </template>
                        <br />
                        <h2>Cliente </h2>
                        <template>
                            <v-data-table :headers="headersClienteFisico" :items="cliente" hide-default-footer
                                class="elevation-1"> </v-data-table>
                        </template>
                        <br />
                        <h2>Veiculo </h2>
                        <template v-if="(condicaoVeiculo === 'Veiculo Usado')">
                            <v-data-table :headers="headersVeiculoUsado" :items="veiculoUsado" hide-default-footer
                                class="elevation-1"> </v-data-table>
                        </template>
                        <template v-if="(condicaoVeiculo === 'Veiculo Novo')">
                            <v-data-table :headers="headersVeiculoNovo" :items="veiculoNovo" hide-default-footer
                                class="elevation-1"> </v-data-table>
                        </template>
                        <br />
                        <h2>Informações de pagamento </h2>
                        <template>
                            <v-data-table :headers="headersPagamento" :items="[{formaPagamento,valorTotal}]"
                                hide-default-footer class="elevation-1"> </v-data-table>
                        </template>
                    </v-container>
                </v-card>
            </v-container>
            <template>
                <div class="text-center">
                    <v-btn class="ma-2" :loading="loading" :disabled="loading" color="secondary" @click="volta">
                        Editar
                    </v-btn>
                    <v-btn class="ma-2" :loading="loading" :disabled="loading" color="success" @click="finalizarVenda">
                        Confirmar Venda</v-btn>
                </div>
            </template>
        </template>
    </div>
</template>
  
<script>
import CadastroFuncionarioService from '@/service/CadastroFuncionarioService'
import CadastroClienteFisicoService from '@/service/CadastroClienteFisicoService'
import CadastroVeiculoNovoService from '@/service/CadastroVeiculoNovoService'
import CadastroVeiculoUsadoService from '@/service/CadastroVeiculoUsadoService'
import CadastroOrdemVendaPessoaFisicaService from '@/service/CadastroOrdemVendaPessoaFisicaService'
import { reactive } from 'vue'

export default {
    data() {
        return {
            singleSelect: true,
            condicaoVeiculo: '',
            searchcliente: '',
            searchVeiculo: '',
            tela: '',
            searchFuncionario: '',
            formaPagamento: '',
            valorTotal: '',
            funcionario: [],
            cliente: [],
            veiculoUsado: [],
            veiculoNovo: [],
            preVenda: reactive({
                cpfCnpjCliente: '',
                cpfFuncionario: '',
                chassiVeiculo: '',
                clienteJuridico: '',
                veiculoNovo: '',
                formaPagamento: '',
            }),
            headersPagamento: [
                { text: 'Forma de Pagamento', value: 'formaPagamento' },
                { text: 'Valor Total', value: 'valorTotal' },
            ],
            headersFuncionario: [
                { text: 'ID', value: 'id' },
                { text: 'Nome', value: 'nome' },
                { text: 'Cargo', value: 'cargo' },

            ],
            headersClienteFisico: [
                { text: 'ID', value: 'id' },
                { text: 'Nome', value: 'nome' },
                { text: 'CPF', value: 'cpf' },
                { text: 'Telefone', value: 'telefone' },
                { text: 'Cidade', value: 'endereco.cidade' },
                { text: 'UF', value: 'endereco.estado' },
            ],
            headersVeiculoNovo: [
                { text: 'ID', value: 'id' },
                { text: 'Marca', value: 'modelo.nomeMarca' },
                { text: 'Modelo', value: 'modelo.nomeModelo' },
                { text: 'Combustível', value: 'modelo.combustivel' },
                { text: 'Valor', value: 'valorVenda' },
                { text: 'Cor', value: 'modelo.cor' },
                { text: 'Quant. Passageiros', value: 'modelo.quantidadePassageiros' },
                { text: 'Garantia', value: 'garantiaFabrica' },
                { text: 'Chassi', value: 'chassi' },
                { text: 'Km`s', value: 'km' },
            ],
            headersVeiculoUsado: [
                { text: 'ID', value: 'id' },
                { text: 'Marca', value: 'modelo.nomeMarca' },
                { text: 'Modelo', value: 'modelo.nomeModelo' },
                { text: 'Combustível', value: 'modelo.combustivel' },
                { text: 'Valor', value: 'valorVenda' },
                { text: 'Cor', value: 'modelo.cor' },
                { text: 'Quant. Passageiros', value: 'modelo.quantidadePassageiros' },
                { text: 'Revisado', value: 'revisado' },
                { text: 'Único Dono', value: 'unicoDono' },
                { text: 'Km`s', value: 'km' },
                { text: 'Chassi', value: 'chassi' },
            ],
            dessertsFuncionario: [
            ],
            dessertsClienteFisico: [
            ],
            dessertsVeiculoNovo: [
            ],
            dessertsVeiculoUsado: [
            ],
        }
    },
    methods: {
        loadAll() {
            this.tela = 1;
            CadastroFuncionarioService.getAll().then(response => { this.dessertsFuncionario = response.data; });
            CadastroClienteFisicoService.getAll().then(response => { this.dessertsClienteFisico = response.data; });
            CadastroVeiculoNovoService.getAll().then(response => { this.dessertsVeiculoNovo = response.data; });
            CadastroVeiculoUsadoService.getAll().then(response => { this.dessertsVeiculoUsado = response.data; });
        },
        cadastrarNovoCliente() {
            this.$router.push({ name: 'cadastroClienteFisico' });
        },
        continuar() {
            this.preVenda.cpfCnpjCliente = this.cliente[0].cpf;
            this.preVenda.cpfFuncionario = this.funcionario[0].cpf
            this.preVenda.clienteJuridico = false;
            this.preVenda.formaPagamento = this.formaPagamento;

            if (JSON.stringify([]) === JSON.stringify(this.cliente) || this.formaPagamento === '' || JSON.stringify([]) === JSON.stringify(this.funcionario) ||
                (JSON.stringify([]) === JSON.stringify(this.veiculoNovo) && JSON.stringify([]) === JSON.stringify(this.veiculoUsado))) {
                alert('Preencha todos os dados solicitados!')
            } else {
                this.tela = 2;
                if (this.condicaoVeiculo == "Veiculo Usado") {
                    this.preVenda.chassiVeiculo = this.veiculoUsado[0].chassi;
                    this.preVenda.veiculoNovo == false;
                } else {
                    this.preVenda.chassiVeiculo = this.veiculoNovo[0].chassi;
                    this.preVenda.veiculoNovo == true;
                }
            }

        },
        finalizarVenda() {
            console.log(this.preVenda)
            CadastroOrdemVendaPessoaFisicaService.create(this.preVenda).then(
                response => { console.log(response.status); }).catch(e => {
                    console.log(e.response.data.message);
                    alert(e.response.data.message);
                });
        },
        volta() {
            this.tela = 1;
        },
        home() {
            this.$router.push({ name: 'home' });
        },
    },
    mounted() {
        this.loadAll();
    }
}
</script>

