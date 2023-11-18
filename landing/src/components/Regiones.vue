<template>
    <div>
      <Header />
      <div class="region-selector">
        <select v-model="selectedRegion">
          <option value="" disabled>Selecciona una región</option>
          <option v-for="region in regiones" :key="region" :value="region">{{ region }}</option>
        </select>
        <button @click="fetchEmergencias">Mostrar Emergencias</button>
      </div>
  
      <div class="emergencias-list">
        <ul v-if="emergencias.length > 0">
          <li v-for="emergencia in emergencias" :key="emergencia.id">
            <h3>{{ emergencia.nombre }}</h3>
            <p>Descripción: {{ emergencia.descripcion }}</p>
        </li>
        </ul>
        <p v-else>No hay emergencias para mostrar.</p>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  import Header from '@/components/Header.vue';
  
  export default {
    components: {
      Header
    },
    data() {
      return {
        regiones: [
            "Región de Arica y Parinacota",
            "Región de Tarapacá",
            "Región de Antofagasta",
            "Región de Magallanes y Antártica Chilena",
            "Región de Aysén del Gral.Ibáñez del Campo",
            "Región de Atacama",
            "Región de Coquimbo",
            "Región de Valparaíso",
            "Región Metropolitana de Santiago",
            "Región de Los Lagos",
            "Región de Los Ríos",
            "Región de La Araucanía",
            "Región del Biobío",
            "Región de Ñuble",
            "Región del Maule",
            "Región del Libertador Bernardo O'Higgins"  
        ], 
        selectedRegion: '',
        emergencias: []
      };
    },
    methods: {
      fetchEmergencias() {
        if (this.selectedRegion) {
          axios.get(`http://localhost:8086/emergencias/region/${this.selectedRegion}`)
            .then(response => {
              this.emergencias = response.data;
            })
            .catch(error => {
              console.error('Error al obtener emergencias:', error);
            });
        }
      }
    }
  };
  </script>
  
  <style>
    /*
  .region-selector {

  }
  
  .emergencias-list {

  }
  */
  </style>
  