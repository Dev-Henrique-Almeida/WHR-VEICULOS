
<template>
    <v-item-group>
        <v-img src="@/assets/pistaCarro.jpg">
            <v-container>
                <v-row>
                    <v-col cols="4">
                        <br/>
                        <v-card height="100" @click="todasVendasPessoaFisica" class="d-flex align-center" color="blue-grey darken-4">
                            <div class="text-h6 flex-grow-1 text-center"> Todas as Vendas Pessoa Fisica</div>
                        </v-card>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-card height="100" @click="todasVendasPessoaJuridica" class="d-flex align-center" color="blue-grey darken-4">
                            <div class="text-h6 flex-grow-1 text-center"> Todas as Vendas Pessoa Juridica</div>
                        </v-card>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-card height="100" @click="cancelaVendaPessoaJuridica" class="d-flex align-center" color="blue-grey darken-4">
                            <div class="text-h6 flex-grow-1 text-center"> Cancelar Venda - Pessoa Juridica</div>
                        </v-card>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-card height="100" @click="cancelaVendaPessoaFisica" class="d-flex align-center" color="blue-grey darken-4">
                            <div class="text-h6 flex-grow-1 text-center"> Cancelar Venda - Pessoa Fisica</div>
                        </v-card>
                    </v-col>
                </v-row>
            </v-container>
        </v-img>
    </v-item-group>
</template>
<script>
export default {

    methods: {
        home() {
            this.$router.push({ name: 'home' });
        },
        todasVendasPessoaFisica() {
            this.$router.push({ name: 'todasVendasPessoaFisica' });
        },
        todasVendasPessoaJuridica() {
            this.$router.push({ name: 'todasVendasPessoaJuridica' });
        },
        cancelaVendaPessoaJuridica() {
            this.$router.push({ name: 'cancelarVendaJuridica' });
        },
        cancelaVendaPessoaFisica() {
            this.$router.push({ name: 'cancelarVendaFisica' });
        },
    }
    
}
</script>