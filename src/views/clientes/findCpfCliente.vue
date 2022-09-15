<template>

  <v-form v-model="valid">
    <v-container>
      <div>
        <h1> Cliente Cadastrado</h1>
      </div>
      <div>
        <h3> Informe um CPF</h3>
      </div>
      <v-row>
        <v-col cols="12" md="4">
          <v-text-field v-model="cliente.cpf" :rules="cpfRules" :counter="40" label="cpf" required></v-text-field>
        </v-col>

      </v-row>
      <div>
        <button>
          <v-btn color="black" dark @click="buscar"> Buscar
          <v-icon right dark >mdi-checkbox-marked-circle</v-icon>
        </v-btn>
    </button>
      </div>
    </v-container>
  </v-form>

</template>
  
<script>
import CadastroClienteFisicoService from '@/service/CadastroClienteFisicoService';
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
    telefoneRules: [
      v => v.length >= 9 || 'Telefone Invalido',
    ],
    cliente: reactive({
      cpf: '',
      
         }),
  }),
  methods: {
    buscar() {
      console.log(this.cliente)
      CadastroClienteFisicoService.findByCpf("123").then(
        response => { console.log(response.status); });
    }
  },
  
}
</script>
  

 
        