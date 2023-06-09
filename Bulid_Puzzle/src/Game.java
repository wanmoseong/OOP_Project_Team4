import java.util.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JPanel {

	private static final long serialVersionUID = 1L;
	private int puzzleSize = 0;
	private int row = 0;
	private ArrayList xList = new ArrayList();
	private ArrayList picList = new ArrayList();
	private int emptyX = 0;
	private int emptyY = 0;
	private int moveX = -1;
	private int moveY = -1;
	private int movePositionX = 0;
	private int movePositionY = 0;
	private String empty = "-1";
	private Game picPanel;
	private int count = 0;
	private int rowSize = 0;
	private int seconds;
	private TimerRunnable sec = new TimerRunnable();
	private Thread time = new Thread(sec);
	private TimerLabel timer ;
	public boolean stop = false;
	private int level;
	
	public Game(int frameSize, int intiCount, String ImagePath, TimerLabel tl, int level) {
		this.timer = tl;
		this.level = level;
		
		picPanel = this;
		frameSize -= 50;
		setPreferredSize(new Dimension(frameSize + 2, frameSize + 2));
		row = intiCount;
		puzzleSize = frameSize / row;
		ArrayList yList;
		try {
			BufferedImage image = ImageIO.read(new File(ImagePath));
			int imageWidth = image.getWidth();
			int imageHeight = image.getHeight();
			int imageBeginX = 0;
			int imageBeginY = 0;
			int imageSize = 0;
			if (imageWidth > imageHeight) {
				imageBeginX = (imageWidth - imageHeight) / 2;
				imageSize = imageHeight / row;
			} else {
				imageBeginY = (imageHeight - imageWidth) / 2;
				imageSize = imageWidth / row;
			}

			for (int x = 0; x < row; x++) {
				yList = new ArrayList();
				for (int y = 0; y < row; y++) {
					if (x + 1 == row && y + 1 == row) {
						emptyX = x;
						emptyY = y;
						yList.add(empty);
					} else {
						picList.add(image.getSubimage(y * imageSize + imageBeginX, x * imageSize + imageBeginY,
								imageSize, imageSize));
						// System.out.println("-"+rowSize+"-"); //컴파일용
						yList.add(Integer.toString(rowSize++));

					}
				}
				xList.add(yList);
			}

			while (true) {
				int arr[] = new int[row * row - 1];

				int changeY1;
				int changeY2;
				int changeX1;
				int changeX2;
				String temp1;
				String temp2;
				Random rand = new Random();

				for (int x = 0; x < row * row; x++) {
					changeX1 = rand.nextInt(row);
					changeY1 = rand.nextInt(row);

					if (changeX1 == emptyX && changeY1 == emptyY) {
						changeX1--;
					}

					changeX2 = rand.nextInt(row);
					changeY2 = rand.nextInt(row);
					if (changeX2 == emptyX && changeY2 == emptyY) {
						changeY2--;
					}

					temp1 = (String)((ArrayList) xList.get(changeX1)).get(changeY1);
					temp2 = (String) ((ArrayList) xList.get(changeX2)).get(changeY2);
					((ArrayList) xList.get(changeX2)).set(changeY2, temp1);
					((ArrayList) xList.get(changeX1)).set(changeY1, temp2);

				}
				int cnt = 0;
				for (int i = 0; i < row; i++) {
				    ArrayList<String> sublist = (ArrayList<String>) xList.get(i);
				    for (int j = 0; j < row; j++) {
				        String element = sublist.get(j);
				        if (element.equals("-1")) break;
				        arr[cnt++] = Integer.parseInt(element);
				    }
				}
				
				int inversion = 0;				
				for(int i = 0; i < arr.length-1; i++) {
					int temp = arr[i];
					System.out.println("temp : "+temp);
					for(int j = i+1;j<arr.length;j++) {
						System.out.print(arr[j]+"-");
						if(temp > arr[j]) inversion++;
					}
					System.out.println("inversion : "+inversion);
				}
				System.out.println(Arrays.toString(arr));
				
				//난이도 하
				if(level == 1) {
					if(row == 3 && inversion == 7) break;
					else if(row == 4 && inversion == 21) break;
					else if(row == 5 && inversion == 69) break;
				}
				//난이도 중
				else if( level == 2) {
					if(row == 3 && inversion == 13) break;
					else if(row == 4 && inversion == 51) break;
					else if(row == 5 && inversion == 137) break;
				} 
				//난이도 상
				else if(level == 3) {
					if(row == 3 && inversion == 21) break;
					else if(row == 4 && inversion == 78) break;
					else if(row == 5 && inversion == 207) break;
				}
			}

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent arg0) {
				int x = arg0.getX() / puzzleSize;
				int y = arg0.getY() / puzzleSize;
				if (x < row && y < row) {
					moveX = x;
					moveY = y;
					movePositionX = 0;
					movePositionY = 0;
					if (emptyX == moveX - 1 && emptyY == moveY) {
					} else if (emptyX == moveX + 1 && emptyY == moveY) {
					} else if (emptyX == moveX && emptyY == moveY - 1) {
					} else if (emptyX == moveX && emptyY == moveY + 1) {
					} else {
						moveX = -1;
						moveY = -1;
					}
					repaint();
				}
			}

			public void mouseClicked(MouseEvent e) {

			}

			public void mouseReleased(MouseEvent e) {

			}

			public void mouseEntered(MouseEvent e) {

			}

			public void mouseExited(MouseEvent e) {

			}
		});
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ArrayList yList;
		String puzzle;
		for (int x = 0; x < xList.size(); x++) {
			yList = (ArrayList) xList.get(x);
			for (int y = 0; y < yList.size(); y++) {
				puzzle = (String) yList.get(y);
				if (puzzle.equals(empty)) {
				} else if (moveX == x && moveY == y) {

					int realPositionX = moveX * puzzleSize;
					int realPositionY = moveY * puzzleSize;
					int realEmptyPositionX = emptyX * puzzleSize;
					int realEmptyPositionY = emptyY * puzzleSize;
					if (moveX > emptyX) {
						movePositionX--;
					} else if (moveX < emptyX) {
						movePositionX++;
					} else if (moveY > emptyY) {
						movePositionY--;
					} else if (moveY < emptyY) {
						movePositionY++;
					}
					g.drawImage((BufferedImage) picList.get(Integer.parseInt(puzzle)), x * puzzleSize + movePositionX,
							y * puzzleSize + movePositionY, puzzleSize, puzzleSize, null);
					if (realPositionX + movePositionX == realEmptyPositionX
							&& realPositionY + movePositionY == realEmptyPositionY) {
						((ArrayList) xList.get(emptyX)).set(emptyY, puzzle);
						((ArrayList) xList.get(moveX)).set(moveY, empty);
						emptyX = moveX;
						emptyY = moveY;
						moveX = -1;
						moveY = -1;
						count++;
						if (emptyX == row - 1 && emptyY == row - 1) {
							boolean isSuccess = true;
							for (int tempx = 0; tempx < xList.size(); tempx++) {
								for (int tempy = 0; tempy < yList.size(); tempy++) {
									if (tempx == emptyX && tempy == emptyX) {
									} else if (Integer
											.parseInt((String) ((ArrayList) xList.get(tempx)).get(tempy)) == tempx
													+ tempy * row) {
									} else {
										isSuccess = false;
										break;
									}
								}
								if (isSuccess) {
								} else {
									break;
								}
							}
							if (isSuccess) {
								stop = true;
								timer.th.interrupt();
								JOptionPane.showMessageDialog(null,"성공");
							}
						}

					}
					repaint();
				} else {
					g.drawImage((BufferedImage) picList.get(Integer.parseInt(puzzle)), x * puzzleSize, y * puzzleSize,
							puzzleSize, puzzleSize, null);
				}

			}
		}
	}

}
