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
  
    name:"Northern cardinal ",
    Description:"The northern cardinal is a medium-sized songbird, with males slightly larger than females. Males are bright red with a black mask around their red bill and a prominent crest on the top of their head. Females are olive brown with red on their wings, tail, and crest, and a red bill. Juveniles are similar in colour to females but have a black bill and a shorter crest.",
  birdimgUrl:"https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Northern_Cardinal_%28Cardinalis_cardinalis%29_male.jpg/1200px-Northern_Cardinal_%28Cardinalis_cardinalis%29_male.jpg",
    is_Featured:false,
    Height:"2.2-2.7 cm",
    Weight:"42-48 g",
    Diet:"The diet of the northern cardinal consists mainly of insects and vegetable material. Vegetable material may include weed seeds, leaf buds, grains, and berries..",
    Location_name:"Afton State Park",
    Region:" Minnesota",
    Colour:" Brilliant  red",
    Biome:"Forest",
    Habitat:"The northern cardinal doesn’t migrate. Instead it stays in its territory year-round. It makes its home in thickets and brushy areas and at the edges of woodlands."
};

// Add a new document in collection "Birds" with ID 'Bird1'
let setDoc1 = db.collection('Birds').doc('Bird1').set(Bird1);
   console.log('new Bird 1 has been added to the database')



    let Bird2 = {

    name:"Pileated woodpecker",
    Description:"The pileated is the largest woodpecker in Canada. \
    These colossal birds, with their striking red crest and resemblance \
    to prehistoric pterodactyls in flight, are thought to be the inspiration for\
    the once popular cartoon Woody the Woodpecker. As Woody had his loud laugh, pileated\
    woodpeckers also made noise to match their size. Their drumming, reminiscent of construction machinery,\
    can be heard up to a kilometre away.",
   birdimgUrl:"https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/PileatedWoodpeckerFeedingonTree%2C_crop.jpg/1200px-PileatedWoodpeckerFeedingonTree%2C_crop.jpg",
    is_Featured:true,
    Height:" 40-49 cm",
    Weight:"364 g",
    Diet:"Pileated woodpeckers are primarily insect eaters. Their favourite food is carpenter ants.",
    Location_name:"Mono Cliffs Provincial Park",
    Region:"Central Ontario",
    Colour:"Dull black and  red crest",
    Biome:"Deciduous or mixed deciduous-coniferous woodlands",
    Habitat:"Pileated woodpeckers need large uninterrupted patches of woodland, covering territories of 100 to 200 acres. These large birds live in older coniferous or deciduous forests - and occasionally in younger forests with old dead trees in it."
};

