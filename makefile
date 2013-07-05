
first: package

package:
	ant -f fitnis.xml
cp:
	ant -f fitnis.xml compile.module.fitnis.production

dist: build
	tar cvzf fitnis.tar.gz build

distwiki: wikidata
	tar cvzf fitnis-wiki.tar.gz build

build: wikidata
	cp -r fitnis makefile log4j.properties build/

wikidata: 
	rm build -rf
	mkdir build/FitNesseRoot -p
	cp -r ExTest/ build/FitNesseRoot/
	find build/FitNesseRoot/ExTest/ -name '*.zip'|xargs rm -f

setupwiki:
	tar xvf fitnis-wiki.tar.gz
	cp -r build/FitNesseRoot/* FitNesseRoot/

st:
	hg st -X extlib/ -X FitNesseRoot/ -X build/ -X out/ -X .idea/ -X fitnesse.jar 
to205:
	rm tmp -rf
	mkdir tmp
	cp -r FitNesseRoot/DouDouTest/ tmp/
	find tmp/DouDouTest -name '*.zip'|xargs rm
	scp -r tmp/DouDouTest/ root@192.168.1.205:/home/fitnis/FitNesseRoot/

install:
	pwd|printf "fitnis_home=%s" $$(cat) > /usr/bin/fitnis
	cat fitnis >> /usr/bin/fitnis
	chmod +x /usr/bin/fitnis
	mkdir -p /etc/fitnis
	cp log4j.properties /etc/fitnis/

clean:
	rm build -rf
	rm fitnis.tar.gz -f
	ant -f fitnis.xml clean
