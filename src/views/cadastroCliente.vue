
<template>   
    <v-form v-model="valid">
      <v-container>
        <v-row>
          <v-col
            cols="12"
            md="4"
          >
            <v-text-field
              v-model="Nome"
              :rules="nameRules"
              :counter="40"
              label="Nome"
              required
            ></v-text-field>
            <v-text-field
              v-model="Nome"
              :rules="nameRules"
              :counter="40"
              label="Teste"
              required
            ></v-text-field>
          </v-col>
  
          <v-col
            cols="12"
            md="4"
          >
            <v-text-field
              v-model="cpf"
              :rules="cpfRules"
              :counter="11"
              label="CPF"
              required
            ></v-text-field>
          </v-col>
  
          <v-col
            cols="12"
            md="4"
          >
            <v-text-field
              v-model="email"
              :rules="emailRules"
              label="E-mail"
              required
            ></v-text-field>
          </v-col>
        </v-row>
      </v-container>
    </v-form>
  </template>
  <script>
    export default {
      data: () => ({
        valid: false,
        nome: '',
        cpf: '',
        nameRules: [
          v => !!v || 'Nome Obrigatorio',
          v => v.length >= 10 || 'Informe seu nome completo',
        ],
        cpfRules: [
          v => !!v || 'CPF Obrigatorio',
          v => v.length >= 11 || 'CPF Invalido',
        ],
        email: '',
        emailRules: [
          v => !!v || 'E-mail invalido',
          v => /.+@.+/.test(v) || 'E-mail must be valid',
        ],
      }),
    }
  </script>