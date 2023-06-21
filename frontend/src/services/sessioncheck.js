import authService from './auth.service';

class SessionCheck {
  activityWatcher() {
    //The number of seconds that have passed
    //since the user was active.
    var secondsSinceLastActivity = 0;

    //Five minutes. 60 x 5 = 300 seconds.
    //This timeout should be equal or one more than jwt session timeout defined in application.properties
    var maxInactivity = 300; // 5 min timeout

    //Setup the setInterval method to run
    //every second. 1000 milliseconds = 1 second.
    setInterval(function () {
      secondsSinceLastActivity++;
      let userexists = JSON.parse(localStorage.getItem('user'));
      console.log(
        secondsSinceLastActivity + ' seconds since the user was last active'
      );
      console.log('user is ' + userexists);
      //if the user has been inactive or idle for longer
      //then the seconds specified in maxInactivity
      if (secondsSinceLastActivity > maxInactivity) {
        console.log(
          'User has been inactive for more than ' + maxInactivity + ' seconds'
        );

        //Check if localstorage has an existing user
        userexists = JSON.parse(localStorage.getItem('user'));
        console.log('user is ' + userexists);
        if (userexists != null) {
          //Redirect to logout page.
          //location.href = 'login';
          console.log('User is NOT Null, Going to logout');
          // location.href = authService.logout;
          //location.href = this.$router.push('/login');
          authService.logout;
          userexists = JSON.parse(localStorage.getItem('user'));
          window.location.href = '/login';
          localStorage.removeItem('user');
        }
      }
    }, 1000);

    //The function that will be called whenever a user is active
    function activity() {
      //reset the secondsSinceLastActivity variable
      //back to 0
      secondsSinceLastActivity = 0;
    }

    //An array of DOM events that should be interpreted as
    //user activity.
    var activityEvents = [
      'mousedown',
      'mousemove',
      'keydown',
      'scroll',
      'touchstart',
    ];

    //add these events to the document.
    //register the activity function as the listener parameter.
    activityEvents.forEach(function (eventName) {
      document.addEventListener(eventName, activity, true);
    });
  }

  //activityWatcher();
}
export default new SessionCheck();
