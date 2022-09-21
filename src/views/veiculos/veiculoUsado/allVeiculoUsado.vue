<template >
  <v-card>
    <v-card-title>
      Lista de Veículos Usados
      <v-spacer></v-spacer>
      <v-text-field v-model="search" append-icon="mdi-magnify" label="Search" single-line hide-details>
      </v-text-field>
    </v-card-title>
    <v-data-table v-model="selected" :headers="headers" :items="desserts" :search="search" :single-select="singleSelect"
      item-key="id" show-select class="elevation-1">
    </v-data-table>
  </v-card>
</template>

<script>

import CadastroVeiculoUsadoService from '@/service/CadastroVeiculoUsadoService';

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
        { text: 'Revisado', value: 'revisado' },
        { text: 'Único Dono', value: 'unicoDono' },
        { text: 'Km`s', value: 'km' },
        { text: 'Chassi', value: 'chassi' },
      ],
      desserts: [
      ],
    }
  },
  methods: {
    loadAll() {
      CadastroVeiculoUsadoService.getAll().then(
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

