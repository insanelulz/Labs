package org.atkachenko.learnjava;

/**
 * Created by atkachenko on 24.03.2017.
 */
public class StringHelper {
    static boolean isMultiline = false;
    static int commentType = 0;

    static int commentStart(String string) {
        boolean isComment = false;
        for (int i = 0; i < string.length(); i++) {
            if (isComment && string.charAt(i) == '*') {
                isMultiline = true;
                return i-1;
            }
            if ( isComment && string.charAt(i) == '/') {
                return i-1;
            }
            if ( string.charAt(i) == '/') {
                isComment = true;
            } else {
                isComment = false;
            }
        }
        return -1;
    }

    static int commentEnd(String string) {
        boolean isComment = false;

        for (int i = 0; i < string.length(); i++) {
            if ( isComment && string.charAt(i) == '/') {
                isMultiline = false;
                return i-1;
            }
            if ( string.charAt(i) == '*') {
                isComment = true;
            } else {
                isComment = false;
            }
        }
        return -1;
    }

    static String trimComments(String string) {
        int commentEnd;
        int commentStart;
        if (isMultiline) {
            commentEnd = commentEnd(string);
            if (isMultiline) {
                return "";
            } else {
                return trimComments(string.substring(commentEnd+2,string.length()));
            }
        }
        commentStart = commentStart(string);
        if (isMultiline) {
            commentEnd = commentEnd(string);
            if (!isMultiline) {
                return string.substring(0,commentStart) + trimComments(string.substring(commentEnd+2, string.length()));
            } else {
                return string.substring(0,commentStart);
            }
        } else if (commentStart == -1) {
            return string;
        } else {
            return string.substring(0,commentStart);
        }
    }

}
