package com.rtest.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternCompiler;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.PatternMatcherInput;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

public class RegxpUtil {
    private static final Logger LOGGER = Logger.getLogger(RegxpUtil.class);

    private PatternCompiler compiler = new Perl5Compiler();

    private PatternMatcher matcher = new Perl5Matcher();

    private Pattern pattern = null;

    public boolean isEquals(String source, String regxp) throws MalformedPatternException {
        if (source == null) {
            return false;
        }
        pattern = compiler.compile(regxp, Perl5Compiler.SINGLELINE_MASK);
        return matcher.matches(source, pattern);
    }

    public String extractRegText(String source, String regxp) throws MalformedPatternException {
        if (source == null) {
            return "";
        }
        pattern = compiler.compile(regxp, Perl5Compiler.SINGLELINE_MASK);
        if (matcher.contains(source, pattern)) {
            return matcher.getMatch().toString();
        }
        return "";
    }

    public List<String> extractRegxpContains(String src, String regxp) throws MalformedPatternException {
        List<String> results = new ArrayList<String>();
        Pattern pattern = compiler.compile(regxp, Perl5Compiler.SINGLELINE_MASK);
        PatternMatcherInput input = new PatternMatcherInput(src);
        while (matcher.contains(input, pattern)) {
            String string = matcher.getMatch().toString();
            results.add(string);
        }
        return results;
    }

    public List<String> splitRegxpGroups(String src, String regxp) throws MalformedPatternException {
        List<String> results = new ArrayList<String>();
        Pattern pattern = new Perl5Compiler().compile(regxp, Perl5Compiler.SINGLELINE_MASK);
        PatternMatcherInput matcherInput = new PatternMatcherInput(src);
        while (matcher.contains(matcherInput, pattern)) {
            for (int i = 0; i < matcher.getMatch().groups(); i++) {
                String info = matcher.getMatch().group(i);
                LOGGER.info(info);
                results.add(info);
            }
        }
        return results;
    }
}