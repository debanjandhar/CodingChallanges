package hackerrank;
import java.io.IOException;

/**
 * @author debanjandhar
 * 
 *         Question :
 *         https://www.hackerrank.com/challenges/bigger-is-greater/problem
 *         
 *         NOT WORKING SOLUTION
 *
 */
public class BiggerisGreater {

	// Complete the biggerIsGreater function below.
	static String biggerIsGreater(String w) {
		StringBuilder returnString = new StringBuilder();
		String noAnswer = "no answer";
		int[] charInts = new int[w.length()];

		for (int i = 0; i < w.length(); i++) {
			charInts[i] = w.charAt(i);
		}

		System.out.println(nextPermutation(charInts));
		
		int pivot = w.length() - 1;
		int comparisonIndex = pivot - 1;
		int minDistance = Integer.MAX_VALUE, minPivot = pivot, minComparisonIndex = comparisonIndex;
		boolean haveSwapped = false;

		while (minDistance != 1) {
			
			if (charInts[pivot] > charInts[comparisonIndex]) {
				int distance = pivot - comparisonIndex;
				if (distance < minDistance && (!(minDistance<Integer.MAX_VALUE) || comparisonIndex != minComparisonIndex
						|| charInts[pivot] < charInts[minPivot])) {
					haveSwapped = true;
					minDistance = distance;
					minPivot = pivot;
					minComparisonIndex = comparisonIndex;
				}
			}

			comparisonIndex--;

			// Compared all the elements in front of pivot. Change the pivot.
			if (comparisonIndex < 0 || haveSwapped) {
				haveSwapped = false;
				pivot--;
				comparisonIndex = pivot - 1;
			}

			if (pivot == 0) {
				if (minDistance<Integer.MAX_VALUE) {
					break;
				}else {
					return noAnswer;
				}
			} else if (minDistance < Integer.MAX_VALUE && pivot <= minComparisonIndex) {
				break;
			}
		}

		int temp = charInts[minPivot];
		charInts[minPivot] = charInts[minComparisonIndex];
		charInts[minComparisonIndex] = temp;

		sortStrngs(charInts, minComparisonIndex + 1);
		for (int i = 0; i < w.length(); i++) {
			returnString.append((char) charInts[i]);
		}

		return returnString.toString();
	}
	
	static boolean nextPermutation(int[] array) {
	    // Find longest non-increasing suffix
	    int i = array.length - 1;
	    while (i > 0 && array[i - 1] >= array[i])
	        i--;
	    // Now i is the head index of the suffix
	    
	    // Are we at the last permutation already?
	    if (i <= 0)
	        return false;
	    
	    // Let array[i - 1] be the pivot
	    // Find rightmost element that exceeds the pivot
	    int j = array.length - 1;
	    while (array[j] <= array[i - 1])
	        j--;
	    // Now the value array[j] will become the new pivot
	    // Assertion: j >= i
	    
	    // Swap the pivot with j
	    int temp = array[i - 1];
	    array[i - 1] = array[j];
	    array[j] = temp;
	    
	    // Reverse the suffix
	    j = array.length - 1;
	    while (i < j) {
	        temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	        i++;
	        j--;
	    }
	    
	    // Successfully computed the next permutation
	    return true;
	}

