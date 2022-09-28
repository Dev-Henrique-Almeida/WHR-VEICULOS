<template>
    <div>
        <v-img :src="require('@/assets/carro3.jpg')">
            <center>
                <br />
                <br />
                <br />
                <br />
                <v-card height="320" width="750" color="grey darken-4">
                    <br />
                    <v-img :src="require('@/assets/cliente.png')" class="my-3" contain height="150" />
                    <h1 class="display-1 font-weight-bold mb-3" color="black">
                        Cadastro Concluido Com Sucesso!</h1>
                        <v-btn class="ma-2" :loading="loading" :disabled="loading" color="grey darken-1" @click="home"> Cadastrar Outro Cliente</v-btn>
                        <v-btn class="ma-2" :loading="loading" :disabled="loading" color="grey darken-1" @click="home"> Ver Todos Os Cliente</v-btn>
                        <v-btn class="ma-2" :loading="loading" :disabled="loading" color="light-blue darken-4" @click="home"> Home</v-btn>
                </v-card>
            </center>
        </v-img>
    </div>
</template>
<script>
   
    export default {

      methods: {
        home() {
          this.$router.push({ name: 'home' });
        },

    }     
    }
    </script>
    
    