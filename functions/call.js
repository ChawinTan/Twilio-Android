exports.handler = function(context, event, callback) {
    const accountSid = context.accountsid;
    const authToken = context.authtoken;
    const client = require('twilio')(accountSid, authToken);
    const got = require("got");
    console.log(event)

    client.studio.v1.flows('Your Studio Flow')
                .executions
                .create({to: event.number, from: 'Your Twilio Number'})
                .then(execution => { console.log(execution.sid); callback(null, {"succeed": "Hello world I am android"}) })
                .catch(Error => {callback(Error, null)})
};
