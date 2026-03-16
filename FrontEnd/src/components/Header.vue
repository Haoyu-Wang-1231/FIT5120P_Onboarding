<template>
  <header class="app-header">
    <div class="logo" @click="$emit('goHome')" style="cursor: pointer;">
      <span class="sun-icon">☀</span>
      <span class="brand-name">UV Shield</span>
    </div>
    <div class="header-right">
      <span class="accessibility">Accessibility tool</span>
      <button class="hamburger-menu">☰</button>
    </div>
  </header>
</template>

<script>
export default {
  name: 'Header'
}
</script>

<style scoped>
.app-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 1rem 2rem;
  background-color: white;
  border-bottom: 1px solid #eee;
}

.logo {
  display: flex;
  align-items: center;
  gap: 10px;
  font-weight: bold;
  font-size: 1.2rem;
  color: #333;
}

.sun-icon {
  font-size: 1.5rem;
  color: #FDB813;
}

.header-right {
  display: flex;
  align-items: center;
  gap: 20px;
  color: #666;
}

.accessibility {
  font-size: 0.9rem;
  display: none;
}

@media (min-width: 600px) {
  .accessibility {
    display: block;
  }
}

.hamburger-menu {
  background: none;
  border: none;
  font-size: 1.5rem;
  cursor: pointer;
}
</style>
