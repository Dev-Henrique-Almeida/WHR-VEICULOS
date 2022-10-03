import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import cadastroCliente from '../views/clientes/cadastroCliente.vue'
import updateClienteFisico from '../views/clientes/updateClienteFisico.vue'
import updateModelo from '../views/veiculos/modelo/updateModelo.vue'
import updateVeiculoNovo from '../views/veiculos/veiculoNovo/updateVeiculoNovo.vue'
import updateVeiculoUsado from '../views/veiculos/veiculoUsado/updateVeiculoUsado.vue'
import updateFuncionario from '../views/funcionarios/updateFuncionario.vue'
import updateClienteJuridico from '../views/clientes/updateClienteJuridico.vue'
import cadastroClienteJuridico from '../views/clientes/cadastroClienteJuridico.vue'
import cadastroFuncionario from '../views/funcionarios/cadastroFuncionario.vue'
import cadastroVeiculoNovo from '../views/veiculos/veiculoNovo/cadastroVeiculoNovo.vue'
import cadastroVeiculoUsado from '../views/veiculos/veiculoUsado/cadastroVeiculoUsado.vue'
import cadastroModelo from '../views/veiculos/modelo/cadastroModelo.vue'
import CadastrarVeiculo from '../views/veiculos/CadastrarVeiculo.vue'
import vendaVeiculo from '../views/venda/vendaVeiculo.vue'
import VendaVeiculoPessoaJuridica from '../views/venda/VendaVeiculoPessoaJuridica.vue'
import VendaConcluida from '../views/venda/VendaConcluida.vue'
import acessoRestrito from '../views/acessoRestrito.vue'
import allVenda from '../views/venda/allVenda.vue'
import allVendaJuridica from '../views/venda/allVendaJuridica.vue'
import cadastroFinalizado from '../views/clientes/cadastroFinalizado.vue'
import gerenciarVendas from '../views/venda/gerenciarVendas.vue'
import cancelarVendaFisica from '../views/venda/cancelarVendaFisica.vue'
import cancelarVendaJuridica from '../views/venda/cancelarVendaJuridica.vue'
import VendaConcluidaJuridica from '../views/venda/VendaConcluidaJuridica.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },

  {
    path: '/vendaVeiculo',
    name: 'vendaVeiculo',
    component: vendaVeiculo
  },
  {
    path: '/VendaConcluidaJuridica',
    name: 'VendaConcluidaJuridica',
    component: VendaConcluidaJuridica
  },
  {
    path: '/gerenciarVendas',
    name: 'gerenciarVendas',
    component: gerenciarVendas
  },
  {
    path: '/cancelarVendaJuridica',
    name: 'cancelarVendaJuridica',
    component: cancelarVendaJuridica
  },
  {
    path: '/cancelarVendaFisica',
    name: 'cancelarVendaFisica',
    component: cancelarVendaFisica
  },
  {
    path: '/VendaVeiculoPessoaJuridica',
    name: 'VendaVeiculoPessoaJuridica',
    component: VendaVeiculoPessoaJuridica
  },
  {
    path: '/vendaConcluida',
    name: 'VendaConcluida',
    component: VendaConcluida
  },
  {
    path: '/acessoRestrito',
    name: 'acessoRestrito',
    component: acessoRestrito
  },
  
  {
    path: '/cadastroInicio',
    name: 'cadastroClienteFisico',
    component: cadastroCliente
  },
  {
    path: '/cadastroClienteFisicoFinalizado',
    name: 'cadastroClienteFisicoFinalizado',
    component: cadastroFinalizado
  },
  {
    path: '/updateClienteFisico',
    name: 'clienteFisico',
    component: updateClienteFisico
  },
  {
    path: '/updateFuncionario',
    name: 'updatefuncionario',
    component: updateFuncionario
  },
  {
    path: '/todasVendasPessoaFisica',
    name: 'todasVendasPessoaFisica',
    component: allVenda
  },
  {
    path: '/todasVendasPessoaJuridica',
    name: 'todasVendasPessoaJuridica',
    component: allVendaJuridica
  },
  {
    path: '/updateClienteJuridico',
    name: 'clienteJuridico',
    component: updateClienteJuridico
  },
  {
    path: '/updateModelo',
    name: 'modelo',
    component: updateModelo
  },
  {
    path: '/updateVeiculoNovo',
    name: 'updateVeiculoNovo',
    component: updateVeiculoNovo
  },
  {
    path: '/updateVeiculoUsado',
    name: 'updateVeiculoUsado',
    component: updateVeiculoUsado
  },
  {
    path: '/cadastroClienteJuridico',
    name: 'cadastroClienteJuridico',
    component: cadastroClienteJuridico
  },
  {
    path: '/cadastroFuncionario',
    name: 'cadastroFuncionario',
    component: cadastroFuncionario
  },
  {
    path: '/cadastrarVeiculo',
    name: 'CadastrarVeiculo',
    component: CadastrarVeiculo
  },
   {
    path: '/cadastrarVeiculo/usado/:modelo',
    name: 'cadastrarVeiculoUsado',
    component: cadastroVeiculoUsado
  },
  {
    path: '/cadastrarVeiculo/novo/:modelo',
    name: 'cadastroVeiculoNovo',
    component: cadastroVeiculoNovo
  },
  {
    path: '/cadastroModelo',
    name: 'cadastroModelo',
    component: cadastroModelo
  },
  {
    path: '/clientes',
    name: 'clientes',
    component: () => import(/* webpackChunkName: "about" */ '../views/clientes/allClientes.vue')
  },
  {
    path: '/funcionarios',
    name: 'funcionarios',
    component: () => import(/* webpackChunkName: "about" */ '../views/funcionarios/allFuncionarios.vue')
  },
  {
    path: '/veiculosNovos',
    name: 'veiculosNovos',
    component: () => import(/* webpackChunkName: "about" */ '../views/veiculos/veiculoNovo/allVeiculoNovo')
  },
  {
    path: '/veiculosUsados',
    name: 'veiculosUsados',
    component: () => import(/* webpackChunkName: "about" */ '../views/veiculos/veiculoUsado/allVeiculoUsado.vue')
  },
  {
    path: '/modelos',
    name: 'modelos',
    component: () => import(/* webpackChunkName: "about" */ '../views/veiculos/modelo/allModelo.vue')
  },
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
