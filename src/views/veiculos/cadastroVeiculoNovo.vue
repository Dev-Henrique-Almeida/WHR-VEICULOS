
<template>

    <v-form v-model="valid">
      <v-container>
        <div>
          <h1> Cadastro de Veiculos Novos</h1>
        </div>
          <h3> Informações do Veiculo</h3>
        <v-row>
          <v-col cols="12" md="4">
            <v-text-field v-model="veiculo.valorCompraVeiculo" :rules="valorRules" type="number" label="Valor de Compra" required></v-text-field>
            <v-text-field v-model="veiculo.valorVenda" :rules="valorRules" type="number" label="Valor de Venda" required></v-text-field>
          </v-col>
  
          <v-col cols="12" md="4">
            <v-select :items="garantia" v-model="veiculo.garantiaFabrica" label="Garantia de Fabrica" required></v-select>
            <v-select :items="items" v-model="items" label="Modelo" required></v-select>
          </v-col>
     
        </v-row>
        <div>
          <button>
            <v-btn color="black" dark @click="cadastrar"> Cadastrar
            <v-icon right dark >mdi-checkbox-marked-circle</v-icon>
          </v-btn>
      </button>
        </div>
      </v-container>
    </v-form>
  
  </template>
    
  <script>

import CadastroVeiculoNovoService from '@/service/CadastroVeiculoNovoService';
import CadastroModeloService from '@/service/CadastroModeloService';


  import { reactive } from 'vue'
  export default {
    data: () => ({
      valid: false,
      nameRules: [
        v => !!v || 'Nome Obrigatorio',
        v => v.length >= 10 || 'Informe seu nome completo',
      ],
      cpfRules: [
        v => !!v || 'CPF Obrigatorio',
        v => v.length >= 11 || 'CPF Invalido',
      ],
      valorRules: [
        v => v >= 0 || 'Valor Invalido',
      ],
      veiculo: reactive({
        valorCompraVeiculo: '',
        valorVenda: '',
        vendido: false,
      }),
      
      garantia: ['Sim', 'Não'],
      items: [ ],
     
    }),
    methods: {
      loadAll() {
      CadastroModeloService.getAll().then(
        response => {
          this.items = response.data;
        }
      );
      },
      cadastrar() {
        console.log(this.veiculo)
        CadastroVeiculoNovoService.create(this.veiculo).then(
          response => { console.log(response.status); });
      },
      
      
    },

    mounted() {
    this.loadAll();
  }
  }
  </script>
  