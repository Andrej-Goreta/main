using System;

namespace ProgrammingExercise
{
    class MainClass
    {
        public static void Main(string[] args)
        {


            String answer = "";
            int counter = 0;
            String indicator = "";
            String plus = "+";
            String minus = "-";


            Random rand = new Random();
            int firstDigit = rand.Next(1, 6);
            String firstDigitStr = Convert.ToString(firstDigit);
            answer += firstDigitStr;

            int secondDigit = rand.Next(1, 6);
            String secondDigitStr = Convert.ToString(secondDigit);
            answer += secondDigitStr;

            int thirdDigit = rand.Next(1, 6);
            String thirdDigitStr = Convert.ToString(thirdDigit);
            answer += thirdDigitStr;

            int fourthDigit = rand.Next(1, 6);
            String fourthDigitStr = Convert.ToString(fourthDigit);
            answer += fourthDigitStr;



            Console.WriteLine("Welcome to a beautiful game of Mastermind! Can you guess the 4 digit number? Give it a shot.");
            Console.WriteLine("'Couple hints: each digit is between 1 to 6, 4 digit length, and no space inbetween numbers." + "\n" +
                                " Also, (+) means correct number and position, (-) means correct number, but wrong position," + "\n" +
                                " and a space means incorrect number. Numbers can be repeated and if the same number has a " + "\n" +
                                " (+) or (-) then that only indicates that the one with the (+) is the only number in the answer sequence.'");

            Console.WriteLine("-------------------" + "\n");

            

         
            for (int k = 1; k <= 10; k++)
            {
                counter += 1;
                Console.WriteLine("Enter Combination:");
                String keyboard = Console.ReadLine();
                if (keyboard.Length < 4 || keyboard.Length > 4)
                {
                    Console.WriteLine("Re-enter guess. Needs to be 4 digits only" + "\n");
                    counter -= 1;
                    k -= 1;

                }
                else
                {


                    for (int i = 0; i < keyboard.Length; i++)
                    {
                        if (keyboard[i] == answer[i])
                        {
                            indicator += plus;
                        }
                        else if ((i == 0) && ((keyboard[i] == answer[i + 1]) ||
                                (keyboard[i] == answer[i + 2]) ||
                                (keyboard[i] == answer[i + 3])))
                        {

                            indicator += minus;
                        }
                        else if ((i == 1) && ((keyboard[i] == answer[i + 1]) ||
                                (keyboard[i] == answer[i + 2]) ||
                                (keyboard[i] == answer[i - 1])))
                        {

                            indicator += minus;
                        }
                        else if ((i == 2) && ((keyboard[i] == answer[i + 1]) ||
                                (keyboard[i] == answer[i - 1]) ||
                                (keyboard[i] == answer[i - 2])))
                        {

                            indicator += minus;
                        }
                        else if ((i == 3) && ((keyboard[i] == answer[i - 1]) ||
                                (keyboard[i] == answer[i - 2]) ||
                                (keyboard[i] == answer[i - 3])))
                        {

                            indicator += minus;
                        }
                        else
                        {
                            indicator += " ";
                        }

                    }

                    if (indicator == ("++++"))
                    {
                        Console.WriteLine("\n" + "Congratulations! You guessed the right sequence of numbers. Gold Star for you! Thank you for playing Mastermind. Have a wonderful day");
                        Console.WriteLine(answer + " (Answer)");
                        Console.WriteLine(keyboard + " (Your Guess)");
                        return;
                    }
                    else
                    {
                        Console.WriteLine("\n" + "Try again. You have " + (10 - counter) + " trys left" + "\n");
                        Console.WriteLine(keyboard);
                        Console.WriteLine(indicator);
                        indicator = "";
                        Console.WriteLine("-------------------" + "\n");
                    }



                }
            }
            Console.WriteLine("Run out of trys. Sorry, you lose but better luck next time! Thank you for playing Mastermind and have a wonderful day.");


        }
    }
}
