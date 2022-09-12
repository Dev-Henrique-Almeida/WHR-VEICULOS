<template>
  <v-app>
    <v-app-bar
      app
      color="black"
      dark
    >
      <div class="d-flex align-center">
            <v-img
          alt="Vuetify Name"
          class="shrink mt-1 hidden-sm-and-down"
          contain
          min-width="175"
          src="./assets/logoWHR.png"
          width="175"
        />
      </div>

      <v-spacer></v-spacer>

      <v-btn
        href="https://github.com/WHR-PROJETO/WHR-VEICULOS"
        target="_blank"
        text
      >
        <span class="mr-2">Acesse GitHub</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn>
    </v-app-bar>

    <v-main>
      <HomePage/>
    </v-main>
  </v-app>
</template>

<script>
import HomePage from './components/HomePage';
export default {
  name: 'App',

  components: {
    HomePage,
  },
};
</script>
