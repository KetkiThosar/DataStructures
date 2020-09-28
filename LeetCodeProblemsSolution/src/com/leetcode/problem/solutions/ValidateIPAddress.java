package com.leetcode.problem.solutions;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.regex.Pattern;

public class ValidateIPAddress {

	//TRIVIA : split with limit argument
	
	/*The limit parameter controls the number of times the pattern is applied and therefore 
	 * affects the length of the resulting array. We have 3 possible values for this limit:

	    1. If the limit n is greater than zero then the pattern will be applied at most n - 1 times, the array's length will be no greater than n, 
	    and the array's last entry will contain all input beyond the last matched delimiter.

	    2. If n is non-positive then the pattern will be applied as many times as possible and the array can have any length.

	    3. If n is zero then the pattern will be applied as many times as possible, the array can have any length, 
	    and trailing empty strings will be discarded.

	*/ 
	/* Regular expression explanation Time complexity O(1) */
		String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
		/* explanation
		1.Chunk contains only one digit, from 0 to 9.

		2.Chunk contains two digits. The first one could be from 1 to 9, and the second one from 0 to 9.

		3.Chunk contains three digits, and the first one is 1. The second and the third ones could be from 0 to 9.

		4.Chunk contains three digits, the first one is 2 and the second one is from 0 to 4. Then the third one could be from 0 to 9.

		5.Chunk contains three digits, the first one is 2, and the second one is 5. Then the third one could be from 0 to 5. */
		
		Pattern patternIPv4 = Pattern.compile("^("+chunkIPv4+"\\.){3}"+chunkIPv4+"$");
		/* {3} - >  exactly 3 copies of regex should match
		^   - >  matches the beginning of string
		\\. -> matches dot character
		$   -> matches end of a string */
		
		String chunkIPv6 = "([0-9a-fA-F] {1,4})";
		
		Pattern pattenIPv6 = Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");
		
	 
	public String validIPAddressUsingInBuilt(String IP) {
		try {
			return (InetAddress.getByName(IP) instanceof Inet6Address) ? "IPv6" : "IPv4";
		} catch (Exception e) {
			return "Neither";
		}
	}

	public String validIPAddressWithRegex(String IP) {
		 if (patternIPv4.matcher(IP).matches()) return "IPv4";
		    return (pattenIPv6.matcher(IP).matches()) ? "IPv6" : "Neither";
		  }
	
	
	
	public String validIPAddress(String IP) {
		String neither = "Neither";
		if (IP.contains(".")) {
			if(isIP4(IP)) {return "IP4";}
		} else if (IP.contains(":")) {
			if(isIP6(IP)){return "IP6";}
		}
		return neither;

	}

	public boolean isIP4(String IP) {
		String[] nums = IP.split("\\.",-1);
		if (nums.length != 4) {
			return false;
		}
		for (String str : nums) {
			if (str.length() == 0 || str.length() > 3) {
				return false;
			}
			if (str.charAt(0) == '0' && str.length() != 1) {
				return false;
			}
			for (char ch : str.toCharArray()) {
				if (!Character.isDigit(ch)) {
					return false;
				}
			}
			if (Integer.parseInt(str) > 255) {
				return false;
			}

		} // end of for loop
		return true;
	}

	public boolean isIP6(String IP) {
		String hexDigits = "0123456789abcdefABCDEF";
		String[] nums = IP.split(":",-1);
		if (nums.length != 8) {
			return false;
		}
		for (String str : nums) {
			if (str.length() == 0 || str.length() > 4) {
				return false;
			}
			for (char ch : str.toCharArray()) {
				if (hexDigits.indexOf(ch) == -1) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String IP = "192.0.0.1";
		long timeout = 1*60*1000;
		long first = System.currentTimeMillis();
		System.out.println(first);
		System.out.println((System.currentTimeMillis()>=first+timeout)?"now ":"not yet");
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println((System.currentTimeMillis()>=first+timeout)?"now":"not yet");
		System.out.println(System.currentTimeMillis()+timeout);
	}

}
