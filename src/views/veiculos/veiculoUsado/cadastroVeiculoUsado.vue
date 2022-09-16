
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
            <v-select :items="revisado" v-model="veiculo.unicoDono" :rules="campoRules" label="Único Dono" required></v-select>
            <v-select :items="items" v-model="items" label="Modelo" required></v-select>
          </v-col>

          <v-col cols="12" md="4">
            <v-text-field v-model="veiculo.km" :rules="ruaRules" type="number" label="Quilometragem" required></v-text-field>
            <v-select :items="revisado" v-model="veiculo.revisado" :rules="campoRules" label="Revisado" required></v-select>
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

import CadastroVeiculoUsadoService from '@/service/CadastroVeiculoUsadoService';
import CadastroModeloService from '@/service/CadastroModeloService';


  import { reactive } from 'vue'
  export default {
    data: () => ({
      valid: false,
      nameRules: [
        v => !!v || 'Campo Obrigatório',
        v => !!v.length || 'Campo Obrigatório',
        v => v.length >= 10 || 'Informe seu nome completo',
      ],
       campoRules: [
      v => !!v || 'Campo Obrigatório',
      v => !!v.length || 'Campo Obrigatório',
      v => v.length >= 2  && v != null || 'Garantia inválida',
    ],
      valorRules: [
        v => !!v || 'Campo Obrigatório',
        v => !!v.length || 'Campo Obrigatório',
        v => v >= 0 || 'Valor inválido',
      ],
      ruaRules: [
      v => !!v || 'Campo Obrigatório',
      v => v > 0 && v != null || 'Informe o nome completo',
    ],
      veiculo: reactive({
        valorCompraVeiculo: '',
        valorVenda: '',
        vendido: false,
        km: '',
        revisado: '',
        unicoDono: '',
           }),
      revisado: ['Sim', 'Não'],
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
        CadastroVeiculoUsadoService.create(this.veiculo).then(
          response => { console.log(response.status); });
      },
      
      
    },

    mounted() {
    this.loadAll();
  }
  }
  </script>
  