# WebprojektBackend
Java Spring Boot Backend für das Webprojekt

## Methoden
Instrument: "/instruments"
- Alle Instrumente: Get ""
- Einzelnes Instrument: Get "/{id}"
- Alle Instrumente für Type: Get "/getAllType/{type}"
- Alle Ausgeliehenen: Get "/AllBooked"
- Instrument als Ausgeliehen markieren: Put "/book/{id}"
- Instrument als Verfügbar markieren: Put "/return/{id}"

## Instrument Hinzufügen: Put "/add" 
RequestObjekt:
	String type;
	double price;
	String name;
	String description;
	String category;

## Instrument Löschen: Delete "/{id}"
