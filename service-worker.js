// ⚡ Java Code Vault - Offline Cache + Update Handler
// Made with ❤️ by TechhBuddies

const CACHE_NAME = "java-code-vault-v1";
const URLS_TO_CACHE = [
  "/",
  "/index.html",
  "/style-v2.css",
  "/script.js",
  "/manifest.json",
  "/assets/favicon.png",
  "/assets/java_logo.png",
  "/assets/Caution.png",
  "/assets/HD Logo PNG.png"
];

// 🧱 Install Event
self.addEventListener("install", event => {
  event.waitUntil(
    caches.open(CACHE_NAME)
      .then(cache => cache.addAll(URLS_TO_CACHE))
      .then(() => self.skipWaiting())
  );
});

// ♻️ Activate Event
self.addEventListener("activate", event => {
  event.waitUntil(
    caches.keys().then(keys => {
      return Promise.all(
        keys
          .filter(key => key !== CACHE_NAME)
          .map(key => caches.delete(key))
      );
    })
  );
  self.clients.claim();
});

// 🌐 Fetch Event (Cache with Network Update)
self.addEventListener("fetch", event => {
  event.respondWith(
    caches.match(event.request).then(cachedResponse => {
      const fetchPromise = fetch(event.request)
        .then(networkResponse => {
          if (networkResponse && networkResponse.status === 200) {
            caches.open(CACHE_NAME).then(cache => {
              cache.put(event.request, networkResponse.clone());
            });
          }
          return networkResponse;
        })
        .catch(() => cachedResponse);

      return cachedResponse || fetchPromise;
    })
  );
});

// 🔄 Message Listener (Skip Waiting)
self.addEventListener("message", event => {
  if (event.data === "SKIP_WAITING") {
    self.skipWaiting();
  }
});
