package inputData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import common.PepupUtilities;

public class InputValuesReadWrite {

	private static InputValues iv = InputValues.getInstance();
	private static String[] tags = {"Walking","SuiminJikan","Suimin","Alcohol","Shokuseikatsu","GekkanEvent"};

	public static InputValues readInputValuesFile() throws ParserConfigurationException, SAXException, IOException {

		//0:今月 1:先月
		for(int i = 0;i<=1;i++) {

			int[] walking = null;
			int[] suiminJikan = null;
			boolean[] suimin = null;
			boolean[] alcohol = null;
			boolean[] shokuseikatsu1 = null;
			boolean[] shokuseikatsu2 = null;
			boolean[] shokuseikatsu3 = null;
			boolean[] shokuseikatsu4 = null;
			boolean[] shokuseikatsu5 = null;
			boolean[] gekkanEvent = null;

			/*xmlから読み込む*/

			String xmlPath = null;
			if(i==0) {
				xmlPath = "./xml/201912.xml";
			}else {
				xmlPath = "./xml/201911.xml";
			}

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(Paths.get(xmlPath).toFile());
			Element root = document.getDocumentElement();

			//大項目のループ
			//TODO うまくいかない
			for(int j=0;j<tags.length;j++) {
				NodeList list = root.getElementsByTagName(tags[j]);
				//NodeList list = root.getElementsByTagName("qst");

				//小項目のループ
				for(int k=0;k<list.getLength();k++) {
					Element element = (Element) list.item(k);
					String string = element.getTextContent();

					switch (j) {
					case 0:
						walking = PepupUtilities.StringToIntegers(string);
						break;
					case 1:
						suiminJikan = PepupUtilities.StringToIntegers(string);
						break;
					case 2:
						suimin = PepupUtilities.StringToBooleans(string);
						break;
					case 3:
						alcohol = PepupUtilities.StringToBooleans(string);
						break;
					case 4:
						switch (k) {
						case 0:
							shokuseikatsu1 = PepupUtilities.StringToBooleans(string);
							break;
						case 1:
							shokuseikatsu2 = PepupUtilities.StringToBooleans(string);
							break;
						case 2:
							shokuseikatsu3 = PepupUtilities.StringToBooleans(string);
							break;
						case 3:
							shokuseikatsu4 = PepupUtilities.StringToBooleans(string);
							break;
						case 4:
							shokuseikatsu5 = PepupUtilities.StringToBooleans(string);
							break;
						}
						break;
					case 5:
						gekkanEvent = PepupUtilities.StringToBooleans(string);
						break;
					}

				}
			}

			/*クラスにセット*/

			InputValuesForMonth ivfm = new InputValuesForMonth();
			updateInputValuesForMonth(ivfm,walking,suiminJikan,suimin,alcohol,shokuseikatsu1,
					shokuseikatsu2,shokuseikatsu3,shokuseikatsu4,shokuseikatsu5,gekkanEvent);

			if(i==0) {
				iv.setThisMonth(ivfm);
			}else {
				iv.setLastMonth(ivfm);
			}

		}

		return iv;

	}

	public static void writeInputValuesFile(InputValues iv) {

		for(int i = 0;i<=1;i++) {

			InputValuesForMonth ivfm = null;
			if(i==0) {
				ivfm = iv.getThisMonth();
			}else {
				ivfm = iv.getLastMonth();
			}

			/*xmlに書き込む*/
			String xmlPath = null;
			if(i==0) {
				xmlPath = "./xml/test201912.xml";
			}else {
				xmlPath = "./xml/test201911.xml";
			}

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			try {

				DocumentBuilder builder = factory.newDocumentBuilder();
				Document doc = builder.newDocument();

				Element inputValues = doc.createElement("InputValues");
				doc.appendChild(inputValues);
				for(int j=0;j<tags.length;j++) {
					Element content = doc.createElement(tags[j]);
					inputValues.appendChild(content);
					Element qst1 = doc.createElement("qst");
					Element qst2 = doc.createElement("qst");
					Element qst3 = doc.createElement("qst");
					Element qst4 = doc.createElement("qst");
					Element qst5 = doc.createElement("qst");
					qst1.setAttribute("number", "1");
					qst2.setAttribute("number", "2");
					qst3.setAttribute("number", "3");
					qst4.setAttribute("number", "4");
					qst5.setAttribute("number", "5");
					content.appendChild(qst1);
					if(tags[j].equals("Shokuseikatsu")) {
						content.appendChild(qst2);
						content.appendChild(qst3);
						content.appendChild(qst4);
						content.appendChild(qst5);
					}

					switch(j) {
					case 0:
						qst1.appendChild(doc.createTextNode(PepupUtilities.IntegersToString(ivfm.getWalking())));
					case 1:
						qst1.appendChild(doc.createTextNode(PepupUtilities.IntegersToString(ivfm.getSuiminJikan())));
					case 2:
						qst1.appendChild(doc.createTextNode(PepupUtilities.BooleansToString(ivfm.getSuimin())));
					case 3:
						qst1.appendChild(doc.createTextNode(PepupUtilities.BooleansToString(ivfm.getAlcohol())));
					case 4:
						qst1.appendChild(doc.createTextNode(PepupUtilities.BooleansToString(ivfm.getShokuseikatsu1())));
						//qst2.appendChild(doc.createTextNode(PepupUtilities.BooleansToString(ivfm.getShokuseikatsu2())));
						//qst3.appendChild(doc.createTextNode(PepupUtilities.BooleansToString(ivfm.getShokuseikatsu3())));
						//qst4.appendChild(doc.createTextNode(PepupUtilities.BooleansToString(ivfm.getShokuseikatsu4())));
						//qst5.appendChild(doc.createTextNode(PepupUtilities.BooleansToString(ivfm.getShokuseikatsu5())));
					case 5:
						qst1.appendChild(doc.createTextNode(PepupUtilities.BooleansToString(ivfm.getGekkanEvent())));
					}


				}

				TransformerFactory tfFactory = TransformerFactory.newInstance();
				Transformer tf = tfFactory.newTransformer();
				tf.setOutputProperty("encoding", "UTF-8");
				tf.setOutputProperty(OutputKeys.INDENT, "yes");
				tf.setOutputProperty(OutputKeys.METHOD, "xml");
				//TODO インデント

				tf.transform(new DOMSource(doc), new StreamResult(new File(xmlPath)));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void updateInputValuesForMonth(InputValuesForMonth ivfm,
			int[] walking, int[] suiminJikan, boolean[] suimin, boolean[] alcohol,
			boolean[] shokuseikatsu1,boolean[] shokuseikatsu2,boolean[] shokuseikatsu3,
			boolean[] shokuseikatsu4,boolean[] shokuseikatsu5,boolean[] gekkanEvent) {

		ivfm.setWalking(walking);
		ivfm.setSuiminJikan(suiminJikan);
		ivfm.setSuimin(suimin);
		ivfm.setAlcohol(alcohol);
		ivfm.setShokuseikatsu1(shokuseikatsu1);
		ivfm.setShokuseikatsu2(shokuseikatsu2);
		ivfm.setShokuseikatsu3(shokuseikatsu3);
		ivfm.setShokuseikatsu4(shokuseikatsu4);
		ivfm.setShokuseikatsu5(shokuseikatsu5);
		ivfm.setGekkanEvent(gekkanEvent);

	}

}
