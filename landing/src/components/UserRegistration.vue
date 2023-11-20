<template>
  <div class="login-page">
    <div class="register-container">
      <h2>REGISTRO VOLUNTARIADO</h2>
      <form @submit.prevent="handleRegister" class="register-form">
        <div class="form-group">
          <InputField label="Nombre: " inputId="nombre" v-model="nombre" />
        </div>
        <div class="form-group">
          <InputField label="Email: " inputId="email" type="email" v-model="email" />
        </div>
        <div class="form-group">
          <InputField label="Contraseña: " inputId="contrasena" type="password" v-model="contrasena" />
        </div>
        <div class="form-group">
          <InputField label="Confirmar Contraseña: " inputId="passwordConfirm" type="password" v-model="passwordConfirm" />
        </div>
        <div class="form-group">
          <InputField label="Teléfono: " inputId="telefono" v-model="telefono" />
        </div>
        <div class="form-group">
          <InputField label="Dirección: " inputId="direccion" v-model="direccion" />
        </div>
        <div class="form-group-button">
          <button class="register-button">Registrar</button>
        </div>
        <router-link to="/user-main">
          <button class="back-button">Volver</button>
        </router-link>
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
}

.register-container {
  display: flex;
  flex-direction: column;
  width: 100%;
  max-width: 40rem;
  height: 45rem;
  padding: 3rem;
  box-shadow: 10px 10px 20px rgba(0, 0, 0, 0.3);
  background-color: #000000; /* Color de fondo morado oscuro */
  color: #fff; /* Color del texto */
  font-family: 'Poppins';
  text-align: center; /* Centra el texto de los elementos hijos */
  opacity: 0.6;

}

h2 {
  margin: 20px 10px;
  padding: 1rem; /* Ajusta el margen superior e inferior */
  font-size: 1.7rem;
  font-weight: bold;
  color: white;
  letter-spacing: 3px;

}

form {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.form-group {
  margin-bottom: 1rem; /* Ajusta el margen inferior */
  letter-spacing: 3px;
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

.back-button, .register-button {
  background-color: #ffffff;
  margin: 1rem;
  margin-top: 20px;
  color: #000000;
  border: none;
  border-radius: 4px;
  font-size: 1rem;
  padding: 10px 50px; /* Ajusta el espaciado del botón */
  cursor: pointer;
  transition: background-color 0.3s;
  font-family: 'Poppins'; /* Aplicar la fuente Roboto Mono */
}

.back-button:hover, .register-button:hover {
  background-color: rgb(111, 37, 126); 
  color: white;
}
</style>
