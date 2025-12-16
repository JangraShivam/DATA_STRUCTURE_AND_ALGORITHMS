public class CoinChange{

    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;

        int minCoinChange = -1;

            for(int coin : coins){
                if(coin <= amount){
                    int recursionAns = coinChange(coins,amount-coin);

                    if(recursionAns != -1){
                        if(minCoinChange == -1) minCoinChange = 1 + recursionAns;
                        else minCoinChange = Math.min(minCoinChange,1 + recursionAns);
                    }
                }
            }

        return minCoinChange; 
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;

        System.out.println(coinChange(coins, amount));
    }
}