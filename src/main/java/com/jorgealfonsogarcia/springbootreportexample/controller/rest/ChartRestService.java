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

import com.jorgealfonsogarcia.springbootreportexample.service.StatisticsService;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Locale;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private StatisticsService statisticsService;

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

        writeChartAsPNGImage(pieChart3D, width, height, response);
    }

    /**
     * Build a PNG image of a bar chart example about average salary for the IT
     * industry in USA.
     *
     * @param width Width of the image.
     * @param height Height of the image.
     * @param response HTTP Response.
     * @throws IOException
     */
    @RequestMapping(path = "/bar/{width}/{height}", method = RequestMethod.GET)
    public void buildBarChart(@PathVariable("width") int width, @PathVariable("height") int height, HttpServletResponse response) throws IOException {
        final DefaultCategoryDataset categoryDataset = buildITServiceAverageSalaryCategoryDataset();
        final String title = "Average Salary for Information Technology (IT) Services Industry";
        final String categoryAxisLabel = "Jobs";
        final String valueAxisLabel = "Average Salary (USD)";
        final boolean legend = true;
        final boolean tooltips = true;
        final boolean urls = true;

        final JFreeChart barChart = ChartFactory.createBarChart(title, categoryAxisLabel, valueAxisLabel, categoryDataset, PlotOrientation.VERTICAL, legend, tooltips, urls);
        final CategoryPlot categoryPlot = (CategoryPlot) barChart.getPlot();
        final CategoryItemRenderer categoryItemRenderer = categoryPlot.getRenderer();
        categoryItemRenderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        categoryItemRenderer.setDefaultItemLabelsVisible(true);

        final ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER);
        categoryItemRenderer.setDefaultPositiveItemLabelPosition(position);

        writeChartAsPNGImage(barChart, width, height, response);
    }

    /**
     * Build a PNG image of a line chart example about the history of number of
     * users (in millions) of Internet worldwide from 1995.
     *
     * @param width Width of the image.
     * @param height Height of the image.
     * @param response HTTP Response.
     * @throws IOException
     */
    @RequestMapping(path = "/line/{width}/{height}", method = RequestMethod.GET)
    public void buildLineChart(@PathVariable("width") int width, @PathVariable("height") int height, HttpServletResponse response) throws IOException {
        final DefaultCategoryDataset categoryDataset = buildHistoryOfInternetUsersCategoryDataset();
        final String title = "History of users of the Internet from 1995";
        final String categoryAxisLabel = "Year";
        final String valueAxisLabel = "Num. of Users (in millions)";
        final boolean legend = true;
        final boolean tooltips = true;
        final boolean urls = true;

        final JFreeChart lineChart = ChartFactory.createLineChart(title, categoryAxisLabel, valueAxisLabel, categoryDataset, PlotOrientation.VERTICAL, legend, tooltips, urls);
        final CategoryPlot categoryPlot = (CategoryPlot) lineChart.getPlot();
        final CategoryItemRenderer categoryItemRenderer = categoryPlot.getRenderer();
        categoryItemRenderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        categoryItemRenderer.setDefaultItemLabelsVisible(true);

        final ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_LEFT);
        categoryItemRenderer.setDefaultPositiveItemLabelPosition(position);

        writeChartAsPNGImage(lineChart, width, height, response);
    }

    private PieDataset buildTopIDEIndexPieDataset() {
        final DefaultPieDataset pieDataset = new DefaultPieDataset();
        statisticsService.getTopIDEIndex().forEach((usage) -> pieDataset.setValue(usage.getIde(), usage.getPercentage()));

        return pieDataset;
    }

    private DefaultCategoryDataset buildITServiceAverageSalaryCategoryDataset() {
        final Comparable<String> rowKey = "USA";
        final DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
        statisticsService.getsAverageSalaryFoITServices().forEach((averageSalary) -> categoryDataset.setValue(averageSalary.getAverageSalary(), rowKey, averageSalary.getJob()));

        return categoryDataset;
    }

    private DefaultCategoryDataset buildHistoryOfInternetUsersCategoryDataset() {
        final Comparable<String> rowKey = "Num. of Users";
        final DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
        statisticsService.getsHistoryOfInternetUsers().forEach((history) -> categoryDataset.setValue(history.getMillionsOfUsers(), rowKey, Integer.valueOf(history.getYear())));

        return categoryDataset;
    }

    private void writeChartAsPNGImage(final JFreeChart chart, final int width, final int height, HttpServletResponse response) throws IOException {
        final BufferedImage bufferedImage = chart.createBufferedImage(width, height);

        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        ChartUtils.writeBufferedImageAsPNG(response.getOutputStream(), bufferedImage);
    }
}
