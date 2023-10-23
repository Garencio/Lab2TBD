<template>
  <div>
    <div class="column">
      <!-- Mostrar la lista de emergencias -->
      <h2>Lista de Emergencias</h2>
      <ul>
        <li v-for="emergencia in emergencias" :key="emergencia.id">{{ emergencia.nombre }}</li>
      </ul>
    </div>
    <div class="column">
      <!-- Mostrar la lista de tareas con menos voluntarios -->
      <h2>Tareas con Menos Voluntarios</h2>
      <ul>
        <li v-for="tarea in tareas" :key="tarea.id">
          {{ tarea.nombre }} - Voluntarios inscritos: {{ tarea.voluntariosInscritos }}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      emergencias: [],
      tareas: []
    };
  },
  mounted() {
    this.obtenerDatos();
  },
  methods: {
    async obtenerDatos() {
      try {
        // Realiza una solicitud GET al endpoint de tu servicio REST en el backend
        const response = await axios.get('/api/voluntario/listado-emergencias-y-tareas');

        // Actualiza los valores de 'emergencias' y 'tareas' con los datos recibidos
        this.emergencias = response.data.emergenciaTareas; // Asegúrate de usar el nombre correcto
        this.tareas = response.data.tareaVoluntarios; // Asegúrate de usar el nombre correcto
      } catch (error) {
        console.error('Error al obtener datos:', error);
      }
    }
  }
};
</script>
