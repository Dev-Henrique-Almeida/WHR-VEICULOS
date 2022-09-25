
<template>
  <div>

    <v-form v-model="valid">
      <v-container>
        <h1>Cadastro de Veiculos</h1>
        <br />
        <h3>Modelo Selecionado:</h3>
        <template>
          <v-card><template>
              <v-data-table :headers="headersModelo" :items="modeloItems" hide-default-footer class="elevation-1">
              </v-data-table>
            </template></v-card>
        </template>
        <br />
        <br />
        <h3> Informações do Veiculo</h3>
        <v-row>
          <v-col cols="12" md="4">
            <v-text-field v-model="veiculoNovo.valorCompraVeiculo" v-mask="'########'" :rules="valorRules" type="number"
              label="Valor de Compra" required></v-text-field>
            <v-text-field v-model="veiculoNovo.valorVenda" v-mask="'########'" :rules="valorRules" type="number"
              label="Valor de Venda" required></v-text-field>
          </v-col>
          <v-col cols="12" md="4">
            <v-select :items="garantia" v-model="veiculoNovo.garantiaFabrica" :rules="ruaRules"
              label="Garantia de Fabrica" required></v-select>
          </v-col>
          <v-col cols="12" md="4">
            <v-text-field v-model="veiculoNovo.chassi" :rules="chassiRules" :maxLength="17" label="Chassi" required>
            </v-text-field>
          </v-col>
        </v-row>


      </v-container>
    </v-form>
    <template>
      <div class="text-center">
        <v-btn class="ma-2" :loading="loading" :disabled="loading" color="secondary" @click="home">Cancelar</v-btn>
        <v-btn :loading="loading3" :disabled="loading3" color="blue-grey" class="ma-2 white--text" @click="irModelo">
          Selecionar outro Modelo</v-btn>
        <v-btn class="ma-2" :loading="loading" :disabled="loading" color="success" @click="cadastrar"> Concluir Cadastro
        </v-btn>
      </div>
    </template>
  </div>
</template>
    
<script>

import CadastroVeiculoNovoService from '@/service/CadastroVeiculoNovoService';

import { reactive } from 'vue'
export default {
  data: () => ({
    valid: false,
    nameRules: [
      v => !!v || 'Campo Obrigatório',
      v => !!v.length || 'Campo Obrigatório',
      v => v.length >= 10 || 'Informe seu nome completo',
    ],
    chassiRules: [
      v => !!v || 'Campo Obrigatório',
      v => v.length >= 17 && v.length <= 17 && v != null || 'Chassi Inválido',
    ],
    campoRules: [
      v => !!v || 'Campo Obrigatório',
      v => !!v.length || 'Campo Obrigatório',
      v => v.length >= 4 && v != null || 'Garantia inválida',
    ],
    valorRules: [
      v => !!v || 'Campo Obrigatório',
      v => !!v.length || 'Campo Obrigatório',
      v => v >= 0 || 'Valor inválido',
    ],
    ruaRules: [
      v => !!v || 'Campo Obrigatório',
      v => v.length >= 0 || 'Informe o nome completo',
    ],

    veiculoNovo: reactive({
      valorCompraVeiculo: '',
      valorVenda: '',
      vendido: false,
      km: '',
      chassi: '',
      garantiaFabrica: '',
      modelo: {},
    }),
    garantia: ['Sim', 'Não'],
    items: [],
    modeloItems: [],
    headersModelo: [

      { text: 'Marca', value: 'nomeMarca' },
      { text: 'Modelo', value: 'nomeModelo' },
      { text: 'Motor', value: 'motor' },
      { text: 'Ano', value: 'anoFabricado' },
      { text: 'Combustível', value: 'combustivel' },
      { text: 'Cor', value: 'cor' },
      { text: 'Cilindradas', value: 'cilindradas' },
      { text: 'Potencia', value: 'potencia' },
      { text: 'Câmbio', value: 'cambio' },
      { text: 'Estado', value: 'estado' },
    ],
  }),
  methods: {
    loadAll() {
      this.modeloItems = this.veiculoNovo.modelo,
        this.veiculoNovo.modelo = this.$route.params.modelo[0];
      this.modeloItems = [{
        nomeMarca: this.veiculoNovo.modelo.nomeMarca,
        nomeModelo: this.veiculoNovo.modelo.nomeModelo,
        motor: this.veiculoNovo.modelo.motor,
        anoFabricado: this.veiculoNovo.modelo.anoFabricado,
        combustivel: this.veiculoNovo.modelo.combustivel,
        cor: this.veiculoNovo.modelo.cor,
        cilindradas: this.veiculoNovo.modelo.cilindradas,
        potencia: this.veiculoNovo.modelo.potencia,
        cambio: this.veiculoNovo.modelo.cambio,
        estado: 'Novo',
      }]
    },
    irModelo() {
      this.$router.push({ name: 'CadastrarVeiculo' });
    },
    home() {
      this.$router.push({ name: 'home' });
    },
    cadastrar() {
      console.log(this.veiculoNovo)
      CadastroVeiculoNovoService.create(this.veiculoNovo).then(
        response => { console.log(response.status), alert('Sucesso, veiculo cadastrado!'); }).catch(e => {
          console.log(e.response.data.message);
          alert(e.response.data.message);

        });

    },
  },
  mounted() {
    this.loadAll();
  },

}
</script>
  