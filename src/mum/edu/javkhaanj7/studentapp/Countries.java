package mum.edu.javkhaanj7.studentapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Countries {
	
	private List<Country> countryList;
	
	public Countries(){		
		initCountries();
	}

	public void initCountries(){
		
		countryList = new ArrayList<Country>();
		
		countryList.add(new Country("Afghanistan", new String[]{"Afghanistan"}, "Afghanistan.png"));
		countryList.add(new Country("African Union(OAS)", new String[]{"African Union(OAS)"}, "African Union(OAS).png"));
		countryList.add(new Country("Albania", new String[]{"Albania"}, "Albania.png"));
		countryList.add(new Country("Algeria", new String[]{"Algeria"}, "Algeria.png"));
		countryList.add(new Country("American Samoa", new String[]{"American Samoa"}, "American Samoa.png"));
		countryList.add(new Country("Andorra", new String[]{"Andorra"}, "Andorra.png"));
		countryList.add(new Country("Angola", new String[]{"Angola"}, "Angola.png"));
		countryList.add(new Country("Anguilla", new String[]{"Anguilla"}, "Anguilla.png"));
		countryList.add(new Country("Antarctica", new String[]{"Antarctica"}, "Antarctica.png"));
		countryList.add(new Country("Antigua & Barbuda", new String[]{"Antigua & Barbuda"}, "Antigua & Barbuda.png"));
		countryList.add(new Country("Arab League", new String[]{"Arab League"}, "Arab League.png"));
		countryList.add(new Country("Argentina", new String[]{"Argentina"}, "Argentina.png"));
		countryList.add(new Country("Armenia", new String[]{"Armenia"}, "Armenia.png"));
		countryList.add(new Country("Aruba", new String[]{"Aruba"}, "Aruba.png"));
		countryList.add(new Country("ASEAN", new String[]{"ASEAN"}, "ASEAN.png"));
		countryList.add(new Country("Australia", new String[]{"Australia"}, "Australia.png"));
		countryList.add(new Country("Austria", new String[]{"Austria"}, "Austria.png"));
		countryList.add(new Country("Azerbaijan", new String[]{"Azerbaijan"}, "Azerbaijan.png"));
		countryList.add(new Country("Bahamas", new String[]{"Bahamas"}, "Bahamas.png"));
		countryList.add(new Country("Bahrain", new String[]{"Bahrain"}, "Bahrain.png"));
		countryList.add(new Country("Bangladesh", new String[]{"Bangladesh"}, "Bangladesh.png"));
		countryList.add(new Country("Barbados", new String[]{"Barbados"}, "Barbados.png"));
		countryList.add(new Country("Belarus", new String[]{"Belarus"}, "Belarus.png"));
		countryList.add(new Country("Belgium", new String[]{"Belgium"}, "Belgium.png"));
		countryList.add(new Country("Belize", new String[]{"Belize"}, "Belize.png"));
		countryList.add(new Country("Benin", new String[]{"Benin"}, "Benin.png"));
		countryList.add(new Country("Bermuda", new String[]{"Bermuda"}, "Bermuda.png"));
		countryList.add(new Country("Bhutan", new String[]{"Bhutan"}, "Bhutan.png"));
		countryList.add(new Country("Bolivia", new String[]{"Bolivia"}, "Bolivia.png"));
		countryList.add(new Country("Bosnia & Herzegovina", new String[]{"Bosnia & Herzegovina"}, "Bosnia & Herzegovina.png"));
		countryList.add(new Country("Botswana", new String[]{"Botswana"}, "Botswana.png"));
		countryList.add(new Country("Brazil", new String[]{"Brazil"}, "Brazil.png"));
		countryList.add(new Country("Brunei", new String[]{"Brunei"}, "Brunei.png"));
		countryList.add(new Country("Bulgaria", new String[]{"Bulgaria"}, "Bulgaria.png"));
		countryList.add(new Country("Burkina Faso", new String[]{"Burkina Faso"}, "Burkina Faso.png"));
		countryList.add(new Country("Burundi", new String[]{"Burundi"}, "Burundi.png"));
		countryList.add(new Country("Cambodia", new String[]{"Cambodja", "Cambodia"}, "Cambodja.png"));
		countryList.add(new Country("Cameroon", new String[]{"Cameroon"}, "Cameroon.png"));
		countryList.add(new Country("Canada", new String[]{"Canada"}, "Canada.png"));
		countryList.add(new Country("Cape Verde", new String[]{"Cape Verde"}, "Cape Verde.png"));
		countryList.add(new Country("CARICOM", new String[]{"CARICOM"}, "CARICOM.png"));
		countryList.add(new Country("Cayman Islands", new String[]{"Cayman Islands"}, "Cayman Islands.png"));
		countryList.add(new Country("Central African Republic", new String[]{"Central African Republic"}, "Central African Republic.png"));
		countryList.add(new Country("Chad", new String[]{"Chad"}, "Chad.png"));
		countryList.add(new Country("Chile", new String[]{"Chile"}, "Chile.png"));
		countryList.add(new Country("China", new String[]{"China"}, "China.png"));
		countryList.add(new Country("CIS", new String[]{"CIS"}, "CIS.png"));
		countryList.add(new Country("Colombia", new String[]{"Colombia"}, "Colombia.png"));
		countryList.add(new Country("Commonwealth", new String[]{"Commonwealth"}, "Commonwealth.png"));
		countryList.add(new Country("Comoros", new String[]{"Comoros"}, "Comoros.png"));
		countryList.add(new Country("Congo-Brazzaville", new String[]{"Congo-Brazzaville"}, "Congo-Brazzaville.png"));
		countryList.add(new Country("Congo-Kinshasa(Zaire)", new String[]{"Congo-Kinshasa(Zaire)"}, "Congo-Kinshasa(Zaire).png"));
		countryList.add(new Country("Cook Islands", new String[]{"Cook Islands"}, "Cook Islands.png"));
		countryList.add(new Country("Costa Rica", new String[]{"Costa Rica"}, "Costa Rica.png"));
		countryList.add(new Country("Cote d'Ivoire", new String[]{"Cote d'Ivoire"}, "Cote d'Ivoire.png"));
		countryList.add(new Country("Croatia", new String[]{"Croatia"}, "Croatia.png"));
		countryList.add(new Country("Cuba", new String[]{"Cuba"}, "Cuba.png"));
		countryList.add(new Country("Cyprus", new String[]{"Cyprus"}, "Cyprus.png"));
		countryList.add(new Country("Czech Republic", new String[]{"Czech Republic"}, "Czech Republic.png"));
		countryList.add(new Country("Denmark", new String[]{"Denmark"}, "Denmark.png"));
		countryList.add(new Country("Djibouti", new String[]{"Djibouti"}, "Djibouti.png"));
		countryList.add(new Country("Dominica", new String[]{"Dominica"}, "Dominica.png"));
		countryList.add(new Country("Dominican Republic", new String[]{"Dominican Republic"}, "Dominican Republic.png"));
		countryList.add(new Country("Ecuador", new String[]{"Ecuador"}, "Ecuador.png"));
		countryList.add(new Country("Egypt", new String[]{"Egypt"}, "Egypt.png"));
		countryList.add(new Country("El Salvador", new String[]{"El Salvador"}, "El Salvador.png"));
		countryList.add(new Country("England", new String[]{"England"}, "England.png"));
		countryList.add(new Country("Equatorial Guinea", new String[]{"Equatorial Guinea"}, "Equatorial Guinea.png"));
		countryList.add(new Country("Eritrea", new String[]{"Eritrea"}, "Eritrea.png"));
		countryList.add(new Country("Estonia", new String[]{"Estonia"}, "Estonia.png"));
		countryList.add(new Country("Ethiopia", new String[]{"Ethiopia"}, "Ethiopia.png"));
		countryList.add(new Country("European Union", new String[]{"European Union"}, "European Union.png"));
		countryList.add(new Country("Faroes", new String[]{"Faroes"}, "Faroes.png"));
		countryList.add(new Country("Fiji", new String[]{"Fiji"}, "Fiji.png"));
		countryList.add(new Country("Finland", new String[]{"Finland"}, "Finland.png"));
		countryList.add(new Country("France", new String[]{"France"}, "France.png"));
		countryList.add(new Country("Gabon", new String[]{"Gabon"}, "Gabon.png"));
		countryList.add(new Country("Gambia", new String[]{"Gambia"}, "Gambia.png"));
		countryList.add(new Country("Georgia", new String[]{"Georgia"}, "Georgia.png"));
		countryList.add(new Country("Germany", new String[]{"Germany"}, "Germany.png"));
		countryList.add(new Country("Ghana", new String[]{"Ghana"}, "Ghana.png"));
		countryList.add(new Country("Gibraltar", new String[]{"Gibraltar"}, "Gibraltar.png"));
		countryList.add(new Country("Greece", new String[]{"Greece"}, "Greece.png"));
		countryList.add(new Country("Greenland", new String[]{"Greenland"}, "Greenland.png"));
		countryList.add(new Country("Grenada", new String[]{"Grenada"}, "Grenada.png"));
		countryList.add(new Country("Guadeloupe", new String[]{"Guadeloupe"}, "Guadeloupe.png"));
		countryList.add(new Country("Guam", new String[]{"Guam"}, "Guam.png"));
		countryList.add(new Country("Guatemala", new String[]{"Guatemala"}, "Guatemala.png"));
		countryList.add(new Country("Guernsey", new String[]{"Guernsey"}, "Guernsey.png"));
		countryList.add(new Country("Guinea", new String[]{"Guinea"}, "Guinea.png"));
		countryList.add(new Country("Guinea-Bissau", new String[]{"Guinea-Bissau"}, "Guinea-Bissau.png"));
		countryList.add(new Country("Guyana", new String[]{"Guyana"}, "Guyana.png"));
		countryList.add(new Country("Haiti", new String[]{"Haiti"}, "Haiti.png"));
		countryList.add(new Country("Honduras", new String[]{"Honduras"}, "Honduras.png"));
		countryList.add(new Country("Hong Kong", new String[]{"Hong Kong"}, "Hong Kong.png"));
		countryList.add(new Country("Hungary", new String[]{"Hungary"}, "Hungary.png"));
		countryList.add(new Country("Iceland", new String[]{"Iceland"}, "Iceland.png"));
		countryList.add(new Country("India", new String[]{"India"}, "India.png"));
		countryList.add(new Country("Indonezia", new String[]{"Indonezia"}, "Indonezia.png"));
		countryList.add(new Country("Iran", new String[]{"Iran"}, "Iran.png"));
		countryList.add(new Country("Iraq", new String[]{"Iraq"}, "Iraq.png"));
		countryList.add(new Country("Ireland", new String[]{"Ireland"}, "Ireland.png"));
		countryList.add(new Country("Islamic Conference", new String[]{"Islamic Conference"}, "Islamic Conference.png"));
		countryList.add(new Country("Isle of Man", new String[]{"Isle of Man"}, "Isle of Man.png"));
		countryList.add(new Country("Israel", new String[]{"Israel"}, "Israel.png"));
		countryList.add(new Country("Italy", new String[]{"Italy"}, "Italy.png"));
		countryList.add(new Country("Jamaica", new String[]{"Jamaica"}, "Jamaica.png"));
		countryList.add(new Country("Japan", new String[]{"Japan"}, "Japan.png"));
		countryList.add(new Country("Jersey", new String[]{"Jersey"}, "Jersey.png"));
		countryList.add(new Country("Jordan", new String[]{"Jordan"}, "Jordan.png"));
		countryList.add(new Country("Kazakhstan", new String[]{"Kazakhstan"}, "Kazakhstan.png"));
		countryList.add(new Country("Kenya", new String[]{"Kenya"}, "Kenya.png"));
		countryList.add(new Country("Kiribati", new String[]{"Kiribati"}, "Kiribati.png"));
		countryList.add(new Country("Kosovo", new String[]{"Kosovo"}, "Kosovo.png"));
		countryList.add(new Country("Kuwait", new String[]{"Kuwait"}, "Kuwait.png"));
		countryList.add(new Country("Kyrgyzstan", new String[]{"Kyrgyzstan"}, "Kyrgyzstan.png"));
		countryList.add(new Country("Laos", new String[]{"Laos"}, "Laos.png"));
		countryList.add(new Country("Latvia", new String[]{"Latvia"}, "Latvia.png"));
		countryList.add(new Country("Lebanon", new String[]{"Lebanon"}, "Lebanon.png"));
		countryList.add(new Country("Lesotho", new String[]{"Lesotho"}, "Lesotho.png"));
		countryList.add(new Country("Liberia", new String[]{"Liberia"}, "Liberia.png"));
		countryList.add(new Country("Libya", new String[]{"Libya"}, "Libya.png"));
		countryList.add(new Country("Liechtenstein", new String[]{"Liechtenstein"}, "Liechtenstein.png"));
		countryList.add(new Country("Lithuania", new String[]{"Lithuania"}, "Lithuania.png"));
		countryList.add(new Country("Luxembourg", new String[]{"Luxembourg"}, "Luxembourg.png"));
		countryList.add(new Country("Macao", new String[]{"Macao"}, "Macao.png"));
		countryList.add(new Country("Macedonia", new String[]{"Macedonia"}, "Macedonia.png"));
		countryList.add(new Country("Madagascar", new String[]{"Madagascar"}, "Madagascar.png"));
		countryList.add(new Country("Malawi", new String[]{"Malawi"}, "Malawi.png"));
		countryList.add(new Country("Malaysia", new String[]{"Malaysia"}, "Malaysia.png"));
		countryList.add(new Country("Maldives", new String[]{"Maldives"}, "Maldives.png"));
		countryList.add(new Country("Mali", new String[]{"Mali"}, "Mali.png"));
		countryList.add(new Country("Malta", new String[]{"Malta"}, "Malta.png"));
		countryList.add(new Country("Marshall Islands", new String[]{"Marshall Islands"}, "Marshall Islands.png"));
		countryList.add(new Country("Martinique", new String[]{"Martinique"}, "Martinique.png"));
		countryList.add(new Country("Mauritania", new String[]{"Mauritania"}, "Mauritania.png"));
		countryList.add(new Country("Mauritius", new String[]{"Mauritius"}, "Mauritius.png"));
		countryList.add(new Country("Mexico", new String[]{"Mexico"}, "Mexico.png"));
		countryList.add(new Country("Micronesia", new String[]{"Micronesia"}, "Micronesia.png"));
		countryList.add(new Country("Moldova", new String[]{"Moldova", "Republic of Moldova"}, "Moldova.png"));
		countryList.add(new Country("Monaco", new String[]{"Monaco"}, "Monaco.png"));
		countryList.add(new Country("Mongolia", new String[]{"Mongolia"}, "Mongolia.png"));
		countryList.add(new Country("Montenegro", new String[]{"Montenegro"}, "Montenegro.png"));
		countryList.add(new Country("Montserrat", new String[]{"Montserrat"}, "Montserrat.png"));
		countryList.add(new Country("Morocco", new String[]{"Morocco"}, "Morocco.png"));
		countryList.add(new Country("Mozambique", new String[]{"Mozambique"}, "Mozambique.png"));
		countryList.add(new Country("Myanmar(Burma)", new String[]{"Myanmar(Burma)"}, "Myanmar(Burma).png"));
		countryList.add(new Country("Namibia", new String[]{"Namibia"}, "Namibia.png"));
		countryList.add(new Country("NATO", new String[]{"NATO"}, "NATO.png"));
		countryList.add(new Country("Nauru", new String[]{"Nauru"}, "Nauru.png"));
		countryList.add(new Country("Nepal", new String[]{"Nepal"}, "Nepal.png"));
		countryList.add(new Country("Netherlands Antilles", new String[]{"Netherlands Antilles"}, "Netherlands Antilles.png"));
		countryList.add(new Country("Netherlands", new String[]{"Netherlands"}, "Netherlands.png"));
		countryList.add(new Country("New Caledonia", new String[]{"New Caledonia"}, "New Caledonia.png"));
		countryList.add(new Country("New Zealand", new String[]{"New Zealand"}, "New Zealand.png"));
		countryList.add(new Country("Nicaragua", new String[]{"Nicaragua"}, "Nicaragua.png"));
		countryList.add(new Country("Niger", new String[]{"Niger"}, "Niger.png"));
		countryList.add(new Country("Nigeria", new String[]{"Nigeria"}, "Nigeria.png"));
		countryList.add(new Country("North Korea", new String[]{"North Korea"}, "North Korea.png"));
		countryList.add(new Country("Northern Cyprus", new String[]{"Northern Cyprus"}, "Northern Cyprus.png"));
		countryList.add(new Country("Northern Ireland", new String[]{"Northern Ireland"}, "Northern Ireland.png"));
		countryList.add(new Country("Norway", new String[]{"Norway"}, "Norway.png"));
		countryList.add(new Country("Olimpic Movement", new String[]{"Olimpic Movement"}, "Olimpic Movement.png"));
		countryList.add(new Country("Oman", new String[]{"Oman"}, "Oman.png"));
		countryList.add(new Country("OPEC", new String[]{"OPEC"}, "OPEC.png"));
		countryList.add(new Country("Pakistan", new String[]{"Pakistan"}, "Pakistan.png"));
		countryList.add(new Country("Palau", new String[]{"Palau"}, "Palau.png"));
		countryList.add(new Country("Palestine", new String[]{"Palestine", "Palestine, West Bank"}, "Palestine.png"));
		countryList.add(new Country("Panama", new String[]{"Panama"}, "Panama.png"));
		countryList.add(new Country("Papua New Guinea", new String[]{"Papua New Guinea"}, "Papua New Guinea.png"));
		countryList.add(new Country("Paraguay", new String[]{"Paraguay"}, "Paraguay.png"));
		countryList.add(new Country("Peru", new String[]{"Peru"}, "Peru.png"));
		countryList.add(new Country("Philippines", new String[]{"Philippines"}, "Philippines.png"));
		countryList.add(new Country("Poland", new String[]{"Poland"}, "Poland.png"));
		countryList.add(new Country("Portugal", new String[]{"Portugal"}, "Portugal.png"));
		countryList.add(new Country("Puerto Rico", new String[]{"Puerto Rico"}, "Puerto Rico.png"));
		countryList.add(new Country("Qatar", new String[]{"Qatar"}, "Qatar.png"));
		countryList.add(new Country("Red Cross", new String[]{"Red Cross"}, "Red Cross.png"));
		countryList.add(new Country("Reunion", new String[]{"Reunion"}, "Reunion.png"));
		countryList.add(new Country("Romania", new String[]{"Romania"}, "Romania.png"));
		countryList.add(new Country("Russian Federation", new String[]{"Russian Federation"}, "Russian Federation.png"));
		countryList.add(new Country("Rwanda", new String[]{"Rwanda"}, "Rwanda.png"));
		countryList.add(new Country("Saint Lucia", new String[]{"Saint Lucia"}, "Saint Lucia.png"));
		countryList.add(new Country("Samoa", new String[]{"Samoa"}, "Samoa.png"));
		countryList.add(new Country("San Marino", new String[]{"San Marino"}, "San Marino.png"));
		countryList.add(new Country("Sao Tome & Principe", new String[]{"Sao Tome & Principe"}, "Sao Tome & Principe.png"));
		countryList.add(new Country("Saudi Arabia", new String[]{"Saudi Arabia"}, "Saudi Arabia.png"));
		countryList.add(new Country("Scotland", new String[]{"Scotland"}, "Scotland.png"));
		countryList.add(new Country("Senegal", new String[]{"Senegal"}, "Senegal.png"));
		countryList.add(new Country("Serbia(Yugoslavia)", new String[]{"Serbia(Yugoslavia)"}, "Serbia(Yugoslavia).png"));
		countryList.add(new Country("Seychelles", new String[]{"Seychelles"}, "Seychelles.png"));
		countryList.add(new Country("Sierra Leone", new String[]{"Sierra Leone"}, "Sierra Leone.png"));
		countryList.add(new Country("Singapore", new String[]{"Singapore"}, "Singapore.png"));
		countryList.add(new Country("Slovakia", new String[]{"Slovakia"}, "Slovakia.png"));
		countryList.add(new Country("Slovenia", new String[]{"Slovenia"}, "Slovenia.png"));
		countryList.add(new Country("Solomon Islands", new String[]{"Solomon Islands"}, "Solomon Islands.png"));
		countryList.add(new Country("Somalia", new String[]{"Somalia"}, "Somalia.png"));
		countryList.add(new Country("Somaliland", new String[]{"Somaliland"}, "Somaliland.png"));
		countryList.add(new Country("South Africa", new String[]{"South Africa"}, "South Africa.png"));
		countryList.add(new Country("South Korea", new String[]{"South Korea"}, "South Korea.png"));
		countryList.add(new Country("Spain", new String[]{"Spain"}, "Spain.png"));
		countryList.add(new Country("Sri Lanka", new String[]{"Sri Lanka"}, "Sri Lanka.png"));
		countryList.add(new Country("St Kitts & Nevis", new String[]{"St Kitts & Nevis"}, "St Kitts & Nevis.png"));
		countryList.add(new Country("St Vincent & the Grenadines", new String[]{"St Vincent & the Grenadines"}, "St Vincent & the Grenadines.png"));
		countryList.add(new Country("Sudan", new String[]{"Sudan"}, "Sudan.png"));
		countryList.add(new Country("Suriname", new String[]{"Suriname"}, "Suriname.png"));
		countryList.add(new Country("Swaziland", new String[]{"Swaziland"}, "Swaziland.png"));
		countryList.add(new Country("Sweden", new String[]{"Sweden"}, "Sweden.png"));
		countryList.add(new Country("Switzerland", new String[]{"Switzerland"}, "Switzerland.png"));
		countryList.add(new Country("Syria", new String[]{"Syria"}, "Syria.png"));
		countryList.add(new Country("Tahiti(French Polinesia)", new String[]{"Tahiti(French Polinesia)"}, "Tahiti(French Polinesia).png"));
		countryList.add(new Country("Taiwan", new String[]{"Taiwan"}, "Taiwan.png"));
		countryList.add(new Country("Tajikistan", new String[]{"Tajikistan"}, "Tajikistan.png"));
		countryList.add(new Country("Tanzania", new String[]{"Tanzania"}, "Tanzania.png"));
		countryList.add(new Country("Thailand", new String[]{"Thailand"}, "Thailand.png"));
		countryList.add(new Country("Timor-Leste", new String[]{"Timor-Leste"}, "Timor-Leste.png"));
		countryList.add(new Country("Togo", new String[]{"Togo"}, "Togo.png"));
		countryList.add(new Country("Tonga", new String[]{"Tonga"}, "Tonga.png"));
		countryList.add(new Country("Trinidad & Tobago", new String[]{"Trinidad & Tobago"}, "Trinidad & Tobago.png"));
		countryList.add(new Country("Tunisia", new String[]{"Tunisia"}, "Tunisia.png"));
		countryList.add(new Country("Turkey", new String[]{"Turkey"}, "Turkey.png"));
		countryList.add(new Country("Turkmenistan", new String[]{"Turkmenistan"}, "Turkmenistan.png"));
		countryList.add(new Country("Turks and Caicos Islands", new String[]{"Turks and Caicos Islands"}, "Turks and Caicos Islands.png"));
		countryList.add(new Country("Tuvalu", new String[]{"Tuvalu"}, "Tuvalu.png"));
		countryList.add(new Country("Uganda", new String[]{"Uganda"}, "Uganda.png"));
		countryList.add(new Country("Ukraine", new String[]{"Ukraine"}, "Ukraine.png"));
		countryList.add(new Country("United Arab Emirates", new String[]{"United Arab Emirates"}, "United Arab Emirates.png"));
		countryList.add(new Country("United Kingdom(Great Britain)", new String[]{"United Kingdom(Great Britain)"}, "United Kingdom(Great Britain).png"));
		countryList.add(new Country("United Nations", new String[]{"United Nations"}, "United Nations.png"));
		countryList.add(new Country("United States of America (USA)", new String[]{"United States of America (USA)"}, "United States of America (USA).png"));
		countryList.add(new Country("Uruguay", new String[]{"Uruguay"}, "Uruguay.png"));
		countryList.add(new Country("Uzbekistan", new String[]{"Uzbekistan"}, "Uzbekistan.png"));
		countryList.add(new Country("Vanutau", new String[]{"Vanutau"}, "Vanutau.png"));
		countryList.add(new Country("Vatican City", new String[]{"Vatican City"}, "Vatican City.png"));
		countryList.add(new Country("Venezuela", new String[]{"Venezuela"}, "Venezuela.png"));
		countryList.add(new Country("Viet Nam", new String[]{"Viet Nam"}, "Viet Nam.png"));
		countryList.add(new Country("Virgin Islands British", new String[]{"Virgin Islands British"}, "Virgin Islands British.png"));
		countryList.add(new Country("Virgin Islands US", new String[]{"Virgin Islands US"}, "Virgin Islands US.png"));
		countryList.add(new Country("Wales", new String[]{"Wales"}, "Wales.png"));
		countryList.add(new Country("Western Sahara", new String[]{"Western Sahara"}, "Western Sahara.png"));
		countryList.add(new Country("Yemen", new String[]{"Yemen"}, "Yemen.png"));
		countryList.add(new Country("Zambia", new String[]{"Zambia"}, "Zambia.png"));
		countryList.add(new Country("Zimbabwe", new String[]{"Zimbabwe"}, "Zimbabwe.png"));
	}

	public List<Country> getCountryList() {
		return countryList;
	}
	
	public Country getCountryByKeyName(String keyName){
		Country country = null;
		
		if(countryList != null){			
			for(int i = 0; i < countryList.size(); i++){
				String keyNames[] = countryList.get(i).getKeyNames();
				if(Arrays.asList(keyNames).contains(keyName)){
					country = countryList.get(i);
				}
			}
		}
		
		return country;
	}
	
}
