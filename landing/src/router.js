import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/components/Home.vue';
import AdminLogin from '@/components/AdminLogin.vue';
import UserMain from '@/components/UserMain.vue';
import UserLogin from '@/components/UserLogin.vue';

import UserRegister from '@/components/UserRegistration.vue';


import TareasConMenosVoluntarios from '@/components/TareasConMenosVoluntarios.vue';


const routes = [
    {
        path: '/',
        name: 'Main',
        component: Home,
    },
    {
        path: '/admin-login',
        name: 'Admin',
        component: AdminLogin,
    },
    {
        path: '/user-main',
        name: 'UserMain',
        component: UserMain,
    },
    {
        path: '/user-login',
        name: 'UserLogin',
        component: UserLogin,
    },
    {
        path: '/user-register',
        name: 'UserRegister',
        component: UserRegister,
    },
    {
        path: '/tareas-con-menos-voluntarios',
        name: 'TareasConMenosVoluntarios',
        component: TareasConMenosVoluntarios,
    },
];

const router = createRouter({
    history: createWebHistory(import.meta.env.VITE_BASE_URL || '/'),
    routes,
});

export default router;
