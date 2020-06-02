const admin = require('firebase-admin');
const serviceAccount = require('./birdsadventureprikey.json');

//initialize admin SDK using serciceAcountKey
admin.initializeApp({
credential: admin.credential.cert(serviceAccount)
});
const db = admin.firestore();



function getDialogue(){
//return a promise since we'll imitating an API call
return new Promise(function(resolve, reject) 
{
resolve({
 
});
})
}


getDialogue().then(result =>{
   console.log(result);
   const obj = result;
 
/////////////////Sign up///////////////////
admin.auth().createUser({
  email: 'jot220@example.com',
  Name: 'John Doe',
  phoneNumber: '+18234567890',
  address: 'montreal',
  password: 'secretPassword',
  confirmpassword: 'secretPassword',
  status: true
})
  .then(function(userRecord) {
    // See the UserRecord reference doc for the contents of userRecord.


    console.log('Successfully created new user:', userRecord.uid);
  let newuser = {
   email: 'jot22@example.com',
   Name: 'John Doe',
   phoneNumber: '+18234567890',
   address: 'montreal',
   password: 'secretPassword',
   confirmpassword: 'secretPassword',
   status: true
 
};
      let setnewuserDoc1 = db.collection('Users').doc('user21').set(newuser);

  })
  .catch(function(error) {
    console.log('Error creating new user:', error);
  });


//////////////////// login /////////////////

/*admin.auth().signInWithEmailAndPassword("jot30@gmail.com", "jotdhaliwal").then(function ()
{
	 this.authStatus = 'Authorized'
            console.log('Authorized');
        }).catch(function(error)
        {
        this.authStatus = error

        });*/
      





///////logout/////
/*admin.auth().signOut().then(function() {
    console.log('Sign out Successfull new user');
}).catch(function(error) {
    console.log('Error logging out  user:', error);
});*/


  ///////Bird Collection///////////////////////////






   let Bird1 = {
   id:01,
    name:"Northern cardinal ",
    Description:"The northern cardinal is a medium-sized songbird, with males slightly larger than females. Males are bright red with a black mask around their red bill and a prominent crest on the top of their head. Females are olive brown with red on their wings, tail, and crest, and a red bill. Juveniles are similar in colour to females but have a black bill and a shorter crest.",
    Height:"2.2-2.7 cm",
    Weight:"42-48 g",
    Diet:"The diet of the northern cardinal consists mainly of insects and vegetable material. Vegetable material may include weed seeds, leaf buds, grains, and berries..",
    Region:"South Canada",
    City:" Minnesota",
    Colour:" Brilliant  red",
    Biome:"Forest",
    Habitat:"The northern cardinal doesn’t migrate. Instead it stays in its territory year-round. It makes its home in thickets and brushy areas and at the edges of woodlands."
};

// Add a new document in collection "Birds" with ID 'Bird1'
let setDoc1 = db.collection('Birds').doc('Bird1').set(Bird1);
   console.log('new Bird 1 has been added to the database')



    let Bird2 = {

   id:02,
    name:"Pileated woodpecker",
    Description:"The pileated is the largest woodpecker in Canada. \
    These colossal birds, with their striking red crest and resemblance \
    to prehistoric pterodactyls in flight, are thought to be the inspiration for\
    the once popular cartoon Woody the Woodpecker. As Woody had his loud laugh, pileated\
    woodpeckers also made noise to match their size. Their drumming, reminiscent of construction machinery,\
    can be heard up to a kilometre away.",
    Height:" 40-49 cm",
    Weight:"364 g",
    Diet:"Pileated woodpeckers are primarily insect eaters. Their favourite food is carpenter ants.",
    Region:"Canada",
    City:" Quebec and central Ontario",
    Colour:"Dull black and  red crest",
    Biome:"Deciduous or mixed deciduous-coniferous woodlands",
    Habitat:"Pileated woodpeckers need large uninterrupted patches of woodland, covering territories of 100 to 200 acres. These large birds live in older coniferous or deciduous forests - and occasionally in younger forests with old dead trees in it."
};

// Add a new document in collection "Birds" with ID 'Bird2'
let setDoc2 = db.collection('Birds').doc('Bird2').set(Bird2);
   console.log('new Bird 2 has been added to the database')


   let Bird3 = {
   id:03,
    name:"Neotropic Cormorant",
    Description:"The male has a beautiful flute-like song, which he performs throughout\
    the summer. The female’s song, in comparison, is shorter and simpler. While songs \
    vary slightly from one bird to the next, they always have the recognizable “hew-li”\
    sound.",
    Height:"17–22 cm",
    Weight:"22.3 to 42 g",
    Diet:"While caterpillars form a large part of their diet, orioles also eat spiders, \
    grasshoppers, crickets, beetles, butterflies, moths and fruit.",
    Region:"Canada",
    City:"British Columbia.",
    Colour:"brilliant orange breast, shoulder patch and rump contrasted\
     with a black head, back, wings and tai",
    Biome:"Grassland; forest; rainforest; scrub forest.",
    Habitat:" They have a preference for deciduous trees and open areas \
    and have adapted well to parks and suburban regions."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc3 = db.collection('Birds').doc('Bird3').set(Bird3);
   console.log('new Bird 3 has been added to the database')


//bird4
 let Bird4 = {
   id:04,
    name:"Black-capped Chickadee",
    Description:"Black-capped Chickadees are small birds. The Gray-headed Chickadee \
    ecile cincta is widely distributed across Asia and Europe. In North America,\
     this brownish-grey chickadee is found in a small corner of the northwestern \
     Yukon and eastern Alaska, where it lives in the willow and spruce woods bordering the treeline.",
    Height:"12 to 15 centimetres",
    Weight:"9-14 g",
    Diet:"The Black-capped Chickadee eats a mixture of seeds, insects and spiders",
    Region:"Canada",
    City:"Nova Scotia, Saskatchewan, Quebec",
    Colour:"Grey backs, a black cap that covers their eyes, white cheeks and a black triangular bib on the throat. ",
    Biome:"taiga; forest.",
    Habitat:"It lives in tree-covered areas — including woodlots and orchards."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc4 = db.collection('Birds').doc('Bird4').set(Bird4);
   console.log('new Bird 4 has been added to the database')




//bird5
 let Bird5 = {
   id:05,
    name:"Burrowing owl",
    Description:" The burrowing owl is now much more rare. The Canadian population \
    f this little bird of prey has declined over 95 per cent since 1987, and now occupies \
    a mere 36 percent of its original distribution in Canada. This alarming rate of decline\
     has motivated scientists to list the species as endangered under the Species at Risk Act.",
    Height:"20 cm",
    Weight:"150 g",
    Diet:"Burrowing Owls eat invertebrates and small vertebrates, including lizards, birds,\
     and mammals. Invertebrates, especially insects",
    Region:"Canada",
    City:"Manitoba, Saskatchewan, Alberta, and British Columbia",
    Colour:"  Adults are brown birds mottled with sandy-pale spots on the upperparts.\
    The breast is spotted, grading to dark brown bars on the belly",
    Biome:"Nest on the ground and often occupy abandoned burrows of small mammals ",
    Habitat:"Burrowing Owls live in open, treeless areas with low, sparse vegetation,\
     usually on gently sloping terrain. The owls can be found in grasslands, deserts, and steppe environments."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc5 = db.collection('Birds').doc('Bird5').set(Bird5);
   console.log('new Bird 5 has been added to the database')


//bird6
 let Bird6 = {
   id:06,
    name:"Cedar Waxwings",
    Description:"The Cedar Waxwing gets its name in part due to the brightly coloured wax-like tips of their\
     feathers. “Cedar” comes from their consumption of juniper berries. While several different \
     trees have the word “cedar” in their common name, one, the Eastern Redcedar (Juniperus virginiana)\
     which is actually a juniper, has blue fruit that these waxwings eat. They have a bright yellow band at \
     the end of their tails. Sometimes you can see a thin red stripe on the edge of their secondary wing feathers.",
    Height:"14-17 cm",
    Weight:"32 g",
    Diet:"Cedar Waxwings eat small fruit year round. They will feed from shrubs and trees\
     like mountain ash, dogwoods, and serviceberries.",
    Region:"Canada",
    City:"Saskatchewan,Alberta",
    Colour:"Creamy yellow below, have light brown colouring on their heads and upper backs, grey on their\
     lower backs and wings and a black mask across the top of their bills that extends around their eyes",
    Biome:"forest edges, streamsides",
    Habitat:"These birds are found in open forests, woodlands, along streams and small rivers, fields, parks and gardens where fruit trees grow"
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc6 = db.collection('Birds').doc('Bird6').set(Bird6);
   console.log('new Bird 6 has been added to the database')



//bird7
 let Bird7 = {
   id:07,
    name:"Common redpoll",
    Description:"The common redpoll is a small bird. A member of the finch family, this streaked bird can be difficult\
     to distinguish from pine siskins. Redpolls are named for their red forehead but this is not always obvious, so look \
     instead for the black patch on their chin to recognize them. To identify the sex of common redpolls look for the slight tinge \
     of rose on the breasts of the males.",
    Height:"11-14 cm",
    Weight:"12 and 16 g",
    Diet:"Redpolls subsist almost entirely on a diet of birch seeds",
    Region:"Canada",
    City:"Yukon, Northwest and Nunavut",
    Colour:" Brownish-grey finch",
    Biome:"woodland edges and brushy",
    Habitat:"Common redpolls are one of the most northern breeding finches, building their nests in the dwarfed willows, spruce, \
    birch, or alders of subarctic forests or the scattered shrubs of northern tundra"
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc7 = db.collection('Birds').doc('Bird7').set(Bird7);
   console.log('new Bird 7  has been added to the database')


//bird8
 let Bird8 = {
   id:08,
    name:"Dark-eyed juncos",
    Description:"Dark-eyed juncos vary geographically in terms of their colouration.\
     Depending on the region, the backs and sides of dark-eyed juncos can vary from dark grey \
     to reddish-brown. In all regions, however, adults can typically be identified by their dark \
     grey to black coloured head and breast (known as their hood), white outer tail feathers and white undersides.",
    Height:"14-16 cm",
    Weight:"18-30 g",
    Diet:"Dark-eyed juncos are ground feeders whose diet changes seasonally. During the breeding season \
    insects make up the bulk of their diet. At this time it’s common to see juncos hopping along the ground\
     in pursuit of their insect prey. In the non-breeding season they forage for seeds, insects and arthropods.",
    Region:"Canada",
    City:"British Columbia ",
    Colour:"Dark grey to black coloured head and breast",
    Biome:"Prefer forest edges",
    Habitat:"In winter, their habitat shifts to roadsides, fields, gardens and parks that offer tree protection."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc8 = db.collection('Birds').doc('Bird8').set(Bird8);
   console.log('new Bird 8 has been added to the database')


//bird8
 let Bird9 = {
   id:09,
    name:"Gray Catbirds",
    Description:"All Gray Catbirds, regardless of their age or gender, are mainly grey with black colouring\
    on the tops of their heads and orange-brown underneath the base of their tail. Their calls are a raspy \
    cat-like sound while their songs are highly variable and often melodic.",
    Height:"21-24 cm",
    Weight:"23.2-56.5 g",
    Diet:"Gray Catbirds eat a variety of insects including ants, grasshoppers, beetles, caterpillars and moths",
    Region:"Canada",
    City:"Yukon, Northwest and Nunavut",
    Colour:"Black cap, blackish tail, and a rich rufous-brown patch under the tail.",
    Biome:"Gray catbirds live in dense thickets of shrubs",
    Habitat:"Gray Catbirds nest and feed in dense shrubby areas in gardens, woods and hedgerows\
     along farm fields. This led to their Latin name, “Dumetella” which loosely translates to “thicket-dweller”.\
      Gray Catbirds also feed on the ground where there is dense vegetation as well as up in treetops."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc9 = db.collection('Birds').doc('Bird9').set(Bird9);
   console.log('new Bird 9 has been added to the database')


//bird8
 let Bird10 = {
   id:10,
    name:"Great Horned Owl",
    Description:"The Great Horned Owl is one of Canada’s commonest large birds of prey. The most notable physical attributes \
    are its large size and prominent ear tufts or 'horns' A predator that hunts at night, this owl has enormous yellow eyes set\
     in a broad face, a curved beak and claws, and long fluffy feathers. Its coloration tends mainly toward brown or grey-brown,\
      with conspicuous barring. This bird’s legendary hooting sounds like a soft yet vibrant whoo-hoo-ho-o-o.",
    Height:"55 cm",
    Weight:"910-2500 g",
    Diet:"The Great Horned Owl mainly depends upon medium-size mammals and birds to rabbits and hares where available.\
     When mice or voles are abundant they will consume these as well.",
    Region:"Canada",
    City:"Nova Scotia, Manitoba, New Brunswick, Newfoundland, Quebec, Saskatchewan, Yukon Territories, Nunavut, Ontario, \
    Prince Edward Island, British Columbia, Alberta",
    Colour:"Gray-brown, with reddish brown faces and a neat white patch on the throat.",
    Biome:"Sitting on fence posts or tree limbs at the edges of open areas,",
    Habitat:"  Rarely moves far from its place of birth and can be found in virtually every forested and semi-forested region in North America."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc10 = db.collection('Birds').doc('Bird10').set(Bird10);
   console.log('new Bird 10 has been added to the database')


//bird11
 let Bird11 = {
   id:11,
    name:"American crow",
    Description:"Crows and their kin are very interesting birds, members of what may be the most intelligent \
    avian family — the Corvidae. The crow’s cousins include magpies, blue jays, jackdaws, rooks, nutcrackers \
    and ravens. Many people use the terms crow and raven interchangeably but the two birds are actually quite different",
    Height:"40-53 cm",
    Weight:"316-620 g",
    Diet:"Crows are omnivorous - they will eat anything edible, and many things, which aren't. Their regular diet includes \
    insects, crops (especially corn), carrion, fruit, nuts and occasionally the eggs or young of other birds",
    Region:"Canada",
    City:"Yukon",
    Colour:"Black",
    Biome:"Nest",
    Habitat:" The crow adapts well to a variety of habitats. Unlike ravens, which prefer the countryside, crows\
     thrive in cities and will gladly make their nests near large human centres."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc11 = db.collection('Birds').doc('Bird11').set(Bird11);
   console.log('new Bird 11 has been added to the database')


//bird12
 let Bird12 = {
   id:12,
    name:"American robin ",
    Description:"The American robin is the largest thrush in North America. Males are not only more vocal than females, \
    but also slightly larger and more brightly coloured. Adult American robins have grey-brown backs, characteristic \
    reddish breasts, white bellies, white chins, yellow bills and throats with dark streaks. Juveniles have dark speckles \
    on their backs and on their cinnamon-coloured breast",
    Height:"20-28 cm",
    Weight:"5.5 g ",
    Diet:"During the spring and summer, it eats invertebrates such as earthworms, caterpillars and beetles, and in the fall\
     and winter switches to fruits such as viburnum, sumac, chokecherries and tomatoes.",
    Region:"Canada, America",
    City:"Saskatchewan, Yukon Territories, Nunavut, Ontario, Prince Edward Island, British Columbia, Alberta",
    Colour:"American Robins are gray-brown birds with warm orange underparts and dark heads",
    Biome:"Nest",
    Habitat:"American Robins are common across the continent in gardens, parks, yards, golf courses, fields, pastures, tundra, \
    as well as deciduous woodlands, pine forests, shrublands, and forests regenerating after fires or logging."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc12 = db.collection('Birds').doc('Bird12').set(Bird12);
   console.log('new Bird 12 has been added to the database')



//bird13
 let Bird13 = {
   id:13,
    name:"Purple Martin",
    Description:"The Purple Martin, Progne subis, is a conspicuous bird in many populated areas\
     of North America during spring and summer. Averaging 17 to 20 cm in length and a wing span of 9-41 cm, \
     it is Canada’s largest swallow. The life span of this swallow is one to five years. The Purple Martin\
      resembles other swallows in having a slender body, long wings, and a wide beak. Males show a shiny blue-black\
       coloration on sunny days. Females are lighter in colour, with a pale grey throat and belly.",
    Height:"  17-20 cm",
    Weight:"45-60 g",
    Diet:"Martins consume a variety of the larger flying insects, including dragonflies, moths, butterflies, house flies, horse flies, and deer flies.",
    Region:"Canada",
    City:"Nova Scotia, the southern portions of New Brunswick, Quebec",
    Colour:"shiny blue-black",
    Biome:"It is happy to nest in human-made.",
    Habitat:"Desert or dune; savanna or grassland; forest; mountains , multi-compartment houses common both in the country and in the cities, \
    sites that can be revisited by the same bird family for up to 100 years."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc13 = db.collection('Birds').doc('Bird13').set(Bird13);
   console.log('new Bird 13 has been added to the database')


//bird14
 let Bird14 = {
   id:14,
    name:"Red-breasted Nuthatch",
    Description:"Red-breasted Nuthatches are small birds reaching about 4.5 inches in length with a thin black bill and short tail. They have a black and white\
     striped head, white throat, grey back and rust-coloured belly.",
    Height:"11 cm",
    Weight:"8-13 g",
    Diet:"These songbirds glean insects and spiders from tree bark. In the winter they eat seeds and nuts such as those from fir, spruce, beech and oak trees.\
     Red-breasted Nuthatches visit feeders with suet and/or sunflower seeds.",
    Region:"Canada",
    City:"Nova Scotia, Manitoba, New Brunswick, Newfoundland, Quebec, Saskatchewan, Yukon Territories, Nunavut,\
     Ontario, Prince Edward Island, British Columbia, Alberta",
    Colour:"It has a black cap and eye line and a white supercilium",
    Biome:"They nest in holes they make themselves in trees, including dead standing trees (snags) and rarely use previously excavated holes or nesting boxes.",
    Habitat:"They prefer coniferous trees but can also be found in mixed woods."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc14 = db.collection('Birds').doc('Bird14').set(Bird14);
   console.log('new Bird 14 has been added to the database')


//bird15
 let Bird15 = {
   id:15,
    name:"Red-winged blackbird ",
    Description:"The red-winged blackbird is a medium-sized songbird, ranging in size from 17 to 23 centimetres, \
    with a very distinct call. Males are a sleek black colour with bright red patches on the tops of their wings. These red patches\
     are called epaulettes and are sometimes less visible while the bird is perched, when it only shows the slight yellow band found \
     below the red epaulettes. Females are less distinctive with their brown- and white-striped backs and white- and brown-striped abdomens. \
     Their colouring often causes them to be mistaken for other species of blackbird or sometimes for sparrows.",
    Height:"17 to 23 cm",
    Weight:"32-77 g",
    Diet:"The diet of a red-winged blackbird consists mostly of seeds and grains.",
    Region:"Canada",
    City:"Yukon to north western British Columbia",
    Colour:"Sleek black colour with bright red patches on the tops of their wings.",
    Biome:" Bushes and small trees, likely constructing their nests from woven marsh vegetation and grasses from surrounding fields and forests.",
    Habitat:"Commonly found living in wetlands, including both fresh and brackish water swamps and marshes, red-winged blackbirds are especially \
    fond of habitats with thick growths of cattails and bulrushes."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc15 = db.collection('Birds').doc('Bird15').set(Bird15);
   console.log('new Bird 15 has been added to the database')


//bird16
 let Bird16 = {
   id:16,
    name:"Rose-breasted grosbeak",
    Description:"With most birds, males are more brightly coloured, and this holds true with the rose-breasted \
    grosbeak. The males are the most attractive with black backs and heads, white bumps and bellies and rose triangular \
    patches on their breasts. The females, however, are not as conspicuous. Females have brown streaking on both their\
     pale under parts and darker backs.Rose-breasted grosbeaks are said to have one of the prettiest calls. It is comparable\
      to that of the American robin but with a more melodic sound.",
    Height:"18-21 cm",
    Weight:"39-49 g",
    Diet:"Rose-breasted grosbeaks feed on insects, seeds, fruits and flower buds. Common items include beetles, \
    bees, ants, crabapples, service berries, elderberries and Juneberries.",
    Region:"Canada",
    City:"British Columbia",
    Colour:"Black backs and heads, white bumps and bellies and rose triangular patches on their breasts",
    Biome:"Rose-breasted Grosbeaks breed in moist deciduous forests.",
    Habitat:"Rose-breasted grosbeaks can be found in a range of habitats including deciduous and mixed woodlands\
    along marshes, lakes, ponds and streams, and in pastures, parks and garden"
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc16 = db.collection('Birds').doc('Bird16').set(Bird16);
   console.log('new Bird 16 has been added to the database')



//bird17
 let Bird17 = {
   id:17,
    name:"Ruby-throated hummingbird",
    Description:"Adult males are metallic green on the upperparts, iridescent ruby red on the throat, white on the \
    underparts and green along the sides. Adult females look similar to males but with a white throat, greyish belly\
     and buff along the sides of the belly, sometimes with a little red on the throat. Immature males look similar to \
     females but with red streaks down the throat.",
    Height:"9–10 cm",
    Weight:" 2-6 g",
    Diet:"Drinks floral nectar, especially of tubular flowers such as the cardinal flower",
    Region:"Canada",
    City:"Alberta to Nova Scotia.",
    Colour:"Ruby red on the throat, white on the underparts and green along the sides.\
    Adult females look similar to males but with a white throat.",
    Biome:"hose in the crook of a tree",
    Habitat:"Mixed, boreal and hardwood forests; woodlands and forest edges, gardens, parks."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc17 = db.collection('Birds').doc('Bird17').set(Bird17);
   console.log('new Bird 17 has been added to the database')


//bird18
 let Bird18 = {
   id:18,
    name:"Rufous hummingbirds",
    Description:"Adult male upperparts are mainly reddish-brown with dull green on the top of their head\
     and a white patch behind the eyes. Their throat is iridescent orange-red and has white at the top of their \
     breast and parts of the belly; the rest of its underparts are reddish-brown. Adult females are similar to males \
     but paler and greener; their throat is white with dark and/or iridescent spots of orange-red. Immature birds resemble\
      the females, but immature males start to show reddish-brown upperparts before their throat colours develop.",
    Height:"9.5 cm",
    Weight:"2.4-3.6 g",
    Diet:"They drink floral nectar from tubular flowers such as wild columbines.",
    Region:"Canada",
    City:"British Columbia, western Alberta",
    Colour:"Adult male upperparts are mainly reddish-brown with dull green on the top of their head and a white patch behind the eyes.",
    Biome:"hose in the crook of a tree",
    Habitat:"Found in a variety of habitats including mountain meadows, forests, woodlands, edges, open shrubby areas, gardens, parks and swamps."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc18 = db.collection('Birds').doc('Bird18').set(Bird18);
   console.log('new Bird 18 has been added to the database')



//bird19
 let Bird19 = {
   id:19,
    name:"Spotted Owl",
    Description:"The Northern Spotted Owl is a fairly large, brown owl, 40 to 48 centimetres long, with a puffy round head and no ear tufts.\
     The chocolate to chestnut brown feathers of the head, neck, back and under-parts have many circular or irregular white spots, for which \
     this attractive owl is named. The Northern Spotted Owl has large, round facial discs with dark outer rims, dark brown eyes and a yellowish-green bill.",
    Height:" 40-48 cm",
    Weight:"600 g",
    Diet:"This bird hunts at night.The spotted owl eats small and medium-sized mammals, especially rodents.",
    Region:"Canada",
    City:"British Columbia",
    Colour:"Dark brown eyes and a yellowish-green bill.",
    Biome:"Spotted owls do not make their own nests, They will nest in tree cavities, broken-topped trees and platforms.",
    Habitat:"In the northern part of their range, they live in old-growth coniferous forests. They can use other forest types and rocky canyons, but prefer mature forests."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc19 = db.collection('Birds').doc('Bird19').set(Bird19);
   console.log('new Bird 19 has been added to the database')


//bird20
 let Bird20 = {
   id:20,
    name:"Northern Flicker",
    Description:"Northern Flickers are a mid-sized woodpecker reaching approximately 32 centimetres. There are two types, \
    the more widely spread Yellow-shafted Northern Flicker and the Red-shafted found mainly in southern British Columbia.\
     Both have a spotted breast, black breast band below the throat, black barring on their backs (lines that run across their\
      backs from wing to wing) and white patch on their rump, visible in flight.",
    Height:"32 cm",
    Weight:"110-160 g",
    Diet:"Northern Flickers spend their time on the ground searching for and eating ants. They hunt for ants along the side of quiet \
    country roads, in wooded clearings, in gardens and away from the cover of trees.",
    Region:"Canada",
    City:"Southern British Columbia",
    Colour:"Red patch at the back of their heads, a black stripe down the side of their brown face and brilliant yellow under their wings and tail.",
    Biome:"Both rural and suburban areas that have mature trees (for nesting and roosting",
    Habitat:"Look for Northern Flickers in both rural and suburban areas that have mature trees (for nesting and roosting) and\
     open ground or low growing plants nearby (for eating ants)."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc20 = db.collection('Birds').doc('Bird20').set(Bird20);
   console.log('new Bird 20 has been added to the database')


//bird21
 let Bird21 = {
   id:21,
    name:"White-crowned sparrow",
    Description:"The most distinctive feature of this relatively large sparrow, as reflected in its name, is the striped crown. Its grey head is\
     crowned with conspicuous black and white stripes. The white-crowned sparrow lacks the yellow spot near each eye and the white throat of the\
      white-throated sparrow, a close relative. This bird is approximately 17 - 19 cm in size. Loud scuffling in the bushes often signals the presence\
       of this spirited bird. Using both of its rather large feet, it vigorously scratches among the leaf litter in search of food.",
    Height:" 17-19 cm",
    Weight:"25-28 g",
    Diet:"White-crowned Sparrows eat mainly seeds of weeds and grasses and grains including oats, wheat, barley and corn. They also consume\
     considerable numbers of caterpillars, wasps, beetles, and other insects during the summer.",
    Region:"Canada",
    City:"British Columbia, western Alberta ",
    Colour:"It’s grey head is crowned with conspicuous black and white stripes.",
    Biome:" Nest",
    Habitat:" While many sparrows travel in mixed flocks, the white-crowned is more of a loner, preferring to travel individually or in small groups\
     with others of its kind. It frequents clearings, meadows, forest edges, parks, and gardens that provide shrub cover."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc21 = db.collection('Birds').doc('Bird21').set(Bird21);
   console.log('new Bird 21 has been added to the database')


//bird22
 let Bird22 = {
   id:22,
    name:"Swallows",
    Description:"The swallows, martins, and saw-wings, or Hirundinidae, are a family of passerine birds found around the world\
     on all continents, including occasionally in Antarctica. Highly adapted to aerial feeding, they have a distinctive appearance.\
      The term 'swallow' is used colloquially in Europe as a synonym for the barn swallow. Around 90 species of Hirundinidae are known,\
       divided into 19 genera, with the greatest diversity found in Africa, which is also thought to be where they evolved as hole-nesters.",
    Height:"15-19 cm",
    Weight:"17-20 g",
    Diet:"seeds of Acacia trees",
    Region:"Canada",
    City:"western Alberta ",
    Colour:"Barn Swallows have a steely blue back, wings, and tail, and rufous to tawny underparts.",
    Biome:"Their nests are often easy to spot under the eaves or inside of sheds, barns, bridges and other structures.",
    Habitat:"You can find the adaptable Barn Swallow feeding in open habitats from fields, parks, and roadway edges to marshes, meadows, ponds, and coastal waters."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc22 = db.collection('Birds').doc('Bird22').set(Bird22);
   console.log('new Bird 22 has been added to the database')



//bird23
 let Bird23 = {
   id:23,
    name:"Finches",
    Description:"The true finches are small to medium-sized passerine birds in the family Fringillidae.\
     Finches have stout conical bills adapted for eating seeds and often have colourful plumage.\
      They occupy a great range of habitats where they are usually resident and do not migrate. They have\
       a worldwide distribution except for Australia and the polar regions. The family Fringillidae contains\
        more than two hundred species divided into fifty genera. It includes species known as siskins, canaries,\
         redpolls, serins, grosbeaks and euphonia.",
    Height:" 24 cm",
    Weight:"83 g",
    Diet:"Drink floral nectar, especially of tubular flowers such as the cardinal flower",
    Region:"Canada",
    City:"Yukon to north western British Columbia",
    Colour:"Brownish,sometimes greenish;many have considerable amounts of black",
    Biome:" Grassland; forest; scrub forest.",
    Habitat:"Finches are typically inhabitants of well-wooded areas, but some can be found on mountains or even in deserts."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc23 = db.collection('Birds').doc('Bird23').set(Bird23);
   console.log('new Bird 23 has been added to the database')


//bird24
 let Bird24 = {
   id:24,
    name:"Warblers",
    Description:"Various Passeriformes (perching birds) are commonly referred to as warblers. They are not necessarily closely related to one another, \
    but share some characteristics, such as being fairly small, vocal, and insectivorous.They are mostly brownish or dull greenish in color.\
     They tend to be more easily heard than seen. Identification can be difficult and may be made on the basis of song alone (to English-speaking \
     birdwatchers in Europe, warblers are the archetypal 'LBJs', or little brown jobs).",
    Height:"12-15 cm",
    Weight:"9-13 g",
    Diet:"yellow Warblers eat mostly insects that they pick from foliage or capture on short flights or while hovering to reach leaves. Typical \
    prey include midges, caterpillars, beetles, leafhoppers and other bugs, and wasps.",
    Region:"Canada",
    City:"Yukon to north western British Columbia",
    Colour:"  Canada Warblers are steely blue-gray \
    above and bright yellow below with an obvious whitish eyering. ",
    Biome:"Grassland; forest; scrub forest.",
    Habitat:"Found in mixed conifer and deciduous forests with a shrubby understory. It frequents forest slopes filled with rhododendrons in the southern"
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc24 = db.collection('Birds').doc('Bird24').set(Bird24);
   console.log('new Bird 24 has been added to the database')



//bird25
 let Bird25 = {
   id:25,
    name:"Blue Jay",
    Description:"The blue jay (Cyanocitta cristata) is a passerine bird in the family Corvidae, native to eastern North America.  It breeds in both deciduous and coniferous forests,\
     and is common in residential areas. It is predominantly blue with a white chest and underparts, and a blue crest; it has a black, U-shaped collar around its neck and a black border\
      behind the crest. Males and females are similar in size and plumage, and plumage does not vary throughout the year. Four subspecies of the blue jay have been recognized.",
    Height:"22–30 cm",
    Weight:"70–100 g",
    Diet:"Blue jays have strong black bills which they use for cracking nuts, usually while holding them with their feet, and for eating corn, grains and seeds. Its food is sought \
    both on the ground and in trees and includes virtually all known types of plant and animal sources, such as acorns and beech mast, weed seeds, grain, fruits and other berries, \
    peanuts, bread, meat, small invertebrates of many types, scraps in town parks, bird-table food and rarely eggs and nestlings",
    Region:"Canada",
    City:"Nova Scotia, Manitoba, New Brunswick, Newfoundland, Quebec.",
    Colour:"White or light gray underneath, various shades of blue, black, and white above.",
    Biome:"live in dense thickets of shrubs",
    Habitat:"The blue jay occupies a variety of habitats within its large range, from the pine woods of Florida to the spruce-fir forests of northern Ontario. It is less\
    abundant in denser forests, preferring mixed woodlands with oaks and beeche"
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc25 = db.collection('Birds').doc('Bird25').set(Bird25);
   console.log('new Bird 25  has been added to the database')


//bird26
 let Bird26 = {
   id:26,
    name:"Wrens",
    Description:"Wrens are a family of brown passerine birds in the predominantly New World family Troglodytidae. The family includes 88 \
    species divided into 19 genera. Only the Eurasian wren occurs in the Old World, where, in Anglophone regions, it is commonly known simply\
     as the 'wren', as it is the originator of the name.",
    Height:"22 cm",
    Weight:"50 g",
    Diet:"Wrens eat primarily insects but will sample berries as well, particularly in the fall and winter when insects are scarcer.",
    Region:"Quebec",
    City:"Montreal",
    Colour:"Brown",
    Biome:"The various species occur in a wide range of habitats, ranging from dry, sparsely wooded country to rainforest.",
    Habitat:"They prefer brushy tangles, thickets, and hedgerows."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc26 = db.collection('Birds').doc('Bird26').set(Bird26);
   console.log('new Bird 26 has been added to the database')


//bird27
 let Bird27 = {
   id:27,
    name:"Common Terns",
    Description:"Common Terns gracefully row through the sky showing off their long angular wings, and breeding season gray belly, \
    black cap, and red bill. They dive towards the water picking off fish just below the surface.",
    Height:"31-38 cm",
    Weight:"93-200 g",
    Diet:"Mostly fish. Feeds on a wide variety of small fish, focussing on whatever types most easily available, sometimes concentrating on shrimp instead.",
    Region:"Newfoundland,  southern Québec",
    City:"Newfoundland,  Laval, Montérégie and Montreal",
    Colour:"Gray, Black",
    Biome:"Common Terns nest on rocky islands, barrier beaches, and saltmarshes and forage over open waters including inlets, lakes, and marine waters.",
    Habitat:" Terns construct floating nests from the vegetation in their wetland habitats, and a few species build simple nests in trees, on cliffs or in crevices."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc27 = db.collection('Birds').doc('Bird27').set(Bird27);
   console.log('new Bird 27 has been added to the database')


//bird28
 let Bird28 = {
   id:28,
    name :"Piping Plovers",
    Description:"Little round Piping Plovers hide in plain sight on sandy ocean and lake shores, blending right in with their sandy gray backs. \
    It's not until they scurry down the sand on their orange legs that you're likely to spot these big-eyed shorebirds with a sharp black ]\
    collar and an orange bill.",
    Height:"17-18 cm",
    Weight:"43-63 g",
    Diet:"Plovers eat a variety of small organisms, primarily invertebrates. The vast majority of their diet\
     consists of worms, small insects, and crustaceans. ",
    Region:"Ontario",
    City:"Toronto",
    Colour:"Gray, Brown, Black",
    Biome:"Piping Plovers breed along ocean shores in the Northeast and along lakeshores and alkali\
     wetlands in the northern Great Plains and Great Lakes.",
    Habitat:"They nest above the high water mark in soft sandy areas with sparse vegetation."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc28 = db.collection('Birds').doc('Bird28').set(Bird28);
   console.log('new Bird 28 has been added to the database')



//bird29
 let Bird29 = {
   id:29,
    name:"Common loon",
    Description:"The eerie calls of Common Loons echo across clear lakes of the northern wilderness. Summer adults are regularly patterned in \
    black and white. In winter, they are plain gray above and white below, and you’ll find them close to shore on most seacoasts and a good many \
    inland reservoirs and lakes.",
    Height:"66-91 cm",
    Weight:"2500-6100 g",
    Diet:"Their principal food is fish, but they also eat shellfish, frogs, and aquatic insects. ",
    Region:"Newfoundland",
    City:"St. John's",
    Colour:"Black, White",
    Biome:"You can see  Common loon  on lakes, rivers, estuaries, and coastlines.",
    Habitat:"Common loons live on lakes and other waterways."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc29 = db.collection('Birds').doc('Bird29').set(Bird29);
   console.log('new Bird 29 has been added to the database')


//bird30
 let Bird30 = {
   id:30,
    name:"Cooper's Hawk",
    Description:"Among the bird world’s most skillful fliers, Cooper’s Hawks are common woodland hawks that tear through cluttered tree canopies in high speed \
    pursuit of other birds. You’re most likely to see one prowling above a forest edge or field using just a few stiff wingbeats followed by a glide.",
    Height:"42-45 cm",
    Weight:"330-680 g",
    Diet:"Mostly birds and small mammals. Feeds mainly on medium-sized birds, in the size range of robins, jays, flickers, also on larger and smaller birds.",
    Region:"British Columbia,Quebec",
    City:"Vancouver, Quebec City",
    Colour:"blue-gray",
    Biome:"Wooded habitats from deep forests to leafy subdivisions and backyards.",
    Habitat:"Cooper's hawks prefer to nest in tall trees with extensive canopy cover."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc30 = db.collection('Birds').doc('Bird30').set(Bird30);
   console.log('new Bird 30 has been added to the database')



//bird31
 let Bird31 = {
   id:31,
    name:"Grosbeak",
    Description:"Grosbeak is a form taxon containing various species of seed-eating passerine birds with large beaks. Although they all belong to the\
     superfamily Passeroidea, these birds are not part of a natural group but rather a polyphyletic assemblage of distantly related songbirds.",
    Height:"16-18 cm",
    Weight:"53-74 g",
    Diet:"They feed predominantly on tree nuts, seeds, berries, fruit and insects.",
    Region:"Northern Ontario",
    City:"Thunder Bay, Greater Sudbury",
    Colour:"Yellow, Black",
    Biome:"Grosbeaks can be found in a range of habitats including deciduous and mixed woodlands along marshes, lakes,\
     ponds and streams, and in pastures, parks and gardens.",
    Habitat:"Grosbeaks prefer to nest in tall trees with extensive canopy cover."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc31 = db.collection('Birds').doc('Bird31').set(Bird31);
   console.log('new Bird 31 has been added to the database')


//bird32
 let Bird32 = {
   id:32,
    name:"Black-capped Chickadee",
    Description:"A bird almost universally considered “cute” thanks to its oversized round head, tiny body, and curiosity about \
    everything, including humans. The chickadee’s black cap and bib; white cheeks; gray back, wings,\
     and tail; and whitish underside with buffy sides are distinctive.",
    Height:"12-15 cm",
    Weight:"9-14 g",
    Diet:"The Black-capped Chickadee eats a mixture of seeds, insects and spiders.",
    Region:"British Columbia, Alberta",
    City:"Prince George, Edmonton",
    Colour:"Black, White, Gray",
    Biome:"The Black-capped Chickadee lives in forests, orchards and other areas with lots of trees, including \
    many urban areas. trees and finds the food it prefers.",
    Habitat:"It lives in tree-covered areas — including woodlots and orchards — where it digs its nest-holes in the soft."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc32 = db.collection('Birds').doc('Bird32').set(Bird32);
   console.log('new Bird 32 has been added to the database')


//bird33
 let Bird33 = {
   id:33,
    name:"European Starling",
    Description:"The common starling, also known as the European starling in the United States or simply the starling in the British Isles, is a \
    medium-sized passerine bird in the starling family, Sturnidae. It is about 20 cm long and has glossy black plumage with a metallic sheen, which is\
     speckled with white at some times of year.",
    Height:"20-23 cm",
    Weight:"60-96 g",
    Diet:"The common starling is largely insectivorous and feeds on both pest and other arthropods.",
    Region:"North America",
    City:"New York, Montreal",
    Colour:"Brown, Black, Purple",
    Biome:"Starlings are common in towns, suburbs, and countryside near human settlements.",
    Habitat:"They sit high on wires or trees making a constant stream of rattles, whirrs, and whistles."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc33 = db.collection('Birds').doc('Bird33').set(Bird33);
   console.log('new Bird 33 has been added to the database')


//bird34
 let Bird34 = {
   id:34,
    name:"Northern Flickers",
    Description:"Northern Flickers are large, brown woodpeckers with a gentle expression and handsome black-scalloped plumage. On walks, don’t be surprised \
    if you scare one up from the ground. It’s not where you’d expect to find a woodpecker, but flickers eat mainly ants and beetles, digging for \
    them with their unusual, slightly curved bill. ",
    Height:"28-31 cm",
    Weight:"110-160 g",
    Diet:"Northern Flickers eat mainly insects, especially ants and beetles that they gather from the ground.",
    Region:"Nova Scotia, P.E.I. and New Brunswick",
    City:"Halifax,  Charlottetown, Miramichi",
    Colour:"White, Yellow, Brown",
    Biome:"Look for flickers in open habitats near trees, including woodlands, edges, yards, and parks.",
    Habitat:"Northern Flickers generally nest in holes in trees like other woodpeckers. Occasionally, they’ve been found nesting in old, \
    earthen burrows vacated by Belted Kingfishers or Bank Swallows."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc34 = db.collection('Birds').doc('Bird34').set(Bird34);
   console.log('new Bird 34 has been added to the database')



//bird35
 let Bird35 = {
   id:35,
    name:"House Finch",
    Description:"The House Finch is a recent introduction from western into eastern North America (and Hawaii), but it \
    has received a warmer reception than other arrivals like the European Starling and House Sparrow.",
    Height:"13-14 cm",
    Weight:"16-27 g",
    Diet:"House Finches eat almost exclusively plant materials, including seeds, buds and fruits.",
    Region:"Ontario",
    City:"Kingston",
    Colour:"Red, Brown",
    Biome:"House Finches frequent city parks, backyards, urban centers, farms, and forest edges across the continent.",
    Habitat:"you can find House Finches around barns and stables."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc35 = db.collection('Birds').doc('Bird35').set(Bird35);
   console.log('new Bird 35 has been added to the database')


//bird36
 let Bird36 = {
   id:36,
    name:"Bushtit ",
    Description:"Bushtits are sprightly, social songbirds that twitter as they fly weakly between shrubs and thickets in\
     western North America. Almost always found in lively flocks, they move constantly, often hanging upside down to pick at insects or spiders on the undersides of leaves.",
    Height:"7-8 cm",
    Weight:"4-6 g",
    Diet:"Mostly insects. Feeds on a wide variety of tiny insects, especially leafhoppers, treehoppers, aphids, scale insects, caterpillars, and beetles; \
    also wasps, ants, and many others, including eggs and pupae of many insects.",
    Region:"Southwestern British Columbia",
    City:"Fraser Valley",
    Colour:"Brown, Gray",
    Biome:"Bushtits live in oak forest, evergreen woodlands, dry scrublands, streamsides, and suburbs.",
    Habitat:"Bushtits weave a very unusual hanging nest, shaped like a soft pouch or sock, from moss, spider webs, and grasses."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc36 = db.collection('Birds').doc('Bird36').set(Bird36);
   console.log('new Bird 36 has been added to the database')



//bird37
 let Bird37 = {
   id:37,
    name:"Anna’s Hummingbird  ",
    Description:"Anna’s Hummingbirds are among the most common hummingbirds along the Pacific Coast, yet they're anything but common in appearance.\
     With their iridescent emerald feathers and sparkling rose-pink throats, they are more like flying jewelry than birds.",
    Height:"10 cm",
    Weight:"3-6 g",
    Diet:"They also consume small insects and other arthropods caught in flight or gleaned from vegetation.",
    Region:"Nova Scotia, Prince Edward Island, British Columbia",
    City:"Cape Breton Island, Summerside, Vancouver",
    Colour:"Green, Gray",
    Biome:"Anna’s Hummingbirds are common in yards, parks, residential streets, eucalyptus groves, riverside woods, savannahs, and coastal scrub.",
    Habitat:"Anna’s Hummingbirds generally nest in holes in trees like other woodpeckers."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc37 = db.collection('Birds').doc('Bird37').set(Bird37);
   console.log('new Bird 37 has been added to the database')


//bird38
 let Bird38 = {
   id:38,
    name:"Spotted Towhee",
    Description:"The Spotted Towhee is a large, striking sparrow of sun-baked thickets of the West. When you catch sight of one, they’re gleaming\
     black above (females are grayish brown), spotted and striped with brilliant white. Their warm rufous flanks match the dry leaves they spend their time hopping around in.",
    Height:"17-21 cm",
    Weight:"33-49 g",
    Diet:"Mostly insects, seeds, berries. Diet varies with season. Eats many insects, especially in summer, including beetles, caterpillars, moths, true bugs, and many others, \
    also spiders, snails, and millipedes. Also eats many seeds, plus acorns, berries, and small fruits.",
    Region:"Southern British Columbia",
    City:"Campbell River",
    Colour:"White, Black, Yellow",
    Biome:"Look for Spotted Towhees in open, shrubby habitat with thick undergrowth. Spotted Towhees are also at home in backyards, forest edges, and overgrown fields.",
    Habitat:"Open woods, undergrowth, brushy edges."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc38 = db.collection('Birds').doc('Bird38').set(Bird38);
   console.log('new Bird 38 has been added to the database')


//bird39
 let Bird39 = {
   id:39,
    name:"Cedar Waxwing",
    Description:"The cedar waxwing is a member of the family Bombycillidae or waxwing family of passerine birds. It is a medium-sized, mostly brown, gray, and yellow bird named\
     for its wax-like wing tips. It is a native of North and Central America, breeding in open wooded areas in southern Canada.",
    Height:"14-17 cm",
    Weight:"32 g",
    Diet:"Cedar Waxwings eat small fruit year round. They will feed from shrubs and trees like mountain ash, dogwoods, serviceberries, crabapples, hawthorns and winterberries.",
    Region:"Ontario",
    City:"Hudson Bay Lowlands",
    Colour:"Black, Brown, Yellow",
    Biome:"Look for Cedar Waxwings in woodlands of all kinds, and at farms, orchards, and suburban gardens where there are fruiting trees or shrubs.",
    Habitat:"Cedar Waxwings are social birds that form large flocks and often nest in loose clusters of a dozen or so nests. "
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc39 = db.collection('Birds').doc('Bird39').set(Bird39);
   console.log('new Bird 39 has been added to the database')


//bird40
 let Bird40 = {
   id:40,
    name:"Bald Eagle",
    Description:"The Bald Eagle has been the national emblem of the United States since 1782 and a spiritual symbol for native people for far longer than that.\
     These regal birds aren’t really bald, but their white-feathered heads gleam in contrast to their chocolate-brown body and wings.",
    Height:"71-96 cm",
    Weight:"3000-6300 g",
    Diet:"They eat mainly fish, but also hunt mammals, gulls, and waterfowl.",
    Region:"Quebec, Ontario",
    City:"Montreal, Lake Erie",
    Colour:"White, Brown, Yellow",
    Biome:"Look for Bald Eagles near lakes, reservoirs, rivers, marshes, and coasts.",
    Habitat:"You'll find Bald Eagles soaring high in the sky, flapping low over treetops\
     with slow wingbeats, or perched in trees or on the ground."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc40 = db.collection('Birds').doc('Bird40').set(Bird40);
   console.log('new Bird 40 has been added to the database')



//bird41
 let Bird41 = {
   id:41,
    name:"Mew Gull",
    Description:"The smallest North American white-headed gull, the Mew Gull is commonly described as \
    having a 'gentle' or 'dove-headed' look. The Mew Gull has typical gull-like plumage--slate-gray back and wings, \
     white head, tail, and body, and black wingtips with white spots. The beak and legs are yellow. ",
    Height:"41-46 cm",
    Weight:"360-600 g",
    Diet:"Omnivorous. Diet may be mostly small fish along the coast, mostly insects around inland lakes,\
     but also eats crustaceans, mollusks, sea urchins, earthworms, small rodents, young birds of other species, carrion, refuse.",
    Region:"Quebec",
    City:"Montreal, Quebec City",
    Colour:"Gray, Black, White",
    Biome:"Coastal waters in winter, lakes in summer. Along Pacific Coast, concentrates in winter\
    around river mouths and lagoons, and freshwater ponds near the shore.",
    Habitat:"Tree nest is a platform or shallow cup of twigs, grasses. Both sexes help build nests."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc41 = db.collection('Birds').doc('Bird41').set(Bird41);
   console.log('new Bird 41 has been added to the database')


//bird42
 let Bird42 = {
   id:42,
    name:"Pine Siskin",
    Description:"The pine siskin (Spinus pinus) is a North American bird in the finch family.\
     It is a migratory bird with an extremely sporadic winter range.",
    Height:"11-14 cm",
    Weight:"12-18 g",
    Diet:"Mostly seeds and other vegetable matter, some insects. Feeds on seeds of alder, \
    birch, spruce, and many other trees, also those of weeds and grasses; eats buds, \
    flower parts, nectar, young shoots. Also feeds on insects, including caterpillars and aphids.",
    Region:"Southern Ontario",
    City:"Stratford",
    Colour:"Brown, Yellow",
    Biome:"Conifers, mixed woods, alders, weedy areas. Breeds mostly in coniferous and mixed woods,\
     often around edges or clearings; sometimes in deciduous woods, isolated conifer groves. ",
    Habitat:"Forages actively in trees, shrubs, and weeds, sometimes hanging upside down to reach seeds."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc42 = db.collection('Birds').doc('Bird42').set(Bird42);
   console.log('new Bird 42 has been added to the database')



//bird43
 let Bird43 = {
   id:43,
    name:"Great Blue Heron",
    Description:"The great blue heron (Ardea herodias) is a large wading bird in the heron family Ardeidae, common near the shores of open water and in wetlands\
     over most of North America and Central America, as well as the Caribbean and the Galápagos Islands.",
    Height:"97-137 cm",
    Weight:"2100-2500 g",
    Diet:"Highly variable and adaptable. Eats mostly fish, but also frogs, salamanders, turtles, snakes, insects, rodents, birds.",
    Region:"British Columbia",
    City:"Chilliwack",
    Colour:"blue-gray",
    Biome:"Marshes, swamps, shores, tideflats. Very adaptable. Forages in any kind of calm fresh waters or slow-moving rivers, also in shallow coastal bays.",
    Habitat:"Nests in trees or shrubs near water"
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc43 = db.collection('Birds').doc('Bird43').set(Bird43);
   console.log('new Bird 43 has been added to the database')


//bird44
 let Bird44 = {
   id:44,
    name:"Bufflehead",
    Description:"The Bufflehead Bucephala albeola is Canada’s smallest diving duck. Strikingly patterned in black and white, and constantly active, \
    it attracts attention out of proportion to its relatively small numbers.",
    Height:"32-40 cm",
    Weight:"272-635 g",
    Diet:"Varies with season and habitat. In summer and on fresh water feeds mainly on aquatic insects; on ocean feeds mainly on crustaceans.\
    Also eats many mollusks (especially snails) in winter, and small amounts of plant material in fall.",
    Region:"Ontario",
    City:"Lake ontario",
    Colour:"White, Black, Gray-brown",
    Biome:"Lakes, ponds, rivers; in winter, salt bays. \
    Preferred nesting habitat is around ponds and small lakes.",
    Habitat:"The Bufflehead nests almost exclusively in holes excavated by Northern \
    Flickers and, on occasion, by Pileated Woodpeckers."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc44 = db.collection('Birds').doc('Bird44').set(Bird44);
   console.log('new Bird 44 has been added to the database')


//bird45
 let Bird45 = {
   id:45,
    name:"Northern Shrike ",
    Description:"The burly, bull-headed Northern Shrike is a pint-sized predator of birds, small mammals, and insects. A bold black mask and stout,\
     hooked bill heighten the impression of danger in these fierce predators. They breed in far northern North America and \
     come as far south as the northern U.S. for winter.",
    Height:"23-24 cm",
    Weight:"56-79 g",
    Diet:"Includes small birds, rodents, large insects. Varied diet includes many small songbirds, especially in winter and \
    early spring; also many voles and other small rodents, and many large insects when available.",
    Region:"Quebec",
    City:"Montreal",
    Colour:"Black, Gray, White",
    Biome:"Semi-open country with lookout posts; trees, scrub. Breeds in far north in partly open or scattered\
     spruce woods and in willow and alder scrub along streams or edges of tundra.",
    Habitat:"Open habitats with a patchwork of small trees and bushes."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc45 = db.collection('Birds').doc('Bird45').set(Bird45);
   console.log('new Bird 45 has been added to the database')


//bird46
 let Bird46 = {
   id:46,
    name:"Pine Grosbeak",
    Description:"The pine grosbeak is a large member of the true finch family, Fringillidae. It is the only species in the genus Pinicola. \
    It is found in coniferous woods across Alaska, the western mountains of the United States, Canada.",
    Height:"20-25 cm",
    Weight:"52-78 g",
    Diet:"Seeds, buds, berries, insects. Feeds mostly on vegetable matter, especially in winter.",
    Region:"Northern Quebec, northern Ontario ",
    City:"Chapais,  North Bay",
    Colour:"Pink, Gray, Orange",
    Biome:"Conifers; in winter, other trees. Breeds in open coniferous forest, especially of spruce and fir;\
     despite the name, not usually in pines in summer.",
    Habitat:"Pine Grosbeaks inhabit open spruce, fir, and pine forests as well as subalpine forests."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc46 = db.collection('Birds').doc('Bird46').set(Bird46);
   console.log('new Bird 46 has been added to the database')



//bird47
 let Bird47 = {
   id:47,
    name:"Least Bittern",
    Description:"The furtive Least Bittern is often little more than a voice in the reeds that is frustratingly difficult to locate. \
    But these diminutive herons reward patience and will charm birders persistent enough to discover them in their wetland haunts.",
    Height:"28-36 cm",
    Weight:"46-95 g",
    Diet:"Mostly fish and insects. Eats mostly small fish (such as minnows, sunfishes, and perch) and large insects (dragonflies and others); \
    also crayfish, leeches, frogs, tadpoles, small snakes, and other items.",
    Region:"Northwest Ontario",
    City:"Thunder Bay, Kenora",
    Colour:"Black, Pale",
    Biome:"The least bittern is found in freshwater or brackish marshes with tall grasses, cattails, and reeds.",
    Habitat:"This bird builds its nest above the marsh water in stands of dense vegetation, hidden among the cattails."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc47 = db.collection('Birds').doc('Bird47').set(Bird47);
   console.log('new Bird 47 has been added to the database')


//bird48
 let Bird48 = {
   id:48,
    name:"Least Sandpiper",
    Description:"Least Sandpipers are the smallest of the small sandpipers known as “peeps”—not much bigger than a sparrow. \
    They have distinctive yellow-green legs and a high-pitched creep call. Look for them on edges of mudflats or marshes, \
    where they walk with a hunched posture and probe for little crustaceans, insects, and other invertebrates.",
    Height:"13-15 cm",
    Weight:"19-30 g",
    Diet:"Tiny crustaceans, insects, snails. Diet varies with season and place.",
    Region:"Manitoba",
    City:"Brandon",
    Colour:"Brown, White, Black",
    Biome:" Mudflats, grassy marshes, rainpools, shores. In migration, often more common inland than on coast, favoring muddy edges of marshes, ponds, rivers.",
    Habitat:"They typically nest in sedge meadows, muskeg bogs, or coastal wetlands. "
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc48 = db.collection('Birds').doc('Bird48').set(Bird48);
   console.log('new Bird 48 has been added to the database')



//bird49
 let Bird49 = {
   id:49,
    name:"Mute Swan",
    Description:"The exotic Mute Swan is the elegant bird of Russian ballets and European fairy tales. This swan swims with its long neck curved into an S and \
    often holds its wings raised slightly above its back. Although they’re numerous and familiar in city parks and in bays and lakes in the Pacific Northwest,\
     Great Lakes, Northeast, and Mid Atlantic, Mute Swans are not native to North America.",
    Height:"127-152 cm",
    Weight:"5500-14300 g",
    Diet:"Mostly plant material. Feeds on seeds, stems, leaves, and roots of aquatic plants, including pondweeds, eelgrass, algae.",
    Region:"Ontario",
    City:"Kingston",
    Colour:"White",
    Biome:"Look for Mute Swans in city-park ponds, as well as rivers, lakes, and estuaries.",
    Habitat:"Swans are waterfowl, and rely very heavily on water bodies in their environment."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc49 = db.collection('Birds').doc('Bird49').set(Bird49);
   console.log('new Bird 49 has been added to the database')


//bird50
 let Bird50 = {
   id:50,
    name:"Osprey",
    Description:"Unique among North American raptors for its diet of live fish and ability to dive into water to catch them, Ospreys are common sights\
     soaring over shorelines, patrolling waterways, and standing on their huge stick nests, white heads gleaming.",
    Height:"54-58 cm",
    Weight:"1400-2000 g",
    Diet:"Osprey eat small mammals, birds, or reptiles. However, the Osprey is highly specialized for eating fish and does not stray from this diet unless necessary.",
    Region:"Southern Ontario",
    City:"Hawk Cliff, south of St Thomas.",
    Colour:"Brown, White",
    Biome:"Look for Ospreys around nearly any body of water: saltmarshes, rivers, ponds, reservoirs, estuaries, and even coral reefs.",
    Habitat:"Their conspicuous stick nests are placed in the open on poles, channel markers, and dead trees, often over water."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc50 = db.collection('Birds').doc('Bird50').set(Bird50);
   console.log('new Bird 50 has been added to the database')




//Media collection to store the media (images,video & Sound Clip related to a particular bird)


//Mediabird1
 let Bird1mediaImage = {
      "media_id": 11,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Northern_Cardinal_%28Cardinalis_cardinalis%29_male.jpg/1200px-Northern_Cardinal_%28Cardinalis_cardinalis%29_male.jpg"
};


let setImage1 = db.collection('Birds').doc('Bird1')
  .collection('media').doc('Image').set(Bird1mediaImage);


//bird1
 let Bird1mediaVideo = {
      "media_id": 12,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=tabtoQTRn-U"
};


let setVideo1 = db.collection('Birds').doc('Bird1')
  .collection('media').doc('Video').set(Bird1mediaVideo);

//bird1
 let Bird1mediaSound = {
      "media_id": 13,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/northern-cardinal/"
};


let setSound1 = db.collection('Birds').doc('Bird1')
  .collection('media').doc('Soundclip').set(Bird1mediaSound);



//Mediabird2
 let Bird2mediaImage = {
      "media_id": 21,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/PileatedWoodpeckerFeedingonTree%2C_crop.jpg/1200px-PileatedWoodpeckerFeedingonTree%2C_crop.jpg"
};


let setImage2 = db.collection('Birds').doc('Bird2')
  .collection('media').doc('Image').set(Bird2mediaImage);


//bird1
 let Bird2mediaVideo = {
      "media_id": 22,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=jHGaFJMkHvM"
};


let setVideo2 = db.collection('Birds').doc('Bird2')
  .collection('media').doc('Video').set(Bird2mediaVideo);

//bird1
 let Bird2mediaSound = {
      "media_id": 23,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/northern-cardinal/"
};


let setSound2 = db.collection('Birds').doc('Bird2')
  .collection('media').doc('Soundclip').set(Bird2mediaSound);



//Mediabird3
 let Bird3mediaImage = {
      "media_id": 31,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.allaboutbirds.org/guide/assets/og/75258971-1200px.jpg"
};


let setImage3 = db.collection('Birds').doc('Bird3')
  .collection('media').doc('Image').set(Bird3mediaImage);


//bird1
 let Bird3mediaVideo = {
      "media_id": 32,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=akdeOr3dp0M"
};


let setVideo3 = db.collection('Birds').doc('Bird3')
  .collection('media').doc('Video').set(Bird3mediaVideo);

//bird1
 let Bird3mediaSound = {
      "media_id": 33,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/baltimore-oriole/"
};


let setSound3 = db.collection('Birds').doc('Bird3')
  .collection('media').doc('Soundclip').set(Bird3mediaSound);


//Mediabird4
 let Bird4mediaImage = {
      "media_id": 41,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://naturallycuriouswithmaryholland.files.wordpress.com/2013/11/11-20-13-black-capped-chickadee-img_01071.jpg"
};


let setImage4 = db.collection('Birds').doc('Bird4')
  .collection('media').doc('Image').set(Bird4mediaImage);


//bird4
 let Bird4mediaVideo = {
      "media_id": 42,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=SM1jv9EmWWU"
};


let setVideo4 = db.collection('Birds').doc('Bird4')
  .collection('media').doc('Video').set(Bird4mediaVideo);

//bird4
 let Bird4mediaSound = {
      "media_id": 43,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/black-capped-chickadee/"
};


let setSound4 = db.collection('Birds').doc('Bird4')
  .collection('media').doc('Soundclip').set(Bird4mediaSound);






  //Mediabird5
 let Bird5mediaImage = {
      "media_id": 51,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Brazilian_burrowing_owl_%28Athene_cunicularia_grallaria%29.jpg/1200px-Brazilian_burrowing_owl_%28Athene_cunicularia_grallaria%29.jpg"
};


let setImage5 = db.collection('Birds').doc('Bird5')
  .collection('media').doc('Image').set(Bird5mediaImage);


//bird1
 let Bird5mediaVideo = {
      "media_id": 52,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=oEri7dXvmKE"
};


let setVideo5 = db.collection('Birds').doc('Bird5')
  .collection('media').doc('Video').set(Bird5mediaVideo);

//bird1
 let Bird5mediaSound = {
      "media_id": 53,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/burrowing-owl/"
};


let setSound5 = db.collection('Birds').doc('Bird5')
  .collection('media').doc('Soundclip').set(Bird5mediaSound);


//Mediabird6
 let Bird6mediaImage = {
      "media_id": 61,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Cedar_Waxwing_August_14_2012_Newfoundland_PA.jpg/1200px-Cedar_Waxwing_August_14_2012_Newfoundland_PA.jpg"
};


let setImage6 = db.collection('Birds').doc('Bird6')
  .collection('media').doc('Image').set(Bird6mediaImage);


//bird1
 let Bird6mediaVideo = {
      "media_id": 62,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=TOaAMkmRNPw"
};


let setVideo6 = db.collection('Birds').doc('Bird6')
  .collection('media').doc('Video').set(Bird6mediaVideo);

//bird1
 let Bird6mediaSound = {
      "media_id": 63,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/burrowing-owl/"
};


let setSound6 = db.collection('Birds').doc('Bird6')
  .collection('media').doc('Soundclip').set(Bird6mediaSound);


//Mediabird7
 let Bird7mediaImage = {
      "media_id": 71,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://philipschwarzphotography.files.wordpress.com/2013/02/common-redpoll-female-13-1-_1566.jpg"
};


let setImage7 = db.collection('Birds').doc('Bird7')
  .collection('media').doc('Image').set(Bird7mediaImage);


//bird1
 let Bird7mediaVideo = {
      "media_id": 72,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=pqyXRDAD93M"
};


let setVideo7 = db.collection('Birds').doc('Bird7')
  .collection('media').doc('Video').set(Bird7mediaVideo);

//bird1
 let Bird7mediaSound = {
      "media_id": 73,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/common-redpoll/"
};


let setSound7 = db.collection('Birds').doc('Bird7')
  .collection('media').doc('Soundclip').set(Bird7mediaSound);


//Mediabird8
 let Bird8mediaImage = {
      "media_id": 81,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://upload.wikimedia.org/wikipedia/commons/b/b3/Dark-eyed_Junco-27527-3.jpg"
};


let setImage8 = db.collection('Birds').doc('Bird8')
  .collection('media').doc('Image').set(Bird8mediaImage);


//bird1
 let Bird8mediaVideo = {
      "media_id": 82,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=mvSVpt27nSI"
};


let setVideo8 = db.collection('Birds').doc('Bird1')
  .collection('media').doc('Video').set(Bird8mediaVideo);

//bird1
 let Bird8mediaSound = {
      "media_id": 83,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/common-redpoll/"
};


let setSound8 = db.collection('Birds').doc('Bird8')
  .collection('media').doc('Soundclip').set(Bird8mediaSound);


//Mediabird9
 let Bird9mediaImage = {
      "media_id": 91,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "http://2.bp.blogspot.com/-Jct9xDnsdG4/UG_Mtw4l4_I/AAAAAAAAARU/CbSJMwwdPZo/s1600/Gray+Catbird.JPG"
};


let setImage9 = db.collection('Birds').doc('Bird9')
  .collection('media').doc('Image').set(Bird9mediaImage);


//bird1
 let Bird9mediaVideo = {
      "media_id": 92,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.bing.com/videos/search?q=Gray+Catbirds&&view=detail&mid=D0D32B1407D3E19A90CDD0D32B1407D3E19A90CD&&FORM=VRDGAR&ru=%2Fvideos%2Fsearch%3Fq%3DGray%2BCatbirds%26FORM%3DHDRSC3"
};


let setVideo9 = db.collection('Birds').doc('Bird9')
  .collection('media').doc('Video').set(Bird9mediaVideo);

//bird1
 let Bird9mediaSound = {
      "media_id": 93,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/gray-catbird/"
};


let setSound9 = db.collection('Birds').doc('Bird9')
  .collection('media').doc('Soundclip').set(Bird9mediaSound);


//Mediabird10
 let Bird10mediaImage = {
      "media_id": 101,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://i.ytimg.com/vi/Cu3bgBVyrNw/maxresdefault.jpg"
};


let setImage10 = db.collection('Birds').doc('Bird10')
  .collection('media').doc('Image').set(Bird10mediaImage);


//bird1
 let Bird10mediaVideo = {
      "media_id": 102,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=KbdKbUWGsuw"
};


let setVideo10 = db.collection('Birds').doc('Bird10')
  .collection('media').doc('Video').set(Bird10mediaVideo);

//bird1
 let Bird10mediaSound = {
      "media_id": 103,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/great-horned-owl/"
};


let setSound10 = db.collection('Birds').doc('Bird10')
  .collection('media').doc('Soundclip').set(Bird10mediaSound);


//Mediabird11
 let Bird11mediaImage = {
      "media_id": 111,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.nps.gov/chat/learn/nature/images/american-crow.jpg"
};


let setImage11 = db.collection('Birds').doc('Bird11')
  .collection('media').doc('Image').set(Bird11mediaImage);


//bird1
 let Bird11mediaVideo = {
      "media_id": 112,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=JnDRHDoOsEw"
};


let setVideo11 = db.collection('Birds').doc('Bird11')
  .collection('media').doc('Video').set(Bird11mediaVideo);

//bird1
 let Bird11mediaSound = {
      "media_id": 113,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/american-crow/"
};


let setSound11 = db.collection('Birds').doc('Bird11')
  .collection('media').doc('Soundclip').set(Bird11mediaSound);


//Mediabird12
 let Bird12mediaImage = {
      "media_id": 121,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/Turdus-migratorius-002.jpg/1200px-Turdus-migratorius-002.jpg"
};


let setImage12 = db.collection('Birds').doc('Bird12')
  .collection('media').doc('Image').set(Bird12mediaImage);


//bird1
 let Bird12mediaVideo = {
      "media_id": 122,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=vvmNz5ZES5c"
};


let setVideo12 = db.collection('Birds').doc('Bird12')
  .collection('media').doc('Video').set(Bird12mediaVideo);

//bird1
 let Bird12mediaSound = {
      "media_id": 123,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/american-crow/"
};


let setSound12 = db.collection('Birds').doc('Bird12')
  .collection('media').doc('Soundclip').set(Bird12mediaSound);



//Mediabird13
 let Bird13mediaImage = {
      "media_id": 131,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "http://www.audubon.org/sites/default/files/styles/hero_cover_bird_page/public/Purple%20Martin%20s60-5-005_V.jpg?itok=dlGL_tZc"
};


let setImage13 = db.collection('Birds').doc('Bird13')
  .collection('media').doc('Image').set(Bird13mediaImage);


//bird1
 let Bird13mediaVideo = {
      "media_id": 132,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=2dGY-li4gSI"
};


let setVideo13 = db.collection('Birds').doc('Bird13')
  .collection('media').doc('Video').set(Bird13mediaVideo);

//bird1
 let Bird13mediaSound = {
      "media_id": 133,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/purple-martin"
};


let setSound13 = db.collection('Birds').doc('Bird13')
  .collection('media').doc('Soundclip').set(Bird13mediaSound);


//Mediabird14
 let Bird14mediaImage = {
      "media_id": 141,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "http://www.wilddelight.com/wp-content/uploads/2013/01/RedBreastedNuthatch01.jpg"
};


let setImage14 = db.collection('Birds').doc('Bird14')
  .collection('media').doc('Image').set(Bird14mediaImage);


//bird1
 let Bird14mediaVideo = {
      "media_id": 142,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=EtFqNtpINgA"
};


let setVideo14 = db.collection('Birds').doc('Bird14')
  .collection('media').doc('Video').set(Bird14mediaVideo);

//bird1
 let Bird14mediaSound = {
      "media_id": 143,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/red-breasted-nuthatch/"
};


let setSound14 = db.collection('Birds').doc('Bird14')
  .collection('media').doc('Soundclip').set(Bird14mediaSound);


//Mediabird15
 let Bird15mediaImage = {
      "media_id": 151,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://mybluesunshine.files.wordpress.com/2015/05/6a00e5513924e68833017615996437970c.jpg"
};


let setImage15 = db.collection('Birds').doc('Bird15')
  .collection('media').doc('Image').set(Bird15mediaImage);


//bird1
 let Bird15mediaVideo = {
      "media_id": 152,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=xZ-pjS4vwDo"
};


let setVideo15 = db.collection('Birds').doc('Bird15')
  .collection('media').doc('Video').set(Bird15mediaVideo);

//bird1
 let Bird15mediaSound = {
      "media_id": 153,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/red-winged-blackbird/"
};


let setSound15 = db.collection('Birds').doc('Bird15')
  .collection('media').doc('Soundclip').set(Bird15mediaSound);


//Mediabird16
 let Bird16mediaImage = {
      "media_id": 161,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.animalspot.net/wp-content/uploads/2016/01/Rose-Breasted-Grosbeak-Female.jpg"
};


let setImage16 = db.collection('Birds').doc('Bird16')
  .collection('media').doc('Image').set(Bird16mediaImage);


//bird1
 let Bird16mediaVideo = {
      "media_id": 162,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=tK37Mdt7rgQ"
};


let setVideo16 = db.collection('Birds').doc('Bird16')
  .collection('media').doc('Video').set(Bird16mediaVideo);

//bird1
 let Bird16mediaSound = {
      "media_id": 163,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/rose-breasted-grosbeak/"
};


let setSound16 = db.collection('Birds').doc('Bird16')
  .collection('media').doc('Soundclip').set(Bird16mediaSound);


//Mediabird17
 let Bird17mediaImage = {
      "media_id": 171,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "http://3.bp.blogspot.com/-4K3XRMSNmmA/T57Mq6ESL0I/AAAAAAAADhw/gWaZm_38c7M/s1600/rubythroatedhummingbird2.jpg"
};


let setImage17 = db.collection('Birds').doc('Bird17')
  .collection('media').doc('Image').set(Bird17mediaImage);


//bird1
 let Bird17mediaVideo = {
      "media_id": 172,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=xVYvjsNui9E"
};


let setVideo17 = db.collection('Birds').doc('Bird17')
  .collection('media').doc('Video').set(Bird17mediaVideo);

//bird1
 let Bird17mediaSound = {
      "media_id": 173,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/ruby-throated-hummingbird/"
};


let setSound17 = db.collection('Birds').doc('Bird17')
  .collection('media').doc('Soundclip').set(Bird17mediaSound);


//Mediabird18
 let Bird18mediaImage = {
      "media_id": 181,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://climate.audubon.org/sites/default/files/bird_photo_gallery_images/Rufous_Hummingbird_NicoleBeaulac:FlickrCC.jpg"
};


let setImage18 = db.collection('Birds').doc('Bird18')
  .collection('media').doc('Image').set(Bird18mediaImage);


//bird1
 let Bird18mediaVideo = {
      "media_id": 182,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=8TmY6J6AT1A"
};


let setVideo18 = db.collection('Birds').doc('Bird18')
  .collection('media').doc('Video').set(Bird18mediaVideo);

//bird1
 let Bird18mediaSound = {
      "media_id": 183,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/rufous-hummingbird/"
};


let setSound18 = db.collection('Birds').doc('Bird18')
  .collection('media').doc('Soundclip').set(Bird18mediaSound);


//Mediabird19
 let Bird19mediaImage = {
      "media_id": 191,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.americanforests.org/wp-content/uploads/2012/07/northern-spotted-owl-2.jpg"
};


let setImage19 = db.collection('Birds').doc('Bird19')
  .collection('media').doc('Image').set(Bird19mediaImage);


//bird1
 let Bird19mediaVideo = {
      "media_id": 192,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=iFa-6BBPY4U"
};


let setVideo19 = db.collection('Birds').doc('Bird19')
  .collection('media').doc('Video').set(Bird19mediaVideo);

//bird1
 let Bird19mediaSound = {
      "media_id": 193,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/spotted-owl/"
};


let setSound19 = db.collection('Birds').doc('Bird19')
  .collection('media').doc('Soundclip').set(Bird19mediaSound);



  //Mediabird20
 let Bird20mediaImage = {
      "media_id": 201,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://mmeara.files.wordpress.com/2012/09/pic-flamb-male-aur1.jpg"
};


let setImage20 = db.collection('Birds').doc('Bird20')
  .collection('media').doc('Image').set(Bird20mediaImage);


//bird1
 let Bird20mediaVideo = {
      "media_id": 202,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=aozKutu9Bk8"
};


let setVideo20 = db.collection('Birds').doc('Bird20')
  .collection('media').doc('Video').set(Bird20mediaVideo);

//bird1
 let Bird20mediaSound = {
      "media_id": 203,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/northern-flicker/"
};


let setSound20 = db.collection('Birds').doc('Bird20').collection('media').doc('Soundclip').set(Bird20mediaSound);



//Mediabird50
 let Bird50mediaImage = {
      "media_id": 501,
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://i.ytimg.com/vi/f6UFcbJFwk0/hqdefault.jpg"
};


let setImage50 = db.collection('Birds').doc('Bird50')
  .collection('media').doc('Image').set(Bird50mediaImage);


//bird50
 let Bird50mediaVideo = {
      "media_id": 502,
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=MIqb4qq_MQU"
};


let setVideo50 = db.collection('Birds').doc('Bird50')
  .collection('media').doc('Video').set(Bird50mediaVideo);

//bird50
 let Bird50mediaSound = {
      "media_id": 503,
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/osprey/"
};


let setSound50 = db.collection('Birds').doc('Bird50')
  .collection('media').doc('Soundclip').set(Bird50mediaSound);











//get a doc Bird1 from collection Birds
let birdRef = db.collection('Birds').doc('Bird1');
let getDoc = birdRef.get()
  .then(doc => {
    if (!doc.exists) {
      console.log('No such document!');
    } else {
      console.log('Document data:', doc.data());
    }
  

  // To update the fields of a Doc like in bird Doc Update Height & Weight:
db.collection("Birds").doc("Bird2").update({
    "Height": "13cm",
    "Weight": "50g"
});


//db.collection("Birds").where("City", "==", true);
//db.collection("Birds").where("Weight", ">=", "49");

//get Multiple Docs
db.collection("Birds").get()
  .then(function(querySnapshot) {
    querySnapshot.forEach(function(doc) {
      // doc.data() is never undefined for query doc snapshots
      console.log(doc.id, " => ", doc.data());
  });
});


   //Delete a doc Bird3 from collection Birds
//let deleteDoc = db.collection('Birds').doc('Bird3').delete();
 //console.log(' Bird3 has been deleted from the database')



   //Delete the  FieldValue of a Doc Bird1 from collection Birds
 // Get the `FieldValue` object
let FieldValue = require('firebase-admin').firestore.FieldValue;
// Create a document reference
let birdrefdel = db.collection('Birds').doc('Bird1');

// Remove the 'capital' field from the document
/*let removeCity = birdrefdel.update({
  //City: FieldValue.delete()

});*/
      console.log('City deleted');


   

  /* function incrementCounter(docRef, numShards) {
  const shardId = Math.floor(Math.random() * numShards);
  const shardRef = docRef.collection('Birds').doc(shardId.toString());
  return shardRef.set({count: id.increment(1)}, {merge: true});
}*/
 



  ///////User Collection///////



//////User Collection///////


let user1 = {
   user_id:201,
    name:"Prabhjot",
    email:"prabhjot@gmail.com",
    encrypted_password:"$$$$$",
    address:"Montreal",
    phone:"45545455545",
    status:true
    
};

// Add a new document in collection "Birds" with ID 'Bird1'
let setuserDoc1 = db.collection('Users').doc('user1').set(user1);
   console.log('new user 1 has been added to the database')



   //////Preferences Collection///////


let user1preferences = {
   get_featured_notifications:true,
    get_favorites_notifications:true,
    proximity_radius:"2 km"
    
};


let setuser1preferences = db.collection('Users').doc('user1').collection('Preferences').doc('preferences').set(user1preferences);



 //////Notifications Collection///////


let user1Notifications = {
   notification_id:301,
    heading:"sample",
     description:"sample",
    date_received:"sample",
    is_deleted:false
    
};


let setuser1Notifications = db.collection('Users').doc('user1').collection('Notifications').doc('notifications').set(user1Notifications);


//////Folder Collection///////


let user1folder = {
folder_id:401,
name:"sample",
is_root_folder: true,
is_default: true,
is_deleted: false,
folder_path: "sample",
date_created: "sample",
date_modified: "sample"
    
};


let setuser1folder = db.collection('Users').doc('user1').collection('Folder').doc('folder').set(user1folder);



let user1foldermediaimage = {
media_id:501,
title: "sample",
is_image: true,
is_video: false,
is_sound_clip: false,
is_deleted: false,
 url: "sample URL"
    
};


let setuser1foldermediaimage = db.collection('Users').doc('user1').collection('Folder').doc('folder').collection('media').doc('images').collection('Images').doc('media_id').set(user1foldermediaimage);


let user1foldermediavideo = {
media_id:502,
title: "sample",
is_image: false,
is_video: true,
is_sound_clip: false,
is_deleted: false,
 url: "sample URL"
    
};


let setuser1foldermediavideo = db.collection('Users').doc('user1').collection('Folder').doc('folder').collection('media').doc('videos').collection('Videos').doc('media_id').set(user1foldermediavideo);


let user1foldermediaSound = {
media_id:503,
title: "sample",
is_image: false,
is_video: true,
is_sound_clip: true,
is_deleted: false,
 url: "sample URL"
    
};


let setuser1foldermediasound = db.collection('Users').doc('user1').collection('Folder').doc('folder').collection('media').doc('sounds').collection('Sounds').doc('media_id').set(user1foldermediaSound);

 

//////Favourite Birds Collection///////


let user_favorite_birds = {
favorite_birds_id: 1,
 user_id: 201,
 bird_id: 11,
 bird_name: "American crow",
 default_image: "https://www.nps.gov/chat/learn/nature/images/american-crow.jpg",
 default_location: "sample",
 is_favorite: true
    
};


let setuser_favorite_birds = db.collection('favorite_birds').doc('favorite_birds_id').set(user_favorite_birds);



//////location  Collection///////


let location = {
location_id: 601,
 name: "sample",
 address: "sample",
 city: "sample",
 province: "sample",
 country: "sample",
 latitude: "sample",
 longitude: "sample"
    
};


let setlocation = db.collection('Location').doc('location_id').set(location);




//////Birdlocation  Collection///////


let bird_location = {
bird_location_id: 701,
 bird_id: 11,
 location_id: 601,
 bird_name: "American crow",
 location_name: "sample",
 bird_image: "https://www.nps.gov/chat/learn/nature/images/american-crow.jpg",
 is_valid: true
    
};


let setbirdlocation = db.collection('Bird_Location').doc('bird_location_id').set(bird_location);
  })








/*return db.collection('Birds').doc('Details')
   .set(BirdData).then(() =>
   console.log('new Bird has been added to the database')
   );
*/
});