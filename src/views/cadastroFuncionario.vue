
<template>

  <v-form v-model="valid">
    <v-container>
      <div>
        <h1> Cadastro de Funcionario</h1>
      </div>
      <div>
        <h3> Informações pessoais</h3>
      </div>
      <v-row>
        <v-col cols="12" md="4">
          <v-text-field v-model="funcionario.nome" :rules="nameRules" :counter="40" label="Nome" required>
          </v-text-field>
          <v-text-field v-model="funcionario.dataNascimento" type="date" label="Data de nascimento" required>
          </v-text-field>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="funcionario.cpf" :rules="cpfRules" :counter="11" label="CPF" required></v-text-field>
          <v-text-field v-model="funcionario.telefone" :rules="telefoneRules" type="phone" label="Telefone" required>
          </v-text-field>
        </v-col>
      </v-row>

      <div>
        <h3> Endereço</h3>
      </div>
      <v-row>
        <v-col cols="12" md="4">
          <v-text-field v-model="funcionario.endereco.cidade" :counter="40" label="Cidade" required></v-text-field>
          <v-text-field v-model="funcionario.endereco.estado" label="Estado" required></v-text-field>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="funcionario.endereco.rua" :counter="40" label="Logradouro" required></v-text-field>
          <v-text-field v-model="funcionario.endereco.numero" label="Numero" required></v-text-field>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="funcionario.endereco.cep" label="CEP" required></v-text-field>
        </v-col>
      </v-row>

      <div>
        <h3> Atribuições</h3>
      </div>
      <v-row>
        <v-col cols="12" md="4">
          <v-text-field v-model="funcionario.cargo" :counter="20" label="Cargo" required></v-text-field>
          <v-text-field v-model="funcionario.salario" :counter="11" label="Salario" required></v-text-field>
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
      v => v.length >= 11 || 'CPF Invalido',
    ],
    telefoneRules: [
      v => v.length >= 9 || 'Telefone Invalido',
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
  

 
        