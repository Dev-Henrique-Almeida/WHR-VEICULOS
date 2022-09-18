<template >
  <div>
    <v-col dark>
      <v-img :src="require('@/assets/3carros.png')" class="my-3" contain height="200" />
    </v-col>
    <center>
      <h1>WHR Veiculos</h1>
    </center>
    <v-card>
      <br />
      <h2> Cadastro de Veiculos</h2>
      <h3>Selecione o modelo do Veiculo</h3>
      <v-card-title>
        Lista de Modelos
        <v-spacer></v-spacer>
        <v-text-field v-model="search" append-icon="mdi-magnify" label="Search" single-line hide-details>
        </v-text-field>
      </v-card-title>
      <v-data-table v-model="selected" :headers="headers" :items="desserts" :search="search"
        :single-select="singleSelect" item-key="id" show-select class="elevation-1">
      </v-data-table>
    </v-card>
    <br />
    <v-form v-model="valid">
      <v-container>
        <v-row>
          <v-col cols="12" md="4">
            <v-select :items="['Veiculo Novo', 'Veiculo Usado']" v-model="condicaoVeiculo" label="Selecione Uma opção"
              required></v-select>
          </v-col>
        </v-row>
      </v-container>
    </v-form>
    <template>
      <div class="text-right">
        <template v-if="verificacao()">
          <v-btn class="ma-2" :loading="loading2" :disabled="loading2" color="success" @click="continuarPara">
            Continuar
            <template v-slot:loader>
              <span>Loading...</span>
            </template>
          </v-btn>
        </template>
        <template v-else>
          <v-btn depressed disabled>
            Informe todos os dados para continuar
          </v-btn>
        </template>

        <v-btn class="ma-2" :loading="loading" :disabled="loading" color="secondary" @click="home"> Cancelar</v-btn>
        <v-btn :loading="loading3" :disabled="loading3" color="blue-grey" class="ma-2 white--text"
          @click="cadastrarNovoModelo">
          Cadastrar Novo modelo
          <v-icon right dark>
            mdi-cloud-upload
          </v-icon>
        </v-btn>
      </div>
    </template>
  </div>
</template>
  
<script>

import CadastroModeloService from '@/service/CadastroModeloService';

export default {
  data() {
    return {
      singleSelect: true,
      search: '',
      selected: {},
      modelo: {},
      condicaoVeiculo: '',
      headers: [
        { text: 'ID', value: 'id' },
        { text: 'Marca', value: 'nomeMarca' },
        { text: 'Modelo', value: 'nomeModelo' },
        { text: 'Motor', value: 'motor' },
        { text: 'Ano de Fabricação', value: 'anoFabricado' },
        { text: 'Combustível', value: 'combustivel' },
        { text: 'Cor', value: 'cor' },
        { text: 'Quantidade Passageiros', value: 'quantidadePassageiros' },
        { text: 'Cilindradas', value: 'cilindradas' },
        { text: 'Potencia', value: 'potencia' },
        { text: 'Câmbio', value: 'cambio' },
      ],
      desserts: [
      ],

    }
  },
  methods: {
    loadAll() {

      CadastroModeloService.getAll().then(
        response => {
          this.desserts = response.data;

        }
      );
    },
    cadastrarNovoModelo() {
      this.$router.push({ name: 'cadastroModelo' });
    },
    home() {
      this.$router.push({ name: 'home' });
    },

    continuarPara() {
      this.modelo = this.selected
      if (this.condicaoVeiculo === 'Veiculo Novo') {
        this.$router.push({ name: 'cadastroVeiculoNovo', params: { modelo: this.modelo } });
      } else {
        this.$router.push({ name: 'cadastrarVeiculoUsado', params: { modelo: this.modelo } });
      }
    },

    verificacao() {

      return ((JSON.stringify([]) !== JSON.stringify(this.selected)) && (this.condicaoVeiculo !== ''))
    },

  },
  mounted() {
    this.loadAll();
    this.verificacao();

  }
}
</script>

