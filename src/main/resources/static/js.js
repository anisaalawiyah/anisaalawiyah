// $(function () {
//     $('[data-toggle="tooltip"]').tooltip()
//   })

//   // untuk mengatur saat si halaman di scroll maka warna si headernya berubah tapi jika kembali ke awal maka akan berubah seperti semula
// window.addEventListener("scroll", function () {
//   var header = document.querySelector("header");
//   var scrollPosition = window.scrollY;
//   // Tentukan posisi scroll (misalnya 100 piksel) untuk mengubah warna header
//   if (scrollPosition > 100) {
//     header.classList.add("fixed"); // untuk menambahkan warna yang di inginkan
//   } else {
//     header.classList.remove("fixed"); // Kembalikan ke warna awal ketika scroll kembali ke atas
// }
// });


const allSideMenu = document.querySelectorAll('#sidebar .side-menu.top li a');

allSideMenu.forEach(item=> {
	const li = item.parentElement;

	item.addEventListener('click', function () {
		allSideMenu.forEach(i=> {
			i.parentElement.classList.remove('active');
		})
		li.classList.add('active');
	})
});




// TOGGLE SIDEBAR
const menuBar = document.querySelector('#content nav .bx.bx-menu');
const sidebar = document.getElementById('sidebar');

menuBar.addEventListener('click', function () {
	sidebar.classList.toggle('hide');
})







const searchButton = document.querySelector('#content nav form .form-input button');
const searchButtonIcon = document.querySelector('#content nav form .form-input button .bx');
const searchForm = document.querySelector('#content nav form');

searchButton.addEventListener('click', function (e) {
	if(window.innerWidth < 576) {
		e.preventDefault();
		searchForm.classList.toggle('show');
		if(searchForm.classList.contains('show')) {
			searchButtonIcon.classList.replace('bx-search', 'bx-x');
		} else {
			searchButtonIcon.classList.replace('bx-x', 'bx-search');
		}
	}
})





if(window.innerWidth < 768) {
	sidebar.classList.add('hide');
} else if(window.innerWidth > 576) {
	searchButtonIcon.classList.replace('bx-x', 'bx-search');
	searchForm.classList.remove('show');
}


window.addEventListener('resize', function () {
	if(this.innerWidth > 576) {
		searchButtonIcon.classList.replace('bx-x', 'bx-search');
		searchForm.classList.remove('show');
	}
})



const switchMode = document.getElementById('switch-mode');

switchMode.addEventListener('change', function () {
	if(this.checked) {
		document.body.classList.add('dark');
	} else {
		document.body.classList.remove('dark');
	}
})


    function formatNumber(input) {
        // Remove any non-digit characters
        let value = input.value.replace(/\D/g, '');

        // Format number with thousands separator
        input.value = new Intl.NumberFormat('id-ID').format(value);
    }

	document.addEventListener('DOMContentLoaded', function () {
        let priceElements = document.querySelectorAll('#price');
        priceElements.forEach(function (element) {
            let value = element.innerText;
            if (!isNaN(value) && value !== '') {
                element.innerText = new Intl.NumberFormat('id-ID').format(value);
            }
        });
    });
	document.getElementById('dateForm').addEventListener('submit', function(event) {
		event.preventDefault();
		
		const dateInput = document.getElementById('dateInput').value;
		const errorMessage = document.getElementById('errorMessage');
		
		if (validateDate(dateInput)) {
			errorMessage.textContent = '';
			alert('Tanggal valid: ' + dateInput);
			// Proses form submission di sini
		} else {
			errorMessage.textContent = 'Tanggal tidak valid. Silakan masukkan tanggal antara tahun 2024 dan 2025.';
		}
	});
	
	function validateDate(date) {
		const parsedDate = new Date(date);
		const year = parsedDate.getFullYear();
		const isValid = parsedDate instanceof Date && !isNaN(parsedDate) && (year === 2024 || year === 2025);
		return isValid;
	}
	