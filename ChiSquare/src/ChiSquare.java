import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ChiSquare extends JFrame{
    public static double confidence;
    private ImageIcon image1;
    private JLabel label1;
    ChiSquare(String filename){
        setLayout(new FlowLayout());
        image1 = new ImageIcon(getClass().getResource(filename));
        label1 = new JLabel(image1);
        add(label1);
    }
    public static void main(String[] agrs) throws IOException {
        //=============================interface=============================
        Scanner fuck2 = new Scanner(System.in);
        boolean fuck = true;

        while(fuck) {
            System.out.println("Plese enter 1-9 to select a calculator\n"
                    + "  1. Chi Square Calculator(row&col)\n"
                    + "  2. Argue that mean of the population is greater, different, lesser (H0: x = 10.93 || u < 5.2)\n"
                    + "  3. Specificity\n"
                    + "  4. Calculated the pooled variance (T-table) (Be careful of a-b or b-a)\n"
                    + "  5. You want to show that pA - pB ... 0 (P-Hat)\n"
                    + "  6. Calculate how wide would the interval be by using mean [a,b] (Margin of error)\n"
                    + "  7. Calculate how wide would the interval be by using p^ [a,b]\n"
                    + "  8. Calculate the appropriate test statistic for hypothesis test by using mean (u1 - u2 > 0)\n"
                    + "  9. Calculate the appropriate test statistic for hypothesis test by using p^\n"
                    + " 10. Calculate the mean of the differences old ..... - new .....\n\n");

            System.out.print("Enter your command: ");
            int cho = fuck2.nextInt();
            switch(cho) {
                case 1: //ChiSquare
                    Scanner input = new Scanner(System.in);
                    System.out.print("How many row are there?: ");
                    int row = input.nextInt();
                    System.out.print("How many column are there?: ");
                    int column = input.nextInt();
                    //========================End ot the interface========================

                    //=============================fill a table=============================
                    double[][] observedValue = new double[row][column];
                    double sumRow = 0;
                    double sumCol = 0;
                    int[] sRows;
                    ArrayList<Double> summationCol = new ArrayList<>();
                    ArrayList<Double> summationRow = new ArrayList<>();
                    //insert input
                    for(int sad = 0; sad < row; sad++) {
                        for(int sad2 = 0; sad2 < column; sad2++) {
                            observedValue[sad][sad2] = input.nextDouble();
                        }
                    }
                    //Calculates sum of each row of given matrix (horizontal)
                    for(int i = 0; i < row; i++){
                        sumRow = 0;
                        for(int j = 0; j < column; j++){
                            sumRow += observedValue[i][j];
                        }
                        summationRow.add(sumRow);
                    }
                    //Calculates sum of each column of given matrix (vertical)
                    for(int i = 0; i < column; i++){
                        sumCol = 0;
                        for(int j = 0; j < row; j++){
                            sumCol += observedValue[j][i];
                        }
                        summationCol.add(sumCol);
                    }
                    double total = 0;
                    for(int i = 0; i < summationRow.size(); i++) {
                        total += summationRow.get(i);
                    }
                    double xSquare = 0;
                    double[][] expectedValue = new double[row][column];
                    for(int r = 0; r < row; r++) {
                        for(int c = 0; c < column; c++){
                            expectedValue[r][c] = (summationRow.get(r)*summationCol.get(c))/total;
                            xSquare += (Math.pow(expectedValue[r][c]-observedValue[r][c],2))/expectedValue[r][c];
                        }
                    }
                    System.out.print("      ");
                    for(int nCol = 0; nCol <= column; nCol++) {
                        if(nCol==column) {
                            System.out.print(" Total");
                            break;
                        }
                        System.out.print(" Col "+(nCol+1)+"  ");
                    }
                    for(int i = 0; i < row; i++) {
                        System.out.println();
                        for(int j = 0; j < column; j++) {
                            if(j==0) {
                                System.out.print("Row "+(i+1)+" ");
                            } if(observedValue[i][j]>10) {
                                System.out.printf(" %.2f |",observedValue[i][j]);
                            } else {
                                System.out.printf(" %.2f  |",observedValue[i][j]);
                            } if(j==column-1) {
                                System.out.printf(" %.2f",summationRow.get(i));
                            }
                        }
                        System.out.println();
                        System.out.print("      ");
                        for(int k = 0; k < column; k++) {
                            if(expectedValue[i][k]>10) {
                                System.out.printf(" %.2f |",expectedValue[i][k]);
                            } else {
                                System.out.printf(" %.2f  |",expectedValue[i][k]);
                            } if(k==column-1) {
                                System.out.print(" Expected Value");
                            }
                        }
                        System.out.println();
                        System.out.print("      ");
                        for(int m = 0; m < column; m++) {
                            if((Math.pow(expectedValue[i][m]-observedValue[i][m],2))/expectedValue[i][m]>10) {
                                System.out.printf(" %.2f |",(Math.pow(expectedValue[i][m]-observedValue[i][m],2))/expectedValue[i][m]);
                            } else {
                                System.out.printf(" %.2f  |",(Math.pow(expectedValue[i][m]-observedValue[i][m],2))/expectedValue[i][m]);
                            } if(m==column-1) {
                                System.out.print(" pow((E-O),2)/E");
                            }
                        }
                        System.out.println();
                        System.out.print("      ");
                        for(int counter = 0; counter < column; counter++) {
                            System.out.print("_______|");
                        }
                    }
                    System.out.println();
                    System.out.print("Total");
                    for(int i = 0; i < column; i++) {
                        if(summationCol.get(i)>100) {
                            System.out.printf(" %.2f  ",summationCol.get(i));
                        } else {
                            System.out.printf("  %.2f ",summationCol.get(i));
                        }
                    }
                    System.out.printf(" %.2f",total);
                    System.out.println("\n");
                    System.out.println("Degree of Freedom => "+(row-1)*(column-1));
                    System.out.printf("Summation of x^2 => %.4f\n\n",xSquare);
                    ChiSquare img = new ChiSquare("ChiTable.jpg");
                    img.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    img.setVisible(true);
                    img.pack();
                    img.setTitle("Chi Squre Table (Please Consider Donate to James Thx)");
                    InputStream imgStream = ChiSquare.class.getResourceAsStream("pokeball.png");
                    BufferedImage myImg = ImageIO.read(imgStream);

                    img.setIconImage(myImg);
                    break;
                case 2:
                    double std,mean,fromMean,size,S;
                    System.out.println("Please enter std, mean, size, different mean, and confidence level");
                    System.out.print("Enter std: ");
                    Scanner input2 = new Scanner(System.in);
                    std = input2.nextDouble();
                    System.out.print("Enter size: ");
                    size = input2.nextDouble();
                    System.out.print("Enter mean: ");
                    mean = input2.nextDouble();
                    System.out.print("Enter different mean: ");
                    fromMean = input2.nextDouble();
                    System.out.print("Enter significance level (if 5%, just type 5): ");
                    confidence = input2.nextDouble();
                    double temp3 = confidence;
                    System.out.print("\nWhat kind of tail is it\n 1. right-tailed\n 2. left-tailed\n 3. two-tailed\n");
                    System.out.print("Enter your command: ");
                    int tail5 = input2.nextInt();
                    if(tail5==3) {
                        confidence /= 2;
                    }
                    if(size>=30) {
                        if(confidence==5) {
                            setCI(1.645);
                        } else if(confidence==2.5) {
                            setCI(1.96);
                        } else if(confidence==1) {
                            setCI(2.33);
                        } else if(confidence==0.5) {
                            setCI(2.58);
                        }
                        //calculation
                        double testStatistic = (mean-fromMean)/(std/Math.sqrt(size));
                        System.out.printf("\na) Test Statistic => %.5f\n",testStatistic);
                        if(tail5==1) {
                            System.out.printf("b) %.0f percent of significance level => %.3f\n\n",temp3,confidence);
                        } else if(tail5==2) {
                            System.out.printf("b) %.0f percent of significance level => %.3f\n\n",temp3,(confidence*-1));
                        } else if(tail5==3) {
                            System.out.printf("b) %.0f percent of significance level => %.3f\n\n",temp3,confidence);
                        }

                        //img
                        ChiSquare img2 = new ChiSquare("ConfidenceLevel.jpg");
                        img2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        img2.setVisible(true);
                        img2.pack();
                        img2.setTitle("t Table (Please Consider Donate to James Thx)");
                        InputStream imgStream2 = ChiSquare.class.getResourceAsStream("pokeball.png");
                        BufferedImage myImg2 = ImageIO.read(imgStream2);
                        img2.setIconImage(myImg2);
                    } else if(size<30) {

                        System.out.printf("Test Statistic => %.5f\n",((mean-fromMean)/(std/(Math.sqrt(size)))));
                        System.out.printf("b) Degrees of Freedom => %.0f\n",(size-1));
                        if(tail5==1) {
                            System.out.printf("c) %.0f percent of significance level => t(%.3f)\n\n",temp3,(temp3)/100);
                        } else if(tail5==2) {
                            System.out.printf("c) %.0f percent of significance level => t(%.3f)\n\n",temp3,(temp3*-1)/100);
                        } else if(tail5==3) {
                            System.out.printf("c) %.0f percent of significance level => t(%.3f)\n\n",temp3,(temp3/2)/100);
                        }
                        ChiSquare img2 = new ChiSquare("tTable.jpg");
                        img2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        img2.setVisible(true);
                        img2.pack();
                        img2.setTitle("t Table (Please Consider Donate to James Thx)");
                        InputStream imgStream2 = ChiSquare.class.getResourceAsStream("pokeball.png");
                        BufferedImage myImg2 = ImageIO.read(imgStream2);
                        img2.setIconImage(myImg2);
                    }
                    //img
                    break;
                case 3:
                    double power,probability,specificity;
                    System.out.println("Please enter power/sensitivity: ");
                    System.out.print("Enter power: ");
                    Scanner input3 = new Scanner(System.in);
                    power = input3.nextDouble();
                    System.out.println("\nPlease enter probability in percentage.(If the question say 3%, please type only 3): ");
                    System.out.print("Enter probability: ");
                    probability = input3.nextDouble();
                    System.out.println("\nPlease enter specificity: ");
                    System.out.print("Enter specificity: ");
                    specificity = input3.nextDouble();

                    double lawOfProb,ActualProb,fractionProb;
                    fractionProb = probability/100;
                    lawOfProb = (power*fractionProb)+((1-specificity)*(1-fractionProb));
                    ActualProb = (fractionProb*power)/((fractionProb*power)+(1-fractionProb)*(1-specificity));

                    System.out.printf("\na) Use law of the probability, The probability => %.4f",lawOfProb);
                    System.out.printf("\nb) The probability that... really has... => %.4f\n\n",ActualProb);
                    break;
                case 4:
                    double mean1,mean2,sampleSize1,sampleSize2,variance1,variance2;
                    boolean flag = true;
                    Scanner input4 = new Scanner(System.in);
                    System.out.println("Please enter your means: ");
                    System.out.print("Enter mean1(x1):  ");
                    mean1 = input4.nextDouble();
                    System.out.print("Enter mean2(x2):  ");
                    mean2 = input4.nextDouble();
                    System.out.println("\nPlease enter your sample sizes: ");
                    System.out.print("Enter sample size 1(n1):  ");
                    sampleSize1 = input4.nextDouble();
                    System.out.print("Enter sample size 2(n2):  ");
                    sampleSize2 = input4.nextDouble();
                    System.out.println("\nPlease enter your variances: ");
                    System.out.print("Enter variance1(v1):  ");
                    variance1 = input4.nextDouble();
                    System.out.print("Enter variance2(v2):  ");
                    variance2 = input4.nextDouble();
                    //end of input

                    //calculation
                    double sSquare,testStatistic1,dof;
                    sSquare = (((sampleSize1-1)*(variance1))+((sampleSize2-1)*(variance2)))/(sampleSize1+sampleSize2-2);
                    double deno1 = sSquare/sampleSize1;
                    double deno2 = sSquare/sampleSize2;
                    double test = Math.sqrt(deno1+deno2);
                    testStatistic1 = (mean1-mean2)/(test);
                    dof = sampleSize1+sampleSize2-2;
                    System.out.printf("\na) Pooled variance => %.5f\n",sSquare);
                    System.out.printf("b) Appropriate test statistic => %.5f\n",testStatistic1);
                    System.out.printf("c) Degrees of Freedom => %.0f\n\n",dof);

                    //img
                    ChiSquare img3 = new ChiSquare("tTable.jpg");
                    img3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    img3.setVisible(true);
                    img3.pack();
                    img3.setTitle("t Table (Please Consider Donate to James Thx)");
                    InputStream imgStream3 = ChiSquare.class.getResourceAsStream("pokeball.png");
                    BufferedImage myImg3 = ImageIO.read(imgStream3);
                    img3.setIconImage(myImg3);
                    //img
                    break;
                case 5:
                    double meanPhat1,meanPhat2,size1,size2;
                    System.out.println("Please enter mean1 & mean2");
                    System.out.print("Enter mean1: ");
                    Scanner input5 = new Scanner(System.in);
                    meanPhat1 = input5.nextDouble();
                    System.out.print("Enter mean2: ");
                    meanPhat2 = input5.nextDouble();
                    System.out.println("Please enter size1 & size2");
                    System.out.print("Enter size1: ");
                    size1 = input5.nextDouble();
                    System.out.print("Enter size2: ");
                    size2 = input5.nextDouble();

                    double cpHat = (meanPhat1+meanPhat2)/(size1+size2);
                    double pHat1,pHat2;
                    double denominator = cpHat*(1-cpHat)*((1/size1)+(1/size2));
                    pHat1 = meanPhat1/size1;
                    pHat2 = meanPhat2/size2;
                    double approTestStatistic = (pHat1-pHat2)/Math.sqrt(denominator);

                    System.out.printf("\na) Combine samples to calculate p^ => %.5f",cpHat);
                    System.out.printf("\nb) Calculate the appropriate test statistic => %.5f\n\n",approTestStatistic);


                    //img
                    ChiSquare img5 = new ChiSquare("ConfidenceLevel.jpg");
                    img5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    img5.setVisible(true);
                    img5.pack();
                    img5.setTitle("t Table (Please Consider Donate to James Thx)");
                    InputStream imgStream5 = ChiSquare.class.getResourceAsStream("pokeball.png");
                    BufferedImage myImg5 = ImageIO.read(imgStream5);
                    img5.setIconImage(myImg5);
                    //img
                    break;
                case 6:
                    Scanner input10 = new Scanner(System.in);
                    System.out.print("How many sample do we have\n 1. one sample\n 2. two samples\nEnter your command: ");
                    int samChoices = input10.nextInt();
                    if(samChoices==1) {
                        double std1,size10,mean10;
                        System.out.println("Please enter your std, size, mean & confidence");
                        System.out.print("Enter std: ");
                        std1 = input10.nextDouble();
                        System.out.print("Enter size: ");
                        size10 = input10.nextDouble();
                        System.out.print("Enter mean: ");
                        mean10 = input10.nextDouble();
                        System.out.print("Please enter your choices\n 1. Significant\n 2. Confident\nEnter your command: ");
                        int sigOrCon = input10.nextInt();
                        double temp = 0;
                        if(sigOrCon==2) {
                            System.out.print("Enter confident: ");
                            confidence = input10.nextDouble();

                            if(confidence==90) {
                                setCI(1.645);
                                temp = 5;
                            } else if(confidence==95) {
                                setCI(1.96);
                                temp = 2.5;
                            } else if(confidence==98) {
                                setCI(2.33);
                                temp = 1;
                            } else if(confidence==99) {
                                setCI(2.58);
                                temp = 0.5;
                            }
                        } else {
                            System.out.print("Enter significant: ");
                            confidence = input10.nextDouble();
                            System.out.print("\nWhat kind of tail is it\n 1. right-tailed\n 2. left-tailed\n 3. two-tailed\n");
                            System.out.print("Enter your command: ");
                            int tail = input10.nextInt();
                            if(tail==3) {
                                confidence /= 2;
                            }
                            temp = confidence;
                            if(confidence==5) {
                                setCI(1.645);
                            } else if(confidence==2.5) {
                                setCI(1.96);
                            } else if(confidence==1) {
                                setCI(2.33);
                            } else if(confidence==0.5) {
                                setCI(2.58);
                            }
                        }
                        if(size10>=30) {
                            System.out.printf("\nEstimate the mean..., how wide is the range => %.5f ± %.5f",mean10,(confidence)*(std1/Math.sqrt(size10)));
                            System.out.printf("\nInterval range => [%.5f , %.5f]",mean10-((confidence)*(std1/Math.sqrt(size10))),mean10+((confidence)*(std1/Math.sqrt(size10))));
                            System.out.printf("\nDifferent in range, b-a => %.5f\n\n",(mean10+((confidence)*(std1/Math.sqrt(size10))))-(mean10-((confidence)*(std1/Math.sqrt(size10)))));
                        } else if(size10<30){
                            System.out.printf("\nDegrees of Freedom => %.0f\n",(size10-1));
                            System.out.printf("So what is your t(%.3f) value from the t-table?\nEnter t-value: ",(temp/100));
                            double tValue = input10.nextDouble();
                            System.out.printf("Your Margin of Error would be => ± %.5f\n",(tValue*(std1/(Math.sqrt(size10)))));
                            System.out.printf("Interval Range => [%.5f , %.5f]\n\n",mean10-(tValue*(std1/(Math.sqrt(size10)))),mean10+(tValue*(std1/(Math.sqrt(size10)))));

                        }
                    } else if(samChoices==2) {
                        double std1,size10,mean10;
                        double std1_2,size10_2,mean10_2;
                        System.out.println("Please enter your stds, sizes, means & confidence");
                        System.out.print("Enter std1: ");
                        std1 = input10.nextDouble();
                        System.out.print("Enter std2: ");
                        std1_2 = input10.nextDouble();
                        System.out.print("Enter size1: ");
                        size10 = input10.nextDouble();
                        System.out.print("Enter size2: ");
                        size10_2 = input10.nextDouble();
                        System.out.print("Enter mean1: ");
                        mean10 = input10.nextDouble();
                        System.out.print("Enter mean2: ");
                        mean10_2 = input10.nextDouble();
                        System.out.print("Please enter your choices\n 1. Significant\n 2. Confident\nEnter your command: ");
                        int sigOrCon = input10.nextInt();
                        if(sigOrCon==2) {
                            System.out.print("Enter confidence: ");
                            confidence = input10.nextDouble();
                            if(confidence==90) {
                                setCI(1.645);
                            } else if(confidence==95) {
                                setCI(1.96);
                            } else if(confidence==98) {
                                setCI(2.33);
                            } else if(confidence==99) {
                                setCI(2.58);
                            }
                            double temp = (Math.pow(std1,2)/size10)+(Math.pow(std1_2,2)/size10_2);
                            System.out.printf("\nEstimate the mean..., how wide is the range => %.5f ± %.5f",(mean10-mean10_2),(confidence)*(Math.sqrt(temp)));
                            System.out.printf("\nInterval range => [%.5f , %.5f]",(mean10-mean10_2)-((confidence)*(Math.sqrt(temp))),(mean10-mean10_2)+((confidence)*(Math.sqrt(temp))));
                            System.out.printf("\nDifferent in range, b-a => %.5f\n\n",((mean10-mean10_2)+((confidence)*(Math.sqrt(temp)))-((mean10-mean10_2)-((confidence)*(Math.sqrt(temp))))));
                        } else if(sigOrCon==1) {
                            System.out.print("Enter significance: ");
                            confidence = input10.nextDouble();
                            if(confidence==5) {
                                setCI(1.645);
                            } else if(confidence==2.5) {
                                setCI(1.96);
                            } else if(confidence==1) {
                                setCI(2.33);
                            } else if(confidence==0.5) {
                                setCI(2.58);
                            }
                            double temp = ((Math.pow(std1,2)/size10)+(Math.pow(std1_2,2)/size10_2));
                            System.out.printf("\nEstimate the mean..., how wide is the range => %.5f ± %.5f",(mean10-mean10_2),(confidence)*(Math.sqrt(temp)));
                            System.out.printf("\nInterval range => [%.5f , %.5f]",(mean10-mean10_2)-((confidence)*(Math.sqrt(temp))),(mean10-mean10_2)+((confidence)*(Math.sqrt(temp))));
                            System.out.printf("\nDifferent in range, b-a => %.5f\n\n",((mean10-mean10_2)+((confidence)*(Math.sqrt(temp)))-((mean10-mean10_2)-((confidence)*(Math.sqrt(temp))))));
                        }
                    }
                    break;
                case 7:
                    Scanner input11 = new Scanner(System.in);
                    System.out.print("Do you have p^ or not?\n 1. Yes\n 2. No\nEnter your command: ");
                    int choi = input11.nextInt();
                    if(choi==2) {
                        System.out.println("\nPlease enter your x, size, and confidence level");
                        System.out.print("Enter x: ");
                        double x = input11.nextDouble();
                        System.out.print("Enter size: ");
                        double size11 = input11.nextDouble();
                        System.out.print("Enter confidence level: ");
                        double CI2 = input11.nextDouble();
                        if(CI2==90) {
                            CI2 = 1.645;
                        } else if(CI2==95) {
                            CI2 = 1.96;
                        } else if(CI2==98) {
                            CI2 = 2.33;
                        } else if(CI2==99) {
                            CI2 = 2.58;
                        }
                        double sampleProp = x/size11;
                        double test2 = (sampleProp*(1-sampleProp))/size11;
                        double MoE = CI2*Math.sqrt(test2);
                        System.out.printf("\nSample proportion p^ => %.4f\n",sampleProp);
                        System.out.printf("Margin of error => %.4f\n",MoE);
                        System.out.printf("Confidence interval => %.4f ± %.4f => [%.4f , %.4f]\n\n",sampleProp,MoE,sampleProp-MoE,sampleProp+MoE);
                    } else if(choi==1) {
                        System.out.println("\nPlease enter your p^, size, and confidence level");
                        System.out.print("Enter p^ (if it is 43% just type 43) : ");
                        double pHat = input11.nextDouble();
                        System.out.print("Enter size: ");
                        double size11 = input11.nextDouble();
                        System.out.print("Enter confidence level: ");
                        double CI2 = input11.nextDouble();
                        if(CI2==90) {
                            CI2 = 1.645;
                        } else if(CI2==95) {
                            CI2 = 1.96;
                        } else if(CI2==98) {
                            CI2 = 2.33;
                        } else if(CI2==99) {
                            CI2 = 2.58;
                        }
                        double sampleProp = pHat/100;
                        double test2 = (sampleProp*(1-sampleProp))/size11;
                        double MoE = CI2*Math.sqrt(test2);
                        System.out.printf("\nSample proportion p^ => %.5f\n",sampleProp);
                        System.out.printf("Margin of error => %.5f\n",MoE);
                        System.out.printf("Confidence interval => %.5f ± %.5f => [%.5f , %.5f]\n",sampleProp,MoE,sampleProp-MoE,sampleProp+MoE);
                        System.out.printf("b-a => %.5f\n\n",(sampleProp+MoE)-(sampleProp-MoE));
                    }
                    break;
                case 8:
                    Scanner hypo = new Scanner(System.in);
                    System.out.println("Please enter sizes, means, stds and significant value");
                    System.out.print("Enter size1: ");
                    double size8 = hypo.nextDouble();
                    System.out.print("Enter size2: ");
                    double size8_2 = hypo.nextDouble();
                    System.out.print("Enter mean1: ");
                    double mean8 = hypo.nextDouble();
                    System.out.print("Enter mean2: ");
                    double mean8_2 = hypo.nextDouble();
                    System.out.print("Enter std1: ");
                    double std8 = hypo.nextDouble();
                    System.out.print("Enter std2: ");
                    double std8_2 = hypo.nextDouble();
                    System.out.print("Enter significant (if 5%, just type 5): ");
                    confidence = hypo.nextDouble();
                    double temp2 = confidence;
                    System.out.print("\nWhat kind of tail is it\n 1. right-tailed\n 2. left-tailed\n 3. two-tailed\n");
                    System.out.print("Enter your command: ");
                    int tail = hypo.nextInt();
                    if(tail==3) {
                        confidence /= 2;
                    }
                    if(confidence==5) {
                        setCI(1.645);
                    } else if(confidence==2.5) {
                        setCI(1.96);
                    } else if(confidence==1) {
                        setCI(2.33);
                    } else if(confidence==0.5) {
                        setCI(2.58);
                    }
                    double temp = ((Math.pow(std8,2)/size8)+(Math.pow(std8_2,2)/size8_2));
                    System.out.printf("a) Test Statistic => %.5f\n",((mean8-mean8_2)/Math.sqrt(temp)));
                    if(tail==1) {
                        System.out.printf("b) %.0f percent of significant => (right tailed) %.3f\n\n",temp2,confidence);
                    } else if(tail==2) {
                        System.out.printf("b) %.0f percent of significant => (left tailed) %.3f\n\n",temp2,(confidence*-1));
                    } else if(tail==3) {
                        System.out.printf("b) %.0f percent of significant => (two tailed) %.3f\n\n",temp2,confidence);
                    }
                    break;
                case 9:
                    Scanner pZero = new Scanner(System.in);
                    System.out.println("Please enter p(zero), x, size, and significance level");
                    System.out.print("Enter p(zero) (if 5%, just type 5): ");
                    double p = pZero.nextDouble();
                    System.out.print("Enter x (have this problem): ");
                    double x55 = pZero.nextDouble();
                    System.out.print("Enter size: ");
                    double size55 = pZero.nextDouble();
                    System.out.print("Enter significant: ");
                    confidence = pZero.nextDouble();
                    double temp4 = confidence;
                    System.out.print("\nWhat kind of tail is it\n 1. right-tailed\n 2. left-tailed\n 3. two-tailed\n");
                    System.out.print("Enter your command: ");
                    int tail55 = pZero.nextInt();
                    if(tail55==3) {
                        confidence /= 2;
                    }
                    if(confidence==5) {
                        setCI(1.645);
                    } else if(confidence==2.5) {
                        setCI(1.96);
                    } else if(confidence==1) {
                        setCI(2.33);
                    } else if(confidence==0.5) {
                        setCI(2.58);
                    }
                    double z = ((x55/size55)-(p/100))/(Math.sqrt((p*(1-(p/100)))/size55));
                    System.out.printf("a) Test Statistic => %.5f\n",z*10);
                    System.out.printf("b) %.0f percent of significant => %.3f\n\n",temp4,confidence);
                    break;
                case 10:
                    Scanner shoes = new Scanner(System.in);
                    System.out.print("\nHow many samples are there?\nEnter rows: ");
                    int rowShoes = shoes.nextInt();
                    System.out.print("Enter columns: ");
                    int colShoes = shoes.nextInt();
                    System.out.print("Enter significant (if 5%, just type 5): ");
                    double sig66 = shoes.nextDouble();
                    double[][] arrayAgain = new double[rowShoes][colShoes];
                    for(int i = 0; i < arrayAgain.length; i++) {
                        if(i==0) {
                            System.out.printf("Enter %d old ones first\n",colShoes);
                        } else {
                            System.out.printf("Now, enter %d new ones\n",colShoes);
                        }
                        for(int j = 0; j < arrayAgain[i].length; j++) {
                            if(i==0) {
                                System.out.print("Old.. number "+(j+1)+": ");
                            } else {
                                System.out.print("New.. number "+(j+1)+": ");
                            }
                            arrayAgain[i][j] = shoes.nextDouble();
                        }
                    }
                    ArrayList<Double> sumCol2 = new ArrayList<>();
                    double sumCol5;
                    for(int k = 0; k < colShoes; k++){
                        sumCol5 = 0;
                        for(int j = 0; j < rowShoes;){
                            sumCol5 = (arrayAgain[j][k]-arrayAgain[j+1][k]);
                            break;
                        }
                        sumCol2.add(sumCol5);
                    }
                    //System.out.println(sumCol2);
                    double sumDif = 0,difAvg;
                    for(int i = 0; i < sumCol2.size(); i++) {
                        sumDif += sumCol2.get(i);
                    }
                    difAvg = sumDif/colShoes;
                    double squareDif = 0;
                    for(int i = 0; i < sumCol2.size(); i++) {
                        squareDif += Math.pow(sumCol2.get(i),2);
                    }
                    double stdDif = Math.sqrt((squareDif-(Math.pow(sumDif,2)/colShoes))/(colShoes-1));
                    System.out.printf("a) The mean difference => %.5f\n",difAvg);
                    System.out.printf("b) The standard deviation of difference => %.5f\n",stdDif);
                    System.out.printf("c) Test Statistic => %.5f\n",((difAvg-0)/((stdDif)/Math.sqrt(colShoes))));
                    System.out.printf("d) Degrees of Freedom => %d\n",(colShoes-1));
                    System.out.printf("e) t(%.3f) at Degrees of Freedom = %d\n\n",(sig66/100),(colShoes-1));
            }

        }

    }
    public static void setCI(double confidence) {
        ChiSquare.confidence = confidence;
    }
}


