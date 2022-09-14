<template>
    <v-parallax dark src="https://images4.alphacoders.com/839/83944.jpg">
        <v-row align="center" justify="center" dark>
            <v-col class="text-center" cols="12">
                <h1 class="text-h4 font-weight-thin mb-4">
                    WHR Veiculos
                </h1>

                <v-form v-model="valid">
                    <v-container>
                        <v-row>
                            <v-col cols="12" md="4">
                            </v-col>
                            <v-col cols="12" md="4">
                                <v-text-field v-model="cpf" :rules="nameRules" :counter="11" label="CPF" required>
                                </v-text-field>
                            </v-col>
                        </v-row>
                    </v-container>
                </v-form>
                <h4 class="subheading">
                    Informe seu CPF para continuar com o cadastro!
                </h4>
            </v-col>
        </v-row>
    </v-parallax>
</template>
<script>
export default {
    data: () => ({
        cpf: '',
        nameRules: [
            v => !!v || 'CPF obrigatorio',
            v => v.length >= 11 || 'CPF invalido',
            v => v.length <= 11 || 'CPF invalido',
        ],
    }),
}
</script>
