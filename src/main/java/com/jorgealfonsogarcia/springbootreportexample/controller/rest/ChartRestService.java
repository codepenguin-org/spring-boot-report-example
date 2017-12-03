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
package com.jorgealfonsogarcia.springbootreportexample.controller.rest;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Locale;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST service to export charts.
 *
 * @author Jorge Alfonso García Espinosa
 * @since 1.8
 * @version 0.0.1-SNAPSHOT 12/03/2017
 */
@RestController
@RequestMapping(path = "/chart")
public class ChartRestService {

    /**
     * Build a PNG image of a pie chart example about the "Top IDE index".
     *
     * @param width Width of the image.
     * @param height Height of the image.
     * @param response HTTP Response.
     * @throws IOException
     */
    @RequestMapping(path = "/pie/{width}/{height}", method = RequestMethod.GET)
    public void buildPieChart(@PathVariable("width") int width, @PathVariable("height") int height, HttpServletResponse response) throws IOException {
        final PieDataset pieDataset = buildTopIDEIndexPieDataset();
        final String title = "Top IDE index";
        final boolean legend = true;
        final boolean tooltips = true;

        final PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} = {2}");

        final JFreeChart pieChart3D = ChartFactory.createPieChart3D(title, pieDataset, legend, tooltips, Locale.getDefault());
        final PiePlot3D piePlot3D = (PiePlot3D) pieChart3D.getPlot();
        piePlot3D.setLabelGenerator(labelGenerator);

        final BufferedImage bufferedImage = pieChart3D.createBufferedImage(width, height);

        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        ChartUtils.writeBufferedImageAsPNG(response.getOutputStream(), bufferedImage);
    }

    private PieDataset buildTopIDEIndexPieDataset() {
        /*
         * Data from:
         * 
         * Top IDE index
         * http://pypl.github.io/IDE.html
         * © Pierre Carbonnelle, 2016
         */
        final DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("Eclipse", 26.08);
        pieDataset.setValue("Visual Studio", 20.14);
        pieDataset.setValue("Android Studio", 9.61);
        pieDataset.setValue("Vim", 8.31);
        pieDataset.setValue("Xcode", 5.54);
        pieDataset.setValue("IntelliJ", 4.5);
        pieDataset.setValue("Xamarin", 3.8);
        pieDataset.setValue("NetBeans", 3.78);
        pieDataset.setValue("Sublime Text", 3.15);
        pieDataset.setValue("Komodo", 3.15);
        pieDataset.setValue("Visual Studio Code", 2.54);
        pieDataset.setValue("pyCharm", 1.95);
        pieDataset.setValue("Emacs", 1.59);
        pieDataset.setValue("Code::Blocks", 1.41);
        pieDataset.setValue("PhpStorm", 1.3);
        pieDataset.setValue("Light Table", 1.08);
        pieDataset.setValue("Cloud9", 0.65);
        pieDataset.setValue("Qt Creator", 0.29);
        pieDataset.setValue("geany", 0.2);
        pieDataset.setValue("JDeveloper", 0.18);
        pieDataset.setValue("MonoDevelop", 0.15);
        pieDataset.setValue("Aptana", 0.13);
        pieDataset.setValue("RubyMine", 0.13);
        pieDataset.setValue("JCreator", 0.05);
        pieDataset.setValue("Coda 2", 0.05);
        pieDataset.setValue("SharpDevelop", 0.05);
        pieDataset.setValue("Monkey Studio", 0.04);
        pieDataset.setValue("Eric Python", 0.04);
        pieDataset.setValue("Julia Studio", 0.03);
        pieDataset.setValue("Zend Studio", 0.02);
        pieDataset.setValue("DrJava", 0.02);
        pieDataset.setValue("SlickEdit", 0.02);
        return pieDataset;
    }
}
