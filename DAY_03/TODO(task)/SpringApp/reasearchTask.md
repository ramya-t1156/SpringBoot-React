## 🔢 **HTTP Status Code 502 – Bad Gateway**

### 🔍 What it means:

`502 Bad Gateway` means:

> The server acting as a **gateway or proxy** got an **invalid response** from the server it was trying to talk to.

In short:
👉 The **first server** tried to forward your request to another **upstream server**, but **something went wrong** there.

---

## 🖼️ Simple Example

### You ➡️ Server A (Gateway) ➡️ Server B (Actual App)

* You send a request to **Server A**.
* Server A sends your request to **Server B** (real backend).
* If **Server B is down** or gives a **bad response**, Server A shows you:
  🔴 `502 Bad Gateway`

---

## 💬 Common Causes

| Reason                            | Description                                                 |
| --------------------------------- | ----------------------------------------------------------- |
| 🔌 Server B is down               | The upstream server is not running or crashed               |
| ⏱️ Timeout                        | Server B took too long to respond                           |
| ❌ Invalid response                | Server B responded with broken or unexpected data           |
| ⚠️ Network error                  | Server A couldn’t connect to Server B (DNS, firewall, etc.) |
| 🔄 Reverse proxy misconfiguration | e.g., Nginx or Apache is set up wrong                       |

---

## ✅ Summary

| Key               | Value                                             |
| ----------------- | ------------------------------------------------- |
| **Code**          | `502`                                             |
| **Name**          | Bad Gateway                                       |
| **Who shows it?** | A server acting as a **gateway/proxy**            |
| **Cause**         | Got a **bad or no response** from another server  |
| **Fix**           | Check backend, networking, timeout, proxy configs |
