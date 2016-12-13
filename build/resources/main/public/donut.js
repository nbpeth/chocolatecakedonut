
var scene = new THREE.Scene();
var renderer = new THREE.WebGLRenderer({ alpha: true });
var camera = new THREE.PerspectiveCamera( 75, window.innerWidth / window.innerHeight, 0.1, 1000 );

setRenderSize();
renderer.setClearColor( 0x000000, 0 );

var geometry = new THREE.TorusGeometry( 12, 3, 24, 100 );
var material = new THREE.MeshPhongMaterial({
	color: 0x00DD00,
  specular: 0x452D1A,
  shininess: 10,
});
var torus = new THREE.Mesh( geometry, material );
scene.add( torus );

var light = new THREE.DirectionalLight( 0xffffff );
light.position.set( 0, 0.5, 1 ).normalize();
scene.add(light);

camera.position.z = 40;

document.body.appendChild( renderer.domElement );
render();

window.onresize = function(event) {
    setRenderSize();
};

function setRenderSize() {
	camera.aspect = window.innerWidth / window.innerHeight;
  camera.updateProjectionMatrix();
	renderer.setSize( window.innerWidth, window.innerHeight );
}

function render() {
	requestAnimationFrame( render );
  torus.rotation.x += 0.001;
	torus.rotation.y += 0.01;
	renderer.render( scene, camera );
}

