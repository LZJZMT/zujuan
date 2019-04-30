package com.zujuan.pojo;

/**
 * @Description:
 * @Author: LZJ
 * @Date： 2019/4/27 14:02
 */

import java.util.List;

public class EchartOption {

    private  EchartTitle title;

    private  EchartTooltip tooltip;

    private  EchartLegend legend;

    private List<EchartSeries> series;

    public EchartTitle getTitle() {
        return title;
    }

    public void setTitle(EchartTitle title) {
        this.title = title;
    }

    public EchartTooltip getTooltip() {
        return tooltip;
    }

    public void setTooltip(EchartTooltip tooltip) {
        this.tooltip = tooltip;
    }

    public EchartLegend getLegend() {
        return legend;
    }

    public void setLegend(EchartLegend legend) {
        this.legend = legend;
    }

    public List<EchartSeries> getSeries() {
        return series;
    }

    public void setSeries(List<EchartSeries> series) {
        this.series = series;
    }
}
