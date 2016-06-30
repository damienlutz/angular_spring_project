var express = require('express');

var app = require('express')();

app.use('/', express.static('../static'));

app.listen(8081);
console.log("App listening on port 8081");
/*

var liveServer = require("live-server");

var params = {
    port: 8081, // Set the server port. Defaults to 8080.
    host: "0.0.0.0", // Set the address to bind to. Defaults to 0.0.0.0 or process.env.IP.
    root: "../static", // Set root directory that's being server. Defaults to cwd.
    open: false, // When false, it won't load your browser by default.
    ignore: 'scss,my/templates', // comma-separated string for paths to ignore
    wait: 100, // Waits for all changes, before reloading. Defaults to 0 sec.
    mount: [['/components', './node_modules']], // Mount a directory to a route.
    logLevel: 2 ,// 0 = errors only, 1 = some, 2 = lots
    cors: true
};
liveServer.start(params);
*/