<template>
    <v-data-table :headers="headers" :items="desserts" sort-by="calories" class="elevation-1">
        <template v-slot:top>
            <v-toolbar flat>
                <v-toolbar-title>Atualizar Cliente Fisico</v-toolbar-title>
                <v-divider class="mx-4" inset vertical></v-divider>
                <v-spacer></v-spacer>
                <v-dialog v-model="dialog" max-width="500px">
                    <template v-slot:activator="{ on, attrs }">
                        <v-btn color="primary" dark class="mb-2" v-bind="attrs" @click="cadastrarCliente" v-on="on">
                            Cadastrar Novo Cliente
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
                                        <v-text-field v-model="editedItem.nome" :rules="nameRules" label="Nome">
                                        </v-text-field>
                                    </v-col>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.telefone" :rules="telefoneRules"
                                            v-mask="'(##) #####-####'" type="text" label="Telefone"></v-text-field>
                                    </v-col>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-text-field v-model="editedItem.endereco.cidade" :rules="cidadeRules"
                                            label="Cidade">
                                        </v-text-field>
                                    </v-col>
                                    <v-col cols="12" sm="6" md="4">
                                        <v-select :items="estados" v-model="editedItem.endereco.estado" label="UF">
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
                        <v-card-title class="text-h9">Você tem certeza que deseja remover esse cliente?</v-card-title>
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
import CadastroClienteFisicoService from '@/service/CadastroClienteFisicoService'
export default {
    data: () => ({
        dialog: false,
        dialogDelete: false,
        search: '',
        headers: [
            { text: 'ID', value: 'id' },
            { text: 'Nome', value: 'nome' },
            { text: 'CPF', value: 'cpf' },
            { text: 'Telefone', value: 'telefone' },
            { text: 'Cidade', value: 'endereco.cidade' },
            { text: 'Estado', value: 'endereco.estado' },
            { text: 'Actions', value: 'actions', sortable: false },
        ],
        nameRules: [
            v => !!v || 'Campo Obrigatorio',
            v => !!v.length || 'Campo Obrigatorio',
            v => v.length >= 4 && v != null || 'Informe seu nome completo',
        ],
        telefoneRules: [
            v => !!v || 'Campo Obrigatorio',
            v => v.length >= 15 && v.length <= 15 && v != null || 'Telefone Invalido',
        ],
        cidadeRules: [
            v => !!v || 'Campo Obrigatorio',
            v => v.length > 0 && v != null || 'Informe o nome completo',
        ],
        ruaRules: [
            v => !!v || 'Campo Obrigatorio',
            v => v.length > 0 && v != null || 'Informe o nome completo',
        ],
        desserts: [],
        editedIndex: -1,
        editedItem: {

            nome: '',
            telefone: '',
            cpf: '',
            endereco: {
                cidade: '',
                estado: '',
            }
        },
        defaultItem: {

            nome: '',
            cpf: '',
            telefone: '',
            endereco: {
                cidade: '',
                estado: '',
            }
        },
        estados: ['Acre', 'Alagoas', 'Amapá', 'Amazonas', 'Bahia', 'Ceará', 'Distrito Federal', 'Espírito Santo', 'Goiás', 'Maranhão', 'Mato Grosso', 'Mato Grosso do Sul',
            'Minas Gerais', 'Paraná', 'Paraíba', 'Pará', 'Pernambuco', 'Piauí', 'Rio de Janeiro', 'Rio Grande do Norte', 'Rio Grande do Sul',
            'Rondonia', 'Roraima', 'Santa Catarina', 'Sergipe', 'São Paulo', 'Tocantins']
    }),
    computed: {
        formTitle() {
            return this.editedIndex === -1 ? 'New Item' : 'Editar Cliente'
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
            CadastroClienteFisicoService.getAll().then(
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

            CadastroClienteFisicoService.deleteById(this.desserts[this.editedIndex].id);
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
            alert("Cliente Atualizado com Sucesso!")
            if (this.editedIndex > -1) {
                Object.assign(this.desserts[this.editedIndex], this.editedItem)

                console.log(this.editedItem)
                CadastroClienteFisicoService.update(this.desserts[this.editedIndex].id, this.editedItem).then(
                    response => { console.log(response.status); }).catch(e => {
                        console.log(e.response.data.message);
                        alert(e.response.data.message);

                    });
            } else {
                this.desserts.push(this.editedItem)
            }


            this.close()
        },
        cadastrarCliente() {
            this.$router.push({ name: 'cadastroClienteFisico' });
        },
    },
    mounted() {
        this.loadAll();

    }

}
</script>