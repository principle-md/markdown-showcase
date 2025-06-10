# Link Testing Suite Documentation 📖

This directory contains a comprehensive testing suite for markdown link functionality in the PrincipleMD slide system.

## Overview

The link testing suite validates all types of link navigation supported by the markdown slides extension, including:
- Internal section navigation within files
- Cross-document navigation between files
- External URL handling
- Directory traversal and relative paths
- Protocol handling and security
- Error scenarios and edge cases

## File Structure

```
link-testing/
├── README.md                   ← This documentation
├── index.md                    ← Main testing hub and entry point
├── internal-links.md           ← Internal section navigation tests
├── external-links.md           ← External URL and protocol tests
├── cross-document.md           ← Cross-file navigation tests
├── file-with-anchors.md        ← Target file for anchor testing
├── deep-navigation.md          ← Complex navigation chains
├── complex-internal.md         ← Advanced internal navigation
├── protocol-tests.md           ← Comprehensive protocol testing
├── parent-directory-test.md    ← Parent directory navigation
├── subfolder/
│   ├── nested-file.md          ← Subdirectory navigation test
│   └── deeper/
│       └── deep-nested.md      ← Deep nested navigation test
└── assets/
    ├── sample.txt              ← Plain text file for testing
    └── config.json             ← JSON file for testing
```

## Getting Started

### Prerequisites
- VS Code with the PrincipleMD extension installed
- A markdown file open in the PrincipleMD workspace
- The markdown slides extension enabled

### Running Tests

1. **Open the main hub:**
   ```
   Navigate to: link-testing/index.md
   Run command: "Open Markdown Slides"
   ```

2. **🆕 Try the new UX improvements:**
   - **Start with:** [Loading Feedback Demo](./loading-feedback-demo.md)
   - **Experience:** Enhanced loading states and user feedback
   - **See:** Immediate visual feedback and progress notifications

3. **Follow the guided tests:**
   - Start with the Hub file for navigation overview
   - Follow the test scenarios provided
   - Use the checklist to track your progress

4. **Test systematically:**
   - Internal navigation first
   - Cross-document navigation second
   - External links and protocols
   - Advanced scenarios and edge cases

## Test Categories

### 1. Internal Section Navigation (`internal-links.md`)
**Purpose:** Test navigation within a single markdown file
**Features:**
- Basic section links (`#heading`)
- Special characters in headings
- Numbered sections
- Navigation chains
- Multi-level headings
- Emoji in headings

**Expected Results:**
- Instant navigation to target slides
- Proper slug generation for all heading types
- Smooth user experience

### 2. External URL Handling (`external-links.md`)
**Purpose:** Test external URL navigation and protocol handling
**Features:**
- HTTP/HTTPS URLs
- Email links (`mailto:`)
- Phone links (`tel:`, `sms:`)
- File protocol links
- Custom application protocols
- Edge cases and malformed URLs

**Expected Results:**
- External URLs open in default browser
- Protocol-specific links open appropriate apps
- Graceful handling of invalid URLs

### 3. Cross-Document Navigation (`cross-document.md`)
**Purpose:** Test navigation between different markdown files
**Features:**
- Same directory file links
- Cross-document anchor navigation
- Directory traversal (subdirectories and parent directories)
- File type detection
- Navigation chains across files
- Error handling for missing files

**Expected Results:**
- Markdown files open in slide presentation
- Anchor navigation works across files
- Non-markdown files open in appropriate editors

### 4. Anchor Target Testing (`file-with-anchors.md`)
**Purpose:** Provide a target file for anchor navigation testing
**Features:**
- Various section types for targeting
- Complex heading names
- Special characters and emoji
- Multi-level nested content
- Cross-reference validation

**Expected Results:**
- All sections are reachable via anchor links
- Proper slug generation for complex headings
- Consistent behavior across link sources

### 5. Deep Navigation Chains (`deep-navigation.md`)
**Purpose:** Test complex navigation patterns and chains
**Features:**
- Multi-file navigation sequences
- Circular references
- Performance stress testing
- Error recovery scenarios
- Complex anchor resolution

**Expected Results:**
- Navigation chains work smoothly
- System handles circular references
- Performance remains good under load
- Graceful error recovery

### 6. Complex Internal Structure (`complex-internal.md`)
**Purpose:** Test advanced internal navigation scenarios
**Features:**
- Many sections (16+ major sections)
- Various heading levels and styles
- Unicode characters in headings
- Performance under load
- Complex anchor names

