// ⚡ Java Code Vault - Advanced Offline Cache & Auto-Update with Progress Tracker
// Made with ❤️ by TechhBuddies

const CACHE_NAME = "java-code-vault-v4"; // increment when updating

// 🧱 Core UI files
const CORE_FILES = [
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

// ✅ Pre-cache all practical .java files (auto-download on first visit)
const PRACTICAL_FILES = [
  "/assets/Pr_1/sum_avg.java",
  "/assets/Pr_1/facto.java",
  "/assets/Pr_1/facto_user.java",
  "/assets/Pr_1/prime_no.java",
  "/assets/Pr_2/calcu.java",
  "/assets/Pr_2/switch_case.java",
  "/assets/Pr_3/rect.java",
  "/assets/Pr_4/rect.java",
  "/assets/Pr_5/sort_int.java",
  "/assets/Pr_5/brute_force_approch.java",
  "/assets/Pr_5/Inbuilt_sort.java",
  "/assets/Pr_6/AddMatrix.java",
  "/assets/Pr_7/Demo1.java",
  "/assets/Pr_8/Sports.java",
  "/assets/Pr_8/InterfaceDemo.java",
  "/assets/Pr_9/Account.java",
  "/assets/Pr_9/DepositeThread.java",
  "/assets/Pr_9/WithdrawThread.java",
  "/assets/Pr_9/Lab10.java",
  "/assets/Pr_10/Circle.java",
  "/assets/Pr_10/InvalidRadiusException.java",
  "/assets/Pr_10/Lab11.java",
  "/assets/Pr_11/ellipses.java",
  "/assets/Pr_11/line.java",
  "/assets/Pr_11/rectangle.java",
  "/assets/Pr_12/ReadWriteFile.java"
];

const ALL_CACHE_FILES = [...CORE_FILES, ...PRACTICAL_FILES];

// 🧱 INSTALL EVENT — Precache all files and show progress
self.addEventListener("install", event => {
  console.log("📦 Installing service worker & caching all files...");
  event.waitUntil(
    (async () => {
      const cache = await caches.open(CACHE_NAME);
      let cachedCount = 0;
      const totalFiles = ALL_CACHE_FILES.length;

      for (const file of ALL_CACHE_FILES) {
        try {
          await cache.add(file);
          cachedCount++;
          const progress = Math.round((cachedCount / totalFiles) * 100);
          // 🔔 Send progress update to all active pages
          self.clients.matchAll().then(clients => {
            clients.forEach(client => {
              client.postMessage({ type: "CACHE_PROGRESS", progress });
            });
          });
        } catch (error) {
          console.warn("⚠️ Failed to cache:", file);
        }
      }

      self.skipWaiting();
    })()
  );
});

// ♻️ ACTIVATE EVENT — Clean old caches
self.addEventListener("activate", event => {
  console.log("♻️ Activating new service worker...");
  event.waitUntil(
    caches.keys().then(keys => {
      return Promise.all(
        keys.filter(key => key !== CACHE_NAME).map(key => caches.delete(key))
      );
    })
  );
  self.clients.claim();
});

// 🌐 FETCH EVENT — Serve from cache, update in background
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

// 🔄 MESSAGE LISTENER — Trigger immediate update
self.addEventListener("message", event => {
  if (event.data === "SKIP_WAITING") {
    self.skipWaiting();
  }
});