// Add a new document in collection "Birds" with ID 'Bird2'
let setDoc2 = db.collection('Birds').doc('Bird2').set(Bird2);
   console.log('new Bird 2 has been added to the database')

   let Bird3 = {
    name:"Baltimore-oriole",
    Description:"The male has a beautiful flute-like song, which he performs throughout\
    the summer. The female’s song, in comparison, is shorter and simpler. While songs \
    vary slightly from one bird to the next, they always have the recognizable “hew-li”\
    sound.",
   birdimgUrl:"https://www.allaboutbirds.org/guide/assets/og/75258971-1200px.jpg",
    is_Featured:false,
    Height:"17–22 cm",
    Weight:"22.3 to 42 g",
    Diet:"While caterpillars form a large part of their diet, orioles also eat spiders, \
    grasshoppers, crickets, beetles, butterflies, moths and fruit.",
    Location_name:"Babine Lake Marine Provincial Park ",
    Region:"British Columbia.",
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
    name:"Black-capped Chickadee",
    Description:"Black-capped Chickadees are small birds. The Gray-headed Chickadee \
    ecile cincta is widely distributed across Asia and Europe. In North America,\
     this brownish-grey chickadee is found in a small corner of the northwestern \
     Yukon and eastern Alaska, where it lives in the willow and spruce woods bordering the treeline.",
   birdimgUrl:"https://naturallycuriouswithmaryholland.files.wordpress.com/2013/11/11-20-13-black-capped-chickadee-img_01071.jpg",
    is_Featured:true,
    Height:"12 to 15 centimetres",
    Weight:"9-14 g",
    Diet:"The Black-capped Chickadee eats a mixture of seeds, insects and spiders",
    Location_name:"Fundy Provincial Park ",
    Region:"Nova Scotia, Saskatchewan, Quebec",
    Colour:"Grey backs, a black cap that covers their eyes, white cheeks and a black triangular bib on the throat. ",
    Biome:"taiga; forest.",
    Habitat:"It lives in tree-covered areas — including woodlots and orchards."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc4 = db.collection('Birds').doc('Bird4').set(Bird4);
   console.log('new Bird 4 has been added to the database')




//bird5
 let Bird5 = {
    name:"Burrowing owl",
    Description:" The burrowing owl is now much more rare. The Canadian population \
    f this little bird of prey has declined over 95 per cent since 1987, and now occupies \
    a mere 36 percent of its original distribution in Canada. This alarming rate of decline\
     has motivated scientists to list the species as endangered under the Species at Risk Act.",
   birdimgUrl:"https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Brazilian_burrowing_owl_%28Athene_cunicularia_grallaria%29.jpg/1200px-Brazilian_burrowing_owl_%28Athene_cunicularia_grallaria%29.jpg",
    is_Featured:false,
    Height:"20 cm",
    Weight:"150 g",
    Diet:"Burrowing Owls eat invertebrates and small vertebrates, including lizards, birds,\
     and mammals. Invertebrates, especially insects",
    Location_name:"Asessippi Provincial Park ",
    Region:"Manitoba, Saskatchewan",
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
    name:"Cedar Waxwings",
    Description:"The Cedar Waxwing gets its name in part due to the brightly coloured wax-like tips of their\
     feathers. “Cedar” comes from their consumption of juniper berries. While several different \
     trees have the word “cedar” in their common name, one, the Eastern Redcedar (Juniperus virginiana)\
     which is actually a juniper, has blue fruit that these waxwings eat. They have a bright yellow band at \
     the end of their tails. Sometimes you can see a thin red stripe on the edge of their secondary wing feathers.",
   birdimgUrl:"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Cedar_Waxwing_August_14_2012_Newfoundland_PA.jpg/1200px-Cedar_Waxwing_August_14_2012_Newfoundland_PA.jpg",
    is_Featured:false,
    Height:"14-17 cm",
    Weight:"32 g",
    Diet:"Cedar Waxwings eat small fruit year round. They will feed from shrubs and trees\
     like mountain ash, dogwoods, and serviceberries.",
    Location_name:"Heritage Park Historical Village",
    Region:"Saskatchewan,Alberta",
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
    name:"Common redpoll",
    Description:"The common redpoll is a small bird. A member of the finch family, this streaked bird can be difficult\
     to distinguish from pine siskins. Redpolls are named for their red forehead but this is not always obvious, so look \
     instead for the black patch on their chin to recognize them. To identify the sex of common redpolls look for the slight tinge \
     of rose on the breasts of the males.",
   birdimgUrl:"https://philipschwarzphotography.files.wordpress.com/2013/02/common-redpoll-female-13-1-_1566.jpg",
    is_Featured:false,
    Height:"11-14 cm",
    Weight:"12 and 16 g",
    Diet:"Redpolls subsist almost entirely on a diet of birch seeds",
    Location_name:"Asi Keyi Territorial park",
    Region:"Yukon, Northwest and Nunavut",
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
    name:"Dark-eyed juncos",
    Description:"Dark-eyed juncos vary geographically in terms of their colouration.\
     Depending on the region, the backs and sides of dark-eyed juncos can vary from dark grey \
     to reddish-brown. In all regions, however, adults can typically be identified by their dark \
     grey to black coloured head and breast (known as their hood), white outer tail feathers and white undersides.",
    birdimgUrl:"https://upload.wikimedia.org/wikipedia/commons/b/b3/Dark-eyed_Junco-27527-3.jpg",
    is_Featured:true,
    Height:"14-16 cm",
    Weight:"18-30 g",
    Diet:"Dark-eyed juncos are ground feeders whose diet changes seasonally. During the breeding season \
    insects make up the bulk of their diet. At this time it’s common to see juncos hopping along the ground\
     in pursuit of their insect prey. In the non-breeding season they forage for seeds, insects and arthropods.",
    Location_name:"Finger-Tatuk Provincial Park",
    Region:"British Columbia",
    Colour:"Dark grey to black coloured head and breast",
    Biome:"Prefer forest edges",
    Habitat:"In winter, their habitat shifts to roadsides, fields, gardens and parks that offer tree protection."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc8 = db.collection('Birds').doc('Bird8').set(Bird8);
   console.log('new Bird 8 has been added to the database')


//bird8
 let Bird9 = {
    name:"Gray Catbirds",
    Description:"All Gray Catbirds, regardless of their age or gender, are mainly grey with black colouring\
    on the tops of their heads and orange-brown underneath the base of their tail. Their calls are a raspy \
    cat-like sound while their songs are highly variable and often melodic.",
    birdimgUrl:"http://2.bp.blogspot.com/-Jct9xDnsdG4/UG_Mtw4l4_I/AAAAAAAAARU/CbSJMwwdPZo/s1600/Gray+Catbird.JPG",
    is_Featured:true,
    Height:"21-24 cm",
    Weight:"23.2-56.5 g",
    Diet:"Gray Catbirds eat a variety of insects including ants, grasshoppers, beetles, caterpillars and moths",
    Location_name:"Tombston Territorial park",
    Region:"Yukon, Northwest and Nunavut",
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
    name:"Great Horned Owl",
    Description:"The Great Horned Owl is one of Canada’s commonest large birds of prey. The most notable physical attributes \
    are its large size and prominent ear tufts or 'horns' A predator that hunts at night, this owl has enormous yellow eyes set\
     in a broad face, a curved beak and claws, and long fluffy feathers. Its coloration tends mainly toward brown or grey-brown,\
      with conspicuous barring. This bird’s legendary hooting sounds like a soft yet vibrant whoo-hoo-ho-o-o.",
    birdimgUrl:"https://i.ytimg.com/vi/Cu3bgBVyrNw/maxresdefault.jpg",
    is_Featured:false,
    Height:"55 cm",
    Weight:"910-2500 g",
    Diet:"The Great Horned Owl mainly depends upon medium-size mammals and birds to rabbits and hares where available.\
     When mice or voles are abundant they will consume these as well.",
    Location_name:"Fundy Provincial Park ",
    Region:"Nova Scotia, Manitoba, New Brunswick, Newfoundland, Quebec, Saskatchewan, Yukon Territories, Nunavut, Ontario, \
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
    name:"American crow",
    Description:"Crows and their kin are very interesting birds, members of what may be the most intelligent \
    avian family — the Corvidae. The crow’s cousins include magpies, blue jays, jackdaws, rooks, nutcrackers \
    and ravens. Many people use the terms crow and raven interchangeably but the two birds are actually quite different",
   birdimgUrl:"https://www.nps.gov/chat/learn/nature/images/american-crow.jpg",
    is_Featured:false,
    Height:"40-53 cm",
    Weight:"316-620 g",
    Diet:"Crows are omnivorous - they will eat anything edible, and many things, which aren't. Their regular diet includes \
    insects, crops (especially corn), carrion, fruit, nuts and occasionally the eggs or young of other birds",
    Location_name:"Kusawa Territorial park",
    Region:"Yukon",
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
    name:"American robin ",
    Description:"The American robin is the largest thrush in North America. Males are not only more vocal than females, \
    but also slightly larger and more brightly coloured. Adult American robins have grey-brown backs, characteristic \
    reddish breasts, white bellies, white chins, yellow bills and throats with dark streaks. Juveniles have dark speckles \
    on their backs and on their cinnamon-coloured breast",
   birdimgUrl:"https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/Turdus-migratorius-002.jpg/1200px-Turdus-migratorius-002.jpg",
    is_Featured:true,
    Height:"20-28 cm",
    Weight:"5.5 g ",
    Diet:"During the spring and summer, it eats invertebrates such as earthworms, caterpillars and beetles, and in the fall\
     and winter switches to fruits such as viburnum, sumac, chokecherries and tomatoes.",
    Location_name:"Prince Edward Island National Park",
    Region:"Saskatchewan, Yukon Territories, Nunavut, Ontario, Prince Edward Island, British Columbia, Alberta",
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
    name:"Purple Martin",
    Description:"The Purple Martin, Progne subis, is a conspicuous bird in many populated areas\
     of North America during spring and summer. Averaging 17 to 20 cm in length and a wing span of 9-41 cm, \
     it is Canada’s largest swallow. The life span of this swallow is one to five years. The Purple Martin\
      resembles other swallows in having a slender body, long wings, and a wide beak. Males show a shiny blue-black\
       coloration on sunny days. Females are lighter in colour, with a pale grey throat and belly.",
   birdimgUrl:"http://www.audubon.org/sites/default/files/styles/hero_cover_bird_page/public/Purple%20Martin%20s60-5-005_V.jpg?itok=dlGL_tZc",
    is_Featured:false,
    Height:"  17-20 cm",
    Weight:"45-60 g",
    Diet:"Martins consume a variety of the larger flying insects, including dragonflies, moths, butterflies, house flies, horse flies, and deer flies.",
    Location_name:"Fundy Provincial Park ",
    Region:"Nova Scotia, the southern portions of New Brunswick, Quebec",
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
    name:"Red-breasted Nuthatch",
    Description:"Red-breasted Nuthatches are small birds reaching about 4.5 inches in length with a thin black bill and short tail. They have a black and white\
     striped head, white throat, grey back and rust-coloured belly.",
    birdimgUrl:"http://www.wilddelight.com/wp-content/uploads/2013/01/RedBreastedNuthatch01.jpg",
    is_Featured:false,
    Height:"11 cm",
    Weight:"8-13 g",
    Diet:"These songbirds glean insects and spiders from tree bark. In the winter they eat seeds and nuts such as those from fir, spruce, beech and oak trees.\
     Red-breasted Nuthatches visit feeders with suet and/or sunflower seeds.",
    Location_name:"Tweedsmuir South Provincial Park",
    Region:"Nova Scotia, Manitoba, New Brunswick, Newfoundland, Quebec, Saskatchewan, Yukon Territories, Nunavut,\
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
    name:"Red-winged blackbird ",
    Description:"The red-winged blackbird is a medium-sized songbird, ranging in size from 17 to 23 centimetres, \
    with a very distinct call. Males are a sleek black colour with bright red patches on the tops of their wings. These red patches\
     are called epaulettes and are sometimes less visible while the bird is perched, when it only shows the slight yellow band found \
     below the red epaulettes. Females are less distinctive with their brown- and white-striped backs and white- and brown-striped abdomens. \
     Their colouring often causes them to be mistaken for other species of blackbird or sometimes for sparrows.",
   birdimgUrl:"https://mybluesunshine.files.wordpress.com/2015/05/6a00e5513924e68833017615996437970c.jpg",
    is_Featured:true,
    Height:"17 to 23 cm",
    Weight:"32-77 g",
    Diet:"The diet of a red-winged blackbird consists mostly of seeds and grains.",
    Location_name:"Kusawa Territorial park",
    Region:"Yukon to north western British Columbia",
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
    name:"Rose-breasted grosbeak",
    Description:"With most birds, males are more brightly coloured, and this holds true with the rose-breasted \
    grosbeak. The males are the most attractive with black backs and heads, white bumps and bellies and rose triangular \
    patches on their breasts. The females, however, are not as conspicuous. Females have brown streaking on both their\
     pale under parts and darker backs.Rose-breasted grosbeaks are said to have one of the prettiest calls. It is comparable\
      to that of the American robin but with a more melodic sound.",
   birdimgUrl:"https://www.animalspot.net/wp-content/uploads/2016/01/Rose-Breasted-Grosbeak-Female.jpg",
    is_Featured:false,
    Height:"18-21 cm",
    Weight:"39-49 g",
    Diet:"Rose-breasted grosbeaks feed on insects, seeds, fruits and flower buds. Common items include beetles, \
    bees, ants, crabapples, service berries, elderberries and Juneberries.",
    Location_name:"Mount Pope Provincial Park",
    Region:"British Columbia",
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
    name:"Ruby-throated hummingbird",
    Description:"Adult males are metallic green on the upperparts, iridescent ruby red on the throat, white on the \
    underparts and green along the sides. Adult females look similar to males but with a white throat, greyish belly\
     and buff along the sides of the belly, sometimes with a little red on the throat. Immature males look similar to \
     females but with red streaks down the throat.",
   birdimgUrl:"http://3.bp.blogspot.com/-4K3XRMSNmmA/T57Mq6ESL0I/AAAAAAAADhw/gWaZm_38c7M/s1600/rubythroatedhummingbird2.jpg",
    is_Featured:true,
    Height:"9–10 cm",
    Weight:" 2-6 g",
    Diet:"Drinks floral nectar, especially of tubular flowers such as the cardinal flower",
    Location_name:"Fundy Provincial Park ",
    Region:"Alberta to Nova Scotia.",
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
    name:"Rufous hummingbirds",
    Description:"Adult male upperparts are mainly reddish-brown with dull green on the top of their head\
     and a white patch behind the eyes. Their throat is iridescent orange-red and has white at the top of their \
     breast and parts of the belly; the rest of its underparts are reddish-brown. Adult females are similar to males \
     but paler and greener; their throat is white with dark and/or iridescent spots of orange-red. Immature birds resemble\
      the females, but immature males start to show reddish-brown upperparts before their throat colours develop.",
   birdimgUrl:"https://climate.audubon.org/sites/default/files/bird_photo_gallery_images/Rufous_Hummingbird_NicoleBeaulac:FlickrCC.jpg",
    is_Featured:false,
    Height:"9.5 cm",
    Weight:"2.4-3.6 g",
    Diet:"They drink floral nectar from tubular flowers such as wild columbines.",
    Location_name:"Heritage Park Historical Village",
    Region:"British Columbia, western Alberta",
    Colour:"Adult male upperparts are mainly reddish-brown with dull green on the top of their head and a white patch behind the eyes.",
    Biome:"hose in the crook of a tree",
    Habitat:"Found in a variety of habitats including mountain meadows, forests, woodlands, edges, open shrubby areas, gardens, parks and swamps."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc18 = db.collection('Birds').doc('Bird18').set(Bird18);
   console.log('new Bird 18 has been added to the database')



//bird19
 let Bird19 = {
    name:"Spotted Owl",
    Description:"The Northern Spotted Owl is a fairly large, brown owl, 40 to 48 centimetres long, with a puffy round head and no ear tufts.\
     The chocolate to chestnut brown feathers of the head, neck, back and under-parts have many circular or irregular white spots, for which \
     this attractive owl is named. The Northern Spotted Owl has large, round facial discs with dark outer rims, dark brown eyes and a yellowish-green bill.",
   birdimgUrl:"https://www.americanforests.org/wp-content/uploads/2012/07/northern-spotted-owl-2.jpg",
    is_Featured:true,
    Height:" 40-48 cm",
    Weight:"600 g",
    Diet:"This bird hunts at night.The spotted owl eats small and medium-sized mammals, especially rodents.",
    Location_name:"Heritage Park Historical Village",
    Region:"British Columbia",
    Colour:"Dark brown eyes and a yellowish-green bill.",
    Biome:"Spotted owls do not make their own nests, They will nest in tree cavities, broken-topped trees and platforms.",
    Habitat:"In the northern part of their range, they live in old-growth coniferous forests. They can use other forest types and rocky canyons, but prefer mature forests."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc19 = db.collection('Birds').doc('Bird19').set(Bird19);
   console.log('new Bird 19 has been added to the database')


//bird20
 let Bird20 = {
    name:"Northern Flicker",
    Description:"Northern Flickers are a mid-sized woodpecker reaching approximately 32 centimetres. There are two types, \
    the more widely spread Yellow-shafted Northern Flicker and the Red-shafted found mainly in southern British Columbia.\
     Both have a spotted breast, black breast band below the throat, black barring on their backs (lines that run across their\
      backs from wing to wing) and white patch on their rump, visible in flight.",
    birdimgUrl:"https://mmeara.files.wordpress.com/2012/09/pic-flamb-male-aur1.jpg",
    is_Featured:true,
    Height:"32 cm",
    Weight:"110-160 g",
    Diet:"Northern Flickers spend their time on the ground searching for and eating ants. They hunt for ants along the side of quiet \
    country roads, in wooded clearings, in gardens and away from the cover of trees.",
    Location_name:"Mount Pope Provincial Park",
    Region:"Southern British Columbia",
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
    name:"White-crowned sparrow",
    Description:"The most distinctive feature of this relatively large sparrow, as reflected in its name, is the striped crown. Its grey head is\
     crowned with conspicuous black and white stripes. The white-crowned sparrow lacks the yellow spot near each eye and the white throat of the\
      white-throated sparrow, a close relative. This bird is approximately 17 - 19 cm in size. Loud scuffling in the bushes often signals the presence\
       of this spirited bird. Using both of its rather large feet, it vigorously scratches among the leaf litter in search of food.",
   birdimgUrl:"https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/White-crowned-Sparrow.jpg/1200px-White-crowned-Sparrow.jpg",
    is_Featured:false,
    Height:" 17-19 cm",
    Weight:"25-28 g",
    Diet:"White-crowned Sparrows eat mainly seeds of weeds and grasses and grains including oats, wheat, barley and corn. They also consume\
     considerable numbers of caterpillars, wasps, beetles, and other insects during the summer.",
    Location_name:"Little Qualicum Falls Provincial Park",
    Region:"British Columbia, western Alberta",
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
    name:"Swallows",
    Description:"The swallows, martins, and saw-wings, or Hirundinidae, are a family of passerine birds found around the world\
     on all continents, including occasionally in Antarctica. Highly adapted to aerial feeding, they have a distinctive appearance.\
      The term 'swallow' is used colloquially in Europe as a synonym for the barn swallow. Around 90 species of Hirundinidae are known,\
       divided into 19 genera, with the greatest diversity found in Africa, which is also thought to be where they evolved as hole-nesters.",
   birdimgUrl:"https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Landsvale.jpg/1200px-Landsvale.jpg",
    is_Featured:false,
    Height:"15-19 cm",
    Weight:"17-20 g",
    Diet:"seeds of Acacia trees",
    Location_name:"Jasper National Park",
    Region:"western Alberta ",
    Colour:"Barn Swallows have a steely blue back, wings, and tail, and rufous to tawny underparts.",
    Biome:"Their nests are often easy to spot under the eaves or inside of sheds, barns, bridges and other structures.",
    Habitat:"You can find the adaptable Barn Swallow feeding in open habitats from fields, parks, and roadway edges to marshes, meadows, ponds, and coastal waters."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc22 = db.collection('Birds').doc('Bird22').set(Bird22);
   console.log('new Bird 22 has been added to the database')



//bird23
 let Bird23 = {
    name:"Finches",
    Description:"The true finches are small to medium-sized passerine birds in the family Fringillidae.\
     Finches have stout conical bills adapted for eating seeds and often have colourful plumage.\
      They occupy a great range of habitats where they are usually resident and do not migrate. They have\
       a worldwide distribution except for Australia and the polar regions. The family Fringillidae contains\
        more than two hundred species divided into fifty genera. It includes species known as siskins, canaries,\
         redpolls, serins, grosbeaks and euphonia.",
  birdimgUrl:"https://fthmb.tqn.com/tvPe1GjuUCasntTK2maHH_0FBZo=/1280x853/filters:fill(auto,1)/gouldian-finch-188062467-resized-58a6ea6e5f9b58a3c9190af4.jpg",
    is_Featured:false,
    Height:" 24 cm",
    Weight:"83 g",
    Diet:"Drink floral nectar, especially of tubular flowers such as the cardinal flower",
    Location_name:"Asi Keyi Territorial park",
    Region:"Yukon to north western British Columbia",
    Colour:"Brownish,sometimes greenish;many have considerable amounts of black",
    Biome:" Grassland; forest; scrub forest.",
    Habitat:"Finches are typically inhabitants of well-wooded areas, but some can be found on mountains or even in deserts."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc23 = db.collection('Birds').doc('Bird23').set(Bird23);
   console.log('new Bird 23 has been added to the database')


//bird24
 let Bird24 = {
    name:"Warblers",
    Description:"Various Passeriformes (perching birds) are commonly referred to as warblers. They are not necessarily closely related to one another, \
    but share some characteristics, such as being fairly small, vocal, and insectivorous.They are mostly brownish or dull greenish in color.\
     They tend to be more easily heard than seen. Identification can be difficult and may be made on the basis of song alone (to English-speaking \
     birdwatchers in Europe, warblers are the archetypal 'LBJs', or little brown jobs).",
   birdimgUrl:"https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Dendroica-fusca-001.jpg/1200px-Dendroica-fusca-001.jpg",
    is_Featured:false,
    Height:"12-15 cm",
    Weight:"9-13 g",
    Diet:"yellow Warblers eat mostly insects that they pick from foliage or capture on short flights or while hovering to reach leaves. Typical \
    prey include midges, caterpillars, beetles, leafhoppers and other bugs, and wasps.",
    Location_name:"Asi Keyi Territorial park",
    Region:"Yukon to north western British Columbia",
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
    name:"Blue Jay",
    Description:"The blue jay (Cyanocitta cristata) is a passerine bird in the family Corvidae, native to eastern North America.  It breeds in both deciduous and coniferous forests,\
     and is common in residential areas. It is predominantly blue with a white chest and underparts, and a blue crest; it has a black, U-shaped collar around its neck and a black border\
      behind the crest. Males and females are similar in size and plumage, and plumage does not vary throughout the year. Four subspecies of the blue jay have been recognized.",
   birdimgUrl:"https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Cyanocitta-cristata-004.jpg/1200px-Cyanocitta-cristata-004.jpg",
    is_Featured:true,
    Height:"22–30 cm",
    Weight:"70–100 g",
    Diet:"Blue jays have strong black bills which they use for cracking nuts, usually while holding them with their feet, and for eating corn, grains and seeds. Its food is sought \
    both on the ground and in trees and includes virtually all known types of plant and animal sources, such as acorns and beech mast, weed seeds, grain, fruits and other berries, \
    peanuts, bread, meat, small invertebrates of many types, scraps in town parks, bird-table food and rarely eggs and nestlings",
    Location_name:"Tweedsmuir South Provincial Park",
    Region:"Nova Scotia, Manitoba, New Brunswick, Newfoundland, Quebec.",
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
    name:"Wrens",
    Description:"Wrens are a family of brown passerine birds in the predominantly New World family Troglodytidae. The family includes 88 \
    species divided into 19 genera. Only the Eurasian wren occurs in the Old World, where, in Anglophone regions, it is commonly known simply\
     as the 'wren', as it is the originator of the name.",
   birdimgUrl:"https://www.audubon.org/sites/default/files/House_Wren_w27-4-011_l.jpg",
    is_Featured:false,
    Height:"22 cm",
    Weight:"50 g",
    Diet:"Wrens eat primarily insects but will sample berries as well, particularly in the fall and winter when insects are scarcer.",
    Location_name:"Cap-Saint Jacques Nature Park",
    Region:"Senneville",
    Colour:"Brown",
    Biome:"The various species occur in a wide range of habitats, ranging from dry, sparsely wooded country to rainforest.",
    Habitat:"They prefer brushy tangles, thickets, and hedgerows."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc26 = db.collection('Birds').doc('Bird26').set(Bird26);
   console.log('new Bird 26 has been added to the database')


//bird27
 let Bird27 = {
    name:"Common Terns",
    Description:"Common Terns gracefully row through the sky showing off their long angular wings, and breeding season gray belly, \
    black cap, and red bill. They dive towards the water picking off fish just below the surface.",
    birdimgUrl:"https://upload.wikimedia.org/wikipedia/commons/b/bf/Common_tern_with_fish.jpg",
    is_Featured:true,
    Height:"31-38 cm",
    Weight:"93-200 g",
    Diet:"Mostly fish. Feeds on a wide variety of small fish, focussing on whatever types most easily available, sometimes concentrating on shrimp instead.",
    Location_name:"La Salle",
    Region:"Newfoundland,  Laval, Montérégie and Montreal",
    Colour:"Gray, Black",
    Biome:"Common Terns nest on rocky islands, barrier beaches, and saltmarshes and forage over open waters including inlets, lakes, and marine waters.",
    Habitat:" Terns construct floating nests from the vegetation in their wetland habitats, and a few species build simple nests in trees, on cliffs or in crevices."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc27 = db.collection('Birds').doc('Bird27').set(Bird27);
   console.log('new Bird 27 has been added to the database')


//bird28
 let Bird28 = {
    name :"Piping Plovers",
    Description:"Little round Piping Plovers hide in plain sight on sandy ocean and lake shores, blending right in with their sandy gray backs. \
    It's not until they scurry down the sand on their orange legs that you're likely to spot these big-eyed shorebirds with a sharp black ]\
    collar and an orange bill.",
    birdimgUrl:"https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Charadrius-melodus-004_edit.jpg/1200px-Charadrius-melodus-004_edit.jpg",
    is_Featured:false,
    Height:"17-18 cm",
    Weight:"43-63 g",
    Diet:"Plovers eat a variety of small organisms, primarily invertebrates. The vast majority of their diet\
     consists of worms, small insects, and crustaceans. ",
    Location_name:"Tommy Thompson Park",
    Region:"Toronto",
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

    name:"Common loon",
    Description:"The eerie calls of Common Loons echo across clear lakes of the northern wilderness. Summer adults are regularly patterned in \
    black and white. In winter, they are plain gray above and white below, and you’ll find them close to shore on most seacoasts and a good many \
    inland reservoirs and lakes.",
    birdimgUrl:"https://upload.wikimedia.org/wikipedia/commons/thumb/b/b0/Gavia_immer_-Minocqua%2C_Wisconsin%2C_USA_-swimming-8.jpg/1200px-Gavia_immer_-Minocqua%2C_Wisconsin%2C_USA_-swimming-8.jpg",
    is_Featured:false,
    Height:"66-91 cm",
    Weight:"2500-6100 g",
    Diet:"Their principal food is fish, but they also eat shellfish, frogs, and aquatic insects. ",
    Location_name:"Bowring park",
    Region:"NewFoundLand",
    Colour:"Black, White",
    Biome:"You can see  Common loon  on lakes, rivers, estuaries, and coastlines.",
    Habitat:"Common loons live on lakes and other waterways."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc29 = db.collection('Birds').doc('Bird29').set(Bird29);
   console.log('new Bird 29 has been added to the database')


//bird30
 let Bird30 = {
    name:"Cooper's Hawk",
    Description:"Among the bird world’s most skillful fliers, Cooper’s Hawks are common woodland hawks that tear through cluttered tree canopies in high speed \
    pursuit of other birds. You’re most likely to see one prowling above a forest edge or field using just a few stiff wingbeats followed by a glide.",
    birdimgUrl:"http://2.bp.blogspot.com/-VzRzd4a0EMo/UMcozCNlxfI/AAAAAAAAZWk/GciLj1TiCXM/s1600/Cooper's+Hawk,+Tucson,+12-08-12-0937.jpg",
    is_Featured:false,
    Height:"42-45 cm",
    Weight:"330-680 g",
    Diet:"Mostly birds and small mammals. Feeds mainly on medium-sized birds, in the size range of robins, jays, flickers, also on larger and smaller birds.",
    Location_name:"La Pointe-Aux-Lièvres",
    Region:"Vancouver, Saint Roch,Quebec City",
    Colour:"blue-gray",
    Biome:"Wooded habitats from deep forests to leafy subdivisions and backyards.",
    Habitat:"Cooper's hawks prefer to nest in tall trees with extensive canopy cover."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc30 = db.collection('Birds').doc('Bird30').set(Bird30);
   console.log('new Bird 30 has been added to the database')



//bird31
 let Bird31 = {
    name:"Grosbeak",
    Description:"Grosbeak is a form taxon containing various species of seed-eating passerine birds with large beaks. Although they all belong to the\
     superfamily Passeroidea, these birds are not part of a natural group but rather a polyphyletic assemblage of distantly related songbirds.",
   birdimgUrl:"https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Black-headed_Grosbeak.jpg/220px-Black-headed_Grosbeak.jpg",
    is_Featured:false,
    Height:"16-18 cm",
    Weight:"53-74 g",
    Diet:"They feed predominantly on tree nuts, seeds, berries, fruit and insects.",
    Location_name:"Field Bird Sanctuary",
    Region:"Thunder Bay, Greater Sudbury",
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
    name:"Neotropic Cormorant",
    Description:"A nearly all-black waterbird with a snaky neck, the Neotropic Cormorant occurs in sheltered waters of southern U.S. states, the Caribbean, \
    and Latin America. It is smaller and longer-tailed than other cormorants, but otherwise looks very similar to the Double-crested Cormorant, and the two\
     species often flock together",
    birdimgUrl:"https://upload.wikimedia.org/wikipedia/commons/thumb/0/0e/Phalacrocorax_brasilianus_%28Costa_Rica%29.jpg/1200px-Phalacrocorax_brasilianus_%28Costa_Rica%29.jpg",
    is_Featured:false,
    Height:"61 cm",
    Weight:"1070-1500 g",
    Diet:"Wrens eat primarily insects but will sample berries as well, particularly in the fall and winter when insects are scarcer",
    Location_name:"Jasper National Park,Gasper",
    Region:"Alberta",
    Colour:"Black, White, Orange",
    Biome:"Often rests in small flocks, near water’s edge on land, on islands, or in trees.",
    Habitat:"Nests in trees or on bare ground next to water, often on barrier islands or small islands in lakes."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc32 = db.collection('Birds').doc('Bird32').set(Bird32);
   console.log('new Bird 32 has been added to the database')


//bird33
 let Bird33 = {
    name:"European Starling",
    Description:"The common starling, also known as the European starling in the United States or simply the starling in the British Isles, is a \
    medium-sized passerine bird in the starling family, Sturnidae. It is about 20 cm long and has glossy black plumage with a metallic sheen, which is\
     speckled with white at some times of year.",
   birdimgUrl:"https://i.ytimg.com/vi/9d8DOhz2UkA/maxresdefault.jpg",
    is_Featured:false,
    Height:"20-23 cm",
    Weight:"60-96 g",
    Diet:"The common starling is largely insectivorous and feeds on both pest and other arthropods.",
    Location_name:"Le Sud-Ouest",
    Region:"New York, Montreal",
    Colour:"Brown, Black, Purple",
    Biome:"Starlings are common in towns, suburbs, and countryside near human settlements.",
    Habitat:"They sit high on wires or trees making a constant stream of rattles, whirrs, and whistles."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc33 = db.collection('Birds').doc('Bird33').set(Bird33);
   console.log('new Bird 33 has been added to the database')


//bird34
 let Bird34 = {
    name:"Northern Flickers",
    Description:"Northern Flickers are large, brown woodpeckers with a gentle expression and handsome black-scalloped plumage. On walks, don’t be surprised \
    if you scare one up from the ground. It’s not where you’d expect to find a woodpecker, but flickers eat mainly ants and beetles, digging for \
    them with their unusual, slightly curved bill. ",
   birdimgUrl:"https://i.ytimg.com/vi/cL-DNEHI21s/maxresdefault.jpg",
    is_Featured:true,
    Height:"28-31 cm",
    Weight:"110-160 g",
    Diet:"Northern Flickers eat mainly insects, especially ants and beetles that they gather from the ground.",
    Location_name:"Miramichi",
    Region:"Halifax, NorthTumberland, Charlottetown, Miramichi",
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
    name:"House Finch",
    Description:"The House Finch is a recent introduction from western into eastern North America (and Hawaii), but it \
    has received a warmer reception than other arrivals like the European Starling and House Sparrow.",
    birdimgUrl:"https://www.bird-sounds.net/images/house-finch.jpg",
    is_Featured:false,
    Height:"13-14 cm",
    Weight:"16-27 g",
    Diet:"House Finches eat almost exclusively plant materials, including seeds, buds and fruits.",
    Location_name:"Rideau Heights",
    Region:"Kingston",
    Colour:"Red, Brown",
    Biome:"House Finches frequent city parks, backyards, urban centers, farms, and forest edges across the continent.",
    Habitat:"you can find House Finches around barns and stables."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc35 = db.collection('Birds').doc('Bird35').set(Bird35);
   console.log('new Bird 35 has been added to the database')


//bird36
 let Bird36 = {
    name:"Bushtit",
    Description:"Bushtits are sprightly, social songbirds that twitter as they fly weakly between shrubs and thickets in\
     western North America. Almost always found in lively flocks, they move constantly, often hanging upside down to pick at insects or spiders on the undersides of leaves.",
    birdimgUrl:"https://www.bird-sounds.net/images/bushtit.jpg",
    is_Featured:false,
    Height:"7-8 cm",
    Weight:"4-6 g",
    Diet:"Mostly insects. Feeds on a wide variety of tiny insects, especially leafhoppers, treehoppers, aphids, scale insects, caterpillars, and beetles; \
    also wasps, ants, and many others, including eggs and pupae of many insects.",
    Location_name:"Matsqui Prairie",
    Region:"Abbotsford",
    Colour:"Brown, Gray",
    Biome:"Bushtits live in oak forest, evergreen woodlands, dry scrublands, streamsides, and suburbs.",
    Habitat:"Bushtits weave a very unusual hanging nest, shaped like a soft pouch or sock, from moss, spider webs, and grasses."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc36 = db.collection('Birds').doc('Bird36').set(Bird36);
   console.log('new Bird 36 has been added to the database')



//bird37
 let Bird37 = {
    name:"Anna’s Hummingbird",
    Description:"Anna’s Hummingbirds are among the most common hummingbirds along the Pacific Coast, yet they're anything but common in appearance.\
     With their iridescent emerald feathers and sparkling rose-pink throats, they are more like flying jewelry than birds.",
   birdimgUrl:"https://upload.wikimedia.org/wikipedia/commons/thumb/c/c4/Anna%27s_hummingbird.jpg/1200px-Anna%27s_hummingbird.jpg",
    is_Featured:false,
    Height:"10 cm",
    Weight:"3-6 g",
    Diet:"They also consume small insects and other arthropods caught in flight or gleaned from vegetation.",
    Location_name:"Victoria",
    Region:"Nova Scotia",
    Colour:"Green, Gray",
    Biome:"Anna’s Hummingbirds are common in yards, parks, residential streets, eucalyptus groves, riverside woods, savannahs, and coastal scrub.",
    Habitat:"Anna’s Hummingbirds generally nest in holes in trees like other woodpeckers."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc37 = db.collection('Birds').doc('Bird37').set(Bird37);
   console.log('new Bird 37 has been added to the database')


//bird38
 let Bird38 = {
    name:"Spotted Towhee",
    Description:"The Spotted Towhee is a large, striking sparrow of sun-baked thickets of the West. When you catch sight of one, they’re gleaming\
     black above (females are grayish brown), spotted and striped with brilliant white. Their warm rufous flanks match the dry leaves they spend their time hopping around in.",
    birdimgUrl:"http://nathistoc.bio.uci.edu/birds/passeriformes/Pipilo%20maculatus/Spotted%20Towhee4_San%20Joaquin%20WS_E%20Chen.jpg",
    is_Featured:false,
    Height:"17-21 cm",
    Weight:"33-49 g",
    Diet:"Mostly insects, seeds, berries. Diet varies with season. Eats many insects, especially in summer, including beetles, caterpillars, moths, true bugs, and many others, \
    also spiders, snails, and millipedes. Also eats many seeds, plus acorns, berries, and small fruits.",
    Location_name:"Campbell River",
    Region:"British Columbia",
    Colour:"White, Black, Yellow",
    Biome:"Look for Spotted Towhees in open, shrubby habitat with thick undergrowth. Spotted Towhees are also at home in backyards, forest edges, and overgrown fields.",
    Habitat:"Open woods, undergrowth, brushy edges."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc38 = db.collection('Birds').doc('Bird38').set(Bird38);
   console.log('new Bird 38 has been added to the database')


//bird39
 let Bird39 = {
    name:"Cedar Waxwing",
    Description:"The cedar waxwing is a member of the family Bombycillidae or waxwing family of passerine birds. It is a medium-sized, mostly brown, gray, and yellow bird named\
     for its wax-like wing tips. It is a native of North and Central America, breeding in open wooded areas in southern Canada.",
    birdimgUrl:"https://i.ytimg.com/vi/WFyzgFkQSRg/hqdefault.jpg",
    is_Featured:true,
    Height:"14-17 cm",
    Weight:"32 g",
    Diet:"Cedar Waxwings eat small fruit year round. They will feed from shrubs and trees like mountain ash, dogwoods, serviceberries, crabapples, hawthorns and winterberries.",
    Location_name:"Kenora District",
    Region:"Kenora",
    Colour:"Black, Brown, Yellow",
    Biome:"Look for Cedar Waxwings in woodlands of all kinds, and at farms, orchards, and suburban gardens where there are fruiting trees or shrubs.",
    Habitat:"Cedar Waxwings are social birds that form large flocks and often nest in loose clusters of a dozen or so nests. "
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc39 = db.collection('Birds').doc('Bird39').set(Bird39);
   console.log('new Bird 39 has been added to the database')


//bird40
 let Bird40 = {
    name:"Bald Eagle",
    Description:"The Bald Eagle has been the national emblem of the United States since 1782 and a spiritual symbol for native people for far longer than that.\
     These regal birds aren’t really bald, but their white-feathered heads gleam in contrast to their chocolate-brown body and wings.",
    birdimgUrl:"https://i.ytimg.com/vi/wr5AQff-SXQ/maxresdefault.jpg",
    is_Featured:false,
    Height:"71-96 cm",
    Weight:"3000-6300 g",
    Diet:"They eat mainly fish, but also hunt mammals, gulls, and waterfowl.",
    Location_name:"Senneville",
    Region:"Montreal, Lake Erie",
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
    name:"Mew Gull",
    Description:"The smallest North American white-headed gull, the Mew Gull is commonly described as \
    having a 'gentle' or 'dove-headed' look. The Mew Gull has typical gull-like plumage--slate-gray back and wings, \
     white head, tail, and body, and black wingtips with white spots. The beak and legs are yellow. ",
    birdimgUrl:"https://www.borealbirds.org/sites/default/files/styles/lightbox_max_wh/public/bird_images/mew-gull.jpg?itok=uFO9VNia",
    is_Featured:true,
    Height:"41-46 cm",
    Weight:"360-600 g",
    Diet:"Omnivorous. Diet may be mostly small fish along the coast, mostly insects around inland lakes,\
     but also eats crustaceans, mollusks, sea urchins, earthworms, small rodents, young birds of other species, carrion, refuse.",
    Location_name:"westmount",
    Region:"Montreal, Quebec City",
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
    name:"Pine Siskin",
    Description:"The pine siskin (Spinus pinus) is a North American bird in the finch family.\
     It is a migratory bird with an extremely sporadic winter range.",
    birdimgUrl:"https://www.bird-sounds.net/images/pine-siskin.jpg",
    is_Featured:true,
    Height:"11-14 cm",
    Weight:"12-18 g",
    Diet:"Mostly seeds and other vegetable matter, some insects. Feeds on seeds of alder, \
    birch, spruce, and many other trees, also those of weeds and grasses; eats buds, \
    flower parts, nectar, young shoots. Also feeds on insects, including caterpillars and aphids.",
    Location_name:"Stratford",
    Region:"perth",
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
    name:"Great Blue Heron",
    Description:"The great blue heron (Ardea herodias) is a large wading bird in the heron family Ardeidae, common near the shores of open water and in wetlands\
     over most of North America and Central America, as well as the Caribbean and the Galápagos Islands.",
   birdimgUrl:"https://www.google.com/search?q=Great+Blue+Heron&sxsrf=ALeKk00CjgBbVnlalF1F17ckrH15ILkC1w:1592108824935&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjavtDHu4DqAhUWXc0KHbWxAqUQ_AUoAXoECCEQAw&biw=650&bih=688#imgrc=6pM7ap8ksKv_dM",
    is_Featured:false,
    Height:"97-137 cm",
    Weight:"2100-2500 g",
    Diet:"Highly variable and adaptable. Eats mostly fish, but also frogs, salamanders, turtles, snakes, insects, rodents, birds.",
    Location_name:"Campbell River",
    Region:"British Columbia",
    Colour:"blue-gray",
    Biome:"Marshes, swamps, shores, tideflats. Very adaptable. Forages in any kind of calm fresh waters or slow-moving rivers, also in shallow coastal bays.",
    Habitat:"Nests in trees or shrubs near water"
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc43 = db.collection('Birds').doc('Bird43').set(Bird43);
   console.log('new Bird 43 has been added to the database')

//bird44
 let Bird44 = {
    name:"Bufflehead",
    Description:"The Bufflehead Bucephala albeola is Canada’s smallest diving duck. Strikingly patterned in black and white, and constantly active, \
    it attracts attention out of proportion to its relatively small numbers.",
   birdimgUrl:"https://i.ytimg.com/vi/LbNcdRrrJHs/maxresdefault.jpg",
    is_Featured:false,
    Height:"32-40 cm",
    Weight:"272-635 g",
    Diet:"Varies with season and habitat. In summer and on fresh water feeds mainly on aquatic insects; on ocean feeds mainly on crustaceans.\
    Also eats many mollusks (especially snails) in winter, and small amounts of plant material in fall.",
    Location_name:"EastPoint Park",
    Region:"Scarborough",
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
    name:"Northern Shrike ",
    Description:"The burly, bull-headed Northern Shrike is a pint-sized predator of birds, small mammals, and insects. A bold black mask and stout,\
     hooked bill heighten the impression of danger in these fierce predators. They breed in far northern North America and \
     come as far south as the northern U.S. for winter.",
   birdimgUrl:"https://www.larkwire.com/static/content/images/ipad/LBNA1/NorthernShrike.jpg",
    is_Featured:false,
    Height:"23-24 cm",
    Weight:"56-79 g",
    Diet:"Includes small birds, rodents, large insects. Varied diet includes many small songbirds, especially in winter and \
    early spring; also many voles and other small rodents, and many large insects when available.",
    Location_name:"Morgsn Aboretum",
    Region:"Montreal",
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
    name:"Pine Grosbeak",
    Description:"The pine grosbeak is a large member of the true finch family, Fringillidae. It is the only species in the genus Pinicola. \
    It is found in coniferous woods across Alaska, the western mountains of the United States, Canada.",
    birdimgUrl:"https://www.bird-sounds.net/images/pine-grosbeak.jpg",
    is_Featured:true,
    Height:"20-25 cm",
    Weight:"52-78 g",
    Diet:"Seeds, buds, berries, insects. Feeds mostly on vegetable matter, especially in winter.",
    Location_name:"Chapais",
    Region:"Chapais,  North Bay",
    Colour:"Eeyou Istchee Baie-James",
    Biome:"Conifers; in winter, other trees. Breeds in open coniferous forest, especially of spruce and fir;\
     despite the name, not usually in pines in summer.",
    Habitat:"Pine Grosbeaks inhabit open spruce, fir, and pine forests as well as subalpine forests."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc46 = db.collection('Birds').doc('Bird46').set(Bird46);
   console.log('new Bird 46 has been added to the database')



//bird47
 let Bird47 = {
    name:"Least Bittern",
    Description:"The furtive Least Bittern is often little more than a voice in the reeds that is frustratingly difficult to locate. \
    But these diminutive herons reward patience and will charm birders persistent enough to discover them in their wetland haunts.",
    birdimgUrl:"https://www.larkwire.com/static/content/images/ipad/LBNA1/LeastBittern.jpg",
    is_Featured:false,
    Height:"28-36 cm",
    Weight:"46-95 g",
    Diet:"Mostly fish and insects. Eats mostly small fish (such as minnows, sunfishes, and perch) and large insects (dragonflies and others); \
    also crayfish, leeches, frogs, tadpoles, small snakes, and other items.",
    Location_name:"Brandon",
    Region:"Manitoba",
    Colour:"Black, Pale",
    Biome:"The least bittern is found in freshwater or brackish marshes with tall grasses, cattails, and reeds.",
    Habitat:"This bird builds its nest above the marsh water in stands of dense vegetation, hidden among the cattails."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc47 = db.collection('Birds').doc('Bird47').set(Bird47);
   console.log('new Bird 47 has been added to the database')


//bird48
 let Bird48 = {
    name:"Least Sandpiper",
    Description:"Least Sandpipers are the smallest of the small sandpipers known as “peeps”—not much bigger than a sparrow. \
    They have distinctive yellow-green legs and a high-pitched creep call. Look for them on edges of mudflats or marshes, \
    where they walk with a hunched posture and probe for little crustaceans, insects, and other invertebrates.",
   birdimgUrl:"https://www.bird-sounds.net/images/least-sandpiper.jpg",
    is_Featured:true,
    Height:"13-15 cm",
    Weight:"19-30 g",
    Diet:"Tiny crustaceans, insects, snails. Diet varies with season and place.",
    Location_name:"Arthur park",
    Region:"Thunder Bay",
    Colour:"Brown, White, Black",
    Biome:" Mudflats, grassy marshes, rainpools, shores. In migration, often more common inland than on coast, favoring muddy edges of marshes, ponds, rivers.",
    Habitat:"They typically nest in sedge meadows, muskeg bogs, or coastal wetlands. "
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc48 = db.collection('Birds').doc('Bird48').set(Bird48);
   console.log('new Bird 48 has been added to the database')



//bird49
 let Bird49 = {
    name:"Mute Swan",
    Description:"The exotic Mute Swan is the elegant bird of Russian ballets and European fairy tales. This swan swims with its long neck curved into an S and \
    often holds its wings raised slightly above its back. Although they’re numerous and familiar in city parks and in bays and lakes in the Pacific Northwest,\
     Great Lakes, Northeast, and Mid Atlantic, Mute Swans are not native to North America.",
    birdimgUrl:"https://www.british-birdsongs.uk/images/mute-swan.jpg",
    is_Featured:true,
    Height:"127-152 cm",
    Weight:"5500-14300 g",
    Diet:"Mostly plant material. Feeds on seeds, stems, leaves, and roots of aquatic plants, including pondweeds, eelgrass, algae.",
    Location_name:"Rideau Heights",
    Region:"Kingston",
    Colour:"White",
    Biome:"Look for Mute Swans in city-park ponds, as well as rivers, lakes, and estuaries.",
    Habitat:"Swans are waterfowl, and rely very heavily on water bodies in their environment."
};

// Add a new document in collection "Birds" with ID 'Bird3'
let setDoc49 = db.collection('Birds').doc('Bird49').set(Bird49);
   console.log('new Bird 49 has been added to the database')


//bird50
 let Bird50 = {
    name:"Osprey",
    Description:"Unique among North American raptors for its diet of live fish and ability to dive into water to catch them, Ospreys are common sights\
     soaring over shorelines, patrolling waterways, and standing on their huge stick nests, white heads gleaming.",
    birdimgUrl:"https://i.ytimg.com/vi/f6UFcbJFwk0/hqdefault.jpg",
    is_Featured:false,
    Height:"54-58 cm",
    Weight:"1400-2000 g",
    Diet:"Osprey eat small mammals, birds, or reptiles. However, the Osprey is highly specialized for eating fish and does not stray from this diet unless necessary.",
    Location_name:"Hawk Cliff Rd",
    Region:"Union",
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/KZYUWIRZVH/XC439903-CARDINA_Northern%20No%203%20Uvalama%20400m%20071918%200711.mp3"
};


let setSound1 = db.collection('Birds').doc('Bird1')
  .collection('media').doc('Soundclip').set(Bird1mediaSound);



//Mediabird2
 let Bird2mediaImage = {
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/KZYUWIRZVH/XC439903-CARDINA_Northern%20No%203%20Uvalama%20400m%20071918%200711.mp3"
};


let setSound2 = db.collection('Birds').doc('Bird2')
  .collection('media').doc('Soundclip').set(Bird2mediaSound);



//Mediabird3
 let Bird3mediaImage = {
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/QZOXFIKPFF/XC415889-BAOR%20-%20Song%20-%20Jon%20Duerr%20-%202018-05-18%2006_27_01.mp3"
};


let setSound3 = db.collection('Birds').doc('Bird3')
  .collection('media').doc('Soundclip').set(Bird3mediaSound);


//Mediabird4
 let Bird4mediaImage = {
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/QZOXFIKPFF/XC406662-BCCH%20-%20Song%20-%20Johnson%20Sauk%20Trail%20SP%20-%202018-30-18%2008_45_01.mp3"
};


let setSound4 = db.collection('Birds').doc('Bird4')
  .collection('media').doc('Soundclip').set(Bird4mediaSound);






  //Mediabird5
 let Bird5mediaImage = {
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/FNIOJOZADD/XC296318-BurrowingOwl_Bolivia_043015_call.mp3"
};


let setSound5 = db.collection('Birds').doc('Bird5')
  .collection('media').doc('Soundclip').set(Bird5mediaSound);


//Mediabird6
 let Bird6mediaImage = {
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/FNIOJOZADD/XC296318-BurrowingOwl_Bolivia_043015_call.mp3"
};


let setSound6 = db.collection('Birds').doc('Bird6')
  .collection('media').doc('Soundclip').set(Bird6mediaSound);


//Mediabird7
 let Bird7mediaImage = {
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/INCBVJJLBJ/XC208556-urpi.mp3"
};


let setSound7 = db.collection('Birds').doc('Bird7')
  .collection('media').doc('Soundclip').set(Bird7mediaSound);


//Mediabird8
 let Bird8mediaImage = {
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/INCBVJJLBJ/XC208556-urpi.mp3"
};


let setSound8 = db.collection('Birds').doc('Bird8')
  .collection('media').doc('Soundclip').set(Bird8mediaSound);


//Mediabird9
 let Bird9mediaImage = {
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/QZOXFIKPFF/XC315205-GRCA%20-%20Song%2C%20Call%20-%20Elsen%20-%202016-05-05%2006_10.mp3"
};


let setSound9 = db.collection('Birds').doc('Bird9')
  .collection('media').doc('Soundclip').set(Bird9mediaSound);


//Mediabird10
 let Bird10mediaImage = {
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/KGOCOOKTTU/XC342574-Great%20Horned%20Owl%2C%20Jim%20Green%20Trail%2C%20Atascadero%2C%20iXY%2011-13-16.mp3"
};


let setSound10 = db.collection('Birds').doc('Bird10')
  .collection('media').doc('Soundclip').set(Bird10mediaSound);


//Mediabird11
 let Bird11mediaImage = {
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "Audio: https://www.xeno-canto.org/sounds/uploaded/RFTXRYBVBX/XC345874-American%20Crow%20-FL%2C%20River%20Lakes%2C%20December%2005%2C%202016%2C%200823%20AM.mp3"
};


let setSound11 = db.collection('Birds').doc('Bird11')
  .collection('media').doc('Soundclip').set(Bird11mediaSound);


//Mediabird12
 let Bird12mediaImage = {
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/RFTXRYBVBX/XC345874-American%20Crow%20-FL%2C%20River%20Lakes%2C%20December%2005%2C%202016%2C%200823%20AM.mp3"
};


let setSound12 = db.collection('Birds').doc('Bird12')
  .collection('media').doc('Soundclip').set(Bird12mediaSound);



//Mediabird13
 let Bird13mediaImage = {
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/FIDXCHEYJO/XC317055-Purple_Martin_831.mp3"
};


let setSound13 = db.collection('Birds').doc('Bird13')
  .collection('media').doc('Soundclip').set(Bird13mediaSound);


//Mediabird14
 let Bird14mediaImage = {
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/RHARFLKISN/XC120877-Sitta%20canadensis%2C%20Red-breasted%20Nuthatch%2C%20Nickerson%20State%20Park%2C%20Brewster%2C%20MA%2C%20USA%2C%20May%2012%2C%20%202012.MP3"
};


let setSound14 = db.collection('Birds').doc('Bird14')
  .collection('media').doc('Soundclip').set(Bird14mediaSound);


//Mediabird15
 let Bird15mediaImage = {
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/YTUXOCTUEM/XC408980-Agelaius_phoeniceus_nom-FL%20song%20CadyRd%20Grasslake%20MI%2026Feb17%209.16am%20LS111655a.mp3"
};


let setSound15 = db.collection('Birds').doc('Bird15')
  .collection('media').doc('Soundclip').set(Bird15mediaSound);


//Mediabird16
 let Bird16mediaImage = {
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/TGBFXDVERJ/XC420877-Pheucticus%20ludovicianus_Michigan_ML0282125.mp3"
};


let setSound16 = db.collection('Birds').doc('Bird16')
  .collection('media').doc('Soundclip').set(Bird16mediaSound);


//Mediabird17
 let Bird17mediaImage = {
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/WCNFEBIHCJ/XC139835-RTHU002.mp3"
};


let setSound17 = db.collection('Birds').doc('Bird17')
  .collection('media').doc('Soundclip').set(Bird17mediaSound);


//Mediabird18
 let Bird18mediaImage = {
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/PVQOLRXXWL/XC331693-Rufous%20Hummingbird%207.4.16%20Antelope%20Dr%206.47%20.26_0375.mp3"
};


let setSound18 = db.collection('Birds').doc('Bird18')
  .collection('media').doc('Soundclip').set(Bird18mediaSound);


//Mediabird19
 let Bird19mediaImage = {
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/PVQOLRXXWL/XC331693-Rufous%20Hummingbird%207.4.16%20Antelope%20Dr%206.47%20.26_0375.mp3"
};


let setSound19 = db.collection('Birds').doc('Bird19')
  .collection('media').doc('Soundclip').set(Bird19mediaSound);



  //Mediabird20
 let Bird20mediaImage = {
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/YTUXOCTUEM/XC408276-Colaptes_auratus_%5Bcafer%20Group%5D-FL%20song%20Mono%20Lake%20County%20Park%2010.35am%2020May15%20LS116590a.mp3"
};


let setSound20 = db.collection('Birds').doc('Bird20').collection('media').doc('Soundclip').set(Bird20mediaSound);



//Mediabird21
 let Bird21mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/White-crowned-Sparrow.jpg/1200px-White-crowned-Sparrow.jpg"
};


let setImage21 = db.collection('Birds').doc('Bird21')
  .collection('media').doc('Image').set(Bird21mediaImage);


//bird21
 let Bird21mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=7fCBTMMcyuI"
};


let setVideo21 = db.collection('Birds').doc('Bird21')
  .collection('media').doc('Video').set(Bird21mediaVideo);

//bird21
 let Bird21mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/WOPIRNCCSX/XC289834-Bon%20Desir-2015-05-16-06h15%20LS115292.mp3"
};


let setSound21 = db.collection('Birds').doc('Bird21')
  .collection('media').doc('Soundclip').set(Bird21mediaSound);



//Mediabird22
 let Bird22mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Landsvale.jpg/1200px-Landsvale.jpg"
};


let setImage22 = db.collection('Birds').doc('Bird22')
  .collection('media').doc('Image').set(Bird22mediaImage);


//bird22
 let Bird22mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=bjXdd9zQqiQ"
};


let setVideo22 = db.collection('Birds').doc('Bird22')
  .collection('media').doc('Video').set(Bird22mediaVideo);

//bird22
 let Bird22mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/WOPIRNCCSX/XC289834-Bon%20Desir-2015-05-16-06h15%20LS115292.mp3"
};


let setSound22 = db.collection('Birds').doc('Bird22')
  .collection('media').doc('Soundclip').set(Bird22mediaSound);



//Mediabird23
 let Bird23mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://fthmb.tqn.com/tvPe1GjuUCasntTK2maHH_0FBZo=/1280x853/filters:fill(auto,1)/gouldian-finch-188062467-resized-58a6ea6e5f9b58a3c9190af4.jpg"
};


let setImage23 = db.collection('Birds').doc('Bird23')
  .collection('media').doc('Image').set(Bird23mediaImage);


//bird23
 let Bird23mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=HBAXA7P1RbU"
};


let setVideo23 = db.collection('Birds').doc('Bird23')
  .collection('media').doc('Video').set(Bird23mediaVideo);

//bird23
 let Bird23mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/YTUXOCTUEM/XC408276-Colaptes_auratus_%5Bcafer%20Group%5D-FL%20song%20Mono%20Lake%20County%20Park%2010.35am%2020May15%20LS116590a.mp3"
};


let setSound23 = db.collection('Birds').doc('Bird23')
  .collection('media').doc('Soundclip').set(Bird23mediaSound);


//Mediabird24
 let Bird24mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Dendroica-fusca-001.jpg/1200px-Dendroica-fusca-001.jpg"
};


let setImage24 = db.collection('Birds').doc('Bird24')
  .collection('media').doc('Image').set(Bird24mediaImage);


//bird24
 let Bird24mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=bLQl32Y7rl4"
};


let setVideo24 = db.collection('Birds').doc('Bird24')
  .collection('media').doc('Video').set(Bird24mediaVideo);

//bird24
 let Bird24mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/WZGPEVZHBJ/XC123405-corey_husic_black-throated_green.mp3"
};


let setSound24 = db.collection('Birds').doc('Bird24')
  .collection('media').doc('Soundclip').set(Bird24mediaSound);






  //Mediabird25
 let Bird25mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Cyanocitta-cristata-004.jpg/1200px-Cyanocitta-cristata-004.jpg"
};


let setImage25 = db.collection('Birds').doc('Bird25')
  .collection('media').doc('Image').set(Bird25mediaImage);


//bird25
 let Bird25mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=MlxC8ky4EO4"
};


let setVideo25 = db.collection('Birds').doc('Bird25')
  .collection('media').doc('Video').set(Bird25mediaVideo);

//bird25
 let Bird25mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/AHYWLCEJLP/XC234669-150407_015.MP3"
};


let setSound25 = db.collection('Birds').doc('Bird25')
  .collection('media').doc('Soundclip').set(Bird25mediaSound);


//Mediabird26
 let Bird26mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.audubon.org/sites/default/files/House_Wren_w27-4-011_l.jpg"
};


let setImage26 = db.collection('Birds').doc('Bird26')
  .collection('media').doc('Image').set(Bird26mediaImage);


//bird26
 let Bird26mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=bSe3R1b8zak"
};


let setVideo26 = db.collection('Birds').doc('Bird26')
  .collection('media').doc('Video').set(Bird26mediaVideo);

//bird26
 let Bird26mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/YTUXOCTUEM/XC352452-Troglodytes_aedon_%28cahooni%29-FL%20song%20km210%20Durango%20Highway%203.17pm%2012Apr15%20LS115434a.mp3"
};


let setSound26 = db.collection('Birds').doc('Bird26')
  .collection('media').doc('Soundclip').set(Bird26mediaSound);


//Mediabird27
 let Bird27mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://upload.wikimedia.org/wikipedia/commons/b/bf/Common_tern_with_fish.jpg"
};


let setImage27 = db.collection('Birds').doc('Bird27')
  .collection('media').doc('Image').set(Bird27mediaImage);


//bird27
 let Bird27mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=GtOcDCtayJc"
};


let setVideo27 = db.collection('Birds').doc('Bird27')
  .collection('media').doc('Video').set(Bird27mediaVideo);

//bird27
 let Bird27mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/ZNCDXTUOFL/XC181436-Sterna_hirundo_Polska_Jarek_Matusiak_20140608_30.mp3/"
};


