# Protocol Tests 🔌

This file specifically tests various URL protocols and how they're handled by the system.

**Navigation:**
- [Back to Hub](./index.md)
- [External Links](./external-links.md)
- [Cross-Document](./cross-document.md)


## Standard Web Protocols

Testing the most common web protocols.

### HTTP/HTTPS
- [HTTP Example](http://example.com) - Insecure HTTP
- [HTTPS Example](https://example.com) - Secure HTTPS
- [HTTPS with Path](https://github.com/microsoft/vscode) - Secure with path
- [HTTPS with Query](https://www.google.com/search?q=test) - With query parameters

### FTP Protocols
- [Standard FTP](ftp://ftp.example.com) - File Transfer Protocol
- [Secure FTP](sftp://secure.example.com) - Secure FTP

**Expected:** Should open in default browser or appropriate handler.


## Communication Protocols

Testing communication and messaging protocols.

### Email Protocols
- [Basic Email](mailto:test@example.com) - Simple email
- [Email with Subject](mailto:test@example.com?subject=Test%20Message) - With subject
- [Email with Body](mailto:test@example.com?body=Hello%20World) - With body
- [Complex Email](mailto:team@example.com?subject=Meeting&body=Let's%20meet&cc=manager@example.com) - Full email composition

### Phone Protocols
- [Phone Call](tel:+1234567890) - Direct phone number
- [International](tel:+44-20-7946-0958) - International format
- [SMS Message](sms:+1234567890) - SMS to number
- [SMS with Text](sms:+1234567890?body=Hello%20from%20test) - SMS with message

**Expected:** Should open appropriate communication app.


## Application Deep Links

Testing application-specific protocol handlers.

### Development Tools
- [VS Code File](vscode://file/Users/example/project/file.js) - VS Code file opening
- [VS Code Settings](vscode://settings/workbench.colorTheme) - VS Code settings
- [GitHub Desktop](x-github-client://openRepo/https://github.com/user/repo) - GitHub Desktop

### Design Tools
- [Figma File](figma://file/abc123) - Figma design file
- [Sketch File](sketch://document/xyz789) - Sketch document

### Communication Apps
- [Slack Channel](slack://channel?team=T1234&id=C5678) - Slack channel
- [Discord Server](discord://discord.com/channels/123/456) - Discord channel
- [Zoom Meeting](zoommtg://zoom.us/join?confno=123456789) - Zoom meeting

**Expected:** Should open in respective application if installed.


## Media and Content Protocols

Testing media and content-specific protocols.

### Streaming Services
- [Spotify Track](spotify:track:4uLU6hMCjMI75M1A2tKUQC) - Spotify song
- [Apple Music](music://music.apple.com/album/123456) - Apple Music
- [YouTube](https://youtube.com/watch?v=dQw4w9WgXcQ) - YouTube video

### Social Media
- [Twitter Profile](twitter://user?screen_name=example) - Twitter user
- [Instagram Profile](instagram://user?username=example) - Instagram user
- [LinkedIn Profile](linkedin://profile/example) - LinkedIn profile

### File Protocols
- [File Reference](file:///Users/Shared/example.txt) - Local file reference
- [Network Share](smb://server.local/share/file.txt) - SMB network share

**Expected:** Should open in appropriate app or browser.



## Custom and Uncommon Protocols

Testing less common but valid protocols.

### Data URLs
- [Base64 Text](data:text/plain;base64,SGVsbG8gV29ybGQ=) - "Hello World" in base64
- [HTML Data](data:text/html,<h1>Hello</h1>) - Inline HTML
- [CSS Data](data:text/css,body{color:red}) - Inline CSS

### Network Protocols
- [SSH Connection](ssh://user@server.com) - SSH protocol
- [Telnet Connection](telnet://server.com:23) - Telnet protocol
- [Git Repository](git://github.com/user/repo.git) - Git protocol

### Specialized Protocols
- [Calendar Event](webcal://calendar.example.com/calendar.ics) - Calendar subscription
- [News Feed](feed://feeds.example.com/news.xml) - RSS/Atom feed
- [Magnet Link](magnet:?xt=urn:btih:example) - BitTorrent magnet link

**Expected:** May show protocol handler dialog or open in specialized apps.



## Protocol Edge Cases

Testing edge cases and malformed protocols.

### Malformed URLs
- [No Protocol](www.example.com) - Missing protocol (browser may auto-fix)
- [Invalid Protocol](invalid://example.com) - Non-existent protocol
- [Empty Protocol](://example.com) - Empty protocol

### Special Characters
- [Spaces in URL](https://example.com/path with spaces) - Spaces (may be encoded)
- [Unicode URL](https://例え.テスト) - International domain
- [Encoded URL](https://example.com/path%20with%20encoded%20spaces) - URL encoded

### Edge Cases
- [Fragment Only](#fragment-test) - Internal fragment
- [Query Only](?query=test) - Query without base
- [Empty URL]() - Completely empty

**Expected:** Should handle gracefully or show appropriate error.



## Fragment Test

✅ **You reached the fragment test section!**

This section tests internal fragment navigation within the protocol test file.

### Fragment Navigation
- [Back to Top](#standard-web-protocols)
- [Jump to Communication](#communication-protocols)
- [Skip to Applications](#application-deep-links)

**This validates that internal navigation still works in protocol test files.**



## Security Considerations

Testing potential security-related protocols and URLs.

### Potentially Dangerous Protocols
⚠️ **Warning:** These are safe test URLs, but in real usage be careful!

- [JavaScript URL](javascript:alert('test')) - JavaScript execution (should be blocked)
- [Data with Script](data:text/html,<script>alert('test')</script>) - Script in data URL
- [Vbscript URL](vbscript:msgbox("test")) - VBScript (should be blocked)

### Safe But Unusual
- [About Blank](about:blank) - Browser about page
- [About Config](about:config) - Browser configuration (Firefox)
- [Chrome Settings](chrome://settings/) - Chrome internal pages

**Expected:** Dangerous protocols should be blocked; safe ones may work.



## Protocol Testing Results

Track your protocol testing results:

### Standard Protocols
- [ ] HTTP/HTTPS ✅/❌
- [ ] FTP/SFTP ✅/❌

### Communication
- [ ] Email (mailto) ✅/❌
- [ ] Phone (tel) ✅/❌
- [ ] SMS ✅/❌

### Application Deep Links
- [ ] VS Code ✅/❌
- [ ] Design tools ✅/❌
- [ ] Communication apps ✅/❌

### Media and Content
- [ ] Streaming services ✅/❌
- [ ] Social media ✅/❌
- [ ] File protocols ✅/❌

### Custom and Uncommon
- [ ] Data URLs ✅/❌
- [ ] Network protocols ✅/❌
- [ ] Specialized protocols ✅/❌

### Edge Cases
- [ ] Malformed URLs ✅/❌
- [ ] Special characters ✅/❌
- [ ] Security handling ✅/❌

### Overall Assessment
- [ ] Protocols handled correctly ✅/❌
- [ ] Security measures working ✅/❌
- [ ] Error handling appropriate ✅/❌
- [ ] User experience smooth ✅/❌

**Next Steps:**
- [Return to Hub](./index.md)
- [Test External Links](./external-links.md)
- [Try Deep Navigation](./deep-navigation.md)

**Protocol Tests: COMPLETE! 🔌** 