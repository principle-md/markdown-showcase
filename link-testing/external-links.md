# External Links Test 🌐

This file tests external URL handling with various protocols and domains.

**Navigation:**
- [Back to Hub](./index.md)
- [Internal Links Test](./internal-links.md)
- [Cross-Document Test](./cross-document.md)



## HTTP/HTTPS URLs

The most common external links. These should open in your default browser.

### Popular Websites
- [GitHub](https://github.com) - Code hosting platform
- [Stack Overflow](https://stackoverflow.com) - Developer Q&A
- [MDN Web Docs](https://developer.mozilla.org) - Web technology docs
- [VS Code](https://code.visualstudio.com) - The editor you're likely using!

### Specific Pages
- [Markdown Guide](https://www.markdownguide.org/basic-syntax/) - Deep link to specific page
- [GitHub Issues](https://github.com/microsoft/vscode/issues) - Project-specific page
- [TypeScript Handbook](https://www.typescriptlang.org/docs/) - Documentation

**Expected Behavior:** Each link should open in your default browser.



## Email Links

Test `mailto:` protocol handling.

### Basic Email Links
- [Contact Support](mailto:support@example.com) - Basic email
- [Sales Inquiry](mailto:sales@company.com?subject=Product%20Inquiry) - With subject
- [Bug Report](mailto:bugs@example.com?subject=Bug%20Report&body=Describe%20the%20issue...) - With subject and body

### Multiple Recipients
- [Team Email](mailto:team@example.com,lead@example.com?cc=manager@example.com) - Multiple recipients with CC

**Expected Behavior:** Should open your default email client with the address pre-filled.



## File Protocol Links

Testing file:// protocol (may have security restrictions).

### Local File Links
- [Local Document](file:///Users/Shared/sample.txt) - Absolute local file
- [System File](file:///etc/hosts) - System file (Unix/Mac)

⚠️ **Note:** File protocol links may be blocked for security reasons in some environments.

**Expected Behavior:** May be blocked or open in file explorer.



## Custom Protocol Links

Testing various custom protocols that applications might register.

### Development Tools
- [VS Code](vscode://file/path/to/file) - VS Code deep link
- [Slack](slack://channel?team=T1234&id=C1234) - Slack deep link

### Other Applications
- [Zoom Meeting](zoommtg://zoom.us/join?confno=123456789) - Zoom meeting link
- [Spotify](spotify:track:4uLU6hMCjMI75M1A2tKUQC) - Spotify track link

**Expected Behavior:** Should open in the respective application if installed.



## FTP and Other Protocols

Testing less common but valid protocols.

### FTP Links
- [Public FTP](ftp://ftp.example.com/public/) - FTP server
- [Secure FTP](sftp://secure.example.com/files/) - SFTP server

### Other Protocols
- [Telephone](tel:+1234567890) - Phone number
- [SMS](sms:+1234567890?body=Hello%20World) - SMS message
- [WhatsApp](https://wa.me/1234567890) - WhatsApp chat

**Expected Behavior:** Should open in appropriate application or show protocol handler dialog.



## URL Edge Cases

Testing edge cases and complex URLs.

### URLs with Fragments
- [GitHub README](https://github.com/microsoft/vscode#readme) - URL with fragment
- [MDN Anchor](https://developer.mozilla.org/en-US/docs/Web/CSS#reference) - Deep anchor link

### URLs with Query Parameters
- [Google Search](https://www.google.com/search?q=markdown+slides) - Search query
- [YouTube Video](https://www.youtube.com/watch?v=dQw4w9WgXcQ&t=30s) - Video with timestamp

### Complex URLs
- [API Endpoint](https://api.github.com/repos/microsoft/vscode/issues?state=open&labels=bug) - API with parameters
- [Long URL](https://www.example.com/very/long/path/with/many/segments?param1=value1&param2=value2&param3=value3#section) - Complex structure



## Link Text Variations

Testing different link text patterns and styles.

### Different Text Styles
- **Bold link:** [**GitHub**](https://github.com)
- *Italic link:* [*Stack Overflow*](https://stackoverflow.com)
- `Code link:` [`VS Code`](https://code.visualstudio.com)
- Mixed: [**Bold** and *italic* link](https://example.com)

### Long Link Text
- [This is a very long link text that spans multiple words and tests how the system handles longer link descriptions](https://example.com)

### Special Characters in Link Text
- [Link with "quotes"](https://example.com)
- [Link with & symbols](https://example.com)
- [Link with emoji 🚀](https://example.com)



## Invalid and Edge Case URLs

Testing how the system handles problematic URLs.

### Malformed URLs
- [Missing Protocol](www.example.com) - Should still work in most browsers
- [Invalid Characters](https://example.com/path with spaces) - Spaces in URL
- [Empty Link]() - Empty href attribute

### Suspicious URLs
⚠️ **Warning:** These are safe test URLs, but in real usage, be careful with suspicious links!

- [Suspicious Domain](https://definitely-not-malicious.example.com) - Safe test URL
- [IP Address](http://127.0.0.1:8080) - Local IP (safe)
- [Data URL](data:text/plain;base64,SGVsbG8sIFdvcmxkIQ==) - Base64 encoded "Hello, World!"



## Testing Results

Use this section to track your testing results:

### HTTP/HTTPS URLs
- [ ] GitHub ✅/❌
- [ ] Stack Overflow ✅/❌
- [ ] MDN Web Docs ✅/❌
- [ ] Deep links ✅/❌

### Email Links
- [ ] Basic mailto ✅/❌
- [ ] With subject ✅/❌
- [ ] Multiple recipients ✅/❌

### Custom Protocols
- [ ] VS Code links ✅/❌
- [ ] Application links ✅/❌

### Edge Cases
- [ ] URLs with fragments ✅/❌
- [ ] Query parameters ✅/❌
- [ ] Malformed URLs ✅/❌

### Overall Assessment
- [ ] External links open in browser ✅/❌
- [ ] Protocol handling works ✅/❌
- [ ] Error handling for invalid URLs ✅/❌
- [ ] No security issues ✅/❌

**Next Steps:**
- [Return to Hub](./index.md)
- [Test Cross-Document Links](./cross-document.md)
- [Test Protocol Handling](./protocol-tests.md)

**External Links Test: COMPLETE! 🌐** 