	private static void sortStrngs(int[] inputArr, int startIndex) {
		for (int i = startIndex; i < inputArr.length; i++) {
			for (int j = i + 1; j < inputArr.length; j++) {
				if (inputArr[i] > inputArr[j]) {
					int temp = inputArr[i];
					inputArr[i] = inputArr[j];
					inputArr[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

//		System.out.println(biggerIsGreater("ab"));
//		System.out.println(biggerIsGreater("bb"));
//		System.out.println(biggerIsGreater("hefg"));
//		System.out.println(biggerIsGreater("dhck"));
		System.out.println(biggerIsGreater("dkhc"));
//		System.out.println(biggerIsGreater("rebjvsszebhehuojrkkhszxltyqfdvayusylgmgkdivzlpmmtvbsavxvydldmsym"));
//		System.out.println(biggerIsGreater("abdc"));
//		System.out.println(biggerIsGreater("jprfovzkdlmdcesdcpdchcwoedjchcovklhrhlzfeeptoewcqpxg"));
//		System.out.println(biggerIsGreater("ifcjnisxizrnbcvhqamdzmnnvpqwnqrkaeikckeqfpmpcfxlcfepajhlmkfuypohzlca"));
//		System.out.println(biggerIsGreater("iyp"));
//		String inputStr = "zedawdvyyfumwpupuinbdbfndyehircmylbaowuptgmw,zyyxwwtrrnmlggfeb,ocsmerkgidvddsazqxjbqlrrxcotrnfvtnlutlfcafdlwiismslaytqdbvlmcpapfbmzxmftrkkqvkpflxpezzapllerxyzlcf,biehzcmjckznhwrfgglverxsezxuqpj,rebjvsszebhehuojrkkhszxltyqfdvayusylgmgkdivzlpmmtvbsavxvydldmsym,unpzhmbgrrs,jprfovzkdlmdcesdcpdchcwoedjchcovklhrhlzfeeptoewcqpxg,ywsfmynmiylcjgrfrrmtyeeykffzkuphpajndwxjteyjba,dkuashjzsdq,gwakhcpkolybihkmxyecrdhsvycjrljajlmlqgpcnmvvkjlkvdowzdfikh,nebsajjbbuifimjpdcqfygeitief,qetpicxagjkydehfnvfxrtigljlheulcsfidjjozbsnomygqbcmpffwswptbgkzrbgqwnczrcfynjmhebfbgseuhckbtuynvbo,xuqfobndhsnsztifmqpnencxkllnpmbfqihtgdgxjhsvitlgtodhcydfb,xqdwkjpkmrvkfnztozzlqtuxzxyxwowf,yewluyxiwiprnajrtkeilolkmqidazhiar,zzyyxxxxxwwwwwvvvvutttttsssssrrrrqqqppponnnnmmmmllkkjjjjiiggffffffeedddddbbbbbba,hlvpzsfwnzsazeyaxaczkkrstiilkldupsqmzjnnsyoao,zxvuutttrrrpoookiihhgggfdca,zzyxxxxwwwvvuuuutsrrrrrqppppoooonnnnnnmmmlllllkkkjjjihgeeedddddcbaaa,jnmvvaybncmoazujefictednlyjuhonfchvpqfelbwc,mqyvczrlabtesyeiteblqklfhkchcryggkewpsfxsumvsjerssbltntydzwrjvf,pzxgfnsapnchz,erwidqokyjfpctpfxuojyloafghxgifdvhcmzjogoqoikjhjngbhfetvtraaojkfqvyujbhdizrkvqmfpzbidysbkhvuebtr,xywhpljspfeiznzisvukwcaizeqwgavokqwxkrotsgchxdupsumgcynfrpcjsylnrzgxdfkctcrkcnvkxgtmiabghcorgnxak,ywghcadvjurpjgwgfyis,pqommldkafmnwzidydgjghxcbnwyjdxpvmkztdfmcxlkargafjzeye,victjarfqkynoavgmhtpzbpcrblzyrzyxjrjlwjxmxdslsubyqdcqcdoenufzxqlty,tlxqigvjmfuxku,cryrpwccrnspwnruubekqkjmrkvwoohzvkctejwvkqfarqgbjzbggyxmecpshgccclykjd,jhrmxpdfhjjubrycaurjjwvkasfyxjkf,acs,aeukmuqpwyrrdkoptlawlpxknjhdnzlzrgfzliojgopwvwafzxyiwevsxwmwlxycppmjlpxafdnpioezfdkyafryx,zvtronmlkkihc,zzzyyyyxxxxwwwwwvvuuuuuuuttttsssrrrqqqqpppooooonnnnmmmllkjjjjiiiiihhhgggfeeeddcccbbbaa,zzyyxxxwwwwvvvvuuuutrrqqqqppoooonnmmllkkkjjjiihhhggfffeeebbbbbbbbb,dinodxkbrsipxfznzevrpbgtrrfbbfdaksagnus,sykgwoyzypukuditxxltlunmbznk,zzyyyxxxxxwwwwvuuuuttttssrrrrpppponnnmmmmlllllkkkkjjjiiiiiiggfffffeeeddccbbba,spceooivwyzjfbejljaizdvrdkeipvetcxvzmkmwuuqdndwuhxdmrmitzsgjcipanobhxphdactouymkyo,iekgvftshvqkkbbxrhhgypngmekykkshhmphfjhcflfknwcxqrearjzsfpryvtahsjawpdufwuqroyckgnph,jwzgvwcljudksghspryqrbjaylokhccptiligqndzswxqtafrunwflkgfrhgkadp,jvbodrobnjihwpnvlyxlixtmska,mllfsvfzllbloukxtonftmlmioqdsdxstdzmyamnut,mexyunrrcglszqwzatguscgvukuyenogubuwwiavudhvzbpgwjwxazvdzfgumudbgtaubmxyqrzbeagjrthedvvmrngxlilczov,shsdzboibebzlfluhgkypbppkxvtgfm,wvokkqbmgbnwrbdlzwqfanzxtwiqasxgqnwvrlhwnhlhbkxx,nennccrmeeflwmpqfvgtiapirdbjjqozvtbrmixnonbhddgxtxp,wffbownokzqkxgobgxclscwbsgeaxbozfcftxiugiahpufilwuhdmugsotdzatvdvuhqum,zzzzyyyxxxxwvvvuuuuuttssssssrrrqqqqqppppppponmmmmmlllkkjjihhggfeeeeeddddccbaaaaa,zzzzzzzyyxxwwwvvuuuuuuttttsssssrrrrqqqqpooonnnmmmmmmmmllllkkjjiihhhgggfffffeeeeedddddccccbbbbaa";
//		String inputStr = "zyyyyxxxxwwwwwvvuuttttssrrqqpponnmkjjjihhggggfffeddddcccccbbbba,qspxfpochvrcznsnlnhbqivxoeyuzxuicrzalvgvlyiaahtyvsheiugu,vxkednatrbquuohianxvddurldvgixajksbanctmgbixaysryritnzgkstmzj,lgeuvf,dqwrmse,ywwwsqonmkjjjec,txhibpmgdirkxudpkstbowpseyphnisizqdokoguytw,hrdajqwelhktmhuvvoifamrvjeorhjsyvfdqdlzjwlcyjyrpneebqozuepvhcwfxqhdvpocxmunlyvzplz,zxkjhfa,zywvvvvvrrrqnmmmmljjjihggffeeca,argjsmasazkmoumtergvyxabrkxsaawcgupxakzl,smbqkwxekxykpraflhoeiiodhhqfqobgsschrbqebxxarwoekpruqezanmvjvxeqbectjkkrgnvsdiupv,lg,cnkowxwrzzlgchmlc,zzyyyyxxxxxxvvvuuutttttttssssrrrqqqqppppooonnnnmmmlllkkkjjjjjiiihggggfeeeeccccccbbbbbaaaaa,xormxhloqwvqhokclhrgojnbqwbekwhpscodduptogwmbyamqgykbastrsnzmwtmjnfnufsdenioemdcpptz,onapfkqihlffxgbazbbyojidwuauptlshcxircaigbcaiyeucyvfhvzrjgbwhlbnbammfv,ifcjnisxizrnbcvhqamdzmnnvpqwnqrkaeikckeqfpmpcfxlcfepajhlmkfuypohzlca,orrswtbuzvhwczrteudswqeurrszkaxshzhkuiokrylmfrulucpbhpyunrupovplucdbmwnsobwhaolduruwaokipsbjpndgw,tngzrqwtnynlqraucsusxocvmbsowkgpedzsabrqifcvnzjczbewjdwlxq,zzzzzzzyyxxwwvvvvvuuuuuutttttsssrrrrqqqqqppppooonnnnnnmmmmllllkjjjiiiihhhhgggggggfffeeeeddcccbbbaa,ynwjdeyufytvgltwzdjnzkafnzwlndzrixrjckc,zzyyyywwwvvvvuuuutttssssrrqqppoonnnnnnmmmllkkkjihhhgggfffffedddccbbba,zzyyyyyxxwwwvvuttttsssrqqqpppnnnnmlllkjihhhhhgggggfffffeeedddccbbaa,byvakxxmcvchxbhjbvagzizpionjtkwfqyohceyizlxurtcjuf,qzealllnel,gloqevnhjakswofqijvscfjmqmmjaexrfbthrw,cexnnzkvgzwpul,tdngrnhtaaarrmsirxmuekxginkvtsqhjx,gxfbcmzkpcywzudenlrpenxudmjliaqkmbqbixmtlgmbvevxqjzvjpuptiprdsixcvrc,iyp,csidwjlcdvlonqwyemsgnafxnhdldkkqlc,zyyxwuusrrqqpnlkkihhggfedd,zbnhddyreqgbtljfomybooayzonqc,hdatwgzimw,ckxvkrzvz,kpyosibsuarrdszbigsjyzschcvgvjgdm,smdwubtiauxbxducxwvvmvgonttkjuqcfijmnsgzlqkhahxqwweikzajdthkmiuehnktdduyucewvbdlsyjgcdzsauyhizrr,uywkqzfktgiuftdffdynxuscrkbvkebxxjpiphxgbxnwnpy,zntwynbyancmzkzkeosyttmnmrcrni,jfparzxakugmylshaeolgganbfewidnydcjqcheggboslytohvccilurdacgehgvnsaerfeolibaovblefocyvbxlhtdubqjjhgt,gmnxmbdpmyhmrneqizayztprhikykwvwmbnicvlqdemwmdxcftssoaakneetykphegqcgjbmmcklinm,vymnloaaxlmvtykujflnklcxeulzfzyryxmtrvmglysjjk,qdnkfqvedqeqnmvzbravyismqksgjzxsklrlxfvuoufwomsanbntlsw,vmjfqifbkuvlrasxswadnrlgbv,zzzzzzzyyyxxxvvuutttttsssrrrrrrqqqppppoooonnnmmlllkkkkjiiihggfffeeddccccaaaaa,zzzzyxxxwwwwwvuuuuuttttssssrrrrqqqqqqqppppnnnmmlllllllkkjjjiiiihhhhggffffeeedddddcccbbbbaaaaaaaa,wztgcfqzzokkcrrgzwhcrmz,gxilexhvbcjlkoxcigxoxxgzdvvyqqytrqyvlkhrkqmijdaub,fzeeqhkqgermnyeclldhvlrrxpamfipdhlbcizvaiaeqfqvk";
//		String[] inputStrArr = inputStr.split(",");
//
//		for (int i = 0; i < inputStrArr.length; i++) {
//			System.out.println(biggerIsGreater(inputStrArr[i]));
//		}
	}
}
