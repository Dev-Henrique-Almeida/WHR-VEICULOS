import Vue from 'vue'
import Router from 'vue-router'
import HomePage from '@/componentes/HomePage'
import clienteFisico from '@/componentes/clienteFisico'

Vue.use(Router)

export default new Router({
	routes:[
		{
		path: '/home',
		name: 'HomePage',
		component: 'HomePage'
		},
		{
		path: '/cliente',
		name: 'clienteFisico',
		component: 'clienteFisico'
		}
		]
	})