<template>
  <div>
    <template>
      <v-card>
        <v-img src="@/assets/carro1_50.png" height="400">
          <br />
          <br />
          <br />
          <br />
          <br />
          <br />
          <center>
            <h1 class="titulo">
              WHR Veiculos
            </h1>
            <h3 class="subtitulo">
              Sua melhor opção em veículos 0Km e seminovos!
            </h3>
          </center>
        </v-img>
      </v-card>
    </template>
    <br />
    <br />
    <br />
    <center>
      <v-card color="black" height="200" width="1170" @click="modelos">
        <v-img src="@/assets/carro4.png" height="200" width="1170" class="img">
          <br />
          <br />
          <br />
          <h1 class="titulo"> Ver Todos os Modelos</h1>
        </v-img>
      </v-card>
    </center>

    <br />
    <br />
    <br />
    <br />
    <v-container>
      <template>
        <v-row>
          <v-col cols="6" sm="4">
            <v-img
              src="@/assets/carroHome1.webp"
              height="200">
            </v-img>
            <v-card-title>Onix Plus, o carro mais econômico do Brasil</v-card-title>
            <v-divider class="mx-4"></v-divider>
            <v-card-text>
              <div>Tá melhor pra quem tem um Onix Plus, dirija você também o sedan com o motor mais econômico do país.
              </div>
            </v-card-text>
            <v-card-actions>
              <v-btn color="deep-purple lighten-2" text @click="veiculos">
                Ir para Veiculos
              </v-btn>
            </v-card-actions>
          </v-col>

          <v-col cols="6" sm="4">
            <v-img
              src="@/assets/carroHome2.webp"
              height="200">
            </v-img>
            <v-card-title>S10 Cabine Dupla, a picape feita pra quem faz</v-card-title>
            <v-divider class="mx-4"></v-divider>
            <v-card-text>
              <div>Seja no campo ou na cidade, a S10 Cabine Dupla tem a força e a tecnologia que você precisa para
                fazer ainda mais</div>
            </v-card-text>
            <v-card-actions>
              <v-btn color="deep-purple lighten-2" text @click="veiculos">
                Ir para Veiculos
              </v-btn>
            </v-card-actions>
          </v-col>

          <v-col cols="6" sm="4">
            <v-img src="@/assets/r35.jpg" height="200">
              <div class="fill-height repeating-gradient"></div>
            </v-img>
            <v-card-title>O GT-R é o monstro que assombra o sono dos germânicos.
            </v-card-title>
            <v-divider class="mx-4"></v-divider>
            <v-card-text>
              <div>O Nissan GT-R é um modelo de automóvel superesportivo produzido pela Nissan, foi anunciado em 2001
                com o
                objetivo de dar sequencia a marca GT-R </div>
            </v-card-text>
            <v-card-actions>
              <v-btn color="deep-purple lighten-2" text @click="veiculos">
                Ir para Veiculos
              </v-btn>
            </v-card-actions>
          </v-col>
        </v-row>
      </template>
    </v-container>




  </div>
</template>

<script>
export default {

  data: () => ({

  }),
  methods: {
        modelos() {
            this.$router.push({ name: 'modelos' });
        },
        veiculos(){
          this.$router.push({ name: 'veiculosNovos' });
        }
      }
}
</script>
<style>
.texto {
  color: rgb(255, 255, 255);
  -webkit-stroke-color: rgb(255, 0, 0);
  -webkit-stroke-width: 12px;
}

.img {
  filter: brightness(90%)
}

.subtitulo {
  color: rgb(255, 255, 255);
  text-shadow:
    -1px -1px 0px rgb(92, 85, 85),
    -1px 1px 0px rgb(92, 85, 85),
    1px -1px 0px rgb(92, 85, 85),
    1px 0px 0px rgb(92, 85, 85);
  font-size: 29px;
}

.titulo {
  color: rgb(255, 255, 255);
  text-shadow:
    -1px -1px 0px rgb(36, 34, 34),
    -1px 1px 0px rgb(36, 34, 34),
    1px -1px 0px rgb(36, 34, 34),
    1px 0px 0px rgb(36, 34, 34);
  font-size: 50px;
  
}
</style>
