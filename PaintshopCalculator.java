package programmingProject3;

import java.text.DecimalFormat;

/**
 * Computes the amount of paint needed to paint a room
 */

public class PaintShopCalculator {

	// Constants
	// Prices of the paint containers in dollars
	public final double FIVEGALLONS = 124.00;

	public final double ONEGALLON = 25.10;

	public final double HALFGALLON = 13.00;

	public final double QUART = 6.70;

	public final double PINT = 3.95;

	public final double HALFPINT = 2.25;

	// Area that can be painted with one gallon of paint (in square inches)
	public final double AREA_PER_GALLON = 25000.0;
	
	private int heightFeet, heightInches, lengthFeet, lengthInches, widthFeet, widthInches;
	private int fiveGallonCount, oneGallonCount, halfGallonCount, quartCount, pintCount,halfPintCount;

	/**
	 * Initializes this PaintShopCalculator with the room measurements. For example,
	 * if the height is 10'2'', heightFeet is 10 and heightInches is 2.
	 * 
	 * @param heightFeet   the number of feet of the height measurement
	 * @param heightInches the number of inches of the height measurement
	 * @param widthFeet    the number of feet of the width measurement
	 * @param widthInches  the number of inches of the width measurement
	 * @param lengthFeet   the number of feet of the length measurement
	 * @param lengthInches the number of inches of the length measurement
	 */
	public PaintShopCalculator(int heightFeet, int heightInches, int lengthFeet, int lengthInches, int widthFeet,
			int widthInches) {
		this.heightFeet = heightFeet;
        this.heightInches = heightInches;
        this.lengthFeet = lengthFeet;
        this.lengthInches = lengthInches;
        this.widthFeet = widthFeet;
        this.widthInches = widthInches;
	}
	
	private double totalPaintNeeded() {
		double totalArea = calculateTotalArea();
		return totalArea / AREA_PER_GALLON;
	}
	
	private double calculateTotalArea() {
		double hInches = heightFeet * 12 + heightInches;
        double lInches = lengthFeet * 12 + lengthInches;
        double wInches = widthFeet * 12 + widthInches;
        return 2*hInches * wInches + 2*hInches * lInches + lInches * wInches;
	}
	private void containersNeeded(double gallonsNeeded) {
	    fiveGallonCount = (int) (gallonsNeeded / 5);
	    gallonsNeeded = gallonsNeeded % 5;

	    oneGallonCount = (int) (gallonsNeeded / 1);
	    gallonsNeeded = gallonsNeeded % 1;

	    halfGallonCount = (int) (gallonsNeeded / 0.5);
	    gallonsNeeded = gallonsNeeded % 0.5;

	    quartCount = (int) (gallonsNeeded / 0.25);
	    gallonsNeeded = gallonsNeeded % 0.25;

	    pintCount = (int) (gallonsNeeded / 0.125);
	    gallonsNeeded = gallonsNeeded % 0.125;

	    halfPintCount = (int) (gallonsNeeded / 0.0625);

	    if (gallonsNeeded > 0) {
	        halfPintCount ++;
	    }
	}

	private double calculateTotalPrice() {
	    containersNeeded(totalPaintNeeded());

	    double totalPrice = fiveGallonCount * FIVEGALLONS
	            + oneGallonCount * ONEGALLON
	            + halfGallonCount * HALFGALLON
	            + quartCount * QUART
	            + pintCount * PINT
	            + halfPintCount * HALFPINT;

	    return totalPrice;
	}


