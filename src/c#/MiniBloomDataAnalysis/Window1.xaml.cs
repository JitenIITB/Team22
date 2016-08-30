using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using System.Windows.Controls.DataVisualization.Charting;
namespace MiniBloomDataAnalysis
{
    /// <summary>
    /// Interaction logic for Window1.xaml
    /// </summary>
    public partial class Window1 : Window
    {
        List<Ticker> tickers = new List<Ticker>();
        public Window1(String userName)
        {
            InitializeComponent();
            
            tickers.Add(new Ticker("aapl", "Nasdoc"));
            tickers.Add(new Ticker("mst", "Nasdoc"));
            tickers.Add(new Ticker("aapl", "Forex"));
            tickers.Add(new Ticker("jhjk", "Forex"));
            tickers.Add(new Ticker("ksj", "Nasdac"));
        }
       
        
        private void Search(object sender, RoutedEventArgs e)
        {
            List<Ticker> matchingTickers = new List<Ticker>();
            foreach(Ticker ticker in tickers)
            {
                if (ticker.TickerName.Equals(txtSearch.Text))
                {
                    matchingTickers.Add(ticker);
                    lstSearch.Items.Add(matchingTickers.Last());
                }
                
            }
            lstSearch.IsEnabled = true;
            //lstSearch.Items.Clear();
            

        }

        private void SignOut(object sender, MouseButtonEventArgs e)
        {
            MainWindow loginWindow = new MainWindow();
            this.Close();
            loginWindow.Show();
        }

        private void Populate(object sender, RoutedEventArgs e)
        {
            txtSearch.IsEnabled = true;
            txtSearch.Text = "";
            //txtSearch.IsEnabled = true;
            
        }

        private void Select(object sender, SelectionChangedEventArgs e)
        {
            txtSearch.IsEnabled = false;
            lstSearch.IsEnabled = false;
            List<KeyValuePair<DateTime, decimal>> msftPrices =
                new List<KeyValuePair<DateTime, decimal>>();
            DateTime dt = DateTime.Now;
            decimal stockPrice = 32.6m;
            TimeSpan delta = new TimeSpan(0, 1, 0); // one minute
            Random random = new Random();
            for (int i = 0; i < 5; i++)
            { // add 5 ticks at minute intervals
                
                msftPrices.Add(new KeyValuePair<DateTime, decimal>
                    (dt, stockPrice + 4 + 2.5m * (Decimal)random.NextDouble()));
                dt = dt.Add(delta);

            }
            LineSeries lineSeries = new LineSeries();
            lineSeries.Title = lstSearch.SelectedItem.ToString();
            lineSeries.ItemsSource = msftPrices;
            lineSeries.DependentValuePath = "Value";
            lineSeries.IndependentValuePath = "Key";

            lineChart.Series.Add(lineSeries);

        }
    }
}
