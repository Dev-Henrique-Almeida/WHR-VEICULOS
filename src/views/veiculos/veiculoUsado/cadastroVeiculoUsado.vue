
<template>
  <div>
    <v-form v-model="valid">
      <v-container>

        <h1>Cadastro de Veiculo Usado</h1>
        <br />
        <h3>Modelo Selecionado:</h3>
        <template>
          <v-card><template>
              <v-data-table :headers="headersModelo" :items="modeloItems" hide-default-footer class="elevation-1">
              </v-data-table>
            </template></v-card>
        </template>
        <br />
        <br />
        <h3> Informações do Veiculo</h3>
        <v-row>
          <v-col cols="12" md="4">
            <v-text-field v-model="veiculoUSado.valorCompraVeiculo" v-mask="'########'" :rules="valorRules"
              type="number" label="Valor de Compra" required></v-text-field>
            <v-text-field v-model="veiculoUSado.valorVenda" v-mask="'########'" :rules="valorRules" type="number"
              label="Valor de Venda" required>
            </v-text-field>
            <v-text-field v-model="veiculoUSado.placa" :rules="placaRules" :maxLength="7" type="text" label="Placa"
              required>
            </v-text-field>
          </v-col>

          <v-col cols="12" md="4">
            <v-select :items="revisado" v-model="veiculoUSado.unicoDono" :rules="campoRules" label="Único Dono"
              required>
            </v-select>
            <v-text-field v-model="veiculoUSado.chassi" :rules="chassiRules" :maxLength="17" label="Chassi" required>
            </v-text-field>
          </v-col>

          <v-col cols="12" md="4">
            <v-select :items="revisado" v-model="veiculoUSado.revisado" :rules="campoRules" label="Revisado" required>
            </v-select>
            <v-text-field v-model="veiculoUSado.km" v-mask="'#######'" :rules="ruaRules" type="number"
              label="Quilometragem" required>
            </v-text-field>
          </v-col>
        </v-row>
      </v-container>
    </v-form>
    <template>
      <div class="text-center">
        <v-btn class="ma-2" :loading="loading" :disabled="loading" color="secondary" @click="home">Cancelar</v-btn>
        <v-btn :loading="loading3" :disabled="loading3" color="blue-grey" class="ma-2 white--text" @click="irModelo">
          Selecionar outro Modelo</v-btn>
        <v-btn class="ma-2" :loading="loading" :disabled="loading" color="success" @click="cadastrar"> Concluir Cadastro
        </v-btn>
      </div>
    </template>
  </div>
</template>
    
<script>

import CadastroVeiculoUsadoService from '@/service/CadastroVeiculoUsadoService';



import { reactive } from 'vue'
export default {
  data: () => ({
    valid: false,
    nameRules: [
      v => !!v || 'Campo Obrigatório',
      v => !!v.length || 'Campo Obrigatório',
      v => v.length >= 10 || 'Informe seu nome completo',
    ],
    campoRules: [
      v => !!v || 'Campo Obrigatório',
      v => !!v.length || 'Campo Obrigatório',
      v => v.length >= 2 && v != null || 'Garantia inválida',
    ], chassiRules: [
      v => !!v || 'Campo Obrigatório',
      v => v.length >= 17 && v.length <= 17 && v != null || 'Chassi Inválido',
    ],
    placaRules: [
      v => !!v || 'Campo Obrigatório',
      v => v.length >= 7 && v.length <= 7 && v != null || 'Placa Inválida',
    ],
    valorRules: [
      v => !!v || 'Campo Obrigatório',
      v => !!v.length || 'Campo Obrigatório',
      v => v >= 0 || 'Valor inválido',
    ],
    ruaRules: [
      v => !!v || 'Campo Obrigatório',
      v => v > 0 && v != null || 'Informe o nome completo',
    ],
    veiculoUSado: reactive({
      valorCompraVeiculo: '',
      valorVenda: '',
      vendido: false,
      km: '',
      modelo: {},
      chassi: '',
      placa: '',
      revisado: '',
      unicoDono: '',
    }),
    revisado: ['Sim', 'Não'],
    modeloItems: [],
    headersModelo: [
      { text: 'Marca', value: 'nomeMarca' },
      { text: 'Modelo', value: 'nomeModelo' },
      { text: 'Motor', value: 'motor' },
      { text: 'Ano', value: 'anoFabricado' },
      { text: 'Combustível', value: 'combustivel' },
      { text: 'Cor', value: 'cor' },
      { text: 'Cilindradas', value: 'cilindradas' },
      { text: 'Potencia', value: 'potencia' },
      { text: 'Câmbio', value: 'cambio' },
      { text: 'Estado', value: 'estado' },
    ],

  }),
  methods: {
    loadAll() {
      this.modeloItems = this.veiculoUSado.modelo,
        this.veiculoUSado.modelo = this.$route.params.modelo[0];
      this.modeloItems = [{
        nomeMarca: this.veiculoUSado.modelo.nomeMarca,
        nomeModelo: this.veiculoUSado.modelo.nomeModelo,
        motor: this.veiculoUSado.modelo.motor,
        anoFabricado: this.veiculoUSado.modelo.anoFabricado,
        combustivel: this.veiculoUSado.modelo.combustivel,
        cor: this.veiculoUSado.modelo.cor,
        cilindradas: this.veiculoUSado.modelo.cilindradas,
        potencia: this.veiculoUSado.modelo.potencia,
        cambio: this.veiculoUSado.modelo.cambio,
        estado: 'Usado',
      }]

    },
    cadastrar() {
      console.log(this.veiculoUSado)
      CadastroVeiculoUsadoService.create(this.veiculoUSado).then(
        response => { console.log(response.status); }).catch(e => {
          console.log(e.response.data.message);
          alert(e.response.data.message);
        });
    },
    irModelo() {
      this.$router.push({ name: 'CadastrarVeiculo' });
    },
    home() {
      this.$router.push({ name: 'home' });
    },


  },

  mounted() {
    this.loadAll();
  }
}
</script>
  