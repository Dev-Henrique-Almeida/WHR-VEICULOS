
<template>
    <v-item-group>
        <v-img src="../assets/carro6.png">
            <v-container>
                <v-row>
                    <v-col cols="4">
                        <br/>
                        <v-card height="100" @click="listFuncionarios" class="d-flex align-center" color="blue-grey darken-4">
                            <div class="text-h6 flex-grow-1 text-center"> Todos os Funcionarios</div>
                        </v-card>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-card height="100" @click="cadastrarFuncionario" class="d-flex align-center" color="blue-grey darken-4">
                            <div class="text-h6 flex-grow-1 text-center"> Cadastrar Funcionario</div>
                        </v-card>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-card height="100" @click="updatefuncionario" class="d-flex align-center" color="blue-grey darken-4">
                            <div class="text-h6 flex-grow-1 text-center"> Editar ou Remover Funcionarios</div>
                        </v-card>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col cols="4">
                        <v-card height="100" @click="home" class="d-flex align-center" color="blue-grey darken-4">
                            <div class="text-h6 flex-grow-1 text-center"> Cancelar Vendas</div>
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
        listFuncionarios() {
            this.$router.push({ name: 'funcionarios' });
        },
        cadastrarFuncionario() {
            this.$router.push({ name: 'cadastroFuncionario' });
        },
        updatefuncionario() {
            this.$router.push({ name: 'updatefuncionario' });
        },
    }

}
</script>