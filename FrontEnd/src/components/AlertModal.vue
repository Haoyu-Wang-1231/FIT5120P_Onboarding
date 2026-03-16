<template>
  <div v-if="isVisible" class="modal-overlay">
    <div class="modal-content">
      <div class="modal-header">
        <span class="warning-icon">⚠</span>
        <h2>Danger Alert!</h2>
        <button class="close-btn" @click="close">×</button>
      </div>
      <div class="modal-body">
        <p>UV level is VERY HIGH (9)! Take protective action NOW.</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ['isVisible'],
  methods: {
    close() {
      this.$emit('close');
    }
  }
}
</script>

<style scoped>
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.7);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 9999;
}

.modal-content {
  background-color: white;
  border-radius: 8px;
  width: 90%;
  max-width: 400px;
  overflow: hidden;
  box-shadow: 0 4px 6px rgba(0,0,0,0.1);
}

.modal-header {
  background-color: #DC3545;
  color: white;
  padding: 1rem;
  display: flex;
  align-items: center;
  gap: 10px;
}

.warning-icon {
  font-size: 1.5rem;
}

.modal-header h2 {
  flex-grow: 1;
  margin: 0;
  font-size: 1.2rem;
}

.close-btn {
  background: none;
  border: none;
  color: white;
  font-size: 1.5rem;
  cursor: pointer;
}

.modal-body {
  padding: 1.5rem;
  color: #333;
  font-size: 1rem;
  line-height: 1.5;
}
</style>
