<template>
    <v-data-table :headers="headers" :items="desserts" sort-by="calories" class="elevation-1">
        <template v-slot:top>
            <v-toolbar flat>
                <v-toolbar-title>Atualizar Veiculo Novo</v-toolbar-title>
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
                                        <v-text-field v-model="editedItem.valorVenda" :rules="valorRules" type="number"
                                            label="Valor Venda">
                                        </v-text-field>
                                    </v-col>

                                    <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.valorCompraVeiculo" :rules="valorRules"
                                            type="number" label="Valor Compra">
                                        </v-text-field>
                                    </v-col>

                                    <v-col cols="12" sm="6" md="4">
                                        <v-select :items="garantia" v-model="editedItem.garantiaFabrica" type="text"
                                            label="Garantia">
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
                        <v-card-title class="text-h9"> Você tem certeza que deseja remover esse Veículo?
                        </v-card-title>
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
import CadastroVeiculoNovoService from '@/service/CadastroVeiculoNovoService'
export default {
    data: () => ({
        dialog: false,
        dialogDelete: false,
        headers: [
            { text: 'ID', value: 'id' },
            { text: 'Marca', value: 'modelo.nomeMarca' },
            { text: 'Modelo', value: 'modelo.nomeModelo' },
            { text: 'Combustível', value: 'modelo.combustivel' },
            { text: 'Valor Venda', value: 'valorVenda' },
            { text: 'Valor Compra', value: 'valorCompraVeiculo' },
            { text: 'Cor', value: 'modelo.cor' },
            { text: 'Quant. Passageiros', value: 'modelo.quantidadePassageiros' },
            { text: 'Garantia', value: 'garantiaFabrica' },
            { text: 'Chassi', value: 'chassi' },
            { text: 'Km`s', value: 'km' },
            { text: 'Actions', value: 'actions', sortable: false },
        ],
        valorRules: [
            v => !!v || 'Campo Obrigatório',
            v => !!v.length || 'Campo Obrigatório',
            v => v >= 0 || 'Valor inválido',
        ],
        desserts: [],
        editedIndex: -1,
        editedItem: {

            valorVenda: '',
            valorCompraVeiculo: '',
            garantiaFabrica: '',
        },
        defaultItem: {

            valorVenda: '',
            valorCompraVeiculo: '',

        },
        garantia: ['Sim', 'Não'],
    }),
    computed: {
        formTitle() {
            return this.editedIndex === -1 ? 'New Item' : 'Editar Veículo Novo'
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
            CadastroVeiculoNovoService.getAll().then(
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

            CadastroVeiculoNovoService.deleteById(this.desserts[this.editedIndex].id);
            alert("Veículo Novo Removido com Sucesso!")
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
            alert("Veículo Novo Atualizado com Sucesso!")
            if (this.editedIndex > -1) {
                Object.assign(this.desserts[this.editedIndex], this.editedItem)

                console.log(this.editedItem)
                CadastroVeiculoNovoService.update(this.desserts[this.editedIndex].id, this.editedItem).then(
                    response => { console.log(response.status); });
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