using System;
using System.Text.RegularExpressions;

namespace StringCalculator
{
    public class StringCalculator
    {
        public static void Main()
        {

        }
        public StringCalculator() { }

        public int Add(string numbers)
        {
            string[] separators = new string[] { ",", "\n", "\r\n", "\r", ";" };
            int value = 0;
            int sum = 0;

            if ((numbers.Contains(",") || numbers.Contains("\n") || numbers.Contains(";")) && numbers.Length > 0)
            {
                
                
                string[] splitNumbers = numbers.Split(separators, StringSplitOptions.RemoveEmptyEntries);
                for(int i=0; i < splitNumbers.Length; i++)
                {
                    value = Int32.Parse(splitNumbers[i]);
                    sum += value;
                }
                
                return sum;
            }
            else if((!numbers.Contains(",") && !numbers.Contains("\n") && !numbers.Contains(";")) && numbers.Length > 0)
            {
                sum = Int32.Parse(numbers);
                return sum;
            }
            else if(numbers == "")
            {
                return 0;
            }
            else
            {
                return 0;
            }

            
            
        }
    }
}
