package com.ui.myswing;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class MFont {
	public static Font titleFont = new Font("微软雅黑", Font.PLAIN, 24);
	public static Font btnFont = new Font("微软雅黑", Font.PLAIN, 12);
	public static Font lbFont = new Font("微软雅黑", Font.PLAIN, 14);
	public static Font textFieldFont = new Font("宋体", Font.PLAIN, 13);
	public static Font textAreaFont = new Font("微软雅黑", Font.PLAIN, 14);
	public static String[] DEFAULT_FONT = new String[] { "Table.font",
			"TableHeader.font", "CheckBox.font", "Tree.font", "Viewport.font",
			"ProgressBar.font", "RadioButtonMenuItem.font", "ToolBar.font",
			"ColorChooser.font", "ToggleButton.font", "Panel.font",
			"TextArea.font", "Menu.font", "TableHeader.font", "TextField.font",
			"OptionPane.font", "MenuBar.font", "Button.font", "Label.font",
			"PasswordField.font", "ScrollPane.font", "MenuItem.font",
			"ToolTip.font", "List.font", "EditorPane.font", "Table.font",
			"TabbedPane.font", "RadioButton.font", "CheckBoxMenuItem.font",
			"TextPane.font", "PopupMenu.font", "TitledBorder.font",
			"ComboBox.font" };

	public static void main(String[] args) {
		GraphicsEnvironment e = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		String[] fontnames = e.getAvailableFontFamilyNames();

		for (int i = 0; i < fontnames.length; i++) {
			System.out.println(fontnames[i]);
		}
	}
}
