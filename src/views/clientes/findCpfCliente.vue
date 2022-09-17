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
          <v-text-field v-model="cliente.cpf" :rules="cpfRules" v-mask="'###.###.###-##'" type="text" label="CPF" required></v-text-field>
        </v-col>

      </v-row>
      <div>
        <button>
          <v-btn color="black" dark @click="buscaCpf"> Buscar CPF
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
      v => !!v || 'Nome Obrigatório',
      v => v.length >= 10 || 'Informe seu nome completo',
    ],
    cpfRules: [
      v => !!v || 'CPF Obrigatório',
      v => v.length >= 14 && v.length && v != null  <= 14 || 'CPF Inválido',
    ],
    telefoneRules: [
      v => !!v || 'Telefone Obrigatorio',
      v => v.length >= 14 && v.length <= 14 && v != null || 'Telefone Invalido',
    ],
    cliente: reactive({
      cpf: '',
      
         }),
  }),
  methods: {
    buscaCpf() {
      console.log(this.cpf)
      CadastroClienteFisicoService.findByCpf(this.cpf).then(
        response => { console.log(response.status); });
    }
  },
  
}
</script>
  

 
        