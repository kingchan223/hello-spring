// swiper
const swiper = new Swiper('.swiper-container', {
    direction: 'horizontal',
    slidesPerView: 1,
    debugger: true,
    mousewheel: true,
    loop: true,
    centeredSlides: true,
    effect: 'fade',

    autoplay: {
        delay: 2500,
        disableOnInteraction: false,
    },

    pagination: {
        el: '.swiper-pagination',
        clickable: true,
    },

    navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev',
    },

});

//youtube
var tag = document.createElement('script');

tag.src = "https://www.youtube.com/iframe_api";
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

var player;
function onYouTubeIframeAPIReady() {
    player = new YT.Player('player', {
        videoId: '6Q1IhcAg1_g',
        events: {
            'onReady': onPlayerReady,
            'onStateChange': onPlayerStateChange,
            'autoplay' : 1
        }
    });
}

function onPlayerReady(event) {
    event.target.playVideo();
}

var done = false;
function onPlayerStateChange(event) {
    if (event.data == YT.PlayerState.PLAYING && !done) {
        done = true;
    }
}
function stopVideo() {
    player.stopVideo();
}

//dropdown menu

$(document).ready(function(){
    $('.navbar-xbootstrap').click(function(){
        $('.nav-xbootstrap').toggleClass('visible');
        $('body').toggleClass('cover-bg');
    });
});

