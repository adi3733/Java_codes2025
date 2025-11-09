// 🧩 Java Code Vault by TechhBuddies
// Supports multi-class practicals with file switching tabs

const practicals = [
  {
    id: 1,
    name: "Practical 1",
    desc: "Factorial, Prime, Sum & Average Programs",
    files: [
      { name: "sum_avg.java", path: "/assets/Pr_1/sum_avg.java" },
      { name: "facto.java", path: "/assets/Pr_1/facto.java" },
      { name: "facto_user.java", path: "/assets/Pr_1/facto_user.java" },
      { name: "prime_no.java", path: "/assets/Pr_1/prime_no.java" }
    ]
  },
  {
    id: 2,
    name: "Practical 2",
    desc: "Calculator using Switch Case",
    files: [
      { name: "calcu.java", path: "/assets/Pr_2/calcu.java" },
      { name: "switch_case.java", path: "/assets/Pr_2/switch_case.java" }
    ]
  },
  {
    id: 3,
    name: "Practical 3",
    desc: "Class Rectangle",
    files: [
      { name: "rect.java", path: "/assets/Pr_3/rect.java" }
    ]
  },
  {
    id: 4,
    name: "Practical 4",
    desc: "Method & Constructor Overloading",
    files: [
      // { name: "rect.java", path: "/assets/Pr_4/rect.java" },
      { name: "Rectangle.java" , path: "/assets/Pr_4/Rectangle.java"}
    ]
  },
  {
    id: 5,
    name: "Practical 5",
    desc: "Sorting in Java",
    files: [
      { name: "sort_int.java", path: "/assets/Pr_5/sort_int.java" },
      { name: "brute_force_approch.java", path: "/assets/Pr_5/brute_force_approch.java" },
      { name: "Inbuilt_sort.java", path: "/assets/Pr_5/Inbuilt_sort.java" }
    ]
  },
  {
    id: 6,
    name: "Practical 6",
    desc: "Addition of Two Matrices",
    files: [
      { name: "AddMatrix.java", path: "/assets/Pr_6/AddMatrix.java" }
    ]
  },
  {
    id: 7,
    name: "Practical 7",
    desc: "Inheritance in Java",
    files: [
      { name: "Demo1.java", path: "/assets/Pr_7/Demo1.java" }
    ]
  },
  {
    id: 8,
    name: "Practical 8",
    desc: "Implementation of Interface",
    files: [
      { name: "Sports.java", path: "/assets/Pr_8/Program For Class.java" },
      { name: "InterfaceDemo.java", path: "/assets/Pr_8/Program For Interface.java" }
    ]
  },
{
  "id": 9,
  "name": "Practical 9",
  "desc": "Multithreading Example",
  "files": [
    { "name": "Account.java", "path": "/assets/Pr_9/Program For Account Thread.java" },
    { "name": "DepositeThread.java", "path": "/assets/Pr_9/Program for Deposit Thread.java" },
    { "name": "Lab9.java", "path": "/assets/Pr_9/Program For Main Thread.java" },
    { "name": "WithdrawThread.java", "path": "/assets/Pr_9/Program for Withdraw Thread.java" }
  ]
},

  {
    id: 10,
    name: "Practical 10",
    desc: "Exception Handling (try-catch)",
    files: [
      { name: "Circle.java", path: "/assets/Pr_10/Circle.java" },
      { name: "InvalidRadiusException.java", path: "/assets/Pr_10/InvalidRadiusException.java" },
      { name: "Lab10.java", path: "/assets/Pr_10/Program for lab10(main thread_Source).java" }
    ]
  },
  {
    id: 11,
    name: "Practical 11",
    desc: "Java Graphics Class",
    files: [
      { name: "ellipses.java", path: "/assets/Pr_11/ellipses.java" },
      { name: "line.java", path: "/assets/Pr_11/line.java" },
      { name: "rectangle.java", path: "/assets/Pr_11/rectangle.java" }
    ]
  },
  {
    id: 12,
    name: "Practical 12",
    desc: "File Handling",
    files: [
      { name: "ReadWriteFile.java", path: "/assets/Pr_12/ReadWriteFile.java" }
    ]
  }
];

// 🌟 DOM Elements
const list = document.getElementById("practicalList");
const popup = document.getElementById("popup");
const popupTitle = document.getElementById("popupTitle");
const popupCode = document.getElementById("popupCode");
const copyBtn = document.getElementById("copyBtn");
const closeBtn = document.getElementById("closeBtn");
const fileTabs = document.getElementById("fileTabs");

