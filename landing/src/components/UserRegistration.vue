<template>
  <div class="login-page">
    <div class="register-container">
      <router-link to="/user-main">
        <button class="back-button">Volver</button>
      </router-link>
      <h2>Registro Voluntariado</h2>
      <form @submit.prevent="handleRegister" class="register-form">
        <div class="form-group">
          <label for="nombre">Nombre:</label>
          <InputField inputId="nombre" v-model="nombre" />
        </div>
        <div class="form-group">
          <label for="email">Email:</label>
          <InputField inputId="email" type="email" v-model="email" />
        </div>
        <div class="form-group">
          <label for="contrasena">Contraseña:</label>
          <InputField inputId="contrasena" type="password" v-model="contrasena" />
        </div>
        <div class="form-group">
          <label for="passwordConfirm">Confirmar Contraseña:</label>
          <InputField inputId="passwordConfirm" type="password" v-model="passwordConfirm" />
        </div>
        <div class="form-group">
          <label for="telefono">Teléfono:</label>
          <InputField inputId="telefono" v-model="telefono" />
        </div>
        <div class="form-group">
          <label for="direccion">Dirección:</label>
          <InputField inputId="direccion" v-model="direccion" />
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
      nombre: '',
      email: '',
      contrasena: '',
      passwordConfirm: '',
      telefono: '',
      direccion: ''
    };
  },
  methods: {
    async handleRegister() {

      if (!this.nombre || !this.email || !this.contrasena || !this.telefono || !this.direccion) {
        alert("Todos los campos son obligatorios");
        return;
      }

      if (this.contrasena.length < 8) {
        alert("La contraseña debe tener al menos 8 caracteres");
        return;
      }

      if (this.contrasena !== this.passwordConfirm) {
        alert("Las contraseñas no coinciden");
        return;
      }

      const voluntarioData = {
        nombre: this.nombre,
        email: this.email,
        contrasena: this.contrasena,
        telefono: this.telefono,
        direccion: this.direccion
      };

      try {
        const response = await api.post('http://localhost:8086/api/voluntario/register', voluntarioData);

        const newUser = response.data;
        alert("Registrado exitosamente con ID: " + newUser.id);
      } catch (error) {
        const errorMessage = error.response && error.response.data && error.response.data.message
            ? error.response.data.message
            : "Ha ocurrido un error desconocido.";
        alert("Error al registrar: " + errorMessage);
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

.register-container {
  display: flex;
  flex-direction: column;
  width: 100%;
  max-width: 50rem;
  height: 50rem;
  margin: 20px auto; /* Ajusta el margen superior e inferior */
  padding: 20px;
  border: 5px solid #3810ab;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  background-color: #220864; /* Color de fondo morado oscuro */
  color: #fff; /* Color del texto */
  font-family: 'Roboto Mono', monospace;
  text-align: center; /* Centra el texto de los elementos hijos */
}

h2 {
  margin: 25px 0; /* Ajusta el margen superior e inferior */
  font-size: 1.5rem;
}

form {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.form-group {
  margin-bottom: 15px; /* Ajusta el margen inferior */
}

label {
  display: block;
  font-weight: 500;
  color: #ffffff;
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
  border-color: #7642d9;
}

PrimaryButton {
  background-color: #7642d9;
  color: #fff;
  border: none;
  border-radius: 4px;
  font-size: 1rem;
  cursor: pointer;
  transition: background-color 0.3s;
  font-family: 'Roboto Mono', monospace;
  padding: 15px 30px; /* Ajusta el espaciado del botón */
}

PrimaryButton:hover {
  background-color: #5c359c;
}

.back-button {
  background-color: #1e044b;
  color: #fff;
  border: none;
  border-radius: 4px;
  font-size: 1rem;
  padding: 10px 30px; /* Ajusta el espaciado del botón */
  cursor: pointer;
  transition: background-color 0.3s;
  font-family: 'Roboto Mono', monospace; /* Aplicar la fuente Roboto Mono */
}

.back-button:hover {
  background-color: #a99f17;
}
</style>
