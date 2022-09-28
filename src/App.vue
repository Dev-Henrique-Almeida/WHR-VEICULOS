<template>
  <v-app id="inspire">
    <v-img src="./assets/fundoPreto.jpg">


      <v-app-bar app color="black">
        <v-app-bar-nav-icon @click="drawer = !drawer" color="white"></v-app-bar-nav-icon>
        <v-img alt="Vuetify Name" class="shrink mt-1 hidden-sm-and-down" contain min-width="175"
          src="./assets/logoWHR.png" width="175" @click="home" />
        <v-spacer></v-spacer>

        <v-btn color="black" dark @click="cliente"> Clientes</v-btn>
        
        <v-btn color="black" dark @click="acessoRestrito"> Acesso Restrito
          <v-icon right dark>mdi-account-lock </v-icon>
        </v-btn>
      </v-app-bar>
      <v-main>
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
          <v-card class="mx-auto" width="320">
            <v-list dense nav>
              <v-list-item>
                <v-list-item-icon>
                  <v-icon>mdi-home</v-icon>
                </v-list-item-icon>
                <v-list-item-title @click="home">Home</v-list-item-title>
              </v-list-item>

              <v-list-group :value="false" prepend-icon="mdi-account-circle">
                <template v-slot:activator>
                  <v-list-item-title>Clientes</v-list-item-title>
                </template>
                <v-list-item v-for="item in clientes" :key="item.title" :to="item.to" link>
                  <v-list-item-icon>
                    <v-icon>{{ item.icon }}</v-icon>
                  </v-list-item-icon>
                  <v-list-item-content>
                    <v-list-item-title>{{ item.title }}</v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              </v-list-group>

              <v-list-group :value="false" prepend-icon="mdi-car">
                <template v-slot:activator>
                  <v-list-item-title>Veiculos</v-list-item-title>
                </template>
                <v-list-item v-for="item in veiculos" :key="item.title" :to="item.to" link>
                  <v-list-item-icon>
                    <v-icon>{{ item.icon }}</v-icon>
                  </v-list-item-icon>
                  <v-list-item-content>
                    <v-list-item-title>{{ item.title }}</v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              </v-list-group>

              <v-list-group :value="false" prepend-icon="mdi-car">
                <template v-slot:activator>
                  <v-list-item-title>Vendas</v-list-item-title>
                </template>
                <v-list-item v-for="item in vendas" :key="item.title" :to="item.to" link>
                  <v-list-item-icon>
                    <v-icon>{{ item.icon }}</v-icon>
                  </v-list-item-icon>
                  <v-list-item-content>
                    <v-list-item-title>{{ item.title }}</v-list-item-title>
                  </v-list-item-content>
                </v-list-item>
              </v-list-group>

              <v-list-item>
                <v-list-item-icon>
                  <v-icon>mdi-information</v-icon>
                </v-list-item-icon>
                <v-list-item-title @click="sobre">Sobre</v-list-item-title>
              </v-list-item>

            </v-list>
          </v-card>
        </template>
      </v-navigation-drawer>

    </v-img>
  </v-app>
</template>
<script>
export default {
  data: () => ({
    drawer: false,


    funcionario: [

      { title: 'Cadastrar Funcionarios', icon: 'mdi-account', to: '/cadastroFuncionario' },
      { title: 'Gerenciar Funcionários', icon: 'mdi-car', to: '/updateFuncionario' },
      { title: 'Todos os Funcionarios', icon: 'mdi-magnify', to: '/funcionarios' },
      { title: 'Sobre', icon: 'mdi-information' },
    ],
    vendas: [
      { title: 'Venda Pessoa Fisica', icon: 'mdi-cart', to: '/vendaVeiculo' },
      { title: 'Venda Pessoa juridica', icon: 'mdi-cart', to: '/VendaVeiculoPessoaJuridica' },
      { title: 'Todas as vendas PJ', icon: 'mdi-cart', to: '/todasVendasPessoaJuridica' },
      { title: 'Todas as vendas PF', icon: 'mdi-cart', to: '/todasVendasPessoaFisica' },

    ],

    clientes: [
      { title: 'Cadastrar Cliente Físico', icon: 'mdi-account', to: '/cadastroInicio' },
      { title: 'Cadastrar Cliente Jurídico', icon: 'mdi-account', to: '/cadastroClienteJuridico' },
      { title: 'Todos os Clientes', icon: 'mdi-account-multiple', to: '/clientes' },
      { title: 'Gerenciar Clientes Fisicos', icon: 'mdi-pencil', to: '/updateClienteFisico' },
      { title: 'Gerenciar Clientes Juridicos', icon: 'mdi-pencil', to: '/updateClienteJuridico' },
    ],

    veiculos: [
      { title: 'Cadastrar Modelo', icon: 'mdi-car-outline', to: '/cadastroModelo' },
      { title: 'Cadastro Veiculo', icon: 'mdi-car', to: '/CadastrarVeiculo' },
      { title: 'Todos os Veiculos Novos', icon: 'mdi-magnify', to: '/veiculosNovos' },
      { title: 'Todos os Veiculos Usados', icon: 'mdi-magnify', to: '/veiculosUsados' },
      { title: 'Todos os Modelos', icon: 'mdi-magnify', to: '/modelos' },
      { title: 'Gerenciar Modelos', icon: 'mdi-pencil', to: '/updateModelo' },
      { title: 'Gerenciar Veiculos Novos', icon: 'mdi-pencil', to: '/updateVeiculoNovo' },
      { title: 'Gerenciar Veiculos Usados', icon: 'mdi-pencil', to: '/updateVeiculoUsado' },
    ],
    right: null,
  }),
  methods: {
    home() {
      this.$router.push({ name: 'home' });
    },
    cliente() {
      this.$router.push({ name: 'clientes' });
    },
    acessoRestrito() {
      this.$router.push({ name: 'acessoRestrito' });
    },
    sobre() {
      this.$router.push({ name: 'sobre' });
    },
  }

}
</script>


<style>
.botao {
  justify-content: flex-end;
}
</style>