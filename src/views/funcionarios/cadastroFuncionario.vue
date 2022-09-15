
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
          <v-text-field v-model="funcionario.nome" label="Nome" required>
          </v-text-field>
          <v-text-field v-model="funcionario.dataNascimento" type="date" label="Data de nascimento" required>
          </v-text-field>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="funcionario.cpf" :rules="cpfRules" :counter="11" label="CPF" required></v-text-field>
          <v-text-field v-model="funcionario.telefone" :rules="telefoneRules" :counter="11" type="number" label="Telefone" required>
          </v-text-field>
        </v-col>
      </v-row>

      <div>
        <h3> Endereço</h3>
      </div>
      <v-row>
        <v-col cols="12" md="4">
          <v-text-field v-model="funcionario.endereco.cidade" :rules="cidadeRules" label="Cidade" required></v-text-field>
          <v-select :items="estados" v-model="funcionario.endereco.estado" label="Estado" required></v-select>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="funcionario.endereco.rua" :rules="ruaRules" label="Logradouro" required></v-text-field>
          <v-text-field v-model="funcionario.endereco.numero" :rules="numeroRules" type="number" label="Numero" required></v-text-field>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="funcionario.endereco.cep" :rules="cepRules" counter="8" type="number" label="CEP" required></v-text-field>
        </v-col>
      </v-row>

      <div>
        <h3> Atribuições</h3>
      </div>
      <v-row>
        <v-col cols="12" md="4">
           <v-select  :items="items" l v-model="funcionario.cargo" label="Cargo" required></v-select>
          <v-text-field v-model="funcionario.salario" :rules="salarioRules" type="number" label="Salario" required></v-text-field>
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
import CadastroFuncionarioService from '@/service/CadastroFuncionarioService';
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
      v => v.length >= 11 && v.length <= 11 || 'CPF Invalido',
    ],
    telefoneRules: [
      v => v.length >= 11 && v.length <= 11 || 'Telefone Invalido',
    ],
    cepRules: [
      v => v.length >= 8 && v.length <= 8 || 'CEP Invalido',
    ],
    salarioRules: [
      v => v >= 0  || 'Salário Invalido',
    ],
    numeroRules: [
      v => v >= 0 || 'Número Invalido',
    ],
    cidadeRules: [
      v => !!v || 'Nome Obrigatorio',
      v => v.length > 0 || 'Informe o nome completo',
    ],
    ruaRules: [
      v => !!v || 'Nome Obrigatorio',
      v => v.length > 0 || 'Informe o nome completo',
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
    }
  },

}
</script>
  

 
        