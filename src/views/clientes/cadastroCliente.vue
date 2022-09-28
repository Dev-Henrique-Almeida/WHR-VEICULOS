
<template>

  <v-form v-model="valid">
    <v-container>
      <div>
        <h1> Cadastro de Clientes</h1>
      </div>
      <div>
        <h3> Informações pessoais </h3>
      </div>
      <v-row>
        <v-col cols="12" md="4">
          <v-text-field v-model="pessoa.nome" :rules="nameRules" label="Nome" required></v-text-field>
          <v-text-field v-model="pessoa.dataNascimento" type="date" label="Data de nascimento" required></v-text-field>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="pessoa.cpf" :rules="cpfRules" v-mask="'###########'" type="text" label="CPF" required>
          </v-text-field>
          <v-text-field v-model="pessoa.telefone" :rules="telefoneRules" v-mask="'(##) #####-####'" type="text"
            label="Telefone" required>
          </v-text-field>
        </v-col>

      </v-row>
      <div>
        <h3> Endereço</h3>
      </div>
      <v-row>
        <v-col cols="12" md="4">
          <v-text-field v-model="pessoa.endereco.cidade" :rules="cidadeRules" label="Cidade" required></v-text-field>
          <v-select :items="estados" v-model="pessoa.endereco.estado" label="Estado" required></v-select>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="pessoa.endereco.rua" :rules="ruaRules" label="Logradouro" required></v-text-field>
          <v-text-field v-model="pessoa.endereco.numero" :rules="numeroRules" type="number" label="Numero" required>
          </v-text-field>
        </v-col>

        <v-col cols="12" md="4">
          <v-text-field v-model="pessoa.endereco.cep" :rules="cepRules" v-mask="'########'" type="text" label="CEP"
            required></v-text-field>
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
import CadastroClienteFisicoService from '@/service/CadastroClienteFisicoService';
import { reactive } from 'vue'
export default {
  data: () => ({
    valid: false,
    nameRules: [
      v => !!v || 'Nome Obrigatorio',
      v => !!v.length || 'Nome Obrigatorio',
      v => v.length >= 4 && v != null || 'Informe seu nome completo',
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
      v => !!v || 'Número Obrigatorio',
      v => v >= 0 && v != null || 'Número Invalido',
    ],
    cepRules: [
      v => !!v || 'CEP Obrigatorio',
      v => v.length >= 8 && v.length <= 8 && v != null || 'CEP Invalido',
    ],
    cidadeRules: [
      v => !!v || 'Nome Obrigatorio',
      v => v.length > 0 && v != null || 'Informe o nome completo',
    ],
    ruaRules: [
      v => !!v || 'Nome Obrigatorio',
      v => v.length > 0 && v != null || 'Informe o nome completo',
    ],
    aux: 0,
    pessoa: reactive({
      nome: '',
      cpf: '',
      dataNascimento: '',
      telefone: '',
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

      console.log(this.pessoa)
      CadastroClienteFisicoService.create(this.pessoa).then(response => { console.log(response.status),
        this.continuar(); 
      }).catch(e => {
        console.log(e.response.data.message);
        alert(e.response.data.message)})
      
    },
    continuar() {
      if(this.aux != 1){
        this.$router.push({ name: 'home' });
      }else{
        alert("Teste");
      }
      
    }
  },

}
</script>
  

 
        