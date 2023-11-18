<template>
  <div class="main-container">
    <div class="login-container">
      <router-link to="/">
    <button class="back-button">Volver</button>
  </router-link>
      <h2>Login Coordinador</h2>
      <form @submit.prevent="handleLogin" class="form-container">
        <div class="form-group-info">
          <InputField label="Correo Electrónico:" inputId="email" v-model="email" />
        </div>
        <div class="form-group-info">
          <InputField label="Contraseña:" inputId="password" type="password" v-model="password" />
        </div>
        <div class="form-group-login">
          <PrimaryButton>Login</PrimaryButton>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import api from '@/api';
import InputField from "@/components/ui/InputField.vue";
import PrimaryButton from "@/components/ui/PrimaryButton.vue";

export default {
  components: {
    InputField,
    PrimaryButton
  },
  data() {
    return {
      email: '',
      password: ''
    };
  },
  methods: {
    async handleLogin() {
      try {
        const response = await api.post('http://localhost:8086/api/coordinador/login', {
          email: this.email,
          contrasena: this.password
        });

        const token = response.data;

        if (token) { 
          localStorage.setItem('token', token);
          this.$router.push({ name: 'HomeCoordinador' });
        } else {
          this.errorMessage = 'Credenciales inválidas. Por favor, intenta nuevamente.';
        }
      } catch (error) {
        this.errorMessage = 'Error al iniciar sesión. Por favor, intenta nuevamente.';
      }
    }
  }
};
</script>

<style scoped>
.main-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh; /* Cambiado a 100vh para ocupar toda la altura vertical */
  background-color: #300870;
}

.login-container {
  width: 100%;
  max-width: 400px; /* Reducido el ancho máximo para un diseño más centrado */
  padding: 20px;
  border: 5px solid #420aa3;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  background-color: #220864;
  color: #fff;
  font-family: 'Roboto Mono', monospace;
  text-align: center; /* Centrado de contenido */
}

h2 {
  margin-bottom: 1rem;
  margin-top: 20px; /* Alineado el título */
}

.form-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.form-group-info {
  margin-top: 15px;
}

.form-group-login {
  margin-top: 20px; /* Alineado el botón */
}

label {
  margin-bottom: 0.3rem;
  font-weight: 500;
}

input {
  width: 100%;
  padding: 0.5rem;
  margin-bottom: 1rem;
  border: 1px solid #e0e0e0;
  border-radius: 4px;
  font-size: 1rem;
  outline: none;
}

input:focus {
  border-color: #1027bb;
}

button {
  width: 100%;
  padding: 0.5rem 0;
  background-color: #20056c;
  color: white;
  border: none;
  border-radius: 4px;
  font-size: 1rem;
  cursor: pointer;
  transition: background-color 0.3s;
  font-family: 'Roboto Mono', monospace;
}

button:hover {
  background-color: #cbb51c;
}
</style>
