# Cross-Document Navigation Test 📄

This file tests navigation between different markdown files in the same workspace.

**Quick Navigation:**
- [Back to Hub](./index.md)
- [Target File with Anchors](./file-with-anchors.md)
- [Subfolder Navigation](./subfolder/nested-file.md)

:::slide:::

## Same Directory Links

Testing links to files in the same directory as this file.

### Basic File Links
- [Internal Links Test](./internal-links.md) - Relative path with `./`
- [External Links Test](./external-links.md) - Another test file
- [File with Anchors](./file-with-anchors.md) - Target for anchor testing
- [Deep Navigation](./deep-navigation.md) - Navigation chains

### Without `./` Prefix
- [Internal Links Test](internal-links.md) - Same file, no `./` prefix
- [External Links Test](external-links.md) - Should work the same way

**Expected Behavior:** Should open the target file in a new slide presentation.

:::slide:::

## Cross-Document Anchors

Testing links that navigate to specific sections in other files.

### Anchor Links to Other Files
- [Jump to Middle Section](./file-with-anchors.md#middle-section) - Specific section
- [Go to Getting Started](./internal-links.md#getting-started) - First section
- [Hub File Structure](./index.md#file-structure-overview) - Table of contents
- [Advanced Navigation](./internal-links.md#advanced-internal-navigation) - Deep section

### Complex Anchor Navigation
- [Nested File Section](./subfolder/nested-file.md#nested-content) - Subfolder + anchor
- [Deep Nested](./subfolder/deeper/deep-nested.md#final-destination) - Deep path + anchor

**Expected Behavior:** Should open the target file AND navigate to the specific section.

:::slide:::

## Directory Navigation

Testing navigation to different directory levels.

### Subdirectory Navigation
- [Nested File](./subfolder/nested-file.md) - One level down
- [Deep Nested File](./subfolder/deeper/deep-nested.md) - Two levels down

### Parent Directory Navigation  
- [Main README](../README.md) - Parent directory file
- [VS Code Extension](../vscode-extension-react/README.md) - Adjacent workspace folder

### Relative Path Variations
- [Same as ./subfolder/nested-file.md](subfolder/nested-file.md) - No leading `./`
- [Explicit ./subfolder/nested-file.md](./subfolder/nested-file.md) - With leading `./`

**Expected Behavior:** Should navigate correctly regardless of path style.

:::slide:::

## File Extension Variations

Testing different file extensions and how they're handled.

### Markdown Files
- [Standard .md file](./file-with-anchors.md) - Standard markdown
- [Long extension](./complex-internal.md) - Different naming

### Non-Markdown Files
- [Text File](./assets/sample.txt) - Plain text file
- [JSON File](./assets/config.json) - JSON configuration

### Missing Extensions
- [File without extension](./assets/no-extension) - No file extension
- [Hidden File](./assets/.hidden-file) - Hidden file

**Expected Behavior:** 
- Markdown files should open in slide view
- Other files should open in appropriate VS Code editor

:::slide:::

## Navigation Chains

Testing complex navigation patterns that link multiple files together.

### Chain Navigation Test
1. **Start here:** [Begin Navigation Chain](./deep-navigation.md#start-chain)
2. **Follow the links** in that file to other files
3. **Complete the journey** back to this file

### Multi-Hop Navigation
- [First Hop](./deep-navigation.md) → Links to other files
- [Second Hop](./file-with-anchors.md) → Links back to this file
- [Final Hop](./subfolder/nested-file.md) → Completes the circle

### Circular References
- [File A](./file-with-anchors.md) ↔️ Links to this file
- [File B](./deep-navigation.md) ↔️ Links back here
- This file ↔️ Links to both

**Test the complete navigation flow!**

:::slide:::

## Error Scenarios

Testing how the system handles problematic cross-document links.

### Non-Existent Files
- [Missing File](./this-file-does-not-exist.md) - Should show error
- [Wrong Extension](./internal-links.txt) - Wrong file extension
- [Typo in Name](./internl-links.md) - Typo in filename

### Invalid Paths
- [Invalid Path](./nonexistent-folder/file.md) - Non-existent directory
- [Too Many Levels](../../../some-file.md) - Path outside workspace
- [Empty Path](./) - Directory instead of file

### Broken Anchors
- [Valid File, Invalid Anchor](./internal-links.md#non-existent-section) - File exists, section doesn't
- [Invalid File, Invalid Anchor](./missing.md#also-missing) - Both invalid

**Expected Behavior:** Should show appropriate error messages or fallback behavior.

:::slide:::

## Path Resolution Testing

Testing how different path formats are resolved.

### Absolute vs Relative
- [Relative Path](./internal-links.md) - Standard relative
- [No Leading Dot](internal-links.md) - Also relative
- [Explicit Current Dir](./././internal-links.md) - Redundant but valid

### Case Sensitivity
- [Lowercase](./internal-links.md) - Standard case
- [Mixed Case](./Internal-Links.md) - Different case (may fail on case-sensitive systems)

### Special Characters in Paths
- [Spaces in Path](./file with spaces.md) - File with spaces (if it exists)
- [Unicode Characters](./файл.md) - Non-ASCII characters

**Path resolution should be consistent and predictable.**

:::slide:::

## Performance Testing

Testing navigation with various file sizes and complexities.

### Large Files
- [Complex Internal](./complex-internal.md) - Large file with many sections
- [Deep Navigation](./deep-navigation.md) - File with many cross-references

### Multiple Rapid Clicks
**Rapid Navigation Test:**
1. [Click me](./internal-links.md) →
2. [Then click this](./external-links.md) →  
3. [Finally this](./file-with-anchors.md) →
4. [Back here](./cross-document.md)

**Try clicking these links rapidly to test system performance.**

:::slide:::

## Test Results Summary

Track your cross-document navigation testing results:

### Same Directory Navigation
- [ ] Basic file links ✅/❌
- [ ] Links without `./` prefix ✅/❌
- [ ] Cross-document anchors ✅/❌

### Directory Navigation
- [ ] Subdirectory links ✅/❌
- [ ] Parent directory links ✅/❌
- [ ] Deep nested paths ✅/❌

### File Types
- [ ] Markdown files ✅/❌
- [ ] Non-markdown files ✅/❌
- [ ] Missing files ✅/❌

### Advanced Features
- [ ] Navigation chains ✅/❌
- [ ] Circular references ✅/❌
- [ ] Error handling ✅/❌
- [ ] Path resolution ✅/❌

### Performance
- [ ] Large files ✅/❌
- [ ] Rapid navigation ✅/❌
- [ ] Multiple concurrent links ✅/❌

**Overall Cross-Document Navigation:** ✅/❌

**Next Steps:**
- [Return to Hub](./index.md)
- [Test File with Anchors](./file-with-anchors.md)
- [Try Deep Navigation](./deep-navigation.md)

**Cross-Document Test: COMPLETE! 📄** 