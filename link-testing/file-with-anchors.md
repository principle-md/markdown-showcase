# File with Anchors Target 🎯

This file is specifically designed to test cross-document anchor navigation.

**Navigation:**
- [Back to Hub](./index.md)
- [Cross-Document Test](./cross-document.md)
- [Deep Navigation](./deep-navigation.md)

:::slide:::

## Top Section

This is the first section of the anchor target file.

**Internal Navigation:**
- [Jump to Middle](#middle-section)
- [Skip to Bottom](#bottom-section)
- [Go to Specific Target](#specific-anchor-target)

**External Navigation:**
- [Back to Cross-Document](./cross-document.md#cross-document-anchors)
- [Return to Hub](./index.md#test-categories)

**Expected:** Other files should be able to link directly to sections in this file.

:::slide:::

## Middle Section

✅ **You successfully navigated to the middle section!**

This section is commonly targeted by cross-document anchor links.

### Content for Testing
This section contains various content types:

- **Lists** with multiple items
- `Code snippets` for technical content
- *Emphasized text* and **bold text**
- Links to [external sites](https://example.com)

**Navigation Options:**
- [Back to Top](#top-section)
- [Continue to Bottom](#bottom-section)
- [Go to Specific Target](#specific-anchor-target)
- [Return to Cross-Document](./cross-document.md)

:::slide:::

## Specific Anchor Target

🎯 **This is a specific anchor target section**

This section has a unique name that makes it easy to target from other files.

### Use Cases
This section tests:
1. **Unique targeting** - Has a distinctive name
2. **Cross-file anchoring** - Linked from multiple files
3. **Deep linking** - Direct navigation to specific content

### Links Back
- [Cross-Document Navigation](./cross-document.md#cross-document-anchors)
- [Deep Navigation Chain](./deep-navigation.md#navigation-chain-step-2)
- [Hub Overview](./index.md#quick-test-scenarios)

:::slide:::

## Section with Complex Name & Symbols!

This section tests anchor generation for complex heading names.

**Original Heading:** `## Section with Complex Name & Symbols!`
**Expected Slug:** `section-with-complex-name-symbols`

### Special Characters
- Ampersand (&) → stripped
- Exclamation (!) → stripped  
- Spaces → converted to hyphens
- Mixed case → converted to lowercase

**Cross-Document Links to This Section:**
Other files should be able to link here using: `#section-with-complex-name-symbols`

:::slide:::

## 🚀 Section with Emoji

Testing anchor generation with emoji characters.

**Original:** `## 🚀 Section with Emoji`
**Expected Slug:** `section-with-emoji`

### Emoji Handling
The system should:
- Strip emoji from slugs
- Keep the text portion
- Generate clean, linkable anchors

**Test Links:**
- [Internal Jump](#bottom-section)
- [External Reference](./cross-document.md#cross-document-anchors)

:::slide:::

## Nested Content Testing

This section tests deeply nested content structures.

### Level 3 Heading
This is a level 3 heading for nested navigation testing.

#### Level 4 Heading  
Even deeper nesting for comprehensive testing.

##### Level 5 Heading
Maximum depth testing.

**Navigation Notes:**
- All heading levels should be navigable
- Slug generation should work at all levels
- Cross-document links should target any level

### Back to Structure
- [Top Level](#top-section)
- [Middle Level](#middle-section)
- [Bottom Level](#bottom-section)

:::slide:::

## Multi-Word Section for Testing

This section has a multi-word name to test slug generation.

**Slug Test:** `multi-word-section-for-testing`

### Content Types
- **Text content** for reading
- **Code blocks** for technical examples
- **Lists** for organization
- **Links** for navigation

```javascript
// Example code block
function testAnchorNavigation() {
  console.log("Testing anchor links");
}
```

**Cross-References:**
- [Referenced from Cross-Document](./cross-document.md)
- [Referenced from Deep Navigation](./deep-navigation.md)

:::slide:::

## Bottom Section

🔚 **You've reached the bottom section!**

This is the final section commonly used for testing navigation.

### Summary
If you reached this section via anchor links from other files, then cross-document anchor navigation is working correctly!

### What This File Tested:
- ✅ Direct section targeting
- ✅ Complex heading names
- ✅ Emoji in headings
- ✅ Multi-level nesting
- ✅ Special characters
- ✅ Multi-word headings

### Navigation Options:
- [Back to Top](#top-section)
- [Return to Cross-Document](./cross-document.md)
- [Go to Hub](./index.md)
- [Try Deep Navigation](./deep-navigation.md)

### Cross-File References
This section is referenced by:
- `./cross-document.md#cross-document-anchors`
- `./deep-navigation.md#final-destination`
- `./index.md#scenario-2-cross-document-journey`

**Anchor Navigation Test: COMPLETE! 🎯** 