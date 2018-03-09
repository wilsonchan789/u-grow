$(document).ready(function() {
    // page is now ready, initialize the calendar...
        // put your options and callbacks here

         $("#tomatoesLink").click(function () {
             $('#calendar').fullCalendar({
               events: [
                  {
                    title  : 'water',
                    start  : '2018-03-01'
                  },
                  {
                      title  : 'feed',
                      start  : '2018-03-05',
                      end    : '2018-03-07'
                  },
                  {
                      title  : 'water',
                      start  : '2018-03-09T12:30:00',
                      allDay : false // will make the time show
                  }
               ]
             });
         console.log('The tomatoes id was clicked!');
         });
         $("#potatoesLink").click(function () {
               $('#calendar').fullCalendar({
               events: [
                    {
                      title  : 'feed',
                      start  : '2018-03-03'
                    },
                    {
                    title  : 'water',
                    start  : '2018-03-08',
                    end    : '2018-03-09'
                    },
                    {
                    title  : 'feed',
                    start  : '2018-03-11T12:30:00',
                    allDay : false // will make the time show
                    }
               ]
             });
         console.log('The potatoes id was clicked!');
         });
});