let setSound27 = db.collection('Birds').doc('Bird27')
  .collection('media').doc('Soundclip').set(Bird27mediaSound);


//Mediabird28
 let Bird28mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Charadrius-melodus-004_edit.jpg/1200px-Charadrius-melodus-004_edit.jpg"
};


let setImage28 = db.collection('Birds').doc('Bird28')
  .collection('media').doc('Image').set(Bird28mediaImage);


//bird28
 let Bird28mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=jk5y57EE3aI"
};


let setVideo28 = db.collection('Birds').doc('Bird28')
  .collection('media').doc('Video').set(Bird8mediaVideo);

//bird1
 let Bird28mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/ZNCDXTUOFL/XC284824-Sieweczka_obro%C5%BCna_Charadrius_hiaticula_Poland_Jarek_Matusiak_20150920_63.mp3"
};


let setSound28 = db.collection('Birds').doc('Bird28')
  .collection('media').doc('Soundclip').set(Bird28mediaSound);


//Mediabird29
 let Bird29mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b0/Gavia_immer_-Minocqua%2C_Wisconsin%2C_USA_-swimming-8.jpg/1200px-Gavia_immer_-Minocqua%2C_Wisconsin%2C_USA_-swimming-8.jpg"
};


let setImage29 = db.collection('Birds').doc('Bird29')
  .collection('media').doc('Image').set(Bird29mediaImage);


