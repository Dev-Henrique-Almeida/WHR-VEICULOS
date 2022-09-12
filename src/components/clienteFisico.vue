<template>
    <v-container>
      <v-row class="text-center">
        <v-col dark>
          <v-img
            :src="require('../assets/logo.png')"
            class="my-3"
            contain
            height="200"
          />
        </v-col>
  
        <v-col class="mb-4">
          <h1 class="display-2 font-weight-bold mb-3">
            Welcome to HWR Veiculos
          </h1>
  
          <p class="subheading font-weight-regular">
            Bem vindo a WHR Veiculos, o melhor lugar para adquirir seu veiculo!
            <br>acesse nosso projeto em 
            <a
              href="https://github.com/WHR-PROJETO/WHR-VEICULOS"
              target="_blank"
            >GitHub Community</a>
          </p>
        </v-col>
  
        <v-col
          class="mb-5"
          cols="12"
        >
          <h2 class="headline font-weight-bold mb-3">
            What's next?
          </h2>
  
          <v-row justify="center">
            <a
              v-for="(next, i) in whatsNext"
              :key="i"
              :href="next.href"
              class="subheading mx-3"
              target="_blank"
            >
              {{ next.text }}
            </a>
          </v-row>
        </v-col>
  
        <v-col
          class="mb-5"
          cols="12"
        >
          <h2 class="headline font-weight-bold mb-3">
            Important Links
          </h2>
  
          <v-row justify="center">
            <a
              v-for="(link, i) in importantLinks"
              :key="i"
              :href="link.href"
              class="subheading mx-3"
              target="_blank"
            >
              {{ link.text }}
            </a>
          </v-row>
        </v-col>
  
        <v-col
          class="mb-5"
          cols="12"
        >
          <h2 class="headline font-weight-bold mb-3">
            Ecosystem
          </h2>
  
          <v-row justify="center">
            <a
              v-for="(eco, i) in ecosystem"
              :key="i"
              :href="eco.href"
              class="subheading mx-3"
              target="_blank"
            >
              {{ eco.text }}
            </a>
          </v-row>
        </v-col>
      </v-row>
    </v-container>
  </template>
  
  <script>
    export default {
      name: 'clienteFisico',
  
      }
  
  </script>
  