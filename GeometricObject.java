import java.util.Random;
import java.util.Vector;

import processing.core.PShape;

public class GeometricObject {
	int mode;
	float interval;
	float numberAssigned;
	public PShape shape;
	Random rand = new Random();
	float osX;
	float osY;
	int mode2 = Math.round(rand.nextFloat() * 33);

	public void assignOffset() {
		osX = (rand.nextFloat()-0.25f) * 2048.0f;
		osY = (rand.nextFloat()-0.25f) * (1024.0f);
	}

	public void draw(Vector<Float> numbers) {
		interval = 1.0f + ((1.0f / (((Math.abs(((((((numberAssigned))))))))) + 1.0f)));
		if (rand.nextInt(2) == 1) {
			interval = 1.0f - ((1.0f / (((Math.abs(((((((numberAssigned))))))))) + 1.0f)));
		}
		if (rand.nextInt(64) == 1) {
			assignOffset();
		}
		double index;
		shape.beginShape();
		// You can set fill and stroke
		shape.fill(Math.abs(256-(256*(0.835f/(Math.abs(numberAssigned)+1.0f)))),
				Math.abs(256-(256*(0.835f/(Math.abs(numberAssigned)+1.0f)))),
				Math.abs(256-(256*(0.835f/(Math.abs(numberAssigned)+1.0f)))));
		shape.stroke(128 / (numberAssigned - numberAssigned * rand.nextFloat()));
		shape.strokeWeight(2);
		if (mode == 0) {// draw all numbers complex

			for (int i = 0; i < numbers.size(); i++) {
				shape.vertex(osX - 119 * numbers.get(i) * (float) Math.sin(3.14159 * numbers.get(i)),
						osY - 119 * numbers.get(i) * (float) Math.cos(3.14159 * numbers.get(i)));
				shape.vertex(
						osX - 119 * numbers.get(i) * (float) Math.sin(3.14159 * Math.sin(3.14159 * numbers.get(i))),
						osY - 119 * numbers.get(i));
				shape.vertex(osX - 119 * numbers.get(i) * (float) Math.cos(3.14159 * numbers.get(i)),
						osY - 119 * numbers.get(i) * (float) Math.sin(3.14159 * Math.sin(numbers.get(i))));
			}

		}
		if (mode == 1) {// draw number shape ceil verts
			for (int i = 0; i < (int) Math.ceil((double) numberAssigned); i++) {
				shape.vertex(osX - (float) Math.cos(3.14159 * ((i) / numberAssigned)) * numbers.size() * numberAssigned,
						osY - (float) Math.sin(3.14159 * ((i) / numberAssigned)) * numbers.size() * numberAssigned);

			}
		}
		if (mode == 2) {// draw number shape floor verts
			for (int i = 0; i < (int) Math.floor((double) numberAssigned); i++) {
				shape.vertex(osX - (float) Math.cos(3.14159 * ((i) / numberAssigned)) * numbers.size() * numberAssigned,
						osY - (float) Math.sin(3.14159 * ((i) / numberAssigned)) * numbers.size() * numberAssigned);

			}
		}
		if (mode == 3) {// draw all numbers randomize
			for (int i = 0; i < numbers.size(); i++) {

				shape.vertex(osX - (float) Math.cos(3.14159 * numbers.get(i)) * numbers.get(i) * numbers.size(),
						osY - (float) Math.sin(3.14159 * Math.sin(3.14159 * numbers.get(i))) * numbers.get(i)
								* (numbers.size() - 1));
				shape.vertex(osX - 0, osY
						- (float) Math.sin(3.14159 * Math.sin(numbers.get(i))) * numbers.get(i) * (numbers.size() - 1));
				shape.vertex(osX - (float) Math.sin(3.14159 * numbers.get(i)) * numbers.get(i)
						* (float) Math.cos(3.14159 * numbers.get(i)) * numbers.size(), osY - 0);
			}

		}
		if (mode == 4) {// draw all numbers complex

			for (int i = 0; i < numbers.size(); i++) {
				shape.vertex(osX - 119 * numbers.get(i) * (float) Math.sin(3.14159 * numbers.get(i)),
						osY - 119 * numbers.get(i) * (float) Math.cos(3.14159 * numbers.get(i)),
						119 * numbers.get(i) * (float) Math.sin(3.14159 * Math.sin(3.14159 * numbers.get(i))));
				shape.vertex(
						osX - 119 * numbers.get(i) * (float) Math.sin(3.14159 * Math.sin(3.14159 * numbers.get(i))),
						osY - 119 * numbers.get(i) * (float) Math.sin(3.14159 * numbers.get(i)),
						119 * numbers.get(i) * (float) Math.cos(3.14159 * numbers.get(i)));
				shape.vertex(osX - 119 * numbers.get(i) * (float) Math.cos(3.14159 * numbers.get(i)),
						osY - 119 * numbers.get(i) * (float) Math.sin(3.14159 * Math.sin(3.14159 * numbers.get(i))),
						119 * numbers.get(i) * (float) Math.sin(3.14159 * numbers.get(i)));
			}

		}
		if (mode == 5) {// draw number shape ceil verts
			for (int i = 0; i < (int) Math.ceil((double) numberAssigned); i++) {
				shape.vertex(osX - (float) Math.cos(3.14159 * ((i) / numberAssigned)) * numbers.size() * numberAssigned,
						osY - (float) Math.sin(3.14159 * ((i) / numberAssigned)) * numbers.size() * numberAssigned,
						(float) Math.sin(((i + 1.0f) / numberAssigned)) * numberAssigned * (numbers.size() - 1));

			}
		}
		if (mode == 6) {// draw number shape floor verts
			for (int i = 0; i < (int) Math.floor((double) numberAssigned); i++) {
				shape.vertex(osX - (float) Math.cos(3.14159 * ((i) / numberAssigned)) * numbers.size() * numberAssigned,
						osY - (float) Math.sin(3.14159 * ((i) / numberAssigned)) * numbers.size() * numberAssigned,
						(float) Math.sin(((i + 1.0f) / numberAssigned)) * numberAssigned * (numbers.size() - 1));

			}
		}
		if (mode == 7) {// draw all numbers randomize
			for (int i = 0; i < numbers.size(); i++) {
				shape.vertex(osX - 119 * numbers.get(i),
						osY - 119 * numbers.get(i) * (float) Math.cos(3.14159 * numbers.get(i)),
						119 * numbers.get(i) * (float) Math.sin(3.14159 * Math.sin(3.14159 * numbers.get(i))));
				shape.vertex(
						osX - 119 * numbers.get(i) * (float) Math.sin(3.14159 * Math.sin(3.14159 * numbers.get(i))),
						osY - 119 * numbers.get(i), 119 * numbers.get(i) * (float) Math.cos(numbers.get(i)));
				shape.vertex(osX - 119 * numbers.get(i) * (float) Math.cos(3.14159 * numbers.get(i)),
						osY - 119 * numbers.get(i) * (float) Math.sin(3.14159 * Math.sin(3.14159 * numbers.get(i))),
						119 * numbers.get(i));
			}

		}
		if (mode == 8) {// draw number shape ceil verts
			for (int i = 0; i < numbers.size(); i++) {
				shape.vertex(osX - (float) Math.cos(3.14159 * ((i) / numberAssigned)) * numbers.size() * numberAssigned,
						osY - (float) Math.sin(3.14159 * ((i) / numberAssigned)) * numbers.size() * numberAssigned);

			}
		}
		if (mode == 9) {// draw number shape floor verts
			for (int i = 0; i < numbers.size(); i++) {
				shape.vertex(osX - (float) Math.cos(3.14159 * ((i) / numberAssigned)) * numbers.size() * numberAssigned,
						osY - (float) Math.sin(3.14159 * ((i) / numberAssigned)) * numbers.size() * numberAssigned);

			}
		}
		if (mode == 10) {// draw number shape ceil verts
			for (int i = 0; i < numbers.size(); i++) {
				shape.vertex(osX - (float) Math.cos(3.14159 * ((i) / numberAssigned)) * numbers.size() * numberAssigned,
						osY - (float) Math.sin(3.14159 * ((i) / numberAssigned)) * numbers.size() * numberAssigned,
						(float) Math.sin(((i + 1.0f) / numberAssigned)) * numberAssigned * (numbers.size() - 1));

			}
		}
		if (mode == 11) {// draw number shape floor verts
			for (int i = 0; i < numbers.size(); i++) {
				shape.vertex(osX - (float) Math.cos(3.14159 * ((i) / numberAssigned)) * numbers.size() * numberAssigned,
						osY - (float) Math.sin(3.14159 * ((i) / numberAssigned)) * numbers.size() * numberAssigned,
						(float) Math.sin(((i + 1.0f) / numberAssigned)) * numberAssigned * (numbers.size() - 1));

			}
		}
		if (mode == 11) {// draw number shape floor verts
			draw2d(osX, osY, numbers, Math.round(numberAssigned));
		}
		if (mode == 12) {// draw number shape floor verts
			draw2d(osX, osY, numbers, numbers.size());
		}
		if (mode == 13) {// draw number shape floor verts
			draw2d(osX, osY, numbers, Math.round(numberAssigned));
		}
		if (mode == 14) {// draw number shape floor verts
			draw3d(osX, osY, 0, numbers, Math.round(numberAssigned));
		}
		if (mode == 15) {// draw number shape floor verts
			draw3d(osX, osY, 0, numbers, numbers.size());
		}
		if (mode == 16) {// draw number shape floor verts
			draw3d(osX, osY, 0, numbers, Math.round(numberAssigned));
		}
		if (mode == 17) {// draw number shape floor verts
			draw3d(osX, osY, 0, numbers, numbers.size());
		}

	}

