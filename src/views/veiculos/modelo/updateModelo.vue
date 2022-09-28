<template>
    <v-data-table :headers="headers" :items="desserts" sort-by="calories" class="elevation-1">
        <template v-slot:top>
            <v-toolbar flat>
                <v-toolbar-title>Atualizar Modelo</v-toolbar-title>
                <v-divider class="mx-4" inset vertical></v-divider>
                <v-spacer></v-spacer>
                <v-dialog v-model="dialog" max-width="500px">
                    <template v-slot:activator="{ on, attrs }">
                        <v-btn color="primary" dark class="mb-2" v-bind="attrs" v-on="on">
                            New Item
                        </v-btn>
                    </template>
                    <v-card>
                        <v-card-title>
                            <span class="text-h5">{{ formTitle }}</span>
                        </v-card-title>

                        <v-card-text>
                            <v-container>
                                <v-row>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.nomeMarca" :rules="nameRules" label="Marca">
                                        </v-text-field>
                                    </v-col>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.nomeModelo" :rules="nameRules"
                                            label="Nome Modelo">
                                        </v-text-field>
                                    </v-col>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.motor" :rules="motorRules" label="Motor">
                                        </v-text-field>
                                    </v-col>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.anoFabricado" v-mask="'####'"
                                            :rules="anoRules" type="number" label="Ano Fabricado">
                                        </v-text-field>
                                    </v-col>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-select :items="combustiveis" v-model="editedItem.combustivel"
                                            label="Combustível">
                                        </v-select>
                                    </v-col>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.quantidadePassageiros" v-mask="'##'"
                                            :rules="passageirosRules" type="number" label="Quant. Passageiros">
                                        </v-text-field>
                                    </v-col>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-select :items="cores" v-model="editedItem.cor" label="Cor">
                                        </v-select>
                                    </v-col>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.potencia" v-mask="'####'"
                                            :rules="potenciaRules" type="number" label="Potência">
                                        </v-text-field>
                                    </v-col>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.cilindradas" v-mask="'####'"
                                            :rules="potenciaRules" type="number" label="Cilindradas">
                                        </v-text-field>
                                    </v-col>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-select :items="cambios" v-model="editedItem.cambio" label="Câmbio">
                                        </v-select>
                                    </v-col>

                                </v-row>
                            </v-container>

                        </v-card-text>

                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="blue darken-1" text @click="close">
                                Cancelar
                            </v-btn>
                            <v-btn color="blue darken-1" text @click="save">
                                Salvar
                            </v-btn>
                        </v-card-actions>
                    </v-card>
                </v-dialog>
                <v-dialog v-model="dialogDelete" max-width="530px">
                    <v-card>
                        <v-card-title class="text-h9"> Você tem certeza que deseja remover esse Modelo?</v-card-title>
                        <v-card-actions>
                            <v-spacer></v-spacer>
                            <v-btn color="blue darken-1" text @click="closeDelete">Cancel</v-btn>
                            <v-btn color="blue darken-1" text @click="deleteItemConfirm">OK</v-btn>
                            <v-spacer></v-spacer>
                        </v-card-actions>
                    </v-card>
                </v-dialog>
            </v-toolbar>

        </template>
        <template v-slot:[`item.actions`]="{ item }">
            <v-icon small class="mr-2" @click="editItem(item)">
                mdi-pencil
            </v-icon>
            <v-icon small @click="deleteItem(item)">
                mdi-delete
            </v-icon>
        </template>
        <template v-slot:no-data>
            <v-btn color="primary" @click="initialize">
                Resetar
            </v-btn>

        </template>

    </v-data-table>

</template>