//bird29
 let Bird29mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=4ENNzjy8QjU"
};


let setVideo29 = db.collection('Birds').doc('Bird29')
  .collection('media').doc('Video').set(Bird29mediaVideo);

//bird29
 let Bird29mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/ZNCDXTUOFL/XC284824-Sieweczka_obro%C5%BCna_Charadrius_hiaticula_Poland_Jarek_Matusiak_20150920_63.mp3"
};


let setSound29 = db.collection('Birds').doc('Bird29')
  .collection('media').doc('Soundclip').set(Bird29mediaSound);


//Mediabird30
 let Bird30mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "http://2.bp.blogspot.com/-VzRzd4a0EMo/UMcozCNlxfI/AAAAAAAAZWk/GciLj1TiCXM/s1600/Cooper's+Hawk,+Tucson,+12-08-12-0937.jpg"
};


let setImage30 = db.collection('Birds').doc('Bird30')
  .collection('media').doc('Image').set(Bird30mediaImage);


//bird30
 let Bird30mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=isKb_9MaZKo"
};


let setVideo30 = db.collection('Birds').doc('Bird30')
  .collection('media').doc('Video').set(Bird30mediaVideo);

//bird30
 let Bird30mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/PJVICFDZGZ/XC308400-160323_0569%20Draper%20Twin%20Lake_COHA2.mp3"
};


