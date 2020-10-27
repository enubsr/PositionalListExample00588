using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PositionalListExample
{
    class Program
    {
        static void Main(string[] args)
        {
            LinkedPositionalList<string> strPos =
                new LinkedPositionalList<string>();

            Position<string> p1 = strPos.AddFirst("first"); //first
            Position<string> p2 = strPos.AddFirst("second");//second first
            Position<string> p3 = strPos.AddAfter(p2, "next_of_p2");//second next_of_p2 first

            Console.WriteLine(strPos.Before(p1).GetElement());
            Console.ReadLine();

        }
    }
}
