# <div align = "center"> The Monty Hall Problem </div>    
<p align="center">
  <img width="301" height="167" src="https://i.imgur.com/VU9s0Bw.jpg">
</p>

### <div align = "center">Explanation</div>
-------


You are a contestant on a game show hosted by Monty Hall. On this game show, you are presented with three doors: two hiding goats
and one hiding a brand new car. You can make a choice but once you make your choice, Monty Hall opens one of the remaining doors
and reveals a goat. You are given another choice to either stay with your original choice or switch to the remaining door. Should
you switch or remain?

### <div align = "center">Solution</div>
-------
 
 <p align="center">
  <img width="220" height="220" src="https://i.imgur.com/1vtmUfZ.png">
</p>

You pick an arbitrary door, for example door 1. The probability that you chose a door hiding a goat is clearly 2/3. Once Monty opens another door, for example door 3, you now know where one of the goats is. For doors 1, 2, and 3, the probability of them hiding a goat are 2/3, 1/3 and 1 (100%). Switching doors will win you a car if you initially picked a goat, since you can only switch from a goat to a car and vice versa. Since the probability you initially picked a goat were 2/3, your chance to win if you switch is also 2/3. The answer to the problem is **YES**, you should definently switch. 

The code I wrote located in the above folder is a simple Monte Carlo style simulator that proves over n iterations, that your odds of winning are approximately 2/3. 
