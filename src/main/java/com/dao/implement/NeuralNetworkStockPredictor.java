package com.dao.implement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.core.events.LearningEvent;
import org.neuroph.core.events.LearningEventListener;
import org.neuroph.core.learning.SupervisedLearning;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.BackPropagation;

public class NeuralNetworkStockPredictor {

	private int slidingWindowSize = 9;
	private double max = 0;
	private double min = Double.MAX_VALUE;
	private String rawDataFilePath;
	private static List<Double> sumCost;

	private String learningDataFilePath = "learningData.csv";
	private String neuralNetworkModelFilePath = "stockPredictor.nnet";

	public List<Double> neuralNetworkPrediction(List<Double> dataSumAllYear)
			throws IOException {
		List<Double> result = new ArrayList<Double>();
		sumCost = dataSumAllYear;
		prepareData();
		trainNetwork();
		for (int i = 0; i < sumCost.size(); i++) {
			result.add(testNetwork(i));
		}
		return result;
	}

	private void prepareData() throws IOException {
		// Find the minimum and maximum values - needed for normalization
		try {
			for (double crtValue : sumCost) {
				if (crtValue > max) {
					max = crtValue;
				}
				if (crtValue < min) {
					min = crtValue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		BufferedWriter writer = new BufferedWriter(new FileWriter(
				learningDataFilePath));

		// Keep a queue with slidingWindowSize + 1 values
		LinkedList<Double> valuesQueue = new LinkedList<Double>();
		try {
			for (double crtValue : sumCost) {
				// Normalize values and add it to the queue
				double normalizedValue = normalizeValue(crtValue);
				valuesQueue.add(normalizedValue);

				if (valuesQueue.size() == slidingWindowSize + 1) {
					String valueLine = valuesQueue.toString().replaceAll(
							"\\[|\\]", "");
					writer.write(valueLine);
					writer.newLine();
					// Remove the first element in queue to make place for a new
					// one
					valuesQueue.removeFirst();
				}
			}
		} finally {
			writer.close();
		}
	}

	private double normalizeValue(double input) {
		return (input - min) / (max - min) * 0.8 + 0.1;
	}

	private double deNormalizeValue(double input) {
		return min + (input - 0.1) * (max - min) / 0.8;
	}

	private void trainNetwork() throws IOException {
		NeuralNetwork<BackPropagation> neuralNetwork = new MultiLayerPerceptron(
				slidingWindowSize, 2 * slidingWindowSize + 1, 1);

		int maxIterations = 314;
		double learningRate = 0.5;
		double maxError = 0.00001;
		SupervisedLearning learningRule = neuralNetwork.getLearningRule();
		learningRule.setMaxError(maxError);
		learningRule.setLearningRate(learningRate);
		learningRule.setMaxIterations(maxIterations);
		learningRule.addListener(new LearningEventListener() {
			public void handleLearningEvent(LearningEvent learningEvent) {
				SupervisedLearning rule = (SupervisedLearning) learningEvent
						.getSource();
			}
		});

		DataSet trainingSet = loadTraininigData(learningDataFilePath);
		neuralNetwork.learn(trainingSet);
		neuralNetwork.save(neuralNetworkModelFilePath);
	}

	private DataSet loadTraininigData(String filePath) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		DataSet trainingSet = new DataSet(slidingWindowSize, 1);

		try {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split(",");

				double trainValues[] = new double[slidingWindowSize];
				for (int i = 0; i < slidingWindowSize; i++) {
					trainValues[i] = Double.valueOf(tokens[i]);
				}
				double expectedValue[] = new double[] { Double
						.valueOf(tokens[slidingWindowSize]) };
				trainingSet.addRow(new DataSetRow(trainValues, expectedValue));
			}
		} finally {
			reader.close();
		}
		return trainingSet;
	}

	private double testNetwork(int i) {
		double result = 0;
		Random rand = new Random();
		int n = rand.nextInt(sumCost.size() - slidingWindowSize)
				+ slidingWindowSize;
		NeuralNetwork neuralNetwork = NeuralNetwork
				.createFromFile(neuralNetworkModelFilePath);
		neuralNetwork.setInput(normalizeValue(sumCost.get(n - 8)),
				normalizeValue(sumCost.get(n - 7)),
				normalizeValue(sumCost.get(n - 6)),
				normalizeValue(sumCost.get(n - 5)),
				normalizeValue(sumCost.get(n - 4)),
				normalizeValue(sumCost.get(n - 3)),
				normalizeValue(sumCost.get(n - 2)),
				normalizeValue(sumCost.get(n - 1)),
				normalizeValue(sumCost.get(n)));

		neuralNetwork.calculate();
		double[] networkOutput = neuralNetwork.getOutput();
		result = Math.abs(deNormalizeValue(networkOutput[0]));

		return result;
	}
}