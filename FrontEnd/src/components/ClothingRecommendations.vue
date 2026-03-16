<template>
  <div class="recommendations-card">

    <div class="title-bar">
      <div class="title-left">
        <span class="icon">👕</span>
        <div>
          <h2 class="main-title">Clothing Recommendations</h2>
          <p class="sub-title">Sun-smart fashion for UV Index 9</p>
        </div>
      </div>
      <button class="share-btn">
        <span class="icon">🔗</span> Share
      </button>
    </div>

    <div class="prompt-box blue-box">
      <p>Very high UV is dangerous. Wear certified UPF 50+ clothing covering all exposed skin. Combine with SPF 50+ sunscreen on any remaining exposed areas.</p>
    </div>

    <div class="wear-section">
      <h3 class="section-title"><span class="icon">💡</span> What to Wear Today</h3>
      <div class="wear-list">
        <div class="wear-item">
          <span class="icon">👕</span>
          <div class="item-details">
            <h4>UPF 50+ Long-sleeve shirt</h4>
            <p>Covers arms completely.</p>
          </div>
          <span class="tag upf-tag">UPF 50+</span>
        </div>
        <div class="wear-item">
          <span class="icon">👖</span>
          <div class="item-details">
            <h4>Pants or long skirt</h4>
            <p>Protect your legs from direct sun.</p>
          </div>
        </div>
        <div class="wear-item">
          <span class="icon">👒</span>
          <div class="item-details">
            <h4>Wide-brimmed hat</h4>
            <p>Shades face, neck, and ears.</p>
          </div>
        </div>
        <div class="wear-item">
          <span class="icon">🕶️</span>
          <div class="item-details">
            <h4>Sunglasses</h4>
            <p>UV-blocking to protect your eyes.</p>
          </div>
        </div>
      </div>
    </div>

    <div class="prompt-box yellow-box">
      <h3 class="section-title"><span class="icon">☀️</span> Understanding UPF</h3>
      <ul class="upf-explanation">
        <li><strong>UPF 15-24:</strong> Good protection (blocks 93.3-95.8% of UV)</li>
        <li><strong>UPF 25-39:</strong> Very good protection (blocks 96-97.4% of UV)</li>
        <li><strong>UPF 40-50+:</strong> Excellent protection (blocks 97.5-98%+ of UV)</li>
      </ul>
      <p class="pro-tip"><span class="icon">💡</span> <strong>Pro tip:</strong> Dark colors, tight weaves, and synthetic fabrics generally offer better UV protection.</p>
    </div>
  </div>
</template>

<style scoped>
.recommendations-card {
  background-color: white;
  border-radius: 12px;
  box-shadow: 0 4px 15px rgba(0,0,0,0.08);
  padding: 25px;
  margin-top: 20px;
}

.icon {
  font-size: 1.5rem;
  margin-right: 10px;
}

.title-bar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-bottom: 1px solid #eee;
  padding-bottom: 15px;
  margin-bottom: 20px;
}
.title-left {
  display: flex;
  align-items: center;
}
.main-title {
  margin-top: 0;
  margin-bottom: 0;
  font-size: 1.4rem;
  color: #333;
}
.sub-title {
  margin-top: 0;
  margin-bottom: 0;
  font-size: 0.9rem;
  color: #777;
}
.share-btn {
  background-color: #f0f2f5;
  border: 1px solid #ddd;
  border-radius: 20px;
  padding: 8px 15px;
  display: flex;
  align-items: center;
  font-size: 0.9rem;
}
.share-btn .icon { font-size: 1rem; }

.prompt-box {
  border-radius: 8px;
  padding: 15px;
  margin-bottom: 25px;
  font-size: 0.95rem;
  line-height: 1.5;
}
.blue-box {
  background-color: #e7f3ff;
  color: #004085;
}
.yellow-box {
  background-color: #fff3cd;
  color: #856404;
}

.section-title {
  display: flex;
  align-items: center;
  font-size: 1.2rem;
  margin-bottom: 15px;
}
.section-title .icon { font-size: 1.2rem; }

.wear-list {
  display: flex;
  flex-direction: column;
  gap: 10px;
}
.wear-item {
  display: flex;
  align-items: center;
  background-color: #f8f9fa;
  padding: 15px;
  border-radius: 8px;
}
.wear-item .item-details {
  flex-grow: 1;
}
.wear-item h4 {
  margin-top: 0;
  margin-bottom: 4px;
  font-size: 1rem;
}
.wear-item p {
  margin: 0;
  font-size: 0.9rem;
  color: #666;
}

.tag {
  padding: 4px 8px;
  border-radius: 6px;
  font-size: 0.8rem;
  font-weight: bold;
  color: white;
}
.upf-tag { background-color: #8e44ad; }

.yellow-box .section-title {
  margin-bottom: 10px;
}
.upf-explanation {
  padding-left: 20px;
  margin-bottom: 15px;
  font-size: 0.9rem;
}
.pro-tip {
  font-size: 0.9rem;
  display: flex;
  align-items: center;
}
.pro-tip .icon {
  font-size: 1rem;
}
</style>