    public String toString() {
        double gallonsNeeded = totalPaintNeeded();
        containersNeeded(gallonsNeeded);
        double totalPrice = calculateTotalPrice();

        DecimalFormat decimalFormat = new DecimalFormat("0.000");
        StringBuilder sb = new StringBuilder();
        sb.append("For this job, you need ")
                .append(decimalFormat.format(gallonsNeeded))
                .append(" gallons of paint.\n")
                .append("You will need to purchase:\n");
                
        
        
        if (fiveGallonCount == 0) {
            sb.append("");
        } else if(fiveGallonCount == 1) {
        	sb.append("\t").append(fiveGallonCount).append(" five-gallon container");
        	sb.append("\n");
        } else {
        	sb.append("\t").append(oneGallonCount).append(" one-gallon containers");
        	sb.append("\n");
        }
        
      
        
        if (oneGallonCount == 0) {
            sb.append("");
        } else if(oneGallonCount == 1) {
        	sb.append("\t").append(oneGallonCount).append(" one-gallon container");
        	sb.append("\n");
        } else {
        	sb.append("\t").append(oneGallonCount).append(" one-gallon containers");
        	sb.append("\n");
        }
        

        
        if (halfGallonCount == 0) {
            sb.append("");
        } else if(halfGallonCount == 1) {
        	sb.append("\t").append(halfGallonCount).append(" half-gallon container");
        	sb.append("\n");
        } else {
        	sb.append("\t").append(halfGallonCount).append(" half-gallon containers");
        	sb.append("\n");
        }

       
        if (quartCount == 0) {
            sb.append("");
        } else if(quartCount == 1) {
        	sb.append("\t").append(quartCount).append(" one-quart container");
        	sb.append("\n");
        } else {
        	sb.append("\t").append(quartCount).append(" one-quart containers");
        	sb.append("\n");
        }
        
        
        if (pintCount == 0) {
            sb.append("");
        } else if(pintCount == 1) {
        	sb.append("\t").append(pintCount).append(" one-pint container");
        	sb.append("\n");
        } else {
        	sb.append("\t").append(pintCount).append(" one-pint containers");
        	sb.append("\n");
        }

        
        if (halfPintCount == 0) {
            sb.append("");
        } else if(halfPintCount == 1) {
        	sb.append("\t").append(halfPintCount).append(" one-half-pint container");
        	sb.append("\n");
        } else {
        	sb.append("\t").append(halfPintCount).append(" one-half-pint containers");
        	sb.append("\n");
        }
               
       
        
        sb.append("\n\n");
        
        
        sb.append("\n\n");


        sb.append("Price without discount:\n")
                .append("\tYour total is $").append(String.format("%.2f", totalPrice)).append("\n\n");

        // Check if a discount is applicable
        int cents = (int) (Math.round(totalPrice * 100) % 100);
        StringBuilder discountedContainer = new StringBuilder();
        if (cents % 5 == 0 && cents % 2 == 1 && cents % 10 != 0) {
        	double discountedPrice = totalPrice;
            if (fiveGallonCount > 0) {
                discountedPrice -= FIVEGALLONS;
                int lengthOfStr = discountedContainer.length();
                discountedContainer.delete(0,lengthOfStr);
                discountedContainer.append("five-gallons container");
            } else if (oneGallonCount > 0) {
                discountedPrice -= ONEGALLON;
                int lengthOfStr = discountedContainer.length();
                discountedContainer.delete(0,lengthOfStr);
                discountedContainer.append("one-gallon container");
            } else if (halfGallonCount > 0) {
                discountedPrice -= HALFGALLON;
                int lengthOfStr = discountedContainer.length();
                discountedContainer.delete(0,lengthOfStr);
                discountedContainer.append("half-gallon container");
            } else if (quartCount > 0) {
                discountedPrice -= QUART;
                int lengthOfStr = discountedContainer.length();
                discountedContainer.delete(0,lengthOfStr);
                discountedContainer.append("one-quart container");
            } else if (pintCount > 0) {
                discountedPrice -= PINT;
                int lengthOfStr = discountedContainer.length();
                discountedContainer.delete(0,lengthOfStr);
                discountedContainer.append("one-pint container");
            } else if (halfPintCount > 0) {
                discountedPrice -= HALFPINT;
                int lengthOfStr = discountedContainer.length();
                discountedContainer.delete(0,lengthOfStr);
                discountedContainer.append("one-half-pint container");
            
            
            }
            sb.append("However, because the amount of cents (").append(cents)
            .append("c)\nin the cost is odd and divisble by 5,")
            .append("\nyou get 1 ").append(discountedContainer).append(" for free!\n\n");
            sb.append("Price with discount:\n")
            .append("\tYour total is $").append(String.format("%.2f", discountedPrice)).append("\n\n");
            
        } else {
        	sb.append("Because the amount of cents (").append(cents).append("c) in the cost\n")
            .append("is not odd and divisible by 5, no discount is\n")
            .append("applied.\n");
            
        
			
        }

        sb.append("\tThank you for your business!");

        return sb.toString();
    }}

	/**
	 * Returns as a string the result of the computation. The string should list the
	 * exact amount of paint needed (with 3 digits after the decimal point), the
	 * number and type of paint containers needed, and the price (with 2 digits
	 * after the decimal point). Pay attention to the spelling (container versus
	 * containers) and the quality of the output (no 0 one gallon container).
	 * 
	 * Here is an example with height=7'3'', length=20'4'' and width=18'7'':
	 * 
	 * <pre>
		For this job, you need 5.427 gallons of paint.
		You will need to purchase
			1 five-gallon container
			1 one-quart container
			1 one-pint container
			1 one-half-pint container
		
		Because the amount of cents (90c) in the cost
		is not odd and divisible by 5, no discount is
		applied.
		
			Your total is $136.90
			
			Thank you for your business!
	 * </pre>
	 */

