import numpy as np
import pandas as pd

# Step 1: Collect raw data
data = {
    'Weather': ['Sunny', 'Sunny', 'Overcast', 'Rainy', 'Rainy', 'Rainy', 'Overcast', 'Sunny', 'Sunny', 'Rainy', 'Sunny', 'Overcast', 'Overcast', 'Rainy'],
    'Temperature': ['Hot', 'Hot', 'Hot', 'Mild', 'Cool', 'Cool', 'Cool', 'Mild', 'Cool', 'Mild', 'Mild', 'Mild', 'Hot', 'Mild'],
    'Humidity': ['High', 'High', 'High', 'High', 'Normal', 'Normal', 'Normal', 'High', 'Normal', 'Normal', 'Normal', 'High', 'Normal', 'High'],
    'Windy': [False, True, False, False, False, True, True, False, False, False, True, True, False, True],
    'Play': ['No', 'No', 'Yes', 'Yes', 'Yes', 'No', 'Yes', 'No', 'Yes', 'Yes', 'Yes', 'Yes', 'Yes', 'No']
}
df = pd.DataFrame(data)

# Step 2: Convert data to a frequency table
frequency_table = df.groupby(['Play', 'Weather']).size().unstack().fillna(0)
print("Frequency Table:\n", frequency_table)

# Step 3: Calculate prior probabilities and likelihoods
# Prior probabilities P(Play)
P_Play = df['Play'].value_counts() / len(df)
print("\nPrior Probabilities:\n", P_Play)

# Likelihoods P(Weather|Play)
P_Weather_given_Play = frequency_table.div(frequency_table.sum(axis=1), axis=0)
print("\nLikelihoods:\n", P_Weather_given_Play)

# Step 4: Apply probabilities to Bayes’ Theorem equation
# Example: Calculate P(Yes|Sunny)
P_Sunny = df['Weather'].value_counts()['Sunny'] / len(df)
P_Sunny_given_Yes = P_Weather_given_Play.loc['Yes', 'Sunny']

P_Yes_given_Sunny = (P_Sunny_given_Yes * P_Play['Yes']) / P_Sunny
print("\nP(Yes|Sunny):", P_Yes_given_Sunny)

# Implementing Naive Bayes Classifier for predictions
class NaiveBayesClassifier:
    def __init__(self):
        self.priors = {}
        self.likelihoods = {}

    def fit(self, X, y):
        data = pd.concat([X, y], axis=1)
        self.priors = y.value_counts() / len(y)
        self.likelihoods = {col: data.groupby([y.name, col]).size().unstack().fillna(0).div(y.value_counts(), axis=0) for col in X.columns}

    def predict(self, X):
        results = []
        for i in range(X.shape[0]):
            probs = {}
            for cls in self.priors.index:
                prob = self.priors[cls]
                for col in X.columns:
                    prob *= self.likelihoods[col].loc[cls].get(X.iloc[i][col], 0)
                probs[cls] = prob
            results.append(max(probs, key=probs.get))
        return results

# Prepare the data
X = df[['Weather', 'Temperature', 'Humidity', 'Windy']]
y = df['Play']

# Train the model
model = NaiveBayesClassifier()
model.fit(X, y)

# Make predictions
predictions = model.predict(X)
print("\nPredictions:\n", predictions)

# Example prediction
example = pd.DataFrame([{'Weather': 'Sunny', 'Temperature': 'Cool', 'Humidity': 'High', 'Windy': False}])
prediction = model.predict(example)
print("\nExample Prediction for Weather:Sunny, Temperature:Cool, Humidity:High, Windy:False -> Play:", prediction)
