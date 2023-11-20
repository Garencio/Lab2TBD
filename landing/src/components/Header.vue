<template>
  <header class="header">
    <button @click="irATareas" class="header-button">Tareas Con Menos Voluntarios</button>
    <button @click="irARegiones" class="header-button">Regiones</button>
    <button @click="logout" class="header-button">Cerrar Sesión</button>
  </header>
</template>

<script>
export default {
  methods: {
    irATareas() {
      this.$router.push({ name: 'TareasConMenosVoluntarios' });
    },
    irARegiones() {
      this.$router.push({ name: 'Regiones' });
    },
    logout() {
      localStorage.removeItem('token');
      this.$router.push({ name: 'Main' });
    }
  }
};
</script>

<style scoped>
.header {
  color: #fff;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 800px;
  

  box-shadow: 10px 10px 20px rgba(0, 0, 0, 0.3);

}

.header-button {
  background-color: #ffffff;
  color: #000000;
  border: none;
  padding: 10px 20px;
  cursor: pointer;
  border-radius: 5px;
  transition: background-color 0.3s ease;
  letter-spacing: 3px;
  ont-family: 'Poppins';
  font-weight: bold;
}

.header-button:hover {
  background-color: rgb(111, 37, 126); 
  color: white;
}
</style>
