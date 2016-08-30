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

namespace MiniBloomDataAnalysis
{
    /// <summary>
    /// Interaction logic for Window2.xaml
    /// </summary>
    public partial class Window2 : Window
    {
        public Window2()
        {
            InitializeComponent();
        }

        private void SignUp(object sender, RoutedEventArgs e)
        {
            if (txtUserName.Text.Length == 0 || txtPassword.Text.Length == 0 || txtConfirmPassword.Text.Length == 0)
            {
                lblMessage.Content = "*Please enter valid values.";
                txtUserName.Text = "";
                txtPassword.Text = "";
                txtConfirmPassword.Text = "";
            }
            else if (txtPassword.Text.Equals(txtConfirmPassword.Text))
            {
                lblMessage.Content = "*Please re-enter password.";
                txtPassword.Text = "";
                txtConfirmPassword.Text = "";
            }
            else
            {
                MainWindow loginWindow = new MainWindow();
                this.Close();
                loginWindow.Show();
            }
        }
    }
}
