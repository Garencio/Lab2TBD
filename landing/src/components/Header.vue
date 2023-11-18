<template>
    <header>
      <button @click="irATareas">Tareas Con Menos Voluntarios</button>
      <button @click="irARegiones">Regiones</button>
      <button @click="logout">Cerrar Sesión</button>
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
  
  <style>

  </style>
  