	public void draw2d(float x, float y, Vector<Float> numbers, float i) {

		// numbers.get(Math.round(rand.nextFloat()*(numbers.size()-1)))
		if (mode2 == 0) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 1) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 2) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 3) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 4) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}

		if (mode2 == 5) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 6) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 7) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 8) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 9) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}

		if (mode2 == 10) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 11) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 12) {
			for (int j = 0; j < i; j++) {
				shape.vertex(x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned, i), y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f)))))
						* 128.0f
						* index(numberAssigned, numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 13) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 14) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1))),
										numberAssigned),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 15) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1))), numberAssigned));
			}
		}
		if (mode2 == 16) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1))),
										numberAssigned),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1))), numberAssigned));
			}
		}

		//////////////////////////////////////
		if (mode2 == 17) {
			for (int j = 0; j < i; j++) {
				shape.vertex(x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(numberAssigned, i), y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f)))))
						* 128.0f
						* index(numberAssigned, numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 18) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 19) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 20) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 21) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}

		if (mode2 == 22) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 23) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 24) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 25) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 26) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}

		if (mode2 == 27) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 28) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 29) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 30) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 31) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1))),
										numberAssigned),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 32) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1))), numberAssigned));
			}
		}
		if (mode2 == 33) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1))),
										numberAssigned),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1))), numberAssigned));
			}
		}

	}

	public void draw3d(float x, float y, float z, Vector<Float> numbers, float i) {

		if (mode == 0) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 1) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 2) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 3) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 4) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}

		if (mode2 == 5) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 6) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 7) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 8) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 9) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}

		if (mode2 == 10) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 11) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 12) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 13) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 14) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1))),
										numberAssigned),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1))), numberAssigned));
			}
		}
		if (mode2 == 15) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1))),
										numberAssigned),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 16) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1))),
										numberAssigned),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1))),
										numberAssigned),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1))), numberAssigned));
			}
		}

		//////////////////////////////////////
		if (mode2 == 17) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 18) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 19) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 20) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 21) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}

		if (mode2 == 22) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 23) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 24) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 25) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 26) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}

		if (mode2 == 27) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 28) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 29) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 30) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 31) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1))),
										numberAssigned),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1))), numberAssigned));
			}
		}
		if (mode2 == 32) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* index(numberAssigned,
										numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1))),
										numberAssigned),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * index(numberAssigned,
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1)))));
			}
		}
		if (mode2 == 33) {
			for (int j = 0; j < i; j++) {
				shape.vertex(
						x + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1))),
										numberAssigned),
						y + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f
								* operate(numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1))),
										numberAssigned),
						z + ((float)(32.00f*(Math.pow(1.1975807343f,1.0f/(Math.abs(numberAssigned)+1.0f))))) * 128.0f * operate(
								numbers.get(Math.round(rand.nextFloat() * (numbers.size() - 1))), numberAssigned));
			}
		}

	}

	public float operate(float n, float n2) {
		int mode2 = Math.round(rand.nextFloat() * 6);
		if (mode2 == 0) {
			return (float) Math.pow(n, n2);
		}
		if (mode2 == 1) {
			return n * n2;
		}
		if (mode2 == 2) {
			return n + n2;
		}
		if (mode2 == 3) {
			return n - n2;
		}
		if (mode2 == 4) {
			return n / n2;
		}
		if (mode2 == 5) {
			return (float) Math.pow(n, 1.0d / n2);
		}
		if (mode2 == 6) {
			return n;
		}
		return n;
	}

	public float index(float n, float n2) {
		int mode2 = Math.round(rand.nextFloat() * 11);
		if (mode2 == 0) {
			return (float) Math.sin(n) * n2;
		}
		if (mode2 == 1) {
			return (float) Math.cos(n) * n2;
		}
		if (mode2 == 2) {
			return (float) Math.pow(n, 1.0d / n2);
		}
		if (mode2 == 3) {
			return (float) Math.pow(1.0d / n2, n);
		}
		if (mode2 == 4) {
			return (float) Math.pow(n, n2);
		}
		if (mode2 == 5) {
			return (float) Math.pow(n2, n);
		}
		if (mode2 == 6) {
			return n * n2;
		}
		if (mode2 == 7) {
			return n / n2;
		}
		if (mode2 == 8) {
			return n2 / n;
		}
		if (mode2 == 9) {
			return n * n2;
		}
		if (mode2 == 10) {
			return -(float) Math.sin(n) * n2;
		}
		if (mode2 == 11) {
			return -(float) Math.cos(n) * n2;
		}
		return n;

	}
}
