package MagiaNegra;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * La clase {@code RegresionPolinominal} implementa una regresión polinómica utilizando
 * la biblioteca Apache Commons Math para ajustar un polinomio a un conjunto de datos,
 * y JFreeChart para graficar tanto los puntos originales como la curva ajustada.
 * <p>
 * Esta clase proporciona métodos para:
 * <ul>
 *   <li>Crear un mapa de puntos observados a partir de arrays de valores X e Y.</li>
 *   <li>Almacenar los puntos originales en una serie de datos.</li>
 *   <li>Generar una serie de datos para la curva ajustada evaluada en múltiples puntos.</li>
 *   <li>Crear y personalizar un gráfico XY con las series de datos.</li>
 *   <li>Mostrar el gráfico en una ventana Swing.</li>
 * </ul>
 * </p>
 *
 * @author José M. Duarte Peris
 */
public class RegresionPolinominal {

    /**
     * Realiza una regresión polinómica sobre los datos proporcionados y muestra el gráfico resultante.
     *
     * @param x              array de valores X
     * @param y              array de valores Y correspondientes a cada X
     * @param gradoPolinomio el grado del polinomio a ajustar (por ejemplo, 1 para recta, 2 para parábola,
     *                       3 para más complejos, etc.)
     */
    public static void calcularRegresionPolinominal(double[] x, double[] y, int gradoPolinomio) {

        //Creamos un "ajustador" polinómico de grado 3
        //Grado 1 es una recta, 2 una parábola y 3 es mucho más complejo
        //Dependiendo de la distribución de datos en el gráfico se usa uno u otro
        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(gradoPolinomio);

        //Calcula los coeficientes para el polinomio (recta)
        double[] coefficients = fitter.fit(crearMapa(x, y).toList());

        //Convierte los coeficientes en una función para evaluar cualquier X
        PolynomialFunction polynomial = new PolynomialFunction(coefficients);

        // Se almacenan los puntos originales y la curva ajustada en un mismo dataset
        XYSeriesCollection dataSet = new XYSeriesCollection();
        dataSet.addSeries(almacenarPuntosOG(x, y));
        dataSet.addSeries(crearCurva(x, polynomial));

        // Se crea y muestra el gráfico
        mostrarGrafico(crearGrafico(dataSet));
    }

    /**
     * Crea un objeto {@code WeightedObservedPoints} a partir de los arrays de valores X e Y.
     *
     * @param x array de valores X
     * @param y array de valores Y
     * @return un objeto {@code WeightedObservedPoints} que contiene cada par (x, y)
     */
    public static WeightedObservedPoints crearMapa(double[] x, double[] y) {
        WeightedObservedPoints points = new WeightedObservedPoints();
        for (int i = 0; i < x.length; i++) {
            points.add(x[i], y[i]);
        }
        return points;
    }

    /**
     * Almacena los puntos originales en una serie de datos.
     *
     * @param x array de valores X
     * @param y array de valores Y
     * @return un objeto {@code XYSeries} con los puntos originales etiquetados como "Datos"
     */
    public static XYSeries almacenarPuntosOG(double[] x, double[] y) {
        XYSeries seriesData = new XYSeries("Datos");
        for (int i = 0; i < x.length; i++) {
            seriesData.add(x[i], y[i]);
        }
        return seriesData;
    }

    /**
     * Crea la curva ajustada evaluando el polinomio en un conjunto de puntos distribuidos uniformemente
     * en el rango de valores de X.
     *
     * @param x          array de valores X originales (usado para determinar el rango)
     * @param polynomial función polinómica que representa el ajuste obtenido
     * @return un objeto {@code XYSeries} que contiene la curva de ajuste, etiquetada como "Ajuste Polinómico"
     */
    public static XYSeries crearCurva(double[] x, PolynomialFunction polynomial) {
        XYSeries seriesFit = new XYSeries("Ajuste Polinómico");

        // Se determina el valor mínimo y máximo del array x
        double minX = Arrays.stream(x).min().orElse(0);
        double maxX = Arrays.stream(x).max().orElse(10);

        // Se determina el número de puntos a generar (10 veces la cantidad de valores originales para una curva suave)
        int numPuntos = x.length * 10;
        if (numPuntos < 10) numPuntos = 10; // Se asegura un mínimo de 10 puntos

        // Se calcula el incremento entre cada punto
        double siguiente = (maxX - minX) / numPuntos;

        // Se evalúa el polinomio en cada uno de los puntos generados y se agregan a la serie
        for (double i = minX; i <= maxX; i += siguiente) {
            seriesFit.add(i, polynomial.value(i));
        }

        return seriesFit;
    }

    /**
     * Crea un gráfico XY a partir de un conjunto de series de datos.
     *
     * @param dataSet conjunto de series de datos que serán graficados
     * @return un objeto {@code JFreeChart} que representa el gráfico XY
     */
    public static JFreeChart crearGrafico(XYSeriesCollection dataSet) {
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Regresión Polinómica",  // Título del gráfico
                "X",                     // Etiqueta del eje X
                "Y",                     // Etiqueta del eje Y
                dataSet,                 // Datos a graficar
                PlotOrientation.VERTICAL,
                true,                    // Mostrar leyenda
                true,                    // Mostrar tooltips
                false                    // No generar URLs
        );
        personalizarGrafico(chart);
        return chart;
    }

    /**
     * Personaliza el gráfico modificando la apariencia del trazado.
     * <p>
     * En particular, configura:
     * <ul>
     *   <li>La visualización de los puntos originales (con formas visibles).</li>
     *   <li>La visualización de la curva de ajuste (línea sin puntos) y su color (rojo).</li>
     * </ul>
     * </p>
     *
     * @param chart el objeto {@code JFreeChart} a personalizar
     */
    public static void personalizarGrafico(JFreeChart chart) {
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesShapesVisible(0, true);  // Muestra los puntos originales
        renderer.setSeriesShapesVisible(1, false); // Muestra solo la curva, sin puntos
        renderer.setSeriesPaint(1, Color.RED);     // Establece el color de la curva
        plot.setRenderer(renderer);
    }

    /**
     * Muestra el gráfico en una ventana Swing.
     * <p>
     * Crea un {@code JFrame} que contiene un {@code ChartPanel} con el gráfico, empaqueta la ventana
     * y la hace visible.
     * </p>
     *
     * @param chart el objeto {@code JFreeChart} que se mostrará
     */
    public static void mostrarGrafico(JFreeChart chart) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Gráfica de Ajuste"); // Crea un JFrame
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new ChartPanel(chart)); // Agrega el gráfico a la ventana
            frame.pack(); // Ajusta el tamaño de la ventana
            frame.setVisible(true); // Muestra la ventana
        });
    }
}
