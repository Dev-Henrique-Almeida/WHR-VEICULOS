<template>
  <div>
    <v-img src="@/assets/pistaCarro.jpg">
      <br />
      <br />
      <br />
      <br />
      <br />
      <center>
      <v-card color="grey darken-4" height="320" width="650">
        <br/>
        <center>
          <v-img :src="require('@/assets/concluido.png')" class="my-3" contain height="150">
          </v-img>
          <h1>Venda Concluida Com Sucesso!</h1>
        </center>
        <center>
          <v-btn depressed color="secondary" @click="home">Home</v-btn>
          <v-btn class="ma-2" :loading="loading" :disabled="loading" color="secondary" @click="novaVenda">Realizar outra
            Venda</v-btn>
          <v-btn depressed color="secondary" @click="vendas">Ver Todas as Vendas </v-btn>
        </center>
      </v-card>
    </center>
    </v-img>
  </div>
</template>
<script>
 
export default {
    data() {
        return {
    }},
    methods: {
        home() {
            this.$router.push({ name: 'home' });
        },
        vendas() {
            this.$router.push({ name: 'todasVendasPessoaFisica' });
        },
        novaVenda(){
          this.$router.push({ name: 'vendaVeiculo' });
        },
    },
    mounted() {
       
    }
}
</script>
  
