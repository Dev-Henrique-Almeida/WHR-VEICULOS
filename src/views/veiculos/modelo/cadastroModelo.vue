
<template>

  <v-form v-model="valid">
    <v-container>
      <div>
        <h1> Cadastro de Modelos</h1>
      </div>
      <h3> Informações do Modelo</h3>
      <v-row>
        <v-col cols="12" md="4">
          <v-text-field v-model="modelo.nomeMarca" :rules="nameRules" label="Nome da Marca" required></v-text-field>
          <v-text-field v-model="modelo.nomeModelo" :rules="nameRules" label="Nome do modelo" required></v-text-field>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="modelo.motor" :rules="motorRules" label="Motor" required></v-text-field>
          <v-text-field v-model="modelo.cilindradas" v-mask="'####'" :rules="potenciaRules" type="number"
            label="Cilindradas" required>
          </v-text-field>
        </v-col>

        <v-col cols="12" md="4">
          <v-select :items="cores" v-model="modelo.cor" :rules="campoRules" label="Cor" required></v-select>
          <v-text-field v-model="modelo.anoFabricado" v-mask="'####'" :rules="anoRules" type="number"
            label="Ano de Fabricação" required></v-text-field>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="modelo.potencia" v-mask="'####'" :rules="potenciaRules" type="number" label="Potencia"
            required>
          </v-text-field>
          <v-text-field v-model="modelo.quantidadePassageiros" v-mask="'##'" :rules="passageirosRules" type="number"
            label="Quantidade de Passageiros" required></v-text-field>
        </v-col>

        <v-col cols="12" md="4">
          <v-select :items="cambios" v-model="modelo.cambio" :rules="campoRules" label="Câmbio" required></v-select>
          <v-select :items="combustiveis" v-model="modelo.combustivel" :rules="campoRules" label="Combustível" required>
          </v-select>
        </v-col>


      </v-row>
      <div>
        <button>
          <v-btn color="black" dark @click="cadastrar"> Cadastrar
            <v-icon right dark>mdi-checkbox-marked-circle</v-icon>
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
      v => !!v || 'Campo Obrigatório',
      v => !!v.length || 'Nome Obrigatório',
      v => v.length >= 1 && v != null || 'Informe seu nome completo',
    ],
    campoRules: [
      v => !!v || 'Campo Obrigatório',
      v => !!v.length || 'Campo Obrigatório',
      v => v.length >= 4 && v != null || 'Campo inválido',
    ],
    corRules: [
      v => !!v || 'Campo Obrigatório',
      v => !!v.length || 'Cor Obrigatória',
      v => v.length >= 4 && v != null || 'Informe o nome da cor',
    ],
    motorRules: [
      v => !!v || 'Motor Obrigatório',
      v => !!v.length || 'Motor Obrigatório',
      v => v.length >= 1 && v != null || 'Informe o nome do motor',
    ],
    kmRules: [
      v => !!v || 'Campo Obrigatório',
      v => v >= 0 || 'Quilometragem Inválida',
    ],
    anoRules: [
      v => !!v || 'Campo Obrigatório',
      v => v >= 1900 && v <= 2023 || 'Ano Inválido',
    ],
    passageirosRules: [
      v => !!v || 'Campo Obrigatório',
      v => v > 0 && v <= 25 || 'Quantidade de Passageiros Inválida',
    ],
    potenciaRules: [
      v => !!v || 'Campo Obrigatório',
      v => v > 0 && v <= 1000 || 'Potência Inválida',
    ],

    modelo: reactive({
      nomeMarca: '',
      nomeModelo: '',
      motor: '',
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
    cores: ['Azul', 'Verde', 'Amarelo', 'Roxo', 'Rosa', 'Vermelho', 'Laranja', 'Marrom', 'Cinza', 'Branco', 'Preto']

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
    
  
   
          