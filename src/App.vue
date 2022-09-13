<template>
  <v-app>
    <v-app-bar app color="black" dark> 
      <div class="d-flex align-center">
        <v-img alt="Vuetify Logo" class="shrink mr-2" contain src="https://www.mouraautomoveis.com.br/images/carro.png"
          transition="scale-transition" width="40" />

        <v-img alt="Vuetify Name" class="shrink mt-1 hidden-sm-and-down" contain min-width="100"
          src="https://www.mouraautomoveis.com.br/images/carro.png" width="100" />
          <v-spacer></v-spacer>
          
      </div>
      <div>

      </div>
      <v-spacer></v-spacer>

      <v-btn href="https://www.mouraautomoveis.com.br/images/carro.png" target="_blank" text>
        <span class="mr-2">Latest Release</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn>
    </v-app-bar>

    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    //
  }),
};
</script>