let setSound30 = db.collection('Birds').doc('Bird30')
  .collection('media').doc('Soundclip').set(Bird30mediaSound);


//Mediabird31
 let Bird31mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Black-headed_Grosbeak.jpg/220px-Black-headed_Grosbeak.jpg"
};


let setImage31 = db.collection('Birds').doc('Bird31')
  .collection('media').doc('Image').set(Bird31mediaImage);


//bird31
 let Bird31mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=ATGSA-nOJhE"
};


let setVideo31 = db.collection('Birds').doc('Bird31')
  .collection('media').doc('Video').set(Bird31mediaVideo);

//bird31
 let Bird31mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/AHYWLCEJLP/XC234669-150407_015.MP3"
};


let setSound31 = db.collection('Birds').doc('Bird31')
  .collection('media').doc('Soundclip').set(Bird31mediaSound);


//Mediabird32
 let Bird32mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0e/Phalacrocorax_brasilianus_%28Costa_Rica%29.jpg/1200px-Phalacrocorax_brasilianus_%28Costa_Rica%29.jpg"
};


let setImage32 = db.collection('Birds').doc('Bird32')
  .collection('media').doc('Image').set(Bird32mediaImage);


//bird32
 let Bird32mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=o2wLlw7TzZg"
};


let setVideo32 = db.collection('Birds').doc('Bird32')
  .collection('media').doc('Video').set(Bird32mediaVideo);

//bird32
 let Bird32mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/species/Phalacrocorax-brasil"
};


let setSound32 = db.collection('Birds').doc('Bird32')
  .collection('media').doc('Soundclip').set(Bird32mediaSound);



//Mediabird33
 let Bird33mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://i.ytimg.com/vi/9d8DOhz2UkA/maxresdefault.jpg"
};


let setImage33 = db.collection('Birds').doc('Bird33')
  .collection('media').doc('Image').set(Bird33mediaImage);


//bird33
 let Bird33mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=fto-HHHTqIg"
};


let setVideo33 = db.collection('Birds').doc('Bird33')
  .collection('media').doc('Video').set(Bird33mediaVideo);

//bird33
 let Bird33mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/ZNCDXTUOFL/XC130063-Sturnus_vulgaris_Jablonna_Polska_Jarek_Matusiak_20130417_52.mp3"
};


let setSound33 = db.collection('Birds').doc('Bird33')
  .collection('media').doc('Soundclip').set(Bird33mediaSound);


//Mediabird34
 let Bird34mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://i.ytimg.com/vi/cL-DNEHI21s/maxresdefault.jpg"
};


let setImage34 = db.collection('Birds').doc('Bird34')
  .collection('media').doc('Image').set(Bird34mediaImage);


//bird34
 let Bird34mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=pG8ls-8LBTs"
};


let setVideo34 = db.collection('Birds').doc('Bird34')
  .collection('media').doc('Video').set(Bird34mediaVideo);

//bird34
 let Bird34mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/northern-flicker/"
};


let setSound34 = db.collection('Birds').doc('Bird34')
  .collection('media').doc('Soundclip').set(Bird34mediaSound);


//Mediabird35
 let Bird35mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/images/house-finch.jpg"
};


let setImage35 = db.collection('Birds').doc('Bird35')
  .collection('media').doc('Image').set(Bird35mediaImage);


//bird35
 let Bird35mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=G4zhGOX9L9g"
};


let setVideo35 = db.collection('Birds').doc('Bird35')
  .collection('media').doc('Video').set(Bird35mediaVideo);

//bird35
 let Bird35mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/ILUHRFXDNU/XC428722-House%20Finch%20song%20male%20nabor%20july%2024%20746.mp3"
};


let setSound35 = db.collection('Birds').doc('Bird35')
  .collection('media').doc('Soundclip').set(Bird35mediaSound);


//Mediabird36
 let Bird36mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/images/bushtit.jpg"
};


let setImage36 = db.collection('Birds').doc('Bird36')
  .collection('media').doc('Image').set(Bird36mediaImage);


//bird36
 let Bird36mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=ogl653elM5E"
};


let setVideo36 = db.collection('Birds').doc('Bird36')
  .collection('media').doc('Video').set(Bird36mediaVideo);

//bird36
 let Bird36mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/KGOCOOKTTU/XC307863-2%20Bushtit%20Laguna%20Lake%2002-08-16.mp3"
};


let setSound36 = db.collection('Birds').doc('Bird36')
  .collection('media').doc('Soundclip').set(Bird36mediaSound);


//Mediabird37
 let Bird37mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c4/Anna%27s_hummingbird.jpg/1200px-Anna%27s_hummingbird.jpg"
};


let setImage37 = db.collection('Birds').doc('Bird37')
  .collection('media').doc('Image').set(Bird37mediaImage);


//bird37
 let Bird37mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=uuQfNZp87u4"
};


let setVideo37 = db.collection('Birds').doc('Bird37')
  .collection('media').doc('Video').set(Bird37mediaVideo);

//bird37
 let Bird37mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/WOEAFQRMUD/XC196691-Calypte%20anna1408234_T1153.mp3"
};


let setSound37 = db.collection('Birds').doc('Bird37')
  .collection('media').doc('Soundclip').set(Bird37mediaSound);


//Mediabird38
 let Bird38mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://climate.audubon.org/sites/default/files/bird_photo_gallery_images/Rufous_Hummingbird_NicoleBeaulac:FlickrCC.jpg"
};


let setImage38 = db.collection('Birds').doc('Bird38')
  .collection('media').doc('Image').set(Bird38mediaImage);


//bird38
 let Bird38mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=J-1rNBkjqxw"
};


let setVideo38 = db.collection('Birds').doc('Bird38')
  .collection('media').doc('Video').set(Bird38mediaVideo);

//bird38
 let Bird38mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/YQNGFTBRRT/XC302569-SPTO_MtOrd_19Aug2013_Harter_02.mp3"
};


let setSound38 = db.collection('Birds').doc('Bird38')
  .collection('media').doc('Soundclip').set(Bird38mediaSound);


//Mediabird39
 let Bird39mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://i.ytimg.com/vi/WFyzgFkQSRg/hqdefault.jpg"
};


let setImage39 = db.collection('Birds').doc('Bird39')
  .collection('media').doc('Image').set(Bird19mediaImage);


//bird1
 let Bird39mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=l7vnp411GPo"
};


let setVideo39 = db.collection('Birds').doc('Bird39')
  .collection('media').doc('Video').set(Bird39mediaVideo);

//bird39
 let Bird39mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/KADPGEQPZI/XC288251-CeWW%202015-11-01-0758.mp3"
};


let setSound39 = db.collection('Birds').doc('Bird39')
  .collection('media').doc('Soundclip').set(Bird39mediaSound);



  //Mediabird40
 let Bird40mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://i.ytimg.com/vi/wr5AQff-SXQ/maxresdefault.jpg"
};


let setImage40 = db.collection('Birds').doc('Bird40')
  .collection('media').doc('Image').set(Bird40mediaImage);


//bird40
 let Bird40mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=9RArGl2vkG"
};


