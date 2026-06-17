### Project Description

This project is a "set-and-forget" mobile application designed to curate and personalize a user's Instagram feed. Users connect their account and select their target interests (e.g., Technology, Startups) as well as topics they want to suppress. A backend automation engine then seamlessly runs in the background, interacting with the platform to train Instagram's recommendation algorithm to match the user's specific goals.

---

### Tech Stack: Languages & Tools

* **Languages:** **JavaScript** / **TypeScript** (used uniformly across the entire stack for fast development and seamless code-sharing)
* **Frontend Framework:** **React Native + Expo** (for cross-platform iOS and Android application deployment and a modern UI/UX)


* **Backend Environment:** **Node.js** (to handle API processing and orchestrate the background automation loops)


* **Database & Backend-as-a-Service:** **Supabase** or **Firebase** (manages user authentication, secure token storage, and real-time state syncing)


* **Automation Frameworks:** **Playwright** or **Puppeteer** (headless browser tools used on the backend to simulate native user browsing patterns safely)



---

### How It Works

1. **Onboarding & Preference Mapping:** The user opens the mobile app, securely logs in, and authenticates their Instagram profile. They select positive topics they want to promote and negative topics they want to avoid.


2. **Session & Token Handshake:** The application encrypts the session state or authentication cookies, safely passing them to a secure Node.js cloud environment managed by Supabase or Firebase.


3. **Background Automation Loop:** Dedicated, randomized backend cron jobs spin up headless browser instances (via Playwright or Puppeteer) acting on behalf of the user.


4. **Algorithmic Algorithmic Curation:** The system searches for preferred interest tags, lingers on matching posts, and applies likes to content to manually signal high interest to Instagram's recommendation engine. Conversely, it systematically skips or flags negative interests.


5. **Status Monitoring:** The user can open their lightweight app dashboard at any point to verify the automation's health status, view recent background actions completed, and check real-time personalization progress.
