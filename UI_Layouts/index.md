This article will cover the different User Interface(UI) layouts used in android application developments.

### Introduction
The basic building block in the User Interface(UI) of an application is called a **View**. A view occupies the rectangular area of a mobile screen. A view contains a layout and a view group such as a `Button`, `ImageView`, `TextView`, and others. 
These layouts design and guide the positioning of various view groups in an application. Every Mobile Application developer needs to learn and understand how to implement most, if not all, layouts.
Currently, Google's [Constraint](https://developer.android.com/reference/androidx/constraintlayout/widget/ConstraintLayout) layout is the default layout used due to its flexibility and simplicity.

### Anatomy of Android Layouts.
- Root Element: This refers to layouts that encapsulate all the XML elements. Examples are Constraint, Linear, Relative, and Frame Layouts.
***Note:One can only use one root element for the UI of an application.**
- View: This refers to an object in Android's built-in View class, represented by the rectangular area of the screen, e.g., TextView, ImageView, Button, and others.
- View Group: This refers to an 'invisible container' that holds multiple views or view groups together, e.g., Linear Layout, Grid Layout, Table Layout, and others.

![Anatomy of Android Layouts](/engineering-education/getting-started-with-android-ui-layouts/anatomy.jpg)

### Root element layouts used in android applications.
### A) Linear Layout
This layout aligns its content in a single direction. It can be either vertical or horizontal. The layout uses the `<LinearLayout>` tag.
One can use it either as a root element or a view group.

![Linear Layout](/engineering-education/getting-started-with-android-ui-layouts/relative.jpg)

### Linear Layout Attributes.
The following attributes are specific to Linear Layout:
1.`android:id` - This is a unique ID signed to a specific layout.
2.`android:baselineAligned` – This is a boolean value ( "true" or "false" ) that prevents the layout from aligning its children's baselines.
3.`android:gravity` – This specifies an object's position on both the vertical and horizontal axes.
4.`andoid:orientation` – This specifies the vertical or horizontal arrangement of objects. 
5.`android:weightSum`- Sum up of child weight.
6.`android:baselineAlignedChildIndex`- It specifies which of its children to baseline align.
7.`android:divider` - This refers to a drawable used as a vertical divider between buttons.

### Pros and Cons of Linear Layout.
### Pros
- The linear layout is relatively easy to use. 
- It has a weight property that ensures logical spacing.
- Predefined width and height either match parent (Covers the entire screen space) or wrap content (covers the content added to the screen).
### Cons
- Has basic functionality hence making it difficult to use when creating a complex UI.
- If the UI is too complex during nesting, the system run time is not completed within the allowed 16ms, which affects the UX(User Experience) of an application and its quality. 

### B)Relative Layout.
This layout aligns content according to child views positioned relative to each other. The layout uses the `<RelativeLayout>` tag.
The position of each view can be relative to sibling elements or relative to the parent. By default, all child views are aligned at the top corner before setting the screen's desired alignment, for example, center-left and others. One can use it either as a root element or a view group.

![Relative Layout](/engineering-education/getting-started-with-android-ui-layouts/relative.jpg)

### Relative Layout Attributes.
The following attributes are specific to Relative Layout:
1.`android:id` - This is a unique ID signed to a specific layout.
2.`android:gravity` – This specifies an object's position on both the vertical and horizontal axes.
3.`android:ignoreGravity` – This ensures that a specific view is not affected by gravity.
4.`android:layout_above` – Positions a child view above a given ID view.
5.`android:layout_alignBottom`, `android:layout_alignLeft`, `android:layout_alignRight`, `android:layout_alignStart`, - Positions a child view at the top,bottom,right or left of a given ID view.
7.`android:layout_alignParentBottom`, `android:layout_alignParentEnd`, `android:layout_alignParentLeft`, `android:layout_alignParentRight`, `android:layout_alignParentStart`, `android:layout_alignParentTop` - Positions a child view at the top,bottom,right or left of a of the parent. They normally use a boolean value I.e “ true” or “false”
8.`android:layout_centerHorizontal`, `android:layout_centerInParent`, `android:layout_centerVertical` – This is used to center a child either horizontally, vertically or inside a parent.
### Pros and Cons of Relative Layout.
### Pros.
- Relative layout is much flexible compared to the linear layout.
- Predefined width and height either match parent (Covers the entire screen space) or wrap content (covers the content added to the screen).
-Suitable for UI that requires views to be arranged relative to each other.
-Nested view groups have a performance impact.
### Cons
-It is time-consuming when items have to be re-arranged.
-It is quite challenging to master.

