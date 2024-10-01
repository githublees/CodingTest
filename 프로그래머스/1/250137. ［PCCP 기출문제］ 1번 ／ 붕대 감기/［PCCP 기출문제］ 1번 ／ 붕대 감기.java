class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int cast = bandage[0];
        int recovery = bandage[1];
        int add_recovery = bandage[2];
        
        int max_health = health;
        
        int currentTime = 0;
        
        for (int i = 0; i < attacks.length; i++) {
            
            int attackTime = attacks[i][0];
            int demage = attacks[i][1];
            
            // 총 시전 시간
            int total_cast = Math.abs(currentTime - attackTime);
            
            // 회복된 체력
            // (총 시전시간 * 초당 회복량) + (추가 회복량 * (총 시전시간 / 시전 시간))
            int total_recovery = (total_cast * recovery) + (total_cast / cast) * add_recovery;
            
            if (health + total_recovery > max_health) {
                health = max_health;
            } else {
                health += total_recovery;
            }
            
            if (health - demage <= 0) {
                return -1;
            } else {
                health -= demage;
            }
            
            System.out.println(health);
            
            currentTime = attackTime + 1;
        }
        
        
        
        return health;
    }
}