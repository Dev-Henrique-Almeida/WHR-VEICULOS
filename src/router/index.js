import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import cadastroClienteFisico from '../views/clientes/cadastroClienteFisico.vue'
import cadastroCliente from '../views/clientes/cadastroCliente.vue'
import cadastroClienteJuridico from '../views/clientes/cadastroClienteJuridico.vue'
import cadastroFuncionario from '../views/funcionarios/cadastroFuncionario.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/cadastroCliente',
    name: 'cadastroCliente',
    component: cadastroClienteFisico
  },
  {
    path: '/cadastroInicio',
    name: 'cadastroInicio',
    component: cadastroCliente
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
    path: '/clientes',
    name: 'clientes',
    component: () => import(/* webpackChunkName: "about" */ '../views/clientes/allClientes.vue')
  },
  {
    path: '/funcionarios',
    name: 'funcionarios',
    component: () => import(/* webpackChunkName: "about" */ '../views/funcionarios/allFuncionarios.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
