# Nested File Test 📁

This file tests navigation from subdirectories and relative path resolution.

**Current Location:** `link-testing/subfolder/nested-file.md`

**Navigation:**
- [Back to Hub](../index.md)
- [Parent Directory](../)
- [Deep Nested File](./deeper/deep-nested.md)



## Nested Content

✅ **You successfully navigated to a nested file!**

This file is located in a subfolder to test:
- Relative path navigation
- Parent directory references  
- Cross-directory linking
- Path resolution from nested locations

### Current Directory Structure
```
link-testing/
├── index.md                    ← Parent directory
├── cross-document.md          ← Sibling files
├── internal-links.md          
└── subfolder/                 ← Current directory
    ├── nested-file.md         ← This file
    └── deeper/
        └── deep-nested.md
```



## Parent Directory Navigation

Testing navigation back to parent directories.

### Up One Level
- [Parent Directory Index](../index.md) - Back to main hub
- [Sibling File](../cross-document.md) - File in parent directory
- [Another Sibling](../internal-links.md) - Another parent file

### Up with Anchors
- [Hub Test Categories](../index.md#test-categories) - Parent + anchor
- [Cross-Doc Anchors](../cross-document.md#cross-document-anchors) - Parent + anchor
- [Internal Advanced](../internal-links.md#advanced-internal-navigation) - Parent + deep anchor

**Expected:** All links should navigate correctly to parent directory files.



## Same Directory Navigation

Testing navigation within the current subfolder.

### Current Directory Links
- [Deep Nested File](./deeper/deep-nested.md) - Further down
- [Deep with Anchor](./deeper/deep-nested.md#final-destination) - Down + anchor

### Alternative Path Styles
- [Without ./](deeper/deep-nested.md) - Relative without prefix
- [With ./](./deeper/deep-nested.md) - Explicit relative

**Expected:** Both path styles should work identically.



## Cross-Directory Chains

Testing navigation chains that cross multiple directory levels.

### Multi-Level Chain
1. **Start:** Current file (subfolder level)
2. **Up:** [Parent Hub](../index.md#scenario-2-cross-document-journey)
3. **Across:** [Sibling File](../cross-document.md#directory-navigation)  
4. **Down:** [Deep Nested](./deeper/deep-nested.md#final-destination)
5. **Back:** [Return Here](#cross-directory-chains)

### Complex Path Resolution
- [Grandparent](../../README.md) - Two levels up
- [Workspace Root](../../) - Directory reference
- [Adjacent Workspace](../../vscode-extension-react/) - Sibling workspace

⚠️ **Note:** Links outside the immediate workspace may have restrictions.



## File Type Testing

Testing different file types from a nested location.

### Markdown Files
- [Parent Markdown](../external-links.md) - Standard .md file
- [Deep Markdown](./deeper/deep-nested.md) - Nested .md file

### Non-Markdown Files
- [Text File](../assets/sample.txt) - Plain text
- [Config File](../assets/config.json) - JSON file
- [Image File](../assets/test-image.png) - Image file

### Expected Behaviors
- **Markdown files:** Open in slide presentation
- **Other files:** Open in appropriate VS Code editor
- **Missing files:** Show error message



## Path Edge Cases

Testing edge cases in path resolution from nested directories.

### Redundant Paths
- [Normal Path](../index.md) - Standard parent reference
- [Redundant Path](../././index.md) - Extra path segments
- [Complex Path](./deeper/../deeper/deep-nested.md) - Up and down

### Special Characters
- [Spaces](../file with spaces.md) - File with spaces (if exists)
- [Unicode](../файл.md) - Non-ASCII characters (if exists)

### Error Cases  
- [Missing Parent](../missing-file.md) - Non-existent parent file
- [Missing Nested](./missing-nested.md) - Non-existent nested file
- [Invalid Path](./invalid/../../../outside.md) - Path outside workspace



## Link Resolution Testing

Testing how links are resolved from this nested location.

### Absolute vs Relative
From this location (`subfolder/nested-file.md`):

- **Relative to current:** `./deeper/deep-nested.md`
- **Relative to parent:** `../index.md`  
- **Workspace relative:** May depend on implementation

### Link Context
This file provides context for testing:
- **Base path resolution**
- **Relative path calculation**
- **Anchor resolution across directories**
- **File existence checking**

### Cross-Reference Testing
Other files that link to this file:
- `../index.md` → Links here for subfolder testing
- `../cross-document.md` → References this file
- `../deep-navigation.md` → Part of navigation chains



## Test Results from Nested Location

Track navigation results from this nested file:

### Parent Directory Navigation
- [ ] Back to hub ✅/❌
- [ ] Parent file links ✅/❌
- [ ] Parent + anchor links ✅/❌

### Same Directory Navigation  
- [ ] Deeper nested files ✅/❌
- [ ] Different path styles ✅/❌

### Cross-Directory Chains
- [ ] Multi-level navigation ✅/❌
- [ ] Complex path resolution ✅/❌

### File Types
- [ ] Markdown files ✅/❌
- [ ] Non-markdown files ✅/❌
- [ ] Error handling ✅/❌

### Overall Assessment
- [ ] All relative paths work ✅/❌
- [ ] Path resolution is consistent ✅/❌
- [ ] No broken links ✅/❌

**Navigation Options:**
- [Continue to Deep Nested](./deeper/deep-nested.md)
- [Back to Hub](../index.md)
- [Test Cross-Document](../cross-document.md)

**Nested File Test: COMPLETE! 📁** 