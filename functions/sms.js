exports.handler = function(context, event, callback) {
    const accountSid = context.accountsid;
    const authToken = context.authtoken;
    const client = require('twilio')(accountSid, authToken);
    
    client.messages
          .create({body: 'Hi there!', from: '+ your num in e.164 format', to: event.number})
          .then(message => { console.log(message.sid); callback(null, { "success": "message send success" } ) });
};
