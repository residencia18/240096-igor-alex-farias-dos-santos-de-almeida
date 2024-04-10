const HtmlWebpackPlugin = require('html-webpack-plugin');
const path = require('path');

module.exports = {
    mode: 'development',
    entry: './index.js',
    output: {
        filename: 'main.js',
    },
    plugins: [
        new HtmlWebpackPlugin()
    ]
};