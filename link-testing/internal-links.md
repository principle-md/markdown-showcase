# Internal Section Links Test 📍

This file tests navigation between slides within the same presentation using internal section links.

**Quick Navigation:**
- [Jump to Middle](#middle-section)
- [Skip to End](#final-section)
- [Back to Hub](./index.md)



## Getting Started

Internal section links use the `#` symbol followed by a heading slug. The system automatically:

1. **Converts headings** to lowercase slugs
2. **Maps slugs** to slide indices  
3. **Navigates instantly** when clicked

### Test These Links:
- [Go to Second Section](#second-section) ⬇️
- [Jump Ahead to Examples](#example-scenarios) ⬇️⬇️
- [Skip to Advanced](#advanced-internal-navigation) ⬇️⬇️⬇️

**Expected Behavior:** Each link should instantly navigate to the target slide.



## Second Section

✅ **You successfully navigated here!**

This is the second section of the internal links test. Notice how the navigation was instant and smooth.

### More Navigation Options:
- [Back to Start](#getting-started) ⬆️
- [Continue to Examples](#example-scenarios) ⬇️
- [Jump to Final Section](#final-section) ⬇️⬇️⬇️

### Testing Edge Cases:
- [Link with Special Characters](#section-with-special-characters) 
- [Link to Numbered Section](#3-numbered-section)
- [Link with Emoji](#section-with-emoji-🚀)



## Example Scenarios

Here are various internal link patterns you can test:

### Basic Patterns
```markdown
[Link Text](#target-heading)
[Go to Section](#section-name)
[Jump Here](#another-place)
```

### Real Examples to Test:
1. [Navigate to Middle Section](#middle-section) - Should work
2. [Go to Non-Existent](#non-existent-section) - Should show warning
3. [Return to Getting Started](#getting-started) - Should work
4. [Back to Hub Overview](./index.md#file-structure-overview) - Cross-document anchor

**Expected Results:**
- ✅ Valid links navigate to correct slides
- ⚠️ Invalid links show console warnings
- 🔄 Cross-document links open other files



## Advanced Internal Navigation

Testing more complex internal navigation scenarios:

### Multi-Level Headings
- [Go to Subsection](#subsection-test)
- [Skip to Nested Content](#deeply-nested-heading)

### Heading with Special Characters
This tests the slug generation for complex headings.

**Original:** `## Section with "Quotes" & Symbols!`
**Slug:** `section-with-quotes-symbols`
**Link:** [Test Special Characters](#section-with-special-characters)

### Navigation Chains
Test a chain of internal navigation:
1. [Start Chain](#chain-step-1) → 
2. Then click the link in that section →
3. Follow the complete chain



## 3. Numbered Section

✅ **Numbered sections work too!**

This tests that numbered headings create proper slugs.

**Next Steps:**
- [Continue the Chain](#chain-step-1)
- [Go to Special Characters](#section-with-special-characters)
- [Jump to Final](#final-section)



## Section with "Quotes" & Symbols!

✅ **Special characters are handled correctly!**

The system strips special characters and creates clean slugs.

**Navigation Options:**
- [Back to Advanced](#advanced-internal-navigation)
- [Continue Chain](#chain-step-1)
- [Skip to End](#final-section)



## Chain Step 1

🔗 **First step in the navigation chain**

This tests chained internal navigation.

**Next:** [Continue to Step 2](#chain-step-2)



## Chain Step 2

🔗 **Second step in the navigation chain**

**Previous:** [Back to Step 1](#chain-step-1)
**Next:** [Final Chain Step](#chain-step-3)



## Chain Step 3

🔗 **Final step in the navigation chain**

**Previous:** [Back to Step 2](#chain-step-2)
**Complete:** [Go to Final Section](#final-section)



## Section with Emoji 🚀

✅ **Emoji in headings work too!**

The system handles emoji characters properly in slug generation.

**Almost Done:**
- [Jump to Middle](#middle-section)
- [Final Section](#final-section)
- [Return to Hub](./index.md)



## Subsection Test

Testing subsection navigation and deeply nested headings.

### Nested Heading
This is a nested heading (h3 level).

#### Deeply Nested Heading
This is an h4 level heading.

**Navigation:**
- [Back to Advanced](#advanced-internal-navigation)
- [Go to Final](#final-section)



## Middle Section

✅ **You reached the middle section!**

This section is specifically designed to be a common navigation target.

**Navigation Hub:**
- [Back to Start](#getting-started)
- [To Examples](#example-scenarios) 
- [To Advanced](#advanced-internal-navigation)
- [To Final](#final-section)
- [Return to Hub](./index.md)



## Final Section

🎉 **Congratulations! You've completed the internal links test.**

### Test Summary
If you reached this section by clicking internal links, then internal section navigation is working correctly!

### What You Tested:
- ✅ Basic internal section links
- ✅ Special characters in headings
- ✅ Numbered sections
- ✅ Emoji in headings  
- ✅ Navigation chains
- ✅ Multi-level headings
- ✅ Edge cases and error handling

### Next Steps:
- [Return to Hub](./index.md) - Go back to main testing hub
- [Test External Links](./external-links.md) - Try external URL handling
- [Test Cross-Document](./cross-document.md) - Test file-to-file navigation

**Internal Links Test: COMPLETE! ✅** 