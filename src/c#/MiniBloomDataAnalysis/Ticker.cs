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
    public class Ticker
    {
        [DataMember]
        public string TickerName { get; private set; }
        [DataMember]
        public string MarketName { get; private set; }
        public Ticker(string tickerName, string marketName)
        {
            TickerName = tickerName;
            MarketName = marketName;
        }
        public override string ToString()
        {
            return TickerName + " : " + MarketName;
        }
        public override bool Equals(object obj)
        {
            if(obj is Ticker)
            {
                Ticker tic = obj as Ticker;
                return tic.TickerName.Equals(this.TickerName);
            }
            return false;
        }
    }
}
