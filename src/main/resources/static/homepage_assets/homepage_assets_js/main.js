var carouselWidth = $('.main-content .carousel-inner')[0].scrollWidth;
var cardWidth = $('.main-content .carousel-item').width();

var scrollPosition = 0;

$('.carousel-control-next').on('click', function() {
    if(scrollPosition < (cardWidth - (cardWidth * 4))) {
        console.log('next');
        scrollPosition = scrollPosition + cardWidth;
        $('.main-content .carousel-inner').animate({scrollLeft: scrollPosition}, 600);
    }
});