let setVideo40 = db.collection('Birds').doc('Bird40')
  .collection('media').doc('Video').set(Bird40mediaVideo);

//bird40
 let Bird40mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/NPYDVIEFTA/XC192236-GAARMWAL_20140615_175045%20Bald%20Eagle.mp3"
};


let setSound40 = db.collection('Birds').doc('Bird40').collection('media').doc('Soundclip').set(Bird40mediaSound);



//Mediabird41
 let Bird41mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.borealbirds.org/sites/default/files/styles/lightbox_max_wh/public/bird_images/mew-gull.jpg?itok=uFO9VNia"
};


let setImage41 = db.collection('Birds').doc('Bird41')
  .collection('media').doc('Image').set(Bird41mediaImage);


//bird41
 let Bird41mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=8eWtsoAIOnU"
};


let setVideo41 = db.collection('Birds').doc('Bird41')
  .collection('media').doc('Video').set(Bird41mediaVideo);

//bird41
 let Bird41mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/ZNCDXTUOFL/XC128367-Larus_canus_Poland_Jarek_Matusiak_20130403wav.mp3"
};


let setSound41 = db.collection('Birds').doc('Bird41')
  .collection('media').doc('Soundclip').set(Bird41mediaSound);


//Mediabird42
 let Bird42mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/images/pine-siskin.jpg"
};


let setImage42 = db.collection('Birds').doc('Bird42')
  .collection('media').doc('Image').set(Bird42mediaImage);


//bird42
 let Bird42mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=QDoF-HvsWqY"
};


let setVideo42 = db.collection('Birds').doc('Bird42')
  .collection('media').doc('Video').set(Bird42mediaVideo);

//bird42
 let Bird42mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/FIDXCHEYJO/XC324998-Pine_Siskin_2068.mp3"
};


let setSound42 = db.collection('Birds').doc('Bird42')
  .collection('media').doc('Soundclip').set(Bird42mediaSound);



//Mediabird43
 let Bird43mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://tx.audubon.org/sites/default/files/styles/bean_wysiwyg_full_width/public/great-blue-heron_rebecca-field.jpg?itok=oSQB_ZLO"
};


let setImage43 = db.collection('Birds').doc('Bird43')
  .collection('media').doc('Image').set(Bird43mediaImage);


//bird43
 let Bird43mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=8meXF8k6r90"
};


let setVideo43 = db.collection('Birds').doc('Bird43')
  .collection('media').doc('Video').set(Bird43mediaVideo);

//bird43
 let Bird43mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/UKNISVRBBF/XC187999-Heron%2C%20Great%20Blue%202014.07.19.mp3"
};


let setSound43 = db.collection('Birds').doc('Bird43')
  .collection('media').doc('Soundclip').set(Bird43mediaSound);


//Mediabird44
 let Bird44mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://i.ytimg.com/vi/LbNcdRrrJHs/maxresdefault.jpg"
};


let setImage44 = db.collection('Birds').doc('Bird44')
  .collection('media').doc('Image').set(Bird44mediaImage);


//bird44
 let Bird44mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=-FSKBnECkAA"
};


let setVideo44 = db.collection('Birds').doc('Bird44')
  .collection('media').doc('Video').set(Bird44mediaVideo);

//bird44
 let Bird44mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/UKNISVRBBF/XC187999-Heron%2C%20Great%20Blue%202014.07.19.mp3"
};


let setSound44 = db.collection('Birds').doc('Bird44')
  .collection('media').doc('Soundclip').set(Bird44mediaSound);


//Mediabird45
 let Bird45mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.larkwire.com/static/content/images/ipad/LBNA1/NorthernShrike.jpg"
};


let setImage45 = db.collection('Birds').doc('Bird45')
  .collection('media').doc('Image').set(Bird45mediaImage);


//bird45
 let Bird45mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=Gmn0eZhr95U"
};


let setVideo45 = db.collection('Birds').doc('Bird45')
  .collection('media').doc('Video').set(Bird45mediaVideo);

//bird45
 let Bird45mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/KADPGEQPZI/XC288251-CeWW%202015-11-01-0758.mp3"
};


let setSound45 = db.collection('Birds').doc('Bird45')
  .collection('media').doc('Soundclip').set(Bird45mediaSound);


//Mediabird46
 let Bird46mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/images/pine-grosbeak.jpg"
};


let setImage46 = db.collection('Birds').doc('Bird46')
  .collection('media').doc('Image').set(Bird46mediaImage);


//bird46
 let Bird46mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=AE4rd224thE"
};


let setVideo46 = db.collection('Birds').doc('Bird46')
  .collection('media').doc('Video').set(Bird46mediaVideo);

//bird46
 let Bird46mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/BPSDQEOJWG/XC125066-Tallbit-call-2013-02-23%2009.09-LS113043.mp3"
};


let setSound46 = db.collection('Birds').doc('Bird46')
  .collection('media').doc('Soundclip').set(Bird46mediaSound);


//Mediabird47
 let Bird47mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.larkwire.com/static/content/images/ipad/LBNA1/LeastBittern.jpg"
};


let setImage47 = db.collection('Birds').doc('Bird47')
  .collection('media').doc('Image').set(Bird47mediaImage);


//bird47
 let Bird47mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=GYPYXboGZ6M"
};


let setVideo47 = db.collection('Birds').doc('Bird47')
  .collection('media').doc('Video').set(Bird47mediaVideo);

//bird47
 let Bird47mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/OHHTDSDNBT/XC341252-Exilis%20001.mp3"
};


let setSound47 = db.collection('Birds').doc('Bird47')
  .collection('media').doc('Soundclip').set(Bird47mediaSound);


//Mediabird48
 let Bird48mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.bird-sounds.net/images/least-sandpiper.jpg"
};


let setImage48 = db.collection('Birds').doc('Bird48')
  .collection('media').doc('Image').set(Bird48mediaImage);


//bird48
 let Bird48mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=zh0FdpmpcMI"
};


let setVideo48 = db.collection('Birds').doc('Bird48')
  .collection('media').doc('Video').set(Bird48mediaVideo);

//bird48
 let Bird48mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/AHEASHOMCO/XC337948-Callla%20Cape%20May%20USA%20100916%20calls.mp3"
};


let setSound48 = db.collection('Birds').doc('Bird48')
  .collection('media').doc('Soundclip').set(Bird48mediaSound);


//Mediabird49
 let Bird49mediaImage = {
            "title": "Image",
            "is_image": true,
            "is_video": false,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.british-birdsongs.uk/images/mute-swan.jpg"
};


let setImage49 = db.collection('Birds').doc('Bird49')
  .collection('media').doc('Image').set(Bird49mediaImage);


//bird49
 let Bird49mediaVideo = {
            "title": "Video",
            "is_image": false,
            "is_video": true,
            "is_sound_clip": false,
            "is_deleted": false,
            "url": "https://www.youtube.com/watch?v=tUoTA_QNE6A"
};


let setVideo49 = db.collection('Birds').doc('Bird49')
  .collection('media').doc('Video').set(Bird49mediaVideo);

//bird49
 let Bird49mediaSound = {
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/ILUHRFXDNU/XC428722-House%20Finch%20song%20male%20nabor%20july%2024%20746.mp3"
};


let setSound49 = db.collection('Birds').doc('Bird49')
  .collection('media').doc('Soundclip').set(Bird49mediaSound);



  //Mediabird50
 let Bird50mediaImage = {
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
            "title": "SoundClip",
            "is_image": false,
            "is_video": false,
            "is_sound_clip": true,
            "is_deleted": false,
            "url": "https://www.xeno-canto.org/sounds/uploaded/ZNCDXTUOFL/XC190478-Pandion_haliaetus_Poland_Jarek_Matusiak_20140720_37.mp3"
};


let setSound50 = db.collection('Birds').doc('Bird50').collection('media').doc('Soundclip').set(Bird50mediaSound);











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
    heading:"sample",
     description:"sample",
    date_received:"sample",
    is_deleted:false
    
};


let setuser1Notifications = db.collection('Users').doc('user1').collection('Notifications').doc('notifications').set(user1Notifications);


//////User birdMedia Collection///////





let user1mediaimage = {
media_id:501,
title: "sample",
is_image: true,
is_video: false,
is_sound_clip: false,
is_deleted: false,
 url: "sample URL"
    
};


let setuser1foldermediaimage = db.collection('Users').doc('user1').collection('Media').add(user1mediaimage);


let user1mediavideo = {
media_id:502,
title: "sample",
is_image: false,
is_video: true,
is_sound_clip: false,
is_deleted: false,
 url: "sample URL"
    
};


let setuser1foldermediavideo = db.collection('Users').doc('user1').collection('Media').add(user1mediavideo);

let user1mediaSound = {
media_id:503,
title: "sample",
is_image: false,
is_video: true,
is_sound_clip: true,
is_deleted: false,
 url: "sample URL"
    
};


let setuser1foldermediasound = db.collection('Users').doc('user1').collection('Media').add(user1mediaSound);

 

//////Favourite Birds Collection///////


let user_favorite_birds = {
 user_id: 201,
 bird_id: "Bird01",
 bird_name: "Northern cardinal",
 Region:"Montreal",
 default_image: "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Northern_Cardinal_%28Cardinalis_cardinalis%29_male.jpg/1200px-Northern_Cardinal_%28Cardinalis_cardinalis%29_male.jpg",
 is_favorite: true
    
};


let setuser_favorite_birds = db.collection('favorite_birds').doc('favorite_birds_id').set(user_favorite_birds);



//////Location  Collection///////


//location 01
let location01 = {
 Location_name: "Afton State Park",
 Region: " Minnesota",
 latitude: "44° 51.336″N",
 longitude: "092° 46.484″W",
 proximity: "0"
    
};

let setlocation01 = db.collection('Location').doc('location_01').set(location01);

//location 02
let location02 = {
 Location_name: "Mono Cliffs Provincial Park l",
 Region: "Central Ontario",
 latitude: "44° 2′ 48.12″N",
 longitude: "80° 4′ 36.84″W",
 proximity: "0"

    
};

let setlocation02 = db.collection('Location').doc('location_02').set(location02);


//location 03
let location03 = {
 Location_name: "Babine Lake Marine Provincial Park ",
 Region: " British Columbia",
 latitude: "54° 30′ 55.08″N",
 longitude: "125° 42′ 0″W",
 proximity: "0"

    
};

let setlocation03 = db.collection('Location').doc('location_03').set(location03);


//location 04
let location04 = {
 Location_name: "Fundy Provincial Park ",
 Region: " Nova Scotia",
 latitude: "44° 44′ 38.02″N",
 longitude: " 65° 40′ 45.69″W",
 proximity: "0"

    
};

let setlocation04 = db.collection('Location').doc('location_04').set(location04);


//location 05
let location05 = {
 Location_name: "Asessippi Provincial Park ",
 Region: " Manitoba",
 latitude: "50° 57′ 59″N",
 longitude: "101° 22′ 47″W",
 proximity: "0"

    
};

let setlocation05 = db.collection('Location').doc('location_05').set(location05);

//location 06
let location06 = {
 Location_name: "Heritage Park Historical Village",
 Region: "51° 15′ 6 ″N",
 longitude: "114° 23′ 13″W",
 proximity: "0"

    
};

let setlocation06 = db.collection('Location').doc('location_06').set(location06);

     
//location 06
let location07 = {
 Location_name: "Asi Keyi Territorial park",
 Region: " Yukon",
 latitude: "64° 4′ 58.3 ″N",
 longitude: "138° 30′ 39.24 ″W",
 proximity: "0"

    
};

let setlocation07 = db.collection('Location').doc('location_07').set(location07);

//location 08
let location08 = {
 Location_name: "Finger-Tatuk Provincial Park",
 Region: " British Columbia",
 latitude: "53° 29′ 38.4 ″N ",
 longitude: "124° 12′ 57.6 ″W ",
 proximity: "0"
    
};

let setlocation08 = db.collection('Location').doc('location_08').set(location08);


//location 09
let location09 = {
 Location_name: "Tombston Territorial park",
 Region: " Yukon",
 latitude: "63° 37' 59.99 ″N",
 longitude: "-135° 45' 59.99 ″W",
 proximity: "0"
    
};

let setlocation09 = db.collection('Location').doc('location_09').set(location09);

//location 09
let location10 = {
 Location_name: "Tweedsmuir South Provincial Park",
 Region: " New Brunswick",
 latitude: "52.5954° ″N",
 longitude: "126.0711° ″W",
 proximity: "0"

};



    
let setlocation10 = db.collection('Location').doc('location_10').set(location10);


//location 11
let location11 = {
 Location_name: "Kusawa Territorial park",
 Region: " Yukon",
 latitude: "52° 28' 5.7864 ″N",
 longitude: "131° 33' 29.6244 ″W",
 proximity: "0"
    
};

let setlocation11 = db.collection('Location').doc('location_11').set(location11);

//location 12
let location12 = {
 Location_name: "Prince Edward Island National Park",
 Region: "  Prince Edward Island",
 latitude: "46° 25′ 0 ″N",
 longitude: "63° 4′ 30 ″W",
 proximity: "0"
    
};

let setlocation12 = db.collection('Location').doc('location_12').set(location12);

//location 13
let location13 = {
 Location_name: "Mount Pope Provincial Park",
 Region: " British Columbia",
 latitude: "54° 29′ 38 ″N",
 longitude: "124° 20′ 30 ″W",
 proximity: "0"
    
};

let setlocation13 = db.collection('Location').doc('location_13').set(location13);
//location 14
let location14 = {
 Location_name: "Little Qualicum Falls Provincial Park",
 Region: "western Alberta",
 latitude: "49.293072 ″N",
 longitude: "-124.574509 ″W",
 proximity: "0"
    
};

let setlocation14 = db.collection('Location').doc('location_14').set(location14);


//location 15
let location15 = {
 Location_name: "Jasper National Park",
 Region: "western Alberta",
 latitude: "52.799999 ″N",
 longitude: "-117.900002 ″W",
 proximity: "0"
    
};

let setlocation15 = db.collection('Location').doc('location_15').set(location15);

//location 16
let location16 = {
 Location_name: "Cap-Saint Jacques Nature Park",
 Region: " Senneville",
 latitude: "45.432051″N",
 longitude: "-73.953186″W",
 proximity: "0"
    
};

let setlocation16 = db.collection('Location').doc('location_16').set(location16);

//location 17
let location17 = {
 Location_name: "La Salle",
 Region: " Montreal",
 latitude: "45.429419″N",
 longitude: "-73.593158″W",
 proximity: "0"
    
};


let setlocation17 = db.collection('Location').doc('location_17').set(location17);

//location 18
let location18 = {
 Location_name: "Tommy Thompson Park",
 Region: " Toronto",
 latitude: "43°37'36.9″N",
 longitude: "79°19'51.3″W",
 proximity: "0"
    
};

