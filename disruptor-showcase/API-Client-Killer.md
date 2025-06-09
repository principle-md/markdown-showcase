# API Endpoint: GET /api/users

This document replaces a Postman collection. It's living documentation that is interactive and can be used to generate client code.

- **Method:** `GET`
- **Path:** `/api/users`
- **Description:** Retrieves a paginated list of users.
- **Authentication:** `Required (Admin)`

---

## 1. Query Parameters

- `page` (optional, number, default: 1): The page number to retrieve.
- `limit` (optional, number, default: 10): The number of users per page.
- `sortBy` (optional, string, default: 'createdAt'): Field to sort by.
- `order` (optional, string, default: 'desc'): Sort order ('asc' or 'desc').

---

## 2. Interactive Request

Click the "Run" button to execute this request against the live development server.

```bash
curl -X GET 'https://dev-api.yourapp.com/api/users?page=1&limit=5' \
-H 'Authorization: Bearer {{DEV_TOKEN}}'
```

---

## 3. Example Response

This is the expected shape of the response. Our CI pipeline fails if the actual endpoint response doesn't match this structure.

**Status:** `200 OK`

```json
{
  "data": [
    {
      "id": "c7a8b9d0-e1f2-g3h4-i5j6-k7l8m9n0o1p",
      "name": "Alice Johnson",
      "email": "alice@example.com",
      "role": "admin",
      "createdAt": "2024-07-29T10:00:00Z"
    },
    {
      "id": "a1b2c3d4-e5f6-g7h8-i9j0-k1l2m3n4o5p",
      "name": "Bob Smith",
      "email": "bob@example.com",
      "role": "user",
      "createdAt": "2024-07-28T14:30:00Z"
    }
  ],
  "pagination": {
    "currentPage": 1,
    "totalPages": 25,
    "totalUsers": 250,
    "limit": 5
  }
}
```

---

## 4. Generate Client Code

Use these prompts to generate client code for interacting with this endpoint.

### **Generate a TypeScript Function**
```prompt
Generate a TypeScript function using `axios` to call this GET /api/users endpoint. It should accept an object for the query parameters and include the necessary type definitions for the response.
```

### **Generate a Python Client**
```prompt
Generate a Python function using the `requests` library to call this endpoint. It should handle authentication and allow passing query parameters.
```

### **Generate Test Cases**
```prompt
Generate a test file using `jest` and `supertest` to test this endpoint. Include tests for a successful request, an unauthorized request, and a request with invalid query parameters.
```

---

> **The Guidewire Advantage:** Your API documentation is never stale. It's interactive, testable, and acts as a factory for generating client code and tests, eliminating the need for separate tools like Postman or Insomnia. 