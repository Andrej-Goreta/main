using Microsoft.VisualStudio.TestTools.UnitTesting;


namespace StringCalculatorTests
{
    using StringCalculator;
    [TestClass]
    public class StringCalculatorTests
    {
        StringCalculator stringNumber = new StringCalculator();
        
        [TestMethod]
        public void Add_EmptyString_ReturnsZero()
        {
           
            int number =  stringNumber.Add("");
            Assert.AreEqual(0, number);
        }

        [TestMethod]
        public void Add_WithNoCommaAndOneNumber_InAString()
        {
            int number = stringNumber.Add("5");
            Assert.AreEqual(5, number);
        }

        [TestMethod]
        public void Add_WithACommaAndTwoNumbers_InAString()
        {
            int number = stringNumber.Add("1,2");
            Assert.AreEqual(3, number);
        }

        [TestMethod]
        public void Add_WithUnkownAmountOfNumbers_InAString()
        {
            int number = stringNumber.Add("1,2,3,4,5,6,7,8,9");
            Assert.AreEqual(45, number);
        }

        [TestMethod]
        public void Add_WithNewLinesAndCommas_InAString()
        {
            int number = stringNumber.Add("1\n3,4");
            Assert.AreEqual(8, number);
        }

        [TestMethod]
        public void Add_WithNewLinesAndCommasAndSemiColons_InAString()
        {
            int number = stringNumber.Add("\n1;4,5");
            Assert.AreEqual(10, number);
        }
    }
}
