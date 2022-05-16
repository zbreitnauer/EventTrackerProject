window.addEventListener('load', function(e) {
	console.log('document loaded');
	init();
});

function init() {
	console.log('in init()');
	document.findJojo.lookup.addEventListener('click', function(event) {
		event.preventDefault();
		let jojoId = document.findJojo.jojoId.value;
		if (!isNaN(jojoId) && jojoId > 0) {
			getJojo(jojoId);
		}

	});

	document.createJojoForm.createJojo.addEventListener('click', createJojo);

	document.updateJojoForm.updateJojo.addEventListener('click', function(event) {
		event.preventDefault();
		let updateId = document.updateJojoForm.updateId.value;
		console.log(updateId);
		if (!isNaN(updateId) && updateId > 0) {
			updateJojo(updateId);
		}
	});

	document.deleteJojo.lookup.addEventListener('click', function(event) {
		event.preventDefault();
		let deleteId = document.deleteJojo.deleteId.value;
		console.log(deleteId);
		if (!isNaN(deleteId) && deleteId > 0) {
			deleteJojo(deleteId);
		}
	});

	function getJojo(jojoId) {
		let xhr = new XMLHttpRequest();
		xhr.open('GET', 'api/jojo/' + jojoId);
		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4) {
				if (xhr.status == 200) {
					let jojo = JSON.parse(xhr.responseText);
					console.log(jojo);
					displayJojo(jojo);
				}
			} else {
				console.log('Jojo not found');
			}
		}
		xhr.send();
	};

	function displayJojo(jojo) {
		let jojoDiv = document.getElementById('jojoData');
		jojoDiv.textContent = '';

		let h1 = document.createElement('h1');
		h1.textContent = jojo.firstname + " " + jojo.lastname;
		jojoDiv.appendChild(h1);

		let image = document.createElement('img'); //TODO: Get image to display.
		image.textContent = jojo.image;
		jojoDiv.appendChild(image)

		let ul = document.createElement('ul');

		let age = document.createElement('li');
		age.textContent = 'Age: ' + jojo.age;
		ul.appendChild(age);

		let height = document.createElement('li');
		height.textContent = 'Height: ' + jojo.height;
		ul.appendChild(height);

		let weight = document.createElement('li');
		weight.textContent = 'Weight: ' + jojo.weight;
		ul.appendChild(weight);

		let stand = document.createElement('li');
		stand.textContent = 'Stand/Power: ' + jojo.stand;
		ul.appendChild(stand);

		jojoDiv.appendChild(ul);

	}
	function createJojo(e) {
		e.preventDefault();
		let xhr = new XMLHttpRequest();
		xhr.open('POST', 'api/jojo', true);

		xhr.setRequestHeader("Content-type", "application/json");

		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4) {
				if (xhr.status == 200 || xhr.status == 201) {
					let data = JSON.parse(xhr.responseText);
					displayJojo(data);
				}
				else {
					console.error("request failed.");
					console.error(xhr.status + ': ' + xhr.responseText);
				}
			}
		};
		let jojo = {
			firstname: document.createJojoForm.firstname.value,
			lastname: document.createJojoForm.lastname.value,
			age: document.createJojoForm.age.value,
			height: document.createJojoForm.height.value,
			weight: document.createJojoForm.weight.value,
			stand: document.createJojoForm.stand.value,
			image: document.createJojoForm.image.value
		};

		xhr.send(JSON.stringify(jojo));

	}

	function updateJojo(updateId) {
		let xhr = new XMLHttpRequest();
		xhr.open('PUT', 'api/jojo/' + updateId, true);

		xhr.setRequestHeader("Content-type", "application/json");
		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4) {
				if (xhr.status == 200 || xhr.status == 201) {
					let data = JSON.parse(xhr.responseText);
					displayJojo(data);
				}
				else {
					console.error("request failed.");
					console.error(xhr.status + ': ' + xhr.responseText);
				}
			}
		};
		let jojo = {
			firstname: document.updateJojoForm.firstname.value,
			lastname: document.updateJojoForm.lastname.value,
			age: document.updateJojoForm.age.value,
			height: document.updateJojoForm.height.value,
			weight: document.updateJojoForm.weight.value,
			stand: document.updateJojoForm.stand.value,
			image: document.updateJojoForm.image.value
		};

		xhr.send(JSON.stringify(jojo));


	}

	function deleteJojo(deleteId) {
		let xhr = new XMLHttpRequest();
		xhr.open('DELETE', 'api/jojo/' + deleteId);
		xhr.onreadystatechange = function() {
			if (xhr.readyState === 4) {
				if (xhr.status === 204) {
					console.log('Deleted');
				}
			} else {
				console.log('Jojo not found');
			}
		}
		xhr.send();
	};
}
