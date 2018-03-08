$(document).ready(function() {
    // page is now ready, initialize the calendar...
    $('#calendar').fullCalendar({
        // put your options and callbacks here
        events: [
            {
                title: 'Event1',
                start: '2018-02-22'
            },
            {
                title: 'Event2',
                start: '2018-02-24'
            }
            // etc...
        ],
    })
});