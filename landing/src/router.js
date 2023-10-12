import { createRouter, createWebHistory } from 'vue-router';
import UserLogin from '@/components/UserLogin.vue';
import UserRegistration from '@/components/UserRegistration.vue';

const routes = [
    {
        path: '/login',
        name: 'Login',
        component: UserLogin,
    },
    {
        path: '/register',
        name: 'Register',
        component: UserRegistration,
    },
];

const router = createRouter({
    history: createWebHistory(import.meta.env.VITE_BASE_URL || '/'),
    routes,
});

export default router;
