# Cruise Booking Project

This project contains solutions for two problems related to cruise booking: finding the best group prices for cabins and determining combinable promotions.

## Table of Contents

- [Problem 1: Best Group Prices](#problem-1-best-group-prices)
- [Problem 2: Combinable Promotions](#problem-2-combinable-promotions)
- [Setup](#setup)
- [Running the Project](#running-the-project)
- [Running Tests](#running-tests)

## Problem 1: Best Group Prices

This solution finds the best price for each cabin and rate group combination.

### Key Components:

- `Rate`: Represents a rate with a code and group.
- `CabinPrice`: Represents the price of a cabin for a specific rate.
- `BestGroupPrice`: Represents the best price for a cabin and rate group.
- `getBestGroupPrices`: Function to calculate the best group prices.

## Problem 2: Combinable Promotions

This solution finds all possible combinations of promotions that can be applied together.

### Key Components:

- `Promotion`: Represents a promotion with a code and a list of promotions it cannot be combined with.
- `PromotionCombo`: Represents a combination of promotion codes.
- `allCombinablePromotions`: Function to find all combinable promotion combinations.
- `combinablePromotions`: Function to find combinable promotions for a specific promotion code.

## Setup

1. Ensure you have Scala and sbt installed on your system.
2. Clone this repository:
   ```
   git clone https://github.com/your-username/cruise-booking-project.git
   cd cruise-booking-project
   ```

## Running the Project

To run the main programs for each problem:

```
sbt "runMain com.tst.cruisebooking.Problem1"
sbt "runMain com.tst.cruisebooking.Problem2"
```

## Running Tests

This project uses ScalaTest for unit testing. To run the tests:

```
sbt test
```

This will run all tests for both Problem 1 and Problem 2.
