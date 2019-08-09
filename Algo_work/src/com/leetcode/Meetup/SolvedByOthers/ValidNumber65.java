package com.leetcode.Meetup.SolvedByOthers;
/**
 * https://leetcode.com/problems/valid-number/
 * 
 * 65. Valid Number
Hard

357

2726

Favorite

Share
Validate if a given string can be interpreted as a decimal number.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
" -90e3   " => true
" 1e" => false
"e3" => false
" 6e-1" => true
" 99e2.5 " => false
"53.5e93" => true
" --6 " => false
"-+3" => false
"95a54e53" => false

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one. However, here is a list of characters that can be in a valid decimal number:

Numbers 0-9
Exponent - "e"
Positive/negative sign - "+"/"-"
Decimal point - "."
Of course, the context of these characters also matters in the input.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button to reset your code definition.
 * 
 * @author rajat
 *
 */
public class ValidNumber65 {
/*Code is in phython . need to impelment in java
 * 
 * def isNumber(self, s: str) -> bool:
        def isInteger(s):
            if len(s) < 1: return False
            if s[0] in {'+', '-'}:
                s = s[1:]
            return str.isnumeric(s)
       
        def isStrictPositiveInteger(s):
            return isInteger(s) and s[0] not in ['-', '+']
       
        def isDecimal(s):
            if '.' in s:
                parts = s.split('.')
                return len(s) > 1 and len(parts) == 2 and (parts[0] in {'', '+', '-'} or isInteger(parts[0])) and (parts[1] == '' or isStrictPositiveInteger(parts[1]))
            else:
                return isInteger(s)
           
        s = s.strip()
        if not any([ str.isnumeric(ch) for ch in s]): return False
        if isInteger(s):
            return True
       
        if 'e' in s:
            parts = s.split('e')
            return len(parts) == 2 and isDecimal(parts[0]) and isInteger(parts[1])
       
        if '.' in s:
            return isDecimal(s)
        return False
 * 
 * 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
