import VueRouter from 'vue-router'
import Vue from 'vue'
import servisBaglantiEkrani from '../ServisBaglantiEkrani.vue'
import sorgulamaEkrani from '../SorgulamaEkrani.vue'

Vue.use(VueRouter);
const routes = [
    {
    path: '/',
    component: sorgulamaEkrani,
    name: 'sorgulama'
    },
    {
    path: '/servisBaglantiEkrani/:servisId',
    component: servisBaglantiEkrani,
    name: 'servisBaglantiEkrani'
    },
]

const router = new VueRouter({
    mode: 'history',
    routes: routes,
    base: '/'
})

export default router

