<template>
  <router-link to="/user-main">
    <button class="back-button">Volver</button>
  </router-link>
  <div class="main-container">
    <div class="register-container">
      <h2>Registro Voluntariado</h2>
      <form @submit.prevent="handleRegister" class="register-form">
        <div class="form-group">
          <label for="username">Username:</label>
          <InputField inputId="username" v-model="username" />
        </div>
        <div class="form-group">
          <label for="password">Password:</label>
          <InputField inputId="password" type="password" v-model="password" />
        </div>
        <div class="form-group">
          <label for="passwordConfirm">Confirm Password:</label>
          <InputField inputId="passwordConfirm" type="password" v-model="passwordConfirm" />
        </div>
        <div class="form-group-button">
          <PrimaryButton>Registrar</PrimaryButton>
        </div>
      </form>

    </div>
  </div>
</template>


<script>
import api from "@/api";
import InputField from "@/components/ui/InputField.vue";
import PrimaryButton from "@/components/ui/PrimaryButton.vue";

export default {
  components: {
    InputField,
    PrimaryButton
  },
  data() {
    return {
      username: '',
      password: '',
      passwordConfirm: ''
    };
  },
  methods: {
    async handleRegister() {
      if (!this.username || !this.password) {
        alert("Username and password are required!");
        return;
      }

      if (this.password.length < 8) {
        alert("Password should be at least 8 characters long!");
        return;
      }

      if (this.password !== this.passwordConfirm) {
        alert("Passwords do not match!");
        return;
      }

      try {
        const response = await api.post('http://localhost:8080/api/register', {
          nickname: this.username,
          contrasena: this.password
        });

        const newUser = response.data;
        alert("Registered successfully with ID: " + newUser.id);
      } catch (error) {
        const errorMessage = error.response && error.response.data && error.response.data.message
            ? error.response.data.message
            : "An unknown error occurred.";
        alert("Error registering: " + errorMessage);
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
  height: 50vh;
  width: 50vw;
  background-color: #300870; /* Color de fondo morado oscuro */
}
.form-group-button{
  padding: 20px;
}

.back-button {
  background-color: #1e044b; /* Morado más claro */
  color: #fff;
  border: none;
  border-radius: 4px;
  font-size: 1rem;
  padding: 10px 451px; /* Ajusta el espaciado del botón */
  cursor: pointer;
  transition: background-color 0.3s;
  font-family: 'Roboto Mono', monospace; /* Aplicar la fuente Roboto Mono */
}

.back-button:hover {
  background-color: #a99f17; /* Color de fondo más oscuro al pasar el cursor */
}

.register-container {
  display: flex;
  flex-direction: column;
  width: 100%;
  max-width: 700px;
  height: 400px;
  margin: 0 auto;
  padding: 20px;
  border: 5px solid #3810ab; /* Borde morado */
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  background-color: #220864; /* Color de fondo morado oscuro */
  color: #fff; /* Color del texto */
  font-family: 'Roboto Mono', monospace;
}

h2 {
  margin-bottom: 1rem;
  text-align: center;
  margin-top: 25px; /* Agrega margen superior de 20px */
  font-size: 1.5rem; /* Tamaño del título */
}

form {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.form-group{
  margin-bottom: 5px;
}

label {
  display: block;
  font-weight: 500;
  color: #ffffff; /* Morado oscuro */
  margin-bottom: 0.3rem;
  text-align: left;
  padding: 1px;
}

input {
  width: 100%;
  padding: 0.5rem;
  border: 1px solid #e0e0e0;
  border-radius: 4px;
  font-size: 1rem;
  outline: none;
  margin-bottom: 1rem;
}

input:focus {
  border-color: #7642d9; /* Morado más claro al enfocar */
}

PrimaryButton {
  background-color: #7642d9; /* Morado más claro */
  color: #fff;
  border: none;
  border-radius: 4px;
  font-size: 1rem;
  cursor: pointer;
  transition: background-color 0.3s;
  font-family: 'Roboto Mono', monospace;
}

PrimaryButton:hover {
  background-color: #5c359c; /* Color de fondo más oscuro al pasar el cursor */
}

</style>

