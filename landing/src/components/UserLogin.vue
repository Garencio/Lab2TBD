<template>
  <div class="login-page">
    <div class="main-container">
      <div class="login-container">
        <h2>LOGIN VOLUNTARIADO</h2>
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
          <router-link to="/user-main">
            <button class="back-button">Volver</button>
          </router-link>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
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
        const response = await axios.post('http://localhost:8086/api/voluntario/login', {
          email: this.email,
          contrasena: this.password
        });

        if (response && response.data) {
          localStorage.setItem('userId', response.data.id);
          alert('Inicio de sesión exitoso!');
        } else {
          alert('Credenciales inválidas. Por favor, intenta nuevamente.');
        }
      } catch (error) {
        alert('Error al iniciar sesión. Por favor, intenta nuevamente.');
      }
    }
  }
};
</script>

<style scoped>

.login-page {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh; /* Ocupa todo el alto de la ventana */
}

.main-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 35rem;
  height: 30rem;
  margin-top: 20px; /* Ajusta el margen superior */
  background-color: #000000; /* Color de fondo morado oscuro */
  opacity: 0.6;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  color: #fff; /* Color del texto */
  font-family: 'Poppins';
  letter-spacing: 4px;
}

h2 {
  margin: 50px 0 20px; /* Ajusta el margen superior e inferior */
  text-align: center;
  font-weight: bold;
  color: white;
  opacity: 1;
  letter-spacing: 3px;
}

.form-group-info {
  margin-top: 1rem;
}

.form-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  padding: 2rem;
}

.form-group-login {
  margin-top: 20px; /* Ajusta el margen superior */
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


.back-button, .login-button {
  background-color: #ffffff; /* Morado más claro */
  margin-top: 2rem; /* Ajusta el margen superior */
  color: #fff;
  color: #000000;
  border-radius: 4px;
  font-size: 1rem;
  padding: 10px 50px; /* Ajusta el espaciado del botón */
  cursor: pointer;
  transition: background-color 0.3s;
  font-family: 'Poppins', monospace; /* Aplicar la fuente Roboto Mono */
}

.back-button:hover, .login-button:hover {
  background-color: rgb(111, 37, 126); 
  color: white;
}
</style>
