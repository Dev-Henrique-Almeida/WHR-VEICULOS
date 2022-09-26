<template>
  <div>
    <br />
    <br />
    <br />
    <br />
    <center>
      <v-img :src="require('@/assets/concluido.png')" class="my-3" contain height="150" />
      <h1>Venda Concluida Com Sucesso!</h1>

    </center>
    <template>
      <v-container>
        <v-card color="grey darken-4">
          <v-container>
            <br />
            <center>
              <h1> Resumo da Venda </h1>
            </center>
            <h2> Vendedor: </h2>
            <template>
              <v-data-table :headers="headersFuncionario" :items="funcionario" hide-default-footer class="elevation-1">
              </v-data-table>
            </template>
            <br />
            <h2>Cliente </h2>
            <template>
              <v-data-table :headers="headersClienteFisico" :items="cliente" hide-default-footer class="elevation-1">
              </v-data-table>
            </template>
            <br />
            <h2>Veiculo </h2>
            <template v-if="(condicaoVeiculo === 'Veiculo Usado')">
              <v-data-table :headers="headersVeiculoUsado" :items="veiculoUsado" hide-default-footer
                class="elevation-1"> </v-data-table>
            </template>
            <template v-if="(condicaoVeiculo === 'Veiculo Novo')">
              <v-data-table :headers="headersVeiculoNovo" :items="veiculoNovo" hide-default-footer class="elevation-1">
              </v-data-table>
            </template>
            <br />
            <h2>Informações de pagamento </h2>
            <template>
              <v-data-table :headers="headersPagamento" :items="[{formaPagamento,valorTotal}]" hide-default-footer
                class="elevation-1"> </v-data-table>
            </template>
          </v-container>
        </v-card>
      </v-container>
    </template>
  </div>
</template>