let setlocation18 = db.collection('Location').doc('location_18').set(location18);

//location 19
let location19 = {
 Location_name: "Bowring park",
 Region: " New FoundLand",
 latitude: "47.523079″N",
 longitude: "-52.756310″W",
 proximity: "0"
    
};

let setlocation19 = db.collection('Location').doc('location_19').set(location19);

//location 20
let location20 = {
 Location_name: "La Pointe-Aux-Lièvres",
 Region: "Saint Roch",
 latitude: "46.81382″N",
 longitude: "-71.203836″W",
 proximity: "0"
    
};


let setlocation20 = db.collection('Location').doc('location_20').set(location20);


//location 21
let location21 = {
 Location_name: "Field Bird Sanctuary",
 Region: " Sudbury",
 latitude: "46°25'35.4″N",
 longitude: "81°05'47.4″W",
 proximity: "0"
    
};

let setlocation21 = db.collection('Location').doc('location_21').set(location21);

//location 22
let location22 = {
 Location_name: "MacTaggart Sanctuary Trail Loop",
 Region: "Edmonton",
 latitude: "53°27'18.7″N",
 longitude: "113°32'51.9″W",
 proximity: "0"
    
};

let setlocation22 = db.collection('Location').doc('location_22').set(location22);


//location 23
let location23 = {
 Location_name: "Le Sud-Ouest",
 Region: "Montreal",
 latitude: "45.444537″N",
 longitude: " -73.602452″W",
 proximity: "0"
    
};

let setlocation23 = db.collection('Location').doc('location_23').set(location23);

 
//location 24
let location24 = {
 Location_name: "Miramichi",
 Region: " NorthTumberland",
 latitude: "44.623323″N",
 longitude: "-63.568579″W",
 proximity: "0"
    
};

let setlocation24 = db.collection('Location').doc('location_24').set(location24);


//location 25
let location25 = {
 Location_name: "Rideau Heights",
 Region: " Kingston",
 latitude: "44.623323″N",
 longitude: "-63.568579″W",
 proximity: "0"
    
};

let setlocation25 = db.collection('Location').doc('location_25').set(location25);

//location 26
let location26 = {
 Location_name: "Matsqui Prairie",
 Region:"Abbotsford",
 latitude: "49°04'29.0″N",
 longitude: "122°16'46.0″W",
 proximity: "0"
    
};

let setlocation26 = db.collection('Location').doc('location_26').set(location26);

     
//location 27
let location27 = {
 Location_name: "Victoria",
 Region: " Nova Scotia",
 latitude: "46.738337″N",
 longitude: "-60.650983 ″W",
 proximity: "0"
    
};

let setlocation27 = db.collection('Location').doc('location_27').set(location27);

//location 28
let location28 = {
 Location_name: "Campbell River",
 Region: " British Columbia",
 latitude: " 50.041402″N ",
 longitude: " -125.319957″W",
 proximity: "0"
  
};

let setlocation28 = db.collection('Location').doc('location_28').set(location28);


//location 29
let location29 = {
 Location_name: "Kenora District",
 Region: " Kenora",
 latitude: "54.761705″N",
 longitude: "-83.038826″W",
 proximity: "0"
   
};

let setlocation29 = db.collection('Location').doc('location_29').set(location29);

//location 30
let location30 = {
 Location_name: "Senneville",
 Region: " Montreal",
 latitude: "45.4857″N",
 longitude: "73.5957″W",
 proximity: "0"
   
};

let setlocation30 = db.collection('Location').doc('location_30').set(location30);



//location 31
let location31 = {
 Location_name: "westmount",
 Region: "Montreal",
 latitude: "45.491961″N",
 longitude: " -73.607241″W",
 proximity: "0"
  

};

let setlocation31 = db.collection('Location').doc('location_31').set(location31);


//location 32
let location32 = {
 Location_name: "Stratford",
 Region: "perth",
 latitude: "43.374711″W",
 longitude: "-80.966995 ″W",
 proximity: "0"
     
};

let setlocation32 = db.collection('Location').doc('location_32').set(location32);

 
//location 33
let location33 = {
 Location_name: "EastPoint Park",
 Region: " Scarborough",
 latitude: "43.759610″N",
 longitude: "-79.159253″W",
 proximity: "0"
    
};

let setlocation33 = db.collection('Location').doc('location_33').set(location33);


//location 34
let location34 = {
 Location_name: "Morgsn Aboretum",
 Region: " Montreal",
 latitude: " 45.432051″N",
 longitude: "-73.953186″W",
 proximity: "0"
   
};

let setlocation34 = db.collection('Location').doc('location_34').set(location34);

//location 35
let location35 = {
 Location_name: "Chapais",
 Region:"Eeyou Istchee Baie-James",
 latitude: "49.784191″N",
 longitude: "-74.862144″W",
 proximity: "0"
      
};

let setlocation35 = db.collection('Location').doc('location_35').set(location35);

     
//location 36
let location36 = {
 Location_name: "Brandon",
 Region: "Manitoba",
 latitude: " 49.816171″N",
 longitude: "-99.866592″W",
 proximity: "0"
   
};

let setlocation36 = db.collection('Location').doc('location_36').set(location36);

//location 37
let location37 = {
 Location_name: "Arthur park",
 Region: "Thunder Bay",
 latitude: "48.380922″N ",
 longitude: "89.227822″W ",
 proximity: "0"
     
};

let setlocation37 = db.collection('Location').doc('location_37').set(location37);


//location 38
let location38 = {
 Location_name: " Hawk Cliff Rd",
 Region: " Union",
 latitude: "42°39'47.4″N",
 longitude: "81°10'12.5″W",
 proximity: "0"
   
};

let setlocation38 = db.collection('Location').doc('location_38').set(location38);

//location 01
let location_39 = {
 Location_name: "Jasper National Park,Gasper",
 Region: " Alberta",
 latitude: "52.869522″N",
 longitude: "-118.075982″W",
 proximity: "0"
 };

let setlocation_39 = db.collection('Location').doc('location_39').set(location_39);


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



//bird_location1
let bird_location1 = {
 bird_id: "Bird1",
 location_id: "location_01",
 bird_name: "Northern cardinal ",
 location_name: "Afton State Park",
 bird_image: "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a6/Northern_Cardinal_%28Cardinalis_cardinalis%29_male.jpg/1200px-Northern_Cardinal_%28Cardinalis_cardinalis%29_male.jpg",
 is_valid: true
    
};


let setbirdlocation1 = db.collection('Bird_Location').doc('bird_location_id1').set(bird_location1);


//bird_location2
let bird_location2 = {
 bird_id: "Bird2",
 location_id: "location_02",
 bird_name: "Pileated woodpecker ",
 location_name: "Mono Cliffs Provincial Park",
 bird_image: "https://upload.wikimedia.org/wikipedia/commons/thumb/1/12/PileatedWoodpeckerFeedingonTree%2C_crop.jpg/1200px-PileatedWoodpeckerFeedingonTree%2C_crop.jpg",
 is_valid: true
    
};


let setbirdlocation2 = db.collection('Bird_Location').doc('bird_location_id2').set(bird_location2);


//bird_location3
let bird_location3 = {
 bird_id: "Bird3",
 location_id: "location_03",
 bird_name: "Neotropic Cormorant",
 location_name: "Babine Lake Marine Provincial Park",
 bird_image: "https://www.allaboutbirds.org/guide/assets/og/75258971-1200px.jpg",
 is_valid: true
    
};


let setbirdlocation3 = db.collection('Bird_Location').doc('bird_location_id3').set(bird_location3);


//bird_location4
let bird_location4 = {
 bird_id: "Bird4",
 location_id: "location_04",
 bird_name: "Black-capped Chickadee",
 location_name: "Fundy Provincial Park ",
 bird_image: "https://naturallycuriouswithmaryholland.files.wordpress.com/2013/11/11-20-13-black-capped-chickadee-img_01071.jpg",
 is_valid: true
    
};


let setbirdlocation4 = db.collection('Bird_Location').doc('bird_location_id4').set(bird_location4);


//bird_location5
let bird_location5 = {
 bird_id: "Bird5",
 location_id: "location_05",
 bird_name: "Burrowing owl",
 location_name: "Asessippi Provincial Park",
 bird_image: "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5a/Brazilian_burrowing_owl_%28Athene_cunicularia_grallaria%29.jpg/1200px-Brazilian_burrowing_owl_%28Athene_cunicularia_grallaria%29.jpg",
 is_valid: true
    
};


let setbirdlocation5 = db.collection('Bird_Location').doc('bird_location_id5').set(bird_location5);

//bird_location6
let bird_location6 = {
 bird_id: "Bird6",
 location_id: "location_06",
 bird_name: "Cedar Waxwings",
 location_name: "Heritage Park Historical Village",
 bird_image: "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Cedar_Waxwing_August_14_2012_Newfoundland_PA.jpg/1200px-Cedar_Waxwing_August_14_2012_Newfoundland_PA.jpg",
 is_valid: true
    
};


let setbirdlocation6 = db.collection('Bird_Location').doc('bird_location_id6').set(bird_location6);


//bird_location7
let bird_location7 = {
 bird_id: "Bird7",
 location_id: "location_07",
 bird_name: "Common redpoll",
 location_name: "Asi Keyi Territorial park",
 bird_image: "https://philipschwarzphotography.files.wordpress.com/2013/02/common-redpoll-female-13-1-_1566.jpg",
 is_valid: true
    
};


let setbirdlocation7 = db.collection('Bird_Location').doc('bird_location_id7').set(bird_location7);


//bird_location8
let bird_location8 = {
 bird_id: "Bird8",
 location_id: "location_08",
 bird_name: "Dark-eyed juncos",
 location_name: "Finger-Tatuk Provincial Park",
 bird_image: "https://upload.wikimedia.org/wikipedia/commons/b/b3/Dark-eyed_Junco-27527-3.jpg",
 is_valid: true
    
};


let setbirdlocation8 = db.collection('Bird_Location').doc('bird_location_id8').set(bird_location8);


//bird_location9
let bird_location9 = {
 bird_id: "Bird9",
 location_id: "location_09",
 bird_name: "Gray Catbirds",
 location_name: "Tombston Territorial park",
 bird_image: "http://2.bp.blogspot.com/-Jct9xDnsdG4/UG_Mtw4l4_I/AAAAAAAAARU/CbSJMwwdPZo/s1600/Gray+Catbird.JPG",
 is_valid: true
    
};


let setbirdlocation9 = db.collection('Bird_Location').doc('bird_location_id9').set(bird_location9);


//bird_location10
let bird_location10 = {
 bird_id: "Bird10",
 location_id: "location_04",
 bird_name: "Great Horned Owl",
 location_name: "Fundy Provincial Park ",
 bird_image: "https://i.ytimg.com/vi/Cu3bgBVyrNw/maxresdefault.jpg",
 is_valid: true
    
};


let setbirdlocation10 = db.collection('Bird_Location').doc('bird_location_id10').set(bird_location10);

//bird_location11
let bird_location11 = {
 bird_id: "Bird11",
 location_id: "location_11",
 bird_name: "American crow",
 location_name: "Kusawa Territorial park",
 bird_image: "https://www.nps.gov/chat/learn/nature/images/american-crow.jpg",
 is_valid: true
    
};


let setbirdlocation11 = db.collection('Bird_Location').doc('bird_location_id11').set(bird_location11);


//bird_location12
let bird_location12 = {
 bird_id: "Bird12",
 location_id: "location_12",
 bird_name: "American robin",
 location_name: "Prince Edward Island National Park",
 bird_image: "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b8/Turdus-migratorius-002.jpg/1200px-Turdus-migratorius-002.jpg",
 is_valid: true
    
};


let setbirdlocation12 = db.collection('Bird_Location').doc('bird_location_id12').set(bird_location12);


//bird_location3
let bird_location13 = {
 bird_id: "Bird13",
 location_id: "location_04",
 bird_name: "Purple Martin",
 location_name: "Fundy Provincial Park ",
 bird_image: "http://www.audubon.org/sites/default/files/styles/hero_cover_bird_page/public/Purple%20Martin%20s60-5-005_V.jpg?itok=dlGL_tZc",
 is_valid: true
    
};


let setbirdlocation13 = db.collection('Bird_Location').doc('bird_location_id13').set(bird_location13);


//bird_location14
let bird_location14 = {
 bird_id: "Bird4",
 location_id: "location_10",
 bird_name: "Red-breasted Nuthatch",
 location_name: "Tweedsmuir South Provincial Park",
 bird_image: "http://www.wilddelight.com/wp-content/uploads/2013/01/RedBreastedNuthatch01.jpg",
 is_valid: true
    
};


let setbirdlocation14 = db.collection('Bird_Location').doc('bird_location_id14').set(bird_location14);


//bird_location15
let bird_location15 = {
 bird_id: "Bird15",
 location_id: "location_11",
 bird_name: "Red-winged blackbird ",
 location_name: "Kusawa Territorial park",
 bird_image: "https://mybluesunshine.files.wordpress.com/2015/05/6a00e5513924e68833017615996437970c.jpg",
 is_valid: true
    
};


let setbirdlocation15 = db.collection('Bird_Location').doc('bird_location_id15').set(bird_location15);

//bird_location16
let bird_location16 = {
 bird_id: "Bird1",
 location_id: "location_13",
 bird_name: "Rose-breasted grosbeak",
 location_name: "Mount Pope Provincial Park",
 bird_image: "https://www.animalspot.net/wp-content/uploads/2016/01/Rose-Breasted-Grosbeak-Female.jpg",
 is_valid: true
    
};


let setbirdlocation16 = db.collection('Bird_Location').doc('bird_location_id16').set(bird_location16);


//bird_location17
let bird_location17 = {
 bird_id: "Bird17",
 location_id: "location_04",
 bird_name: "Ruby-throated hummingbird",
 location_name: "Fundy Provincial Park",
 bird_image: "http://3.bp.blogspot.com/-4K3XRMSNmmA/T57Mq6ESL0I/AAAAAAAADhw/gWaZm_38c7M/s1600/rubythroatedhummingbird2.jpg",
 is_valid: true
    
};


let setbirdlocation17 = db.collection('Bird_Location').doc('bird_location_id17').set(bird_location17);


//bird_location18
let bird_location18 = {
 bird_id: "Bird18",
 location_id: "location_06",
 bird_name: "Rufous hummingbirds",
 location_name: "Heritage Park Historical Village",
 bird_image: "https://climate.audubon.org/sites/default/files/bird_photo_gallery_images/Rufous_Hummingbird_NicoleBeaulac:FlickrCC.jpg",
 is_valid: true
    
};


