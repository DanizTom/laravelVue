/*const nodemailer = require('nodemailer');
const querystring = require('querystring');
const payload = querystring.parse(event.body);
const { name, email, subject, message } = payload;

// create reusable transporter object using the default SMTP transport
let transporter = nodemailer.createTransport({
  host: 'xxx',
  port: 587,
  secure: false, // true for 465, false for other ports
  auth: {
    user: 'xxx', // generated ethereal user
    pass: 'xxx' // generated ethereal password
  },
  tls: {
    rejectUnauthorized: false
  }
});

// setup email data with unicode symbols
let mailOptions = {
  from: `"website enquiry 👻" <${email}>`, // sender address
  to: 'admin@xxx.xx, enquiry@xxx.xx', // list of receivers
  subject: `${subject} ✔`, // Subject line
  text: `name: ${name}, \n email: ${email}, \n message: ${message}\n` // plain text body
};

var callback = function(err, info) {
  if (err) {
    throw err;
  }
  console.log('sent');
};

// send mail with defined transport object
transporter
  .sendMail(mailOptions)
  .then(() => {
    callback(null, { statusCode: 200, body: 'Success' });
  })
  .catch(e => callback(e, { statusCode: 500, body: 'Error sending email' }));*/
