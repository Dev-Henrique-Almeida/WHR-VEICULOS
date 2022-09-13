
<template>

  <v-form v-model="valid">
    <v-container>
      <div>
        <h1> Cadastro de Clientes Juridico</h1>
      </div>
      <div>
        <h3> Informações pessoais</h3>
      </div>
      <v-row>
        <v-col cols="12" md="4">
          <v-text-field v-model="clienteJuridico.nomeEmpresarial" :rules="nameEmpresarialRules" :counter="40" label="Nome Empresarial" required></v-text-field>
          <v-text-field v-model="clienteJuridico.nomeFantasia" :rules="nameEmpresarialRules" :counter="40" label="Nome Fantasia" required></v-text-field>
          <v-text-field v-model="clienteJuridico.descricao" :rules="nameEmpresarialRules" label="Descrição" required></v-text-field>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="clienteJuridico.cnpj" :rules="cnpjRules" :counter="14" label="CNPJ" required></v-text-field>
          <v-text-field v-model="clienteJuridico.contato" :rules="telefoneRules" type="phone" label="Contato" required></v-text-field>
        </v-col>

      </v-row>
      <div>
        <h3> Endereço</h3>
      </div>
      <v-row>
        <v-col cols="12" md="4">
          <v-text-field v-model="clienteJuridico.endereco.cidade" :counter="40" label="Cidade" required></v-text-field>
          <v-text-field v-model="clienteJuridico.endereco.estado" label="Estado" required></v-text-field>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="clienteJuridico.endereco.rua" :counter="40" label="Logradouro" required></v-text-field>
          <v-text-field v-model="clienteJuridico.endereco.numero" label="Número" required></v-text-field>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="clienteJuridico.endereco.cep" label="CEP" required></v-text-field>
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
import CadastroClienteJuridicoService from '@/service/CadastroClienteJuridicoService';
import { reactive } from 'vue'
export default {
  data: () => ({
    valid: false,
    nameEmpresarialRules: [
      v => !!v || 'Nome Obrigatorio',
      v => v.length >= 5 || 'Informe o nome completo',
    ],
    cnpjRules: [
      v => !!v || 'CNPJ Obrigatorio',
      v => v.length >= 14 || 'CNPJ Invalido',
    ],
    telefoneRules: [
      v => v.length >= 9 || 'Contato Invalido',
    ],
    clienteJuridico: reactive({
      nomeEmpresarial: '',
      nomeFantasia: '',
      descricao: '',
      cnpj: '',
      contato: '',
      endereco: {
        numero: '',
        cidade: '',
        estado: '',
        rua: '',
        cep: '',
      }
    }),
  }),
  methods: {
    cadastrar() {
      console.log(this.clienteJuridico)
      CadastroClienteJuridicoService.create(this.clienteJuridico).then(
        response => { console.log(response.status); });
    }
  },
  
}
</script>
  

 
        