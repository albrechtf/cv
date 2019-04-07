# CV Generator

Yet another CV (Resume) generator. I used it for my latest CV. It takes a CV in a JSON format specified
by [JSON Resume](https://github.com/jsonresume) (with slight additions) and creates a nice-looking (I think so) PDF.

The PDF design has been inspired by [some](https://venngage.com/blog/infographic-resume-template/) 
[pages](https://www.rapiddweller.com/pete.html) on the web.

## How it works

The generator internally deserializes the JSON into Java objects, and serializes these objects to XML.
This XML is then fed to an XSLT stylesheet, which generates XSL-FO data, and is finally converted to
PDF using [Apache FOP](https://xmlgraphics.apache.org/fop/). Simple, isn't it?

For making the PDF looking nice, icons by [FontAwesome](https://fontawesome.com/) are included, and the free font [Lato](http://www.latofonts.com/lato-free-fonts/) is used.

## How you can use it

Clone the project locally:

    git clone https://github.com/albrechtf/cv.git
    
Run the example script to generate an example PDF:

    chmod +x example.sh && ./example.sh
    
Or, on Windows:

    example.bat
    
This will build the Java part of the project and run the PDF creation.

To learn about all program options, just run

    mvn clean package && java -jar target/cvgen.jar


## Disclaimer

I created this software and the stylesheet for my own CV. It may be completely useless to anyone else. If you are missing something, feel free to fork the repository and change everything you like. If you think that your changes could be useful for others, I will be happy to get and review Pull Requests.

But, unfortunately, most likely I will not be able to handle any bug reports or feature requests.

## Example

Yeah, why cloning and building and all this stuff? Watch the example CV right here:

![Example CV](https://github.com/albrechtf/cv/raw/gh-pages/images/example-cv.png)
