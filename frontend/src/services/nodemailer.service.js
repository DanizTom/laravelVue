import nodemailer from '../../node_modules/nodemailer/';
//const nodemailer = require('nodemailer');
//const querystring = require('querystring');
//const payload = querystring.parse(event.body);
//const { name, email, subject, message } = payload;
class NodeMailerService {
  // create reusable transporter object using the default SMTP transport
  transporter = nodemailer.createTransport({
    service: 'gmail',
    host: 'smtp.gmail.com',
    auth: {
      user: 'idanahealth@gmail.com',
      pass: 'Idana1234%'
    }
  });

  // setup email data with unicode symbols
  mailOptions = {
    // from: this.clientemailid,
    // to: this.coachemailId,
    from: 'pushirattan@gmail.com ',
    to: 'chengpr@gmail.com',
    subject: 'hello',
    text: 'hello world!'
  };

  callback = function(err, info) {
    if (err) {
      throw err;
    }
    console.log('sent');
  };

  // send mail with defined transport object
  sendMessage() {
    this.transporter
      .sendMail(this.mailOptions)
      .then(() => {
        this.callback(null, { statusCode: 200, body: 'Success' });
      })
      .catch(e =>
        this.callback(e, { statusCode: 500, body: 'Error sending email' })
      );
  }
}

export default new NodeMailerService();
