package common;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class DNSQuery {
	public static void main(String[] args) throws NamingException{
		/*
		 * 绗竴涓弬鏁版寚瀹氳鏌ヨ鐨勫煙鎴栦富鏈哄悕锛岀浜屼釜鍙傛暟鎸囧畾鏌ヨ鐨凞NS鏈嶅姟鍣�, 涓轰簡绋嬪簭鐨勭畝鍗曟槗璇绘�э紝鐪佺暐浜嗕弗鏍肩殑鍙傛暟閿欒妫�鏌�
		 */
		String domain = args[0];
		String dnsServer = args.length < 2 ? "" : ("//" + args[1]);

		// 閫氳繃鐜灞炴�ф潵鎸囧畾Context鐨勫伐鍘傜被
		Hashtable env = new Hashtable();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.dns.DnsContextFactory");
		env.put(Context.PROVIDER_URL, "dns:" + dnsServer);
		DirContext ctx = new InitialDirContext(env);
		// 鍒嗗埆鑾峰彇鍖呭惈鎵�鏈夊睘鎬у拰鍙寘鍚玀x灞炴�х殑Attributes瀵硅薄
		Attributes attrsAll = ctx.getAttributes(domain);
		Attributes attrsMx = ctx.getAttributes(domain, new String[] { "MX" });

		/*
		 * 涓婇潰鐨勬暣娈电▼搴忎唬鐮佷篃鍙互鐢ㄤ笅闈㈣繖娈电▼搴忎唬鐮佹潵鏇夸唬锛屼笅闈㈣繖娈电▼搴� 浠ｇ爜閫氳繃鏌ヨURL涓殑Schema淇℃伅鏉ヨ嚜鍔ㄩ�夋嫨Context鐨勫伐鍘傜被
		 */
		/*
		 * DirContext ctx = new InitialDirContext(); Attributes attrsAll =
		 * ctx.getAttributes("dns:" + dnsServer + "/" + domain); Attributes attrsMx =
		 * ctx.getAttributes( "dns:" + dnsServer + "/" + domain, new String[]{"MX"});
		 */

		System.out.println("鎵撳嵃鍑哄煙" + domain + "鐨凙ttributes瀵硅薄涓殑淇℃伅锛�");
		System.out.println(attrsAll);
		System.out.println("--------------------------");
		System.out.println("鎵撳嵃鍙绱㈠煙" + domain + "鐨凪X璁板綍鐨凙ttributes瀵硅薄锛�");
		System.out.println(attrsMx);

		System.out.println("--------------------------");
		System.out.println("閫愪竴鎵撳嵃鍑篈ttributes瀵硅薄涓殑鍚勪釜灞炴�э細");
		NamingEnumeration attributes = attrsAll.getAll();
		while (attributes.hasMore()) {
			System.out.println(attributes.next());
		}

		System.out.println("--------------------------");
		// 鐩存帴璋冪敤get鏂规硶浠巃ttrsMx闆嗗悎妫�绱X灞炴��
		System.out.println("鐩存帴妫�绱ttributes瀵硅薄涓殑MX灞炴�э細");
		Attribute attrMx = attrsAll.get("MX");
		System.out.println(attrMx);

		System.out.println("--------------------------");
		// 鑾峰彇Mx灞炴�т腑鐨勭涓�涓��:
		System.out.println("鑾峰彇Mx灞炴�т腑鐨勭涓�涓��:");
		String recordMx = (String) attrMx.get();
		System.out.println(recordMx);
		// 浠嶮x灞炴�х殑绗竴涓�间腑鎻愬彇閭欢鏈嶅姟鍣ㄥ湴鍧�
		System.out.println("浠嶮X灞炴�у�间腑鎻愬彇鐨勯偖浠舵湇鍔″櫒鍦板潃锛�");
		String smtpServer = recordMx.substring(recordMx.indexOf(" ") + 1);
		System.out.println(smtpServer);
	}
}