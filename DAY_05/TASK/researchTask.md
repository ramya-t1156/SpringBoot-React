## What is CSRF? (In simple words)

**CSRF** means **Cross-Site Request Forgery**.

It is when a **bad website** tricks a **logged-in user** into doing something **they didn’t want to do** on another website.

---

### Real-Life Example (Easy to Understand)

Let’s say:

* You are **logged into your bank** website.
* You now open **a bad website** in another tab.

That bad website secretly sends a **money transfer request** to your bank **using your login session** (because your browser still has cookies for the bank).

Result: The bank thinks **you sent money**, but **you didn’t** — the hacker did!

---

## What does Spring Boot do?

Spring Boot uses **Spring Security**, which helps **protect your website** from CSRF attacks by using something called a **CSRF token**.

---

### What is a CSRF token?

* A **secret code** (token) is given to your form.
* When you submit the form, the token is sent with it.
* Spring Boot checks:

  > "Is this token valid?"
* If yes → Allow the request
  If no → **Block the request**

This means: **Hackers can't trick you**, because **they don’t know the secret token**.

---

## Default Behavior in Spring Boot

* If you're making **web pages with login forms**, CSRF protection is **automatically turned ON**.
* You don’t need to do anything!

---

### When do we turn it OFF?

If you're building a:

* **REST API**
* That uses **Postman**, or
* Uses **JWT tokens instead of sessions**

Then you can turn it OFF:

```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())  // turns off CSRF
        .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
        .httpBasic();
    return http.build();
}
```

---

###  Summary (Very Short)

| -------------------- | ----------------------------------------------------- |
| **CSRF**             | A hacker tricking a logged-in user to perform actions |
| **Spring Boot**      | Protects you by using a CSRF token                    |
| **Token**            | A hidden secret added to forms                        |
| **When needed?**     | Needed for web forms with sessions                    |
| **When not needed?** | Not needed for REST APIs using JWT or tokens          |

---
