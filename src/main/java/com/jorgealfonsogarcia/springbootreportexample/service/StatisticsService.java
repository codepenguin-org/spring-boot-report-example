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

    /**
     * Gets the Average Salary for Information Technology (IT) Services Industry
     * in the USA.
     * <a href="https://www.payscale.com/research/US/Industry=Information_Technology_(IT)_Services/Salary">https://www.payscale.com/research/US/Industry=Information_Technology_(IT)_Services/Salary</a>
     *
     * @return List of the IT jobs and their average salary for the USA
     * industry.
     */
    public List<ITServiceAverageSalary> getsAverageSalaryFoITServices() {
        List<ITServiceAverageSalary> list = new ArrayList<>();

        list.add(new ITServiceAverageSalary("Software Engineer", 81496));
        list.add(new ITServiceAverageSalary("Project Manager, Information Technology", 87488));
        list.add(new ITServiceAverageSalary("Network Engineer", 66526));
        list.add(new ITServiceAverageSalary("Project Manager, (General)", 79219));
        list.add(new ITServiceAverageSalary("Information Technology Manager", 90877));

        return list;
    }

    /**
     * Gets the history of the number of users of Internet worldwide, year by
     * year from 1995.
     * <a href="http://www.internetworldstats.com/emarketing.htm">http://www.internetworldstats.com/emarketing.htm</a>
     *
     * @return List of every year from 1995 with their number of users of
     * Internet (in millions).
     */
    public List<InternetUserNumberHistory> getsHistoryOfInternetUsers() {
        List<InternetUserNumberHistory> list = new ArrayList<>();

        list.add(new InternetUserNumberHistory(1995, 16));
        list.add(new InternetUserNumberHistory(1996, 36));
        list.add(new InternetUserNumberHistory(1997, 70));
        list.add(new InternetUserNumberHistory(1998, 147));
        list.add(new InternetUserNumberHistory(1999, 248));
        list.add(new InternetUserNumberHistory(2000, 361));
        list.add(new InternetUserNumberHistory(2001, 513));
        list.add(new InternetUserNumberHistory(2002, 587));
        list.add(new InternetUserNumberHistory(2003, 719));
        list.add(new InternetUserNumberHistory(2004, 817));
        list.add(new InternetUserNumberHistory(2005, 1018));
        list.add(new InternetUserNumberHistory(2006, 1093));
        list.add(new InternetUserNumberHistory(2007, 1319));
        list.add(new InternetUserNumberHistory(2008, 1574));
        list.add(new InternetUserNumberHistory(2009, 1802));
        list.add(new InternetUserNumberHistory(2010, 1971));
        list.add(new InternetUserNumberHistory(2011, 2267));
        list.add(new InternetUserNumberHistory(2012, 2497));
        list.add(new InternetUserNumberHistory(2013, 2802));
        list.add(new InternetUserNumberHistory(2014, 3079));
        list.add(new InternetUserNumberHistory(2015, 3366));
        list.add(new InternetUserNumberHistory(2016, 3696));
        list.add(new InternetUserNumberHistory(2017, 3885));

        return list;
    }
}