//import java.awt.FlowLayout;
//import java.awt.Image;
//import java.awt.image.BufferedImage;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//
//public class ChiSquare extends JFrame{
//    private ImageIcon image1;
//    private JLabel label1;
//    private static boolean GetOut = false;
//    ChiSquare(){
//        setLayout(new FlowLayout());
//        image1 = new ImageIcon(getClass().getResource("ChiTable.jpg"));
//        label1 = new JLabel(image1);
//        add(label1);
//    }
//    public static void main(String[] agrs) throws IOException {
//        //=============================interface=============================
//        boolean fuck = true;
//        while(fuck && GetOut == false) {
//            System.out.println("\n=== === === === === === Chi square === === === === === ===");
//            Scanner input = new Scanner(System.in);
//            System.out.print("How many row are there?: ");
//            int row = input.nextInt();
//            System.out.print("How many column are there?: ");
//            int column = input.nextInt();
//            System.out.println();
//            //========================End ot the interface========================
//
//            //=============================fill a table=============================
//            double[][] observedValue = new double[row][column];
//            double sumRow = 0;
//            double sumCol = 0;
//            int[] sRows;
//            ArrayList<Double> summationCol = new ArrayList<>();
//            ArrayList<Double> summationRow = new ArrayList<>();
//            //insert input
//            for(int currentRow = 0; currentRow < row; currentRow++) {
//                for(int currentColumn = 0; currentColumn < column; currentColumn++) {
//                    System.out.print("Input your number in Row "+ (currentRow+1) + ", Column "+ (currentColumn+1) +" : ");
//                    observedValue[currentRow][currentColumn] = input.nextDouble();
//                }
//                System.out.println();
//            }
//            GetOut = true;
//            //Calculates sum of each row of given matrix (horizontal)
//            for(int i = 0; i < row; i++){
//                sumRow = 0;
//                for(int j = 0; j < column; j++){
//                    sumRow += observedValue[i][j];
//                }
//                summationRow.add(sumRow);
//            }
//            //Calculates sum of each column of given matrix (vertical)
//            for(int i = 0; i < column; i++){
//                sumCol = 0;
//                for(int j = 0; j < row; j++){
//                    sumCol += observedValue[j][i];
//                }
//                summationCol.add(sumCol);
//            }
//            double total = 0;
//            for(int i = 0; i < summationRow.size(); i++) {
//                total += summationRow.get(i);
//            }
//            double xSquare = 0;
//            double[][] expectedValue = new double[row][column];
//            for(int r = 0; r < row; r++) {
//                for(int c = 0; c < column; c++){
//                    expectedValue[r][c] = (summationRow.get(r)*summationCol.get(c))/total;
//                    xSquare += (Math.pow(expectedValue[r][c]-observedValue[r][c],2))/expectedValue[r][c];
//                }
//            }
//            System.out.print("      ");
//            for(int nCol = 0; nCol <= column; nCol++) {
//                if(nCol==column) {
//                    System.out.print(" Total");
//                    break;
//                }
//                System.out.print(" Col "+(nCol+1)+"  ");
//            }
//            for(int i = 0; i < row; i++) {
//                System.out.println();
//                for(int j = 0; j < column; j++) {
//                    if(j==0) {
//                        System.out.print("Row "+(i+1)+" ");
//                    } if(observedValue[i][j]>10) {
//                        System.out.printf(" %.2f |",observedValue[i][j]);
//                    } else {
//                        System.out.printf(" %.2f  |",observedValue[i][j]);
//                    } if(j==column-1) {
//                        System.out.printf(" %.2f",summationRow.get(i));
//                    }
//                }
//                System.out.println();
//                System.out.print("      ");
//                for(int k = 0; k < column; k++) {
//                    if(expectedValue[i][k]>10) {
//                        System.out.printf(" %.2f |",expectedValue[i][k]);
//                    } else {
//                        System.out.printf(" %.2f  |",expectedValue[i][k]);
//                    } if(k==column-1) {
//                        System.out.print(" <- Expected Value");
//                    }
//                }
//                System.out.println();
//                System.out.print("      ");
//                for(int m = 0; m < column; m++) {
//                    if((Math.pow(expectedValue[i][m]-observedValue[i][m],2))/expectedValue[i][m]>10) {
//                        System.out.printf(" %.2f |",(Math.pow(expectedValue[i][m]-observedValue[i][m],2))/expectedValue[i][m]);
//                    } else {
//                        System.out.printf(" %.2f  |",(Math.pow(expectedValue[i][m]-observedValue[i][m],2))/expectedValue[i][m]);
//                    } if(m==column-1) {
//                        System.out.print(" <- pow((E-O),2)/E");
//                    }
//                }
//                System.out.println();
//                System.out.print("      ");
//                for(int counter = 0; counter < column; counter++) {
//                    System.out.print("_______|");
//                }
//                System.out.println();
//            }
//            System.out.print("Total");
//            for(int i = 0; i < column; i++) {
//                if(summationCol.get(i)>100) {
//                    System.out.printf("  %.2f  ",summationCol.get(i));
//                } else {
//                    System.out.printf("   %.2f ",summationCol.get(i));
//                }
//            }
//            System.out.printf(" %.2f",total);
//            System.out.println("\n");
//            System.out.println("Degree of Freedom => "+(row-1)*(column-1));
//            System.out.printf("Summation of x^2 => %.4f ",xSquare);
//            ChiSquare img = new ChiSquare();
//            img.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            img.setVisible(true);
//            img.pack();
//            img.setTitle("Chi Squre Table (Please Consider Donate to James Thx)");
//            InputStream imgStream = ChiSquare.class.getResourceAsStream("pokeball.png");
//            BufferedImage myImg = ImageIO.read(imgStream);
//
//            img.setIconImage(myImg);
//        }
//    }
//}
