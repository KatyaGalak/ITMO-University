import csv
import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt

with open("dop2.csv", encoding='utf-8') as r_file:
    file_reader = csv.reader(r_file, delimiter=";")
    arr = [[], [], [], []]
    col = ["<OPEN>", "<HIGH>", "<LOW>", "<CLOSE>"]
    dates = ['18.09.2018', '18.10.2018', '20.11.2018', '18.12.2018']
    for row in file_reader:
        if row[0] == '18.09.2018':
            arr[0].append([int(row[1]), int(row[2]), int(row[3]), int(row[4])])
        elif row[0] == '18.10.2018':
            arr[1].append([int(row[1]), int(row[2]), int(row[3]), int(row[4])])
        elif row[0] == '20.11.2018':
            arr[2].append([int(row[1]), int(row[2]), int(row[3]), int(row[4])])
        elif row[0] == '18.12.2018':
            arr[3].append([int(row[1]), int(row[2]), int(row[3]), int(row[4])])

    plt.figure(figsize=(16, 8))

    for i in range(4):
        data = pd.DataFrame(arr[i], columns=col)
        plt.subplot(2, 2, i + 1)
        sns.boxplot(data=data, palette = 'pastel')
        plt.title(dates[i])
        plt.legend(col, loc = 'lower right')
    plt.subplots_adjust(wspace = 0.5, hspace = 0.5)
    plt.show()