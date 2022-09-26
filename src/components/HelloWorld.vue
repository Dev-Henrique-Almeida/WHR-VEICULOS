<template>
  <div>

    <v-container>
      <template>

      </template>

      <v-row class="text-center">
        <v-col cols="12">
          <v-img :src="require('../assets/3carros.png')" class="my-3" contain height="200" />
        </v-col>

        <v-col class="mb-4">
          <h1 class="display-2 font-weight-bold mb-3">
            Seja Bem Vindo á WHR Veiculos
          </h1>
          <br>
          <h3>
            Sua melhor opção em veículos 0Km e seminovos!
          </h3>
        </v-col>




      </v-row>



    </v-container>
  </div>
</template>

<script>
export default {

  data: () => ({
    fotosVeiculos: [
      {
        src: '@/assets/carro1_50.png',
      },
      {
        src: 'https://cdn.vuetifyjs.com/images/carousel/sky.jpg',
      },
      {
        src: 'https://cdn.vuetifyjs.com/images/carousel/bird.jpg',
      },
      {
        src: 'https://cdn.vuetifyjs.com/images/carousel/planet.jpg',
      },
    ],




  }),
}
</script>
<style>
  .texto {
    color: rgb(255, 255, 255);
    -webkit-stroke-color: rgb(255, 0, 0);
    -webkit-stroke-width: 12px;
}
.img{
  filter: brightness(90%)
}
</style>
