
<template>

  <v-form v-model="valid">
    <v-container>
      <div>
        <h1> Cadastro de Funcionarios</h1>
      </div>
      <div>
        <h3> Informações pessoais</h3>
      </div>
      <v-row>
        <v-col cols="12" md="4">
          <v-text-field v-model="funcionario.nome" :rules="nameRules" label="Nome" required>
          </v-text-field>
          <v-text-field v-model="funcionario.dataNascimento" :rules="dataRules" type="date" label="Data de nascimento"
            required>
          </v-text-field>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="funcionario.cpf" :rules="cpfRules" v-mask="'###########'" type="text" label="CPF"
            required></v-text-field>
          <v-text-field v-model="funcionario.telefone" :rules="telefoneRules" v-mask="'(##) #####-####'" type="text"
            label="Telefone" required></v-text-field>
        </v-col>
      </v-row>

      <div>
        <h3> Endereço</h3>
      </div>
      <v-row>
        <v-col cols="12" md="4">
          <v-text-field v-model="funcionario.endereco.cidade" :rules="cidadeRules" label="Cidade" required>
          </v-text-field>
          <v-select :items="estados" v-model="funcionario.endereco.estado" :rules="ruaRules" label="Estado" required>
          </v-select>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="funcionario.endereco.rua" :rules="ruaRules" label="Logradouro" required></v-text-field>
          <v-text-field v-model="funcionario.endereco.numero" :rules="numeroRules" type="number" label="Numero"
            required></v-text-field>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="funcionario.endereco.cep" :rules="cepRules" v-mask="'########'" type="text" label="CEP"
            required></v-text-field>
        </v-col>
      </v-row>

      <div>
        <h3> Atribuições</h3>
      </div>
      <v-row>
        <v-col cols="12" md="4">
          <v-select :items="items" l v-model="funcionario.cargo" :rules="ruaRules" label="Cargo" required></v-select>
          <v-text-field v-model="funcionario.salario" :rules="salarioRules" type="number" label="Salario" required>
          </v-text-field>
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
import CadastroFuncionarioService from '@/service/CadastroFuncionarioService';
import { reactive } from 'vue'
export default {
  data: () => ({
    valid: false,
    nameRules: [
      v => !!v || 'Campo Obrigatório',
      v => !!v.length || 'Campo Obrigatório',
      v => v.length >= 4 && v != null || 'Informe o nome completo',
    ],
    cpfRules: [
      v => !!v || 'CPF Obrigatorio',
      v => v.length >= 11 && v.length && v != null <= 11 || 'CPF Invalido',
    ],
    telefoneRules: [
      v => !!v || 'Telefone Obrigatorio',
      v => v.length >= 15 && v.length <= 15 && v != null || 'Telefone Invalido',
    ],
    numeroRules: [
      v => !!v || 'Campo Obrigatório',
      v => v >= 0 && v != null || 'Número Invalido',
    ],
    cepRules: [
      v => !!v || 'CEP Obrigatorio',
      v => v.length >= 8 && v.length <= 8 && v != null || 'CEP Invalido',
    ],
    cidadeRules: [
      v => !!v || 'Campo Obrigatório',
      v => v.length > 0 && v != null || 'Informe o nome completo',
    ],
    ruaRules: [
      v => !!v || 'Campo Obrigatório',
      v => v.length > 0 && v != null || 'Informe o nome completo',
    ],
    salarioRules: [
      v => !!v || 'Campo Obrigatório',
      v => v >= 0 || 'Salário Invalido',
    ],
    funcionario: reactive({
      nome: '',
      cpf: '',
      dataNascimento: '',
      salario: '',
      cargo: '',
      telefone: '',
      endereco: {
        numero: '',
        cidade: '',
        estado: '',
        rua: '',
        cep: '',
      }
    }),
    items: ['Gerente', 'Vendedor'],
    estados: ['Acre', 'Alagoas', 'Amapá', 'Amazonas', 'Bahia', 'Ceará', 'Distrito Federal', 'Espírito Santo', 'Goiás', 'Maranhão', 'Mato Grosso', 'Mato Grosso do Sul',
      'Minas Gerais', 'Paraná', 'Paraíba', 'Pará', 'Pernambuco', 'Piauí', 'Rio de Janeiro', 'Rio Grande do Norte', 'Rio Grande do Sul',
      'Rondonia', 'Roraima', 'Santa Catarina', 'Sergipe', 'São Paulo', 'Tocantins'],

  }),
  methods: {
    cadastrar() {
      console.log(this.funcionario)
      CadastroFuncionarioService.create(this.funcionario).then(
        response => { console.log(response.status); });
    },

  },

}
</script>
  

 
        