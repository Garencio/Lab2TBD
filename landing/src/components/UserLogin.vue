<template>
  <div class="login-page">
    <router-link to="/user-main">
      <button class="back-button">Volver</button>
    </router-link>
    <div class="main-container">
      <div class="login-container">
        <h2>Login Voluntariado</h2>
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
  background-color: #300870;
}

.main-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  max-width: 700px;
  height: 400px;
  margin-top: 20px; /* Ajusta el margen superior */
  background-color: #220864; /* Color de fondo morado oscuro */
  border: 5px solid #420aa3;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  color: #fff; /* Color del texto */
  font-family: 'Roboto Mono', monospace;
}

h2 {
  margin: 50px 0 20px; /* Ajusta el margen superior e inferior */
  text-align: center;
}

.form-group-info {
  margin-top: 15px;
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

.back-button {
  background-color: #320a6c; /* Morado más claro */
  margin-top: 20px; /* Ajusta el margen superior */
  color: #fff;
  border: none;
  border-radius: 4px;
  font-size: 1rem;
  padding: 10px 20px; /* Ajusta el espaciado del botón */
  cursor: pointer;
  transition: background-color 0.3s;
  font-family: 'Roboto Mono', monospace; /* Aplicar la fuente Roboto Mono */
}

.back-button:hover {
  background-color: #5c359c; /* Color de fondo más oscuro al pasar el cursor */
}
</style>
