# Deep Nested File Test 🏔️

This file is deeply nested to test complex relative path navigation.

**Current Location:** `link-testing/subfolder/deeper/deep-nested.md`

**Navigation:**
- [Back to Hub](../../index.md)
- [Up One Level](../nested-file.md)
- [Up Two Levels](../../cross-document.md)

:::slide:::

## Final Destination

🎯 **You've reached the deepest nested file!**

This file tests the most complex navigation scenarios:
- Multi-level parent directory navigation
- Deep relative path resolution
- Complex anchor linking across directories

### Directory Depth
```
link-testing/                   ← Root (2 levels up)
└── subfolder/                  ← Level 1 (1 level up)
    └── deeper/                 ← Level 2 (current)
        └── deep-nested.md      ← This file
```

**Path Complexity:** `../../` to reach the root testing directory.

:::slide:::

## Multi-Level Navigation

Testing navigation across multiple directory levels.

### Up Two Levels (Root)
- [Hub Index](../../index.md) - Back to main hub
- [Cross-Document](../../cross-document.md) - Root level file
- [Internal Links](../../internal-links.md) - Another root file
- [File with Anchors](../../file-with-anchors.md) - Root + specific file

### Up One Level (Parent)
- [Nested File](../nested-file.md) - Immediate parent directory
- [Nested with Anchor](../nested-file.md#nested-content) - Parent + anchor

### Cross-Directory with Anchors
- [Hub Categories](../../index.md#test-categories) - Root + anchor
- [Cross-Doc Navigation](../../cross-document.md#directory-navigation) - Root + specific section
- [Deep Navigation Final](../../deep-navigation.md#final-destination) - Root + final section

:::slide:::

## Complex Path Resolution

Testing advanced path resolution scenarios.

### Redundant Path Segments
- [Normal](../../index.md) - Standard path
- [Redundant](../../././index.md) - Extra segments
- [Complex](./../../index.md) - Mixed style

### Path Calculation Tests
From `subfolder/deeper/deep-nested.md`:
- **Root:** `../../filename.md`
- **Parent:** `../filename.md`
- **Current:** `./filename.md` (if any existed)

### Edge Case Paths
- [Roundabout](../../subfolder/nested-file.md) - Down then up
- [Complex Route](../../subfolder/deeper/deep-nested.md) - Full circle to self
- [Invalid](../../../outside-workspace.md) - Outside workspace (should error)

:::slide:::

## Cross-Reference Validation

Testing if other files can correctly link to this deep location.

### Inbound Links
This file should be reachable from:
- `../../index.md#scenario-2-cross-document-journey`
- `../../cross-document.md#complex-anchor-navigation`
- `../../deep-navigation.md#nested-navigation-chains`
- `../nested-file.md#same-directory-navigation`

### Link Validation
If you reached this file by following links from other files, then:
- ✅ Deep path resolution works
- ✅ Multi-level navigation functions
- ✅ Complex anchor linking operates correctly

:::slide:::

## File Type Testing from Deep Location

Testing different file types from the deepest nested location.

### Markdown Files at Various Levels
- [Root Level MD](../../external-links.md) - Two levels up
- [Parent Level MD](../nested-file.md) - One level up
- [Current Level MD](./deep-nested.md) - Self reference

### Non-Markdown Files
- [Root Assets](../../assets/sample.txt) - Text file in root assets
- [Root Config](../../assets/config.json) - JSON in root assets

### Expected Behaviors
- **Markdown:** Open in slide presentation
- **Text/Config:** Open in VS Code editor
- **Missing:** Show appropriate error

:::slide:::

## Navigation Chain Completion

Testing complex navigation chains that end at this deep location.

### Chain Validation
If you followed a navigation chain to reach here:

1. **Chain Step 1:** Started from some root file
2. **Chain Step 2:** Navigated through intermediate files
3. **Chain Step 3:** Reached this deep nested location
4. **Chain Complete:** Successfully tested deep navigation!

### Return Journey Options
- [Quick Return to Hub](../../index.md) - Direct back to start
- [Step Back Through Chain](../nested-file.md) - Reverse the journey
- [Alternative Route](../../cross-document.md) - Different path back

### Performance Test
Multiple rapid links from deep location:
- [Link A](../../internal-links.md#getting-started)
- [Link B](../../external-links.md#http-https-urls)  
- [Link C](../../file-with-anchors.md#middle-section)
- [Back Here](#navigation-chain-completion)

:::slide:::

## Error Handling from Deep Location

Testing error scenarios from the deepest nested location.

### Missing Files at Different Levels
- [Missing Root](../../missing-root-file.md) - Non-existent root file
- [Missing Parent](../missing-parent-file.md) - Non-existent parent file
- [Missing Current](./missing-current-file.md) - Non-existent current file

### Invalid Path Structures
- [Too Many Levels](../../../../outside.md) - Path outside workspace
- [Malformed Path](../../subfolder/deeper/../../index.md) - Unnecessarily complex
- [Empty Reference]() - Empty link

### Broken Anchors
- [Valid File, Bad Anchor](../../index.md#nonexistent-section) - File exists, section doesn't
- [Bad File, Bad Anchor](../../missing.md#also-missing) - Both missing

**Expected:** System should handle all errors gracefully.

:::slide:::

## Deep Navigation Test Results

Final results tracking from the deepest nested location:

### Multi-Level Navigation
- [ ] Two levels up (root) ✅/❌
- [ ] One level up (parent) ✅/❌
- [ ] Cross-directory with anchors ✅/❌

### Path Resolution
- [ ] Standard relative paths ✅/❌
- [ ] Redundant path segments ✅/❌
- [ ] Complex path calculations ✅/❌

### Cross-References
- [ ] Inbound links from other files ✅/❌
- [ ] Navigation chain completion ✅/❌
- [ ] Multi-hop navigation ✅/❌

### File Types and Error Handling
- [ ] Various file types ✅/❌
- [ ] Missing file handling ✅/❌
- [ ] Invalid path handling ✅/❌

### Performance
- [ ] Rapid navigation from deep location ✅/❌
- [ ] Complex path resolution speed ✅/❌
- [ ] Error recovery ✅/❌

**Overall Deep Navigation Assessment:** ✅/❌

### Completion
🏆 **Deep Navigation Test Complete!**

You've successfully tested the most complex navigation scenarios. If all links worked correctly, then the system handles:
- ✅ Multi-level directory traversal
- ✅ Complex relative path resolution  
- ✅ Deep anchor linking
- ✅ Error handling at all levels

**Final Navigation Options:**
- [Return to Hub](../../index.md) - Complete the test cycle
- [View Test Summary](../../index.md#test-results-log) - Check overall results
- [Start New Test](../../cross-document.md) - Try different functionality

**Deep Nested File Test: COMPLETE! 🏔️** 