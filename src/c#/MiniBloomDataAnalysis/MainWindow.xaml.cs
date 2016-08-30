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
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Net;

namespace MiniBloomDataAnalysis
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void Login(object sender, RoutedEventArgs e)
        {
            string serverUrl = "http://192.168.77.1/MarketDataAnalysisWeb/rest/market";
            string password;
            string userName = txtUserName.Text;
            //using(WebClient web = new WebClient())
            //{
            //    web.Headers.Add(HttpRequestHeader.ContentType, "text/plain");
            //    web.UploadString(serverUrl, "POST", userName);
            //    password = web.DownloadString(serverUrl);
            //}
            password = "abc123";
            if (password.Length == 0)
            {
                txtUserName.Text = "";
                pwdPassword.Password = "";
                lblMessage.Content = "*The username is not valid.Please try again or create a new account";
            }
            else if (password.Equals(pwdPassword.Password))
            {
                Window1 appWindow = new Window1(userName);
                this.Close();
                appWindow.Show();
            }
            else
            {
                txtUserName.Text = "";
                pwdPassword.Password = " ";
                lblMessage.Content = "*The username and password do not match.Please try again.";
            }
        }

        private void SignUp(object sender, RoutedEventArgs e)
        {
            Window2 registerWindow = new Window2();
            this.Close();
            registerWindow.Show();
        }

        private void EnterUserName(object sender, MouseButtonEventArgs e)
        {
            txtUserName.Text = "";
        }

        

        private void EnterUserName(object sender, MouseEventArgs e)
        {
            txtUserName.Text = "";
        }

        private void EnterPassword(object sender, MouseEventArgs e)
        {
            pwdPassword.Password = "";
        }
    }
}
