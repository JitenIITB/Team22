using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;
using System.Runtime.Serialization.Json;

namespace MiniBloomDataAnalysis
{
    [DataContract]
    class User
    {
        public string UserName { get; private set; }
        public string Password { get; private set; }
        public User(string userName,string password)
        {
            UserName = userName;
            Password = password;
        }

    }
}
