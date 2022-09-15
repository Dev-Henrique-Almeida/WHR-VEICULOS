<template >
  <v-card >
  <v-card-title>
          Lista de Modelos
          <v-spacer></v-spacer>
          <v-text-field  v-model="search" append-icon="mdi-magnify" label="Search" single-line hide-details>
          </v-text-field>
        </v-card-title >
  <v-data-table 
  
    v-model="selected"
    :headers="headers"
    :items="desserts"
    :search="search"
    :single-select="singleSelect"
    item-key="id"
    show-select
    class="elevation-1"
  >
   

  </v-data-table>
</v-card>
</template>

<script>

import CadastroModeloService from '@/service/CadastroModeloService';

  export default {
    data () {
      return {
        singleSelect: true,
        search: '',
        selected: [],  
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
        { text: 'Quilometragem', value: 'km' },
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
     
  },
  mounted() {
    this.loadAll();
  }
  }
</script>