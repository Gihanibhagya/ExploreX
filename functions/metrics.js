const functions = require('firebase-functions');
const { Monitoring } = require('@google-cloud/monitoring');
const admin = require('firebase-admin');

admin.initializeApp();
const client = new Monitoring.MetricServiceClient();


client.createTimeSeries({
  name: client.projectPath('your-project-id'),
  timeSeries: [
    {
      metric: {
        type: 'custom.googleapis.com/my-metric',
        labels: {
          environment: 'prod',
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
            doubleValue: 100.0,
          },
        },
      ],
    },
  ],
});
