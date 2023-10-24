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
        meta: { requiresAuth: true, requiresCoordinator: true },
    },
];

const router = createRouter({
    history: createWebHistory(import.meta.env.VITE_BASE_URL || '/'),
    routes,
});

router.beforeEach((to, from, next) => {
    const token = localStorage.getItem('token');
    let isCoordinator = false;

    if (token) {
        console.log('Token encontrado:', token);
        const decodedToken = decodeToken(token);
        console.log('Token decodificado:', decodedToken);
        if (decodedToken) {
            isCoordinator = decodedToken.type === 'coordinador';
        }
    }

    const requiresAuth = to.matched.some(record => record.meta.requiresAuth);
    const requiresCoordinator = to.matched.some(record => record.meta.requiresCoordinator);

    if (requiresAuth && !token) {
        console.log('No autenticado, redirigiendo a Login');
        next({ name: 'Admin' });
    } else if (requiresCoordinator && !isCoordinator) {
        console.log('No es coordinador, acceso denegado');
        next(false);
    } else {
        next();
    }
});

function decodeToken(token) {
    try {
        const base64String = token.split('.')[1];
        const decodedValue = JSON.parse(atob(base64String));
        return decodedValue;
    } catch (e) {
        console.error('Error al decodificar el token', e);
        return null;
    }
}





export default router;