**Expected Results:**
- All sections navigable regardless of complexity
- Unicode support in anchors
- Consistent performance with many sections

### 7. Protocol Comprehensive Testing (`protocol-tests.md`)
**Purpose:** Extensive protocol and URL scheme testing
**Features:**
- Standard web protocols (HTTP, HTTPS, FTP)
- Communication protocols (mailto, tel, sms)
- Application deep links (VS Code, Slack, etc.)
- Custom and uncommon protocols
- Security considerations
- Malformed URL handling

**Expected Results:**
- Each protocol handled appropriately
- Security restrictions enforced
- User-friendly error messages

### 8. Directory Navigation (`subfolder/`, `parent-directory-test.md`)
**Purpose:** Test relative path resolution and directory traversal
**Features:**
- Subdirectory navigation
- Parent directory navigation
- Complex relative paths
- Cross-directory anchors
- Path edge cases
- Security boundaries

**Expected Results:**
- Correct path resolution at all levels
- Security restrictions prevent unauthorized access
- Consistent behavior across path styles

## Test Scenarios

### Scenario 1: Basic Navigation
1. Start at `index.md`
2. Navigate to `internal-links.md`
3. Use internal navigation within that file
4. Return to hub

### Scenario 2: Cross-Document Journey
1. Start at `cross-document.md`
2. Navigate through multiple files following links
3. End at `subfolder/deeper/deep-nested.md`
4. Verify all navigation worked correctly

### Scenario 3: Mixed Link Types
1. Test external links in `external-links.md`
2. Navigate to `file-with-anchors.md#middle-section`
3. Continue to `complex-internal.md#advanced-features`
4. Verify all link types function properly

### Scenario 4: Error Handling
1. Test broken links in various files
2. Verify appropriate error messages
3. Ensure system continues functioning after errors
4. Test recovery from error states

## Expected Behaviors

| Link Type | Example | Expected Result |
|-----------|---------|----------------|
| **Internal Section** | `#heading` | Navigate to slide with that heading |
| **Same Directory** | `./file.md` | Open file in new slides view |
| **Subdirectory** | `./subfolder/file.md` | Navigate down into folder |
| **Parent Directory** | `../file.md` | Navigate up to parent folder |
| **With Anchor** | `./file.md#section` | Open file and jump to section |
| **External URL** | `https://example.com` | Open in external browser |
| **Non-Markdown** | `./file.txt` | Open in VS Code text editor |

## Troubleshooting

### Common Issues

1. **Links not working:**
   - Verify VS Code extension is active
   - Check file paths are correct
   - Ensure markdown slides mode is enabled

2. **Anchor navigation fails:**
   - Verify target sections exist
   - Check for typos in anchor names
   - Ensure proper slug generation

3. **External links don't open:**
   - Check default browser settings
   - Verify URL format is correct
   - Test with simple URLs first

4. **File links show errors:**
   - Verify file paths exist
   - Check relative path calculation
   - Ensure files are in workspace

### Debugging Tips

1. **Use browser developer tools** to inspect link behavior
2. **Check VS Code console** for error messages
3. **Test incrementally** - start with simple links
4. **Verify file structure** matches expected paths
5. **Check security settings** that might block certain protocols

## Test Results Tracking

Each test file includes a results tracking section. Use these to systematically verify functionality:

- ✅ = Feature working correctly
- ❌ = Feature not working or error
- ⏳ = Test pending or inconclusive

### Overall Assessment Checklist

- [ ] Internal section navigation ✅/❌
- [ ] Same directory markdown files ✅/❌
- [ ] Subdirectory navigation ✅/❌
- [ ] Parent directory links ✅/❌
- [ ] Cross-document anchors ✅/❌
- [ ] External URL handling ✅/❌
- [ ] Non-markdown file opening ✅/❌
- [ ] Complex navigation chains ✅/❌
- [ ] Protocol handling ✅/❌
- [ ] Error handling ✅/❌

## Contributing

To add new tests or improve existing ones:

1. **Follow the naming convention:** `test-type.md`
2. **Include comprehensive scenarios** for the feature being tested
3. **Add cross-references** to link files together
4. **Update the hub file** (`index.md`) with new test links
5. **Document expected behaviors** clearly
6. **Include both positive and negative test cases**

## Support

For issues or questions about the link testing suite:
- Check the main PrincipleMD documentation
- Review VS Code extension logs
- Test with minimal examples first
- Report issues with specific test scenarios that fail

---

**Happy Testing! 🚀**

*This testing suite ensures robust link functionality across all supported markdown link types and scenarios.* 