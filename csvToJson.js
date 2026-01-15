// Import required modules
const fs = require('fs');
const Papa = require('papaparse');

// Path to your CSV file
const csvFilePath = '/Users/dekumari/Documents/practice/data.csv';

// Read the CSV file
fs.readFile(csvFilePath, 'utf8', (err, data) => {
  if (err) {
    console.error('Error reading CSV file:', err);
    return;
  }

  // Parse the CSV data
  Papa.parse(data, {
    header: true, // Treat the first row as headers
    dynamicTyping: true, // Automatically convert types (e.g., numbers)
    complete: (result) => {
      // Log the JSON output
      console.log('Parsed JSON:', result.data);
    },
    error: (error) => {
      console.error('Error parsing CSV:', error);
    }
  });
});
