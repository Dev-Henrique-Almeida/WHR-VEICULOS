
<template>

    <v-form v-model="valid">
      <v-container>
        <div>
          <h1> Cadastro de Modelos</h1>
        </div>
          <h3> Informações do Modelo</h3>
        <v-row>
          <v-col cols="12" md="4">
            <v-text-field v-model="modelo.nomeMarca" label="Nome da Marca" required></v-text-field>
            <v-text-field v-model="modelo.nomeModelo" label="Nome do modelo" required></v-text-field>
          </v-col>
  
          <v-col cols="12" md="4">
            <v-text-field v-model="modelo.motor" label="Motor" required></v-text-field>
            <v-text-field v-model="modelo.km" counter="6" :rules="kmRules"  type="number" label="Quilometragem" required></v-text-field>
          </v-col>

          <v-col cols="12" md="4">
            <v-text-field v-model="modelo.cor" label="Cor" required></v-text-field>
            <v-text-field v-model="modelo.anoFabricado" counter="4" :rules="anoRules" type="number" label="Ano de Fabricação" required></v-text-field>
          </v-col>

          <v-col cols="12" md="4">
            <v-text-field v-model="modelo.potencia" type="number" label="Potencia" required></v-text-field>
            <v-text-field v-model="modelo.quantidadePassageiros" counter="2" :rules="passageirosRules" type="number" label="Quantidade de Passageiros" required></v-text-field>
          </v-col>

          <v-col cols="12" md="4">
            <v-select :items="cambios" v-model="modelo.cambio" counter="40" label="Câmbio" required></v-select>
            <v-select :items="combustiveis" v-model="modelo.combustivel" label="Combustível" required></v-select>
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

import CadastroModeloService from '@/service/CadastroModeloService';

  import { reactive } from 'vue'
  export default {
    data: () => ({
      valid: false,
      nameRules: [
        v => !!v || 'Nome Obrigatorio',
        v => v.length >= 10 || 'Informe o nome completo',
      ],
      kmRules: [
  
        v => v >= 0 || 'Quilometragem Invalida',
      ],
      anoRules: [
        v => v >= 1900 && v <= 2023 || 'Ano Invalido',
      ],
      passageirosRules: [
        v => v > 0 || 'Quantidade de Passageiros Invalida',
      ],

      modelo: reactive({
        nomeMarca: '',
        nomeModelo: '',
        motor: '',
        km: '',
        cor: '',
        anoFabricado: '',
        potencia: '',
        quantidadePassageiros: '',
        cilindradas: '',
        cambio: '',
        combustivel: '',
        
      }),
      combustiveis: ['Gasolina', 'Álcool', 'Diesel', 'Flex(Gasolina/Álcool)'],
      cambios: ['Automático', 'Manual', 'Semi-Automático'],
      
    }),
    methods: {
      cadastrar() {
        console.log(this.veiculo)
        CadastroModeloService.create(this.modelo).then(
          response => { console.log(response.status); });
      }
    },
    
  }
  </script>
    
  
   
          