// functions/metrics.js
const functions = require('firebase-functions');
const admin = require('firebase-admin');
const { Monitoring } = require('@google-cloud/monitoring');

// Initialize Firebase Admin SDK
admin.initializeApp();

// Initialize Google Cloud Monitoring Client
const client = new Monitoring.MetricServiceClient();

// Firebase Cloud Function to create and track custom metrics
exports.trackCustomMetric = functions.pubsub
  .schedule('every 24 hours') // Set your schedule here
  .onRun(async (context) => {
    try {
      // Replace with your Google Cloud project ID
      const projectId = 'your-project-id';

      // Create custom metric in Google Cloud Monitoring
      const [timeSeries] = await client.createTimeSeries({
        name: client.projectPath(projectId),
        timeSeries: [
          {
            metric: {
              type: 'custom.googleapis.com/my-metric', // Custom metric name
              labels: {
                environment: 'prod', // Label to track environment
              },
            },
            resource: {
              type: 'global',
            },
            points: [
              {
                interval: {
                  startTime: { seconds: Date.now() / 1000 },
                  endTime: { seconds: Date.now() / 1000 },
                },
                value: {
                  doubleValue: 100.0, // Metric value (customize as needed)
                },
              },
            ],
          },
        ],
      });

      console.log('Custom Metric Tracked: ', timeSeries);
    } catch (error) {
      console.error('Error tracking custom metric:', error);
    }
  });
