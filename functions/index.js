// functions/index.js
const functions = require('firebase-functions');
const { trackCustomMetric } = require('./metrics'); // Import the custom metric tracking function

exports.trackCustomMetric = trackCustomMetric;