let setbirdlocation18 = db.collection('Bird_Location').doc('bird_location_id18').set(bird_location18);


//bird_location19
let bird_location19 = {
 bird_id: "Bird19",
 location_id: "location_06",
 bird_name: "Spotted Owl",
 location_name: "Heritage Park Historical Village",
 bird_image: "https://www.americanforests.org/wp-content/uploads/2012/07/northern-spotted-owl-2.jpg",
 is_valid: true
    
};


let setbirdlocation19 = db.collection('Bird_Location').doc('bird_location_id19').set(bird_location19);


//bird_location20
let bird_location20 = {
 bird_id: "Bird20",
 location_id: "location_13",
 bird_name: "Northern Flicker",
 location_name: "Mount Pope Provincial Park",
 bird_image: "https://mmeara.files.wordpress.com/2012/09/pic-flamb-male-aur1.jpg",
 is_valid: true
    
};


let setbirdlocation20 = db.collection('Bird_Location').doc('bird_location_id20').set(bird_location20);


 
//bird_location21
let bird_location21 = {
 bird_id: "Bird21",
 location_id: "location_14",
 bird_name: "White-crowned sparrow",
 location_name: "Little Qualicum Falls Provincial Park",
 bird_image: "https://upload.wikimedia.org/wikipedia/commons/thumb/9/92/White-crowned-Sparrow.jpg/1200px-White-crowned-Sparrow.jpg",
 is_valid: true
    
};


let setbirdlocation21 = db.collection('Bird_Location').doc('bird_location_id21').set(bird_location21);


//bird_location22
let bird_location22 = {
 bird_id: "Bird22",
 location_id: "location_15",
 bird_name: "Swallows",
 location_name: "Jasper National Park",
 bird_image: "https://upload.wikimedia.org/wikipedia/commons/thumb/2/24/Landsvale.jpg/1200px-Landsvale.jpg",
 is_valid: true
    
};


let setbirdlocation22 = db.collection('Bird_Location').doc('bird_location_id22').set(bird_location22);


//bird_location23
let bird_location23 = {
 bird_id: "Bird23",
 location_id: "location_07",
 bird_name: "Finches",
 location_name: "Asi Keyi Territorial park",
 bird_image: "https://fthmb.tqn.com/tvPe1GjuUCasntTK2maHH_0FBZo=/1280x853/filters:fill(auto,1)/gouldian-finch-188062467-resized-58a6ea6e5f9b58a3c9190af4.jpg",
 is_valid: true
    
};


let setbirdlocation23 = db.collection('Bird_Location').doc('bird_location_id23').set(bird_location23);


//bird_location24
let bird_location24 = {
 bird_id: "Bird24",
 location_id: "location_07",
 bird_name: "Warblers",
 location_name: "Asi Keyi Territorial park",
 bird_image: "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Dendroica-fusca-001.jpg/1200px-Dendroica-fusca-001.jpg",
 is_valid: true
    
};


let setbirdlocation24 = db.collection('Bird_Location').doc('bird_location_id24').set(bird_location24);


//bird_location25
let bird_location25 = {
 bird_id: "Bird25",
 location_id: "location_10",
 bird_name: "Blue Jay",
 location_name: "Tweedsmuir South Provincial Park",
 bird_image: "https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Cyanocitta-cristata-004.jpg/1200px-Cyanocitta-cristata-004.jpg",
 is_valid: true
    
};


let setbirdlocation25 = db.collection('Bird_Location').doc('bird_location_id25').set(bird_location25);

//bird_location26
let bird_location26 = {
 bird_id: "Bird6",
 location_id: "location_16",
 bird_name: "Wrens",
 location_name: "Cap-Saint Jacques Nature Park",
 bird_image: "https://www.audubon.org/sites/default/files/House_Wren_w27-4-011_l.jpg",
 is_valid: true
    
};


let setbirdlocation26 = db.collection('Bird_Location').doc('bird_location_id26').set(bird_location26);


//bird_location27
let bird_location27 = {
 bird_id: "Bird27",
 location_id: "location_17",
 bird_name: "Common Terns",
 location_name: "La Salle",
 bird_image: "https://upload.wikimedia.org/wikipedia/commons/b/bf/Common_tern_with_fish.jpg",
 is_valid: true
    
};


let setbirdlocation27 = db.collection('Bird_Location').doc('bird_location_id27').set(bird_location27);


//bird_location28
let bird_location28 = {
 bird_id: "Bird28",
 location_id: "location_18",
 bird_name: "Piping Plovers",
 location_name: "Tommy Thompson Park",
 bird_image: "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/Charadrius-melodus-004_edit.jpg/1200px-Charadrius-melodus-004_edit.jpg",
 is_valid: true
    
};


let setbirdlocation28 = db.collection('Bird_Location').doc('bird_location_id28').set(bird_location28);


//bird_location29
let bird_location29 = {
 bird_id: "Bird29",
 location_id: "location_19",
 bird_name: "Common loon",
 location_name: "Bowring park",
 bird_image: "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b0/Gavia_immer_-Minocqua%2C_Wisconsin%2C_USA_-swimming-8.jpg/1200px-Gavia_immer_-Minocqua%2C_Wisconsin%2C_USA_-swimming-8.jpg",
 is_valid: true
    
};


let setbirdlocation29 = db.collection('Bird_Location').doc('bird_location_id29').set(bird_location29);


//bird_location30
let bird_location30 = {
 bird_id: "Bird30",
 location_id: "location_20",
 bird_name: "Cooper's Hawk",
 location_name: "La Pointe-Aux-Lièvres",
 bird_image: "http://2.bp.blogspot.com/-VzRzd4a0EMo/UMcozCNlxfI/AAAAAAAAZWk/GciLj1TiCXM/s1600/Cooper's+Hawk,+Tucson,+12-08-12-0937.jpg",
 is_valid: true
    
};


let setbirdlocation30 = db.collection('Bird_Location').doc('bird_location_id30').set(bird_location30);

//bird_location31
let bird_location31 = {
 bird_id: "Bird31",
 location_id: "location_21",
 bird_name: "Grosbeak",
 location_name: "Field Bird Sanctuary",
 bird_image: "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Black-headed_Grosbeak.jpg/220px-Black-headed_Grosbeak.jpg",
 is_valid: true
    
};


let setbirdlocation31 = db.collection('Bird_Location').doc('bird_location_id31').set(bird_location31);


//bird_location32
let bird_location32 = {
 bird_id: "Bird32",
 location_id: "location_39",
 bird_name: "Neotropic Cormorant",
 location_name: "Jasper National Park,Gasper",
 bird_image: "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0e/Phalacrocorax_brasilianus_%28Costa_Rica%29.jpg/1200px-Phalacrocorax_brasilianus_%28Costa_Rica%29.jpg",
 is_valid: true
    
};



let setbirdlocation32 = db.collection('Bird_Location').doc('bird_location_id32').set(bird_location32);


//bird_location33
let bird_location33 = {
 bird_id: "Bird33",
 location_id: "location_23",
 bird_name: "European Starling",
 location_name: "Le Sud-Ouest",
 bird_image: "https://i.ytimg.com/vi/9d8DOhz2UkA/maxresdefault.jpg",
 is_valid: true
    
};


let setbirdlocation33 = db.collection('Bird_Location').doc('bird_location_id33').set(bird_location33);


//bird_location34
let bird_location34 = {
 bird_id: "Bird34",
 location_id: "location_24",
 bird_name: "Northern Flickers",
 location_name: "Miramichi",
 bird_image: "https://i.ytimg.com/vi/cL-DNEHI21s/maxresdefault.jpg",
 is_valid: true
    
};


let setbirdlocation34 = db.collection('Bird_Location').doc('bird_location_id34').set(bird_location34);


//bird_location35
let bird_location35 = {
 bird_id: "Bird35",
 location_id: "location_25",
 bird_name: "House Finch",
 location_name: "Rideau Heights",
 bird_image: "https://www.bird-sounds.net/images/house-finch.jpg",
 is_valid: true
    
};


let setbirdlocation35 = db.collection('Bird_Location').doc('bird_location_id35').set(bird_location35);

//bird_location36
let bird_location36 = {
 bird_id: "Bird36",
 location_id: "location_26",
 bird_name: "Bushtit",
 location_name: "Matsqui Prairie",
 bird_image: "https://www.bird-sounds.net/images/bushtit.jpg",
 is_valid: true
    
};


let setbirdlocation36 = db.collection('Bird_Location').doc('bird_location_id36').set(bird_location6);


//bird_location37
let bird_location37 = {
 bird_id: "Bird37",
 location_id: "location_27",
 bird_name: "Anna’s Hummingbird",
 location_name: "Victoria",
 bird_image: "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c4/Anna%27s_hummingbird.jpg/1200px-Anna%27s_hummingbird.jpg",
 is_valid: true
    
};


let setbirdlocation37 = db.collection('Bird_Location').doc('bird_location_id37').set(bird_location37);


//bird_location38
let bird_location38 = {
 bird_id: "Bird38",
 location_id: "location_28",
 bird_name: "Spotted Towhee",
 location_name: "Campbell River",
 bird_image: "http://nathistoc.bio.uci.edu/birds/passeriformes/Pipilo%20maculatus/Spotted%20Towhee4_San%20Joaquin%20WS_E%20Chen.jpg",
 is_valid: true
    
};


let setbirdlocation38 = db.collection('Bird_Location').doc('bird_location_id38').set(bird_location38);


//bird_location39
let bird_location39 = {
 bird_id: "Bird39",
 location_id: "location_29",
 bird_name: "Cedar Waxwing",
 location_name: "Kenora District",
 bird_image: "https://i.ytimg.com/vi/WFyzgFkQSRg/hqdefault.jpg",
 is_valid: true
    
};


let setbirdlocation39 = db.collection('Bird_Location').doc('bird_location_id39').set(bird_location39);


//bird_location40
let bird_location40 = {
 bird_id: "Bird40",
 location_id: "location_30",
 bird_name: "Bald Eagle",
 location_name: "Senneville",
 bird_image: "https://i.ytimg.com/vi/wr5AQff-SXQ/maxresdefault.jpg",
 is_valid: true
    
};


let setbirdlocation40 = db.collection('Bird_Location').doc('bird_location_id40').set(bird_location40);


//bird_location41
let bird_location41 = {
 bird_id: "Bird41",
 location_id: "location_31",
 bird_name: "Mew Gull",
 location_name: "westmount",
 bird_image: "https://www.borealbirds.org/sites/default/files/styles/lightbox_max_wh/public/bird_images/mew-gull.jpg?itok=uFO9VNia",
 is_valid: true
    
};

let setbirdlocation41 = db.collection('Bird_Location').doc('bird_location_id41').set(bird_location41);


//bird_location42
let bird_location42 = {
 bird_id: "Bird42",
 location_id: "location_32",
 bird_name: "Pine Siskin",
 location_name: "Stratford",
 bird_image: "https://www.bird-sounds.net/images/pine-siskin.jpg",
 is_valid: true
    
};


let setbirdlocation42 = db.collection('Bird_Location').doc('bird_location_id42').set(bird_location42);


//bird_location43
let bird_location43 = {
 bird_id: "Bird43",
 location_id: "location_28",
 bird_name: "Great Blue Heron",
 location_name: "Campbell River",
 bird_image: "https://www.google.com/search?q=Great+Blue+Heron&sxsrf=ALeKk00CjgBbVnlalF1F17ckrH15ILkC1w:1592108824935&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjavtDHu4DqAhUWXc0KHbWxAqUQ_AUoAXoECCEQAw&biw=650&bih=688#imgrc=6pM7ap8ksKv_dM",
 is_valid: true
    
};


let setbirdlocation43 = db.collection('Bird_Location').doc('bird_location_id43').set(bird_location43);


//bird_location44
let bird_location44 = {
 bird_id: "Bird44",
 location_id: "location_33",
 bird_name: "Bufflehead",
 location_name: "EastPoint Park",
 bird_image: "https://i.ytimg.com/vi/LbNcdRrrJHs/maxresdefault.jpg",
 is_valid: true
    
};


let setbirdlocation44 = db.collection('Bird_Location').doc('bird_location_id44').set(bird_location44);


//bird_location45
let bird_location45 = {
 bird_id: "Bird45",
 location_id: "location_34",
 bird_name: "Northern Shrike ",
 location_name: "Morgsn Aboretum",
 bird_image: "https://www.larkwire.com/static/content/images/ipad/LBNA1/NorthernShrike.jpg",
 is_valid: true
    
};


let setbirdlocation45 = db.collection('Bird_Location').doc('bird_location_id45').set(bird_location45);

//bird_location46
let bird_location46 = {
 bird_id: "Bird46",
 location_id: "location_35",
 bird_name: "Pine Grosbeak",
 location_name: "Chapais",
 bird_image: "https://www.bird-sounds.net/images/pine-grosbeak.jpg",
 is_valid: true
    
};


let setbirdlocation46 = db.collection('Bird_Location').doc('bird_location_id46').set(bird_location46);


//bird_location47
let bird_location47 = {
 bird_id: "Bird47",
 location_id: "location_36",
 bird_name: "Least Bittern",
 location_name: "Brandon",
 bird_image: "https://www.larkwire.com/static/content/images/ipad/LBNA1/LeastBittern.jpg",
 is_valid: true
    
};


let setbirdlocation47 = db.collection('Bird_Location').doc('bird_location_id47').set(bird_location47);


//bird_location48
let bird_location48 = {
 bird_id: "Bird48",
 location_id: "location_37",
 bird_name: "Least Sandpiper",
 location_name: "Arthur park",
 bird_image: "https://www.bird-sounds.net/images/least-sandpiper.jpg",
 is_valid: true
    
};


let setbirdlocation48 = db.collection('Bird_Location').doc('bird_location_id48').set(bird_location48);


//bird_location49
let bird_location49 = {
 bird_id: "Bird49",
 location_id: "location_25",
 bird_name: "Mute Swan",
 location_name: "Rideau Heights",
 bird_image: "https://www.british-birdsongs.uk/images/mute-swan.jpg",
 is_valid: true
    
};

let setbirdlocation49 = db.collection('Bird_Location').doc('bird_location_id49').set(bird_location49);


//bird_location50
let bird_location50 = {
 bird_id: "Bird50",
 location_id: "location_38",
 bird_name: "Osprey",
 location_name: "Hawk Cliff Rd",
 bird_image: "https://i.ytimg.com/vi/f6UFcbJFwk0/hqdefault.jpg",
 is_valid: true
    
};


let setbirdlocation50 = db.collection('Bird_Location').doc('bird_location_id50').set(bird_location50);


  })








/*return db.collection('Birds').doc('Details')
   .set(BirdData).then(() =>
   console.log('new Bird has been added to the database')
   );
*/
});