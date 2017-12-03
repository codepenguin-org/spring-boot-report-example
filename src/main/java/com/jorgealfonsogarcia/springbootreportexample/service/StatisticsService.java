/*
 * MIT License
 * 
 * Copyright (c) 2017 Jorge Alfonso García Espinosa
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 */
package com.jorgealfonsogarcia.springbootreportexample.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Service with statistics of the examples.
 *
 * @author Jorge Alfonso García Espinosa
 * @since 1.8
 * @version 0.0.1-SNAPSHOT 12/03/2017
 */
@Service
public class StatisticsService {

    /**
     * Gets the "TOP IDE index" from © Pierre Carbonnelle, 2016.
     * <a href="http://pypl.github.io/IDE.html">http://pypl.github.io/IDE.html</a>
     *
     * @return List of the IDE's and their percentage of use.
     */
    public List<IDEUsage> getTopIDEIndex() {
        List<IDEUsage> list = new ArrayList<>();

        list.add(new IDEUsage("Eclipse", 26.08));
        list.add(new IDEUsage("Visual Studio", 20.14));
        list.add(new IDEUsage("Android Studio", 9.61));
        list.add(new IDEUsage("Vim", 8.31));
        list.add(new IDEUsage("Xcode", 5.54));
        list.add(new IDEUsage("IntelliJ", 4.5));
        list.add(new IDEUsage("Xamarin", 3.8));
        list.add(new IDEUsage("NetBeans", 3.78));
        list.add(new IDEUsage("Sublime Text", 3.15));
        list.add(new IDEUsage("Komodo", 3.15));
        list.add(new IDEUsage("Visual Studio Code", 2.54));
        list.add(new IDEUsage("pyCharm", 1.95));
        list.add(new IDEUsage("Emacs", 1.59));
        list.add(new IDEUsage("Code::Blocks", 1.41));
        list.add(new IDEUsage("PhpStorm", 1.3));
        list.add(new IDEUsage("Light Table", 1.08));
        list.add(new IDEUsage("Cloud9", 0.65));
        list.add(new IDEUsage("Qt Creator", 0.29));
        list.add(new IDEUsage("geany", 0.2));
        list.add(new IDEUsage("JDeveloper", 0.18));
        list.add(new IDEUsage("MonoDevelop", 0.15));
        list.add(new IDEUsage("Aptana", 0.13));
        list.add(new IDEUsage("RubyMine", 0.13));
        list.add(new IDEUsage("JCreator", 0.05));
        list.add(new IDEUsage("Coda 2", 0.05));
        list.add(new IDEUsage("SharpDevelop", 0.05));
        list.add(new IDEUsage("Monkey Studio", 0.04));
        list.add(new IDEUsage("Eric Python", 0.04));
        list.add(new IDEUsage("Julia Studio", 0.03));
        list.add(new IDEUsage("Zend Studio", 0.02));
        list.add(new IDEUsage("DrJava", 0.02));
        list.add(new IDEUsage("SlickEdit", 0.02));

        return list;
    }
}
