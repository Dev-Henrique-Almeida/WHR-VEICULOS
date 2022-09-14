<template>
  <v-container>
    
    <v-row class="text-center">
      <v-col dark>
        <v-img :src="require('@/assets/3carros.png')" class="my-3" contain height="200" />
      </v-col>
    </v-row>
    <template>
      <h1>WHR Veiculos</h1>
      <v-card>
        <v-card-title>
          Lista de Funcionarios
          <v-spacer></v-spacer>
          <v-text-field v-model="search" append-icon="mdi-magnify" label="Search" single-line hide-details>
          </v-text-field>
        </v-card-title>
        <v-data-table :headers="headers" :items="funcionarios" :search="search">
          <template slot="items" slot-scope="funcionario">
            <td>{{funcionario.nome}}</td>
            <td>{{funcionario.cpf}}</td>
            <td>{{funcionario.telefone}}</td>
            <td>{{funcionario.id}}</td>
            <td>{{funcionario.salario}}</td>
            <td>{{funcionario.cargo}}</td>
            <td>{{funcionario.endereco.cidade}}</td>
            <td>{{funcionario.endereco.estado}}</td>

          </template>
        </v-data-table>
      </v-card>
    </template>
   
  </v-container>
</template>

<script>
import CadastroFuncionarioService from '@/service/CadastroFuncionarioService';

export default {
  name: 'HomePage',
  data() {
    return {
      search: '',
      funcionarios: [],
      headers: [
        { text: 'ID', value: 'id' },
        { text: 'Nome', value: 'nome' },
        { text: 'CPF', value: 'cpf' },
        { text: 'Telefone', value: 'telefone' },
        { text: 'Cargo', value: 'cargo' },
        { text: 'Salario', value: 'salario' },
        { text: 'Cidade', value: 'endereco.cidade' },
        { text: 'Estado', value: 'endereco.estado' },
      ],
    }
  },
  methods: {
    loadAll() {
      CadastroFuncionarioService.getAll().then(
        response => {
          this.funcionarios = response.data;
        }
      );
    },
     
  },
  mounted() {
    this.loadAll();
  }
}

</script>

