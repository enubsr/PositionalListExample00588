using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PositionalListExample
{
    public class InvalidPositionException : Exception
    {
        public InvalidPositionException(string msg) 
            : base(msg)
        {

        }
    }
}
