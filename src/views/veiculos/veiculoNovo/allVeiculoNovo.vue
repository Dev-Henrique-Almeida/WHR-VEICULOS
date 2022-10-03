<template >
  <v-card>
    <v-card-title>
      Lista de Veículos Novos
      <v-spacer></v-spacer>
      <v-text-field v-model="search" append-icon="mdi-magnify" label="Search" single-line hide-details>
      </v-text-field>
    </v-card-title>
    <v-data-table v-model="selected" :headers="headers" :items="desserts" :search="search" :single-select="singleSelect"
      item-key="id" class="elevation-1">
    </v-data-table>
  </v-card>
</template>

<script>

import CadastroVeiculoNovoService from '@/service/CadastroVeiculoNovoService';

export default {
  data() {
    return {
      singleSelect: true,
      search: '',
      selected: [],
      headers: [

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
      desserts: [
      ],
    }
  },
  methods: {
    loadAll() {
      CadastroVeiculoNovoService.findAllByVendidoVeiculoNovo().then(
        response => {
          this.desserts = response.data;
        }
      );
    },

  },
  mounted() {
    this.loadAll();
  }
}
</script>