// 🧱 Render Practical Cards
practicals.forEach(p => {
  const card = document.createElement("div");
  card.className = "card";
  const count = p.files.length;
  card.innerHTML = `
    <h3>${p.name}</h3>
    <span>${p.desc} — ${count} file${count > 1 ? "s" : ""}</span>
  `;
  card.onclick = () => openPopup(p);
  list.appendChild(card);
});

// 🌐 Popup Logic
let currentCode = "";
let currentFontSize = 0.95;

function openPopup(p) {
  popupTitle.textContent = `${p.name}: ${p.desc}`;
  popup.style.display = "flex";

  // Create file tabs
  fileTabs.innerHTML = "";
  p.files.forEach((f, idx) => {
    const btn = document.createElement("button");
    btn.className = "file-tab";
    btn.textContent = f.name;
    btn.onclick = (e) => {
      e.stopPropagation();
      setActiveFile(p, idx);
    };
    fileTabs.appendChild(btn);
  });

  // Load first file by default
  setActiveFile(p, 0);
}

function setActiveFile(practical, index) {
  const tabs = Array.from(fileTabs.children);
  tabs.forEach((tab, i) => tab.classList.toggle("active", i === index));
  const file = practical.files[index];

  fetch(file.path)
    .then(res => {
      if (!res.ok) throw new Error("File not found");
      return res.text();
    })
    .then(code => {
      currentCode = code;
      popupCode.textContent = code;
      copyBtn.textContent = "📋 Copy Code";
      popupCode.style.fontSize = `${currentFontSize}rem`;
    })
    .catch(() => {
      popupCode.textContent = `⚠️ Unable to load file: ${file.name}`;
    });
}

// 📋 Copy Function
copyBtn.onclick = () => {
  if (!currentCode) return;
  navigator.clipboard.writeText(currentCode);
  copyBtn.textContent = "✅ Copied!";
  setTimeout(() => (copyBtn.textContent = "📋 Copy Code"), 1500);
};

// 🔤 Font Size Controls
const fontPlus = document.getElementById("fontPlus");
const fontMinus = document.getElementById("fontMinus");

fontPlus.onclick = () => {
  currentFontSize += 0.1;
  popupCode.style.fontSize = `${currentFontSize}rem`;
};

fontMinus.onclick = () => {
  if (currentFontSize > 0.6) {
    currentFontSize -= 0.1;
    popupCode.style.fontSize = `${currentFontSize}rem`;
  }
};

// ❌ Close Popup
closeBtn.onclick = () => {
  popup.style.display = "none";
};

// 🕒 Build Timestamp
const buildVersion = document.getElementById("buildVersion");
const now = new Date();
buildVersion.textContent = now.toLocaleString("en-IN", {
  dateStyle: "medium",
  timeStyle: "short",
});



// 📱 Layout Switch (1-column ↔ 2-column for mobile)
const toggleBtn = document.getElementById("toggleLayout");
const layoutContainer = document.getElementById("layoutToggleContainer");
const grid = document.getElementById("practicalList");

if (window.innerWidth <= 600) {
  layoutContainer.style.display = "block";
  let isTwoColumn = false;

  toggleBtn.addEventListener("click", () => {
    isTwoColumn = !isTwoColumn;

    if (isTwoColumn) {
      grid.style.gridTemplateColumns = "repeat(2, 1fr)";
      toggleBtn.textContent = "📋 Switch to 1-Column Layout";
    } else {
      grid.style.gridTemplateColumns = "1fr";
      toggleBtn.textContent = "🔳 Switch to 2-Column Layout";
    }
  });
} else {
  layoutContainer.style.display = "none";
}



// 🧩 Manual Cache Refresh (Optional)
if ('serviceWorker' in navigator) {
  const refreshCache = async () => {
    const reg = await navigator.serviceWorker.getRegistration();
    if (reg && reg.active) {
      reg.active.postMessage('SKIP_WAITING');
      window.location.reload();
    }
  };
  // Example: refreshCache(); // call when needed
}


// 🧱 Listen for cache progress messages from service worker
if ("serviceWorker" in navigator) {
  navigator.serviceWorker.addEventListener("message", event => {
    if (event.data && event.data.type === "CACHE_PROGRESS") {
      const percent = event.data.progress;
      const progressEl = document.getElementById("cacheProgress");

      if (progressEl) {
        progressEl.style.display = "block";
        progressEl.textContent = `Downloading for offline use: ${percent}%`;

        if (percent >= 100) {
          setTimeout(() => {
            progressEl.textContent = "✅ Ready to use offline!";
          }, 500);
        }
      }
    }
  });
}
