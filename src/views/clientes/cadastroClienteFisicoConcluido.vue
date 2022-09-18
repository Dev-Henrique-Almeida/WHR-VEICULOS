<template>
  <v-container>
    <v-row class="text-center">
      <v-col dark>
        <v-img :src="'https://www.gov.br/cgu/pt-br/100-dias/statusconcluido.png'" class="my-3" contain height="100" />
      </v-col>
      
    </v-row>
    <template>
      <v-card>
        <v-card-title>
          Cliente Cadastrado
          <v-spacer></v-spacer>
        </v-card-title>
        <template>
          <v-data-table :headers="headers" :items="desserts" hide-default-footer class="elevation-1"></v-data-table>
        </template>
        <br />
        <v-card-title>
          Endereço do Cliente
          <v-spacer></v-spacer>
        </v-card-title>
        <template>
          <v-data-table :headers="headers2" :items="desserts" hide-default-footer class="elevation-1"></v-data-table>
        </template>
        <br />
        <br />
      </v-card>
      <br />
        <v-btn @click="cadastrarOutro">Cadastrar Outro Cliente</v-btn>
    </template>
  </v-container>
</template>
<script>

export default {
  data() {
    return {

      headers: [
        {text: 'Nome', align: 'start', value: 'nome',},
        { text: 'CPF', value: 'cpf' },
        { text: 'Telefone', value: 'telefone' },
        { text: 'Data Nascimento', value: 'dataNascimento' },
      ],
      headers2: [
        {text: 'Cidade', align: 'start', value: 'cidade',},
        { text: 'Estado', value: 'estado' },
        { text: 'CEP', value: 'cep' },
        { text: 'Rua', value: 'rua' },
        { text: 'Numero', value: 'numero' },
      ],
      desserts: [{
          cpf: this.$route.params.user.cpf,
          nome: this.$route.params.user.nome,
          telefone: this.$route.params.user.telefone,
          dataNascimento: this.$route.params.user.dataNascimento,
          cidade: this.$route.params.user.endereco.cidade,
          estado: this.$route.params.user.endereco.estado,
          cep: this.$route.params.user.endereco.cep,
          rua: this.$route.params.user.endereco.rua,
          numero: this.$route.params.user.endereco.numero,
        },],
    }
  },
  methods: {
    cadastrarOutro() {
        this.$router.push({name: 'cadastroInicio'});
    }
  },
}
</script>

  
  