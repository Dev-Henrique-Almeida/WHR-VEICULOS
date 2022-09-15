
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
          <v-text-field v-model="clienteJuridico.nomeEmpresarial" :rules="nameEmpresarialRules" label="Nome Empresarial" required></v-text-field>
          <v-text-field v-model="clienteJuridico.nomeFantasia" :rules="nameEmpresarialRules" label="Nome Fantasia" required></v-text-field>
          <v-text-field v-model="clienteJuridico.descricao" :rules="nameEmpresarialRules" label="Descrição" required></v-text-field>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="clienteJuridico.cnpj" :rules="cnpjRules" :counter="14" type="number" label="CNPJ" required></v-text-field>
          <v-text-field v-model="clienteJuridico.contato" :rules="telefoneRules" :counter="11" type="number" label="Contato" required></v-text-field>
        </v-col>

      </v-row>
      <div>
        <h3> Endereço</h3>
      </div>
      <v-row>
        <v-col cols="12" md="4">
          <v-text-field v-model="clienteJuridico.endereco.cidade" :rules="cidadeRules" label="Cidade" required></v-text-field>
          <v-select :items="estados" v-model="clienteJuridico.endereco.estado" :rules="estadoRules" label="Estado" required></v-select>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="clienteJuridico.endereco.rua" :rules="ruaRules" label="Logradouro" required></v-text-field>
          <v-text-field v-model="clienteJuridico.endereco.numero" :rules="numeroRules" type="number" label="Numero" required></v-text-field>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="clienteJuridico.endereco.cep" :rules="cepRules" counter="8" type="number" label="CEP" required></v-text-field>
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
      v => v.length > 0 || 'Informe o nome completo',
    ],
    cnpjRules: [
      v => !!v || 'CNPJ Obrigatorio',
      v => v.length >= 14 && v.length <= 14 || 'CNPJ Invalido',
    ],
    telefoneRules: [
      v => !!v || 'Telefone Obrigatorio',
      v => v.length >= 11 && v.length <= 11 || 'Telefone Invalido',
    ],
    numeroRules: [
      v => !!v || 'Número Obrigatorio',
      v => v >= 0 || 'Número Invalido',
    ],
    cepRules: [
      v => !!v || 'CEP Obrigatorio',
      v => v.length >= 8 && v.length <= 8 || 'CEP Invalido',
    ],
    estadoRules: [
      v => !!v || 'Estado Obrigatorio',
      v => v.length > 0 || 'Estado Invalido',
    ],
    cidadeRules: [
      v => !!v || 'Nome Obrigatorio',
      v => v.length > 0 || 'Informe o nome completo',
    ],
    ruaRules: [
      v => !!v || 'Nome Obrigatorio',
      v => v.length > 0 || 'Informe o nome completo',
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
    estados: ['Acre', 'Alagoas', 'Amapá', 'Amazonas', 'Bahia', 'Ceará', 'Distrito Federal', 'Espírito Santo', 'Goiás', 'Maranhão', 'Mato Grosso', 'Mato Grosso do Sul',
     'Minas Gerais', 'Paraná', 'Paraíba', 'Pará', 'Pernambuco', 'Piauí', 'Rio de Janeiro', 'Rio Grande do Norte', 'Rio Grande do Sul', 
     'Rondonia', 'Roraima', 'Santa Catarina', 'Sergipe', 'São Paulo', 'Tocantins']
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
  

 
        