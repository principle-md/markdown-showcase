# Parent Directory Test 📂

This file tests navigation to parent directories and files outside the current test folder.

**Navigation:**
- [Back to Hub](./index.md)
- [Test Workspace Root](../README.md)
- [Adjacent Project](../vscode-extension-react/)



## Parent Directory Navigation

Testing navigation to files and directories above the current location.

### Current Location Context
```
PrincipleMD/                    ← Workspace root (1 level up)
├── README.md                   ← Target file
├── link-testing/               ← Current directory
│   ├── index.md               ← Hub file
│   └── parent-directory-test.md ← This file
└── vscode-extension-react/     ← Adjacent project
    └── README.md              ← Another target
```

### Parent Directory Links
- [Workspace README](../README.md) - Main project README
- [Parent Directory](../) - Directory listing (may not work)
- [Adjacent Project README](../vscode-extension-react/README.md) - Sibling project



## Cross-Workspace Navigation

Testing navigation between different parts of the workspace.

### Main Project Files
- [Main README](../README.md) - Primary project documentation
- [License File](../LICENSE) - Project license (if exists)
- [Package Config](../package.json) - Project configuration (if exists)

### Extension Project
- [Extension README](../vscode-extension-react/README.md) - Extension documentation
- [Extension Package](../vscode-extension-react/package.json) - Extension config
- [Extension Source](../vscode-extension-react/src/) - Source directory (may not work)

### Other Workspace Areas
- [Docs Directory](../docs/) - Documentation folder (if exists)
- [Scripts Directory](../scripts/) - Scripts folder (if exists)

**Expected:** Markdown files should open appropriately; other files in VS Code editor.



## Relative Path Variations

Testing different styles of relative path references.

### Standard Relative Paths
- [Single Dot](../README.md) - Standard parent reference
- [Double Dot](../../) - Grandparent (may be outside workspace)
- [Mixed Path](../link-testing/index.md) - Up then down

### Path Edge Cases
- [Redundant Path](../././README.md) - Extra path segments
- [Complex Path](../link-testing/../README.md) - Roundabout path
- [Self Reference](../link-testing/parent-directory-test.md) - Full path to self

### Path Validation
- [Valid Path](../README.md) - Should work
- [Invalid Path](../nonexistent-file.md) - Should error
- [Outside Workspace](../../outside-file.md) - May be restricted



## File Type Testing

Testing different file types in parent directories.

### Markdown Files
- [Parent Markdown](../README.md) - Should open in slides or editor
- [Deep Parent MD](../docs/some-file.md) - Nested markdown (if exists)

### Configuration Files
- [Package JSON](../package.json) - Project configuration
- [VS Code Settings](../.vscode/settings.json) - Editor settings
- [Git Config](../.gitignore) - Git ignore file

### Other File Types
- [Text Files](../CHANGELOG.txt) - Plain text (if exists)
- [Image Files](../images/logo.png) - Images (if exist)
- [Binary Files](../node_modules/) - Binary/directory

**Expected Behavior:**
- **Markdown:** May open in slides or editor depending on implementation
- **JSON/Text:** Open in appropriate VS Code editor
- **Images:** Open in image viewer
- **Directories:** May show error or open file explorer



## Security and Restrictions

Testing potential security restrictions on parent directory access.

### Workspace Boundaries
- [Within Workspace](../README.md) - Should be allowed
- [Workspace Edge](../link-testing/index.md) - Should work
- [Outside Workspace](../../external-file.md) - May be restricted

### Potentially Restricted Paths
- [System Directory](../../../etc/hosts) - System file (should be blocked)
- [User Directory](../../../Users/) - User directory (may be blocked)
- [Root Directory](../../../) - File system root (likely blocked)

### Path Traversal Attempts
- [Traversal Test](../../../../../../../etc/passwd) - Excessive path traversal
- [Mixed Traversal](../link-testing/../../README.md) - Complex traversal
- [Encoded Path](..%2F..%2Fetc%2Fhosts) - URL encoded traversal

**Expected:** System should prevent access outside allowed areas.



## Cross-Reference Validation

Testing if other files correctly link to this parent directory test.

### Inbound Links
This file should be referenced by:
- `./index.md` - Main hub
- `./cross-document.md` - Cross-document navigation test
- Other test files for parent directory examples

### Link Validation
If you reached this file from other test files:
- ✅ Parent directory linking works
- ✅ Relative path resolution functions
- ✅ File discovery operates correctly

### Return Navigation
- [Back to Hub](./index.md) - Return to main testing hub
- [Cross-Document Test](./cross-document.md) - Continue testing
- [Subfolder Test](./subfolder/nested-file.md) - Test other directions



## Test Results Summary

Track your parent directory navigation results:

### Basic Parent Access
- [ ] Main workspace README ✅/❌
- [ ] Adjacent project files ✅/❌
- [ ] Parent directory listing ✅/❌

### Path Variations
- [ ] Standard relative paths ✅/❌
- [ ] Complex path variations ✅/❌
- [ ] Path edge cases ✅/❌

### File Types
- [ ] Parent markdown files ✅/❌
- [ ] Configuration files ✅/❌
- [ ] Other file types ✅/❌

### Security
- [ ] Workspace boundaries respected ✅/❌
- [ ] Path traversal prevented ✅/❌
- [ ] Appropriate error messages ✅/❌

### Cross-References
- [ ] Inbound links working ✅/❌
- [ ] Return navigation functional ✅/❌

**Overall Parent Directory Navigation:** ✅/❌

### Next Steps
- [Return to Hub](./index.md) - Continue testing other features
- [Test Nested Navigation](./subfolder/nested-file.md) - Opposite direction
- [Cross-Document Links](./cross-document.md) - Test file-to-file navigation

**Parent Directory Test: COMPLETE! 📂** 