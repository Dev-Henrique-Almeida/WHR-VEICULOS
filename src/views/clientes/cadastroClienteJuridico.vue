
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
          
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="clienteJuridico.cnpj" :rules="cnpjRules" v-mask="'##.###.###/####-##'" type="text" label="CNPJ" required></v-text-field>
          <v-text-field v-model="clienteJuridico.contato" :rules="telefoneRules" v-mask="'(##)#####-####'" type="text" label="Contato" required></v-text-field>
        </v-col>

        <v-col>
          <v-text-field v-model="clienteJuridico.descricao" :rules="nameEmpresarialRules" label="Descrição" required></v-text-field>
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
          <v-text-field v-model="clienteJuridico.endereco.cep" :rules="cepRules" v-mask="'#####-###'" type="text" label="CEP" required></v-text-field>
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
      v => !!v || 'Campo Obrigatório',
      v => v.length > 0 || 'Informe o nome completo',
    ],
    cnpjRules: [
      v => !!v || 'Campo Obrigatório',
      v => v.length >= 14 && v.length <= 14 || 'CNPJ Invalido',
    ],
    telefoneRules: [
      v => !!v || 'Campo Obrigatório',
      v => v.length >= 11 && v.length <= 11 || 'Telefone Invalido',
    ],
    numeroRules: [
      v => !!v || 'Campo Obrigatório',
      v => v >= 0 || 'Número Invalido',
    ],
    cepRules: [
      v => !!v || 'Campo Obrigatório',
      v => v.length >= 9 && v.length <= 9 || 'CEP Invalido',
    ],
    estadoRules: [
      v => !!v || 'Campo Obrigatório',
      v => v.length > 0 || 'Estado Invalido',
    ],
    cidadeRules: [
      v => !!v || 'Campo Obrigatório',
      v => v.length > 0 || 'Informe o nome completo',
    ],
    ruaRules: [
      v => !!v || 'Campo Obrigatório',
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
  

 
        