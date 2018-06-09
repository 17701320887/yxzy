module.exports = {
    entry:{
        build:'./src/main/resources/static/js/main.js'
    },
    output: {
        filename: "[name].js",
        path: __dirname+"/static/outputStatic/",
        publicPath:"/outputStatic"
    },
    resolve: {
        extensions: ['.js','.vue','.json']
    },
    module: {
        rules: [
            {
                test:/\.js$/,
                loader: "babel-loader"
            }
            ,
            {
                test:/\.css$/,
                use:[
                    'babel-loader',
                    'style-loader',
                    'css-loader',
                    'px2rem-loader',
                    'postcss-loader'
                ]
            },
             {
                            test: /\.(png|jpg)$/,
                        loader: 'file-loader',
                     query : {
                         name : '/img/[hash].[ext]'
                     }                        }
        ]
    }
}