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

      <template>
    <v-card class="mx-auto" width="300">
        
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
    </v-card>
</template>
    </v-navigation-drawer>
  </v-img>
  </v-app>
</template>
<script>
//import { mdiHome } from '@mdi/js'
export default {
  data: () => ({
    drawer: false,

    items: [
      { title: 'Home', icon: 'mdi-home', to: '/' },
      { title: 'Cadastrar Cliente Físico', icon: 'mdi-account', to: '/cadastroInicio' },
      { title: 'Cadastrar Cliente Jurídico', icon: 'mdi-account', to: '/cadastroClienteJuridico' },
      { title: 'Cadastrar Funcionarios', icon: 'mdi-account', to: '/cadastroFuncionario' },
      { title: 'Cadastrar Modelo', icon: 'mdi-car-outline', to: '/cadastroModelo' },
      { title: 'Cadastro Veiculo', icon: 'mdi-car', to: '/CadastrarVeiculo' },
      { title: 'Todos os Veiculos Novos', icon: 'mdi-magnify', to: '/veiculosNovos' },
      { title: 'Todos os Veiculos Usados', icon: 'mdi-magnify', to: '/veiculosUsados' },
      { title: 'Todos os Clientes', icon: 'mdi-account-multiple', to: '/clientes' },
      { title: 'Todos os Funcionarios', icon: 'mdi-magnify', to: '/funcionarios' },
      { title: 'Todos os Modelos', icon: 'mdi-magnify', to: '/modelos' },
      { title: 'Venda', icon: 'mdi-cart', to: '/vendaVeiculo' },
      { title: 'Venda juridica', icon: 'mdi-cart', to: '/VendaVeiculoPessoaJuridica' },
      { title: 'Sobre', icon: 'mdi-information' },
      
    ],
    right: null,
  }),

}
</script>

