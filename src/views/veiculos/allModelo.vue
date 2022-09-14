<template>
  <v-container>
    
    <v-row class="text-center">
      <v-col dark>
        <v-img :src="require('@/assets/3carros.png')" class="my-3" contain height="200" />
      </v-col>
    </v-row>
    <template>
      <br>
      <center>
        <h1>WHR Veiculos</h1>
      </center>
      <br>
      <v-card >
        <v-card-title>
          Lista de Modelos
          <v-spacer></v-spacer>
          <v-text-field  v-model="search" append-icon="mdi-magnify" label="Search" single-line hide-details>
          </v-text-field>
        </v-card-title >
        <v-data-table  :headers="headers" :items="modelos" :search="search">
          <template  slot="items" slot-scope="modelo">
            <td>{{modelo.nomeMarca}}</td>
            <td>{{modelo.nomeModelo}}</td>
            <td>{{modelo.motor}}</td>
            <td>{{modelo.combustivel}}</td>
            <td>{{modelo.anoFabricado}}</td>
            <td>{{modelo.potencia}}</td>
            <td>{{modelo.cilindradas}}</td>
            <td>{{modelo.cambio}}</td>
            <td>{{modelo.id}}</td>
            <td>{{modelo.cor}}</td>
            <td>{{modelo.quantidadePassageiros}}</td>
            <td>{{modelo.km}}</td> 
        
          </template>
        </v-data-table>
      </v-card>
    </template>
   
  </v-container>
</template>

<script>

import CadastroModeloService from '@/service/CadastroModeloService';

export default {
  name: 'HomePage',
  data() {
    return {
      search: '',
      modelos: [],
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
        { text: 'Câmbio', value: 'potencia' },
        { text: 'Quilometragem', value: 'km' },
      ], 
      
    }
  },
  methods: {
    loadAll() {
      CadastroModeloService.getAll().then(
        response => {
          this.modelos = response.data;
        }
      );
    },
     
  },
  mounted() {
    this.loadAll();
  }
}

</script>

