<template>
  <div class="main-container">
    <div class="login-container">
      <h2>LOGIN COORDINADOR</h2>
      <form @submit.prevent="handleLogin" class="form-container">
        <div class="form-group-info">
          <InputField label="Correo Electrónico: " inputId="email" v-model="email" />
        </div>
        <div class="form-group-info">
          <InputField label="Contraseña: " inputId="password" type="password" v-model="password" />
        </div>
        <div class="form-group-login">
          <button class="login-button">Login</button>
        </div>
        <router-link to="/">
          <button class="back-button">Volver</button>
        </router-link>
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
}

.login-container {
  width: 100%;
  max-width: 30rem; /* Reducido el ancho máximo para un diseño más centrado */
  height: 24rem;
  padding: 20px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  color: #fff;
  font-family: 'Poppins';
  text-align: center; /* Centrado de contenido */
  box-shadow: 10px 10px 20px rgba(0, 0, 0, 0.3);
  background-color: #000000;
  opacity: 0.6;
}

h2 {
  margin-bottom: 1rem;
  margin-top: 20px; /* Alineado el título */
  letter-spacing: 3px;
  font-weight: bold;
}

.form-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.form-group-info {
  margin-top: 25px;
  letter-spacing: 3px;
}

.form-group-login {
  margin-top: 20px; /* Alineado el botón */
}

label {
  margin-bottom: 0.3rem;
  font-weight: 500;
}


button {
  min-width: 150px; 
  margin-top: 25px;
  padding: 10px 20px; 
  border: none;
  border-radius: 5px;
  color: #000000; 
  cursor: pointer;
  transition: background-color 0.3s ease; 
  font-family: 'Poppins';
}

button:hover {
  background-color: rgb(111, 37, 126); 
  color: white;
}
</style>
