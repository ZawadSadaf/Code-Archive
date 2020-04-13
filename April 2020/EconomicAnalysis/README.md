A class of methods for performing various operations from ECON 423 (Engineering Economic Analysis, IIT). 

| Chapter | Name  |  Return Type  |  Method and Description |
|---------|-------|---------------|-------------------------|
| 3 | Single Payment Compound Amount Factor| double | singlePCAF(double p, double i, double n)  <br /> <br /> Returns the future value, given present value, interest, and number of periods. |
| 3 | Single Payment Present Worth Factor| double | singlePPWF(double f, double i, double n)  <br /> <br /> Returns the present value, given future value, interest, and number of periods. |
| 3 | Single Payment Series Period Number| double | singlePSPN(double f, double p, double i)  <br /> <br /> Returns the number of periods, given future value, present value, and interest. |
| 3 | Single Payment Series Interest | double | singlePSI(double n, double f, double p)  <br /> <br /> Returns the interest, given number of periods, future value, and present value. |
| 3 | Effective Annual Interest Rate | double | effectiveAIR(double i, double m)  <br /> <br /> Returns the effective annual interest rate, given the interest per subperiod and number of subperiods per year. |
| 3 | Effective Annual Interest Rate (w/ Continuous Compounding) | double | effectiveAIRCC(double r)  <br /> <br /> Returns the effective annual interest rate (w/ continuous compounding), given the annual interest rate. |
