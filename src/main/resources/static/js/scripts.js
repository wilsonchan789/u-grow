$(document).ready(function() {

    // page is now ready, initialize the calendar...
        // put your options and callbacks here
            $('#calendar').fullCalendar({
                selectable: true,
                events: [
                                      {
                                          title: 'Potatoes',
                                          start: '2018-03-01',
                                          plant: '1'
                                      },
                                      {
                                          title: 'Tomatoes',
                                          start: '2018-03-02',
                                          plant: '2'
                                      },
                                      {
                                          title: 'Potatoes',
                                          start: '2018-03-03',
                                          plant: '1'
                                      },
                                      {
                                          title: 'Tomatoes',
                                          start: '2018-03-04',
                                          plant: '2'
                                      }
                                  ],
                header: {
                        left: 'prev,next today',
                        center: 'title',
                        right: 'month,listWeek'
                },
                eventRender: function eventRender( event, element, view ) {
                                     return ['all', event.plant].indexOf($('#plant_selector').val()) >= 0
                                 }
            });
            $('#plant_selector').on('change',function(){
                $('#calendar').fullCalendar('rerenderEvents');
            })

});

