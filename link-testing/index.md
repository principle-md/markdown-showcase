# Link Testing Hub 🔗

Welcome to the comprehensive link testing suite! This collection of markdown files tests all types of link functionality in the markdown slides extension.



## Test Categories

Click any link below to start testing specific functionality:

### ✨ NEW: UX Improvements  
- **[🚀 Loading Feedback Demo](./loading-feedback-demo.md)** - **Enhanced user experience with loading states and feedback!**

### 📍 Internal Navigation Tests
- [Internal Section Links](./internal-links.md) - Test navigation within a single presentation
- [Complex Internal Navigation](./complex-internal.md) - Multi-level headings and edge cases

### 🌐 External Link Tests  
- [External URLs](./external-links.md) - Test various external link types
- [Protocol Tests](./protocol-tests.md) - Test different URL protocols

### 📄 Cross-Document Tests
- [Cross-Document Navigation](./cross-document.md) - Test links between markdown files
- [Anchor-Specific Links](./file-with-anchors.md) - File designed for anchor testing
- [Deep Navigation](./deep-navigation.md) - Multi-hop navigation chains

### 📁 Directory Navigation Tests
- [Subfolder Navigation](./subfolder/nested-file.md) - Test relative path navigation
- [Parent Directory Links](./parent-directory-test.md) - Test `../` navigation



## Quick Test Scenarios

### Scenario 1: Basic Navigation
1. Start here: [Internal Links](./internal-links.md)
2. Use internal navigation within that file
3. Come back via: [Return to Hub](#test-categories)

### Scenario 2: Cross-Document Journey
1. Go to: [Cross-Document Navigation](./cross-document.md)
2. Follow the chain of links through multiple files
3. End at: [Deep Nested File](./subfolder/deeper/deep-nested.md)

### Scenario 3: Mixed Link Types
1. Start with: [External Links](./external-links.md)
2. Then navigate to: [File with Anchors](./file-with-anchors.md#middle-section)
3. Finally: [Complex Internal](./complex-internal.md#advanced-features)



## File Structure Overview

```
link-testing/
├── index.md                    ← You are here
├── internal-links.md          
├── external-links.md          
├── cross-document.md          
├── file-with-anchors.md       
├── complex-internal.md        
├── protocol-tests.md          
├── deep-navigation.md         
├── parent-directory-test.md   
├── subfolder/
│   ├── nested-file.md
│   └── deeper/
│       └── deep-nested.md
├── assets/
│   ├── sample.txt
│   └── test-image.png
└── README.md
```

### Testing Instructions
1. **Open VS Code** in the `PrincipleMD` workspace
2. **Navigate** to this file (`link-testing/index.md`)
3. **Run** "Open Markdown Slides" command
4. **Click links** to test different functionality
5. **Observe** behavior for each link type



## Expected Behaviors

| Link Type | Example | Expected Result |
|-----------|---------|----------------|
| **Internal Section** | `#test-categories` | Navigate to slide with that heading |
| **Same Directory** | `./internal-links.md` | Open file in new slides view |
| **Subdirectory** | `./subfolder/nested-file.md` | Navigate down into folder |
| **Parent Directory** | `../README.md` | Navigate up to parent folder |
| **With Anchor** | `./file-with-anchors.md#middle-section` | Open file and jump to section |
| **External URL** | `https://github.com` | Open in external browser |
| **Non-Markdown** | `./assets/sample.txt` | Open in VS Code text editor |

### Test Results Log
- [x] Internal section navigation ✅/❌
- [x] Same directory markdown files ✅/❌
- [x] Subdirectory navigation ✅/❌
- [x] Parent directory links ✅/❌
- [x] Cross-document anchors ✅/❌
- [x] External URL handling ✅/❌
- [x] Non-markdown file opening ✅/❌
- [ ] Complex navigation chains ✅/❌

**Happy Testing! 🚀** 