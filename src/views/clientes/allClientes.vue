<template>
  <v-container>
    
    <v-row class="text-center">
      <v-col dark>
        <v-img :src="require('@/assets/3carros.png')" class="my-3" contain height="200" />
      </v-col>
    </v-row>
    <template>
      <center>
        <h1>WHR Veiculos</h1>
      </center>
      <v-card>
        <v-card-title>
          Lista de Clientes Fisicos
          <v-spacer></v-spacer>
          <v-text-field v-model="search" append-icon="mdi-magnify" label="Search" single-line hide-details>
          </v-text-field>
        </v-card-title>
        <v-data-table :headers="headers" :items="usuarios" :search="search">
          <template slot="items" slot-scope="clientPF">
            <td>{{clientPF.nome}}</td>
            <td>{{clientPF.cpf}}</td>
            <td>{{clientPF.telefone}}</td>
            <td>{{clientPF.id}}</td>
            <td>{{clientPF.endereco.cidade}}</td>
            <td>{{clientPF.endereco.estado}}</td>
          </template>
        </v-data-table>
      </v-card>
      <br/>
      <br/>
      <br/>
       <v-card>
        <v-card-title>
          
          Lista de Clientes Juridicos
          <v-spacer></v-spacer>
          <v-text-field v-model="searchPJ" append-icon="mdi-magnify" label="Search" single-line hide-details>
          </v-text-field>
        </v-card-title>
        <v-data-table :headers="headers2" :items="empresas" :search="searchPJ">
          <template slot="items" slot-scope="clientPJ">
            <td>{{clientPJ.nomeEmpresarial}}</td>
            <td>{{clientPJ.cnpj}}</td>
            <td>{{clientPJ.telefone}}</td>
            <td>{{clientPJ.id}}</td>
            <td>{{clientPJ.endereco.cidade}}</td>
            <td>{{clientPJ.endereco.estado}}</td>

          </template>
        </v-data-table>
      </v-card>
      <br/>
      <br/>
      <br/>
      <br/>
    </template>
    
  </v-container>
</template>

<script>
import CadastroClienteJuridicoService from '@/service/CadastroClienteJuridicoService';
import CadastroClienteFisicoService from '@/service/CadastroClienteFisicoService'

export default {
  name: 'HomePage',
  data() {
    return {
      search: '',
      searchPJ: '',
      usuarios: [],
      empresas: [],
      headers: [
        { text: 'ID', value: 'id' },
        { text: 'Nome', value: 'nome' },
        { text: 'CPF', value: 'cpf' },
        { text: 'Telefone', value: 'telefone' },
        { text: 'Cidade', value: 'endereco.cidade' },
        { text: 'UF', value: 'endereco.estado' },
      ],
       headers2: [
        { text: 'ID', value: 'id' },
        { text: 'Nome', value: 'nomeEmpresarial' },
        { text: 'CNPJ', value: 'cnpj' },
        { text: 'Telefone', value: 'contato' },
        { text: 'Cidade', value: 'endereco.cidade' },
        { text: 'UF', value: 'endereco.estado' },
      ],
      carros: [
        {
          src: 'https://s2.glbimg.com/6JIKpLXJEJiMzBM0E4MrIwxoazU=/0x0:1300x805/924x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2022/H/C/eJ6shcQKuBA1gh0uxDXw/volkswagen-voyage-22.jpg',
        },
        {
          src: 'https://s2.glbimg.com/k9sT8yqv4e4ZILNsFZKuyjrOGfI=/0x0:1024x695/1008x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_59edd422c0c84a879bd37670ae4f538a/internal_photos/bs/2020/1/z/sp5b91RLSYB0BvH8UYAA/bmw-m3-competition-38-0297029d0c720872-1-.jpg',
        },
        {
          src: 'https://www.olhardireto.com.br/imgsite/noticias/camaro1.jpg',
        },
        {
          src: 'https://blog.jocar.com.br/wp-content/uploads/2019/09/autowp.ru_chevrolet_celta_3_door_6.jpg',
        },
      ],
    }
  },
  methods: {
    loadAll() {
      CadastroClienteFisicoService.getAll().then(
        response => {
          this.usuarios = response.data;
        }
      );
    },
     loadAllPJ() {
        CadastroClienteJuridicoService.getAll().then(
        response => {
          this.empresas = response.data;
        }
      );
    }
  },
  mounted() {
    this.loadAll();
    this.loadAllPJ();
  }

}

</script>

