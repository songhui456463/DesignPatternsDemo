package com.sh.designprinciples.lawofDemeter;

/**
 * 可以看出Button依赖于很多类，而这些类中又存在互相依赖
 * 由于界面控件之间的交互关系复杂，
 * 导致在该窗口中增加新的界面控件时需要修改与之交互的其他控件的源代码，
 * 系统扩展性较差，也不便于增加和删除新控件。
 * @author: songhui
 * @create: 2021-08-18 12:57
 */
public class Button {

    private List list;
    private Label label;
    private TextBox textBox;
    private ComboBox comboBox;
}

class List{
    private TextBox textBox;
}

class Label{

}

class TextBox{
    private List list;
    private ComboBox comboBox;
}

class ComboBox{
    private TextBox textBox;
}
