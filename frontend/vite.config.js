import { defineConfig, loadEnv } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig(({mode }) => {
  // Load env file based on `mode` in the current working directory.
  // Set the third parameter to '' to load all env regardless of the `VITE_` prefix.
  // eslint-disable-next-line no-undef
  const env = loadEnv(mode, process.cwd(), '')
  return {
    // vite config
    plugins: [react()],
    server: {
      port: 3000, // Set the port to 3000

      // proxy: {
      //   // Proxy /api requests to http://localhost:5000
      //   '/api': {
      //     target: 'http://localhost:5000',
      //     changeOrigin: true,
      //     rewrite: (path) => path.replace(/^\/api/, ''),
      //   },
      // },

      cors: {
        origin: ['*', env.VITE_API_URL], // Allow requests from these origins only
        methods: ['GET', 'POST', 'PUT', 'DELETE', 'OPTIONS'], // HTTP methods allowed
        allowedHeaders: ['Content-Type', 'Authorization'], // Headers allowed in requests
        credentials: true, // Allow credentials (cookies, authorization headers)
      },

    },
  }
})