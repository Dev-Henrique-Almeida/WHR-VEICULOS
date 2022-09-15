<template>
  <v-container>
    
    <v-row class="text-center">
      <v-col dark>
        <v-img :src="require('@/assets/3carros.png')" class="my-3" contain height="200" />
      </v-col>
    </v-row>
    <template>
      <center>
        <h1>WHR Veiculos</h1>
      </center>
      <v-card>
        <v-card-title>
          Cliente Fisico Cadastrado
          <v-spacer></v-spacer>
          <v-text-field v-model="search" append-icon="mdi-magnify" label="Search" single-line hide-details>
          </v-text-field>
        </v-card-title>
        <v-data-table :headers="headers" :items="usuarios" :search="search">
          <template slot="items" slot-scope="clientPF">
            <td>{{clientPF.nome}}</td>
            <td>{{clientPF.cpf}}</td>
            <td>{{clientPF.telefone}}</td>
            <td>{{clientPF.id}}</td>
            <td>{{clientPF.endereco.cidade}}</td>
            <td>{{clientPF.endereco.estado}}</td>
          </template>
        </v-data-table>
      </v-card>
      <br/>
      <br/>
      <br/>

      <br/>
      <br/>
      <br/>
      <br/>
    </template>
    
  </v-container>
</template>

<script>
import CadastroClienteFisicoService from '@/service/CadastroClienteFisicoService'

export default {
  name: 'HomePage',
  data() {
    return {
      search: '',
      usuarios: [],
      headers: [
        { text: 'ID', value: 'id' },
        { text: 'Nome', value: 'nome' },
        { text: 'CPF', value: 'cpf' },
        { text: 'Telefone', value: 'telefone' },
        { text: 'Cidade', value: 'endereco.cidade' },
        { text: 'Estado', value: 'endereco.estado' },
      ],
    }
  },
  methods: {
    loadAll() {
      CadastroClienteFisicoService.findByCpf().then(
        response => {
          this.usuarios = response.data;
        }
      );
    },
       },
  mounted() {
    this.loadAll();

  }

}

</script>

