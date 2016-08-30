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
    class Stock
    {
        [DataMember]
        public string Ticker { get; private set; }
        [DataMember]
        public DateTime Date { get; private set; }
        [DataMember]
        public decimal Price { get; private set; }
        [DataMember]
        public int Volume { get; private set; }
        public Stock(string ticker,DateTime date,decimal price,int volume)
        {
            Ticker = ticker;
            Date = date;
            Price = price;
            Volume = volume;
        }

    }
}
