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
      <v-card>
        <v-card-title>
          Lista de Veiculos Novos
          <v-spacer></v-spacer>
          <v-text-field v-model="search" append-icon="mdi-magnify" label="Search" single-line hide-details>
          </v-text-field>
        </v-card-title>
        <v-data-table  :headers="headers" :items="veiculos" :search="search">
          <template slot="items" slot-scope="veiculoNovo">
            <td>{{veiculoNovo.modelo.nomeMarca}}</td>
            <td>{{veiculoNovo.modelo.nomeModelo}}</td>
            <td>{{veiculoNovo.modelo.combustivel}}</td>
            <td>{{veiculoNovo.id}}</td>
            <td>{{veiculoNovo.valorVenda}}</td>
            <td>{{veiculoNovo.modelo.cor}}</td>
            <td>{{veiculoNovo.modelo.quantidadePassageiros}}</td>
            <td>{{veiculoNovo.modelo.garantiaFabrica}}</td>
            <td>{{veiculoNovo.modelo.km}}</td>

          </template>
        </v-data-table> 
      </v-card>
    </template>
   
  </v-container>
</template>

<script>

import CadastroVeiculoNovoService from '@/service/CadastroVeiculoNovoService';


export default {
  name: 'HomePage',
  data() {
    return {
      search: '',
      veiculos: [],
      headers: [
        { text: 'ID', value: 'id' },
        { text: 'Marca', value: 'modelo.nomeMarca' },
        { text: 'Modelo', value: 'modelo.nomeModelo' },
        { text: 'Combustível', value: 'modelo.combustivel' },
        { text: 'Valor', value: 'valorVenda' },
        { text: 'Cor', value: 'modelo.cor' },
        { text: 'Quantidade Passageiros', value: 'modelo.quantidadePassageiros' },
        { text: 'Garantia', value: 'garantiaFabrica' },
        { text: 'Quilometragem', value: 'modelo.km' },
      ],
    }
  },
  methods: {
    loadAll() {
      CadastroVeiculoNovoService.getAll().then(
        response => {
          this.veiculos = response.data;
        }
      );
    },
     
  },
  mounted() {
    this.loadAll();
  }
}

</script>

