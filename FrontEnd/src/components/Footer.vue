<template>
  <footer class="app-footer">
    <div class="footer-top">
      <div class="footer-col brand-col">
        <div class="logo">
          <span class="sun-icon">☀</span>
          <span class="brand-name">UV Shield</span>
        </div>
        <p class="tagline">your skin from UV radiation</p>
      </div>
      <div class="footer-col">
        <h4>Understanding UV</h4>
        <ul>
          <li>What is UV radiation?</li>
          <li>UV Index explained</li>
          <li>Myths about UV</li>
        </ul>
      </div>
      <div class="footer-col">
        <h4>Sun Protection</h4>
        <ul>
          <li>How to protect yourself</li>
          <li>Sunscreen guide</li>
          <li>UPF clothing</li>
        </ul>
      </div>
      <div class="footer-col">
        <h4>Resources</h4>
        <ul>
          <li>UV forecast</li>
          <li>Glossary of terms</li>
          <li>Scientific research</li>
        </ul>
      </div>
      <div class="footer-col">
        <h4>About</h4>
        <ul>
          <li>About UV Shield</li>
          <li>Our data sources</li>
          <li>Contact us</li>
        </ul>
      </div>
    </div>
    <div class="footer-bottom">
      <p>&copy; 2026 UV Shield. All rights reserved. | Data powered by World Weather Online.</p>
    </div>
  </footer>
</template>

<style scoped>
.app-footer {
  background-color: #003366;
  color: white;
  padding-top: 3rem;
  padding-bottom: 3rem;
  padding-left: 2rem;
  padding-right: 2rem;
  font-size: 0.9rem;
}

.footer-top {
  display: flex;
  flex-wrap: wrap;
  gap: 2rem;
  justify-content: space-between;
  border-bottom: 1px solid rgba(255,255,255,0.2);
  padding-bottom: 2rem;
  max-width: 1200px;
  margin-left: auto;
  margin-right: auto;
}

.brand-col {
  flex-basis: 250px;
}

.logo {
  display: flex;
  align-items: center;
  gap: 10px;
  font-weight: bold;
  font-size: 1.5rem;
  margin-bottom: 0.5rem;
}

.sun-icon {
  font-size: 1.8rem;
  color: #FDB813;
}

.tagline {
  margin: 0;
  color: #add8e6;
  font-style: italic;
}

.footer-col h4 {
  margin-top: 0;
  margin-bottom: 1rem;
  font-weight: 600;
  color: #add8e6;
}

.footer-col ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

.footer-col li {
  margin-bottom: 0.6rem;
  color: #ccc;
  cursor: pointer;
  transition: color 0.2s;
}

.footer-col li:hover {
  color: white;
  text-decoration: underline;
}

.footer-bottom {
  margin-top: 2rem;
  text-align: center;
  color: #88aacc;
  font-size: 0.8rem;
}
</style>
