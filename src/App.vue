<template>
  <v-app id="inspire">
    <v-img src="./assets/fundoPreto.jpg">
    

    
    <v-app-bar app color="black">
      <v-app-bar-nav-icon @click="drawer = !drawer" color="white"></v-app-bar-nav-icon>
      <v-img alt="Vuetify Name" class="shrink mt-1 hidden-sm-and-down" contain min-width="175"
        src="./assets/logoWHR.png" width="175" />

    </v-app-bar>
    <v-main class="">
      <router-view>

      </router-view>


    </v-main>
    <v-navigation-drawer v-model="drawer" app>
      <v-list-item>
        <v-list-item-content>

          <v-list-item-title class="text-h6">
            WHR Veiculos
          </v-list-item-title>
          <v-list-item-subtitle>
            Mais que um carro, uma paixão.
          </v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>

      <v-divider></v-divider>

      <v-list dense nav>
        <v-list-item v-for="item in items" :key="item.title" :to="item.to" link>
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </v-img>
  </v-app>
</template>
<script>
export default {
  data: () => ({
    drawer: false,

    items: [
      { title: 'Home', icon: 'mdi-view-dashboard', to: '/' },
      { title: 'Cadastrar Cliente Físico', icon: 'mdi-view-dashboard', to: '/cadastroInicio' },
      { title: 'Cadastrar Cliente Jurídico', icon: 'mdi-view-dashboard', to: '/cadastroClienteJuridico' },
      { title: 'Cadastrar Funcionarios', icon: 'mdi-view-dashboard', to: '/cadastroFuncionario' },
      { title: 'Cadastrar Veiculo Novo ', icon: 'mdi-view-dashboard', to: '/cadastroVeiculoNovo' },
      { title: 'Cadastrar Modelo', icon: 'mdi-view-dashboard', to: '/cadastroModelo' },
      { title: 'Todos os Clientes', icon: 'mdi-view-dashboard', to: '/clientes' },
      { title: 'Todos os Funcionarios', icon: 'mdi-view-dashboard', to: '/funcionarios' },
      { title: 'Todos os Veiculos Novos', icon: 'mdi-view-dashboard', to: '/veiculosNovos' },
      { title: 'Todos os Modelos', icon: 'mdi-view-dashboard', to: '/modelos' },
      { title: 'Tcpf', icon: 'mdi-view-dashboard', to: '/cpfCliente' },
      


      { title: 'Sobre', icon: 'mdi-help-box' },
    ],
    right: null,
  }),

}
</script>