### C)Constraint Layout.
The Constraint layout is the default layout used in Android. that allows flexible positioning and sizing of child views. The layout uses the `<ConstraintLayout>` tag .In this layout, constraints are set on child views to avoid changing their position once the app is run on a device or emulator. One can use it either as a root element or a view group.
Constraint layout is supported in the Android 2.2 version and above.
For any version below this, add the following dependency to the app-level module `build.gradle` file in order to use the constraint layout:

```gradle
    implementation "androidx.constraintlayout:constraintlayout:2.0.4"
```
**Note: An error will always be displayed if the views are not constrained.**
### Constraint Layout Attributes.
1.`android:id` - This is a unique ID signed to a specific layout.
2.`layout_constraintTop_toTopOf` , `layout_constraintTop_toBottomOf`,`layout_constraintBottom_toTopOf`,`layout_constraintBottom_toBottomOf` - Allign the bottom or top of a desired view to the top or bottom of another view.
3.`layout_constraintLeft_toTopOf` ,`layout_constraintLeft_toBottomOf` ,`layout_constraintLeft_toLeftOf` ,`layout_constraintLeft_toRightOf`,`layout_constraintRight_toTopOf` ,`layout_constraintRight_toBottomOf` ,`layout_constraintRight_toLeftOf`,`layout_constraintRight_toRightOf`  - Align the right or left of a desired view to the right or left of another view.
4.`layout_constraintVertical_bias`, `layout_constraintHorizontal_bias` - Used to position a view either vertically or horizontally at a particular point.

### Pros and Cons.
### Pros.
- It is easy to use because of its drag and drop feature.
- It is very flexible.
- It can supplant various layouts that are Relative, Frame, and  Linear.
- It is straightforward to create a flat view hierarchy.
- Constraint layout has an improved performance over other layouts.
- Can support animations with a few lines of code.

### Cons
- It is quite hard to master, especially for a beginner developer.
- It can be complex to use when the UI is very basic.


### D) Frame Layout.
The Frame layout is one of the most basic and most straightforward layouts. This layout blocks out an area on the screen to display a single view group. The layout uses the `<FrameLayout>` tag. It is suitable to use this layout when the UI of an application only requires one view. One can use it either as a root element or a view group.

### Frame Layout Attributes.
1.`android:id` - This is a unique ID signed to a specific layout.
2.`android:foreground` - Refers to the drawable to be displayed over the content. 
3.`android:foregroundGravity` - Defines the gravity direction applied to the foreground drawable.
Examples of the values are center_vertical, center_horizontal, top, bottom, left, right, and many others.

### Pros and Cons
### Pros
- It is very to use and understand.
- It is suitable for a  basic UI.

### Cons.
- It is challenging to use it for a complex UI.

### View group layouts used in Android.
The following are layouts popularly used as view groups.
### A)Scroll View.
The ScrollView is a view group that allows scrollable content. Scrolling in the ScrollView is either vertically or horizontally. The layout uses the `<ScrollView>` tag. A ScrollView can only support one direct child; otherwise, one must add view groups, e.g., Linear Layout, if they want the scroll view to be more detailed.  One can use it as a view group only. 

### B)Nested ScrollView.
The Nested ScrollView is just a ScrollView that can act as both a nested scrolling parent and a child. It is supported by both old and new versions of Android.  One can use it as a view group only. 

### D) Recycler view.
The RecyclerView is the improved version of a `ListView` with better performance and improved features. One can use it as both a view group and a root element. It is most suitable to use it under a root element.

### E) Grid View.
The Grid layout displays items in a two-dimensional, scrollable grid. The Grid View is a subclass of the `AdapterView` class. This layout is slowly becoming outdated as developers have found other ways to have a more responsive grid layout. One can use it as both a view group and a root element. It is most suitable to use it under a root element.

### F) Table Layout.
The Table layout groups view into rows and columns depending on the size required. This layout is rarely used in Android compared to its use in web applications.  It can be used as both a root element and a view group, but it is advisable to use it under a root element. One can use it as both a view group and a root element. It is most suitable to use it under a root element.

### To wrap up
Android application use layouts as the basic UI building block. We have learned about both root element and view group layouts and their uses. Feel free to research we have not discussed above and pratice most if not all of the layouts we have discussed above. Feel free to reach out incase of any query or clarification. Till next time!