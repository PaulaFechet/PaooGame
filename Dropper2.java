public class Dropper2 extends Thread {




    NivelIII n;
    Candy[][] candies;
    Dropper2(NivelIII n, Candy[][] candies)
    {
        this.candies=candies;
        this.n=n;
    }



    public void run() {
        while (candies[0][0].getY() < 700) {
            for (int i = 0; i < candies.length; i++) {
                for (int j = 0; j < candies[i].length; j++) {
                    {
                        if(i%2==0)
                        {
                            candies[i][j].setY(candies[i][j].getY() + 30);
                        }else if(j%3==0)
                        {
                            candies[i][j].setY(candies[i][j].getY() + 40);
                        }else
                        {
                            candies[i][j].setY(candies[i][j].getY() + 30);
                        }
                    }

                }
            }
            try{
                Thread.sleep(900);
            }catch(Exception e) {
                System.out.println(e);
            }

            n.repaint();
        }
    }
}