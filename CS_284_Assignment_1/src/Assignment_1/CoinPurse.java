package Assignment_1;

public class CoinPurse {
	
	private int numGalleons;
	private int numSickles;
	private int numKnuts;
	private static final int CAPACITY = 256;
	
	
	public CoinPurse() {
		numGalleons = 0;
		numSickles = 0;
		numKnuts = 0;
	}
	
	
	public CoinPurse(int g, int s, int k) {
		if (g + s + k > CAPACITY) {
			throw new IllegalArgumentException("You can't put more than 256 coins in your coinpurse!");
		}
		else {
			if (g >= 0) {
				this.numGalleons = g;
			}
			else {
				throw new IllegalArgumentException("You can't have less than 0 Galleons!");
			}
			
			if (s >= 0) {
				this.numSickles = s;
			}
			else {
				throw new IllegalArgumentException("You can't have less than 0 Sickles!");
			}
			
			if (k >= 0) {
				this.numKnuts = k;
			}
			else {
				throw new IllegalArgumentException("You can't have less than 0 Knuts!");
			}		
		}
	}
	
	
	public void depositGalleons(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("You can't deposit a negative amount of Galleons!");
		}
		else {
			if (numGalleons + numSickles + numKnuts + n <= CAPACITY) {
				numGalleons += n;
			}
			else {
				throw new IllegalArgumentException("You can't have more than 256 coins in a coinpurse!");
			}
		}
	}
	
	
	public void depositSickles(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("You can't deposit a negative amount of Sickles!");
		}
		else {
			if (numGalleons + numSickles + numKnuts + n <= CAPACITY) {
				numSickles += n;
			}
			else {
				throw new IllegalArgumentException("You can't have more than 256 coins in a coinpurse!");
			}
		}
	}
	
	
	public void depositKnuts(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("You can't deposit a negative amount of Knuts!");
		}
		else {
			if (numGalleons + numSickles + numKnuts + n <= CAPACITY) {
				numKnuts += n;
			}
			else {
				throw new IllegalArgumentException("You can't have more than 256 coins in a coinpurse!");
			}
		}
	}
	
	
	public void withdrawGalleons(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("You can't withdraw a negative amount of Galleons!");
		}
		else {
			if (numGalleons - n >= 0) {
				numGalleons -= n;
			}
			else {
				throw new IllegalArgumentException("You can't withdraw more Galleons than you have!");
			}
		}
	}
	
	
	public void withdrawSickles(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("You can't withdraw a negative amount of Sickles!");
		}
		else {
			if (numSickles - n >= 0) {
				numSickles -= n;
			}
			else {
				throw new IllegalArgumentException("You can't withdraw more Sickles than you have!");
			}
		}
	}
	
	
	public void withdrawKnuts(int n) {
		if (n < 0) {
			throw new IllegalArgumentException("You can't withdraw a negative amount of Knuts!");
		}
		else {
			if (numKnuts - n >= 0) {
				numKnuts -= n;
			}
			else {
				throw new IllegalArgumentException("You can't withdraw more Knuts than you have!");
			}
		}
	}
	
	
	public int numCoins() {
		return numGalleons + numSickles + numKnuts;
	}
	
	
	public int totalValue() {
		return (numGalleons * 493) + (numSickles * 29) + numKnuts;
	}
	
	
	public boolean exactChange(int n) {
		int galleon = numGalleons;
		int sickle = numSickles;
		int knut = numKnuts;
		
		for (int i = 0; i < numGalleons; i++) {
			if (n == 0) {
				break;
			}
			else {
				if (galleon == 0) {
					break;
				}
				else {
					if (n - 493 < 0) {
						break;
					}
					else {
						n -= 493;
						galleon -= 1;
					}
				}
			}
		}
		
		for (int i = 0; i < numSickles; i++) {
			if (n == 0) {
				break;
			}
			else {
				if (sickle == 0) {
					break;
					}
				else {
					if (n - 29 < 0) {
						break;
					}
					else {
						n -= 29;
						sickle -= 1;
					}	
				}
			}
		}
		
		for (int i = 0; i < numKnuts; i++) {
			if (n == 0) {
				break;
			}
			else {
				if (knut == 0) {
					break;
					}
				else { //no need to check like others since it only subtracts 1 and checks for 0 before doing so
					n -= 1;
					knut -= 1;
				}
			}
		}
		
		if (n == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int[] withdraw(int n) {
		int gCount = numGalleons;
		int sCount = numSickles;
		int kCount = numKnuts;
		boolean change = exactChange(n);
		int total = totalValue();
		int muchAsPoss = 0;
		int[] withdrawCoins = {0, 0, 0};
		
		if (change == true) {
			for (int i = 0; i < gCount; i++) {
				if (n == 0) {
					break;
				}
				else {
					if (numGalleons == 0) {
						break;
					}
					else {
						if (n - 493 < 0) {
							break;
						}
						else {
							n -= 493;
							numGalleons -= 1;
							withdrawCoins[0] += 1;
						}
					}
				}	
			}
			
			for (int i = 0; i < sCount; i++) {
				if (n == 0) {
					break;
				}
				else {
					if (numSickles == 0) {
						break;
					}
					else {
						if (n - 29 < 0) {
							break;
						}
						else {
							n -= 29;
							numSickles -= 1;
							withdrawCoins[1] += 1;
						}
					}
				}
			}
			
			for (int i = 0; i < kCount; i++) {
				if (n == 0) {
					break;
				}
				else {
					if (numKnuts == 0) {
						break;
					}
					else { //no need to check like others since it only subtracts 1 and checks for 0 before doing so
						n -= 1;
						numKnuts -= 1;
						withdrawCoins[2] += 1;
					}
				}
			}
			return withdrawCoins;
		}
		else {	
			if (total < n) {
				throw new IllegalArgumentException("You can't withdraw a higher value than the total in your coinpurse!");
				}
			else {
				int m = n;
				int o = n;
				boolean moveOn = false;
				while (moveOn == false) {
					for (int i = 0; i < gCount; i++) {
						if (n == 0) {
							break;
						}
						else {
							if (numGalleons == 0) {
								break;
							}
							else {
								if (n - 493 < 0) {
									break;
								}
								else {
									n -= 493;
									muchAsPoss += 493;
									numGalleons -= 1;
									withdrawCoins[0] += 1;
								}
							}
						}
					}
				
					for (int i = 0; i < sCount; i++) {
						if (n == 0) {
							break;
						}
						else {
							if (numSickles == 0) {
								break;
							}
							else {
								if (n - 29 < 0) {
									break;
								}
								else {
									n -= 29;
									muchAsPoss += 29;
									numSickles -= 1;
									withdrawCoins[1] += 1;
								}
							}
						}
					}
				
					for (int i = 0; i < kCount; i++) {
						if (n == 0) {
							break;
						}
						else {
							if (numKnuts == 0) {
								break;
							}
							else { //no need to check like others since it only subtracts 1 and checks for 0 before doing so
								n -= 1;
								muchAsPoss += 1;
								numKnuts -= 1;
								withdrawCoins[2] += 1;
							}
						}
					}
				
					if (muchAsPoss > m) {
						if (n == 0) {
							moveOn = true;
						}
						else {
							numGalleons = gCount;
							numSickles = sCount;
							numKnuts = kCount;
							muchAsPoss = 0;
							withdrawCoins[0] = 0;
							withdrawCoins[1] = 0;
							withdrawCoins[2] = 0;
							o++;
							n = o; 
						}
					}
					else {
						numGalleons = gCount;
						numSickles = sCount;
						numKnuts = kCount;
						muchAsPoss = 0;
						withdrawCoins[0] = 0;
						withdrawCoins[1] = 0;
						withdrawCoins[2] = 0;
						o++;
						n = o;
					}	
				}
				
				System.out.println("Insufficient change, the closest possible change is " + muchAsPoss);
				return withdrawCoins;
			}
		}
	}
	
	public int drawRandCoin() {
		int totalCoins = numGalleons + numSickles + numKnuts;
		
		if (totalCoins == 0) {
			throw new IllegalArgumentException("You can't randomly choose from zero coins!");
		}
		else {
			int coin = 1 + (int)(Math.random() * totalCoins);
			
			if (coin <= numKnuts) {
				return 0;
			}
			else if (coin <= numKnuts + numSickles) {
				return 1;
			}
			else if (coin <= numKnuts + numSickles + numGalleons) {
				return 2;
			}
			else {
				throw new IllegalArgumentException("This shouldn't be possible! (Randomly chose from more coins than exist in the coinpurse)");
			}
		}
	}
	
	
	public int[] drawRandSequence(int n) {
		int[] seq = new int[n];
		int i = 0;
		int totalCoins = numGalleons + numSickles + numKnuts;
		
		if (totalCoins == 0) {
			throw new IllegalArgumentException("You can't randomly choose from zero coins!");
		}
		else {
			while (i < n) {
				int coin = 1 + (int)(Math.random() * totalCoins);
				
				if (coin <= numKnuts) {
					seq[i] = 0;
				}
				else if (coin <= numKnuts + numSickles) {
					seq[i] = 1;
				}
				else if (coin <= numKnuts + numSickles + numGalleons) {
					seq[i] = 2;
				}
				else {
					throw new IllegalArgumentException("This shouldn't be possible! (Randomly chose from more coins than exist in the coinpurse)");
				}
				
				i++;
			}
		}
		return seq;
	}
	
	
	public static int compareSequences(int[] coinSeq1, int[] coinSeq2) {
		int oneCount = 0;
		int negativeOneCount = 0;
		
		if (coinSeq1.length != coinSeq2.length) {
			throw new IllegalArgumentException("Cannot compare these sequences, they are not the same length!");
		}
		else {
			for (int i = 0; i < coinSeq1.length; i++) {
				if (coinSeq1[i] > coinSeq2[i]) {
					oneCount++;
				}
				else if (coinSeq1[i] < coinSeq2[i]) {
					negativeOneCount++;
				}
			}
			
			if (oneCount > negativeOneCount) {
				return 1;
			}
			else if (negativeOneCount > oneCount) {
				return -1;
			}
			else {
				return 0;
			}
		}

	}
	
	
	public int[] drawRandSequenceNoRepl(int n) {
		int[] seq = new int[n];
		int i = 0;
		int totalCoins = numGalleons + numSickles + numKnuts;
		int tempGalleons = numGalleons; //temporary storage of variables so updated values can appear, but all coins get "returned" by the end (never left technically)
		int tempSickles = numSickles;
		int tempKnuts = numKnuts;
		
		if (totalCoins == 0) {
			throw new IllegalArgumentException("You can't randomly choose from zero coins!");
		}
		else if (totalCoins - n < 0) {
			throw new IllegalArgumentException("You can't randomly choose more coins than you have!");
		}
		else {
			while (i < n) {
				int coin = 1 + (int)(Math.random() * totalCoins);
				
				if (coin <= tempKnuts) {
					seq[i] = 0;
					tempKnuts--;
					totalCoins--;
				}
				else if (coin <= tempKnuts + tempSickles) {
					seq[i] = 1;
					tempSickles--;
					totalCoins--;
				}
				else if (coin <= tempKnuts + tempSickles + tempGalleons) {
					seq[i] = 2;
					tempGalleons--;
					totalCoins--;
				}
				else {
					throw new IllegalArgumentException("This shouldn't be possible! (Randomly chose from more coins than exist in the coinpurse)");
				}
				
				i++;
			}
		}
		return seq;
	}
	
	
	public String toString() {
		return "This coinpurse has " + numGalleons + " Galleons, " + numSickles + " Sickles, and " + numKnuts + " Knuts.";
	}
	
	public static void main(String[] args) {
	}

}