<script>
import CadastroModeloService from '@/service/CadastroModeloService'
export default {
    data: () => ({
        dialog: false,
        dialogDelete: false,
        headers: [
            { text: 'ID', value: 'id' },
            { text: 'Marca', value: 'nomeMarca' },
            { text: 'Modelo', value: 'nomeModelo' },
            { text: 'Motor', value: 'motor' },
            { text: 'Ano de Fabricação', value: 'anoFabricado' },
            { text: 'Combustível', value: 'combustivel' },
            { text: 'Cor', value: 'cor' },
            { text: 'Quantidade Passageiros', value: 'quantidadePassageiros' },
            { text: 'Cilindradas', value: 'cilindradas' },
            { text: 'Potencia', value: 'potencia' },
            { text: 'Câmbio', value: 'cambio' },
            { text: 'Actions', value: 'actions', sortable: false },
        ],
        nameRules: [
            v => !!v || 'Campo Obrigatório',
            v => !!v.length || 'Nome Obrigatório',
            v => v.length >= 1 && v != null || 'Informe seu nome completo',
        ],

        corRules: [
            v => !!v || 'Campo Obrigatório',
            v => !!v.length || 'Cor Obrigatória',
            v => v.length >= 4 && v != null || 'Informe o nome da cor',
        ],
        motorRules: [
            v => !!v || 'Motor Obrigatório',
            v => !!v.length || 'Motor Obrigatório',
            v => v.length >= 1 && v != null || 'Informe o nome do motor',
        ],

        anoRules: [
            v => !!v || 'Campo Obrigatório',
            v => v >= 1900 && v <= 2023 || 'Ano Inválido',
        ],
        passageirosRules: [
            v => !!v || 'Campo Obrigatório',
            v => v > 0 && v <= 25 || 'Quantidade de Passageiros Inválida',
        ],
        potenciaRules: [
            v => !!v || 'Campo Obrigatório',
            v => v > 0 && v <= 1000 || 'Potência Inválida',
        ],
        desserts: [],
        editedIndex: -1,
        editedItem: {

            nomeMarca: '',
            nomeModelo: '',
            motor: '',
            anoFabricado: '',
            combustivel: '',
            cor: '',
            quantidadePassageiros: '',
            cilindradas: '',
            cambio: '',
        },
        defaultItem: {

            nomeMarca: '',
            nomeModelo: '',
            motor: '',
            anoFabricado: '',
            combustivel: '',
            quantidadePassageiros: '',
            cilindradas: '',
            cambio: '',

        },
        combustiveis: ['Gasolina', 'Álcool', 'Diesel', 'Flex(Gasolina/Álcool)'],
        cambios: ['Automático', 'Manual', 'Semi-Automático'],
        cores: ['Azul', 'Verde', 'Amarelo', 'Roxo', 'Rosa', 'Vermelho', 'Laranja', 'Marrom', 'Cinza', 'Branco', 'Preto']
    }),
    computed: {
        formTitle() {
            return this.editedIndex === -1 ? 'New Item' : 'Editar Modelo'
        },
    },
    watch: {
        dialog(val) {
            val || this.close()
        },
        dialogDelete(val) {
            val || this.closeDelete()
        },
    },
    created() {
        this.initialize()
    },
    methods: {
        initialize() {
            this.desserts = [
            ]
        },
        loadAll() {
            CadastroModeloService.getAll().then(
                response => {
                    this.desserts = response.data;
                }
            );
        },
        editItem(item) {
            this.editedIndex = this.desserts.indexOf(item)
            this.editedItem = Object.assign({}, item)
            this.dialog = true
        },
        deleteItem(item) {
            this.editedIndex = this.desserts.indexOf(item)
            this.editedItem = Object.assign({}, item)
            this.dialogDelete = true

        },
        deleteItemConfirm() {

            CadastroModeloService.deleteById(this.desserts[this.editedIndex].id).then(
                response => {
                    alert("Modelo Removido com Sucesso!"),
                        console.log(response.status);
                }).catch(e => {
                    console.log(e.response.data.message);
                    alert(e.response.data.message);
                });
            this.desserts.splice(this.editedIndex, 1)


            this.closeDelete()



        },
        close() {

            this.dialog = false
            this.$nextTick(() => {
                this.editedItem = Object.assign({}, this.defaultItem)
                this.editedIndex = -1

            })
        },
        closeDelete() {
            this.dialogDelete = false
            this.$nextTick(() => {
                this.editedItem = Object.assign({}, this.defaultItem)
                this.editedIndex = -1


            })
        },
        save() {
            if (this.editedIndex > -1) {
                Object.assign(this.desserts[this.editedIndex], this.editedItem)

                console.log(this.editedItem)
                CadastroModeloService.update(this.desserts[this.editedIndex].id, this.editedItem).then(
                    response => {
                        alert("Modelo Atualizado com Sucesso!"),
                            console.log(response.status);
                    }).catch(e => {
                        console.log(e.response.data.message);
                        alert(e.response.data.message);

                    });
            } else {
                this.desserts.push(this.editedItem)
            }


            this.close()
        },


    },
    mounted() {
        this.loadAll();

    }

}
</script>