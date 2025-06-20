/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        navy: '#000035',
        lightnavy:'#000042',
        lavender: '#c3aed6',
        palegreen:'#adf5ad'
      }
    },
  },
  plugins: [],
}

