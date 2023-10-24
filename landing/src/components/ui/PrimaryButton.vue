<template>
  <button class="primary-button" @click="handleClick">
    <slot></slot>
  </button>
</template>

<script>
export default {
  methods: {
    handleClick() {
      this.$emit('click');
    }
  }
};
</script>

<style scoped>
.primary-button {
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 10px 45px;
  border: none;
  border-radius: 20px;
  background-color: #007BFF;
  color: white;
  font-size: 1rem;
  cursor: pointer;
  transition: background-color 0.3s;
  outline: none;
}

.primary-button:hover {
  background-color: #0056b3;
}
</style>
