import pandas as pd

data = pd.read_csv('data.csv', sep = ',')

data = data.drop(columns=['<TICKER>', '<PER>', '<TIME>', '<VOL>'])

dates = ['18/09/18', '18/10/18', '20/11/18', '18/12/18']

filtered_data = data[data['<DATE>'].isin(dates)]

filtered_data.to_csv('filtered_data.csv', index=False)