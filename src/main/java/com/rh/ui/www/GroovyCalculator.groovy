package com.rh.ui.www

import groovy.swing.SwingBuilder

import javax.swing.JFrame
import javax.swing.JTextField
import javax.swing.UIManager
import javax.swing.WindowConstants
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Toolkit

class GroovyCalculator {
    def swing = new SwingBuilder()
    JFrame frame
    def toolkit = Toolkit.getDefaultToolkit()
    def screenSize = toolkit.getScreenSize()


    def WIDTH = 320
    def HEIGHT = 200
    int X = (screenSize.width - WIDTH) / 2
    int Y = (screenSize.height - HEIGHT) / 2

    boolean flag = false

    private void run() {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())

        frame = buildByMe()
//        frame = buildSource(panel)

        swing.expr.setEditable(false)
        swing.expr.setHorizontalAlignment(JTextField.RIGHT)
        swing.expr.setBackground(Color.WHITE)

        frame.pack()
        frame.setResizable(false)
        frame.setVisible(true)
    }

    private JFrame buildByMe() {

        def optionLayout = {
            swing.tableLayout() {
                tr {
                    td {
                        button(text: " 7 ") {
                            action(getAction(" 7 "))
                        }
                    }
                    td {
                        button(text: " 8 ") {
                            action(getAction(" 8 "))
                        }
                    }
                    td {
                        button(text: " 9 ") {
                            action(getAction(" 9 "))
                        }
                    }
                    td {
                        button(text: " / ") {
                            action(getAction(" / "))
                        }
                    }
                }
                tr {
                    td {
                        button(text: " 4 ") {
                            action(getAction(" 4 "))
                        }
                    }
                    td {
                        button(text: " 5 ") {
                            action(getAction(" 5 "))
                        }
                    }
                    td {
                        button(text: " 6 ") {
                            action(getAction(" 6 "))
                        }
                    }
                    td {
                        button(text: " * ") {
                            action(getAction(" * "))
                        }
                    }
                }
                tr {
                    td {
                        button(text: " 1 ") {
                            action(getAction(" 1 "))
                        }
                    }
                    td {
                        button(text: " 2 ") {
                            action(getAction(" 2 "))
                        }
                    }
                    td {
                        button(text: " 3 ") {
                            action(getAction(" 3 "))
                        }
                    }
                    td {
                        button(text: " - ") {
                            action(getAction(" - "))
                        }
                    }
                }
                tr {
                    td {
                        button(text: " 0 ") {
                            action(getAction(" 0 "))
                        }
                    }
                    td {
                        button(text: " = ") {
                            action(name: " = ", closure: this.&eval)
                        }
                    }
                    td {
                        button(text: " C ") {
                            action(name: " C ", closure: this.&clear)
                        }
                    }
                    td {
                        button(text: " + ") {
                            action(getAction(" + "))
                        }
                    }
                }
            }
        }

        def optionPanel = {
            swing.panel() {
                optionLayout()
            }
        }

        def text = {
            swing.textField(id: 'expr',
                    constraints: BorderLayout.NORTH,
            )
        }

        def layout = {
            swing.borderLayout(north: text(),
                    center: optionPanel()
            )
        }

        def panel = {
            swing.panel() {
                layout()
            }
        }

        def frame = swing.frame(title: 'Demo',
                size: [WIDTH, HEIGHT],
                location: [X, Y],
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE
        ){
            panel()
        }

        frame.visible = true;

        frame
    }

    private JFrame buildBySource(panel) {
        frame = swing.frame(title: ' Demo ',
                size: [WIDTH, HEIGHT],
                location: [X, Y],
                defaultCloseOperation: WindowConstants.EXIT_ON_CLOSE) {


            panel(layout: new BorderLayout()) {
                textField(id: "expr", constraints: BorderLayout.NORTH)

                panel(constraints: BorderLayout.CENTER) {
                    tableLayout {
                        tr {
                            td {
                                button(text: " 7 ") {
                                    action(getAction(" 7 "))
                                }
                            }
                            td {
                                button(text: " 8 ") {
                                    action(getAction(" 8 "))
                                }
                            }
                            td {
                                button(text: " 9 ") {
                                    action(getAction(" 9 "))
                                }
                            }
                            td {
                                button(text: " / ") {
                                    action(getAction(" / "))
                                }
                            }
                        }
                        tr {
                            td {
                                button(text: " 4 ") {
                                    action(getAction(" 4 "))
                                }
                            }
                            td {
                                button(text: " 5 ") {
                                    action(getAction(" 5 "))
                                }
                            }
                            td {
                                button(text: " 6 ") {
                                    action(getAction(" 6 "))
                                }
                            }
                            td {
                                button(text: " * ") {
                                    action(getAction(" * "))
                                }
                            }
                        }
                        tr {
                            td {
                                button(text: " 1 ") {
                                    action(getAction(" 1 "))
                                }
                            }
                            td {
                                button(text: " 2 ") {
                                    action(getAction(" 2 "))
                                }
                            }
                            td {
                                button(text: " 3 ") {
                                    action(getAction(" 3 "))
                                }
                            }
                            td {
                                button(text: " - ") {
                                    action(getAction(" - "))
                                }
                            }
                        }
                        tr {
                            td {
                                button(text: " 0 ") {
                                    action(getAction(" 0 "))
                                }
                            }
                            td {
                                button(text: " = ") {
                                    action(name: " = ", closure: this.&eval)
                                }
                            }
                            td {
                                button(text: " C ") {
                                    action(name: " C ", closure: this.&clear)
                                }
                            }
                            td {
                                button(text: " + ") {
                                    action(getAction(" + "))
                                }
                            }
                        }
                    }
                }
            }
        }
        frame
    }

    private void append(EventObject evt = null) {
        if (flag) {
            swing.expr.text = ""
            flag = false
        }

        String name = evt.source.text
        swing.expr.text <<= name
        swing.expr.text = swing.expr.text.replaceAll(" // ", " / ")
    }

    private void clear(EventObject evt = null) {
        swing.expr.text = ""
    }

    private void eval(EventObject evt = null) {
        String expr = swing.expr.text

        def b = new Binding()
        def conf = new org.codehaus.groovy.control.CompilerConfiguration()
        conf.setSourceEncoding('unicode')
        def groovyShell = new GroovyShell(b, conf)

        try {
            swing.expr.text = groovyShell.evaluate(expr)
        } catch (Throwable t) {
            swing.expr.text = " invalid expression! "
            flag = true
        }

    }

    def getAction(name) {
        return swing.action(name: name, closure: this.& append)
    }

    static void main(args) {
        new GroovyCalculator().run()
    }
}
