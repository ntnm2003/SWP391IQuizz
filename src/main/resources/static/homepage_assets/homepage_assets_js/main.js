const scrollRight1 = document.getElementById('scroll-right-1');
const scrollLeft1 = document.getElementById('scroll-left-1');
const scrollRight2 = document.getElementById('scroll-right-2');
const scrollLeft2 = document.getElementById('scroll-left-2');

scrollLeft1.onclick = () => scroll('left', document.getElementById('hot-posts'));
scrollRight1.onclick = () => scroll('right', document.getElementById('hot-posts'));
scrollLeft2.onclick = () => scroll('left', document.getElementById('featured-subjects'));
scrollRight2.onclick = () => scroll('right', document.getElementById('featured-subjects'));

const scroll = (dir, list) => {
    if (dir === 'right') {
        list.scrollBy({
            left: 300,
            behavior: 'smooth'
        });
    } else {
        list.scrollBy({
            left: -300,
            behavior: 'smooth'
        });
    }
}