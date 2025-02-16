/*
 * The contents of this file is dual-licensed under 2
 * alternative Open Source/Free licenses: LGPL 2.1 or later and
 * Apache License 2.0. (starting with JNA version 4.0.0).
 *
 * You can freely decide which license you want to apply to
 * the project.
 *
 * You may obtain a copy of the LGPL License at:
 *
 * http://www.gnu.org/licenses/licenses.html
 *
 * A copy is also included in the downloadable source code package
 * containing JNA, in file "LGPL2.1".
 *
 * You may obtain a copy of the Apache License at:
 *
 * http://www.apache.org/licenses/
 *
 * A copy is also included in the downloadable source code package
 * containing JNA, in file "AL2.0".
 */

package com.zcsmart.jna.platform.win32.COM.util.office.excel;

import com.zcsmart.jna.platform.win32.COM.IDispatch;
import com.zcsmart.jna.platform.win32.COM.util.annotation.ComInterface;
import com.zcsmart.jna.platform.win32.COM.util.annotation.ComMethod;

@ComInterface
public interface Chart {
    @ComMethod
    void ChartWizard(Object Source,Object Gallery,Object Format,Object PlotBy,
            Object CategoryLabels,Object SeriesLabels,Object HasLegend,
            Object Title,Object CategoryTitle,Object ValueTitle,Object ExtraTitle);

    @ComMethod
    Series SeriesCollection(Object index);

    @ComMethod
    IDispatch Location(XlChartLocation location, String name);
}
